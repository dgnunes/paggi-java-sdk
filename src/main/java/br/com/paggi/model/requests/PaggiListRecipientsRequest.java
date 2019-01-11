package br.com.paggi.model.requests;

import java.util.Map;

public class PaggiListRecipientsRequest extends PaggiRequest{

    private final String PATH = "partners/{partner_id}/recipients";
    private final String METHOD = "GET";

    public PaggiListRecipientsRequest(){
        super();
    }

    public PaggiListRecipientsRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiListRecipientsRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
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
