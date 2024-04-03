package com.airbnb.lottie.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimatable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\r\u0010\t\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\f*\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"LottieAnimatable", "Lcom/airbnb/lottie/compose/LottieAnimatable;", "defaultProgress", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "clipSpec", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "speed", "rememberLottieAnimatable", "(Landroidx/compose/runtime/Composer;I)Lcom/airbnb/lottie/compose/LottieAnimatable;", "resetToBeginning", "", "(Lcom/airbnb/lottie/compose/LottieAnimatable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottie-compose_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LottieAnimatableKt {
    @NotNull
    public static final LottieAnimatable LottieAnimatable() {
        return new LottieAnimatableImpl();
    }

    /* access modifiers changed from: private */
    public static final float defaultProgress(LottieComposition lottieComposition, LottieClipSpec lottieClipSpec, float f11) {
        int i11 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i11 >= 0 || lottieComposition != null) {
            if (lottieComposition == null) {
                return 0.0f;
            }
            if (i11 < 0) {
                if (lottieClipSpec != null) {
                    return lottieClipSpec.getMaxProgress$lottie_compose_release(lottieComposition);
                }
            } else if (lottieClipSpec == null) {
                return 0.0f;
            } else {
                return lottieClipSpec.getMinProgress$lottie_compose_release(lottieComposition);
            }
        }
        return 1.0f;
    }

    @NotNull
    @Composable
    public static final LottieAnimatable rememberLottieAnimatable(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-610207901);
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = LottieAnimatable();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LottieAnimatable lottieAnimatable = (LottieAnimatable) rememberedValue;
        composer.endReplaceableGroup();
        return lottieAnimatable;
    }

    @Nullable
    public static final Object resetToBeginning(@NotNull LottieAnimatable lottieAnimatable, @NotNull Continuation<? super Unit> continuation) {
        Object snapTo$default = LottieAnimatable.DefaultImpls.snapTo$default(lottieAnimatable, (LottieComposition) null, defaultProgress(lottieAnimatable.getComposition(), lottieAnimatable.getClipSpec(), lottieAnimatable.getSpeed()), 1, false, continuation, 9, (Object) null);
        if (snapTo$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return snapTo$default;
        }
        return Unit.INSTANCE;
    }
}
