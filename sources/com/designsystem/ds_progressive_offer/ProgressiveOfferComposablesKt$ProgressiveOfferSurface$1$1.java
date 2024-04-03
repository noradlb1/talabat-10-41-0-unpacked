package com.designsystem.ds_progressive_offer;

import android.os.CountDownTimer;
import androidx.compose.runtime.MutableState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt$ProgressiveOfferSurface$1$1 extends Lambda implements Function2<LifecycleOwner, Lifecycle.Event, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<CountDownTimer> f32511g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$ProgressiveOfferSurface$1$1(MutableState<CountDownTimer> mutableState) {
        super(2);
        this.f32511g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LifecycleOwner) obj, (Lifecycle.Event) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        CountDownTimer r22;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "$noName_0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY && (r22 = ProgressiveOfferComposablesKt.m8535ProgressiveOfferSurface$lambda8(this.f32511g)) != null) {
            r22.cancel();
        }
    }
}
