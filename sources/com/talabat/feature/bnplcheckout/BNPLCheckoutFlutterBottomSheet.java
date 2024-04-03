package com.talabat.feature.bnplcheckout;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ll.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/bnplcheckout/BNPLCheckoutFlutterBottomSheet;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "planId", "", "amount", "isChangeCardClicked", "", "isPaymentFallbackFlow", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/String;ZZ)V", "bottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "getBottomSheet$annotations", "()V", "getBottomSheet", "()Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "setBottomSheet", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;)V", "show", "", "showInNativeBottomSheet", "showWithoutNativeBottomSheet", "Companion", "com_talabat_feature_bnpl-checkout_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLCheckoutFlutterBottomSheet {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String TAG = "BNPLCheckoutFlutterBottomSheet";
    @NotNull
    private final AppCompatActivity activity;
    @NotNull
    private final String amount;
    @NotNull
    private DSBottomSheet bottomSheet;
    private final boolean isChangeCardClicked;
    private final boolean isPaymentFallbackFlow;
    @NotNull
    private final String planId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/bnplcheckout/BNPLCheckoutFlutterBottomSheet$Companion;", "", "()V", "TAG", "", "com_talabat_feature_bnpl-checkout_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BNPLCheckoutFlutterBottomSheet(@NotNull AppCompatActivity appCompatActivity, @NotNull String str, @NotNull String str2, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "amount");
        this.activity = appCompatActivity;
        this.planId = str;
        this.amount = str2;
        this.isChangeCardClicked = z11;
        this.isPaymentFallbackFlow = z12;
        DSBottomSheet dSBottomSheet = new DSBottomSheet();
        this.bottomSheet = dSBottomSheet;
        BNPLCheckoutFlutterFragment bNPLCheckoutFlutterFragment = new BNPLCheckoutFlutterFragment();
        bNPLCheckoutFlutterFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA, str), TuplesKt.to("amount", str2), TuplesKt.to(BNPLCheckoutFlutterFragment.IS_CHANGE_CARD_CTA_CLICKED, Boolean.valueOf(z11)), TuplesKt.to(BNPLCheckoutFlutterFragment.IS_PAYMENT_FALLBACK_FLOW, Boolean.valueOf(z12)), TuplesKt.to(BNPLCheckoutFlutterBottomSheetKt.ARGS_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED, Boolean.valueOf(z12))));
        dSBottomSheet.setBody(bNPLCheckoutFlutterFragment);
    }

    @VisibleForTesting
    public static /* synthetic */ void getBottomSheet$annotations() {
    }

    private final void showInNativeBottomSheet() {
        this.bottomSheet.showNow(this.activity.getSupportFragmentManager(), TAG);
        this.bottomSheet.getChildFragmentManager().setFragmentResultListener(BNPLCheckoutFlutterFragment.REQUEST_KEY, this.bottomSheet.getViewLifecycleOwner(), new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: showInNativeBottomSheet$lambda-1  reason: not valid java name */
    public static final void m10140showInNativeBottomSheet$lambda1(BNPLCheckoutFlutterBottomSheet bNPLCheckoutFlutterBottomSheet, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(bNPLCheckoutFlutterBottomSheet, "this$0");
        Intrinsics.checkNotNullParameter(str, "requestKey");
        Intrinsics.checkNotNullParameter(bundle, "result");
        bNPLCheckoutFlutterBottomSheet.bottomSheet.dismiss();
        bNPLCheckoutFlutterBottomSheet.bottomSheet.getParentFragmentManager().setFragmentResult(BNPLCheckoutFlutterFragment.REQUEST_KEY, bundle);
    }

    private final void showWithoutNativeBottomSheet() {
        Fragment body = this.bottomSheet.getBody();
        if (body != null) {
            this.activity.getSupportFragmentManager().beginTransaction().replace(16908290, body).commit();
        }
    }

    @NotNull
    public final DSBottomSheet getBottomSheet() {
        return this.bottomSheet;
    }

    public final void setBottomSheet(@NotNull DSBottomSheet dSBottomSheet) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "<set-?>");
        this.bottomSheet = dSBottomSheet;
    }

    public final void show() {
        if (this.isPaymentFallbackFlow) {
            showWithoutNativeBottomSheet();
        } else {
            showInNativeBottomSheet();
        }
    }
}
