package br.com.paggi.model.bean;

public class PaggiAdditional {
    private int period;
    private int amount;
    private String description;

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    //Fluent

    public PaggiAdditional withPeriod(int period) {
        this.period = period;
        return this;
    }

    public PaggiAdditional withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public PaggiAdditional withDescription(String description) {
        this.description = description;
        return this;
    }
}
