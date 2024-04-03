package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v0.a;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001f\u0012\f\u0010u\u001a\b\u0012\u0004\u0012\u00028\u00000t\u0012\u0006\u0010-\u001a\u00020'¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0010\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\b¢\u0006\u0004\b\u0010\u0010\u0011JB\u0010\u0017\u001a\u00020\u000e2'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0012j\u0002`\u00152\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\bJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJB\u0010\"\u001a\u00020\u000e2'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0012j\u0002`\u00152\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\"\u0010#J8\u0010%\u001a\u00020$2'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0012j\u0002`\u0015H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*JZ\u00100\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010 2\u0006\u0010-\u001a\u00020'2#\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\b\u0010/\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b0\u00101JH\u00102\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010 2\u0006\u0010-\u001a\u00020'2%\b\u0002\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0002¢\u0006\u0004\b2\u00103JJ\u00105\u001a\u0004\u0018\u0001042\b\u0010,\u001a\u0004\u0018\u00010 2\b\u0010/\u001a\u0004\u0018\u00010 2#\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0002¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u0002072\b\u0010,\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000eH\u0002¢\u0006\u0004\b:\u0010\u001fJ\u000f\u0010;\u001a\u00020\u000eH\u0016¢\u0006\u0004\b;\u0010\u001fJ\u000f\u0010<\u001a\u00020\u0006H\u0001¢\u0006\u0004\b<\u0010\bJ\u0017\u0010?\u001a\n\u0018\u00010=j\u0004\u0018\u0001`>H\u0016¢\u0006\u0004\b?\u0010@J\u0011\u0010C\u001a\u0004\u0018\u00010 H\u0010¢\u0006\u0004\bA\u0010BJ!\u0010G\u001a\u00020\u000e2\b\u0010D\u001a\u0004\u0018\u00010 2\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\bE\u0010FJ\u0019\u0010H\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\bH\u0010\fJ\u0017\u0010K\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\bI\u0010JJ\u001f\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020$2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010LJ8\u0010M\u001a\u00020\u000e2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\bM\u0010\u0018J\u0017\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bP\u0010QJ\u0011\u0010R\u001a\u0004\u0018\u00010 H\u0001¢\u0006\u0004\bR\u0010BJ \u0010U\u001a\u00020\u000e2\f\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000SH\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ<\u0010X\u001a\u00020\u000e2\u0006\u0010W\u001a\u00028\u00002#\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0016¢\u0006\u0004\bX\u0010YJ8\u0010Z\u001a\u00020\u000e2'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0012j\u0002`\u0015H\u0016¢\u0006\u0004\bZ\u0010[J\u000f\u0010]\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\\\u0010\u001fJ#\u0010\u001a\u001a\u0004\u0018\u00010 2\u0006\u0010W\u001a\u00028\u00002\b\u0010/\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\u001a\u0010^JH\u0010\u001a\u001a\u0004\u0018\u00010 2\u0006\u0010W\u001a\u00028\u00002\b\u0010/\u001a\u0004\u0018\u00010 2#\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001a\u0010_J\u0019\u0010a\u001a\u0004\u0018\u00010 2\u0006\u0010`\u001a\u00020\tH\u0016¢\u0006\u0004\ba\u0010bJ\u0017\u0010d\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020 H\u0016¢\u0006\u0004\bd\u0010VJ\u001b\u0010f\u001a\u00020\u000e*\u00020e2\u0006\u0010W\u001a\u00028\u0000H\u0016¢\u0006\u0004\bf\u0010gJ\u001b\u0010h\u001a\u00020\u000e*\u00020e2\u0006\u0010`\u001a\u00020\tH\u0016¢\u0006\u0004\bh\u0010iJ\u001f\u0010l\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010!\u001a\u0004\u0018\u00010 H\u0010¢\u0006\u0004\bj\u0010kJ\u001b\u0010o\u001a\u0004\u0018\u00010\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0010¢\u0006\u0004\bm\u0010nJ\u000f\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020pH\u0014¢\u0006\u0004\bs\u0010rR \u0010u\u001a\b\u0012\u0004\u0012\u00028\u00000t8\u0000X\u0004¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u001a\u0010z\u001a\u00020y8\u0016X\u0004¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R\u0018\u0010~\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b~\u0010R\u0016\u0010\u0001\u001a\u00020p8BX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010rR\u0017\u0010!\u001a\u0004\u0018\u00010 8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010BR\u0016\u0010\u0001\u001a\u00020\u00068VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\bR\u0016\u0010\u0001\u001a\u00020\u00068VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\bR\u0016\u0010\u0001\u001a\u00020\u00068VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\bR\u001f\u0010\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "isReusable", "()Z", "", "cause", "cancelLater", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function0;", "", "block", "callCancelHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "callCancelHandler", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "trySuspend", "tryResume", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "releaseClaimedReusableContinuation", "()V", "", "state", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "Lkotlinx/coroutines/CancelHandler;", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/NotCompleted;", "proposedUpdate", "resumeMode", "onCancellation", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "detachChildIfNonResuable", "initCancellability", "resetStateReusable", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancel", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "callOnCancellation", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "detachChild$kotlinx_coroutines_core", "detachChild", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "completeResume", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "", "toString", "()Ljava/lang/String;", "a", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getStateDebugRepresentation", "stateDebugRepresentation", "getState$kotlinx_coroutines_core", "isActive", "isCompleted", "isCancelled", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _decision$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU;
    @NotNull
    private volatile /* synthetic */ int _decision = 0;
    @NotNull
    private volatile /* synthetic */ Object _state = Active.INSTANCE;
    @NotNull
    private final CoroutineContext context;
    @NotNull
    private final Continuation<T> delegate;
    @Nullable
    private DisposableHandle parentHandle;

    static {
        Class<CancellableContinuationImpl> cls = CancellableContinuationImpl.class;
        _decision$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "_decision");
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_state");
    }

    public CancellableContinuationImpl(@NotNull Continuation<? super T> continuation, int i11) {
        super(i11);
        this.delegate = continuation;
        this.context = continuation.getContext();
    }

    private final Void alreadyResumedError(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public static /* synthetic */ void b(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i11, Function1 function1, int i12, Object obj2) {
        if (obj2 == null) {
            if ((i12 & 4) != 0) {
                function1 = null;
            }
            cancellableContinuationImpl.resumeImpl(obj, i11, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final void callCancelHandlerSafely(Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Throwable th2) {
            CoroutineContext context2 = getContext();
            CoroutineExceptionHandlerKt.handleCoroutineException(context2, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean cancelLater(Throwable th2) {
        if (!isReusable()) {
            return false;
        }
        return ((DispatchedContinuation) this.delegate).postponeCancellation(th2);
    }

    private final void detachChildIfNonResuable() {
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
    }

    private final void dispatchResume(int i11) {
        if (!tryResume()) {
            DispatchedTaskKt.dispatch(this, i11);
        }
    }

    private final String getStateDebugRepresentation() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof NotCompleted) {
            return "Active";
        }
        if (state$kotlinx_coroutines_core instanceof CancelledContinuation) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        }
        return "Completed";
    }

    private final DisposableHandle installParentHandle() {
        Job job = (Job) getContext().get(Job.Key);
        if (job == null) {
            return null;
        }
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new ChildContinuation(this), 2, (Object) null);
        this.parentHandle = invokeOnCompletion$default;
        return invokeOnCompletion$default;
    }

    private final boolean isReusable() {
        return DispatchedTaskKt.isReusableMode(this.resumeMode) && ((DispatchedContinuation) this.delegate).isReusable();
    }

    private final CancelHandler makeCancelHandler(Function1<? super Throwable, Unit> function1) {
        return function1 instanceof CancelHandler ? (CancelHandler) function1 : new InvokeOnCancel(function1);
    }

    private final void multipleHandlersError(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    private final void releaseClaimedReusableContinuation() {
        DispatchedContinuation dispatchedContinuation;
        Throwable tryReleaseClaimedContinuation;
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null && (tryReleaseClaimedContinuation = dispatchedContinuation.tryReleaseClaimedContinuation(this)) != null) {
            detachChild$kotlinx_coroutines_core();
            cancel(tryReleaseClaimedContinuation);
        }
    }

    private final void resumeImpl(Object obj, int i11, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.makeResumed()) {
                        if (function1 != null) {
                            callOnCancellation(function1, cancelledContinuation.cause);
                            return;
                        }
                        return;
                    }
                }
                alreadyResumedError(obj);
                throw new KotlinNothingValueException();
            }
        } while (!a.a(_state$FU, this, obj2, resumedState((NotCompleted) obj2, obj, i11, function1, (Object) null)));
        detachChildIfNonResuable();
        dispatchResume(i11);
    }

    private final Object resumedState(NotCompleted notCompleted, Object obj, int i11, Function1<? super Throwable, Unit> function1, Object obj2) {
        CancelHandler cancelHandler;
        if (obj instanceof CompletedExceptionally) {
            return obj;
        }
        if (!DispatchedTaskKt.isCancellableMode(i11) && obj2 == null) {
            return obj;
        }
        if (function1 == null && ((!(notCompleted instanceof CancelHandler) || (notCompleted instanceof BeforeResumeCancelHandler)) && obj2 == null)) {
            return obj;
        }
        if (notCompleted instanceof CancelHandler) {
            cancelHandler = (CancelHandler) notCompleted;
        } else {
            cancelHandler = null;
        }
        return new CompletedContinuation(obj, cancelHandler, function1, obj2, (Throwable) null, 16, (DefaultConstructorMarker) null);
    }

    private final Symbol tryResumeImpl(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof NotCompleted) {
            } else if (!(obj3 instanceof CompletedContinuation) || obj2 == null || ((CompletedContinuation) obj3).idempotentResume != obj2) {
                return null;
            } else {
                return CancellableContinuationImplKt.RESUME_TOKEN;
            }
        } while (!a.a(_state$FU, this, obj3, resumedState((NotCompleted) obj3, obj, this.resumeMode, function1, obj2)));
        detachChildIfNonResuable();
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }

    private final boolean trySuspend() {
        do {
            int i11 = this._decision;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    @NotNull
    public String a() {
        return "CancellableContinuation";
    }

    public final void callCancelHandler(@NotNull CancelHandler cancelHandler, @Nullable Throwable th2) {
        try {
            cancelHandler.invoke(th2);
        } catch (Throwable th3) {
            CoroutineContext context2 = getContext();
            CoroutineExceptionHandlerKt.handleCoroutineException(context2, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public final void callOnCancellation(@NotNull Function1<? super Throwable, Unit> function1, @NotNull Throwable th2) {
        try {
            function1.invoke(th2);
        } catch (Throwable th3) {
            CoroutineContext context2 = getContext();
            CoroutineExceptionHandlerKt.handleCoroutineException(context2, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th3));
        }
    }

    public boolean cancel(@Nullable Throwable th2) {
        Object obj;
        boolean z11;
        CancelHandler cancelHandler;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z11 = obj instanceof CancelHandler;
        } while (!a.a(_state$FU, this, obj, new CancelledContinuation(this, th2, z11)));
        if (z11) {
            cancelHandler = (CancelHandler) obj;
        } else {
            cancelHandler = null;
        }
        if (cancelHandler != null) {
            callCancelHandler(cancelHandler, th2);
        }
        detachChildIfNonResuable();
        dispatchResume(this.resumeMode);
        return true;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object obj, @NotNull Throwable th2) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof CompletedExceptionally)) {
                if (obj2 instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                    if (!completedContinuation.getCancelled()) {
                        if (a.a(_state$FU, this, obj2, CompletedContinuation.copy$default(completedContinuation, (Object) null, (CancelHandler) null, (Function1) null, (Object) null, th2, 15, (Object) null))) {
                            completedContinuation.invokeHandlers(this, th2);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (a.a(_state$FU, this, obj2, new CompletedContinuation(obj2, (CancelHandler) null, (Function1) null, (Object) null, th2, 14, (DefaultConstructorMarker) null))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void completeResume(@NotNull Object obj) {
        dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle disposableHandle = this.parentHandle;
        if (disposableHandle != null) {
            disposableHandle.dispose();
            this.parentHandle = NonDisposableHandle.INSTANCE;
        }
    }

    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    @NotNull
    public Throwable getContinuationCancellationCause(@NotNull Job job) {
        return job.getCancellationException();
    }

    @NotNull
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            return exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    @Nullable
    @PublishedApi
    public final Object getResult() {
        Job job;
        boolean isReusable = isReusable();
        if (trySuspend()) {
            if (this.parentHandle == null) {
                installParentHandle();
            }
            if (isReusable) {
                releaseClaimedReusableContinuation();
            }
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (isReusable) {
            releaseClaimedReusableContinuation();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else if (!DispatchedTaskKt.isCancellableMode(this.resumeMode) || (job = (Job) getContext().get(Job.Key)) == null || job.isActive()) {
            return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
        } else {
            CancellationException cancellationException = job.getCancellationException();
            cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
            throw cancellationException;
        }
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return this._state;
    }

    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object obj) {
        return obj instanceof CompletedContinuation ? ((CompletedContinuation) obj).result : obj;
    }

    public void initCancellability() {
        DisposableHandle installParentHandle = installParentHandle();
        if (installParentHandle != null && isCompleted()) {
            installParentHandle.dispose();
            this.parentHandle = NonDisposableHandle.INSTANCE;
        }
    }

    public void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> function1) {
        CancelHandler makeCancelHandler = makeCancelHandler(function1);
        while (true) {
            Object obj = this._state;
            if (obj instanceof Active) {
                if (a.a(_state$FU, this, obj, makeCancelHandler)) {
                    return;
                }
            } else if (obj instanceof CancelHandler) {
                multipleHandlersError(function1, obj);
            } else {
                boolean z11 = obj instanceof CompletedExceptionally;
                if (z11) {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                    if (!completedExceptionally.makeHandled()) {
                        multipleHandlersError(function1, obj);
                    }
                    if (obj instanceof CancelledContinuation) {
                        Throwable th2 = null;
                        if (!z11) {
                            completedExceptionally = null;
                        }
                        if (completedExceptionally != null) {
                            th2 = completedExceptionally.cause;
                        }
                        callCancelHandler(function1, th2);
                        return;
                    }
                    return;
                } else if (obj instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                    if (completedContinuation.cancelHandler != null) {
                        multipleHandlersError(function1, obj);
                    }
                    if (!(makeCancelHandler instanceof BeforeResumeCancelHandler)) {
                        if (completedContinuation.getCancelled()) {
                            callCancelHandler(function1, completedContinuation.cancelCause);
                            return;
                        }
                        if (a.a(_state$FU, this, obj, CompletedContinuation.copy$default(completedContinuation, (Object) null, makeCancelHandler, (Function1) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (!(makeCancelHandler instanceof BeforeResumeCancelHandler)) {
                    if (a.a(_state$FU, this, obj, new CompletedContinuation(obj, makeCancelHandler, (Function1) null, (Object) null, (Throwable) null, 28, (DefaultConstructorMarker) null))) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    public boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    public final void parentCancelled$kotlinx_coroutines_core(@NotNull Throwable th2) {
        if (!cancelLater(th2)) {
            cancel(th2);
            detachChildIfNonResuable();
        }
    }

    @JvmName(name = "resetStateReusable")
    public final boolean resetStateReusable() {
        Object obj = this._state;
        if (!(obj instanceof CompletedContinuation) || ((CompletedContinuation) obj).idempotentResume == null) {
            this._decision = 0;
            this._state = Active.INSTANCE;
            return true;
        }
        detachChild$kotlinx_coroutines_core();
        return false;
    }

    public void resume(T t11, @Nullable Function1<? super Throwable, Unit> function1) {
        resumeImpl(t11, this.resumeMode, function1);
    }

    public void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, T t11) {
        DispatchedContinuation dispatchedContinuation;
        int i11;
        Continuation<T> continuation = this.delegate;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i11 = 4;
        } else {
            i11 = this.resumeMode;
        }
        b(this, t11, i11, (Function1) null, 4, (Object) null);
    }

    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th2) {
        DispatchedContinuation dispatchedContinuation;
        int i11;
        Continuation<T> continuation = this.delegate;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(th2, false, 2, (DefaultConstructorMarker) null);
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i11 = 4;
        } else {
            i11 = this.resumeMode;
        }
        b(this, completedExceptionally, i11, (Function1) null, 4, (Object) null);
    }

    public void resumeWith(@NotNull Object obj) {
        b(this, CompletionStateKt.toState(obj, (CancellableContinuation<?>) this), this.resumeMode, (Function1) null, 4, (Object) null);
    }

    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    @NotNull
    public String toString() {
        return a() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    @Nullable
    public Object tryResume(T t11, @Nullable Object obj) {
        return tryResumeImpl(t11, obj, (Function1<? super Throwable, Unit>) null);
    }

    @Nullable
    public Object tryResumeWithException(@NotNull Throwable th2) {
        return tryResumeImpl(new CompletedExceptionally(th2, false, 2, (DefaultConstructorMarker) null), (Object) null, (Function1<? super Throwable, Unit>) null);
    }

    @Nullable
    public Object tryResume(T t11, @Nullable Object obj, @Nullable Function1<? super Throwable, Unit> function1) {
        return tryResumeImpl(t11, obj, function1);
    }

    private final boolean tryResume() {
        do {
            int i11 = this._decision;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }

    private final void callCancelHandler(Function1<? super Throwable, Unit> function1, Throwable th2) {
        try {
            function1.invoke(th2);
        } catch (Throwable th3) {
            CoroutineContext context2 = getContext();
            CoroutineExceptionHandlerKt.handleCoroutineException(context2, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }
}
