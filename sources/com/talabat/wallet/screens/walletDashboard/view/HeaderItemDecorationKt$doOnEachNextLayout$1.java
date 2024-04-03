package com.talabat.wallet.screens.walletDashboard.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class HeaderItemDecorationKt$doOnEachNextLayout$1 implements View.OnLayoutChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<View, Unit> f12683b;

    public HeaderItemDecorationKt$doOnEachNextLayout$1(Function1<? super View, Unit> function1) {
        this.f12683b = function1;
    }

    public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        Function1<View, Unit> function1 = this.f12683b;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        function1.invoke(view);
    }
}
