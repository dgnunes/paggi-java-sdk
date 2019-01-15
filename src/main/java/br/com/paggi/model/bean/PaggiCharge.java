package br.com.paggi.model.bean;

public class PaggiCharge {
    private int amount;
    private int installments;
    private PaggiCard card;

    public int getAmount() {
        return amount;
    }

    public int getInstallments() {
        return installments;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public void setCard(PaggiCard card) {
        this.card = card;
    }

    public PaggiCard getCard() {
        return card;
    }

    public PaggiCharge withCard(PaggiCard card) {
        this.card = card;
        return this;
    }

    public PaggiCharge withInstallments(int installments) {
        this.installments = installments;
        return this;
    }

    public PaggiCharge withAmount(int amount) {
        this.amount = amount;
        return this;
    }

}
