package br.com.paggi.model.requests;

import br.com.paggi.model.bean.PaggiAdditional;
import br.com.paggi.model.bean.PaggiCard;
import br.com.paggi.model.bean.PaggiCustomer;
import br.com.paggi.model.bean.PaggiDiscount;

import java.util.List;
import java.util.Map;

public class PaggiCreateSubscriptionRequest extends PaggiRequest{
    private final String PATH = "partners/{partner_id}/subscriptions";
    private final String METHOD = "POST";

    public PaggiCreateSubscriptionRequest(){
        super();
    }

    public PaggiCreateSubscriptionRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiCreateSubscriptionRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    public PaggiCreateSubscriptionRequest withExternal_Identifier(String external_identifier) {
        getBody().put("external_identifier",external_identifier);
        return this;
    }

    public PaggiCreateSubscriptionRequest withPlanId(String plan_id) {
        getBody().put("plan_id",plan_id);
        return this;
    }

    public PaggiCreateSubscriptionRequest withIp(String ip){
        getBody().put("ip",ip);
        return this;
    }

    public PaggiCreateSubscriptionRequest withPaggiCustomer(PaggiCustomer customer) {
        getBody().put("customer", customer);
        return this;
    }

    public PaggiCreateSubscriptionRequest withPaggiCard(PaggiCard card) {
        getBody().put("card", card);
        return this;
    }

    public PaggiCreateSubscriptionRequest withPaggiDiscounts(List<PaggiDiscount> listDiscount) {
        getBody().put("discount", listDiscount);
        return this;
    }

    public PaggiCreateSubscriptionRequest withPaggiAdditionals(List<PaggiAdditional> listAdditional) {
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
