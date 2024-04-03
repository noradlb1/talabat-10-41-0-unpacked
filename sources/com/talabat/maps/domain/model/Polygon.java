package com.talabat.maps.domain.model;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/maps/domain/model/Polygon;", "", "points", "", "Lcom/talabat/maps/domain/model/LatLng;", "getPoints", "()Ljava/util/List;", "setPoints", "(Ljava/util/List;)V", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Polygon {
    @NotNull
    List<LatLng> getPoints();

    void setPoints(@NotNull List<? extends LatLng> list);
}
