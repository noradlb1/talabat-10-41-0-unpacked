package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.IntOffset;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1", f = "LazyListItemPlacementAnimator.kt", i = {}, l = {400}, m = "invokeSuspend", n = {}, s = {})
public final class LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f2740h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PlaceableInfo f2741i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FiniteAnimationSpec<IntOffset> f2742j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(PlaceableInfo placeableInfo, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Continuation<? super LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1> continuation) {
        super(2, continuation);
        this.f2741i = placeableInfo;
        this.f2742j = finiteAnimationSpec;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(this.f2741i, this.f2742j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AnimationSpec animationSpec;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2740h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f2741i.getAnimatedOffset().isRunning()) {
                FiniteAnimationSpec<IntOffset> finiteAnimationSpec = this.f2742j;
                if (finiteAnimationSpec instanceof SpringSpec) {
                    animationSpec = (SpringSpec) finiteAnimationSpec;
                } else {
                    animationSpec = LazyListItemPlacementAnimatorKt.InterruptionSpec;
                }
            } else {
                animationSpec = this.f2742j;
            }
            AnimationSpec animationSpec2 = animationSpec;
            Animatable<IntOffset, AnimationVector2D> animatedOffset = this.f2741i.getAnimatedOffset();
            IntOffset r42 = IntOffset.m5587boximpl(this.f2741i.m652getTargetOffsetnOccac());
            this.f2740h = 1;
            if (Animatable.animateTo$default(animatedOffset, r42, animationSpec2, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException unused) {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f2741i.setInProgress(false);
        return Unit.INSTANCE;
    }
}
