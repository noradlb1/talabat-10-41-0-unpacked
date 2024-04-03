package com.airbnb.lottie.compose;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$1", f = "rememberLottieComposition.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RememberLottieCompositionKt$rememberLottieComposition$1 extends SuspendLambda implements Function3<Integer, Throwable, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f40611h;

    public RememberLottieCompositionKt$rememberLottieComposition$1(Continuation<? super RememberLottieCompositionKt$rememberLottieComposition$1> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(int i11, @NotNull Throwable th2, @Nullable Continuation<? super Boolean> continuation) {
        return new RememberLottieCompositionKt$rememberLottieComposition$1(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).intValue(), (Throwable) obj2, (Continuation<? super Boolean>) (Continuation) obj3);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f40611h == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(false);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
