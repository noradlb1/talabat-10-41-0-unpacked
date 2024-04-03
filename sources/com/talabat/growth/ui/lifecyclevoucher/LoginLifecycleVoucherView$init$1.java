package com.talabat.growth.ui.lifecyclevoucher;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.talabat.growth.databinding.LoginInfoContainerLifecycleVoucherInfoBinding;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcore.exception.Failure;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "flagValue", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoginLifecycleVoucherView$init$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LoginLifecycleVoucherView f60582g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ View f60583h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginLifecycleVoucherView$init$1(LoginLifecycleVoucherView loginLifecycleVoucherView, View view) {
        super(1);
        this.f60582g = loginLifecycleVoucherView;
        this.f60583h = view;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3$lambda-2$lambda-0  reason: not valid java name */
    public static final void m10596invoke$lambda3$lambda2$lambda0(LoginLifecycleVoucherView loginLifecycleVoucherView, LoginLifecycleVoucherDisplayModel loginLifecycleVoucherDisplayModel) {
        Intrinsics.checkNotNullParameter(loginLifecycleVoucherView, "this$0");
        LoginInfoContainerLifecycleVoucherInfoBinding loginInfoContainerLifecycleVoucherInfoBinding = loginLifecycleVoucherView.binding.lifeCycleVoucherLoginInfo;
        Intrinsics.checkNotNullExpressionValue(loginInfoContainerLifecycleVoucherInfoBinding, "binding.lifeCycleVoucherLoginInfo");
        Intrinsics.checkNotNullExpressionValue(loginLifecycleVoucherDisplayModel, "it");
        loginLifecycleVoucherView.bindLifecycleVoucherView(loginInfoContainerLifecycleVoucherInfoBinding, loginLifecycleVoucherDisplayModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3$lambda-2$lambda-1  reason: not valid java name */
    public static final void m10597invoke$lambda3$lambda2$lambda1(View view, LoginLifecycleVoucherView loginLifecycleVoucherView, Failure failure) {
        Intrinsics.checkNotNullParameter(view, "$defaultLoginInfo");
        Intrinsics.checkNotNullParameter(loginLifecycleVoucherView, "this$0");
        ViewKt.crossFade(view, loginLifecycleVoucherView);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        if (z11) {
            LoginLifecycleVoucherViewModel access$getViewModel$p = this.f60582g.viewModel;
            LoginLifecycleVoucherView loginLifecycleVoucherView = this.f60582g;
            View view = this.f60583h;
            access$getViewModel$p.getWelcomeVoucherData$com_talabat_NewArchi_GrowthSquad_GrowthSquad();
            LifecycleOwner access$getLifeCycleOwner = loginLifecycleVoucherView.getLifeCycleOwner();
            if (access$getLifeCycleOwner != null) {
                access$getViewModel$p.getVoucherDataLiveData().observe(access$getLifeCycleOwner, new a(loginLifecycleVoucherView));
                access$getViewModel$p.getFailureData().observe(access$getLifeCycleOwner, new b(view, loginLifecycleVoucherView));
                return;
            }
            return;
        }
        ViewKt.crossFade(this.f60583h, this.f60582g);
    }
}
