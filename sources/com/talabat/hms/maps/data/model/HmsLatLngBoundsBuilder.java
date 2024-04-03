package com.talabat.hms.maps.data.model;

import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.maps.model.LatLngBounds;
import com.talabat.hms.maps.data.ExtensionsKt;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.LatLngBounds;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/hms/maps/data/model/HmsLatLngBoundsBuilder;", "Lcom/talabat/maps/domain/model/LatLngBounds$Builder;", "googleLatLngBoundsBuilder", "Lcom/huawei/hms/maps/model/LatLngBounds$Builder;", "(Lcom/huawei/hms/maps/model/LatLngBounds$Builder;)V", "build", "Lcom/talabat/maps/domain/model/LatLngBounds;", "include", "latLng", "Lcom/talabat/maps/domain/model/LatLng;", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsLatLngBoundsBuilder implements LatLngBounds.Builder {
    @NotNull
    private final LatLngBounds.Builder googleLatLngBoundsBuilder;

    @Inject
    public HmsLatLngBoundsBuilder(@NotNull LatLngBounds.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "googleLatLngBoundsBuilder");
        this.googleLatLngBoundsBuilder = builder;
    }

    @NotNull
    public com.talabat.maps.domain.model.LatLngBounds build() {
        com.huawei.hms.maps.model.LatLngBounds build = this.googleLatLngBoundsBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "googleLatLngBoundsBuilder.build()");
        return new HmsLatLngBoundsWrapper(build);
    }

    @NotNull
    public LatLngBounds.Builder include(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, Param.LAT_LNG);
        this.googleLatLngBoundsBuilder.include(ExtensionsKt.toHuaweiLatLng(latLng));
        return this;
    }
}
