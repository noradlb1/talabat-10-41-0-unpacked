package com.talabat.talabatcommon.lifecycle;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/talabat/talabatcommon/lifecycle/AutoDisposableKt$autoDisposeView$3", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "p0", "Landroid/view/View;", "onViewDetachedFromWindow", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoDisposableKt$autoDisposeView$3 implements View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f61751b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f61752c;

    public AutoDisposableKt$autoDisposeView$3(Function0<Unit> function0, AutoDisposable autoDisposable) {
        this.f61751b = function0;
        this.f61752c = autoDisposable;
    }

    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "p0");
        this.f61751b.invoke();
    }

    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "p0");
        this.f61752c.onCleared();
    }
}
