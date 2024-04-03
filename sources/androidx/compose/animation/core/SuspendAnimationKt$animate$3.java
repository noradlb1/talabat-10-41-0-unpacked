package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/AnimationScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SuspendAnimationKt$animate$3 extends Lambda implements Function1<AnimationScope<T, V>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<T, T, Unit> f1377g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TwoWayConverter<T, V> f1378h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendAnimationKt$animate$3(Function2<? super T, ? super T, Unit> function2, TwoWayConverter<T, V> twoWayConverter) {
        super(1);
        this.f1377g = function2;
        this.f1378h = twoWayConverter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AnimationScope<T, V> animationScope) {
        Intrinsics.checkNotNullParameter(animationScope, "$this$animate");
        this.f1377g.invoke(animationScope.getValue(), this.f1378h.getConvertFromVector().invoke(animationScope.getVelocityVector()));
    }
}
