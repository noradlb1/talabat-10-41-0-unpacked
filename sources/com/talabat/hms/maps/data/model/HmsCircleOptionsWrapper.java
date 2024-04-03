package com.talabat.hms.maps.data.model;

import com.talabat.hms.maps.data.ExtensionsKt;
import com.talabat.maps.domain.model.CircleOptions;
import com.talabat.maps.domain.model.LatLng;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/talabat/hms/maps/data/model/HmsCircleOptionsWrapper;", "Lcom/talabat/maps/domain/model/CircleOptions;", "huaweiCircleOptions", "Lcom/huawei/hms/maps/model/CircleOptions;", "(Lcom/huawei/hms/maps/model/CircleOptions;)V", "getHuaweiCircleOptions", "()Lcom/huawei/hms/maps/model/CircleOptions;", "center", "Lcom/talabat/maps/domain/model/LatLng;", "radius", "", "strokeColor", "", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsCircleOptionsWrapper implements CircleOptions {
    @NotNull
    private final com.huawei.hms.maps.model.CircleOptions huaweiCircleOptions;

    @Inject
    public HmsCircleOptionsWrapper(@NotNull com.huawei.hms.maps.model.CircleOptions circleOptions) {
        Intrinsics.checkNotNullParameter(circleOptions, "huaweiCircleOptions");
        this.huaweiCircleOptions = circleOptions;
    }

    @NotNull
    public CircleOptions center(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "center");
        this.huaweiCircleOptions.center(ExtensionsKt.toHuaweiLatLng(latLng));
        return this;
    }

    @NotNull
    public final com.huawei.hms.maps.model.CircleOptions getHuaweiCircleOptions() {
        return this.huaweiCircleOptions;
    }

    @NotNull
    public CircleOptions radius(double d11) {
        this.huaweiCircleOptions.radius(d11);
        return this;
    }

    @NotNull
    public CircleOptions strokeColor(int i11) {
        this.huaweiCircleOptions.strokeColor(i11);
        return this;
    }
}
