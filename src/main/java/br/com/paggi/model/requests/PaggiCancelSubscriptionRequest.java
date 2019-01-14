package br.com.paggi.model.requests;

import java.util.Map;

public class PaggiCancelSubscriptionRequest extends PaggiRequest{
    private final String PATH = "partners/{partner_id}/subscriptions/{subscription_id}/void";
    private final String METHOD = "PUT";


    public PaggiCancelSubscriptionRequest(){
        super();
    }

    public PaggiCancelSubscriptionRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiCancelSubscriptionRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    public PaggiCancelSubscriptionRequest withSubscriptionId(String subscriptionId){
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
