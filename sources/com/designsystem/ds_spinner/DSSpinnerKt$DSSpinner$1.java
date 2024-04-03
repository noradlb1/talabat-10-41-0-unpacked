package com.designsystem.ds_spinner;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCancellationBehavior;
import com.airbnb.lottie.compose.LottieClipSpec;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.LottieDynamicProperties;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSpinnerKt$DSSpinner$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSSpinnerColor f32771g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32772h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f32773i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSSpinnerSize f32774j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSpinnerKt$DSSpinner$1(DSSpinnerColor dSSpinnerColor, int i11, Modifier modifier, DSSpinnerSize dSSpinnerSize) {
        super(2);
        this.f32771g = dSSpinnerColor;
        this.f32772h = i11;
        this.f32773i = modifier;
        this.f32774j = dSSpinnerSize;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    private static final LottieComposition m8577invoke$lambda0(LottieCompositionResult lottieCompositionResult) {
        return (LottieComposition) lottieCompositionResult.getValue();
    }

    /* renamed from: invoke$lambda-1  reason: not valid java name */
    private static final float m8578invoke$lambda1(LottieAnimationState lottieAnimationState) {
        return ((Number) lottieAnimationState.getValue()).floatValue();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m9175boximpl(LottieCompositionSpec.RawRes.m9176constructorimpl(DSSpinnerKt.value(this.f32771g, composer2, (this.f32772h >> 3) & 14))), (String) null, (String) null, (String) null, (String) null, (Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object>) null, composer, 8, 62);
            LottieAnimationState animateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(m8577invoke$lambda0(rememberLottieComposition), false, false, (LottieClipSpec) null, 0.0f, Integer.MAX_VALUE, (LottieCancellationBehavior) null, false, composer, 196616, 222);
            LottieAnimationKt.LottieAnimation(m8577invoke$lambda0(rememberLottieComposition), m8578invoke$lambda1(animateLottieCompositionAsState), SizeKt.m558size3ABfNKs(this.f32773i, DSSpinnerKt.value(this.f32774j, composer2, (this.f32772h >> 6) & 14)), false, false, false, (RenderMode) null, false, (LottieDynamicProperties) null, (Alignment) null, (ContentScale) null, false, composer, 8, 0, 4088);
            return;
        }
        composer.skipToGroupEnd();
    }
}
