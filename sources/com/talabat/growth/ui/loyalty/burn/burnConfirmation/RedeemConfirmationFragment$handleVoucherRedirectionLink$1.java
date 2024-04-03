package com.talabat.growth.ui.loyalty.burn.burnConfirmation;

import android.content.Context;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.views.CouponCodeView;
import com.talabat.growth.ui.util.ExtentionsKt;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RedeemConfirmationFragment$handleVoucherRedirectionLink$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RedeemConfirmationFragment f60595g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f60596h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedeemConfirmationFragment$handleVoucherRedirectionLink$1(RedeemConfirmationFragment redeemConfirmationFragment, String str) {
        super(0);
        this.f60595g = redeemConfirmationFragment;
        this.f60596h = str;
    }

    public final void invoke() {
        Object obj;
        RedeemConfirmationFragment redeemConfirmationFragment = this.f60595g;
        String str = this.f60596h;
        try {
            Result.Companion companion = Result.Companion;
            ((CouponCodeView) redeemConfirmationFragment._$_findCachedViewById(R.id.couponCodeView)).copyCodeToClipboard();
            Context requireContext = redeemConfirmationFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ExtentionsKt.openLinkInBrowser(str, requireContext);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        RedeemConfirmationFragment redeemConfirmationFragment2 = this.f60595g;
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            String string = redeemConfirmationFragment2.getResources().getString(com.talabat.localization.R.string.sorry_something_went_wrong);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…rry_something_went_wrong)");
            Status.Companion.notify$default(Status.Companion, redeemConfirmationFragment2.getActivity(), (NestedScrollView) redeemConfirmationFragment2._$_findCachedViewById(R.id.redeemBodyRelativeLayout), string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
        }
    }
}
