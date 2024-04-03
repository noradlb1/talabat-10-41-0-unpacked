package com.talabat.talabatlife.features.vendors;

import com.talabat.talabatlife.features.vendors.vendorList.models.response.Vendor;
import com.talabat.talabatlife.features.vendors.vendorList.models.response.VendorRootResponse;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorListDisplayModelMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "it", "Lcom/talabat/talabatlife/features/vendors/vendorList/models/response/VendorRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetVendorInfo$requestVendorInfo$1 extends Lambda implements Function1<VendorRootResponse, VendorDisplayModel> {
    public static final GetVendorInfo$requestVendorInfo$1 INSTANCE = new GetVendorInfo$requestVendorInfo$1();

    public GetVendorInfo$requestVendorInfo$1() {
        super(1);
    }

    @NotNull
    public final VendorDisplayModel invoke(@NotNull VendorRootResponse vendorRootResponse) {
        Intrinsics.checkNotNullParameter(vendorRootResponse, "it");
        return VendorListDisplayModelMapper.Companion.getVendorDisplayModel((Vendor) vendorRootResponse.getResult(), "");
    }
}
