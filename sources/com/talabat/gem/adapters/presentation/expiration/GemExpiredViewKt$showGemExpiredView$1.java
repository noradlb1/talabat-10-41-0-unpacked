package com.talabat.gem.adapters.presentation.expiration;

import android.content.Context;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.ports.logging.LoggerPort;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEvents;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/lifecycle/ContextLifecycleEvents;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemExpiredViewKt$showGemExpiredView$1 extends Lambda implements Function1<ContextLifecycleEvents, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Boolean> f60057g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f60058h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f60059i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f60060j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemExpiredViewKt$showGemExpiredView$1(Function0<Boolean> function0, Context context, Function0<Unit> function02, boolean z11) {
        super(1);
        this.f60057g = function0;
        this.f60058h = context;
        this.f60059i = function02;
        this.f60060j = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContextLifecycleEvents) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContextLifecycleEvents contextLifecycleEvents) {
        Intrinsics.checkNotNullParameter(contextLifecycleEvents, "$this$withLifecycleEvents");
        ContextLifecycleEvents on2 = contextLifecycleEvents.getOn();
        final Function0<Boolean> function0 = this.f60057g;
        final Context context = this.f60058h;
        final Function0<Unit> function02 = this.f60059i;
        final boolean z11 = this.f60060j;
        on2.resume(new Function0<Unit>() {
            public final void invoke() {
                if (function0.invoke().booleanValue()) {
                    GemExpiredViewKt.displayAlert(context, function02, z11);
                }
            }
        });
        contextLifecycleEvents.getOn().error(new Function1<Throwable, Unit>(IntegrationKt.getLogger()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((LoggerPort) this.receiver).logError(th2);
            }
        });
    }
}
