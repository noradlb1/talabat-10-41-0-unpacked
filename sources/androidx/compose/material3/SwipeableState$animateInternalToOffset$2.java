package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Landroidx/compose/foundation/gestures/DragScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.material3.SwipeableState$animateInternalToOffset$2", f = "Swipeable.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
public final class SwipeableState$animateInternalToOffset$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f8438h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f8439i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f8440j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f8441k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableState$animateInternalToOffset$2(SwipeableState<T> swipeableState, float f11, AnimationSpec<Float> animationSpec, Continuation<? super SwipeableState$animateInternalToOffset$2> continuation) {
        super(2, continuation);
        this.f8439i = swipeableState;
        this.f8440j = f11;
        this.f8441k = animationSpec;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SwipeableState$animateInternalToOffset$2 swipeableState$animateInternalToOffset$2 = new SwipeableState$animateInternalToOffset$2(this.f8439i, this.f8440j, this.f8441k, continuation);
        swipeableState$animateInternalToOffset$2.L$0 = obj;
        return swipeableState$animateInternalToOffset$2;
    }

    @Nullable
    public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SwipeableState$animateInternalToOffset$2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f8438h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final DragScope dragScope = (DragScope) this.L$0;
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            floatRef.element = ((Number) this.f8439i.absoluteOffset.getValue()).floatValue();
            this.f8439i.animationTarget.setValue(Boxing.boxFloat(this.f8440j));
            this.f8439i.setAnimationRunning(true);
            Animatable Animatable$default = AnimatableKt.Animatable$default(floatRef.element, 0.0f, 2, (Object) null);
            Float boxFloat = Boxing.boxFloat(this.f8440j);
            AnimationSpec<Float> animationSpec = this.f8441k;
            AnonymousClass1 r82 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Animatable<Float, AnimationVector1D>) (Animatable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Animatable<Float, AnimationVector1D> animatable) {
                    Intrinsics.checkNotNullParameter(animatable, "$this$animateTo");
                    dragScope.dragBy(animatable.getValue().floatValue() - floatRef.element);
                    floatRef.element = animatable.getValue().floatValue();
                }
            };
            this.f8438h = 1;
            if (Animatable.animateTo$default(Animatable$default, boxFloat, animationSpec, (Object) null, r82, this, 4, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                this.f8439i.animationTarget.setValue(null);
                this.f8439i.setAnimationRunning(false);
                throw th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f8439i.animationTarget.setValue(null);
        this.f8439i.setAnimationRunning(false);
        return Unit.INSTANCE;
    }
}
