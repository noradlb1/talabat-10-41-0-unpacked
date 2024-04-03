package coil.decode;

import coil.annotation.InternalCoilApi;
import java.io.InterruptedIOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\fHHø\u0001\u0000¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"FINISHED", "", "INTERRUPTED", "INTERRUPTING", "PENDING", "UNINTERRUPTIBLE", "WORKING", "withInterruptibleSource", "T", "source", "Lokio/Source;", "block", "Lkotlin/Function1;", "(Lokio/Source;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class InterruptibleSourceKt {
    private static final int FINISHED = 2;
    private static final int INTERRUPTED = 5;
    private static final int INTERRUPTING = 4;
    private static final int PENDING = 3;
    private static final int UNINTERRUPTIBLE = 1;
    private static final int WORKING = 0;

    @InternalCoilApi
    @Nullable
    public static final <T> Object withInterruptibleSource(@NotNull Source source, @NotNull Function1<? super Source, ? extends T> function1, @NotNull Continuation<? super T> continuation) {
        InterruptibleSource interruptibleSource;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        try {
            interruptibleSource = new InterruptibleSource(cancellableContinuationImpl, source);
            cancellableContinuationImpl.resumeWith(Result.m6329constructorimpl(function1.invoke(interruptibleSource)));
            InlineMarker.finallyStart(1);
            interruptibleSource.clearInterrupt();
            InlineMarker.finallyEnd(1);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (Exception e11) {
            if ((e11 instanceof InterruptedException) || (e11 instanceof InterruptedIOException)) {
                Throwable initCause = new CancellationException("Blocking call was interrupted due to parent cancellation.").initCause(e11);
                Intrinsics.checkNotNullExpressionValue(initCause, "CancellationException(\"B…n.\").initCause(exception)");
                throw initCause;
            }
            throw e11;
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            interruptibleSource.clearInterrupt();
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    @InternalCoilApi
    private static final <T> Object withInterruptibleSource$$forInline(Source source, Function1<? super Source, ? extends T> function1, Continuation<? super T> continuation) {
        InterruptibleSource interruptibleSource;
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        try {
            interruptibleSource = new InterruptibleSource(cancellableContinuationImpl, source);
            cancellableContinuationImpl.resumeWith(Result.m6329constructorimpl(function1.invoke(interruptibleSource)));
            InlineMarker.finallyStart(1);
            interruptibleSource.clearInterrupt();
            InlineMarker.finallyEnd(1);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark(1);
            return result;
        } catch (Exception e11) {
            if ((e11 instanceof InterruptedException) || (e11 instanceof InterruptedIOException)) {
                Throwable initCause = new CancellationException("Blocking call was interrupted due to parent cancellation.").initCause(e11);
                Intrinsics.checkNotNullExpressionValue(initCause, "CancellationException(\"B…n.\").initCause(exception)");
                throw initCause;
            }
            throw e11;
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            interruptibleSource.clearInterrupt();
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }
}
