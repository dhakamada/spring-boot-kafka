package br.com.dhakamada.kafka;

import java.util.HashMap;
import java.util.Map;

import br.com.dhakamada.kafka.scripts.FinancialMovementOperationScript;
import br.com.dhakamada.kafka.scripts.operation.OperationTest;
import br.com.dhakamada.kafka.scripts.operation.OperationTest1;

/**
 * @author dhakamada
 * @version $Revision: $<br/>
 * $Id: $
 * @since 1/16/18 9:50 AM
 */
public class MapTest {

    public static final Map<String, Class<? extends FinancialMovementRequestInterface>> mapV1 = new HashMap<>();

    public static final Map<String, FinancialMovementRequestInterface> mapV2 = new HashMap<String, FinancialMovementRequestInterface>();

    public static final Map<String, Class<? extends FinancialMovementOperationScript>> map = new HashMap<>();

    static {
        mapV1.put("test", FinancialMovementRequestTest.class);
        mapV1.put("test1", FinancialMovementRequestTest1.class);

        mapV2.put("map", new FinancialMovementRequestTest());
        mapV2.put("map1", new FinancialMovementRequestTest1());

        map.put("operation", OperationTest.class);
        map.put("oepration1", OperationTest1.class);
    }


    public static void main(String []args) throws IllegalAccessException, InstantiationException {
        final Class<? extends FinancialMovementRequestInterface> clazz = mapV1.get("test");
        final FinancialMovementRequestInterface financialMovementRequestInterface = clazz.newInstance();
        financialMovementRequestInterface.print();


        final Class<? extends FinancialMovementRequestInterface> clazz1 = mapV1.get("test1");
        final FinancialMovementRequestInterface financialMovementRequestInterface1 = clazz1.newInstance();
        financialMovementRequestInterface1.print();

    }
}
