
package proj1ComSys;

import java.time.Instant;
import java.util.Date;


public class Invoice {

    private double usageLimit;

    private double currentSpending;

    private Date lastDayToPay;

    private final static long month = 2592000000l; //for pay method

    //For exit option
    private double totalSpending;

    public Invoice(double usageLimit) {
        this.usageLimit = usageLimit;
        this.currentSpending = 0;
        this.lastDayToPay = new Date(System.currentTimeMillis() + month);
        this.totalSpending = 0;
    }


    public boolean isLimitExceeded(double amount) {
        return currentSpending + amount > usageLimit;
    }


    public void addCost(double amount) {
        this.currentSpending += amount;
        this.totalSpending += amount;
    }


    public void pay(double amount) {
        if (amount == currentSpending) {
            lastDayToPay = new Date(Instant.now().toEpochMilli() + month);
        }
        currentSpending -= amount;
    }



    public void changeUsageLimit(double amount) {
        usageLimit = amount;
    }


    public double getUsageLimit() {
        return usageLimit;
    }

    public double getCurrentSpending() {
        return currentSpending;
    }

    public void setCurrentSpending(double currentSpending) {
        this.currentSpending = currentSpending;
    }

    public Date getLastDayToPay() {
        return lastDayToPay;
    }

    public void setLastDayToPay(Date lastDayToPay) {
        this.lastDayToPay = lastDayToPay;
    }

    //For exit option
    public double getTotalSpending() {
        return totalSpending;
    }

}
