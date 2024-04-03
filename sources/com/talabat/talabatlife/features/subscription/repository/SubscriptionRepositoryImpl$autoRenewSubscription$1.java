package com.talabat.talabatlife.features.subscription.repository;

import com.talabat.talabatlife.features.subscription.model.response.AutoRenewSubscriptionResponse;
import com.talabat.talabatlife.ui.subscriptionManagement.model.AutoRenewSubscriptionDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/ui/subscriptionManagement/model/AutoRenewSubscriptionDisplayModel;", "it", "Lcom/talabat/talabatlife/features/subscription/model/response/AutoRenewSubscriptionResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionRepositoryImpl$autoRenewSubscription$1 extends Lambda implements Function1<AutoRenewSubscriptionResponse, AutoRenewSubscriptionDisplayModel> {
    public static final SubscriptionRepositoryImpl$autoRenewSubscription$1 INSTANCE = new SubscriptionRepositoryImpl$autoRenewSubscription$1();

    public SubscriptionRepositoryImpl$autoRenewSubscription$1() {
        super(1);
    }

    @NotNull
    public final AutoRenewSubscriptionDisplayModel invoke(@NotNull AutoRenewSubscriptionResponse autoRenewSubscriptionResponse) {
        Intrinsics.checkNotNullParameter(autoRenewSubscriptionResponse, "it");
        return new AutoRenewSubscriptionDisplayModel();
    }
}
