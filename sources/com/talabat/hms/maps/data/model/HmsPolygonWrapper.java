package com.talabat.hms.maps.data.model;

import com.talabat.hms.maps.data.ExtensionsKt;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.Polygon;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R0\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/talabat/hms/maps/data/model/HmsPolygonWrapper;", "Lcom/talabat/maps/domain/model/Polygon;", "huaweiPolygon", "Lcom/huawei/hms/maps/model/Polygon;", "(Lcom/huawei/hms/maps/model/Polygon;)V", "value", "", "Lcom/talabat/maps/domain/model/LatLng;", "points", "getPoints", "()Ljava/util/List;", "setPoints", "(Ljava/util/List;)V", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsPolygonWrapper implements Polygon {
    @NotNull
    private final com.huawei.hms.maps.model.Polygon huaweiPolygon;

    public HmsPolygonWrapper(@NotNull com.huawei.hms.maps.model.Polygon polygon) {
        Intrinsics.checkNotNullParameter(polygon, "huaweiPolygon");
        this.huaweiPolygon = polygon;
    }

    @NotNull
    public List<LatLng> getPoints() {
        List<com.huawei.hms.maps.model.LatLng> points = this.huaweiPolygon.getPoints();
        Intrinsics.checkNotNullExpressionValue(points, "huaweiPolygon.points");
        Iterable<com.huawei.hms.maps.model.LatLng> iterable = points;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (com.huawei.hms.maps.model.LatLng latLng : iterable) {
            Intrinsics.checkNotNullExpressionValue(latLng, "it");
            arrayList.add(new HmsLatLngWrapper(latLng));
        }
        return arrayList;
    }

    public void setPoints(@NotNull List<? extends LatLng> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        com.huawei.hms.maps.model.Polygon polygon = this.huaweiPolygon;
        Iterable<LatLng> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (LatLng huaweiLatLng : iterable) {
            arrayList.add(ExtensionsKt.toHuaweiLatLng(huaweiLatLng));
        }
        polygon.setPoints(arrayList);
    }
}
