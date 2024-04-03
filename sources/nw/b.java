package nw;

import android.content.DialogInterface;
import com.talabat.talabatlife.ui.vendorList.views.VendorLocationFilterAdapter;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorLocationFilterAdapter f24007b;

    public /* synthetic */ b(VendorLocationFilterAdapter vendorLocationFilterAdapter) {
        this.f24007b = vendorLocationFilterAdapter;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        VendorLocationFilterAdapter.m5856openAppLocationSettingAlert$lambda1(this.f24007b, dialogInterface, i11);
    }
}
