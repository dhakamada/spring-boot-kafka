package br.com.dhakamada.kafka;

/**
 * @author dhakamada
 * @version $Revision: $<br/>
 * $Id: $
 * @since 1/16/18 9:54 AM
 */
public interface FinancialMovementRequestInterface {

    Class<? extends FinancialMovementRequestInterface> getInterface();

    void print();

}
