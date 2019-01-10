import br.com.paggi.auth.PaggiCredentials;
import br.com.paggi.builder.PaggiSyncClientBuilder;
import br.com.paggi.client.PaggiClient;
import br.com.paggi.enums.PaggiEnvironment;
import br.com.paggi.model.bean.PaggiCard;
import br.com.paggi.model.requests.PaggiRemoveCardRequest;
import br.com.paggi.model.requests.PaggiStoreCardRequest;
import br.com.paggi.model.responses.PaggiRemoveCardResponse;
import br.com.paggi.model.responses.PaggiStoreCardResponse;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;
import java.util.Map;

public class CardsTest {


    @Test
    public void storeCardTestUglified() throws Exception {
            PaggiClient client = PaggiSyncClientBuilder.standard()
                    .withEnvironment(PaggiEnvironment.STAGING)
                    .withCredentials(new PaggiCredentials()
                            .withToken(TestCredentials.TOKEN))
                    .build();

        PaggiStoreCardRequest request = new PaggiStoreCardRequest();
        PaggiStoreCardResponse response = client.storeCard(request);

        Assert.assertTrue(false);
    }

    @Test
    public void storeCardTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        PaggiCard card = new PaggiCard()
                .withNumber("5573710095684403")
                .withCvc(String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()))
                .withHolder(faker.name().fullName())
                .withDocument(faker.idNumber().ssnValid())
                .withYear("2050")
                .withMonth("04");

        PaggiStoreCardRequest request = new PaggiStoreCardRequest().withCard(card);
        PaggiStoreCardResponse response = client.storeCard(request);

        System.out.println("storeCardTest: " + response.getBody());
        Assert.assertTrue(response.getHttpReturnCode() == 201);
    }

    @Test
    public void removeCardTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        PaggiCard card = new PaggiCard()
                .withNumber("5573710095684403")
                .withCvc(String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()))
                .withHolder(faker.name().fullName())
                .withDocument(faker.idNumber().ssnValid())
                .withYear("2050")
                .withMonth("04");

        PaggiStoreCardRequest storeRequest = new PaggiStoreCardRequest().withCard(card);
        PaggiStoreCardResponse storeResponse = client.storeCard(storeRequest);

        //Verificar se Armazenou Cartão Corretamente
        System.out.println("removeCardTest: " + storeResponse.getBody());
        Assert.assertTrue(storeResponse.getHttpReturnCode() == 201);


        Map<String,Object> responseMap = storeResponse.getBodyAsMap();

        String cardId = (String) responseMap.get("id");

        PaggiRemoveCardRequest request = new PaggiRemoveCardRequest().withCardId(cardId);
        PaggiRemoveCardResponse response = client.removeCard(request);

        //Verificar se Cartão Criado previamente foi removido
        System.out.println("removeCardTest: " + response.getBody());
        Assert.assertTrue(response.getHttpReturnCode() == 204);
    }


}
