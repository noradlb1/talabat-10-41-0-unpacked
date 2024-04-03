package com.deliveryhero.performance.core.logger;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.performance.core.logger.LoggerFileWriter$job$1", f = "LoggerFileWriter.kt", i = {0}, l = {26}, m = "invokeSuspend", n = {"writer"}, s = {"L$2"})
public final class LoggerFileWriter$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f30355h;

    /* renamed from: i  reason: collision with root package name */
    public Object f30356i;

    /* renamed from: j  reason: collision with root package name */
    public Object f30357j;

    /* renamed from: k  reason: collision with root package name */
    public int f30358k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ LoggerFileWriter f30359l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoggerFileWriter$job$1(LoggerFileWriter loggerFileWriter, Continuation<? super LoggerFileWriter$job$1> continuation) {
        super(2, continuation);
        this.f30359l = loggerFileWriter;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LoggerFileWriter$job$1(this.f30359l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LoggerFileWriter$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f30358k
            r2 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r6.f30357j
            java.io.BufferedWriter r1 = (java.io.BufferedWriter) r1
            java.lang.Object r3 = r6.f30356i
            com.deliveryhero.performance.core.logger.LoggerFileWriter r3 = (com.deliveryhero.performance.core.logger.LoggerFileWriter) r3
            java.lang.Object r4 = r6.f30355h
            java.io.Closeable r4 = (java.io.Closeable) r4
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x001b }
            goto L_0x004e
        L_0x001b:
            r7 = move-exception
            goto L_0x0071
        L_0x001d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r7)
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            com.deliveryhero.performance.core.logger.LoggerFileWriter r1 = r6.f30359l
            java.io.File r1 = r1.getFile()
            r7.<init>(r1, r2)
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter
            r3.<init>(r7, r1)
            boolean r7 = r3 instanceof java.io.BufferedWriter
            if (r7 == 0) goto L_0x0041
            java.io.BufferedWriter r3 = (java.io.BufferedWriter) r3
            goto L_0x0049
        L_0x0041:
            java.io.BufferedWriter r7 = new java.io.BufferedWriter
            r1 = 8192(0x2000, float:1.14794E-41)
            r7.<init>(r3, r1)
            r3 = r7
        L_0x0049:
            com.deliveryhero.performance.core.logger.LoggerFileWriter r7 = r6.f30359l
            r1 = r3
            r4 = r1
            r3 = r7
        L_0x004e:
            r7 = r6
        L_0x004f:
            java.util.concurrent.ArrayBlockingQueue r5 = r3.getQueue()     // Catch:{ all -> 0x001b }
            java.lang.Object r5 = r5.take()     // Catch:{ all -> 0x001b }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x001b }
            r1.write(r5)     // Catch:{ all -> 0x001b }
            r1.newLine()     // Catch:{ all -> 0x001b }
            r1.flush()     // Catch:{ all -> 0x001b }
            r7.f30355h = r4     // Catch:{ all -> 0x001b }
            r7.f30356i = r3     // Catch:{ all -> 0x001b }
            r7.f30357j = r1     // Catch:{ all -> 0x001b }
            r7.f30358k = r2     // Catch:{ all -> 0x001b }
            java.lang.Object r5 = kotlinx.coroutines.YieldKt.yield(r7)     // Catch:{ all -> 0x001b }
            if (r5 != r0) goto L_0x004f
            return r0
        L_0x0071:
            throw r7     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.performance.core.logger.LoggerFileWriter$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
