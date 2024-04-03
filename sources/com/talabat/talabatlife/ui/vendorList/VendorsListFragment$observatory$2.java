package com.talabat.talabatlife.ui.vendorList;

import com.talabat.talabatlife.ui.vendorList.model.VendorAreasDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VendorsListFragment$observatory$2 extends FunctionReferenceImpl implements Function1<VendorAreasDisplayModel, Unit> {
    public VendorsListFragment$observatory$2(Object obj) {
        super(1, obj, VendorsListFragment.class, "updateVendorAreasList", "updateVendorAreasList(Lcom/talabat/talabatlife/ui/vendorList/model/VendorAreasDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VendorAreasDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VendorAreasDisplayModel vendorAreasDisplayModel) {
        ((VendorsListFragment) this.receiver).updateVendorAreasList(vendorAreasDisplayModel);
    }
}
