package com.talabat.talabatlife.ui.vendorOffers;

import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VendorOffersFragment$observatory$3 extends FunctionReferenceImpl implements Function1<VendorOfferListDisplayModel, Unit> {
    public VendorOffersFragment$observatory$3(Object obj) {
        super(1, obj, VendorOffersFragment.class, "updateOffers", "updateOffers(Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VendorOfferListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VendorOfferListDisplayModel vendorOfferListDisplayModel) {
        ((VendorOffersFragment) this.receiver).updateOffers(vendorOfferListDisplayModel);
    }
}
