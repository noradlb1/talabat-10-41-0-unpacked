package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SwipeableKt$rememberSwipeableStateFor$1", f = "Swipeable.kt", i = {}, l = {512}, m = "invokeSuspend", n = {}, s = {})
public final class SwipeableKt$rememberSwipeableStateFor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f8399h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ T f8400i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f8401j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableKt$rememberSwipeableStateFor$1(T t11, SwipeableState<T> swipeableState, Continuation<? super SwipeableKt$rememberSwipeableStateFor$1> continuation) {
        super(2, continuation);
        this.f8400i = t11;
        this.f8401j = swipeableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SwipeableKt$rememberSwipeableStateFor$1(this.f8400i, this.f8401j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SwipeableKt$rememberSwipeableStateFor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f8399h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Intrinsics.areEqual((Object) this.f8400i, (Object) this.f8401j.getCurrentValue())) {
                SwipeableState<T> swipeableState = this.f8401j;
                T t11 = this.f8400i;
                this.f8399h = 1;
                if (SwipeableState.animateTo$material3_release$default(swipeableState, t11, (AnimationSpec) null, this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
