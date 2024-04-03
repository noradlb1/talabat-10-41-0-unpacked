package com.talabat.talabatlife.ui.onBoarding;

import com.talabat.talabatlife.ui.vendorList.model.VendorListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TLifeOnBoardingFragment$observatory$1 extends FunctionReferenceImpl implements Function1<VendorListDisplayModel, Unit> {
    public TLifeOnBoardingFragment$observatory$1(Object obj) {
        super(1, obj, TLifeOnBoardingFragment.class, "updateRestaurants", "updateRestaurants(Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VendorListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VendorListDisplayModel vendorListDisplayModel) {
        ((TLifeOnBoardingFragment) this.receiver).updateRestaurants(vendorListDisplayModel);
    }
}
