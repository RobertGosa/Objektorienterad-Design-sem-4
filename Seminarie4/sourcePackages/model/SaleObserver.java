package model;

/**
 * A listener an interface for sales object that handle payments.
 * @author Robert Gosa
 */
public interface SaleObserver {
    /**
     * Called when payment occurs.
     * @param sale The sale that was paid for.
     */
    void newPayment (double amount);
    
}