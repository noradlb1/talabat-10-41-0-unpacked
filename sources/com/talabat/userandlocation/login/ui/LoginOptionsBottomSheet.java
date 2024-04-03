package com.talabat.userandlocation.login.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.designsystem.ds_bottom_sheet.DSBottomSheet;
import com.designsystem.ds_button.DSSocialButton;
import com.talabat.growth.ui.lifecyclevoucher.LoginLifecycleVoucherView;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.userandlocation.login.R;
import com.talabat.userandlocation.login.databinding.LayoutLoginOptionsBinding;
import com.talabat.userandlocation.login.ui.activity.EmailLoginActivity;
import hx.a;
import hx.b;
import hx.c;
import hx.d;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\nH\u0002J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001b\u001a\u00020\nJ\b\u0010\u001c\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/userandlocation/login/ui/LoginOptionsBottomSheet;", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet$FragmentListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "requestCode", "", "shouldEnableGuestLogin", "Lkotlin/Function0;", "", "onGuestLoginRequestedListener", "", "onCancel", "(Landroidx/appcompat/app/AppCompatActivity;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "bottomSheet", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "getBottomSheet", "()Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "bottomSheet$delegate", "Lkotlin/Lazy;", "dismissManually", "getView", "view", "Landroid/view/View;", "hideImageIfSmallDevice", "viewBinding", "Lcom/talabat/userandlocation/login/databinding/LayoutLoginOptionsBinding;", "setupContinueWithEmailButton", "show", "showGuestLogin", "Companion", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginOptionsBottomSheet implements DSBottomSheet.FragmentListener {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int SMALLER_DEVICE_SCREEN_HEIGHT = 600;
    @NotNull
    @Deprecated
    public static final String TAG = "LoginOptionsBottomSheet";
    @NotNull
    private final AppCompatActivity activity;
    @NotNull
    private final Lazy bottomSheet$delegate;
    @NotNull
    private final Function0<Unit> onCancel;
    @NotNull
    private final Function0<Unit> onGuestLoginRequestedListener;
    private final int requestCode;
    @NotNull
    private final Function0<Boolean> shouldEnableGuestLogin;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/login/ui/LoginOptionsBottomSheet$Companion;", "", "()V", "SMALLER_DEVICE_SCREEN_HEIGHT", "", "TAG", "", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoginOptionsBottomSheet(@NotNull AppCompatActivity appCompatActivity, int i11) {
        this(appCompatActivity, i11, (Function0) null, (Function0) null, (Function0) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoginOptionsBottomSheet(@NotNull AppCompatActivity appCompatActivity, int i11, @NotNull Function0<Boolean> function0) {
        this(appCompatActivity, i11, function0, (Function0) null, (Function0) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(function0, "shouldEnableGuestLogin");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoginOptionsBottomSheet(@NotNull AppCompatActivity appCompatActivity, int i11, @NotNull Function0<Boolean> function0, @NotNull Function0<Unit> function02) {
        this(appCompatActivity, i11, function0, function02, (Function0) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(function0, "shouldEnableGuestLogin");
        Intrinsics.checkNotNullParameter(function02, "onGuestLoginRequestedListener");
    }

    @JvmOverloads
    public LoginOptionsBottomSheet(@NotNull AppCompatActivity appCompatActivity, int i11, @NotNull Function0<Boolean> function0, @NotNull Function0<Unit> function02, @NotNull Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(function0, "shouldEnableGuestLogin");
        Intrinsics.checkNotNullParameter(function02, "onGuestLoginRequestedListener");
        Intrinsics.checkNotNullParameter(function03, "onCancel");
        this.activity = appCompatActivity;
        this.requestCode = i11;
        this.shouldEnableGuestLogin = function0;
        this.onGuestLoginRequestedListener = function02;
        this.onCancel = function03;
        this.bottomSheet$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new LoginOptionsBottomSheet$bottomSheet$2(this));
    }

    private final void dismissManually() {
        getBottomSheet().dismiss();
        getBottomSheet().setOnDismiss((Runnable) null);
    }

    private final DSBottomSheet getBottomSheet() {
        return (DSBottomSheet) this.bottomSheet$delegate.getValue();
    }

    private final void hideImageIfSmallDevice(LayoutLoginOptionsBinding layoutLoginOptionsBinding) {
        if (this.activity.getResources().getConfiguration().screenHeightDp <= 600) {
            layoutLoginOptionsBinding.imageView.setVisibility(8);
            ConstraintLayout constraintLayout = layoutLoginOptionsBinding.containerTitleDescription;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "viewBinding.containerTitleDescription");
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                int i11 = R.id.textLogoText;
                layoutParams2.topToBottom = i11;
                layoutParams2.startToStart = i11;
                constraintLayout.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    private final void setupContinueWithEmailButton(LayoutLoginOptionsBinding layoutLoginOptionsBinding) {
        DSSocialButton dSSocialButton = layoutLoginOptionsBinding.btnLoginWithEmail;
        Drawable drawable = ContextCompat.getDrawable(this.activity, com.designsystem.marshmallow.R.drawable.ds_email_filled);
        if (drawable != null) {
            DrawableCompat.setTint(drawable, ContextCompat.getColor(this.activity, com.designsystem.marshmallow.R.color.ds_primary_100));
        } else {
            drawable = null;
        }
        dSSocialButton.setIcon(drawable);
        layoutLoginOptionsBinding.btnLoginWithEmail.setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupContinueWithEmailButton$lambda-6  reason: not valid java name */
    public static final void m5920setupContinueWithEmailButton$lambda6(LoginOptionsBottomSheet loginOptionsBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(loginOptionsBottomSheet, "this$0");
        LogManager.info("ALOV LoginOptionsBottomSheet: setupContinueWithEmailButton :: click on continue with Email");
        loginOptionsBottomSheet.activity.startActivityForResult(new Intent(loginOptionsBottomSheet.activity, EmailLoginActivity.class), loginOptionsBottomSheet.requestCode);
        loginOptionsBottomSheet.dismissManually();
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-0  reason: not valid java name */
    public static final void m5921show$lambda0(LoginOptionsBottomSheet loginOptionsBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(loginOptionsBottomSheet, "this$0");
        loginOptionsBottomSheet.onGuestLoginRequestedListener.invoke();
        loginOptionsBottomSheet.getBottomSheet().dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-1  reason: not valid java name */
    public static final void m5922show$lambda1(LoginOptionsBottomSheet loginOptionsBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(loginOptionsBottomSheet, "this$0");
        loginOptionsBottomSheet.getBottomSheet().dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-2  reason: not valid java name */
    public static final void m5923show$lambda2(LoginOptionsBottomSheet loginOptionsBottomSheet) {
        Intrinsics.checkNotNullParameter(loginOptionsBottomSheet, "this$0");
        loginOptionsBottomSheet.onCancel.invoke();
    }

    private final void showGuestLogin() {
        View view;
        TextView textView;
        if (this.shouldEnableGuestLogin.invoke().booleanValue() && (view = getBottomSheet().getView()) != null && (textView = (TextView) view.findViewById(com.designsystem.marshmallow.R.id.bsh_end_text)) != null) {
            textView.setText(com.talabat.localization.R.string.login_screen_guest_btn_text);
            textView.setVisibility(0);
        }
    }

    public void getView(@Nullable View view) {
        if (view != null) {
            LayoutLoginOptionsBinding bind = LayoutLoginOptionsBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(it)");
            LoginLifecycleVoucherView loginLifecycleVoucherView = bind.lifeCycleVoucherLoginInfoView;
            ConstraintLayout constraintLayout = bind.containerImageAndDescription;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "layoutLoginOptionsBindin…tainerImageAndDescription");
            loginLifecycleVoucherView.init(constraintLayout);
            setupContinueWithEmailButton(bind);
            hideImageIfSmallDevice(bind);
            showGuestLogin();
        }
    }

    public final void show() {
        getBottomSheet().setHeaderEndTextOnClick(new a(this));
        getBottomSheet().setHeaderStartIconOnClickListener(new b(this));
        getBottomSheet().setOnDismiss(new c(this));
        getBottomSheet().showNow(this.activity.getSupportFragmentManager(), TAG);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoginOptionsBottomSheet(AppCompatActivity appCompatActivity, int i11, Function0 function0, Function0 function02, Function0 function03, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(appCompatActivity, i11, (i12 & 4) != 0 ? AnonymousClass1.INSTANCE : function0, (i12 & 8) != 0 ? AnonymousClass2.INSTANCE : function02, (i12 & 16) != 0 ? AnonymousClass3.INSTANCE : function03);
    }
}
