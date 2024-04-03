package coil.util;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"await", "Lokhttp3/Response;", "Lokhttp3/Call;", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "-Calls")
/* renamed from: coil.util.-Calls  reason: invalid class name */
public final class Calls {
    @Nullable
    public static final Object await(@NotNull Call call, @NotNull Continuation<? super Response> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ContinuationCallback continuationCallback = new ContinuationCallback(call, cancellableContinuationImpl);
        FirebasePerfOkHttpClient.enqueue(call, continuationCallback);
        cancellableContinuationImpl.invokeOnCancellation(continuationCallback);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private static final Object await$$forInline(Call call, Continuation<? super Response> continuation) {
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ContinuationCallback continuationCallback = new ContinuationCallback(call, cancellableContinuationImpl);
        FirebasePerfOkHttpClient.enqueue(call, continuationCallback);
        cancellableContinuationImpl.invokeOnCancellation(continuationCallback);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }
}
