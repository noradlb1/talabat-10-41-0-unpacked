package pw;

import android.view.View;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.views.branch.VendorBranchBase;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f24051b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VendorBranchDisplayModel f24052c;

    public /* synthetic */ a(View view, VendorBranchDisplayModel vendorBranchDisplayModel) {
        this.f24051b = view;
        this.f24052c = vendorBranchDisplayModel;
    }

    public final void onClick(View view) {
        VendorBranchBase.DefaultImpls.m5867setMapsOnClickListener$lambda2(this.f24051b, this.f24052c, view);
    }
}
