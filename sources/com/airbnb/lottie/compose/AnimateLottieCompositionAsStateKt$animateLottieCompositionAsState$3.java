package com.airbnb.lottie.compose;

import androidx.compose.runtime.MutableState;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimatable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3", f = "animateLottieCompositionAsState.kt", i = {}, l = {68, 73}, m = "invokeSuspend", n = {}, s = {})
public final class AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f40477h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f40478i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f40479j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LottieAnimatable f40480k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ LottieComposition f40481l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f40482m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f40483n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ LottieClipSpec f40484o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ LottieCancellationBehavior f40485p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f40486q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3(boolean z11, boolean z12, LottieAnimatable lottieAnimatable, LottieComposition lottieComposition, int i11, float f11, LottieClipSpec lottieClipSpec, LottieCancellationBehavior lottieCancellationBehavior, MutableState<Boolean> mutableState, Continuation<? super AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3> continuation) {
        super(2, continuation);
        this.f40478i = z11;
        this.f40479j = z12;
        this.f40480k = lottieAnimatable;
        this.f40481l = lottieComposition;
        this.f40482m = i11;
        this.f40483n = f11;
        this.f40484o = lottieClipSpec;
        this.f40485p = lottieCancellationBehavior;
        this.f40486q = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3(this.f40478i, this.f40479j, this.f40480k, this.f40481l, this.f40482m, this.f40483n, this.f40484o, this.f40485p, this.f40486q, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f40477h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f40478i && !AnimateLottieCompositionAsStateKt.m9138animateLottieCompositionAsState$lambda3(this.f40486q) && this.f40479j) {
                LottieAnimatable lottieAnimatable = this.f40480k;
                this.f40477h = 1;
                if (LottieAnimatableKt.resetToBeginning(lottieAnimatable, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnimateLottieCompositionAsStateKt.m9139animateLottieCompositionAsState$lambda4(this.f40486q, this.f40478i);
        if (!this.f40478i) {
            return Unit.INSTANCE;
        }
        LottieAnimatable lottieAnimatable2 = this.f40480k;
        LottieComposition lottieComposition = this.f40481l;
        int i12 = this.f40482m;
        float f11 = this.f40483n;
        LottieClipSpec lottieClipSpec = this.f40484o;
        float progress = lottieAnimatable2.getProgress();
        LottieCancellationBehavior lottieCancellationBehavior = this.f40485p;
        this.f40477h = 2;
        if (LottieAnimatable.DefaultImpls.animate$default(lottieAnimatable2, lottieComposition, 0, i12, f11, lottieClipSpec, progress, false, lottieCancellationBehavior, false, this, BZip2Constants.MAX_ALPHA_SIZE, (Object) null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
