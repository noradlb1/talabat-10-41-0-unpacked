package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/core/AnimationScope;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$settleAppBar$2 extends Lambda implements Function1<AnimationScope<Float, AnimationVector1D>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f6550g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TopAppBarState f6551h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f6552i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$settleAppBar$2(Ref.FloatRef floatRef, TopAppBarState topAppBarState, Ref.FloatRef floatRef2) {
        super(1);
        this.f6550g = floatRef;
        this.f6551h = topAppBarState;
        this.f6552i = floatRef2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope<Float, AnimationVector1D>) (AnimationScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
        Intrinsics.checkNotNullParameter(animationScope, "$this$animateDecay");
        float floatValue = animationScope.getValue().floatValue() - this.f6550g.element;
        float heightOffset = this.f6551h.getHeightOffset();
        this.f6551h.setHeightOffset(heightOffset + floatValue);
        float abs = Math.abs(heightOffset - this.f6551h.getHeightOffset());
        this.f6550g.element = animationScope.getValue().floatValue();
        this.f6552i.element = animationScope.getVelocity().floatValue();
        if (Math.abs(floatValue - abs) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }
}
