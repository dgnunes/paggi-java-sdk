package br.com.paggi.model.requests;

import java.util.Map;

public class PaggiRemoveCardRequest extends PaggiRequest{

    private final String PATH = "partners/{partner_id}/cards/{card_id}";
    private final String METHOD = "DELETE";

    public PaggiRemoveCardRequest(){
        super();
    }

    public PaggiRemoveCardRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiRemoveCardRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    //Fluent
    public PaggiRemoveCardRequest withCardId(String cardId) {
        getPathParameters().put("card_id", cardId);
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
