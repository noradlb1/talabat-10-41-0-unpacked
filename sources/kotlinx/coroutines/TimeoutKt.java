package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a_\u0010\u0006\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\t*\u0002H\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\n2'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aU\u0010\u0011\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0012\u001a\u00020\u00032'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH@ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0013\u001a]\u0010\u0011\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0014\u001a\u00020\u00152'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0016\u0010\u0013\u001aJ\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0012\u001a\u00020\u00032'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aR\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0014\u001a\u00020\u00152'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0013\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TimeoutKt {
    @NotNull
    public static final TimeoutCancellationException TimeoutCancellationException(long j11, @NotNull Job job) {
        return new TimeoutCancellationException("Timed out waiting for " + j11 + " ms", job);
    }

    private static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        JobKt.disposeOnCompletion(timeoutCoroutine, DelayKt.getDelay(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.getContext()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(timeoutCoroutine, timeoutCoroutine, function2);
    }

    @Nullable
    public static final <T> Object withTimeout(long j11, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        if (j11 > 0) {
            Object obj = setupTimeout(new TimeoutCoroutine(j11, continuation), function2);
            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return obj;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    @Nullable
    /* renamed from: withTimeout-KLykuaI  reason: not valid java name */
    public static final <T> Object m7784withTimeoutKLykuaI(long j11, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return withTimeout(DelayKt.m7782toDelayMillisLRDsOJo(j11), function2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object withTimeoutOrNull(long r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.f25142l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25142l = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.f25141k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25142l
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            java.lang.Object r7 = r0.f25140j
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.f25139i
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ TimeoutCancellationException -> 0x0032 }
            goto L_0x006b
        L_0x0032:
            r8 = move-exception
            goto L_0x006e
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L_0x0046
            return r3
        L_0x0046:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r0.f25139i = r9     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.f25140j = r10     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.f25138h = r7     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.f25142l = r4     // Catch:{ TimeoutCancellationException -> 0x006c }
            kotlinx.coroutines.TimeoutCoroutine r2 = new kotlinx.coroutines.TimeoutCoroutine     // Catch:{ TimeoutCancellationException -> 0x006c }
            r2.<init>(r7, r0)     // Catch:{ TimeoutCancellationException -> 0x006c }
            r10.element = r2     // Catch:{ TimeoutCancellationException -> 0x006c }
            java.lang.Object r7 = setupTimeout(r2, r9)     // Catch:{ TimeoutCancellationException -> 0x006c }
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ TimeoutCancellationException -> 0x006c }
            if (r7 != r8) goto L_0x0067
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ TimeoutCancellationException -> 0x006c }
        L_0x0067:
            if (r7 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r10 = r7
        L_0x006b:
            return r10
        L_0x006c:
            r8 = move-exception
            r7 = r10
        L_0x006e:
            kotlinx.coroutines.Job r9 = r8.coroutine
            T r7 = r7.element
            if (r9 != r7) goto L_0x0075
            return r3
        L_0x0075:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    /* renamed from: withTimeoutOrNull-KLykuaI  reason: not valid java name */
    public static final <T> Object m7785withTimeoutOrNullKLykuaI(long j11, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return withTimeoutOrNull(DelayKt.m7782toDelayMillisLRDsOJo(j11), function2, continuation);
    }
}
