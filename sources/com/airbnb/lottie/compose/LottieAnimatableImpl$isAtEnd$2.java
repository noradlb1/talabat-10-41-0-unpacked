package com.airbnb.lottie.compose;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u000b\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class LottieAnimatableImpl$isAtEnd$2 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LottieAnimatableImpl f40508g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieAnimatableImpl$isAtEnd$2(LottieAnimatableImpl lottieAnimatableImpl) {
        super(0);
        this.f40508g = lottieAnimatableImpl;
    }

    @NotNull
    public final Boolean invoke() {
        boolean z11 = false;
        if (this.f40508g.getIteration() == this.f40508g.getIterations()) {
            if (this.f40508g.getProgress() == this.f40508g.getEndProgress()) {
                z11 = true;
            }
        }
        return Boolean.valueOf(z11);
    }
}
