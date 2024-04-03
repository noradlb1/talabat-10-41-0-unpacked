package kotlinx.coroutines.reactive;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a!\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a)\u0010\r\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\u000e\u001a\u0002H\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a/\u0010\u0010\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a#\u0010\u0014\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a!\u0010\u0015\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a5\u0010\u0016\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a!\u0010\u0018\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a)\u0010\u0019\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\u000e\u001a\u0002H\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a/\u0010\u001a\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a#\u0010\u001b\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"gotSignalInTerminalStateException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "signalName", "", "moreThanOneValueProvidedException", "mode", "Lkotlinx/coroutines/reactive/Mode;", "awaitFirst", "T", "Lorg/reactivestreams/Publisher;", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrDefault", "default", "(Lorg/reactivestreams/Publisher;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrElse", "defaultValue", "Lkotlin/Function0;", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrNull", "awaitLast", "awaitOne", "(Lorg/reactivestreams/Publisher;Lkotlinx/coroutines/reactive/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingle", "awaitSingleOrDefault", "awaitSingleOrElse", "awaitSingleOrNull", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AwaitKt {
    public static /* synthetic */ Object a(Publisher publisher, Mode mode, Object obj, Continuation continuation, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        return awaitOne(publisher, mode, obj, continuation);
    }

    @Nullable
    public static final <T> Object awaitFirst(@NotNull Publisher<T> publisher, @NotNull Continuation<? super T> continuation) {
        return a(publisher, Mode.FIRST, (Object) null, continuation, 2, (Object) null);
    }

    @Nullable
    public static final <T> Object awaitFirstOrDefault(@NotNull Publisher<T> publisher, T t11, @NotNull Continuation<? super T> continuation) {
        return awaitOne(publisher, Mode.FIRST_OR_DEFAULT, t11, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object awaitFirstOrElse(@org.jetbrains.annotations.NotNull org.reactivestreams.Publisher<T> r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.reactive.AwaitKt$awaitFirstOrElse$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.reactive.AwaitKt$awaitFirstOrElse$1 r0 = (kotlinx.coroutines.reactive.AwaitKt$awaitFirstOrElse$1) r0
            int r1 = r0.f26205j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26205j = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.AwaitKt$awaitFirstOrElse$1 r0 = new kotlinx.coroutines.reactive.AwaitKt$awaitFirstOrElse$1
            r0.<init>(r9)
        L_0x0018:
            r4 = r0
            java.lang.Object r9 = r4.f26204i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f26205j
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r7 = r4.f26203h
            r8 = r7
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004c
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.reactive.Mode r9 = kotlinx.coroutines.reactive.Mode.FIRST_OR_DEFAULT
            r3 = 0
            r5 = 2
            r6 = 0
            r4.f26203h = r8
            r4.f26205j = r2
            r1 = r7
            r2 = r9
            java.lang.Object r9 = a(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x004c
            return r0
        L_0x004c:
            if (r9 != 0) goto L_0x0052
            java.lang.Object r9 = r8.invoke()
        L_0x0052:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.AwaitKt.awaitFirstOrElse(org.reactivestreams.Publisher, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public static final <T> Object awaitFirstOrNull(@NotNull Publisher<T> publisher, @NotNull Continuation<? super T> continuation) {
        return a(publisher, Mode.FIRST_OR_DEFAULT, (Object) null, continuation, 2, (Object) null);
    }

    @Nullable
    public static final <T> Object awaitLast(@NotNull Publisher<T> publisher, @NotNull Continuation<? super T> continuation) {
        return a(publisher, Mode.LAST, (Object) null, continuation, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final <T> Object awaitOne(Publisher<T> publisher, Mode mode, T t11, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ReactiveFlowKt.injectCoroutineContext(publisher, cancellableContinuationImpl.getContext()).subscribe(new AwaitKt$awaitOne$2$1(cancellableContinuationImpl, mode, t11));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public static final <T> Object awaitSingle(@NotNull Publisher<T> publisher, @NotNull Continuation<? super T> continuation) {
        return a(publisher, Mode.SINGLE, (Object) null, continuation, 2, (Object) null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without a replacement due to its name incorrectly conveying the behavior. Please consider using awaitFirstOrDefault().")
    @Nullable
    public static final <T> Object awaitSingleOrDefault(@NotNull Publisher<T> publisher, T t11, @NotNull Continuation<? super T> continuation) {
        return awaitOne(publisher, Mode.SINGLE_OR_DEFAULT, t11, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated without a replacement due to its name incorrectly conveying the behavior. Please consider using awaitFirstOrElse().")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object awaitSingleOrElse(@org.jetbrains.annotations.NotNull org.reactivestreams.Publisher<T> r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.reactive.AwaitKt$awaitSingleOrElse$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.reactive.AwaitKt$awaitSingleOrElse$1 r0 = (kotlinx.coroutines.reactive.AwaitKt$awaitSingleOrElse$1) r0
            int r1 = r0.f26219j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26219j = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.AwaitKt$awaitSingleOrElse$1 r0 = new kotlinx.coroutines.reactive.AwaitKt$awaitSingleOrElse$1
            r0.<init>(r9)
        L_0x0018:
            r4 = r0
            java.lang.Object r9 = r4.f26218i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f26219j
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r7 = r4.f26217h
            r8 = r7
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004c
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.reactive.Mode r9 = kotlinx.coroutines.reactive.Mode.SINGLE_OR_DEFAULT
            r3 = 0
            r5 = 2
            r6 = 0
            r4.f26217h = r8
            r4.f26219j = r2
            r1 = r7
            r2 = r9
            java.lang.Object r9 = a(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x004c
            return r0
        L_0x004c:
            if (r9 != 0) goto L_0x0052
            java.lang.Object r9 = r8.invoke()
        L_0x0052:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.AwaitKt.awaitSingleOrElse(org.reactivestreams.Publisher, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without a replacement due to its name incorrectly conveying the behavior. There is a specialized version for Reactor's Mono, please use that where applicable. Alternatively, please consider using awaitFirstOrNull().", replaceWith = @ReplaceWith(expression = "this.awaitSingleOrNull()", imports = {"kotlinx.coroutines.reactor"}))
    @Nullable
    public static final <T> Object awaitSingleOrNull(@NotNull Publisher<T> publisher, @NotNull Continuation<? super T> continuation) {
        return a(publisher, Mode.SINGLE_OR_DEFAULT, (Object) null, continuation, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void gotSignalInTerminalStateException(CoroutineContext coroutineContext, String str) {
        CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, new IllegalStateException('\'' + str + "' was called after the publisher already signalled being in a terminal state"));
    }

    /* access modifiers changed from: private */
    public static final void moreThanOneValueProvidedException(CoroutineContext coroutineContext, Mode mode) {
        CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, new IllegalStateException("Only a single value was requested in '" + mode + "', but the publisher provided more"));
    }
}
