package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlinx.coroutines.channels.ProducerScope;

public final /* synthetic */ class b implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProducerScope f489b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f490c;

    public /* synthetic */ b(ProducerScope producerScope, View view) {
        this.f489b = producerScope;
        this.f490c = view;
    }

    public final void onScrollChanged() {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.m2invokeSuspend$lambda1(this.f489b, this.f490c);
    }
}
