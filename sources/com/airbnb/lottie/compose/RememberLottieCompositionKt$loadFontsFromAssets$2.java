package com.airbnb.lottie.compose;

import android.content.Context;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.Font;
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
@DebugMetadata(c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$loadFontsFromAssets$2", f = "rememberLottieComposition.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RememberLottieCompositionKt$loadFontsFromAssets$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f40596h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LottieComposition f40597i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Context f40598j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f40599k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f40600l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RememberLottieCompositionKt$loadFontsFromAssets$2(LottieComposition lottieComposition, Context context, String str, String str2, Continuation<? super RememberLottieCompositionKt$loadFontsFromAssets$2> continuation) {
        super(2, continuation);
        this.f40597i = lottieComposition;
        this.f40598j = context;
        this.f40599k = str;
        this.f40600l = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RememberLottieCompositionKt$loadFontsFromAssets$2(this.f40597i, this.f40598j, this.f40599k, this.f40600l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RememberLottieCompositionKt$loadFontsFromAssets$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f40596h == 0) {
            ResultKt.throwOnFailure(obj);
            for (Font next : this.f40597i.getFonts().values()) {
                Context context = this.f40598j;
                Intrinsics.checkNotNullExpressionValue(next, "font");
                RememberLottieCompositionKt.maybeLoadTypefaceFromAssets(context, next, this.f40599k, this.f40600l);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
