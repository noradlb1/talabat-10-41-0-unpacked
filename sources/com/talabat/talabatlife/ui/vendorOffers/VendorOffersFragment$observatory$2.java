package com.talabat.talabatlife.ui.vendorOffers;

import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VendorOffersFragment$observatory$2 extends FunctionReferenceImpl implements Function1<VendorBranchListDisplayModel, Unit> {
    public VendorOffersFragment$observatory$2(Object obj) {
        super(1, obj, VendorOffersFragment.class, "updateBranches", "updateBranches(Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VendorBranchListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VendorBranchListDisplayModel vendorBranchListDisplayModel) {
        ((VendorOffersFragment) this.receiver).updateBranches(vendorBranchListDisplayModel);
    }
}
