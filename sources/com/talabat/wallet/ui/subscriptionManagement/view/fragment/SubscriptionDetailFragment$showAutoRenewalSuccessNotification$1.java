package com.talabat.wallet.ui.subscriptionManagement.view.fragment;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.localization.R;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionDetailFragment$showAutoRenewalSuccessNotification$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubscriptionDetailFragment f12732g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionDetailFragment$showAutoRenewalSuccessNotification$1(SubscriptionDetailFragment subscriptionDetailFragment) {
        super(0);
        this.f12732g = subscriptionDetailFragment;
    }

    public final void invoke() {
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = this.f12732g.getActivity();
        String string = this.f12732g.getString(R.string.auto_renew_enabled_success_message);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…_enabled_success_message)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.SUCCESS, 26, (Object) null);
    }
}
