package com.talabat.gms.maps.data.model;

import com.talabat.maps.domain.model.BitmapDescriptor;
import com.talabat.maps.domain.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/gms/maps/data/model/GmsBitmapDescriptorFactory;", "Lcom/talabat/maps/domain/model/BitmapDescriptorFactory;", "()V", "fromResource", "Lcom/talabat/maps/domain/model/BitmapDescriptor;", "resource", "", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GmsBitmapDescriptorFactory implements BitmapDescriptorFactory {
    @NotNull
    public BitmapDescriptor fromResource(int i11) {
        com.google.android.gms.maps.model.BitmapDescriptor fromResource = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource(i11);
        Intrinsics.checkNotNullExpressionValue(fromResource, "fromResource(resource)");
        return new GmsBitmapDescriptor(fromResource);
    }
}
