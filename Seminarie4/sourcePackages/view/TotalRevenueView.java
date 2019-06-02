package view;

import model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
    private double totalRevenue = 0;

    /**
     * This is an ampty constructor that starts with the value 0
     */
    public TotalRevenueView() {
        this.totalRevenue = 0;
    }

    /**
     * Increases the total revenue.
     * @param paidAmount - paid amount.
     */
    public void newPayment (double paidAmount){
        totalRevenue = totalRevenue + paidAmount;
        showOnDisplay();
    }

    /**
     * Prints the total revenue.
     */
    
    private void showOnDisplay() {

        System.out.println("Totalt betalt belopp från alla sales: " + Math.round(totalRevenue));

    }

    /**
     * is used to check if the class works as intended.
     * @return totalRevenue - to check if class works properly.
     */

    public double getTotalRevenue(){
        return totalRevenue;
    }


}