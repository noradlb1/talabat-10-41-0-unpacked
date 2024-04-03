package com.airbnb.lottie.compose;

import android.content.Context;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a_\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"animateLottieCompositionAsState", "Lcom/airbnb/lottie/compose/LottieAnimationState;", "composition", "Lcom/airbnb/lottie/LottieComposition;", "isPlaying", "", "restartOnPlay", "clipSpec", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "speed", "", "iterations", "", "cancellationBehavior", "Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "ignoreSystemAnimatorScale", "(Lcom/airbnb/lottie/LottieComposition;ZZLcom/airbnb/lottie/compose/LottieClipSpec;FILcom/airbnb/lottie/compose/LottieCancellationBehavior;ZLandroidx/compose/runtime/Composer;II)Lcom/airbnb/lottie/compose/LottieAnimationState;", "lottie-compose_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class AnimateLottieCompositionAsStateKt {
    @NotNull
    @Composable
    public static final LottieAnimationState animateLottieCompositionAsState(@Nullable LottieComposition lottieComposition, boolean z11, boolean z12, @Nullable LottieClipSpec lottieClipSpec, float f11, int i11, @Nullable LottieCancellationBehavior lottieCancellationBehavior, boolean z13, @Nullable Composer composer, int i12, int i13) {
        boolean z14;
        boolean z15;
        LottieClipSpec lottieClipSpec2;
        float f12;
        int i14;
        LottieCancellationBehavior lottieCancellationBehavior2;
        boolean z16;
        boolean z17;
        boolean z18;
        Composer composer2 = composer;
        int i15 = i13;
        composer2.startReplaceableGroup(-180607952);
        if ((i15 & 2) != 0) {
            z14 = true;
        } else {
            z14 = z11;
        }
        if ((i15 & 4) != 0) {
            z15 = true;
        } else {
            z15 = z12;
        }
        if ((i15 & 8) != 0) {
            lottieClipSpec2 = null;
        } else {
            lottieClipSpec2 = lottieClipSpec;
        }
        if ((i15 & 16) != 0) {
            f12 = 1.0f;
        } else {
            f12 = f11;
        }
        if ((i15 & 32) != 0) {
            i14 = 1;
        } else {
            i14 = i11;
        }
        if ((i15 & 64) != 0) {
            lottieCancellationBehavior2 = LottieCancellationBehavior.Immediately;
        } else {
            lottieCancellationBehavior2 = lottieCancellationBehavior;
        }
        if ((i15 & 128) != 0) {
            z16 = false;
        } else {
            z16 = z13;
        }
        if (i14 > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (Float.isInfinite(f12) || Float.isNaN(f12)) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                LottieAnimatable rememberLottieAnimatable = LottieAnimatableKt.rememberLottieAnimatable(composer2, 0);
                composer2.startReplaceableGroup(-3687241);
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z14), (SnapshotMutationPolicy) null, 2, (Object) null);
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                MutableState mutableState = (MutableState) rememberedValue;
                if (z16) {
                    composer2.startReplaceableGroup(-180607158);
                } else {
                    composer2.startReplaceableGroup(-180607146);
                    f12 /= Utils.getAnimationScale((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                }
                composer.endReplaceableGroup();
                float f13 = f12;
                EffectsKt.LaunchedEffect(new Object[]{lottieComposition, Boolean.valueOf(z14), lottieClipSpec2, Float.valueOf(f13), Integer.valueOf(i14)}, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3(z14, z15, rememberLottieAnimatable, lottieComposition, i14, f13, lottieClipSpec2, lottieCancellationBehavior2, mutableState, (Continuation<? super AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3>) null), composer2, 8);
                composer.endReplaceableGroup();
                return rememberLottieAnimatable;
            }
            throw new IllegalArgumentException(("Speed must be a finite number. It is " + f12 + '.').toString());
        }
        throw new IllegalArgumentException(("Iterations must be a positive number (" + i14 + ").").toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: animateLottieCompositionAsState$lambda-3  reason: not valid java name */
    public static final boolean m9138animateLottieCompositionAsState$lambda3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: animateLottieCompositionAsState$lambda-4  reason: not valid java name */
    public static final void m9139animateLottieCompositionAsState$lambda4(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }
}
