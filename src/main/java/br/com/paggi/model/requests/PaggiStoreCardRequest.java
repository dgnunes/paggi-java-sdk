package br.com.paggi.model.requests;

import br.com.paggi.model.bean.PaggiCard;

import java.util.Map;

public class PaggiStoreCardRequest extends PaggiRequest{

    private final String PATH = "partners/{partner_id}/cards";
    private final String METHOD = "POST";

    public PaggiStoreCardRequest(){
        super();
    }

    public PaggiStoreCardRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiStoreCardRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    //Fluent
    public PaggiStoreCardRequest withCard(PaggiCard card){
        getBody().put("holder",card.getHolder());
        getBody().put("document",card.getDocument());
        getBody().put("number", card.getNumber());
        getBody().put("month", card.getMonth());
        getBody().put("year", card.getYear());
        getBody().put("cvc", card.getCvc());
        return this;
    }

    @Override
    public String getPATH() {
        return PATH;
    }

    @Override
    public String getMETHOD() {
        return METHOD;
    }
}
