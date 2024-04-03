package com.talabat.talabatcommon.feature.subscriptionManagement.repository;

import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationFeedbackResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackResponse;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementRepositoryImpl$postSubscriptionCancellationFeedback$1 extends Lambda implements Function1<SubscriptionCancellationFeedbackResponse, SubscriptionCancellationFeedbackResponse> {
    public static final SubscriptionManagementRepositoryImpl$postSubscriptionCancellationFeedback$1 INSTANCE = new SubscriptionManagementRepositoryImpl$postSubscriptionCancellationFeedback$1();

    public SubscriptionManagementRepositoryImpl$postSubscriptionCancellationFeedback$1() {
        super(1);
    }

    @NotNull
    public final SubscriptionCancellationFeedbackResponse invoke(@NotNull SubscriptionCancellationFeedbackResponse subscriptionCancellationFeedbackResponse) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationFeedbackResponse, "it");
        return subscriptionCancellationFeedbackResponse;
    }
}
