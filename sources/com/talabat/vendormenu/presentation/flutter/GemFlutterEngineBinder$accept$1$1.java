package com.talabat.vendormenu.presentation.flutter;

import android.content.IntentFilter;
import androidx.fragment.app.FragmentActivity;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEvents;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEventsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemFlutterEngineBinder$accept$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f12427g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemFlutterEngineBinder f12428h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFlutterEngineBinder$accept$1$1(FragmentActivity fragmentActivity, GemFlutterEngineBinder gemFlutterEngineBinder) {
        super(0);
        this.f12427g = fragmentActivity;
        this.f12428h = gemFlutterEngineBinder;
    }

    public final void invoke() {
        final FragmentActivity fragmentActivity = this.f12427g;
        final GemFlutterEngineBinder gemFlutterEngineBinder = this.f12428h;
        ContextLifecycleEventsKt.withLifecycleEvents(fragmentActivity, new Function1<ContextLifecycleEvents, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContextLifecycleEvents) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContextLifecycleEvents contextLifecycleEvents) {
                Intrinsics.checkNotNullParameter(contextLifecycleEvents, "$this$withLifecycleEvents");
                ContextLifecycleEvents on2 = contextLifecycleEvents.getOn();
                final FragmentActivity fragmentActivity = fragmentActivity;
                final GemFlutterEngineBinder gemFlutterEngineBinder = gemFlutterEngineBinder;
                on2.resume(new Function0<Unit>() {
                    public final void invoke() {
                        fragmentActivity.registerReceiver(gemFlutterEngineBinder.gemBroadcastReceiver, new IntentFilter("com.talabat.gem.domain.usecases.ACTION_GEM_STATUS"));
                    }
                });
                ContextLifecycleEvents on3 = contextLifecycleEvents.getOn();
                final FragmentActivity fragmentActivity2 = fragmentActivity;
                final GemFlutterEngineBinder gemFlutterEngineBinder2 = gemFlutterEngineBinder;
                on3.destroy(new Function0<Unit>() {
                    public final void invoke() {
                        fragmentActivity2.unregisterReceiver(gemFlutterEngineBinder2.gemBroadcastReceiver);
                    }
                });
            }
        });
    }
}
