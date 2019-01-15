package br.com.paggi.enums;

public enum PaggiEnvironment {
    PRODUCTION("https://api.paggi.com"),
    STAGING("https://api.stg.paggi.com");

    private String url;

    PaggiEnvironment (String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }
}
