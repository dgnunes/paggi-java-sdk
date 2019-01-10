package br.com.paggi.builder;

import br.com.paggi.client.PaggiClient;
import br.com.paggi.enums.PaggiEnvironment;
import br.com.paggi.auth.PaggiCredentials;

public interface PaggiBuilder {

    void setEnvironemnt(PaggiEnvironment environment);
    void setCredentials(PaggiCredentials credentials) throws Exception;

    PaggiBuilder withEnvironment(PaggiEnvironment environment);
    PaggiBuilder withCredentials(PaggiCredentials credentials) throws Exception;
    PaggiClient build();
}
