package br.com.paggi.model.requests;

import br.com.paggi.model.bean.PaggiAdditional;
import br.com.paggi.model.bean.PaggiDiscount;

import java.util.List;
import java.util.Map;

public class PaggiUpdateSubscriptionRequest extends PaggiRequest{
    private final String PATH = "partners/{partner_id}/subscriptions/{subscription_id}";
    private final String METHOD = "PUT";

    public PaggiUpdateSubscriptionRequest(){
        super();
    }

    public PaggiUpdateSubscriptionRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiUpdateSubscriptionRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    public PaggiUpdateSubscriptionRequest withSubscriptionId(String subscriptionId){
        getPathParameters().put("subscription_id", subscriptionId);
        return this;
    }

    public PaggiUpdateSubscriptionRequest withPaggiDiscounts(List<PaggiDiscount> listDiscount) {
        getBody().put("discount", listDiscount);
        return this;
    }

    public PaggiUpdateSubscriptionRequest withPaggiAdditionals(List<PaggiAdditional> listAdditional) {
        getBody().put("additional", listAdditional);
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
