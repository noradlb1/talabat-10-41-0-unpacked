package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$getAnimatedOffset$1", f = "LazyGridItemPlacementAnimator.kt", i = {}, l = {324}, m = "invokeSuspend", n = {}, s = {})
public final class LazyGridItemPlacementAnimator$getAnimatedOffset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f2891h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PlaceableInfo f2892i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridItemPlacementAnimator$getAnimatedOffset$1(PlaceableInfo placeableInfo, Continuation<? super LazyGridItemPlacementAnimator$getAnimatedOffset$1> continuation) {
        super(2, continuation);
        this.f2892i = placeableInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LazyGridItemPlacementAnimator$getAnimatedOffset$1(this.f2892i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LazyGridItemPlacementAnimator$getAnimatedOffset$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2891h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<IntOffset, AnimationVector2D> animatedOffset = this.f2892i.getAnimatedOffset();
            IntOffset r12 = IntOffset.m5587boximpl(this.f2892i.m735getTargetOffsetnOccac());
            this.f2891h = 1;
            if (animatedOffset.snapTo(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f2892i.setInProgress(false);
        return Unit.INSTANCE;
    }
}
