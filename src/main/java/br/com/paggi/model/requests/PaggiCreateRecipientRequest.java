package br.com.paggi.model.requests;

import br.com.paggi.model.bean.PaggiRecipient;

public class PaggiCreateRecipientRequest extends PaggiRequest{
    private final String PATH = "partners/{partner_id}/recipients";
    private final String METHOD = "POST";

    public PaggiCreateRecipientRequest withRecipient(PaggiRecipient recipient) {
        getBody().put("name",  recipient.getName());
        getBody().put("document",recipient.getDocument());
        getBody().put("bank_account",recipient.getBank_account());
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
