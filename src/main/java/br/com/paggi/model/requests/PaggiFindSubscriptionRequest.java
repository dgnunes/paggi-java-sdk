package br.com.paggi.model.requests;

import java.util.Map;

public class PaggiFindSubscriptionRequest extends PaggiRequest{
    private final String PATH = "partners/{partner_id}/subscriptions/{subscription_id}";
    private final String METHOD = "GET";


    public PaggiFindSubscriptionRequest(){
        super();
    }

    public PaggiFindSubscriptionRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiFindSubscriptionRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    public PaggiFindSubscriptionRequest withSubscriptionId(String subscriptionId){
        getPathParameters().put("subscription_id", subscriptionId);
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
