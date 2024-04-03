package com.talabat.hms.maps.data.model;

import com.talabat.hms.maps.data.ExtensionsKt;
import com.talabat.maps.domain.model.BitmapDescriptor;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.MarkerOptions;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/hms/maps/data/model/HmsMarkerOptionsWrapper;", "Lcom/talabat/maps/domain/model/MarkerOptions;", "huaweiMarkerOptions", "Lcom/huawei/hms/maps/model/MarkerOptions;", "(Lcom/huawei/hms/maps/model/MarkerOptions;)V", "getHuaweiMarkerOptions", "()Lcom/huawei/hms/maps/model/MarkerOptions;", "anchor", "var1", "", "var2", "icon", "bitmapDescriptor", "Lcom/talabat/maps/domain/model/BitmapDescriptor;", "position", "Lcom/talabat/maps/domain/model/LatLng;", "zIndex", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsMarkerOptionsWrapper implements MarkerOptions {
    @NotNull
    private final com.huawei.hms.maps.model.MarkerOptions huaweiMarkerOptions;

    @Inject
    public HmsMarkerOptionsWrapper(@NotNull com.huawei.hms.maps.model.MarkerOptions markerOptions) {
        Intrinsics.checkNotNullParameter(markerOptions, "huaweiMarkerOptions");
        this.huaweiMarkerOptions = markerOptions;
    }

    @NotNull
    public MarkerOptions anchor(float f11, float f12) {
        this.huaweiMarkerOptions.anchor(f11, f12);
        return this;
    }

    @NotNull
    public final com.huawei.hms.maps.model.MarkerOptions getHuaweiMarkerOptions() {
        return this.huaweiMarkerOptions;
    }

    @NotNull
    public MarkerOptions icon(@Nullable BitmapDescriptor bitmapDescriptor) {
        com.huawei.hms.maps.model.MarkerOptions markerOptions = this.huaweiMarkerOptions;
        if (bitmapDescriptor != null) {
            markerOptions.icon(((HmsBitmapDescriptor) bitmapDescriptor).getHuaweiBitmapDescriptor());
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.hms.maps.data.model.HmsBitmapDescriptor");
    }

    @NotNull
    public MarkerOptions position(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "position");
        this.huaweiMarkerOptions.position(ExtensionsKt.toHuaweiLatLng(latLng));
        return this;
    }

    @NotNull
    public MarkerOptions zIndex(float f11) {
        this.huaweiMarkerOptions.zIndex(f11);
        return this;
    }
}
