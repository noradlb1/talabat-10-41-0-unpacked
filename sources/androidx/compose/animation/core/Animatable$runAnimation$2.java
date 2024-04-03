package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001H@"}, d2 = {"T", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/AnimationResult;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.animation.core.Animatable$runAnimation$2", f = "Animatable.kt", i = {0, 0}, l = {291}, m = "invokeSuspend", n = {"endState", "clampingNeeded"}, s = {"L$0", "L$1"})
public final class Animatable$runAnimation$2 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<T, V>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f1279h;

    /* renamed from: i  reason: collision with root package name */
    public Object f1280i;

    /* renamed from: j  reason: collision with root package name */
    public int f1281j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Animatable<T, V> f1282k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ T f1283l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Animation<T, V> f1284m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f1285n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function1<Animatable<T, V>, Unit> f1286o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Animatable$runAnimation$2(Animatable<T, V> animatable, T t11, Animation<T, V> animation, long j11, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super Animatable$runAnimation$2> continuation) {
        super(1, continuation);
        this.f1282k = animatable;
        this.f1283l = t11;
        this.f1284m = animation;
        this.f1285n = j11;
        this.f1286o = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new Animatable$runAnimation$2(this.f1282k, this.f1283l, this.f1284m, this.f1285n, this.f1286o, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super AnimationResult<T, V>> continuation) {
        return ((Animatable$runAnimation$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AnimationState animationState;
        Ref.BooleanRef booleanRef;
        AnimationEndReason animationEndReason;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1281j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f1282k.getInternalState$animation_core_release().setVelocityVector$animation_core_release((AnimationVector) this.f1282k.getTypeConverter().getConvertToVector().invoke(this.f1283l));
            this.f1282k.setTargetValue(this.f1284m.getTargetValue());
            this.f1282k.setRunning(true);
            final AnimationState copy$default = AnimationStateKt.copy$default((AnimationState) this.f1282k.getInternalState$animation_core_release(), (Object) null, (AnimationVector) null, 0, Long.MIN_VALUE, false, 23, (Object) null);
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            Animation<T, V> animation = this.f1284m;
            long j11 = this.f1285n;
            final Animatable<T, V> animatable = this.f1282k;
            final Function1<Animatable<T, V>, Unit> function1 = this.f1286o;
            AnonymousClass1 r62 = new Function1<AnimationScope<T, V>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AnimationScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull AnimationScope<T, V> animationScope) {
                    Intrinsics.checkNotNullParameter(animationScope, "$this$animate");
                    SuspendAnimationKt.updateState(animationScope, animatable.getInternalState$animation_core_release());
                    Object access$clampToBounds = animatable.clampToBounds(animationScope.getValue());
                    if (!Intrinsics.areEqual(access$clampToBounds, (Object) animationScope.getValue())) {
                        animatable.getInternalState$animation_core_release().setValue$animation_core_release(access$clampToBounds);
                        copy$default.setValue$animation_core_release(access$clampToBounds);
                        Function1<Animatable<T, V>, Unit> function1 = function1;
                        if (function1 != null) {
                            function1.invoke(animatable);
                        }
                        animationScope.cancelAnimation();
                        booleanRef2.element = true;
                        return;
                    }
                    Function1<Animatable<T, V>, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(animatable);
                    }
                }
            };
            this.f1279h = copy$default;
            this.f1280i = booleanRef2;
            this.f1281j = 1;
            if (SuspendAnimationKt.animate(copy$default, animation, j11, r62, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            animationState = copy$default;
            booleanRef = booleanRef2;
        } else if (i11 == 1) {
            booleanRef = (Ref.BooleanRef) this.f1280i;
            animationState = (AnimationState) this.f1279h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException e11) {
                this.f1282k.endAnimation();
                throw e11;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (booleanRef.element) {
            animationEndReason = AnimationEndReason.BoundReached;
        } else {
            animationEndReason = AnimationEndReason.Finished;
        }
        this.f1282k.endAnimation();
        return new AnimationResult(animationState, animationEndReason);
    }
}
