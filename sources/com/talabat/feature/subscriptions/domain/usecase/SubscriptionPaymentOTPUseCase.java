package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH¦Bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/SubscriptionPaymentOTPUseCase;", "", "invoke", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "planId", "", "cardTokenId", "deliveryFee", "orderId", "paymentMethodId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SubscriptionPaymentOTPUseCase {
    @Nullable
    Object invoke(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, @NotNull Continuation<? super SubscriptionOTPPaymentStatus> continuation);
}
