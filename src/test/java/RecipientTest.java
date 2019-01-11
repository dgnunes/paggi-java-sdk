import br.com.paggi.auth.PaggiCredentials;
import br.com.paggi.builder.PaggiSyncClientBuilder;
import br.com.paggi.client.PaggiClient;
import br.com.paggi.enums.PaggiEnvironment;
import br.com.paggi.model.bean.PaggiBankAccount;
import br.com.paggi.model.bean.PaggiRecipient;
import br.com.paggi.model.requests.PaggiCreateRecipientRequest;
import br.com.paggi.model.requests.PaggiListRecipientsRequest;
import br.com.paggi.model.requests.PaggiUpdateRecipientRequest;
import br.com.paggi.model.responses.PaggiCreateRecipientResponse;
import br.com.paggi.model.responses.PaggiListRecipientResponse;
import br.com.paggi.model.responses.PaggiUpdateRecipientResponse;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;
import java.util.Map;

public class RecipientTest {

    @Test
    public void listRecipientsTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        PaggiListRecipientsRequest request = new PaggiListRecipientsRequest();

        PaggiListRecipientResponse response = client.listRecipients(request);

        Assert.assertTrue("Não Retornou 200 OK",response.getHttpReturnCode() == 200);
        Assert.assertFalse("Body está vazio",response.getBody().isEmpty());
    }

    @Test
    public void createRecipientsTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        PaggiBankAccount bankAccount = new PaggiBankAccount()
                .withBank_code("077")
                .withAccount_number("120003")
                .withAccount_digit("4")
                .withBranch_number("0001")
                .withBranch_digit("5");


        PaggiRecipient recipient = new PaggiRecipient()
                .withName(faker.gameOfThrones().character())
                .withDocument(TestUtils.geraCPF())
                .withBank_account(bankAccount);

        PaggiCreateRecipientRequest request = new PaggiCreateRecipientRequest().withRecipient(recipient);
        PaggiCreateRecipientResponse response = client.createRecipient(request);


        Assert.assertTrue("Não Retornou 201 Created",response.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",response.getBody().isEmpty());
    }

    @Test
    public void updateRecipientsTest() throws Exception {
        PaggiClient client = PaggiSyncClientBuilder.standard()
                .withEnvironment(PaggiEnvironment.STAGING)
                .withCredentials(new PaggiCredentials()
                        .withToken(TestCredentials.TOKEN))
                .build();

        Faker faker = new Faker(new Locale("pt-BR"));

        PaggiBankAccount originalBankAccount = new PaggiBankAccount()
                .withBank_code("077")
                .withAccount_number("120003")
                .withAccount_digit("4")
                .withBranch_number("0001")
                .withBranch_digit("5");


        PaggiRecipient recipient = new PaggiRecipient()
                .withName(faker.gameOfThrones().character())
                .withDocument(TestUtils.geraCPF())
                .withBank_account(originalBankAccount);

        PaggiCreateRecipientRequest createRequest = new PaggiCreateRecipientRequest().withRecipient(recipient);
        PaggiCreateRecipientResponse createResponse = client.createRecipient(createRequest);


        Assert.assertTrue("Não Retornou 201 Created",createResponse.getHttpReturnCode() == 201);
        Assert.assertFalse("Body está vazio",createResponse.getBody().isEmpty());
        Map<String, Object> responseMap = createResponse.getBodyAsMap();
        Map<String, String> responseBankMap = (Map<String, String>) responseMap.get("bank_account");



        PaggiBankAccount modifiedBankAccount = new PaggiBankAccount()
                .withId(responseBankMap.get("id"))
                .withBank_code("066")
                .withAccount_number("120001")
                .withAccount_digit("2")
                .withBranch_number("1")
                .withBranch_digit("4");

        PaggiUpdateRecipientRequest request = new PaggiUpdateRecipientRequest()
                .withRecipientId((String) responseMap.get("id"))
                .withBank_Account(modifiedBankAccount);

        PaggiUpdateRecipientResponse response = client.updateRecipient(request);

        Assert.assertTrue("Não Retornou 200 OK",createResponse.getHttpReturnCode() == 200);
        Assert.assertFalse("Body está vazio",createResponse.getBody().isEmpty());
    }

}
