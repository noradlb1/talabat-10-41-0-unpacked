package com.talabat.feature.tpro.presentation.management.cancellation.reason;

import com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationReasonBottomSheetFragment$addButtonsListeners$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationReasonBottomSheetFragment f59296g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionCancellationReasonBottomSheetFragment$addButtonsListeners$1$1$1(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment) {
        super(0);
        this.f59296g = subscriptionCancellationReasonBottomSheetFragment;
    }

    public final void invoke() {
        SubscriptionCancellationReasonBottomSheetFragment.SubscriptionCancellationReasonBottomSheetInterface access$getMSubscriptionCancellationReasonBottomSheetInterface$p = this.f59296g.mSubscriptionCancellationReasonBottomSheetInterface;
        if (access$getMSubscriptionCancellationReasonBottomSheetInterface$p != null) {
            access$getMSubscriptionCancellationReasonBottomSheetInterface$p.onReasonSubmitSuccess();
        }
        this.f59296g.dismiss();
    }
}
