package br.com.paggi.model.bean;

public class PaggiBankAccount {
    private String bank_code;
    private String account_number;
    private String account_digit;
    private String branch_number;
    private String branch_digit;


    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getAccount_digit() {
        return account_digit;
    }

    public void setAccount_digit(String account_digit) {
        this.account_digit = account_digit;
    }

    public String getBranch_number() {
        return branch_number;
    }

    public void setBranch_number(String branch_number) {
        this.branch_number = branch_number;
    }

    public String getBranch_digit() {
        return branch_digit;
    }

    public void setBranch_digit(String branch_digit) {
        this.branch_digit = branch_digit;
    }

    //Fluent
    public PaggiBankAccount withBank_code(String bank_code) {
        this.bank_code = bank_code;
        return this;
    }

    public PaggiBankAccount withAccount_number(String account_number) {
        this.account_number = account_number;
        return this;
    }

    public PaggiBankAccount withAccount_digit(String account_digit) {
        this.account_digit = account_digit;
        return this;
    }

    public PaggiBankAccount withBranch_number(String branch_number) {
        this.branch_number = branch_number;
        return this;
    }

    public PaggiBankAccount withBranch_digit(String branch_digit) {
        this.branch_digit = branch_digit;
        return this;
    }
}
