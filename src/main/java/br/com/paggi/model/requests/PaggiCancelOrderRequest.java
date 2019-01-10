package br.com.paggi.model.requests;

import java.util.Map;

public class PaggiCancelOrderRequest extends PaggiRequest{

    private final String PATH = "partners/{partner_id}/orders/{order_id}/void";
    private final String METHOD = "POST";

    public PaggiCancelOrderRequest(){
        super();
    }

    public PaggiCancelOrderRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiCancelOrderRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    //Fluent
    public PaggiCancelOrderRequest withOrderId(String orderId){
        getPathParameters().put("order_id",orderId);
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
