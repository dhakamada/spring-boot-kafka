package br.com.dhakamada.kafka.scripts.operation;

import br.com.dhakamada.kafka.scripts.FinancialMovementOperationScript;
import org.springframework.stereotype.Component;

/**
 * @author dhakamada
 * @version $Revision: $<br/>
 * $Id: $
 * @since 1/16/18 10:40 AM
 */
@Component
public class OperationTest1 implements FinancialMovementOperationScript {

    @Override
    public String execute() {
        return "OperationTest1";
    }
}