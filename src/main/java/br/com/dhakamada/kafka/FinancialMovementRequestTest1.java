package br.com.dhakamada.kafka;

/**
 * @author dhakamada
 * @version $Revision: $<br/>
 * $Id: $
 * @since 1/16/18 9:56 AM
 */
public class FinancialMovementRequestTest1 implements FinancialMovementRequestInterface {

    @Override
    public Class<? extends FinancialMovementRequestInterface> getInterface() {
        return FinancialMovementRequestTest1.class;
    }

    @Override
    public void print() {
        System.out.println("test1");
    }
}
