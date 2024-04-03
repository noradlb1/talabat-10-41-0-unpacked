package ju;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.sdsquad.ui.restaurantssearch.VendorSearchFragment;

public final /* synthetic */ class c implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorSearchFragment f62208b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62209c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62210d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f62211e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f62212f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f62213g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f62214h;

    public /* synthetic */ c(VendorSearchFragment vendorSearchFragment, String str, String str2, int i11, int i12, int i13, int i14) {
        this.f62208b = vendorSearchFragment;
        this.f62209c = str;
        this.f62210d = str2;
        this.f62211e = i11;
        this.f62212f = i12;
        this.f62213g = i13;
        this.f62214h = i14;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return VendorSearchFragment.m10830onActivityCreated$lambda2(this.f62208b, this.f62209c, this.f62210d, this.f62211e, this.f62212f, this.f62213g, this.f62214h, textView, i11, keyEvent);
    }
}
