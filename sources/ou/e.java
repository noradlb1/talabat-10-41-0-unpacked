package ou;

import android.view.View;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.VendorCardViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorCardViewHolder f62781b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VendorDisplayModel f62782c;

    public /* synthetic */ e(VendorCardViewHolder vendorCardViewHolder, VendorDisplayModel vendorDisplayModel) {
        this.f62781b = vendorCardViewHolder;
        this.f62782c = vendorDisplayModel;
    }

    public final void onClick(View view) {
        VendorCardViewHolder.m10893bind$lambda0(this.f62781b, this.f62782c, view);
    }
}
