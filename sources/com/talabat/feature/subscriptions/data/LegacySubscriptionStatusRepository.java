package com.talabat.feature.subscriptions.data;

import buisnessmodels.Customer;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.subscriptions.domain.model.SubscriptionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u001fR(\u0010!\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\r8V@VX\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/talabat/feature/subscriptions/data/LegacySubscriptionStatusRepository;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "()V", "customer", "Lbuisnessmodels/Customer;", "getCustomer", "()Lbuisnessmodels/Customer;", "hasAnySubscription", "", "getHasAnySubscription", "()Z", "inactiveSubscriptions", "", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "getInactiveSubscriptions", "()Ljava/util/List;", "isFreeCoffeeEligible", "isTProCancellationPeriod", "isTProExpiredPeriod", "isTProUser", "mostRecentInactiveSubscription", "getMostRecentInactiveSubscription", "()Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "subscriptionSavings", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "getSubscriptionSavings", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "subscriptionsList", "getSubscriptionsList", "setSubscriptionsList", "(Ljava/util/List;)V", "value", "tProSubscriptionInfo", "getTProSubscriptionInfo", "setTProSubscriptionInfo", "(Lcom/talabat/feature/subscriptions/domain/model/Subscription;)V", "hasManagedSubscription", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacySubscriptionStatusRepository implements ISubscriptionStatusRepository {
    @NotNull
    private final MutableStateFlow<SubscriptionSavingsInfo> subscriptionSavings = StateFlowKt.MutableStateFlow(null);
    @Nullable
    private List<Subscription> subscriptionsList;

    private final Customer getCustomer() {
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    public boolean getHasAnySubscription() {
        Collection subscriptionsList2 = getSubscriptionsList();
        return !(subscriptionsList2 == null || subscriptionsList2.isEmpty());
    }

    @NotNull
    public List<Subscription> getInactiveSubscriptions() {
        ArrayList arrayList;
        List<Subscription> subscriptionsList2 = getSubscriptionsList();
        if (subscriptionsList2 != null) {
            arrayList = new ArrayList();
            for (Object next : subscriptionsList2) {
                if (!((Subscription) next).isActive()) {
                    arrayList.add(next);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.talabat.feature.subscriptions.domain.model.Subscription} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.subscriptions.domain.model.Subscription getMostRecentInactiveSubscription() {
        /*
            r6 = this;
            java.util.List r0 = r6.getInactiveSubscriptions()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x0012
            r0 = 0
            goto L_0x0047
        L_0x0012:
            java.lang.Object r1 = r0.next()
            boolean r2 = r0.hasNext()
            if (r2 != 0) goto L_0x001e
        L_0x001c:
            r0 = r1
            goto L_0x0047
        L_0x001e:
            r2 = r1
            com.talabat.feature.subscriptions.domain.model.Subscription r2 = (com.talabat.feature.subscriptions.domain.model.Subscription) r2
            org.threeten.bp.LocalDateTime r2 = r2.getEndDate()
            if (r2 != 0) goto L_0x0029
            org.threeten.bp.LocalDateTime r2 = org.threeten.bp.LocalDateTime.MIN
        L_0x0029:
            java.lang.Object r3 = r0.next()
            r4 = r3
            com.talabat.feature.subscriptions.domain.model.Subscription r4 = (com.talabat.feature.subscriptions.domain.model.Subscription) r4
            org.threeten.bp.LocalDateTime r4 = r4.getEndDate()
            if (r4 != 0) goto L_0x0038
            org.threeten.bp.LocalDateTime r4 = org.threeten.bp.LocalDateTime.MIN
        L_0x0038:
            int r5 = r2.compareTo(r4)
            if (r5 >= 0) goto L_0x0040
            r1 = r3
            r2 = r4
        L_0x0040:
            boolean r3 = r0.hasNext()
            if (r3 != 0) goto L_0x0029
            goto L_0x001c
        L_0x0047:
            com.talabat.feature.subscriptions.domain.model.Subscription r0 = (com.talabat.feature.subscriptions.domain.model.Subscription) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.LegacySubscriptionStatusRepository.getMostRecentInactiveSubscription():com.talabat.feature.subscriptions.domain.model.Subscription");
    }

    @NotNull
    public MutableStateFlow<SubscriptionSavingsInfo> getSubscriptionSavings() {
        return this.subscriptionSavings;
    }

    @Nullable
    public List<Subscription> getSubscriptionsList() {
        return this.subscriptionsList;
    }

    @Nullable
    public Subscription getTProSubscriptionInfo() {
        return getCustomer().tProSubscriptionInfo;
    }

    public boolean hasManagedSubscription() {
        boolean z11;
        SubscriptionType subscriptionType;
        if (isTProUser()) {
            return true;
        }
        Subscription tProSubscriptionInfo = getTProSubscriptionInfo();
        if (tProSubscriptionInfo == null || tProSubscriptionInfo.isActive()) {
            z11 = false;
        } else {
            z11 = true;
        }
        SubscriptionType subscriptionType2 = null;
        if (z11) {
            Subscription tProSubscriptionInfo2 = getTProSubscriptionInfo();
            if (tProSubscriptionInfo2 != null) {
                subscriptionType = tProSubscriptionInfo2.getType();
            } else {
                subscriptionType = null;
            }
            if (subscriptionType == SubscriptionType.GracePeriod) {
                return true;
            }
        }
        Subscription tProSubscriptionInfo3 = getTProSubscriptionInfo();
        if (tProSubscriptionInfo3 != null) {
            subscriptionType2 = tProSubscriptionInfo3.getType();
        }
        if (subscriptionType2 == SubscriptionType.BillingRetryPeriod) {
            return true;
        }
        return false;
    }

    public boolean isFreeCoffeeEligible() {
        Boolean isFreeCoffeeEligible = getCustomer().isFreeCoffeeEligible();
        Intrinsics.checkNotNullExpressionValue(isFreeCoffeeEligible, "customer.isFreeCoffeeEligible");
        return isFreeCoffeeEligible.booleanValue();
    }

    public boolean isTProCancellationPeriod() {
        Subscription tProSubscriptionInfo = getTProSubscriptionInfo();
        if (tProSubscriptionInfo == null || !tProSubscriptionInfo.isActive() || tProSubscriptionInfo.isAutorenewable()) {
            return false;
        }
        return true;
    }

    public boolean isTProExpiredPeriod() {
        return !isTProUser() && getMostRecentInactiveSubscription() != null;
    }

    public boolean isTProUser() {
        Boolean isTPro = getCustomer().isTPro();
        Intrinsics.checkNotNullExpressionValue(isTPro, "customer.isTPro");
        return isTPro.booleanValue();
    }

    public void setSubscriptionsList(@Nullable List<Subscription> list) {
        this.subscriptionsList = list;
    }

    public void setTProSubscriptionInfo(@Nullable Subscription subscription) {
        getCustomer().tProSubscriptionInfo = subscription;
    }
}
