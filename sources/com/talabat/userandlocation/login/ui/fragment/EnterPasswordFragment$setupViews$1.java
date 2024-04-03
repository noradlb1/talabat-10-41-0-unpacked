package com.talabat.userandlocation.login.ui.fragment;

import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.talabat.userandlocation.login.databinding.FragmentEnterPasswordBinding;
import com.talabat.userandlocation.login.presentation.viewmodel.EnterPasswordViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterPasswordFragment$setupViews$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EnterPasswordFragment f12420g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterPasswordFragment$setupViews$1(EnterPasswordFragment enterPasswordFragment) {
        super(0);
        this.f12420g = enterPasswordFragment;
    }

    public final void invoke() {
        EnterPasswordViewModel access$getViewModel = this.f12420g.getViewModel();
        FragmentEnterPasswordBinding access$getBinding$p = this.f12420g.binding;
        FragmentEnterPasswordBinding fragmentEnterPasswordBinding = null;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getViewModel.onLogInClicked(access$getBinding$p.edtPassword.getText());
        EnterPasswordFragment enterPasswordFragment = this.f12420g;
        FragmentEnterPasswordBinding access$getBinding$p2 = enterPasswordFragment.binding;
        if (access$getBinding$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentEnterPasswordBinding = access$getBinding$p2;
        }
        DSPrimaryButton dSPrimaryButton = fragmentEnterPasswordBinding.btnLogIn;
        Intrinsics.checkNotNullExpressionValue(dSPrimaryButton, "binding.btnLogIn");
        enterPasswordFragment.hideKeyboard(dSPrimaryButton);
    }
}
