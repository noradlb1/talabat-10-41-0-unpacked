package com.talabat.hms.maps.data.di;

import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.CircleOptions;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.MarkerOptions;
import com.huawei.hms.maps.model.PolygonOptions;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/talabat/hms/maps/data/di/HuaweiModule;", "", "()V", "cameraPositionBuilder", "Lcom/huawei/hms/maps/model/CameraPosition$Builder;", "huaweiCircleOptions", "Lcom/huawei/hms/maps/model/CircleOptions;", "huaweiMarkerOptions", "Lcom/huawei/hms/maps/model/MarkerOptions;", "huaweiPolygonOptions", "Lcom/huawei/hms/maps/model/PolygonOptions;", "latLngBoundsBuilder", "Lcom/huawei/hms/maps/model/LatLngBounds$Builder;", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class HuaweiModule {
    @NotNull
    @Provides
    public final CameraPosition.Builder cameraPositionBuilder() {
        return new CameraPosition.Builder();
    }

    @NotNull
    @Provides
    public final CircleOptions huaweiCircleOptions() {
        return new CircleOptions();
    }

    @NotNull
    @Provides
    public final MarkerOptions huaweiMarkerOptions() {
        return new MarkerOptions();
    }

    @NotNull
    @Provides
    public final PolygonOptions huaweiPolygonOptions() {
        return new PolygonOptions();
    }

    @NotNull
    @Provides
    public final LatLngBounds.Builder latLngBoundsBuilder() {
        return new LatLngBounds.Builder();
    }
}
