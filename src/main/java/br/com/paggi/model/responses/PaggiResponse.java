package br.com.paggi.model.responses;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public abstract class PaggiResponse {
    private String body;
    private int httpReturnCode;
    private String message;
    private String calledPath;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getHttpReturnCode() {
        return httpReturnCode;
    }

    public void setHttpReturnCode(int httpReturnCode) {
        this.httpReturnCode = httpReturnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCalledPath() {
        return calledPath;
    }

    public void setCalledPath(String calledPath) {
        this.calledPath = calledPath;
    }

    public Map<String, Object> getBodyAsMap(){
        Type mapType = new TypeToken<Map<String, Object>>(){}.getType();

        Map<String, Object> son = new Gson().fromJson(body, mapType);

        return son;
    }
}
