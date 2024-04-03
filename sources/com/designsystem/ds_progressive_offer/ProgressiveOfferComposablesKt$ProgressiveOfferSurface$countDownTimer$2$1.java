package com.designsystem.ds_progressive_offer;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt$ProgressiveOfferSurface$countDownTimer$2$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Long> f32539g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f32540h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$ProgressiveOfferSurface$countDownTimer$2$1(MutableState<Long> mutableState, MutableState<Boolean> mutableState2) {
        super(0);
        this.f32539g = mutableState;
        this.f32540h = mutableState2;
    }

    public final void invoke() {
        ProgressiveOfferComposablesKt.m8534ProgressiveOfferSurface$lambda4(this.f32539g, 0);
        ProgressiveOfferComposablesKt.m8522ProgressiveOfferSurface$lambda1(this.f32540h, true);
    }
}
