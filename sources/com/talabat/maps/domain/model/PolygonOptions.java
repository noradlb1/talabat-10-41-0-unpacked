package com.talabat.maps.domain.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/talabat/maps/domain/model/PolygonOptions;", "", "addAll", "var1", "", "Lcom/talabat/maps/domain/model/LatLng;", "clickable", "", "fillColor", "", "strokeColor", "strokeWidth", "", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PolygonOptions {
    @NotNull
    PolygonOptions addAll(@NotNull Iterable<? extends LatLng> iterable);

    @NotNull
    PolygonOptions clickable(boolean z11);

    @NotNull
    PolygonOptions fillColor(int i11);

    @NotNull
    PolygonOptions strokeColor(int i11);

    @NotNull
    PolygonOptions strokeWidth(float f11);
}
