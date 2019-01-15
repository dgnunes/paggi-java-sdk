package br.com.paggi.client;

import br.com.paggi.model.requests.*;
import br.com.paggi.model.responses.*;

public interface PaggiClient {

    //CARDS
    PaggiStoreCardResponse storeCard(PaggiStoreCardRequest request);
    PaggiRemoveCardResponse removeCard(PaggiRemoveCardRequest request);

    //ORDERS
    PaggiCreateOrderResponse createOrder(PaggiCreateOrderRequest request);
    PaggiCaptureOrderResponse captureOrder(PaggiCaptureOrderRequest request);
    PaggiCancelOrderResponse cancelOrder (PaggiCancelOrderRequest request);

    //RECIPIENTS
    PaggiCreateRecipientResponse createRecipient(PaggiCreateRecipientRequest request);
    PaggiListRecipientResponse listRecipients(PaggiListRecipientsRequest request);
    PaggiUpdateRecipientResponse updateRecipient(PaggiUpdateRecipientRequest request);

    //PLAN
    PaggiCreatePlanResponse createPlan(PaggiCreatePlanRequest request);
    PaggiFindPlanResponse findPlan(PaggiFindPlanRequest request);
    PaggiUpdatePlanResponse updatePlan(PaggiUpdatePlanRequest request);
    PaggiRemovePlanResponse removePlan(PaggiRemovePlanRequest request);

    //SUBSCRIPTION
    PaggiCreateSubscriptionResponse createSubscription (PaggiCreateSubscriptionRequest request);
    PaggiFindSubscriptionResponse findSubscription(PaggiFindSubscriptionRequest request);
    PaggiUpdateSubscriptionResponse updateSubscription(PaggiUpdateSubscriptionRequest request);
    PaggiCancelSubscriptionResponse cancelSubscription (PaggiCancelSubscriptionRequest request);

}
