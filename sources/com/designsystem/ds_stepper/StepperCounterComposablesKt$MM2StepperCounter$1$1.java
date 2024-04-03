package com.designsystem.ds_stepper;

import android.view.View;
import com.designsystem.extensions.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperCounterComposablesKt$MM2StepperCounter$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f33005g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33006h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperCounterComposablesKt$MM2StepperCounter$1$1(View view, Function0<Unit> function0) {
        super(0);
        this.f33005g = view;
        this.f33006h = function0;
    }

    public final void invoke() {
        ViewExtensionsKt.performSelectionFeedback(this.f33005g);
        this.f33006h.invoke();
    }
}
