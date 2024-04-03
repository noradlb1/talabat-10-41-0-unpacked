package com.talabat.talabatlife.features.vendors;

import com.talabat.talabatlife.features.vendors.vendorList.models.request.VendorListRequestModel;
import com.talabat.talabatlife.features.vendors.vendorList.models.response.VendorListRootResponse;
import com.talabat.talabatlife.ui.vendorList.model.VendorListDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorListDisplayModelMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "it", "Lcom/talabat/talabatlife/features/vendors/vendorList/models/response/VendorListRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetVendorsList$run$2 extends Lambda implements Function1<VendorListRootResponse, VendorListDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VendorListRequestModel f12052g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetVendorsList$run$2(VendorListRequestModel vendorListRequestModel) {
        super(1);
        this.f12052g = vendorListRequestModel;
    }

    @NotNull
    public final VendorListDisplayModel invoke(@NotNull VendorListRootResponse vendorListRootResponse) {
        Intrinsics.checkNotNullParameter(vendorListRootResponse, "it");
        return VendorListDisplayModelMapper.Companion.mapToVendorListDisplayModel(vendorListRootResponse, this.f12052g.getSectionTheList());
    }
}
