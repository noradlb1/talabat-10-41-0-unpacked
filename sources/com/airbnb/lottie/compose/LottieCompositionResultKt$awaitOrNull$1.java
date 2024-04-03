package com.airbnb.lottie.compose;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.airbnb.lottie.compose.LottieCompositionResultKt", f = "LottieCompositionResult.kt", i = {}, l = {85}, m = "awaitOrNull", n = {}, s = {})
public final class LottieCompositionResultKt$awaitOrNull$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f40582h;

    /* renamed from: i  reason: collision with root package name */
    public int f40583i;

    public LottieCompositionResultKt$awaitOrNull$1(Continuation<? super LottieCompositionResultKt$awaitOrNull$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f40582h = obj;
        this.f40583i |= Integer.MIN_VALUE;
        return LottieCompositionResultKt.awaitOrNull((LottieCompositionResult) null, this);
    }
}
