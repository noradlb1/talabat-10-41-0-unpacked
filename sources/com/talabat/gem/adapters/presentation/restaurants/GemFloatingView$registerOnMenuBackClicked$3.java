package com.talabat.gem.adapters.presentation.restaurants;

import android.content.Intent;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.ports.logging.LoggerPort;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import com.talabat.talabatcommon.extentions.RxKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemFloatingView$registerOnMenuBackClicked$3 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemFloatingViewModel f60321g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemFloatingView f60322h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFloatingView$registerOnMenuBackClicked$3(GemFloatingViewModel gemFloatingViewModel, GemFloatingView gemFloatingView) {
        super(1);
        this.f60321g = gemFloatingViewModel;
        this.f60322h = gemFloatingView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Intent intent) {
        AnonymousClass1 r32 = new Function1<Throwable, Unit>(IntegrationKt.getLogger()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((LoggerPort) this.receiver).logError(th2);
            }
        };
        final GemFloatingView gemFloatingView = this.f60322h;
        CoroutinesKt.runHandling(r32, new Function0<Unit>() {
            public final void invoke() {
                gemFloatingView.onCancelledAction.invoke();
            }
        });
        if (Intrinsics.areEqual(RxKt.invoke(this.f60321g.getVisibility()), (Object) Boolean.TRUE) && RxKt.invoke(this.f60321g.getMode()) != GemMode.DISABLED) {
            GemFloatingView gemFloatingView2 = this.f60322h;
            gemFloatingView2.openOffers(gemFloatingView2);
        }
    }
}
