package kotlinx.coroutines;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CoroutineExceptionHandlerImplKt {
    @NotNull
    private static final List<CoroutineExceptionHandler> handlers;

    static {
        Class<CoroutineExceptionHandler> cls = CoroutineExceptionHandler.class;
        handlers = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final void handleCoroutineExceptionImpl(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th2) {
        for (CoroutineExceptionHandler handleException : handlers) {
            try {
                handleException.handleException(coroutineContext, th2);
            } catch (Throwable th3) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, CoroutineExceptionHandlerKt.handlerException(th2, th3));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        try {
            Result.Companion companion = Result.Companion;
            ExceptionsKt__ExceptionsKt.addSuppressed(th2, new DiagnosticCoroutineContextException(coroutineContext));
            Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th4) {
            Result.Companion companion2 = Result.Companion;
            Result.m6329constructorimpl(ResultKt.createFailure(th4));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th2);
    }
}
