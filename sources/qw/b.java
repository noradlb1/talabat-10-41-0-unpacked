package qw;

import android.view.View;
import com.talabat.talabatlife.ui.vendorOffers.views.offers.VendorOfferViewHolder;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f24079b;

    public /* synthetic */ b(Function0 function0) {
        this.f24079b = function0;
    }

    public final void onClick(View view) {
        VendorOfferViewHolder.m5869setItemEnabled$lambda3(this.f24079b, view);
    }
}
