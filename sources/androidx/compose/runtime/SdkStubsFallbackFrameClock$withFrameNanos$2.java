package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.runtime.SdkStubsFallbackFrameClock$withFrameNanos$2", f = "ActualAndroid.android.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class SdkStubsFallbackFrameClock$withFrameNanos$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f9219h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Long, R> f9220i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SdkStubsFallbackFrameClock$withFrameNanos$2(Function1<? super Long, ? extends R> function1, Continuation<? super SdkStubsFallbackFrameClock$withFrameNanos$2> continuation) {
        super(2, continuation);
        this.f9220i = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SdkStubsFallbackFrameClock$withFrameNanos$2(this.f9220i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super R> continuation) {
        return ((SdkStubsFallbackFrameClock$withFrameNanos$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f9219h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f9219h = 1;
            if (DelayKt.delay(16, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return this.f9220i.invoke(Boxing.boxLong(System.nanoTime()));
    }
}
