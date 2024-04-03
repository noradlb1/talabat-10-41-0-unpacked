package com.talabat.talabatlife.ui.vendorOffers;

import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VendorOffersFragment$observatory$1 extends FunctionReferenceImpl implements Function1<VendorDisplayModel, Unit> {
    public VendorOffersFragment$observatory$1(Object obj) {
        super(1, obj, VendorOffersFragment.class, "populateVendorInfo", "populateVendorInfo(Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VendorDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VendorDisplayModel vendorDisplayModel) {
        ((VendorOffersFragment) this.receiver).populateVendorInfo(vendorDisplayModel);
    }
}
