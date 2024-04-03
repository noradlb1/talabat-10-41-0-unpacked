package com.talabat.growth.ui.loyalty.burn.details;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.integration.IntegrationAppTracker;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsDialogFragment$setupView$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BurnOptionsDetailsDialogFragment f60632g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BurnOptionsDetailsDialogFragment$setupView$3(BurnOptionsDetailsDialogFragment burnOptionsDetailsDialogFragment) {
        super(0);
        this.f60632g = burnOptionsDetailsDialogFragment;
    }

    public final void invoke() {
        Context context = this.f60632g.getContext();
        if (context != null) {
            IntegrationAppTracker.Companion.onRedeemPageOpen(context, LoyaltyDashboardFragment.GA_SCREEN_NAME, String.valueOf(this.f60632g.getViewModel().getTotalPoints()));
        }
        FragmentActivity activity = this.f60632g.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
