import br.com.paggi.builder.PaggiSyncClientBuilder;
import br.com.paggi.client.PaggiClient;
import br.com.paggi.enums.PaggiEnvironment;
import br.com.paggi.auth.PaggiCredentials;
import br.com.paggi.model.bean.*;
import br.com.paggi.model.requests.PaggiCancelOrderRequest;
import br.com.paggi.model.requests.PaggiCaptureOrderRequest;
import br.com.paggi.model.requests.PaggiCreateOrderRequest;
import br.com.paggi.model.responses.PaggiCancelOrderResponse;
import br.com.paggi.model.responses.PaggiCaptureOrderResponse;
import br.com.paggi.model.responses.PaggiCreateOrderResponse;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class OrdersTest {

    @Test
    public void createOrderSuccessfulTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Map<String,Object> body = new HashMap<>();

        Faker faker = new Faker(new Locale("pt-BR"));

        faker.internet().ipV4Address();

        body.put("capture",false);
        body.put("ip",faker.internet().ipV4Address());
        body.put("external_identifier",faker.commerce().promotionCode());

        List<Object> charges = new ArrayList<>();
        Map<String,Object> charge = new HashMap<>();
        charge.put("amount", 5000);
        charge.put("installments", 1);

        Map<String,Object> chargedCard = new HashMap<>();
        chargedCard.put("number","5573710095684403");
        chargedCard.put("cvc","123");
        chargedCard.put("holder","BRUCE WAYNE");
        chargedCard.put("year","2020");
        chargedCard.put("month","04");
        chargedCard.put("document","86219425006");

        charge.put("card", chargedCard);
        charges.add(charge);

        body.put("charges", charges);

        List<Object> recipients = new ArrayList<>();
        Map<String,Object> recipient = new HashMap<>();

        recipient.put("document", "47172220080");
        recipient.put("name", "Clark Kent");
        recipient.put("percentage", 10);

        Map<String,Object> recipientBankAccount = new HashMap<>();
        recipientBankAccount.put("bank_code", "077");
        recipientBankAccount.put("account_number", "0001");
        recipientBankAccount.put("branch_number", "86251");
        recipientBankAccount.put("branch_digit", "9");
        recipientBankAccount.put("account_digit", "1");

        recipient.put("bank_account",recipientBankAccount);
        recipients.add(recipient);
        body.put("recipients", recipients);


        Map<String,Object> customer = new HashMap<>();
        customer.put("name", "createOrderSuccessfulTest");
        customer.put("document", "86219425006");
        customer.put("email", "bruce@waynecorp.com");

        body.put("customer", customer);
        PaggiCreateOrderRequest request = new PaggiCreateOrderRequest(body);

        PaggiCreateOrderResponse response = client.createOrder(request);

        System.out.println("createOrderSuccessfulTest: " + response.getBody());
        Assert.assertTrue(response.getHttpReturnCode() == 201 || response.getHttpReturnCode() == 202);
    }

    @Test
    public void createOrderSuccessfulTestBeautified() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        //Instanciando Cartão a ser cobrado
        PaggiCard card = new PaggiCard()
                .withNumber("5573710095684403")
                .withCvc("123")
                .withHolder("BRUCE WAYNE")
                .withDocument("86219425006")
                .withYear("2020")
                .withMonth("04");

        //Criando Cobrança
        PaggiCharge charge = new PaggiCharge()
                .withAmount(500)
                .withInstallments(2)
                .withCard(card);

        List<PaggiCharge> charges = new ArrayList<>();
        charges.add(charge);

        //Listando Recebedores
        List<PaggiRecipient> recipients = new ArrayList<>();
        recipients.add(new PaggiRecipient()
                .withName("Clark Kent")
                .withDocument("47172220080")
                .withBank_account(new PaggiBankAccount()
                        .withBank_code("077")
                        .withAccount_number("0001")
                        .withAccount_digit("86251")
                        .withBranch_number("9")
                        .withBranch_digit("1"))
                .withPercentage(10));

        //Criando Client
        PaggiCustomer customer = new PaggiCustomer()
                .withName("createOrderSuccessfulTestBeautified")
                .withEmail("bruce@waynecorp.com")
                .withDocument("86219425006");

        PaggiCreateOrderRequest request = new PaggiCreateOrderRequest()
                .withCapture(true)
                .withIp(faker.internet().ipV4Address())
                .withExternalIdentifier(faker.commerce().promotionCode())
                .withCharges(charges)
                .withRecipients(recipients)
                .withCustomer(customer);

        PaggiCreateOrderResponse response = client.createOrder(request);

        System.out.println("createOrderSuccessfulTestBeautified: " + response.getBody());
        Assert.assertTrue(response.getHttpReturnCode() == 201 || response.getHttpReturnCode() == 202);
    }

    @Test
    public void createOrderSuccessfulTestBeautifiedWithoutCapture() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        //Instanciando Cartão a ser cobrado
        PaggiCard card = new PaggiCard()
                .withNumber("5573710095684403")
                .withCvc("123")
                .withHolder("BRUCE WAYNE")
                .withDocument("86219425006")
                .withYear("2020")
                .withMonth("04");

        //Criando Cobrança
        PaggiCharge charge = new PaggiCharge()
                .withAmount(500)
                .withInstallments(1)
                .withCard(card);


        List<PaggiCharge> charges = new ArrayList<>();
        charges.add(charge);


        //Listando Recebedores
        List<PaggiRecipient> recipients = new ArrayList<>();
        recipients.add(new PaggiRecipient()
                .withName("Clark Kent")
                .withDocument("47172220080")
                .withBank_account(new PaggiBankAccount()
                        .withBank_code("077")
                        .withAccount_number("0001")
                        .withAccount_digit("86251")
                        .withBranch_number("9")
                        .withBranch_digit("1"))
                .withPercentage(10));


        //Criando Client
        PaggiCustomer customer = new PaggiCustomer()
                .withName("createOrderSuccessfulTestBeautified")
                .withEmail("bruce@waynecorp.com")
                .withDocument("86219425006");

        PaggiCreateOrderRequest request = new PaggiCreateOrderRequest()
                .withCapture(false)
                .withIp(faker.internet().ipV4Address())
                .withExternalIdentifier(faker.commerce().promotionCode())
                .withCharges(charges)
                .withRecipients(recipients)
                .withCustomer(customer);

        PaggiCreateOrderResponse response = client.createOrder(request);

        System.out.println("createOrderSuccessfulTestBeautified: " + response.getBody());
        Assert.assertTrue(response.getHttpReturnCode() == 201 || response.getHttpReturnCode() == 202);
    }

    @Test
    public void createOrderSuccessfulTestBeautifiedWithoutSplit() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();


        Faker faker = new Faker(new Locale("pt-BR"));


        //Instanciando Cartão a ser cobrado
        PaggiCard card = new PaggiCard()
                .withNumber("5573710095684403")
                .withCvc("123")
                .withHolder("BRUCE WAYNE")
                .withDocument("86219425006")
                .withYear("2020")
                .withMonth("04");

        //Criando Cobrança
        PaggiCharge charge = new PaggiCharge()
                .withAmount(500)
                .withInstallments(1)
                .withCard(card);


        List<PaggiCharge> charges = new ArrayList<>();
        charges.add(charge);


        //Criando Client
        PaggiCustomer customer = new PaggiCustomer()
                .withName("createOrderSuccessfulTestBeautifiedWithoutSplit")
                .withEmail("bruce@waynecorp.com")
                .withDocument("86219425006");

        PaggiCreateOrderRequest request = new PaggiCreateOrderRequest()
                .withCapture(true)
                .withIp(faker.internet().ipV4Address())
                .withExternalIdentifier(faker.commerce().promotionCode())
                .withCharges(charges)
                .withCustomer(customer);

        PaggiCreateOrderResponse response = client.createOrder(request);

        System.out.println("createOrderSuccessfulTestBeautifiedWithoutSplit: " + response.getBody());
        Assert.assertTrue(response.getHttpReturnCode() == 201 || response.getHttpReturnCode() == 202);
    }

    @Test
    public void createOrderSuccessfulTestBeautifiedWithCardId() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();


        Faker faker = new Faker(new Locale("pt-BR"));


        //Instanciando Cartão a ser cobrado
        PaggiCard card = new PaggiCard()
                .withId("f3a0cfbd-a81d-425e-ae1a-adfbc1e058a7");

        //Criando Cobrança
        PaggiCharge charge = new PaggiCharge()
                .withAmount(500)
                .withInstallments(1)
                .withCard(card);


        List<PaggiCharge> charges = new ArrayList<>();
        charges.add(charge);


        //Criando Client
        PaggiCustomer customer = new PaggiCustomer()
                .withName("createOrderSuccessfulTestBeautifiedWithCardId")
                .withEmail("bruce@waynecorp.com")
                .withDocument("86219425006");

        PaggiCreateOrderRequest request = new PaggiCreateOrderRequest()
                .withCapture(false)
                .withIp(faker.internet().ipV4Address())
                .withExternalIdentifier(faker.commerce().promotionCode())
                .withCharges(charges)
                .withCustomer(customer);

        PaggiCreateOrderResponse response = client.createOrder(request);

        System.out.println("createOrderSuccessfulTestBeautifiedWithCardId: " + response.getBody());
        Assert.assertTrue(response.getHttpReturnCode() == 201 || response.getHttpReturnCode() == 202);
    }


    @Test
    public void captureOrderTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        //Instanciando Cartão a ser cobrado
        PaggiCard card = new PaggiCard()
                .withNumber("5573710095684403")
                .withCvc("123")
                .withHolder("BRUCE WAYNE")
                .withDocument("86219425006")
                .withYear("2020")
                .withMonth("04");

        //Criando Cobrança
        PaggiCharge charge = new PaggiCharge()
                .withAmount(500)
                .withInstallments(1)
                .withCard(card);

        List<PaggiCharge> charges = new ArrayList<>();
        charges.add(charge);

        //Criando Customer
        PaggiCustomer customer = new PaggiCustomer()
                .withName("createOrderSuccessfulTestBeautified")
                .withEmail("bruce@waynecorp.com")
                .withDocument("86219425006");

        PaggiCreateOrderRequest createRequest = new PaggiCreateOrderRequest()
                .withCapture(true)
                .withIp(faker.internet().ipV4Address())
                .withExternalIdentifier(faker.commerce().promotionCode())
                .withCharges(charges)
                .withCustomer(customer);

        PaggiCreateOrderResponse createResponse = client.createOrder(createRequest);
        Map<String, Object> responseMap = createResponse.getBodyAsMap();

        //Verificando Possibilidade de Captura
        PaggiCaptureOrderRequest request = new PaggiCaptureOrderRequest().withOrderId((String) responseMap.get("id"));

        PaggiCaptureOrderResponse response = client.captureOrder(request);

        System.out.println("captureOrderTest: " + response.getBody());
        Assert.assertTrue(response.getHttpReturnCode() == 200 || response.getHttpReturnCode() == 201 || response.getHttpReturnCode() == 202);
    }

    @Test
    public void cancelOrderTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        //Instanciando Cartão a ser cobrado
        PaggiCard card = new PaggiCard()
                .withNumber("5573710095684403")
                .withCvc("123")
                .withHolder("BRUCE WAYNE")
                .withDocument("86219425006")
                .withYear("2020")
                .withMonth("04");

        //Criando Cobrança
        PaggiCharge charge = new PaggiCharge()
                .withAmount(500)
                .withInstallments(1)
                .withCard(card);

        List<PaggiCharge> charges = new ArrayList<>();
        charges.add(charge);

        //Criando Customer
        PaggiCustomer customer = new PaggiCustomer()
                .withName("createOrderSuccessfulTestBeautified")
                .withEmail("bruce@waynecorp.com")
                .withDocument("86219425006");

        PaggiCreateOrderRequest createRequest = new PaggiCreateOrderRequest()
                .withCapture(true)
                .withIp(faker.internet().ipV4Address())
                .withExternalIdentifier(faker.commerce().promotionCode())
                .withCharges(charges)
                .withCustomer(customer);

        PaggiCreateOrderResponse createResponse = client.createOrder(createRequest);
        Map<String, Object> responseMap = createResponse.getBodyAsMap();


        //Verificando Possibilidade de Cancelamento
        PaggiCancelOrderRequest request = new PaggiCancelOrderRequest().withOrderId((String) responseMap.get("id"));

        PaggiCancelOrderResponse response = client.cancelOrder(request);

        System.out.println("cancelOrderTest: " + response.getBody());
        Assert.assertTrue(response.getHttpReturnCode() == 200 || response.getHttpReturnCode() == 201 || response.getHttpReturnCode() == 202);
    }

}
