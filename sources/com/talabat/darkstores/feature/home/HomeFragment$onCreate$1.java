package com.talabat.darkstores.feature.home;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$onCreate$1 extends Lambda implements Function1<OnBackPressedCallback, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56397g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$onCreate$1(HomeFragment homeFragment) {
        super(1);
        this.f56397g = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OnBackPressedCallback) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "$this$addCallback");
        FragmentActivity activity = this.f56397g.getActivity();
        if (activity != null) {
            this.f56397g.getViewModel().onBackPressed(activity);
        }
    }
}
