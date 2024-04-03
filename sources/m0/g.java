package m0;

import androidx.compose.ui.platform.AndroidComposeView;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f11603b;

    public /* synthetic */ g(AndroidComposeView androidComposeView) {
        this.f11603b = androidComposeView;
    }

    public final void run() {
        AndroidComposeView.m4799sendHoverExitEvent$lambda5(this.f11603b);
    }
}
