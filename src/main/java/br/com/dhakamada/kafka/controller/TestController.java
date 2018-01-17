package br.com.dhakamada.kafka.controller;

import br.com.dhakamada.kafka.MapTest;
import br.com.dhakamada.kafka.scripts.FinancialMovementOperationScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dhakamada
 * @version $Revision: $<br/>
 * $Id: $
 * @since 1/16/18 10:26 AM
 */
@RestController
@RequestMapping("tests")
public class TestController {

    @Autowired
    private ApplicationContext context;

    @GetMapping
    public String test(@RequestParam(value = "op") String operationName) {
        final Class<? extends FinancialMovementOperationScript> clazz = MapTest.map.get(operationName);

        final FinancialMovementOperationScript bean = context.getBean(clazz);
        return bean.execute();
    }

}
