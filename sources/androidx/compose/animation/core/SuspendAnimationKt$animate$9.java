package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SuspendAnimationKt$animate$9 extends Lambda implements Function1<Long, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<AnimationScope<T, V>> f1394g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f1395h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animation<T, V> f1396i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AnimationState<T, V> f1397j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<AnimationScope<T, V>, Unit> f1398k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendAnimationKt$animate$9(Ref.ObjectRef<AnimationScope<T, V>> objectRef, float f11, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        super(1);
        this.f1394g = objectRef;
        this.f1395h = f11;
        this.f1396i = animation;
        this.f1397j = animationState;
        this.f1398k = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j11) {
        T t11 = this.f1394g.element;
        Intrinsics.checkNotNull(t11);
        SuspendAnimationKt.doAnimationFrameWithScale((AnimationScope) t11, j11, this.f1395h, this.f1396i, this.f1397j, this.f1398k);
    }
}
