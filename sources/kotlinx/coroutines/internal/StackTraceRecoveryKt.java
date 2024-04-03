package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u001a\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\t\u001a\u00020\u0001H\u0007\u001a9\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\r\u001a\u0002H\u000b2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0010H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00102\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002\u001a1\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00192\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0010H\u0002¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fHHø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a+\u0010\u001f\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002¢\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\"\u001a,\u0010!\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030#H\b¢\u0006\u0002\u0010$\u001a!\u0010%\u001a\u0004\u0018\u0001H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\"\u001a \u0010&\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\b¢\u0006\u0002\u0010\"\u001a\u001f\u0010'\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\"\u001a1\u0010(\u001a\u0018\u0012\u0004\u0012\u0002H\u000b\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00190)\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0002¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020,*\u00060\u0007j\u0002`\b2\n\u0010-\u001a\u00060\u0007j\u0002`\bH\u0002\u001a#\u0010.\u001a\u00020/*\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00192\u0006\u00100\u001a\u00020\u0001H\u0002¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0017*\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000\u001a\u0010\u00103\u001a\u00020,*\u00060\u0007j\u0002`\bH\u0000\u001a\u001b\u00104\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0002¢\u0006\u0002\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u00105\"\u00020\u00142\u00020\u0014*\f\b\u0000\u00106\"\u00020\u00072\u00020\u0007\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "message", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "tryCopyAndVerify", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class StackTraceRecoveryKt {
    @NotNull
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String baseContinuationImplClassName;
    @NotNull
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    private static final String stackTraceRecoveryClassName;

    static {
        Object obj;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            obj = baseContinuationImplClass;
        }
        baseContinuationImplClassName = (String) obj;
        try {
            obj2 = Result.m6329constructorimpl(StackTraceRecoveryKt.class.getCanonicalName());
        } catch (Throwable th3) {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            obj2 = stackTraceRecoveryClass;
        }
        stackTraceRecoveryClassName = (String) obj2;
    }

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    @NotNull
    @InternalCoroutinesApi
    public static final StackTraceElement artificialFrame(@NotNull String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E e11) {
        boolean z11;
        Throwable cause = e11.getCause();
        if (cause == null || !Intrinsics.areEqual((Object) cause.getClass(), (Object) e11.getClass())) {
            return TuplesKt.to(e11, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e11.getStackTrace();
        int length = stackTrace.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                z11 = false;
                break;
            } else if (isArtificial(stackTrace[i11])) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            return TuplesKt.to(cause, stackTrace);
        }
        return TuplesKt.to(e11, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E createFinalException(E e11, E e12, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(artificialFrame("Coroutine boundary"));
        StackTraceElement[] stackTrace = e11.getStackTrace();
        int frameIndex = frameIndex(stackTrace, baseContinuationImplClassName);
        int i11 = 0;
        if (frameIndex == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e12.setStackTrace((StackTraceElement[]) array);
                return e12;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[(arrayDeque.size() + frameIndex)];
        for (int i12 = 0; i12 < frameIndex; i12++) {
            stackTraceElementArr[i12] = stackTrace[i12];
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            stackTraceElementArr[i11 + frameIndex] = it.next();
            i11++;
        }
        e12.setStackTrace(stackTraceElementArr);
        return e12;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    private static final boolean elementWiseEquals(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        if (stackTraceElement.getLineNumber() != stackTraceElement2.getLineNumber() || !Intrinsics.areEqual((Object) stackTraceElement.getMethodName(), (Object) stackTraceElement2.getMethodName()) || !Intrinsics.areEqual((Object) stackTraceElement.getFileName(), (Object) stackTraceElement2.getFileName()) || !Intrinsics.areEqual((Object) stackTraceElement.getClassName(), (Object) stackTraceElement2.getClassName())) {
            return false;
        }
        return true;
    }

    private static final int frameIndex(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (Intrinsics.areEqual((Object) str, (Object) stackTraceElementArr[i11].getClassName())) {
                return i11;
            }
        }
        return -1;
    }

    public static final void initCause(@NotNull Throwable th2, @NotNull Throwable th3) {
        th2.initCause(th3);
    }

    public static final boolean isArtificial(@NotNull StackTraceElement stackTraceElement) {
        return StringsKt__StringsJVMKt.startsWith$default(stackTraceElement.getClassName(), "\b\b\b", false, 2, (Object) null);
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            } else if (isArtificial(stackTraceElementArr[i11])) {
                break;
            } else {
                i11++;
            }
        }
        int i12 = i11 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i12 <= length2) {
            while (true) {
                if (elementWiseEquals(stackTraceElementArr[length2], arrayDeque.getLast())) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 != i12) {
                    length2--;
                } else {
                    return;
                }
            }
        }
    }

    @Nullable
    public static final Object recoverAndThrow(@NotNull Throwable th2, @NotNull Continuation<?> continuation) {
        throw th2;
    }

    private static final Object recoverAndThrow$$forInline(Throwable th2, Continuation<?> continuation) {
        throw th2;
    }

    /* access modifiers changed from: private */
    public static final <E extends Throwable> E recoverFromStackFrame(E e11, CoroutineStackFrame coroutineStackFrame) {
        Pair causeAndStacktrace = causeAndStacktrace(e11);
        E e12 = (Throwable) causeAndStacktrace.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) causeAndStacktrace.component2();
        Throwable tryCopyAndVerify = tryCopyAndVerify(e12);
        if (tryCopyAndVerify == null) {
            return e11;
        }
        ArrayDeque createStackTrace = createStackTrace(coroutineStackFrame);
        if (createStackTrace.isEmpty()) {
            return e11;
        }
        if (e12 != e11) {
            mergeRecoveredTraces(stackTraceElementArr, createStackTrace);
        }
        return createFinalException(e12, tryCopyAndVerify, createStackTrace);
    }

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E e11) {
        return e11;
    }

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E e11, @NotNull Continuation<?> continuation) {
        return e11;
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E e11) {
        int i11;
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e11.getStackTrace();
        int length = stackTrace.length;
        int frameIndex = frameIndex(stackTrace, stackTraceRecoveryClassName);
        int i12 = frameIndex + 1;
        int frameIndex2 = frameIndex(stackTrace, baseContinuationImplClassName);
        if (frameIndex2 == -1) {
            i11 = 0;
        } else {
            i11 = length - frameIndex2;
        }
        int i13 = (length - frameIndex) - i11;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            if (i14 == 0) {
                stackTraceElement = artificialFrame("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i12 + i14) - 1];
            }
            stackTraceElementArr[i14] = stackTraceElement;
        }
        e11.setStackTrace(stackTraceElementArr);
        return e11;
    }

    private static final <E extends Throwable> E tryCopyAndVerify(E e11) {
        E tryCopyException = ExceptionsConstructorKt.tryCopyException(e11);
        if (tryCopyException == null) {
            return null;
        }
        if ((e11 instanceof CopyableThrowable) || Intrinsics.areEqual((Object) tryCopyException.getMessage(), (Object) e11.getMessage())) {
            return tryCopyException;
        }
        return null;
    }

    @NotNull
    public static final <E extends Throwable> E unwrap(@NotNull E e11) {
        return e11;
    }

    @NotNull
    public static final <E extends Throwable> E unwrapImpl(@NotNull E e11) {
        E cause = e11.getCause();
        if (cause != null && Intrinsics.areEqual((Object) cause.getClass(), (Object) e11.getClass())) {
            StackTraceElement[] stackTrace = e11.getStackTrace();
            int length = stackTrace.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                } else if (isArtificial(stackTrace[i11])) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
            if (z11) {
                return cause;
            }
        }
        return e11;
    }
}
