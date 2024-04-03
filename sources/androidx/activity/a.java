package androidx.activity;

import android.view.View;
import kotlinx.coroutines.channels.ProducerScope;

public final /* synthetic */ class a implements View.OnLayoutChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProducerScope f488b;

    public /* synthetic */ a(ProducerScope producerScope) {
        this.f488b = producerScope;
    }

    public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.m1invokeSuspend$lambda0(this.f488b, view, i11, i12, i13, i14, i15, i16, i17, i18);
    }
}
