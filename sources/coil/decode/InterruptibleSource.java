package coil.decode;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import net.bytebuddy.implementation.MethodDelegation;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u00012#\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bB\u0019\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u0013\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcoil/decode/InterruptibleSource;", "Lokio/ForwardingSource;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "delegate", "Lokio/Source;", "(Lkotlinx/coroutines/CancellableContinuation;Lokio/Source;)V", "_state", "Ljava/util/concurrent/atomic/AtomicInteger;", "targetThread", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "clearInterrupt", "invalidState", "", "state", "", "invoke", "read", "", "sink", "Lokio/Buffer;", "byteCount", "setInterruptible", "interruptible", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@PublishedApi
public final class InterruptibleSource extends ForwardingSource implements Function1<Throwable, Unit> {
    @NotNull
    private final AtomicInteger _state;
    private final Thread targetThread = Thread.currentThread();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InterruptibleSource(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull Source source) {
        super(source);
        int i11;
        Intrinsics.checkNotNullParameter(cancellableContinuation, "continuation");
        Intrinsics.checkNotNullParameter(source, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        this._state = atomicInteger;
        cancellableContinuation.invokeOnCancellation(this);
        do {
            i11 = atomicInteger.get();
            if (i11 != 1) {
                if (i11 != 3 && i11 != 4 && i11 != 5) {
                    invalidState(i11);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!this._state.compareAndSet(i11, 1));
    }

    private final Void invalidState(int i11) {
        throw new IllegalStateException(Intrinsics.stringPlus("Illegal state: ", Integer.valueOf(i11)).toString());
    }

    private final void setInterruptible(boolean z11) {
        AtomicInteger atomicInteger = this._state;
        while (true) {
            int i11 = atomicInteger.get();
            if (i11 == 0 || i11 == 1) {
                if (this._state.compareAndSet(i11, true ^ z11 ? 1 : 0)) {
                    return;
                }
            } else if (i11 != 3) {
                if (i11 != 4) {
                    if (i11 == 5) {
                        Thread.interrupted();
                        return;
                    } else {
                        invalidState(i11);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (this._state.compareAndSet(i11, 4)) {
                this.targetThread.interrupt();
                this._state.set(5);
                return;
            }
        }
    }

    public final void clearInterrupt() {
        AtomicInteger atomicInteger = this._state;
        while (true) {
            int i11 = atomicInteger.get();
            if (i11 == 0 || i11 == 3) {
                if (this._state.compareAndSet(i11, 2)) {
                    return;
                }
            } else if (i11 != 4) {
                if (i11 == 5) {
                    Thread.interrupted();
                    return;
                } else {
                    invalidState(i11);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: finally extract failed */
    public long read(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        try {
            setInterruptible(false);
            long read = super.read(buffer, j11);
            setInterruptible(true);
            return read;
        } catch (Throwable th2) {
            setInterruptible(true);
            throw th2;
        }
    }

    public void invoke(@Nullable Throwable th2) {
        AtomicInteger atomicInteger = this._state;
        while (true) {
            int i11 = atomicInteger.get();
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2 && i11 != 3 && i11 != 4 && i11 != 5) {
                        invalidState(i11);
                        throw new KotlinNothingValueException();
                    }
                    return;
                } else if (this._state.compareAndSet(i11, 3)) {
                    return;
                }
            } else if (this._state.compareAndSet(i11, 4)) {
                this.targetThread.interrupt();
                this._state.set(5);
                return;
            }
        }
    }
}
