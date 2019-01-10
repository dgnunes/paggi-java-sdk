package br.com.paggi.builder;

import br.com.paggi.client.PaggiClient;
import br.com.paggi.client.PaggiSyncClient;

public class PaggiSyncClientBuilder extends PaggiAbstractBuilder{

    public static PaggiSyncClientBuilder standard(){
        return new PaggiSyncClientBuilder();
    }

    @Override
    public PaggiClient build() {
        return new PaggiSyncClient(credentials);
    }

}
