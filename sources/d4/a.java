package d4;

import android.view.View;
import com.braze.ui.inappmessage.views.InAppMessageFullView;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InAppMessageFullView f44276b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f44277c;

    public /* synthetic */ a(InAppMessageFullView inAppMessageFullView, View view) {
        this.f44276b = inAppMessageFullView;
        this.f44277c = view;
    }

    public final void onClick(View view) {
        InAppMessageFullView.m9218resetMessageMargins$lambda2$lambda1(this.f44276b, this.f44277c, view);
    }
}
