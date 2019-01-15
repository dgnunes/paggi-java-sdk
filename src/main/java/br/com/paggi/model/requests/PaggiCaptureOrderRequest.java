package br.com.paggi.model.requests;

import java.util.Map;

public class PaggiCaptureOrderRequest extends PaggiRequest{

    private final String PATH = "partners/{partner_id}/orders/{order_id}/capture";
    private final String METHOD = "PUT";

    public PaggiCaptureOrderRequest(){
        super();
    }

    public PaggiCaptureOrderRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiCaptureOrderRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    //Fluent
    public PaggiCaptureOrderRequest withOrderId(String orderId){
        getPathParameters().put("order_id",orderId);
        return this;
    }

    @Override
    public String getPATH() {
        return this.PATH;
    }

    @Override
    public String getMETHOD() {
        return this.METHOD;
    }

}
