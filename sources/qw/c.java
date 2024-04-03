package qw;

import com.talabat.talabatlife.ui.vendorOffers.views.offers.VendorsOfferListAdaptor;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsOfferListAdaptor f24080b;

    public /* synthetic */ c(VendorsOfferListAdaptor vendorsOfferListAdaptor) {
        this.f24080b = vendorsOfferListAdaptor;
    }

    public final void run() {
        VendorsOfferListAdaptor.m5870setSelectedItemIndex$lambda1(this.f24080b);
    }
}
