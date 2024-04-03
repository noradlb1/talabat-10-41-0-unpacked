package com.designsystem.ds_progressive_offer;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt$ProgressiveOfferSurface$countDownTimer$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Long> f32538g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$ProgressiveOfferSurface$countDownTimer$1$1(MutableState<Long> mutableState) {
        super(0);
        this.f32538g = mutableState;
    }

    public final void invoke() {
        MutableState<Long> mutableState = this.f32538g;
        ProgressiveOfferComposablesKt.m8534ProgressiveOfferSurface$lambda4(mutableState, ProgressiveOfferComposablesKt.m8533ProgressiveOfferSurface$lambda3(mutableState) - ((long) 1000));
    }
}
