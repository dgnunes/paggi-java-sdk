package br.com.paggi.auth;

public class PaggiCredentials {
    private String partnerId;
    private String token;

    public PaggiCredentials (){
        this.token = System.getenv("TOKEN");
        this.partnerId = System.getenv("PARTNERID");
    }

    public PaggiCredentials (String partnerId, String token){
        this.token = token;
        this.partnerId = partnerId;
    }

    public PaggiCredentials withPartnerId(String partnerId){
        this.partnerId = partnerId;
        return this;
    }

    public PaggiCredentials withToken(String token){
        this.token = token;
        return this;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
