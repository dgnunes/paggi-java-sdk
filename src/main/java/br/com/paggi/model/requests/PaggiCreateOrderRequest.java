package br.com.paggi.model.requests;

import br.com.paggi.model.bean.PaggiCharge;
import br.com.paggi.model.bean.PaggiCustomer;
import br.com.paggi.model.bean.PaggiRecipient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaggiCreateOrderRequest extends PaggiRequest{

    private final String PATH = "partners/{partner_id}/orders";
    private final String METHOD = "POST";

    public PaggiCreateOrderRequest(){
        super();
    }

    public PaggiCreateOrderRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiCreateOrderRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    @Override
    public String getPATH() {
        return this.PATH;
    }

    @Override
    public String getMETHOD() {
        return this.METHOD;
    }

    //Fluent
    public PaggiCreateOrderRequest withCapture(boolean capture){
        getBody().put("capture", capture);
        return this;
    }

    public PaggiCreateOrderRequest withIp(String ip){
        getBody().put("ip", ip);
        return this;
    }

    public PaggiCreateOrderRequest withCharges(List<PaggiCharge> l){
        getBody().put("charges", l);
        return this;
    }

    public PaggiCreateOrderRequest withRecipients(List<PaggiRecipient> l){
        getBody().put("recipients", l);
        return this;
    }

    public PaggiCreateOrderRequest withCustomer(PaggiCustomer c){
        getBody().put("customer", c);
        return this;
    }

    public PaggiCreateOrderRequest withExternalIdentifier(String s){
        getBody().put("external_identifier", s);
        return this;
    }


}
