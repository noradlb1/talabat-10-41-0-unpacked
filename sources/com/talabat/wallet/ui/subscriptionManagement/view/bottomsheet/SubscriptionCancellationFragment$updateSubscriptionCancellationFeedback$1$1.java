package com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet;

import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationFragment$updateSubscriptionCancellationFeedback$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationFragment f12730g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionCancellationFragment$updateSubscriptionCancellationFeedback$1$1(SubscriptionCancellationFragment subscriptionCancellationFragment) {
        super(0);
        this.f12730g = subscriptionCancellationFragment;
    }

    public final void invoke() {
        SubscriptionCancellationFragment.SubscriptionCancellationFragmentInterface access$getMSubscriptionCancellationFragmentInterface$p = this.f12730g.mSubscriptionCancellationFragmentInterface;
        if (access$getMSubscriptionCancellationFragmentInterface$p != null) {
            access$getMSubscriptionCancellationFragmentInterface$p.onBottomSheetClosed();
        }
    }
}
