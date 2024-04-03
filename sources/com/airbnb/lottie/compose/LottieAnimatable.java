package com.airbnb.lottie.compose;

import androidx.compose.runtime.Stable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001Jm\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J;\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/airbnb/lottie/compose/LottieAnimatable;", "Lcom/airbnb/lottie/compose/LottieAnimationState;", "animate", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "iteration", "", "iterations", "speed", "", "clipSpec", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "initialProgress", "continueFromPreviousAnimate", "", "cancellationBehavior", "Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "ignoreSystemAnimationsDisabled", "(Lcom/airbnb/lottie/LottieComposition;IIFLcom/airbnb/lottie/compose/LottieClipSpec;FZLcom/airbnb/lottie/compose/LottieCancellationBehavior;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "progress", "resetLastFrameNanos", "(Lcom/airbnb/lottie/LottieComposition;FIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Stable
public interface LottieAnimatable extends LottieAnimationState {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object animate$default(LottieAnimatable lottieAnimatable, LottieComposition lottieComposition, int i11, int i12, float f11, LottieClipSpec lottieClipSpec, float f12, boolean z11, LottieCancellationBehavior lottieCancellationBehavior, boolean z12, Continuation continuation, int i13, Object obj) {
            int i14;
            int i15;
            float f13;
            LottieClipSpec lottieClipSpec2;
            float f14;
            boolean z13;
            LottieCancellationBehavior lottieCancellationBehavior2;
            boolean z14;
            int i16 = i13;
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i14 = lottieAnimatable.getIteration();
                } else {
                    i14 = i11;
                }
                if ((i16 & 4) != 0) {
                    i15 = lottieAnimatable.getIterations();
                } else {
                    i15 = i12;
                }
                if ((i16 & 8) != 0) {
                    f13 = lottieAnimatable.getSpeed();
                } else {
                    f13 = f11;
                }
                if ((i16 & 16) != 0) {
                    lottieClipSpec2 = lottieAnimatable.getClipSpec();
                } else {
                    lottieClipSpec2 = lottieClipSpec;
                }
                if ((i16 & 32) != 0) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    f14 = LottieAnimatableKt.defaultProgress(lottieComposition, lottieClipSpec2, f13);
                } else {
                    LottieComposition lottieComposition3 = lottieComposition;
                    f14 = f12;
                }
                if ((i16 & 64) != 0) {
                    z13 = false;
                } else {
                    z13 = z11;
                }
                if ((i16 & 128) != 0) {
                    lottieCancellationBehavior2 = LottieCancellationBehavior.Immediately;
                } else {
                    lottieCancellationBehavior2 = lottieCancellationBehavior;
                }
                if ((i16 & 256) != 0) {
                    z14 = false;
                } else {
                    z14 = z12;
                }
                return lottieAnimatable.animate(lottieComposition, i14, i15, f13, lottieClipSpec2, f14, z13, lottieCancellationBehavior2, z14, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animate");
        }

        public static long getLastFrameNanos(@NotNull LottieAnimatable lottieAnimatable) {
            Intrinsics.checkNotNullParameter(lottieAnimatable, "this");
            return LottieAnimationState.DefaultImpls.getLastFrameNanos(lottieAnimatable);
        }

        public static /* synthetic */ Object snapTo$default(LottieAnimatable lottieAnimatable, LottieComposition lottieComposition, float f11, int i11, boolean z11, Continuation continuation, int i12, Object obj) {
            boolean z12;
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    lottieComposition = lottieAnimatable.getComposition();
                }
                LottieComposition lottieComposition2 = lottieComposition;
                if ((i12 & 2) != 0) {
                    f11 = lottieAnimatable.getProgress();
                }
                float f12 = f11;
                if ((i12 & 4) != 0) {
                    i11 = lottieAnimatable.getIteration();
                }
                int i13 = i11;
                if ((i12 & 8) != 0) {
                    if (f12 == lottieAnimatable.getProgress()) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z11 = !z12;
                }
                return lottieAnimatable.snapTo(lottieComposition2, f12, i13, z11, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: snapTo");
        }
    }

    @Nullable
    Object animate(@Nullable LottieComposition lottieComposition, int i11, int i12, float f11, @Nullable LottieClipSpec lottieClipSpec, float f12, boolean z11, @NotNull LottieCancellationBehavior lottieCancellationBehavior, boolean z12, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object snapTo(@Nullable LottieComposition lottieComposition, float f11, int i11, boolean z11, @NotNull Continuation<? super Unit> continuation);
}
