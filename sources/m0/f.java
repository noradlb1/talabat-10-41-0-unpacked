package m0;

import android.view.ViewTreeObserver;
import androidx.compose.ui.platform.AndroidComposeView;

public final /* synthetic */ class f implements ViewTreeObserver.OnTouchModeChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f11602b;

    public /* synthetic */ f(AndroidComposeView androidComposeView) {
        this.f11602b = androidComposeView;
    }

    public final void onTouchModeChanged(boolean z11) {
        AndroidComposeView.m4801touchModeChangeListener$lambda3(this.f11602b, z11);
    }
}
