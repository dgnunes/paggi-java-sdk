import br.com.paggi.auth.PaggiCredentials;
import br.com.paggi.builder.PaggiSyncClientBuilder;
import br.com.paggi.client.PaggiClient;
import br.com.paggi.enums.PaggiEnvironment;
import br.com.paggi.model.bean.*;
import br.com.paggi.model.requests.*;
import br.com.paggi.model.responses.*;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SubscriptionTest {

    @Test
    public void createSubscription() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();


        Faker faker = new Faker(new Locale("pt-BR"));

        //Cria Plan
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


        PaggiCard card = new PaggiCard()
                .withNumber("5573710095684403")
                .withCvc(String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()))
                .withHolder(faker.name().fullName())
                .withDocument(faker.idNumber().ssnValid())
                .withYear("2050")
                .withMonth("04");

        PaggiCustomer customer = new PaggiCustomer()
                .withName("createSubscription")
                .withEmail(faker.internet().emailAddress())
                .withDocument("86219425006");

        PaggiDiscount discount = new PaggiDiscount()
                .withPeriod(2)
                .withAmount(2000)
                .withDescription(faker.commerce().promotionCode());


        List<PaggiDiscount> discounts = new ArrayList<>();
        discounts.add(discount);


        PaggiAdditional additional = new PaggiAdditional()
                .withPeriod(3)
                .withAmount(1999)
                .withDescription(faker.commerce().promotionCode());

        List<PaggiAdditional> additionals = new ArrayList<>();
        additionals.add(additional);

        PaggiCreateSubscriptionRequest request = new PaggiCreateSubscriptionRequest()
                .withExternal_Identifier(faker.finance().creditCard())
                .withPlanId((String) responseMap.get("id"))
                .withIp(faker.internet().ipV4Address())
                .withPaggiCustomer(customer)
                .withPaggiCard(card)
                .withPaggiDiscounts(discounts)
                .withPaggiAdditionals(additionals);


        PaggiCreateSubscriptionResponse response = client.createSubscription(request);

        Assert.assertTrue("Não retornou 201 Created",response.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",response.getBody().isEmpty());
    }

    @Test
    public void findSubscription() throws Exception {

        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();


        Faker faker = new Faker(new Locale("pt-BR"));

        //Cria Plan
        PaggiPlan plan = new PaggiPlan()
                .withName(faker.commerce().productName())
                .withPrice("1990")
                .withInterval("1m")
                .withTrial_period("15d")
                .withDescription(faker.commerce().promotionCode())
                .withExternal_identifier(faker.finance().iban());

        PaggiCreatePlanRequest createPlanRequest = new PaggiCreatePlanRequest().withPlan(plan);

        PaggiCreatePlanResponse createPlanResponse = client.createPlan(createPlanRequest);

        Assert.assertTrue("Não retornou 201 Created",createPlanResponse.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",createPlanResponse.getBody().isEmpty());

        Map<String, Object> responsePlanMap = createPlanResponse.getBodyAsMap();

        PaggiCard card = new PaggiCard()
                .withNumber("5573710095684403")
                .withCvc(String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()))
                .withHolder(faker.name().fullName())
                .withDocument(faker.idNumber().ssnValid())
                .withYear("2050")
                .withMonth("04");

        PaggiCustomer customer = new PaggiCustomer()
                .withName("findSubscription")
                .withEmail(faker.internet().emailAddress())
                .withDocument("86219425006");

        PaggiDiscount discount = new PaggiDiscount()
                .withPeriod(2)
                .withAmount(2000)
                .withDescription(faker.commerce().promotionCode());

        List<PaggiDiscount> discounts = new ArrayList<>();
        discounts.add(discount);


        PaggiAdditional additional = new PaggiAdditional()
                .withPeriod(3)
                .withAmount(1999)
                .withDescription(faker.commerce().promotionCode());

        List<PaggiAdditional> additionals = new ArrayList<>();
        additionals.add(additional);

        PaggiCreateSubscriptionRequest createSubscriptionRequest = new PaggiCreateSubscriptionRequest()
                .withExternal_Identifier(faker.finance().creditCard())
                .withPlanId((String) responsePlanMap.get("id"))
                .withIp(faker.internet().ipV4Address())
                .withPaggiCustomer(customer)
                .withPaggiCard(card)
                .withPaggiDiscounts(discounts)
                .withPaggiAdditionals(additionals);


        PaggiCreateSubscriptionResponse createSubscriptionResponse = client.createSubscription(createSubscriptionRequest);

        Assert.assertTrue("Não retornou 201 Created",createSubscriptionResponse.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",createSubscriptionResponse.getBody().isEmpty());
        Map<String, Object> responseMap = createSubscriptionResponse.getBodyAsMap();

        PaggiFindSubscriptionRequest request = new PaggiFindSubscriptionRequest().withSubscriptionId((String) responseMap.get("id"));
        PaggiFindSubscriptionResponse response = client.findSubscription(request);

        Assert.assertTrue("Não retornou 200 OK",response.getHttpReturnCode() == 200);
        Assert.assertFalse("Body está vazio",response.getBody().isEmpty());
    }

    @Test
    public void updateSubscription() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();


        Faker faker = new Faker(new Locale("pt-BR"));

        //Cria Plan
        PaggiPlan plan = new PaggiPlan()
                .withName(faker.commerce().productName())
                .withPrice("1990")
                .withInterval("1m")
                .withTrial_period("15d")
                .withDescription(faker.commerce().promotionCode())
                .withExternal_identifier(faker.finance().iban());

        PaggiCreatePlanRequest createPlanRequest = new PaggiCreatePlanRequest().withPlan(plan);

        PaggiCreatePlanResponse createPlanResponse = client.createPlan(createPlanRequest);

        Assert.assertTrue("Não retornou 201 Created",createPlanResponse.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",createPlanResponse.getBody().isEmpty());

        Map<String, Object> responsePlanMap = createPlanResponse.getBodyAsMap();

        PaggiCard card = new PaggiCard()
                .withNumber("5573710095684403")
                .withCvc(String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()))
                .withHolder(faker.name().fullName())
                .withDocument(faker.idNumber().ssnValid())
                .withYear("2050")
                .withMonth("04");

        PaggiCustomer customer = new PaggiCustomer()
                .withName("findSubscription")
                .withEmail(faker.internet().emailAddress())
                .withDocument("86219425006");

        PaggiDiscount discount = new PaggiDiscount()
                .withPeriod(2)
                .withAmount(2000)
                .withDescription(faker.commerce().promotionCode());

        List<PaggiDiscount> discounts = new ArrayList<>();
        discounts.add(discount);


        PaggiAdditional additional = new PaggiAdditional()
                .withPeriod(3)
                .withAmount(1999)
                .withDescription(faker.commerce().promotionCode());

        List<PaggiAdditional> additionals = new ArrayList<>();
        additionals.add(additional);

        PaggiCreateSubscriptionRequest createSubscriptionRequest = new PaggiCreateSubscriptionRequest()
                .withExternal_Identifier(faker.finance().creditCard())
                .withPlanId((String) responsePlanMap.get("id"))
                .withIp(faker.internet().ipV4Address())
                .withPaggiCustomer(customer)
                .withPaggiCard(card)
                .withPaggiDiscounts(discounts)
                .withPaggiAdditionals(additionals);


        PaggiCreateSubscriptionResponse createSubscriptionResponse = client.createSubscription(createSubscriptionRequest);

        Assert.assertTrue("Não retornou 201 Created",createSubscriptionResponse.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",createSubscriptionResponse.getBody().isEmpty());
        Map<String, Object> responseMap = createSubscriptionResponse.getBodyAsMap();


        PaggiDiscount modifiedDiscount = new PaggiDiscount()
                .withPeriod(4)
                .withAmount(5000)
                .withDescription(faker.commerce().productName());

        List<PaggiDiscount> modifiedDiscounts = new ArrayList<>();
        modifiedDiscounts.add(modifiedDiscount);


        PaggiAdditional modifiedAdditional = new PaggiAdditional()
                .withPeriod(10)
                .withAmount(1989)
                .withDescription(faker.gameOfThrones().house());

        List<PaggiAdditional> modifiedAdditionals = new ArrayList<>();
        modifiedAdditionals.add(modifiedAdditional);


        PaggiUpdateSubscriptionRequest request = new PaggiUpdateSubscriptionRequest()
                .withSubscriptionId((String) responseMap.get("id"))
                .withPaggiDiscounts(modifiedDiscounts)
                .withPaggiAdditionals(modifiedAdditionals);


        PaggiUpdateSubscriptionResponse response = client.updateSubscription(request);

        Assert.assertTrue("Não retornou 201 Created",response.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",response.getBody().isEmpty());
    }

    @Test
    public void removeSubscription() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();


        Faker faker = new Faker(new Locale("pt-BR"));

        //Cria Plan
        PaggiPlan plan = new PaggiPlan()
                .withName(faker.commerce().productName())
                .withPrice("1990")
                .withInterval("1m")
                .withTrial_period("15d")
                .withDescription(faker.commerce().promotionCode())
                .withExternal_identifier(faker.finance().iban());

        PaggiCreatePlanRequest createPlanRequest = new PaggiCreatePlanRequest().withPlan(plan);

        PaggiCreatePlanResponse createPlanResponse = client.createPlan(createPlanRequest);

        Assert.assertTrue("Não retornou 201 Created",createPlanResponse.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",createPlanResponse.getBody().isEmpty());

        Map<String, Object> responsePlanMap = createPlanResponse.getBodyAsMap();

        PaggiCard card = new PaggiCard()
                .withNumber("5573710095684403")
                .withCvc(String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()) + String.valueOf(faker.number().randomDigit()))
                .withHolder(faker.name().fullName())
                .withDocument(faker.idNumber().ssnValid())
                .withYear("2050")
                .withMonth("04");

        PaggiCustomer customer = new PaggiCustomer()
                .withName("findSubscription")
                .withEmail(faker.internet().emailAddress())
                .withDocument("86219425006");

        PaggiDiscount discount = new PaggiDiscount()
                .withPeriod(2)
                .withAmount(2000)
                .withDescription(faker.commerce().promotionCode());

        List<PaggiDiscount> discounts = new ArrayList<>();
        discounts.add(discount);

        PaggiAdditional additional = new PaggiAdditional()
                .withPeriod(3)
                .withAmount(1999)
                .withDescription(faker.commerce().promotionCode());

        List<PaggiAdditional> additionals = new ArrayList<>();
        additionals.add(additional);

        PaggiCreateSubscriptionRequest createSubscriptionRequest = new PaggiCreateSubscriptionRequest()
                .withExternal_Identifier(faker.finance().creditCard())
                .withPlanId((String) responsePlanMap.get("id"))
                .withIp(faker.internet().ipV4Address())
                .withPaggiCustomer(customer)
                .withPaggiCard(card)
                .withPaggiDiscounts(discounts)
                .withPaggiAdditionals(additionals);

        PaggiCreateSubscriptionResponse createSubscriptionResponse = client.createSubscription(createSubscriptionRequest);

        Assert.assertTrue("Não retornou 201 Created",createSubscriptionResponse.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",createSubscriptionResponse.getBody().isEmpty());
        Map<String, Object> responseMap = createSubscriptionResponse.getBodyAsMap();


        PaggiCancelSubscriptionRequest request = new PaggiCancelSubscriptionRequest().withSubscriptionId((String) responseMap.get("id"));
        PaggiCancelSubscriptionResponse response = client.cancelSubscription(request);

        Assert.assertTrue("Não retornou 204 No Content",response.getHttpReturnCode() == 204);
        Assert.assertFalse("Body está vazio",response.getBody().isEmpty());

    }


}
