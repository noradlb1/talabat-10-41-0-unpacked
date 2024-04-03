package androidx.tracing;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001aG\u0010\u0007\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u001e\b\u0004\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bHHø\u0001\u0001¢\u0006\u0002\u0010\u000e\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"trace", "T", "label", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "traceAsync", "methodName", "cookie", "", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tracing-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TraceKt {
    public static final <T> T trace(@NotNull String str, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            Trace.beginSection(str);
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            Trace.endSection();
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object traceAsync(@org.jetbrains.annotations.NotNull java.lang.String r4, int r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r7) {
        /*
            boolean r0 = r7 instanceof androidx.tracing.TraceKt$traceAsync$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.tracing.TraceKt$traceAsync$1 r0 = (androidx.tracing.TraceKt$traceAsync$1) r0
            int r1 = r0.f37717k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f37717k = r1
            goto L_0x0018
        L_0x0013:
            androidx.tracing.TraceKt$traceAsync$1 r0 = new androidx.tracing.TraceKt$traceAsync$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f37716j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f37717k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            int r5 = r0.f37715i
            java.lang.Object r4 = r0.f37714h
            java.lang.String r4 = (java.lang.String) r4
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0054 }
            goto L_0x004a
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.tracing.Trace.beginAsyncSection(r4, r5)     // Catch:{ all -> 0x0054 }
            r0.f37714h = r4     // Catch:{ all -> 0x0054 }
            r0.f37715i = r5     // Catch:{ all -> 0x0054 }
            r0.f37717k = r3     // Catch:{ all -> 0x0054 }
            java.lang.Object r7 = r6.invoke(r0)     // Catch:{ all -> 0x0054 }
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            return r7
        L_0x0054:
            r6 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.tracing.TraceKt.traceAsync(java.lang.String, int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <T> Object traceAsync$$forInline(String str, int i11, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        try {
            Trace.beginAsyncSection(str, i11);
            return function1.invoke(continuation);
        } finally {
            InlineMarker.finallyStart(1);
            Trace.endAsyncSection(str, i11);
            InlineMarker.finallyEnd(1);
        }
    }
}
