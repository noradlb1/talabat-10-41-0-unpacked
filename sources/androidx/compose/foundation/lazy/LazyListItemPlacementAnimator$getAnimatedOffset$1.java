package androidx.compose.foundation.lazy;

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
@DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$getAnimatedOffset$1", f = "LazyListItemPlacementAnimator.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, s = {})
public final class LazyListItemPlacementAnimator$getAnimatedOffset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f2738h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PlaceableInfo f2739i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyListItemPlacementAnimator$getAnimatedOffset$1(PlaceableInfo placeableInfo, Continuation<? super LazyListItemPlacementAnimator$getAnimatedOffset$1> continuation) {
        super(2, continuation);
        this.f2739i = placeableInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LazyListItemPlacementAnimator$getAnimatedOffset$1(this.f2739i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LazyListItemPlacementAnimator$getAnimatedOffset$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2738h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<IntOffset, AnimationVector2D> animatedOffset = this.f2739i.getAnimatedOffset();
            IntOffset r12 = IntOffset.m5587boximpl(this.f2739i.m652getTargetOffsetnOccac());
            this.f2738h = 1;
            if (animatedOffset.snapTo(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f2739i.setInProgress(false);
        return Unit.INSTANCE;
    }
}
