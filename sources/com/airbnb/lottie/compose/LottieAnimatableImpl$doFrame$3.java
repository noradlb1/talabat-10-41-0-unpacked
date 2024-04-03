package com.airbnb.lottie.compose;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "frameNanos", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class LottieAnimatableImpl$doFrame$3 extends Lambda implements Function1<Long, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LottieAnimatableImpl f40505g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f40506h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieAnimatableImpl$doFrame$3(LottieAnimatableImpl lottieAnimatableImpl, int i11) {
        super(1);
        this.f40505g = lottieAnimatableImpl;
        this.f40506h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }

    @NotNull
    public final Boolean invoke(long j11) {
        return Boolean.valueOf(this.f40505g.onFrame(this.f40506h, j11));
    }
}
