package com.talabat.helpers;

import androidx.fragment.app.FragmentActivity;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEvents;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/lifecycle/ContextLifecycleEvents;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoadingIndicatorKt$showLoading$1 extends Lambda implements Function1<ContextLifecycleEvents, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f60787g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadingIndicatorKt$showLoading$1(FragmentActivity fragmentActivity) {
        super(1);
        this.f60787g = fragmentActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContextLifecycleEvents) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContextLifecycleEvents contextLifecycleEvents) {
        Intrinsics.checkNotNullParameter(contextLifecycleEvents, "$this$withLifecycleEvents");
        ContextLifecycleEvents on2 = contextLifecycleEvents.getOn();
        final FragmentActivity fragmentActivity = this.f60787g;
        on2.pause(new Function0<Unit>() {
            public final void invoke() {
                LoadingIndicatorKt.hideLoading(fragmentActivity);
            }
        });
    }
}
