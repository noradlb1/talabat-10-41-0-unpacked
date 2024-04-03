package com.deliveryhero.performance.core.tapresponse;

import android.view.View;
import android.view.Window;
import curtains.OnRootViewAddedListener;
import curtains.WindowsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "onRootViewAdded"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TapResponseTimeInitializer$initialize$1 implements OnRootViewAddedListener {
    public static final TapResponseTimeInitializer$initialize$1 INSTANCE = new TapResponseTimeInitializer$initialize$1();

    public final void onRootViewAdded(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Window phoneWindow = WindowsKt.getPhoneWindow(view);
        if (phoneWindow != null && WindowsKt.getWindowAttachCount(view) == 0) {
            TapTracker tapTracker = TapTracker.INSTANCE;
            WindowsKt.getTouchEventInterceptors(phoneWindow).add(tapTracker);
            WindowsKt.getKeyEventInterceptors(phoneWindow).add(tapTracker);
        }
    }

    public void onRootViewsChanged(@NotNull View view, boolean z11) {
        OnRootViewAddedListener.DefaultImpls.onRootViewsChanged(this, view, z11);
    }
}
