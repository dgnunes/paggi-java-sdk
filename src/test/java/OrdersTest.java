import br.com.paggi.builder.PaggiSyncClientBuilder;
import br.com.paggi.client.PaggiClient;
import br.com.paggi.enums.PaggiEnvironment;
import br.com.paggi.model.PaggiCredentials;
import br.com.paggi.model.requests.PaggiCreateOrderRequest;
import br.com.paggi.model.responses.PaggiCreateOrderResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OrdersTest {

    @Test
    public void createOrderSuccessfulTest(){
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withPartnerId(TestCredentials.PARTNERID)
                        .withToken(TestCredentials.TOKEN))
                .build();

        Map<String,String> body = new HashMap<String,String>();
        body.put("","");


        //PaggiCreateOrderRequest request = new PaggiCreateOrderRequest(body);

        //PaggiCreateOrderResponse response = client.createOrder(request);





        Assert.assertTrue(false);
    }

}
