package androidx.compose.ui.platform;

import androidx.compose.runtime.MonotonicFrameClockKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000H@"}, d2 = {"R", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.platform.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2", f = "InfiniteAnimationPolicy.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
public final class InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2 extends SuspendLambda implements Function1<Continuation<? super R>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f10040h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Long, R> f10041i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2(Function1<? super Long, ? extends R> function1, Continuation<? super InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2> continuation) {
        super(1, continuation);
        this.f10041i = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2(this.f10041i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super R> continuation) {
        return ((InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f10040h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Long, R> function1 = this.f10041i;
            this.f10040h = 1;
            obj = MonotonicFrameClockKt.withFrameNanos(function1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
