package com.talabat.userandlocation.login.ui.fragment;

import com.talabat.userandlocation.login.databinding.FragmentEnterEmailBinding;
import com.talabat.userandlocation.login.presentation.viewmodel.EnterEmailViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterEmailFragment$setupViews$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EnterEmailFragment f12406g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterEmailFragment$setupViews$1(EnterEmailFragment enterEmailFragment) {
        super(0);
        this.f12406g = enterEmailFragment;
    }

    public final void invoke() {
        EnterEmailViewModel access$getViewModel = this.f12406g.getViewModel();
        FragmentEnterEmailBinding access$getBinding$p = this.f12406g.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getViewModel.onNextButtonClicked(access$getBinding$p.edtEmail.getText());
    }
}
