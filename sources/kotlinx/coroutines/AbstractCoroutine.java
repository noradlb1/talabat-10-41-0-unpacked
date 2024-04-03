package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u001f\u0012\u0006\u00102\u001a\u00020'\u0012\u0006\u00103\u001a\u00020\f\u0012\u0006\u00104\u001a\u00020\f¢\u0006\u0004\b5\u00106J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0004J\u001e\u0010\u0016\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\tJ\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u000fH\u0010¢\u0006\u0004\b\u001c\u0010\u001dJO\u0010!\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u001f2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00028\u00012'\u0010%\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00110#¢\u0006\u0002\b$ø\u0001\u0000¢\u0006\u0004\b!\u0010&R\u001d\u0010(\u001a\u00020'8\u0006¢\u0006\u0012\n\u0004\b(\u0010)\u0012\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010+R\u0014\u00100\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "value", "", "onCompleted", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "m", "", "b", "", "state", "i", "Lkotlin/Result;", "result", "resumeWith", "l", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "handleOnCompletionException", "nameString$kotlinx_coroutines_core", "()Ljava/lang/String;", "nameString", "R", "Lkotlinx/coroutines/CoroutineStart;", "start", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "block", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getContext$annotations", "()V", "getCoroutineContext", "coroutineContext", "isActive", "()Z", "parentContext", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@InternalCoroutinesApi
public abstract class AbstractCoroutine<T> extends JobSupport implements Continuation<T>, CoroutineScope {
    @NotNull
    private final CoroutineContext context;

    public AbstractCoroutine(@NotNull CoroutineContext coroutineContext, boolean z11, boolean z12) {
        super(z12);
        if (z11) {
            f((Job) coroutineContext.get(Job.Key));
        }
        this.context = coroutineContext.plus(this);
    }

    public static /* synthetic */ void getContext$annotations() {
    }

    @NotNull
    public String b() {
        return DebugStringsKt.getClassSimpleName(this) + " was cancelled";
    }

    @NotNull
    public final CoroutineContext getContext() {
        return this.context;
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    public final void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable th2) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.context, th2);
    }

    public final void i(@Nullable Object obj) {
        if (obj instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            m(completedExceptionally.cause, completedExceptionally.getHandled());
            return;
        }
        onCompleted(obj);
    }

    public boolean isActive() {
        return super.isActive();
    }

    public void l(@Nullable Object obj) {
        a(obj);
    }

    public void m(@NotNull Throwable th2, boolean z11) {
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = CoroutineContextKt.getCoroutineName(this.context);
        if (coroutineName == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        return '\"' + coroutineName + "\":" + super.nameString$kotlinx_coroutines_core();
    }

    public void onCompleted(T t11) {
    }

    public final void resumeWith(@NotNull Object obj) {
        Object makeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(CompletionStateKt.toState$default(obj, (Function1) null, 1, (Object) null));
        if (makeCompletingOnce$kotlinx_coroutines_core != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            l(makeCompletingOnce$kotlinx_coroutines_core);
        }
    }

    public final <R> void start(@NotNull CoroutineStart coroutineStart, R r11, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        coroutineStart.invoke(function2, r11, this);
    }
}
