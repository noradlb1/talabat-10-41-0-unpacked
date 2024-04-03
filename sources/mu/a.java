package mu;

import android.view.View;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.adapters.viewholders.VendorSuggestionViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorSuggestionViewHolder f62346b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VendorDisplayModel f62347c;

    public /* synthetic */ a(VendorSuggestionViewHolder vendorSuggestionViewHolder, VendorDisplayModel vendorDisplayModel) {
        this.f62346b = vendorSuggestionViewHolder;
        this.f62347c = vendorDisplayModel;
    }

    public final void onClick(View view) {
        VendorSuggestionViewHolder.m10859bind$lambda0(this.f62346b, this.f62347c, view);
    }
}
