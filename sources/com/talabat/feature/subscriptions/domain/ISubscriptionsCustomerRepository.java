package com.talabat.feature.subscriptions.domain;

import com.talabat.feature.subscriptions.domain.model.Subscription;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J!\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "", "clearSubscriptionInfo", "", "saveProStatus", "isPro", "", "showPro", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "saveSubscriptionInfo", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISubscriptionsCustomerRepository {
    void clearSubscriptionInfo();

    void saveProStatus(@Nullable Boolean bool, @Nullable Boolean bool2);

    void saveSubscriptionInfo(@NotNull Subscription subscription);
}
