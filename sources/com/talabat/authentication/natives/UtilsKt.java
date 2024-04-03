package com.talabat.authentication.natives;

import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a|\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u000521\u0010\u0006\u001a-\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00072\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"retryIf", "T", "times", "", "backoff", "Lcom/talabat/authentication/natives/Backoff;", "predicate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "e", "Lkotlin/coroutines/Continuation;", "", "", "block", "Lkotlin/Function1;", "(ILcom/talabat/authentication/natives/Backoff;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_Authentication_Authentication"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class UtilsKt {
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b6 A[SYNTHETIC, Splitter:B:24:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object retryIf(int r11, @org.jetbrains.annotations.NotNull com.talabat.authentication.natives.Backoff r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r15) {
        /*
            boolean r0 = r15 instanceof com.talabat.authentication.natives.UtilsKt$retryIf$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.talabat.authentication.natives.UtilsKt$retryIf$1 r0 = (com.talabat.authentication.natives.UtilsKt$retryIf$1) r0
            int r1 = r0.f55515p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55515p = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.UtilsKt$retryIf$1 r0 = new com.talabat.authentication.natives.UtilsKt$retryIf$1
            r0.<init>(r15)
        L_0x0018:
            java.lang.Object r15 = r0.f55514o
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55515p
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x009c
            if (r2 == r6) goto L_0x007c
            if (r2 == r5) goto L_0x005c
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0131
        L_0x0034:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003c:
            int r11 = r0.f55513n
            int r12 = r0.f55512m
            java.lang.Object r13 = r0.f55510k
            kotlin.jvm.internal.Ref$LongRef r13 = (kotlin.jvm.internal.Ref.LongRef) r13
            java.lang.Object r14 = r0.f55509j
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            java.lang.Object r2 = r0.f55508i
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            java.lang.Object r8 = r0.f55507h
            com.talabat.authentication.natives.Backoff r8 = (com.talabat.authentication.natives.Backoff) r8
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r13
            r13 = r8
            r10 = r0
            r0 = r14
            r14 = r2
            r2 = r1
            r1 = r10
            goto L_0x0117
        L_0x005c:
            int r11 = r0.f55513n
            int r12 = r0.f55512m
            java.lang.Object r13 = r0.f55511l
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            java.lang.Object r14 = r0.f55510k
            kotlin.jvm.internal.Ref$LongRef r14 = (kotlin.jvm.internal.Ref.LongRef) r14
            java.lang.Object r2 = r0.f55509j
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r8 = r0.f55508i
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r0.f55507h
            com.talabat.authentication.natives.Backoff r9 = (com.talabat.authentication.natives.Backoff) r9
            kotlin.ResultKt.throwOnFailure(r15)
            r10 = r14
            r14 = r13
            r13 = r10
            goto L_0x00ef
        L_0x007c:
            int r11 = r0.f55513n
            int r12 = r0.f55512m
            java.lang.Object r13 = r0.f55510k
            kotlin.jvm.internal.Ref$LongRef r13 = (kotlin.jvm.internal.Ref.LongRef) r13
            java.lang.Object r14 = r0.f55509j
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            java.lang.Object r2 = r0.f55508i
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            java.lang.Object r8 = r0.f55507h
            com.talabat.authentication.natives.Backoff r8 = (com.talabat.authentication.natives.Backoff) r8
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0094 }
            goto L_0x00cb
        L_0x0094:
            r15 = move-exception
            r9 = r8
            r8 = r2
            r2 = r14
            r10 = r15
            r15 = r13
            r13 = r10
            goto L_0x00d4
        L_0x009c:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            long r8 = r12.delay()
            r15.element = r8
            int r11 = r11 - r6
            r2 = 0
            r10 = r12
            r12 = r11
            r11 = r2
            r2 = r1
            r1 = r0
            r0 = r14
            r14 = r13
            r13 = r10
        L_0x00b4:
            if (r11 >= r12) goto L_0x0120
            r1.f55507h = r13     // Catch:{ all -> 0x00cc }
            r1.f55508i = r14     // Catch:{ all -> 0x00cc }
            r1.f55509j = r0     // Catch:{ all -> 0x00cc }
            r1.f55510k = r15     // Catch:{ all -> 0x00cc }
            r1.f55512m = r12     // Catch:{ all -> 0x00cc }
            r1.f55513n = r11     // Catch:{ all -> 0x00cc }
            r1.f55515p = r6     // Catch:{ all -> 0x00cc }
            java.lang.Object r15 = r0.invoke(r1)     // Catch:{ all -> 0x00cc }
            if (r15 != r2) goto L_0x00cb
            return r2
        L_0x00cb:
            return r15
        L_0x00cc:
            r8 = move-exception
            r9 = r13
            r13 = r8
            r8 = r14
            r10 = r2
            r2 = r0
            r0 = r1
            r1 = r10
        L_0x00d4:
            r0.f55507h = r9
            r0.f55508i = r8
            r0.f55509j = r2
            r0.f55510k = r15
            r0.f55511l = r13
            r0.f55512m = r12
            r0.f55513n = r11
            r0.f55515p = r5
            java.lang.Object r14 = r8.invoke(r13, r0)
            if (r14 != r1) goto L_0x00eb
            return r1
        L_0x00eb:
            r10 = r14
            r14 = r13
            r13 = r15
            r15 = r10
        L_0x00ef:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x011f
            long r14 = r13.element
            r0.f55507h = r9
            r0.f55508i = r8
            r0.f55509j = r2
            r0.f55510k = r13
            r0.f55511l = r7
            r0.f55512m = r12
            r0.f55513n = r11
            r0.f55515p = r4
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r14, r0)
            if (r14 != r1) goto L_0x0110
            return r1
        L_0x0110:
            r15 = r13
            r14 = r8
            r13 = r9
            r10 = r1
            r1 = r0
            r0 = r2
            r2 = r10
        L_0x0117:
            long r8 = r13.delay()
            r15.element = r8
            int r11 = r11 + r6
            goto L_0x00b4
        L_0x011f:
            throw r14
        L_0x0120:
            r1.f55507h = r7
            r1.f55508i = r7
            r1.f55509j = r7
            r1.f55510k = r7
            r1.f55515p = r3
            java.lang.Object r15 = r0.invoke(r1)
            if (r15 != r2) goto L_0x0131
            return r2
        L_0x0131:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.UtilsKt.retryIf(int, com.talabat.authentication.natives.Backoff, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: com.talabat.authentication.natives.Backoff$Exponential} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: com.talabat.authentication.natives.Backoff$Exponential} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.talabat.authentication.natives.Backoff$Exponential} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object retryIf$default(int r9, com.talabat.authentication.natives.Backoff r10, kotlin.jvm.functions.Function2 r11, kotlin.jvm.functions.Function1 r12, kotlin.coroutines.Continuation r13, int r14, java.lang.Object r15) {
        /*
            r15 = r14 & 1
            if (r15 == 0) goto L_0x0007
            r9 = 2147483647(0x7fffffff, float:NaN)
        L_0x0007:
            r14 = r14 & 2
            if (r14 == 0) goto L_0x0019
            com.talabat.authentication.natives.Backoff$Exponential r10 = new com.talabat.authentication.natives.Backoff$Exponential
            r1 = 0
            r3 = 0
            r5 = 0
            r7 = 7
            r8 = 0
            r0 = r10
            r0.<init>(r1, r3, r5, r7, r8)
        L_0x0019:
            java.lang.Object r9 = retryIf(r9, r10, r11, r12, r13)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.UtilsKt.retryIf$default(int, com.talabat.authentication.natives.Backoff, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation, int, java.lang.Object):java.lang.Object");
    }
}
