package c7;

import android.view.ViewTreeObserver;
import com.facebook.login.widget.ToolTipPopup;

public final /* synthetic */ class h implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ToolTipPopup f29374b;

    public /* synthetic */ h(ToolTipPopup toolTipPopup) {
        this.f29374b = toolTipPopup;
    }

    public final void onScrollChanged() {
        ToolTipPopup.m9009scrollListener$lambda1(this.f29374b);
    }
}
