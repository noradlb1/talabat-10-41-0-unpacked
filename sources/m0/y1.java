package m0;

import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class y1 implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractComposeView f11605b;

    public /* synthetic */ y1(AbstractComposeView abstractComposeView) {
        this.f11605b = abstractComposeView;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ViewCompositionStrategy_androidKt.m4880installForLifecycle$lambda1(this.f11605b, lifecycleOwner, event);
    }
}
