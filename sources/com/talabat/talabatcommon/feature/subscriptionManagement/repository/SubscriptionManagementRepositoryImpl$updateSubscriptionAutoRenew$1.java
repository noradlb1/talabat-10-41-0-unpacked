package com.talabat.talabatcommon.feature.subscriptionManagement.repository;

import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewUpdateResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewUpdateResponse;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementRepositoryImpl$updateSubscriptionAutoRenew$1 extends Lambda implements Function1<SubscriptionAutoRenewUpdateResponse, SubscriptionAutoRenewUpdateResponse> {
    public static final SubscriptionManagementRepositoryImpl$updateSubscriptionAutoRenew$1 INSTANCE = new SubscriptionManagementRepositoryImpl$updateSubscriptionAutoRenew$1();

    public SubscriptionManagementRepositoryImpl$updateSubscriptionAutoRenew$1() {
        super(1);
    }

    @NotNull
    public final SubscriptionAutoRenewUpdateResponse invoke(@NotNull SubscriptionAutoRenewUpdateResponse subscriptionAutoRenewUpdateResponse) {
        Intrinsics.checkNotNullParameter(subscriptionAutoRenewUpdateResponse, "it");
        return subscriptionAutoRenewUpdateResponse;
    }
}
