package nw;

import android.view.View;
import com.talabat.talabatlife.ui.vendorList.views.VendorLocationFilterAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorLocationFilterAdapter f24005b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f24006c;

    public /* synthetic */ a(VendorLocationFilterAdapter vendorLocationFilterAdapter, int i11) {
        this.f24005b = vendorLocationFilterAdapter;
        this.f24006c = i11;
    }

    public final void onClick(View view) {
        VendorLocationFilterAdapter.m5855onBindViewHolder$lambda0(this.f24005b, this.f24006c, view);
    }
}
