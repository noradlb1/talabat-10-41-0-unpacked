package com.airbnb.lottie.compose;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$3", f = "rememberLottieComposition.kt", i = {0, 0, 1, 1}, l = {90, 92}, m = "invokeSuspend", n = {"exception", "failedCount", "exception", "failedCount"}, s = {"L$0", "I$0", "L$0", "I$0"})
public final class RememberLottieCompositionKt$rememberLottieComposition$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f40612h;

    /* renamed from: i  reason: collision with root package name */
    public int f40613i;

    /* renamed from: j  reason: collision with root package name */
    public int f40614j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<Integer, Throwable, Continuation<? super Boolean>, Object> f40615k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f40616l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ LottieCompositionSpec f40617m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f40618n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f40619o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ String f40620p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ String f40621q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ MutableState<LottieCompositionResultImpl> f40622r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RememberLottieCompositionKt$rememberLottieComposition$3(Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function3, Context context, LottieCompositionSpec lottieCompositionSpec, String str, String str2, String str3, String str4, MutableState<LottieCompositionResultImpl> mutableState, Continuation<? super RememberLottieCompositionKt$rememberLottieComposition$3> continuation) {
        super(2, continuation);
        this.f40615k = function3;
        this.f40616l = context;
        this.f40617m = lottieCompositionSpec;
        this.f40618n = str;
        this.f40619o = str2;
        this.f40620p = str3;
        this.f40621q = str4;
        this.f40622r = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RememberLottieCompositionKt$rememberLottieComposition$3(this.f40615k, this.f40616l, this.f40617m, this.f40618n, this.f40619o, this.f40620p, this.f40621q, this.f40622r, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RememberLottieCompositionKt$rememberLottieComposition$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.f40614j
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 == r3) goto L_0x002a
            if (r1 != r2) goto L_0x0022
            int r1 = r14.f40613i
            java.lang.Object r4 = r14.f40612h
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x001d }
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r14
            goto L_0x00a5
        L_0x001d:
            r15 = move-exception
            r4 = r15
            r15 = r14
            goto L_0x00bd
        L_0x0022:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x002a:
            int r1 = r14.f40613i
            java.lang.Object r4 = r14.f40612h
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            kotlin.ResultKt.throwOnFailure(r15)
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r14
            goto L_0x0069
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = 0
            r1 = 0
            r4 = r15
            r15 = r14
        L_0x003f:
            androidx.compose.runtime.MutableState<com.airbnb.lottie.compose.LottieCompositionResultImpl> r5 = r15.f40622r
            com.airbnb.lottie.compose.LottieCompositionResultImpl r5 = com.airbnb.lottie.compose.RememberLottieCompositionKt.m9192rememberLottieComposition$lambda1(r5)
            boolean r5 = r5.isSuccess()
            if (r5 != 0) goto L_0x00bf
            if (r1 == 0) goto L_0x0079
            kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Throwable, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r5 = r15.f40615k
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r15.f40612h = r4
            r15.f40613i = r1
            r15.f40614j = r3
            java.lang.Object r5 = r5.invoke(r6, r4, r15)
            if (r5 != r0) goto L_0x0063
            return r0
        L_0x0063:
            r13 = r0
            r0 = r15
            r15 = r5
            r5 = r4
            r4 = r1
            r1 = r13
        L_0x0069:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0076
            r15 = r0
            r0 = r1
            r1 = r4
            r4 = r5
            goto L_0x0079
        L_0x0076:
            r15 = r0
            r4 = r5
            goto L_0x00bf
        L_0x0079:
            android.content.Context r6 = r15.f40616l     // Catch:{ all -> 0x00bc }
            com.airbnb.lottie.compose.LottieCompositionSpec r7 = r15.f40617m     // Catch:{ all -> 0x00bc }
            java.lang.String r5 = r15.f40618n     // Catch:{ all -> 0x00bc }
            java.lang.String r8 = com.airbnb.lottie.compose.RememberLottieCompositionKt.ensureTrailingSlash(r5)     // Catch:{ all -> 0x00bc }
            java.lang.String r5 = r15.f40619o     // Catch:{ all -> 0x00bc }
            java.lang.String r9 = com.airbnb.lottie.compose.RememberLottieCompositionKt.ensureTrailingSlash(r5)     // Catch:{ all -> 0x00bc }
            java.lang.String r5 = r15.f40620p     // Catch:{ all -> 0x00bc }
            java.lang.String r10 = com.airbnb.lottie.compose.RememberLottieCompositionKt.ensureLeadingPeriod(r5)     // Catch:{ all -> 0x00bc }
            java.lang.String r11 = r15.f40621q     // Catch:{ all -> 0x00bc }
            r15.f40612h = r4     // Catch:{ all -> 0x00bc }
            r15.f40613i = r1     // Catch:{ all -> 0x00bc }
            r15.f40614j = r2     // Catch:{ all -> 0x00bc }
            r12 = r15
            java.lang.Object r5 = com.airbnb.lottie.compose.RememberLottieCompositionKt.lottieComposition(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00bc }
            if (r5 != r0) goto L_0x009f
            return r0
        L_0x009f:
            r13 = r0
            r0 = r15
            r15 = r5
            r5 = r4
            r4 = r1
            r1 = r13
        L_0x00a5:
            com.airbnb.lottie.LottieComposition r15 = (com.airbnb.lottie.LottieComposition) r15     // Catch:{ all -> 0x00b5 }
            androidx.compose.runtime.MutableState<com.airbnb.lottie.compose.LottieCompositionResultImpl> r6 = r0.f40622r     // Catch:{ all -> 0x00b5 }
            com.airbnb.lottie.compose.LottieCompositionResultImpl r6 = com.airbnb.lottie.compose.RememberLottieCompositionKt.m9192rememberLottieComposition$lambda1(r6)     // Catch:{ all -> 0x00b5 }
            r6.complete$lottie_compose_release(r15)     // Catch:{ all -> 0x00b5 }
            r15 = r0
            r0 = r1
            r1 = r4
            r4 = r5
            goto L_0x003f
        L_0x00b5:
            r15 = move-exception
            r13 = r4
            r4 = r15
            r15 = r0
            r0 = r1
            r1 = r13
            goto L_0x00bd
        L_0x00bc:
            r4 = move-exception
        L_0x00bd:
            int r1 = r1 + r3
            goto L_0x003f
        L_0x00bf:
            androidx.compose.runtime.MutableState<com.airbnb.lottie.compose.LottieCompositionResultImpl> r0 = r15.f40622r
            com.airbnb.lottie.compose.LottieCompositionResultImpl r0 = com.airbnb.lottie.compose.RememberLottieCompositionKt.m9192rememberLottieComposition$lambda1(r0)
            boolean r0 = r0.isComplete()
            if (r0 != 0) goto L_0x00d6
            if (r4 == 0) goto L_0x00d6
            androidx.compose.runtime.MutableState<com.airbnb.lottie.compose.LottieCompositionResultImpl> r15 = r15.f40622r
            com.airbnb.lottie.compose.LottieCompositionResultImpl r15 = com.airbnb.lottie.compose.RememberLottieCompositionKt.m9192rememberLottieComposition$lambda1(r15)
            r15.completeExceptionally$lottie_compose_release(r4)
        L_0x00d6:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
