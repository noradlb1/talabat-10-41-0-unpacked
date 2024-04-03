package com.airbnb.lottie.compose;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.airbnb.lottie.compose.RememberLottieCompositionKt", f = "rememberLottieComposition.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {125, 126, 127}, m = "lottieComposition", n = {"context", "imageAssetsFolder", "fontAssetsFolder", "fontFileExtension", "context", "fontAssetsFolder", "fontFileExtension", "composition", "composition"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
public final class RememberLottieCompositionKt$lottieComposition$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f40605h;

    /* renamed from: i  reason: collision with root package name */
    public Object f40606i;

    /* renamed from: j  reason: collision with root package name */
    public Object f40607j;

    /* renamed from: k  reason: collision with root package name */
    public Object f40608k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f40609l;

    /* renamed from: m  reason: collision with root package name */
    public int f40610m;

    public RememberLottieCompositionKt$lottieComposition$1(Continuation<? super RememberLottieCompositionKt$lottieComposition$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f40609l = obj;
        this.f40610m |= Integer.MIN_VALUE;
        return RememberLottieCompositionKt.lottieComposition((Context) null, (LottieCompositionSpec) null, (String) null, (String) null, (String) null, (String) null, this);
    }
}
