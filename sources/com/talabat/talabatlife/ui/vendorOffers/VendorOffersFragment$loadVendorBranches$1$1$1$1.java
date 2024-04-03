package com.talabat.talabatlife.ui.vendorOffers;

import com.talabat.talabatlife.features.vendors.branches.models.VendorBranchListRequestModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "lat", "", "long", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VendorOffersFragment$loadVendorBranches$1$1$1$1 extends Lambda implements Function2<Double, Double, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VendorOffersFragment f12102g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ VendorDisplayModel f12103h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorOffersFragment$loadVendorBranches$1$1$1$1(VendorOffersFragment vendorOffersFragment, VendorDisplayModel vendorDisplayModel) {
        super(2);
        this.f12102g = vendorOffersFragment;
        this.f12103h = vendorDisplayModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).doubleValue(), ((Number) obj2).doubleValue());
        return Unit.INSTANCE;
    }

    public final void invoke(double d11, double d12) {
        VendorOffersFragment.access$getViewModel(this.f12102g).getVendorBranches(new VendorBranchListRequestModel(this.f12103h.getRestaurantId(), String.valueOf(d11), String.valueOf(d12)));
    }
}
