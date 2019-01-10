package br.com.paggi.builder;

import br.com.paggi.auth.PaggiCredentialsValidator;
import br.com.paggi.enums.PaggiEnvironment;
import br.com.paggi.auth.PaggiCredentials;

abstract class PaggiAbstractBuilder implements PaggiBuilder {
    PaggiEnvironment environment = PaggiEnvironment.PRODUCTION;
    PaggiCredentials credentials = new PaggiCredentials();

    @Override
    public void setEnvironemnt(PaggiEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void setCredentials(PaggiCredentials credentials) throws Exception {
        if(!PaggiCredentialsValidator.withCredentials(credentials).isValid()){
            throw new Exception ("Invalid Token");
        }

        this.credentials = credentials;
    }

    @Override
    public PaggiBuilder withEnvironment(PaggiEnvironment environment) {
        this.environment = environment;
        return this;
    }

    @Override
    public PaggiBuilder withCredentials(PaggiCredentials credentials) throws Exception {
        this.setCredentials(credentials);
        return this;
    }

}
