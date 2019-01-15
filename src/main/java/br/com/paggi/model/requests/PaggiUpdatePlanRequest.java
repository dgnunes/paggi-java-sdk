package br.com.paggi.model.requests;

import br.com.paggi.model.bean.PaggiPlan;

import java.util.Map;

public class PaggiUpdatePlanRequest extends PaggiRequest{
    private final String PATH = "partners/{partner_id}/plans/{plan_id}";
    private final String METHOD = "PUT";

    public PaggiUpdatePlanRequest(){
        super();
    }

    public PaggiUpdatePlanRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiUpdatePlanRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    public PaggiUpdatePlanRequest withPlanId(String id) {
        getPathParameters().put("plan_id",id);
        return this;
    }

    public PaggiUpdatePlanRequest withPlan(PaggiPlan plan) {
        if (plan.getName() != null)
            getBody().put("name",plan.getName());

        if (plan.getPrice() != null)
            getBody().put("price",plan.getPrice());

        if (plan.getInterval() != null)
            getBody().put("interval",plan.getInterval());

        if (plan.getTrial_period() != null)
            getBody().put("trial_period",plan.getTrial_period());

        if (plan.getExternal_identifier() != null)
            getBody().put("external_identifier",plan.getExternal_identifier());

        if (plan.getDescription() != null)
            getBody().put("description",plan.getDescription());

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
