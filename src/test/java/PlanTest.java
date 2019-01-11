import br.com.paggi.auth.PaggiCredentials;
import br.com.paggi.builder.PaggiSyncClientBuilder;
import br.com.paggi.client.PaggiClient;
import br.com.paggi.enums.PaggiEnvironment;
import br.com.paggi.model.bean.PaggiPlan;
import br.com.paggi.model.requests.*;
import br.com.paggi.model.responses.*;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;
import java.util.Map;

public class PlanTest {

    @Test
    public void findPlansTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        PaggiPlan plan = new PaggiPlan()
                .withName(faker.commerce().productName())
                .withPrice("1990")
                .withInterval("1m")
                .withTrial_period("15d")
                .withDescription(faker.commerce().promotionCode())
                .withExternal_identifier(faker.finance().iban());

        PaggiCreatePlanRequest createRequest = new PaggiCreatePlanRequest().withPlan(plan);

        PaggiCreatePlanResponse createResponse = client.createPlan(createRequest);

        Assert.assertTrue("Não retornou 201 Created",createResponse.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",createResponse.getBody().isEmpty());

        Map<String, Object> responseMap = createResponse.getBodyAsMap();

        PaggiFindPlanRequest request = new PaggiFindPlanRequest().withPlanId((String) responseMap.get("id"));
        PaggiFindPlanResponse response = client.findPlan(request);

        Assert.assertTrue("Não retornou 200 OK",response.getHttpReturnCode() == 200);
        Assert.assertFalse("Body está vazio",response.getBody().isEmpty());
    }

    @Test
    public void createPlanTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        PaggiPlan plan = new PaggiPlan()
                .withName(faker.commerce().productName())
                .withPrice("1990")
                .withInterval("1m")
                .withTrial_period("15d")
                .withDescription(faker.commerce().promotionCode())
                .withExternal_identifier(faker.finance().iban());

        PaggiCreatePlanRequest request = new PaggiCreatePlanRequest().withPlan(plan);

        PaggiCreatePlanResponse response = client.createPlan(request);

        Assert.assertTrue("Não retornou 201 Created",response.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",response.getBody().isEmpty());
    }

    @Test
    public void updatePlanTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        PaggiPlan plan = new PaggiPlan()
                .withName(faker.commerce().productName())
                .withPrice("1990")
                .withInterval("1m")
                .withTrial_period("15d")
                .withDescription(faker.commerce().promotionCode())
                .withExternal_identifier(faker.finance().iban());

        PaggiCreatePlanRequest createRequest = new PaggiCreatePlanRequest().withPlan(plan);

        PaggiCreatePlanResponse createResponse = client.createPlan(createRequest);

        Assert.assertTrue("Não retornou 201 Created",createResponse.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",createResponse.getBody().isEmpty());

        Map<String, Object> responseMap = createResponse.getBodyAsMap();

        PaggiPlan modifiedPlan = new PaggiPlan()
                .withName(faker.commerce().productName())
                .withPrice("2000")
                .withInterval("2m")
                .withTrial_period("14d")
                .withDescription(faker.commerce().promotionCode())
                .withExternal_identifier(faker.finance().iban());

        PaggiUpdatePlanRequest request = new PaggiUpdatePlanRequest().withPlanId((String) responseMap.get("id")).withPlan(modifiedPlan);
        PaggiUpdatePlanResponse response = client.updatePlan(request);

        Assert.assertTrue("Não retornou 200 OK",response.getHttpReturnCode() == 200);
        Assert.assertFalse("Body está vazio",response.getBody().isEmpty());
    }

    @Test
    public void removePlanTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        PaggiPlan plan = new PaggiPlan()
                .withName(faker.commerce().productName())
                .withPrice("1990")
                .withInterval("1m")
                .withTrial_period("15d")
                .withDescription(faker.commerce().promotionCode())
                .withExternal_identifier(faker.finance().iban());

        PaggiCreatePlanRequest createRequest = new PaggiCreatePlanRequest().withPlan(plan);

        PaggiCreatePlanResponse createResponse = client.createPlan(createRequest);

        Assert.assertTrue("Não retornou 201 Created",createResponse.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",createResponse.getBody().isEmpty());

        Map<String, Object> responseMap = createResponse.getBodyAsMap();

        PaggiRemovePlanRequest request = new PaggiRemovePlanRequest().withPlanId((String) responseMap.get("id"));
        PaggiRemovePlanResponse response = client.removePlan(request);

        Assert.assertTrue("Não retornou 200 OK ou 204 No Content",response.getHttpReturnCode() == 200 || response.getHttpReturnCode() == 204 );
        Assert.assertFalse("Body está vazio",response.getBody().isEmpty());
    }

}
