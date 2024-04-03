package com.talabat.userandlocation.login.ui.fragment;

import android.content.Context;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.userandlocation.ForgotPasswordActions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterPasswordFragment$setupViews$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EnterPasswordFragment f12421g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterPasswordFragment$setupViews$2(EnterPasswordFragment enterPasswordFragment) {
        super(0);
        this.f12421g = enterPasswordFragment;
    }

    public final void invoke() {
        Navigator.Companion companion = Navigator.Companion;
        Context requireContext = this.f12421g.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.navigate(requireContext, ForgotPasswordActions.INSTANCE.createOpenScreenModel());
    }
}
