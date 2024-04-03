package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0007\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class LottieAnimatableImpl$endProgress$2 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LottieAnimatableImpl f40507g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieAnimatableImpl$endProgress$2(LottieAnimatableImpl lottieAnimatableImpl) {
        super(0);
        this.f40507g = lottieAnimatableImpl;
    }

    @NotNull
    public final Float invoke() {
        LottieComposition composition = this.f40507g.getComposition();
        float f11 = 0.0f;
        if (composition != null) {
            if (this.f40507g.getSpeed() < 0.0f) {
                LottieClipSpec clipSpec = this.f40507g.getClipSpec();
                if (clipSpec != null) {
                    f11 = clipSpec.getMinProgress$lottie_compose_release(composition);
                }
            } else {
                LottieClipSpec clipSpec2 = this.f40507g.getClipSpec();
                f11 = clipSpec2 == null ? 1.0f : clipSpec2.getMaxProgress$lottie_compose_release(composition);
            }
        }
        return Float.valueOf(f11);
    }
}
