package br.com.paggi.model.requests;

import br.com.paggi.model.bean.PaggiPlan;

import java.util.Map;

public class PaggiCreatePlanRequest extends PaggiRequest{
    private final String PATH = "partners/{partner_id}/plans";
    private final String METHOD = "POST";

    public PaggiCreatePlanRequest(){
        super();
    }

    public PaggiCreatePlanRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiCreatePlanRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    public PaggiCreatePlanRequest withPlan(PaggiPlan plan){
        getBody().put("name",plan.getName());
        getBody().put("price",plan.getPrice());
        getBody().put("interval",plan.getInterval());
        getBody().put("trial_period",plan.getTrial_period());
        getBody().put("external_identifier",plan.getExternal_identifier());
        getBody().put("description",plan.getName());

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
