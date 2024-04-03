package com.talabat.feature.subscriptions.domain;

import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\b\u0010\u001f\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0012\u0010\r\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u0004\u0018\u00010\bX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "", "hasAnySubscription", "", "getHasAnySubscription", "()Z", "inactiveSubscriptions", "", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "getInactiveSubscriptions", "()Ljava/util/List;", "isFreeCoffeeEligible", "isTProCancellationPeriod", "isTProExpiredPeriod", "isTProUser", "mostRecentInactiveSubscription", "getMostRecentInactiveSubscription", "()Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "subscriptionSavings", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "getSubscriptionSavings", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "subscriptionsList", "getSubscriptionsList", "setSubscriptionsList", "(Ljava/util/List;)V", "tProSubscriptionInfo", "getTProSubscriptionInfo", "setTProSubscriptionInfo", "(Lcom/talabat/feature/subscriptions/domain/model/Subscription;)V", "hasManagedSubscription", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISubscriptionStatusRepository {
    boolean getHasAnySubscription();

    @NotNull
    List<Subscription> getInactiveSubscriptions();

    @Nullable
    Subscription getMostRecentInactiveSubscription();

    @NotNull
    MutableStateFlow<SubscriptionSavingsInfo> getSubscriptionSavings();

    @Nullable
    List<Subscription> getSubscriptionsList();

    @Nullable
    Subscription getTProSubscriptionInfo();

    boolean hasManagedSubscription();

    boolean isFreeCoffeeEligible();

    boolean isTProCancellationPeriod();

    boolean isTProExpiredPeriod();

    boolean isTProUser();

    void setSubscriptionsList(@Nullable List<Subscription> list);

    void setTProSubscriptionInfo(@Nullable Subscription subscription);
}
