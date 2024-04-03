package com.talabat.hms.maps.data.model;

import com.talabat.hms.maps.data.ExtensionsKt;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.PolygonOptions;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/talabat/hms/maps/data/model/HmsPolygonOptionsWrapper;", "Lcom/talabat/maps/domain/model/PolygonOptions;", "huaweiPolygonOptions", "Lcom/huawei/hms/maps/model/PolygonOptions;", "(Lcom/huawei/hms/maps/model/PolygonOptions;)V", "getHuaweiPolygonOptions", "()Lcom/huawei/hms/maps/model/PolygonOptions;", "addAll", "var1", "", "Lcom/talabat/maps/domain/model/LatLng;", "clickable", "", "fillColor", "", "strokeColor", "strokeWidth", "", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsPolygonOptionsWrapper implements PolygonOptions {
    @NotNull
    private final com.huawei.hms.maps.model.PolygonOptions huaweiPolygonOptions;

    @Inject
    public HmsPolygonOptionsWrapper(@NotNull com.huawei.hms.maps.model.PolygonOptions polygonOptions) {
        Intrinsics.checkNotNullParameter(polygonOptions, "huaweiPolygonOptions");
        this.huaweiPolygonOptions = polygonOptions;
    }

    @NotNull
    public PolygonOptions addAll(@NotNull Iterable<? extends LatLng> iterable) {
        com.huawei.hms.maps.model.LatLng latLng;
        Intrinsics.checkNotNullParameter(iterable, "var1");
        com.huawei.hms.maps.model.PolygonOptions polygonOptions = this.huaweiPolygonOptions;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (LatLng latLng2 : iterable) {
            if (latLng2 != null) {
                latLng = ExtensionsKt.toHuaweiLatLng(latLng2);
            } else {
                latLng = null;
            }
            arrayList.add(latLng);
        }
        polygonOptions.addAll(arrayList);
        return this;
    }

    @NotNull
    public PolygonOptions clickable(boolean z11) {
        this.huaweiPolygonOptions.clickable(z11);
        return this;
    }

    @NotNull
    public PolygonOptions fillColor(int i11) {
        this.huaweiPolygonOptions.fillColor(i11);
        return this;
    }

    @NotNull
    public final com.huawei.hms.maps.model.PolygonOptions getHuaweiPolygonOptions() {
        return this.huaweiPolygonOptions;
    }

    @NotNull
    public PolygonOptions strokeColor(int i11) {
        this.huaweiPolygonOptions.strokeColor(i11);
        return this;
    }

    @NotNull
    public PolygonOptions strokeWidth(float f11) {
        this.huaweiPolygonOptions.strokeWidth(f11);
        return this;
    }
}
