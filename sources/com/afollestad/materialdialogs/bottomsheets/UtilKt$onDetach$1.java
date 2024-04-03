package com.afollestad.materialdialogs.bottomsheets;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/afollestad/materialdialogs/bottomsheets/UtilKt$onDetach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "com.afollestad.material-dialogs.bottomsheets"}, k = 1, mv = {1, 1, 15})
public final class UtilKt$onDetach$1 implements View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f40383b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f40384c;

    public UtilKt$onDetach$1(T t11, Function1 function1) {
        this.f40383b = t11;
        this.f40384c = function1;
    }

    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "v");
    }

    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        this.f40383b.removeOnAttachStateChangeListener(this);
        this.f40384c.invoke(view);
    }
}
