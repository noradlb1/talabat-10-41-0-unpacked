package com.airbnb.lottie.compose;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u000b\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class LottieCompositionResultImpl$isSuccess$2 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LottieCompositionResultImpl f40581g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieCompositionResultImpl$isSuccess$2(LottieCompositionResultImpl lottieCompositionResultImpl) {
        super(0);
        this.f40581g = lottieCompositionResultImpl;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(this.f40581g.getValue() != null);
    }
}
