package com.airbnb.lottie.compose;

import androidx.compose.runtime.State;
import com.airbnb.lottie.value.LottieFrameInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class LottieDynamicPropertiesKt$rememberLottieDynamicProperty$2$1 extends Lambda implements Function1<LottieFrameInfo<T>, T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Function1<LottieFrameInfo<T>, T>> f40584g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieDynamicPropertiesKt$rememberLottieDynamicProperty$2$1(State<? extends Function1<? super LottieFrameInfo<T>, ? extends T>> state) {
        super(1);
        this.f40584g = state;
    }

    public final T invoke(@NotNull LottieFrameInfo<T> lottieFrameInfo) {
        Intrinsics.checkNotNullParameter(lottieFrameInfo, "it");
        return LottieDynamicPropertiesKt.m9190rememberLottieDynamicProperty$lambda4(this.f40584g).invoke(lottieFrameInfo);
    }
}
