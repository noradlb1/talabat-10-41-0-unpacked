package ou;

import android.view.View;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.VendorViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorViewHolder f62783b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VendorDisplayModel f62784c;

    public /* synthetic */ f(VendorViewHolder vendorViewHolder, VendorDisplayModel vendorDisplayModel) {
        this.f62783b = vendorViewHolder;
        this.f62784c = vendorDisplayModel;
    }

    public final void onClick(View view) {
        VendorViewHolder.m10894bind$lambda0(this.f62783b, this.f62784c, view);
    }
}
