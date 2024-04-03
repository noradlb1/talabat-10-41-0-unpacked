package com.talabat.feature.subscriptions.fake;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus;
import com.talabat.feature.subscriptions.domain.usecase.SubscriptionPaymentOTPUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J9\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rHBø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/subscriptions/fake/FakeSubscriptionPaymentOTPUseCase;", "Lcom/talabat/feature/subscriptions/domain/usecase/SubscriptionPaymentOTPUseCase;", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;)V", "invoke", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "planId", "", "cardTokenId", "deliveryFee", "orderId", "paymentMethodId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_subscriptions_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeSubscriptionPaymentOTPUseCase implements SubscriptionPaymentOTPUseCase {
    @NotNull
    private final ISubscriptionsRepository repository;

    @Inject
    public FakeSubscriptionPaymentOTPUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        this.repository = iSubscriptionsRepository;
    }

    @Nullable
    public Object invoke(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, @NotNull Continuation<? super SubscriptionOTPPaymentStatus> continuation) {
        System.out.println("com.talabat.feature.subscriptions.fake.FakeGetTProOrderStatusUseCase.invoke()");
        return new SubscriptionOTPPaymentStatus(false, (String) null, "", "", "", 2, (DefaultConstructorMarker) null);
    }
}
