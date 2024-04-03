package com.talabat.userandlocation.login.ui.fragment;

import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.talabat.userandlocation.login.databinding.FragmentEnterPasswordBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterPasswordFragment$setupViews$4$2 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EnterPasswordFragment f12425g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterPasswordFragment$setupViews$4$2(EnterPasswordFragment enterPasswordFragment) {
        super(1);
        this.f12425g = enterPasswordFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.f12425g.getViewModel().onLogInClicked(str);
        EnterPasswordFragment enterPasswordFragment = this.f12425g;
        FragmentEnterPasswordBinding access$getBinding$p = enterPasswordFragment.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        DSPrimaryButton dSPrimaryButton = access$getBinding$p.btnLogIn;
        Intrinsics.checkNotNullExpressionValue(dSPrimaryButton, "binding.btnLogIn");
        enterPasswordFragment.hideKeyboard(dSPrimaryButton);
    }
}
