package com.deliveryhero.fluid.widgets.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LayoutParamsUtilsKt$updateLayoutParams$$inlined$doOnAttach$1 implements View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f30287b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f30288c;

    public LayoutParamsUtilsKt$updateLayoutParams$$inlined$doOnAttach$1(View view, Function1 function1) {
        this.f30287b = view;
        this.f30288c = function1;
    }

    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f30287b.removeOnAttachStateChangeListener(this);
        this.f30288c.invoke(view);
    }

    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
