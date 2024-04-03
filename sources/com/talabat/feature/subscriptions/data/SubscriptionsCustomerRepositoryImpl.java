package com.talabat.feature.subscriptions.data;

import buisnessmodels.Customer;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J!\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/talabat/feature/subscriptions/data/SubscriptionsCustomerRepositoryImpl;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "()V", "clearSubscriptionInfo", "", "saveProStatus", "isPro", "", "showPro", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "saveSubscriptionInfo", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionsCustomerRepositoryImpl implements ISubscriptionsCustomerRepository {
    public void clearSubscriptionInfo() {
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        if (customerInfo != null) {
            customerInfo.tProSubscriptionInfo = null;
        }
        Customer.getInstance().tProSubscriptionInfo = null;
    }

    public void saveProStatus(@Nullable Boolean bool, @Nullable Boolean bool2) {
        Customer instance = Customer.getInstance();
        Boolean bool3 = Boolean.TRUE;
        instance.setPro(Intrinsics.areEqual((Object) bool, (Object) bool3));
        Customer.getInstance().setShowPro(Intrinsics.areEqual((Object) bool2, (Object) bool3));
    }

    public void saveSubscriptionInfo(@NotNull Subscription subscription) {
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        if (customerInfo != null) {
            customerInfo.tProSubscriptionInfo = subscription;
            customerInfo.minimOrderValueToEnableTproDiscount = subscription.getMinDeliveryFee();
        }
        Customer.getInstance().tProSubscriptionInfo = subscription;
        Customer.getInstance().minimOrderValueToEnableTproDiscount = subscription.getMinDeliveryFee();
    }
}
