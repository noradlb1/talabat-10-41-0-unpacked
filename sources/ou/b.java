package ou;

import android.view.View;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.SwimlanesCellViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwimlanesCellViewHolder f62777b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VendorDisplayModel f62778c;

    public /* synthetic */ b(SwimlanesCellViewHolder swimlanesCellViewHolder, VendorDisplayModel vendorDisplayModel) {
        this.f62777b = swimlanesCellViewHolder;
        this.f62778c = vendorDisplayModel;
    }

    public final void onClick(View view) {
        SwimlanesCellViewHolder.m10890bind$lambda0(this.f62777b, this.f62778c, view);
    }
}
