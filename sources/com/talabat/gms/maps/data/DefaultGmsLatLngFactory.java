package com.talabat.gms.maps.data;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.gms.maps.data.model.GmsLatLngBoundsWrapper;
import com.talabat.gms.maps.data.model.GmsLatLngWrapper;
import com.talabat.gms.maps.domain.GmsLatLngFactory;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.LatLngBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/talabat/gms/maps/data/DefaultGmsLatLngFactory;", "Lcom/talabat/gms/maps/domain/GmsLatLngFactory;", "()V", "createLatLng", "Lcom/talabat/maps/domain/model/LatLng;", "lat", "", "lng", "createLatLngBounds", "Lcom/talabat/maps/domain/model/LatLngBounds;", "southwest", "northeast", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultGmsLatLngFactory implements GmsLatLngFactory {
    @NotNull
    public LatLng createLatLng(double d11, double d12) {
        return new GmsLatLngWrapper(new com.google.android.gms.maps.model.LatLng(d11, d12));
    }

    @NotNull
    public LatLngBounds createLatLngBounds(@NotNull LatLng latLng, @NotNull LatLng latLng2) {
        Intrinsics.checkNotNullParameter(latLng, Param.SOUTHWEST);
        Intrinsics.checkNotNullParameter(latLng2, Param.NORTHEAST);
        return new GmsLatLngBoundsWrapper(new com.google.android.gms.maps.model.LatLngBounds(ExtensionsKt.toGoogleLatLng(latLng), ExtensionsKt.toGoogleLatLng(latLng2)));
    }
}
