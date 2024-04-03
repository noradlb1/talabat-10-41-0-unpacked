package com.talabat.hms.maps.data.model;

import com.talabat.maps.domain.model.BitmapDescriptor;
import com.talabat.maps.domain.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/hms/maps/data/model/HmsBitmapDescriptorFactory;", "Lcom/talabat/maps/domain/model/BitmapDescriptorFactory;", "()V", "fromResource", "Lcom/talabat/maps/domain/model/BitmapDescriptor;", "resource", "", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsBitmapDescriptorFactory implements BitmapDescriptorFactory {
    @NotNull
    public BitmapDescriptor fromResource(int i11) {
        com.huawei.hms.maps.model.BitmapDescriptor fromResource = com.huawei.hms.maps.model.BitmapDescriptorFactory.fromResource(i11);
        Intrinsics.checkNotNullExpressionValue(fromResource, "fromResource(resource)");
        return new HmsBitmapDescriptor(fromResource);
    }
}
