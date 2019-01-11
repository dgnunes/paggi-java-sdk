package br.com.paggi.model.requests;

import java.util.Map;

public class PaggiFindPlanRequest extends PaggiRequest{
    private final String PATH = "partners/{partner_id}/plans/{plan_id}";
    private final String METHOD = "GET";

    public PaggiFindPlanRequest(){
        super();
    }

    public PaggiFindPlanRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiFindPlanRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    public PaggiFindPlanRequest withPlanId(String id){
        getPathParameters().put("plan_id", id);
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
