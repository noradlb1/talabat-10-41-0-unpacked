package com.airbnb.lottie.compose;

import android.content.Context;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$loadImagesFromAssets$2", f = "rememberLottieComposition.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RememberLottieCompositionKt$loadImagesFromAssets$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f40601h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LottieComposition f40602i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Context f40603j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f40604k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RememberLottieCompositionKt$loadImagesFromAssets$2(LottieComposition lottieComposition, Context context, String str, Continuation<? super RememberLottieCompositionKt$loadImagesFromAssets$2> continuation) {
        super(2, continuation);
        this.f40602i = lottieComposition;
        this.f40603j = context;
        this.f40604k = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RememberLottieCompositionKt$loadImagesFromAssets$2(this.f40602i, this.f40603j, this.f40604k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RememberLottieCompositionKt$loadImagesFromAssets$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f40601h == 0) {
            ResultKt.throwOnFailure(obj);
            for (LottieImageAsset next : this.f40602i.getImages().values()) {
                Intrinsics.checkNotNullExpressionValue(next, "asset");
                RememberLottieCompositionKt.maybeDecodeBase64Image(next);
                RememberLottieCompositionKt.maybeLoadImageFromAsset(this.f40603j, next, this.f40604k);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
