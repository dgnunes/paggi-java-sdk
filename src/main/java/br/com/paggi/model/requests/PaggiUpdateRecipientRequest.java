package br.com.paggi.model.requests;

import br.com.paggi.model.bean.PaggiBankAccount;

import java.util.Map;

public class PaggiUpdateRecipientRequest extends PaggiRequest{

    private final String PATH = "partners/{partner_id}/recipients/{recipient_id}";
    private final String METHOD = "PUT";

    public PaggiUpdateRecipientRequest(){
        super();
    }

    public PaggiUpdateRecipientRequest(Map<String, Object> data) {
        super(data);
    }

    public PaggiUpdateRecipientRequest(Map<String, String> pathParameters, Map<String, Object> data) {
        super(pathParameters, data);
    }

    //Fluent
    public PaggiUpdateRecipientRequest withRecipientId(String recipientId){
        getPathParameters().put("recipient_id", recipientId);
        return this;
    }

    public PaggiUpdateRecipientRequest withBank_Account(PaggiBankAccount bankAccount){
        getBody().put("bank_account", bankAccount);
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
