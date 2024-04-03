package m0;

import android.view.ViewTreeObserver;
import androidx.compose.ui.platform.AndroidComposeView;

public final /* synthetic */ class e implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f11601b;

    public /* synthetic */ e(AndroidComposeView androidComposeView) {
        this.f11601b = androidComposeView;
    }

    public final void onScrollChanged() {
        AndroidComposeView.m4798scrollChangedListener$lambda2(this.f11601b);
    }
}
