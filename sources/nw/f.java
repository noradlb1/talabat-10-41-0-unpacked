package nw;

import android.view.View;
import com.talabat.talabatlife.ui.vendorList.views.VendorsListAdaptor;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListAdaptor f24010b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f24011c;

    public /* synthetic */ f(VendorsListAdaptor vendorsListAdaptor, int i11) {
        this.f24010b = vendorsListAdaptor;
        this.f24011c = i11;
    }

    public final void onClick(View view) {
        VendorsListAdaptor.m5861bindVendorView$lambda1$lambda0(this.f24010b, this.f24011c, view);
    }
}
