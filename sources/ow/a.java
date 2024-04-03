package ow;

import android.location.Location;
import com.google.android.gms.tasks.OnSuccessListener;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.VendorOffersFragment;

public final /* synthetic */ class a implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorOffersFragment f24031a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorDisplayModel f24032b;

    public /* synthetic */ a(VendorOffersFragment vendorOffersFragment, VendorDisplayModel vendorDisplayModel) {
        this.f24031a = vendorOffersFragment;
        this.f24032b = vendorDisplayModel;
    }

    public final void onSuccess(Object obj) {
        VendorOffersFragment.m5863loadVendorBranches$lambda17$lambda16(this.f24031a, this.f24032b, (Location) obj);
    }
}
