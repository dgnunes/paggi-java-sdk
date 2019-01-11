package br.com.paggi.client;

import br.com.paggi.auth.PaggiCredentials;
import br.com.paggi.enums.PaggiEnvironment;
import br.com.paggi.model.requests.*;
import br.com.paggi.model.responses.*;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class PaggiSyncClient implements PaggiClient{
    private PaggiCredentials credentials;
    private PaggiEnvironment environment;

    public PaggiSyncClient(PaggiCredentials credentials, PaggiEnvironment environment){
        this.credentials = credentials;
        this.environment = environment;
    }

    @Override
    public PaggiStoreCardResponse storeCard(PaggiStoreCardRequest request) {
        PaggiStoreCardResponse response = new PaggiStoreCardResponse();
        httpsProcess(request, response);

        return response;
    }

    @Override
    public PaggiRemoveCardResponse removeCard(PaggiRemoveCardRequest request) {
        PaggiRemoveCardResponse response = new PaggiRemoveCardResponse();
        httpsProcess(request, response);

        return response;

    }

    @Override
    public PaggiCreateOrderResponse createOrder(PaggiCreateOrderRequest request) {
        PaggiCreateOrderResponse response = new PaggiCreateOrderResponse();
        httpsProcess(request, response);

        return response;
    }

    @Override
    public PaggiCaptureOrderResponse captureOrder(PaggiCaptureOrderRequest request) {
        PaggiCaptureOrderResponse response = new PaggiCaptureOrderResponse();
        httpsProcess(request, response);

        return response;
    }

    @Override
    public PaggiCancelOrderResponse cancelOrder(PaggiCancelOrderRequest request) {
        PaggiCancelOrderResponse response = new PaggiCancelOrderResponse();
        httpsProcess(request, response);

        return response;
    }

    @Override
    public PaggiCreateRecipientResponse createRecipient(PaggiCreateRecipientRequest request) {
        PaggiCreateRecipientResponse response = new PaggiCreateRecipientResponse();
        httpsProcess(request, response);

        return response;
    }

    @Override
    public PaggiListRecipientResponse listRecipients(PaggiListRecipientsRequest request) {
        PaggiListRecipientResponse response = new PaggiListRecipientResponse();
        httpsProcess(request, response);

        return response;
    }

    @Override
    public PaggiUpdateRecipientResponse updateRecipient(PaggiUpdateRecipientRequest request) {
        PaggiUpdateRecipientResponse response = new PaggiUpdateRecipientResponse();
        httpsProcess(request, response);

        return response;
    }

    @Override
    public PaggiCreatePlanResponse createPlan(PaggiCreatePlanRequest request) {
        return null;
    }

    @Override
    public PaggiFindPlanResponse findPlan(PaggiFindPlanRequest request) {
        return null;
    }

    @Override
    public PaggiUpdatePlanResponse updatePlan(PaggiUpdatePlanRequest request) {
        return null;
    }

    @Override
    public PaggiRemovePlanResponse removePlan(PaggiRemovePlanRequest request) {
        return null;
    }

    @Override
    public PaggiCreateSubscriptionResponse createSubscription(PaggiCreateSubscriptionRequest request) {
        return null;
    }

    @Override
    public PaggiFindSubscriptionResponse findSubscription(PaggiFindSubscriptionRequest request) {
        return null;
    }

    @Override
    public PaggiUpdateSubscriptionResponse updateSubscription(PaggiUpdateSubscriptionRequest request) {
        return null;
    }

    @Override
    public PaggiCancelSubscriptionResponse cancelSubscription(PaggiCancelSubscriptionRequest request) {
        return null;
    }


    private void httpsProcess(PaggiRequest paggiRequest, PaggiResponse paggiResponse) {
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");

        //Selecting correct Path according to environment
        String path = "";
        switch(environment){
            case PRODUCTION:
                path += "https://api.paggi.com/v1/";
                break;
            case STAGING:
            default:
                path += "https://api.stg.paggi.com/v1/";
        }

        path += paggiRequest.getPATH();

        //Preparing Request Path Parameters
        path = path.replace("{partner_id}", credentials.getPartnerId());

        for (Map.Entry entry: paggiRequest.getPathParameters().entrySet()){
            path = path.replace("{" + entry.getKey() + "}", (CharSequence) entry.getValue());
        }

        paggiResponse.setCalledPath(path);
        //Preparing Request Body
        Gson gson = new Gson();
        String json = gson.toJson(paggiRequest.getBody());

        System.out.println("requestJson: " + json);

        RequestBody body = RequestBody.create(JSON, json);

        Request httpsRequest;
        switch(paggiRequest.getMETHOD()){
            case "GET":
                httpsRequest = new Request.Builder()
                        .url(path)
                        .header("Authorization", "Bearer " + credentials.getToken())
                        .header("Content-Type","application/json")
                        .get()
                        .build();
                break;

            case "POST":
            case "PUT":
            case "DELETE":
                httpsRequest = new Request.Builder()
                        .url(path)
                        .header("Authorization", "Bearer " + credentials.getToken())
                        .header("Content-Type","application/json")
                        .method(paggiRequest.getMETHOD(), body)
                        .build();
                break;
            default:
                throw new UnsupportedOperationException("Método HTTP inválido");

        }

        OkHttpClient httpClient = new OkHttpClient();
        try (Response httpResponse = httpClient.newCall(httpsRequest).execute()) {
            paggiResponse.setBody(httpResponse.body().string());
            paggiResponse.setHttpReturnCode(httpResponse.code());
            paggiResponse.setMessage(httpResponse.message());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
