package br.com.paggi.model.bean;

public class PaggiCustomer {
    private String name;
    private String document;
    private String email;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Fluent
    public PaggiCustomer withName(String name) {
        this.name = name;
        return this;
    }

    public PaggiCustomer withDocument(String document) {
        this.document = document;
        return this;
    }

    public PaggiCustomer withEmail(String email) {
        this.email = email;
        return this;
    }
}
