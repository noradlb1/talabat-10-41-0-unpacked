package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.airbnb.lottie.compose.LottieAnimatableImpl$snapTo$2", f = "LottieAnimatable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LottieAnimatableImpl$snapTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f40509h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LottieAnimatableImpl f40510i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LottieComposition f40511j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f40512k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f40513l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f40514m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieAnimatableImpl$snapTo$2(LottieAnimatableImpl lottieAnimatableImpl, LottieComposition lottieComposition, float f11, int i11, boolean z11, Continuation<? super LottieAnimatableImpl$snapTo$2> continuation) {
        super(1, continuation);
        this.f40510i = lottieAnimatableImpl;
        this.f40511j = lottieComposition;
        this.f40512k = f11;
        this.f40513l = i11;
        this.f40514m = z11;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new LottieAnimatableImpl$snapTo$2(this.f40510i, this.f40511j, this.f40512k, this.f40513l, this.f40514m, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((LottieAnimatableImpl$snapTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f40509h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f40510i.setComposition(this.f40511j);
            this.f40510i.setProgress(this.f40512k);
            this.f40510i.setIteration(this.f40513l);
            this.f40510i.setPlaying(false);
            if (this.f40514m) {
                this.f40510i.setLastFrameNanos(Long.MIN_VALUE);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
