package com.designsystem.ds_stepper;

import android.view.View;
import com.designsystem.extensions.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperCounterComposablesKt$MM1StepperCounter$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f32994g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32995h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperCounterComposablesKt$MM1StepperCounter$1$1(View view, Function0<Unit> function0) {
        super(0);
        this.f32994g = view;
        this.f32995h = function0;
    }

    public final void invoke() {
        ViewExtensionsKt.performSelectionFeedback(this.f32994g);
        this.f32995h.invoke();
    }
}
