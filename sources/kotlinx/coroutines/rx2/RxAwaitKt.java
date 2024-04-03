package kotlinx.coroutines.rx2;

import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.ObservableSource;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a#\u0010\u0000\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a!\u0010\u0000\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a!\u0010\t\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\n2\u0006\u0010\r\u001a\u0002H\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a/\u0010\u000f\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a#\u0010\u0013\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a!\u0010\u0014\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a5\u0010\u0015\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\n2\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\r\u001a\u0004\u0018\u0001H\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a)\u0010\u0019\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u0002H\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a!\u0010\u001b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a!\u0010\u001b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a#\u0010\u001c\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u0018\u0010\u001d\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"await", "", "Lio/reactivex/CompletableSource;", "(Lio/reactivex/CompletableSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lio/reactivex/MaybeSource;", "(Lio/reactivex/MaybeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/SingleSource;", "(Lio/reactivex/SingleSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirst", "Lio/reactivex/ObservableSource;", "(Lio/reactivex/ObservableSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrDefault", "default", "(Lio/reactivex/ObservableSource;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrElse", "defaultValue", "Lkotlin/Function0;", "(Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrNull", "awaitLast", "awaitOne", "mode", "Lkotlinx/coroutines/rx2/Mode;", "(Lio/reactivex/ObservableSource;Lkotlinx/coroutines/rx2/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitOrDefault", "(Lio/reactivex/MaybeSource;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingle", "awaitSingleOrNull", "disposeOnCancellation", "Lkotlinx/coroutines/CancellableContinuation;", "d", "Lio/reactivex/disposables/Disposable;", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RxAwaitKt {
    public static /* synthetic */ Object a(ObservableSource observableSource, Mode mode, Object obj, Continuation continuation, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        return awaitOne(observableSource, mode, obj, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of awaitSingleOrNull()", replaceWith = @ReplaceWith(expression = "this.awaitSingleOrNull()", imports = {}))
    @Nullable
    public static final <T> Object await(@NotNull MaybeSource<T> maybeSource, @NotNull Continuation<? super T> continuation) {
        return awaitSingleOrNull(maybeSource, continuation);
    }

    @Nullable
    public static final <T> Object awaitFirst(@NotNull ObservableSource<T> observableSource, @NotNull Continuation<? super T> continuation) {
        return a(observableSource, Mode.FIRST, (Object) null, continuation, 2, (Object) null);
    }

    @Nullable
    public static final <T> Object awaitFirstOrDefault(@NotNull ObservableSource<T> observableSource, T t11, @NotNull Continuation<? super T> continuation) {
        return awaitOne(observableSource, Mode.FIRST_OR_DEFAULT, t11, continuation);
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
    public static final <T> java.lang.Object awaitFirstOrElse(@org.jetbrains.annotations.NotNull io.reactivex.ObservableSource<T> r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.rx2.RxAwaitKt$awaitFirstOrElse$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.rx2.RxAwaitKt$awaitFirstOrElse$1 r0 = (kotlinx.coroutines.rx2.RxAwaitKt$awaitFirstOrElse$1) r0
            int r1 = r0.f26281j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26281j = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx2.RxAwaitKt$awaitFirstOrElse$1 r0 = new kotlinx.coroutines.rx2.RxAwaitKt$awaitFirstOrElse$1
            r0.<init>(r9)
        L_0x0018:
            r4 = r0
            java.lang.Object r9 = r4.f26280i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f26281j
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r7 = r4.f26279h
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
            kotlinx.coroutines.rx2.Mode r9 = kotlinx.coroutines.rx2.Mode.FIRST_OR_DEFAULT
            r3 = 0
            r5 = 2
            r6 = 0
            r4.f26279h = r8
            r4.f26281j = r2
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxAwaitKt.awaitFirstOrElse(io.reactivex.ObservableSource, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public static final <T> Object awaitFirstOrNull(@NotNull ObservableSource<T> observableSource, @NotNull Continuation<? super T> continuation) {
        return a(observableSource, Mode.FIRST_OR_DEFAULT, (Object) null, continuation, 2, (Object) null);
    }

    @Nullable
    public static final <T> Object awaitLast(@NotNull ObservableSource<T> observableSource, @NotNull Continuation<? super T> continuation) {
        return a(observableSource, Mode.LAST, (Object) null, continuation, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final <T> Object awaitOne(ObservableSource<T> observableSource, Mode mode, T t11, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        observableSource.subscribe(new RxAwaitKt$awaitOne$2$1(cancellableContinuationImpl, mode, t11));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated in favor of awaitSingleOrNull()", replaceWith = @kotlin.ReplaceWith(expression = "this.awaitSingleOrNull() ?: default", imports = {}))
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object awaitOrDefault(@org.jetbrains.annotations.NotNull io.reactivex.MaybeSource<T> r4, T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.rx2.RxAwaitKt$awaitOrDefault$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.rx2.RxAwaitKt$awaitOrDefault$1 r0 = (kotlinx.coroutines.rx2.RxAwaitKt$awaitOrDefault$1) r0
            int r1 = r0.f26288j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26288j = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx2.RxAwaitKt$awaitOrDefault$1 r0 = new kotlinx.coroutines.rx2.RxAwaitKt$awaitOrDefault$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f26287i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26288j
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r5 = r0.f26286h
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0041
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.f26286h = r5
            r0.f26288j = r3
            java.lang.Object r6 = awaitSingleOrNull(r4, r0)
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            if (r6 != 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r5 = r6
        L_0x0045:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxAwaitKt.awaitOrDefault(io.reactivex.MaybeSource, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object awaitSingle(@org.jetbrains.annotations.NotNull io.reactivex.MaybeSource<T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.rx2.RxAwaitKt$awaitSingle$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.rx2.RxAwaitKt$awaitSingle$1 r0 = (kotlinx.coroutines.rx2.RxAwaitKt$awaitSingle$1) r0
            int r1 = r0.f26290i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26290i = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx2.RxAwaitKt$awaitSingle$1 r0 = new kotlinx.coroutines.rx2.RxAwaitKt$awaitSingle$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.f26289h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26290i
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.f26290i = r3
            java.lang.Object r5 = awaitSingleOrNull(r4, r0)
            if (r5 != r1) goto L_0x003d
            return r1
        L_0x003d:
            if (r5 == 0) goto L_0x0040
            return r5
        L_0x0040:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxAwaitKt.awaitSingle(io.reactivex.MaybeSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public static final <T> Object awaitSingleOrNull(@NotNull MaybeSource<T> maybeSource, @NotNull Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        maybeSource.subscribe(new RxAwaitKt$awaitSingleOrNull$2$1(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final void disposeOnCancellation(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull Disposable disposable) {
        cancellableContinuation.invokeOnCancellation(new RxAwaitKt$disposeOnCancellation$1(disposable));
    }

    @Nullable
    public static final Object await(@NotNull CompletableSource completableSource, @NotNull Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        completableSource.subscribe(new RxAwaitKt$await$2$1(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Nullable
    public static final <T> Object awaitSingle(@NotNull ObservableSource<T> observableSource, @NotNull Continuation<? super T> continuation) {
        return a(observableSource, Mode.SINGLE, (Object) null, continuation, 2, (Object) null);
    }

    @Nullable
    public static final <T> Object await(@NotNull SingleSource<T> singleSource, @NotNull Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        singleSource.subscribe(new RxAwaitKt$await$5$1(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
