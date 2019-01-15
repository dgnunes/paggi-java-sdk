package br.com.paggi.model.bean;

public class PaggiRecipient {
    private String name;
    private String document;
    private PaggiBankAccount bank_account;
    private int percentage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public PaggiBankAccount getBank_account() {
        return bank_account;
    }

    public void setBank_account(PaggiBankAccount bank_account) {
        this.bank_account = bank_account;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    //Fluent
    public PaggiRecipient withName(String name) {
        this.name = name;
        return this;
    }

    public PaggiRecipient withDocument(String document) {
        this.document = document;
        return this;
    }

    public PaggiRecipient withBank_account(PaggiBankAccount bank_account) {
        this.bank_account = bank_account;
        return this;
    }

    public PaggiRecipient withPercentage(int percentage) {
        this.percentage = percentage;
        return this;
    }
}
