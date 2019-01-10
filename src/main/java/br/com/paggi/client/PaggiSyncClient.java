package br.com.paggi.client;

import br.com.paggi.model.PaggiCredentials;
import br.com.paggi.model.requests.*;
import br.com.paggi.model.responses.*;

public class PaggiSyncClient implements PaggiClient{
    private PaggiCredentials credentials;

    public PaggiSyncClient(PaggiCredentials credentials){
        this.credentials = credentials;
    }

    @Override
    public PaggiStoreCardResponse storeCard(PaggiStoreCardRequest request) {
        return null;
    }

    @Override
    public PaggiRemoveCardResponse removeCard(PaggiRemoveCardRequest request) {
        return null;
    }

    @Override
    public PaggiCreateOrderResponse createOrder(PaggiCreateOrderRequest request) {
        return null;
    }

    @Override
    public PaggiCaptureOrderResponse captureOrder(PaggiCaptureOrderRequest request) {
        return null;
    }

    @Override
    public PaggiCancelOrderResponse cancelOrder(PaggiCancelOrderRequest request) {
        return null;
    }

    @Override
    public PaggiCreateRecipientResponse createRecipient(PaggiCreateRecipientRequest request) {
        return null;
    }

    @Override
    public PaggiListRecipientResponse listRecipients(PaggiListRecipientsRequest request) {
        return null;
    }

    @Override
    public PaggiUpdateRecipientResponse updateRecipient(PaggiUpdateRecipientResponse request) {
        return null;
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
}
