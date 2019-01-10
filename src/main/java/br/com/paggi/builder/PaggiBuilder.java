package br.com.paggi.builder;

import br.com.paggi.client.PaggiClient;
import br.com.paggi.enums.PaggiEnvironment;
import br.com.paggi.model.PaggiCredentials;

public interface PaggiBuilder {

    void setEnvironemnt(PaggiEnvironment environment);
    void setCredentials(PaggiCredentials credentials);

    PaggiBuilder withEnvironment(PaggiEnvironment environment);
    PaggiBuilder withCredentials(PaggiCredentials credentials);
    PaggiClient build();
}
