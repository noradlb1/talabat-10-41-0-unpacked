package a4;

import android.content.Context;
import android.view.View;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageFullViewFactory;
import com.braze.ui.inappmessage.views.InAppMessageFullView;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f35600b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InAppMessageFullView f35601c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ InAppMessageFull f35602d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f35603e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f35604f;

    public /* synthetic */ a(View view, InAppMessageFullView inAppMessageFullView, InAppMessageFull inAppMessageFull, Context context, View view2) {
        this.f35600b = view;
        this.f35601c = inAppMessageFullView;
        this.f35602d = inAppMessageFull;
        this.f35603e = context;
        this.f35604f = view2;
    }

    public final void run() {
        DefaultInAppMessageFullViewFactory.m9215createInAppMessageView$lambda4(this.f35600b, this.f35601c, this.f35602d, this.f35603e, this.f35604f);
    }
}
