package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SuspendAnimationKt$animate$6 extends Lambda implements Function1<Long, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<AnimationScope<T, V>> f1385g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ T f1386h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animation<T, V> f1387i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ V f1388j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AnimationState<T, V> f1389k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f1390l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function1<AnimationScope<T, V>, Unit> f1391m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendAnimationKt$animate$6(Ref.ObjectRef<AnimationScope<T, V>> objectRef, T t11, Animation<T, V> animation, V v11, AnimationState<T, V> animationState, float f11, Function1<? super AnimationScope<T, V>, Unit> function1) {
        super(1);
        this.f1385g = objectRef;
        this.f1386h = t11;
        this.f1387i = animation;
        this.f1388j = v11;
        this.f1389k = animationState;
        this.f1390l = f11;
        this.f1391m = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j11) {
        Ref.ObjectRef<AnimationScope<T, V>> objectRef = this.f1385g;
        T t11 = this.f1386h;
        TwoWayConverter<T, V> typeConverter = this.f1387i.getTypeConverter();
        V v11 = this.f1388j;
        T targetValue = this.f1387i.getTargetValue();
        final AnimationState<T, V> animationState = this.f1389k;
        AnimationScope animationScope = new AnimationScope(t11, typeConverter, v11, j11, targetValue, j11, true, new Function0<Unit>() {
            public final void invoke() {
                animationState.setRunning$animation_core_release(false);
            }
        });
        SuspendAnimationKt.doAnimationFrameWithScale(animationScope, j11, this.f1390l, this.f1387i, this.f1389k, this.f1391m);
        objectRef.element = animationScope;
    }
}
