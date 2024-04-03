package com.deliveryhero.fluid.widgets.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0000H\n¨\u0006\u0001"}, d2 = {"", "androidx/core/view/ViewKt$doOnPreDraw$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class LayoutParamsUtilsKt$updateLayoutParams$$inlined$doOnPreDraw$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f30289b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f30290c;

    public LayoutParamsUtilsKt$updateLayoutParams$$inlined$doOnPreDraw$1(Function1 function1, View view) {
        this.f30289b = function1;
        this.f30290c = view;
    }

    public final void run() {
        this.f30289b.invoke(this.f30290c);
    }
}
