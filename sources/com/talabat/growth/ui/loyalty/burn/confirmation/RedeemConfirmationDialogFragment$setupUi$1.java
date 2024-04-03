package com.talabat.growth.ui.loyalty.burn.confirmation;

import android.content.Context;
import com.integration.IntegrationAppTracker;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment;
import com.talabat.growth.ui.util.ExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RedeemConfirmationDialogFragment$setupUi$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RedeemConfirmationDialogFragment f60624g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedeemConfirmationDialogFragment$setupUi$1(RedeemConfirmationDialogFragment redeemConfirmationDialogFragment) {
        super(0);
        this.f60624g = redeemConfirmationDialogFragment;
    }

    public final void invoke() {
        this.f60624g.closeBottomSheet();
        Context context = this.f60624g.getContext();
        if (context != null) {
            IntegrationAppTracker.Companion.onRedeemPageOpen(context, LoyaltyDashboardFragment.GA_SCREEN_NAME, ExtentionsKt.decimalFormat(this.f60624g.getViewModel().getRemainingPoints()));
        }
    }
}
