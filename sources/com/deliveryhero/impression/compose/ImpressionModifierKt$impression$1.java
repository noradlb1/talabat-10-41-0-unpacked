package com.deliveryhero.impression.compose;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u000b"}, d2 = {"Landroidx/compose/ui/Modifier;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ImpressionModifierKt$impression$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f30322g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f30323h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ComposeImpressionTracker f30324i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImpressionModifierKt$impression$1(int i11, Integer num, ComposeImpressionTracker composeImpressionTracker) {
        super(3);
        this.f30322g = i11;
        this.f30323h = num;
        this.f30324i = composeImpressionTracker;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-1615080436);
        Integer valueOf = Integer.valueOf(this.f30322g);
        final Integer num = this.f30323h;
        final ComposeImpressionTracker composeImpressionTracker = this.f30324i;
        final int i12 = this.f30322g;
        EffectsKt.DisposableEffect(valueOf, num, new Function1<DisposableEffectScope, DisposableEffectResult>() {
            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                return new ImpressionModifierKt$impression$1$1$invoke$$inlined$onDispose$1(composeImpressionTracker, i12, num);
            }
        }, composer, 0);
        final View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        final ComposeImpressionTracker composeImpressionTracker2 = this.f30324i;
        final int i13 = this.f30322g;
        final Integer num2 = this.f30323h;
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, new Function1<LayoutCoordinates, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinate");
                if (!layoutCoordinates.isAttached()) {
                    composeImpressionTracker2.onItemDisposed$impression_tracking_release(i13, num2);
                    return;
                }
                Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
                android.graphics.Rect rect = new android.graphics.Rect();
                view.getGlobalVisibleRect(rect);
                composeImpressionTracker2.m8230onItemLayoutCoordinatesChange03bzQGs$impression_tracking_release(layoutCoordinates.m4473getSizeYbymL2g(), boundsInWindow, RectHelper_androidKt.toComposeRect(rect), i13, num2);
            }
        });
        composer.endReplaceableGroup();
        return onGloballyPositioned;
    }
}
