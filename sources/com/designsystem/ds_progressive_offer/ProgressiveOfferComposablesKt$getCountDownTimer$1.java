package com.designsystem.ds_progressive_offer;

import android.os.CountDownTimer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/designsystem/ds_progressive_offer/ProgressiveOfferComposablesKt$getCountDownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt$getCountDownTimer$1 extends CountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32542a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32543b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f32544c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$getCountDownTimer$1(Function0<Unit> function0, Function0<Unit> function02, long j11, long j12) {
        super(j11, j12);
        this.f32542a = function0;
        this.f32543b = function02;
        this.f32544c = j11;
    }

    public void onFinish() {
        this.f32543b.invoke();
    }

    public void onTick(long j11) {
        this.f32542a.invoke();
    }
}
