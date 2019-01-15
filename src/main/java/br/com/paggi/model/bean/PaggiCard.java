package br.com.paggi.model.bean;

public class PaggiCard {
    private String number;
    private String cvc;
    private String holder;
    private String year;
    private String month;
    private String document;
    private String id;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //Fluent
    public PaggiCard withId(String id){
        this.id = id;
        return this;
    }

    public PaggiCard withNumber(String number){
        this.number = number;
        return this;
    }

    public PaggiCard withCvc(String cvc){
        this.cvc = cvc;
        return this;
    }


    public PaggiCard withHolder(String holder){
        this.holder = holder;
        return this;
    }


    public PaggiCard withYear(String year){
        this.year = year;
        return this;
    }

    public PaggiCard withMonth(String month){
        this.month = month;
        return this;
    }

    public PaggiCard withDocument(String document){
        this.document = document;
        return this;
    }

}
