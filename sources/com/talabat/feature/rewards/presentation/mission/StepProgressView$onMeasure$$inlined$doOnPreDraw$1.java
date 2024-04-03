package com.talabat.feature.rewards.presentation.mission;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class StepProgressView$onMeasure$$inlined$doOnPreDraw$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f58766b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ StepProgressView f58767c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58768d;

    public StepProgressView$onMeasure$$inlined$doOnPreDraw$1(View view, StepProgressView stepProgressView, int i11) {
        this.f58766b = view;
        this.f58767c = stepProgressView;
        this.f58768d = i11;
    }

    public final void run() {
        this.f58767c.makeStepView(this.f58768d);
    }
}
