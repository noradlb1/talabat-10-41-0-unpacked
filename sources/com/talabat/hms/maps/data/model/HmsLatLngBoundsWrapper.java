package com.talabat.hms.maps.data.model;

import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.LatLngBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/talabat/hms/maps/data/model/HmsLatLngBoundsWrapper;", "Lcom/talabat/maps/domain/model/LatLngBounds;", "huaweiLatLngBounds", "Lcom/huawei/hms/maps/model/LatLngBounds;", "(Lcom/huawei/hms/maps/model/LatLngBounds;)V", "center", "Lcom/talabat/maps/domain/model/LatLng;", "getCenter", "()Lcom/talabat/maps/domain/model/LatLng;", "getHuaweiLatLngBounds", "()Lcom/huawei/hms/maps/model/LatLngBounds;", "northeast", "getNortheast", "southwest", "getSouthwest", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsLatLngBoundsWrapper implements LatLngBounds {
    @NotNull
    private final com.huawei.hms.maps.model.LatLngBounds huaweiLatLngBounds;

    public HmsLatLngBoundsWrapper(@NotNull com.huawei.hms.maps.model.LatLngBounds latLngBounds) {
        Intrinsics.checkNotNullParameter(latLngBounds, "huaweiLatLngBounds");
        this.huaweiLatLngBounds = latLngBounds;
    }

    @NotNull
    public LatLng getCenter() {
        com.huawei.hms.maps.model.LatLng center = this.huaweiLatLngBounds.getCenter();
        Intrinsics.checkNotNullExpressionValue(center, "huaweiLatLngBounds.center");
        return new HmsLatLngWrapper(center);
    }

    @NotNull
    public final com.huawei.hms.maps.model.LatLngBounds getHuaweiLatLngBounds() {
        return this.huaweiLatLngBounds;
    }

    @NotNull
    public LatLng getNortheast() {
        com.huawei.hms.maps.model.LatLng latLng = this.huaweiLatLngBounds.northeast;
        Intrinsics.checkNotNullExpressionValue(latLng, "huaweiLatLngBounds.northeast");
        return new HmsLatLngWrapper(latLng);
    }

    @NotNull
    public LatLng getSouthwest() {
        com.huawei.hms.maps.model.LatLng latLng = this.huaweiLatLngBounds.southwest;
        Intrinsics.checkNotNullExpressionValue(latLng, "huaweiLatLngBounds.southwest");
        return new HmsLatLngWrapper(latLng);
    }
}
