package br.com.paggi.model.requests;

import java.util.Map;

public class PaggiRemovePlanRequest extends PaggiRequest{
    private final String PATH = "partners/{partner_id}/plans/{plan_id}";
    private final String METHOD = "DELETE";

    public PaggiRemovePlanRequest(){
        super();
    }

    public PaggiRemovePlanRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiRemovePlanRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    public PaggiRemovePlanRequest withPlanId(String id) {
        getPathParameters().put("plan_id",id);
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
