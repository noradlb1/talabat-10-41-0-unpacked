package d4;

import android.view.View;
import android.view.ViewParent;
import com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f44279b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InAppMessageImmersiveBaseView f44280c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ViewParent f44281d;

    public /* synthetic */ c(View view, InAppMessageImmersiveBaseView inAppMessageImmersiveBaseView, ViewParent viewParent) {
        this.f44279b = view;
        this.f44280c = inAppMessageImmersiveBaseView;
        this.f44281d = viewParent;
    }

    public final void run() {
        InAppMessageImmersiveBaseView.m9219setLargerCloseButtonClickArea$lambda5(this.f44279b, this.f44280c, this.f44281d);
    }
}
