package com.airbnb.lottie.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberLottieRetrySignal", "Lcom/airbnb/lottie/compose/LottieRetrySignal;", "(Landroidx/compose/runtime/Composer;I)Lcom/airbnb/lottie/compose/LottieRetrySignal;", "lottie-compose_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LottieRetrySignalKt {
    @NotNull
    @Composable
    public static final LottieRetrySignal rememberLottieRetrySignal(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1025108786);
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LottieRetrySignal();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LottieRetrySignal lottieRetrySignal = (LottieRetrySignal) rememberedValue;
        composer.endReplaceableGroup();
        return lottieRetrySignal;
    }
}
