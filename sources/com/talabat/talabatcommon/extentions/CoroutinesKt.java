package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u0001H\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b¢\u0006\u0002\u0010\t\u001aY\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u0001H\u00012\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a*\u0010\u000e\u001a\u00020\u00052\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u001aE\u0010\u000f\u001a\u00020\u00052\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001at\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0012\"\u0004\b\u0000\u0010\u0001*\u00020\u00132\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u0001H\u00012\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a+\u0010\u001a\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u00122\u0006\u0010\u0006\u001a\u0002H\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001aP\u0010\u001c\u001a\u00020\u001d*\u00020\u00132\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"returnHandling", "T", "onError", "Lkotlin/Function1;", "", "", "defaultValue", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "returnSuspended", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runHandling", "runSuspended", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asyncCatching", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "onErrorReturn", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Deferred;", "await", "(Lkotlinx/coroutines/Deferred;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchCatching", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CoroutinesKt {
    @NotNull
    public static final <T> Deferred<T> asyncCatching(@NotNull CoroutineScope coroutineScope, @NotNull Function1<? super Throwable, Unit> function1, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @Nullable T t11, @NotNull Function1<? super Continuation<? super T>, ? extends Object> function12) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(coroutineStart, "start");
        Intrinsics.checkNotNullParameter(function12, "block");
        return BuildersKt.async(coroutineScope, coroutineContext, coroutineStart, new CoroutinesKt$asyncCatching$2(function1, t11, function12, (Continuation<? super CoroutinesKt$asyncCatching$2>) null));
    }

    public static /* synthetic */ Deferred asyncCatching$default(CoroutineScope coroutineScope, Function1 function1, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Object obj, Function1 function12, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            function1 = CoroutinesKt$asyncCatching$1.INSTANCE;
        }
        Function1 function13 = function1;
        if ((i11 & 2) != 0) {
            coroutineContext = coroutineScope.getCoroutineContext();
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i11 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i11 & 8) != 0) {
            obj = null;
        }
        return asyncCatching(coroutineScope, function13, coroutineContext2, coroutineStart2, obj, function12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object await(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Deferred<? extends T> r4, T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r6) {
        /*
            boolean r0 = r6 instanceof com.talabat.talabatcommon.extentions.CoroutinesKt$await$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.talabatcommon.extentions.CoroutinesKt$await$1 r0 = (com.talabat.talabatcommon.extentions.CoroutinesKt$await$1) r0
            int r1 = r0.f46984j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f46984j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.extentions.CoroutinesKt$await$1 r0 = new com.talabat.talabatcommon.extentions.CoroutinesKt$await$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f46983i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f46984j
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r5 = r0.f46982h
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0041
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.f46982h = r5
            r0.f46984j = r3
            java.lang.Object r6 = r4.await(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.CoroutinesKt.await(kotlinx.coroutines.Deferred, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public static final Job launchCatching(@NotNull CoroutineScope coroutineScope, @NotNull Function1<? super Throwable, Unit> function1, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function12) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(function12, "block");
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, coroutineContext, (CoroutineStart) null, new CoroutinesKt$launchCatching$2(function1, function12, (Continuation<? super CoroutinesKt$launchCatching$2>) null), 2, (Object) null);
    }

    public static /* synthetic */ Job launchCatching$default(CoroutineScope coroutineScope, Function1 function1, CoroutineContext coroutineContext, Function1 function12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = CoroutinesKt$launchCatching$1.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            coroutineContext = coroutineScope.getCoroutineContext();
        }
        return launchCatching(coroutineScope, function1, coroutineContext, function12);
    }

    @Nullable
    public static final <T> T returnHandling(@NotNull Function1<? super Throwable, Unit> function1, @Nullable T t11, @NotNull Function0<? extends T> function0) {
        T t12;
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            Result.Companion companion = Result.Companion;
            t12 = Result.m6329constructorimpl(function0.invoke());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            t12 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(t12);
        if (r02 != null) {
            function1.invoke(r02);
        }
        if (Result.m6335isFailureimpl(t12)) {
            return t11;
        }
        return t12;
    }

    public static /* synthetic */ Object returnHandling$default(Function1 function1, Object obj, Function0 function0, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            function1 = CoroutinesKt$returnHandling$1.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            obj = null;
        }
        return returnHandling(function1, obj, function0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object returnSuspended(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r4, @org.jetbrains.annotations.Nullable T r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r7) {
        /*
            boolean r0 = r7 instanceof com.talabat.talabatcommon.extentions.CoroutinesKt$returnSuspended$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.talabatcommon.extentions.CoroutinesKt$returnSuspended$1 r0 = (com.talabat.talabatcommon.extentions.CoroutinesKt$returnSuspended$1) r0
            int r1 = r0.f46991k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f46991k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.extentions.CoroutinesKt$returnSuspended$1 r0 = new com.talabat.talabatcommon.extentions.CoroutinesKt$returnSuspended$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f46990j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f46991k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.f46989i
            java.lang.Object r4 = r0.f46988h
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x004e }
            goto L_0x0049
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x004e }
            r0.f46988h = r4     // Catch:{ all -> 0x004e }
            r0.f46989i = r5     // Catch:{ all -> 0x004e }
            r0.f46991k = r3     // Catch:{ all -> 0x004e }
            java.lang.Object r7 = r6.invoke(r0)     // Catch:{ all -> 0x004e }
            if (r7 != r1) goto L_0x0049
            return r1
        L_0x0049:
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r7)     // Catch:{ all -> 0x004e }
            goto L_0x0059
        L_0x004e:
            r6 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x0059:
            java.lang.Throwable r7 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r7 == 0) goto L_0x0062
            r4.invoke(r7)
        L_0x0062:
            boolean r4 = kotlin.Result.m6335isFailureimpl(r6)
            if (r4 == 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r5 = r6
        L_0x006a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.CoroutinesKt.returnSuspended(kotlin.jvm.functions.Function1, java.lang.Object, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object returnSuspended$default(Function1 function1, Object obj, Function1 function12, Continuation continuation, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            function1 = CoroutinesKt$returnSuspended$2.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            obj = null;
        }
        return returnSuspended(function1, obj, function12, continuation);
    }

    public static final void runHandling(@NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            Result.Companion companion = Result.Companion;
            function0.invoke();
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            function1.invoke(r22);
        }
    }

    public static /* synthetic */ void runHandling$default(Function1 function1, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = CoroutinesKt$runHandling$1.INSTANCE;
        }
        runHandling(function1, function0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object runSuspended(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof com.talabat.talabatcommon.extentions.CoroutinesKt$runSuspended$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.talabatcommon.extentions.CoroutinesKt$runSuspended$1 r0 = (com.talabat.talabatcommon.extentions.CoroutinesKt$runSuspended$1) r0
            int r1 = r0.f46994j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f46994j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.extentions.CoroutinesKt$runSuspended$1 r0 = new com.talabat.talabatcommon.extentions.CoroutinesKt$runSuspended$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f46993i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f46994j
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.f46992h
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x004c }
            goto L_0x0045
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x004c }
            r0.f46992h = r4     // Catch:{ all -> 0x004c }
            r0.f46994j = r3     // Catch:{ all -> 0x004c }
            java.lang.Object r5 = r5.invoke(r0)     // Catch:{ all -> 0x004c }
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004c }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x004c }
            goto L_0x0057
        L_0x004c:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0057:
            java.lang.Throwable r5 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r5 == 0) goto L_0x0060
            r4.invoke(r5)
        L_0x0060:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.CoroutinesKt.runSuspended(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object runSuspended$default(Function1 function1, Function1 function12, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = CoroutinesKt$runSuspended$2.INSTANCE;
        }
        return runSuspended(function1, function12, continuation);
    }
}
