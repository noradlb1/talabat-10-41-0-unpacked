package com.talabat.userandlocation.login.ui.fragment;

import androidx.fragment.app.FragmentActivity;
import com.talabat.userandlocation.login.di.factory.EnterPasswordViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/userandlocation/login/di/factory/EnterPasswordViewModelFactory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterPasswordFragment$factory$2 extends Lambda implements Function0<EnterPasswordViewModelFactory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EnterPasswordFragment f12418g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterPasswordFragment$factory$2(EnterPasswordFragment enterPasswordFragment) {
        super(0);
        this.f12418g = enterPasswordFragment;
    }

    @NotNull
    public final EnterPasswordViewModelFactory invoke() {
        EnterPasswordViewModelFactory.Companion companion = EnterPasswordViewModelFactory.Companion;
        FragmentActivity requireActivity = this.f12418g.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return companion.newInstance(requireActivity);
    }
}
