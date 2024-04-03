package m0;

import android.view.ViewTreeObserver;
import androidx.compose.ui.platform.AndroidComposeView;

public final /* synthetic */ class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f11600b;

    public /* synthetic */ d(AndroidComposeView androidComposeView) {
        this.f11600b = androidComposeView;
    }

    public final void onGlobalLayout() {
        AndroidComposeView.m4796globalLayoutListener$lambda1(this.f11600b);
    }
}
