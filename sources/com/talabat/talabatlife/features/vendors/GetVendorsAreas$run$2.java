package com.talabat.talabatlife.features.vendors;

import com.talabat.talabatcommon.extentions.DoubleKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatlife.features.vendors.vendorAreas.models.Area;
import com.talabat.talabatlife.features.vendors.vendorAreas.models.VendorAreasResponse;
import com.talabat.talabatlife.features.vendors.vendorAreas.models.VendorAreasRootResponse;
import com.talabat.talabatlife.ui.vendorList.model.FilterType;
import com.talabat.talabatlife.ui.vendorList.model.VendorAreasDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorLocationFilterDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorAreasDisplayModel;", "it", "Lcom/talabat/talabatlife/features/vendors/vendorAreas/models/VendorAreasRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetVendorsAreas$run$2 extends Lambda implements Function1<VendorAreasRootResponse, VendorAreasDisplayModel> {
    public static final GetVendorsAreas$run$2 INSTANCE = new GetVendorsAreas$run$2();

    public GetVendorsAreas$run$2() {
        super(1);
    }

    @NotNull
    public final VendorAreasDisplayModel invoke(@NotNull VendorAreasRootResponse vendorAreasRootResponse) {
        List<Area> areas;
        Intrinsics.checkNotNullParameter(vendorAreasRootResponse, "it");
        VendorAreasDisplayModel vendorAreasDisplayModel = new VendorAreasDisplayModel();
        VendorAreasResponse vendorAreasResponse = (VendorAreasResponse) vendorAreasRootResponse.getResult();
        if (!(vendorAreasResponse == null || (areas = vendorAreasResponse.getAreas()) == null)) {
            for (Area area : areas) {
                List<VendorLocationFilterDisplayModel> areas2 = vendorAreasDisplayModel.getAreas();
                VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel = new VendorLocationFilterDisplayModel(0, (String) null, (String) null, (Double) null, (Double) null, (FilterType) null, 63, (DefaultConstructorMarker) null);
                vendorLocationFilterDisplayModel.setAreaId(IntKt.orZero(area.getAreaId()));
                String areaName = area.getAreaName();
                String str = "";
                if (areaName == null) {
                    areaName = str;
                }
                vendorLocationFilterDisplayModel.setAreaName(areaName);
                String cityName = area.getCityName();
                if (cityName != null) {
                    str = cityName;
                }
                vendorLocationFilterDisplayModel.setCityName(str);
                vendorLocationFilterDisplayModel.setLatitude(Double.valueOf(DoubleKt.orZero(area.getLatitude())));
                vendorLocationFilterDisplayModel.setLongitude(Double.valueOf(DoubleKt.orZero(area.getLongitude())));
                areas2.add(vendorLocationFilterDisplayModel);
            }
        }
        return vendorAreasDisplayModel;
    }
}
