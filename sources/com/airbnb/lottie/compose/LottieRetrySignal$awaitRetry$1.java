package com.airbnb.lottie.compose;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.airbnb.lottie.compose.LottieRetrySignal", f = "LottieRetrySignal.kt", i = {0}, l = {45}, m = "awaitRetry", n = {"this"}, s = {"L$0"})
public final class LottieRetrySignal$awaitRetry$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f40587h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f40588i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LottieRetrySignal f40589j;

    /* renamed from: k  reason: collision with root package name */
    public int f40590k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieRetrySignal$awaitRetry$1(LottieRetrySignal lottieRetrySignal, Continuation<? super LottieRetrySignal$awaitRetry$1> continuation) {
        super(continuation);
        this.f40589j = lottieRetrySignal;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f40588i = obj;
        this.f40590k |= Integer.MIN_VALUE;
        return this.f40589j.awaitRetry(this);
    }
}
