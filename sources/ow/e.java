package ow;

import android.view.View;
import com.talabat.talabatlife.ui.vendorOffers.VendorOffersFragment;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchListDisplayModel;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorOffersFragment f24037b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VendorBranchListDisplayModel f24038c;

    public /* synthetic */ e(VendorOffersFragment vendorOffersFragment, VendorBranchListDisplayModel vendorBranchListDisplayModel) {
        this.f24037b = vendorOffersFragment;
        this.f24038c = vendorBranchListDisplayModel;
    }

    public final void onClick(View view) {
        VendorOffersFragment.m5866updateBranches$lambda6$lambda5(this.f24037b, this.f24038c, view);
    }
}
