package d4;

import com.braze.ui.inappmessage.views.InAppMessageModalView;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InAppMessageModalView f44282b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f44283c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f44284d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f44285e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ double f44286f;

    public /* synthetic */ d(InAppMessageModalView inAppMessageModalView, int i11, int i12, int i13, double d11) {
        this.f44282b = inAppMessageModalView;
        this.f44283c = i11;
        this.f44284d = i12;
        this.f44285e = i13;
        this.f44286f = d11;
    }

    public final void run() {
        InAppMessageModalView.m9222resizeGraphicFrameIfAppropriate$lambda2(this.f44282b, this.f44283c, this.f44284d, this.f44285e, this.f44286f);
    }
}
