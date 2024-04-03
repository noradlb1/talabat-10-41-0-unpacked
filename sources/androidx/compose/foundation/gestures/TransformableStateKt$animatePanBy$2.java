package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import o.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animatePanBy$2", f = "TransformableState.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
public final class TransformableStateKt$animatePanBy$2 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2347h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f2348i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f2349j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Offset> f2350k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransformableStateKt$animatePanBy$2(Ref.LongRef longRef, long j11, AnimationSpec<Offset> animationSpec, Continuation<? super TransformableStateKt$animatePanBy$2> continuation) {
        super(2, continuation);
        this.f2348i = longRef;
        this.f2349j = j11;
        this.f2350k = animationSpec;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TransformableStateKt$animatePanBy$2 transformableStateKt$animatePanBy$2 = new TransformableStateKt$animatePanBy$2(this.f2348i, this.f2349j, this.f2350k, continuation);
        transformableStateKt$animatePanBy$2.L$0 = obj;
        return transformableStateKt$animatePanBy$2;
    }

    @Nullable
    public final Object invoke(@NotNull TransformScope transformScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TransformableStateKt$animatePanBy$2) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2347h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final TransformScope transformScope = (TransformScope) this.L$0;
            AnimationState animationState = new AnimationState(VectorConvertersKt.getVectorConverter(Offset.Companion), Offset.m2665boximpl(this.f2348i.element), (AnimationVector) null, 0, 0, false, 60, (DefaultConstructorMarker) null);
            Offset r42 = Offset.m2665boximpl(this.f2349j);
            AnimationSpec<Offset> animationSpec = this.f2350k;
            final Ref.LongRef longRef = this.f2348i;
            AnonymousClass1 r72 = new Function1<AnimationScope<Offset, AnimationVector2D>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AnimationScope<Offset, AnimationVector2D>) (AnimationScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull AnimationScope<Offset, AnimationVector2D> animationScope) {
                    Intrinsics.checkNotNullParameter(animationScope, "$this$animateTo");
                    d.a(transformScope, 0.0f, Offset.m2680minusMKHz9U(animationScope.getValue().m2686unboximpl(), longRef.element), 0.0f, 5, (Object) null);
                    longRef.element = animationScope.getValue().m2686unboximpl();
                }
            };
            this.f2347h = 1;
            if (SuspendAnimationKt.animateTo$default(animationState, r42, animationSpec, false, r72, this, 4, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
