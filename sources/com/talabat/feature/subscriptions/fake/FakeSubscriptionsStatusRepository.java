package com.talabat.feature.subscriptions.fake;

import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\t8VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/talabat/feature/subscriptions/fake/FakeSubscriptionsStatusRepository;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "()V", "hasAnySubscription", "", "getHasAnySubscription", "()Z", "inactiveSubscriptions", "", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "getInactiveSubscriptions", "()Ljava/util/List;", "isFreeCoffeeEligible", "isTProCancellationPeriod", "isTProExpiredPeriod", "isTProUser", "mostRecentInactiveSubscription", "getMostRecentInactiveSubscription", "()Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "subscriptionSavings", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "getSubscriptionSavings", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "subscriptionsList", "getSubscriptionsList", "setSubscriptionsList", "(Ljava/util/List;)V", "tProSubscriptionInfo", "getTProSubscriptionInfo", "setTProSubscriptionInfo", "(Lcom/talabat/feature/subscriptions/domain/model/Subscription;)V", "hasManagedSubscription", "com_talabat_feature_subscriptions_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeSubscriptionsStatusRepository implements ISubscriptionStatusRepository {
    @Nullable
    private List<Subscription> subscriptionsList;
    @Nullable
    private Subscription tProSubscriptionInfo;

    public boolean getHasAnySubscription() {
        return true;
    }

    @NotNull
    public List<Subscription> getInactiveSubscriptions() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    @Nullable
    public Subscription getMostRecentInactiveSubscription() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    @NotNull
    public MutableStateFlow<SubscriptionSavingsInfo> getSubscriptionSavings() {
        return StateFlowKt.MutableStateFlow(null);
    }

    @Nullable
    public List<Subscription> getSubscriptionsList() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    @Nullable
    public Subscription getTProSubscriptionInfo() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public boolean hasManagedSubscription() {
        return false;
    }

    public boolean isFreeCoffeeEligible() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public boolean isTProCancellationPeriod() {
        return false;
    }

    public boolean isTProExpiredPeriod() {
        return false;
    }

    public boolean isTProUser() {
        return true;
    }

    public void setSubscriptionsList(@Nullable List<Subscription> list) {
        this.subscriptionsList = list;
    }

    public void setTProSubscriptionInfo(@Nullable Subscription subscription) {
        this.tProSubscriptionInfo = subscription;
    }
}
