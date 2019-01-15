package br.com.paggi.model.requests;

import java.util.HashMap;
import java.util.Map;

public abstract class PaggiRequest {
    private Map<String, String> pathParameters = new HashMap<>();
    private Map<String,Object> body = new HashMap<>();
    PaggiRequest(){

    }

    PaggiRequest (Map<String, Object> data){
        this.body.putAll(data);
    }

    PaggiRequest (Map<String, String> pathParameters, Map<String, Object> data){
        this.body.putAll(data);
        this.pathParameters.putAll(pathParameters);
    }

    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    public void setPathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public abstract String getPATH();
    public abstract String getMETHOD();
}
