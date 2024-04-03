package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/core/AnimationScope;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnapFlingBehaviorKt$animateDecay$2 extends Lambda implements Function1<AnimationScope<Float, AnimationVector1D>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f2386g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f2387h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ScrollScope f2388i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapFlingBehaviorKt$animateDecay$2(float f11, Ref.FloatRef floatRef, ScrollScope scrollScope) {
        super(1);
        this.f2386g = f11;
        this.f2387h = floatRef;
        this.f2388i = scrollScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope<Float, AnimationVector1D>) (AnimationScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
        Intrinsics.checkNotNullParameter(animationScope, "$this$animateDecay");
        if (Math.abs(animationScope.getValue().floatValue()) >= Math.abs(this.f2386g)) {
            SnapFlingBehaviorKt.animateDecay$consumeDelta(animationScope, this.f2388i, SnapFlingBehaviorKt.coerceToTarget(animationScope.getValue().floatValue(), this.f2386g) - this.f2387h.element);
            animationScope.cancelAnimation();
            return;
        }
        SnapFlingBehaviorKt.animateDecay$consumeDelta(animationScope, this.f2388i, animationScope.getValue().floatValue() - this.f2387h.element);
        this.f2387h.element = animationScope.getValue().floatValue();
    }
}
