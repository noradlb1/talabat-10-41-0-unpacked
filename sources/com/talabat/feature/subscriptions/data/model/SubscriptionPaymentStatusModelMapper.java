package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import com.talabat.mapper.ModelMapper;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\t"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/SubscriptionPaymentStatusModelMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRootResponse;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus;", "()V", "apply", "response", "mapPaymentResult", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus$PaymentResult;", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPaymentStatusModelMapper implements ModelMapper<SubscriptionPaymentRootResponse, SubscriptionPaymentStatus> {
    private final SubscriptionPaymentStatus.PaymentResult mapPaymentResult(SubscriptionPaymentRootResponse subscriptionPaymentRootResponse) {
        SubscriptionPaymentRootResponse.SubscriptionPaymentResult subscriptionPaymentResult;
        if (subscriptionPaymentRootResponse != null) {
            subscriptionPaymentResult = subscriptionPaymentRootResponse.getResult();
        } else {
            subscriptionPaymentResult = null;
        }
        boolean z11 = false;
        if (subscriptionPaymentResult == null) {
            return new SubscriptionPaymentStatus.PaymentResult((String) null, false, 3, (DefaultConstructorMarker) null);
        }
        String redirectURL = subscriptionPaymentRootResponse.getResult().getRedirectURL();
        if (redirectURL == null) {
            redirectURL = "";
        }
        Collection errors = subscriptionPaymentRootResponse.getErrors();
        if (errors == null || errors.isEmpty()) {
            z11 = true;
        }
        return new SubscriptionPaymentStatus.PaymentResult(redirectURL, z11);
    }

    @NotNull
    public SubscriptionPaymentStatus apply(@NotNull SubscriptionPaymentRootResponse subscriptionPaymentRootResponse) {
        Intrinsics.checkNotNullParameter(subscriptionPaymentRootResponse, "response");
        List<String> errors = subscriptionPaymentRootResponse.getErrors();
        SubscriptionPaymentStatus.PaymentResult mapPaymentResult = mapPaymentResult(subscriptionPaymentRootResponse);
        String str = errors != null ? (String) CollectionsKt___CollectionsKt.firstOrNull(errors) : null;
        if (str == null) {
            str = "";
        }
        return new SubscriptionPaymentStatus(mapPaymentResult, str);
    }
}
