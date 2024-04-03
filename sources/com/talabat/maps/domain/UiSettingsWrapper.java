package com.talabat.maps.domain;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0004\"\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0004\"\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006R\u0018\u0010\u0014\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/talabat/maps/domain/UiSettingsWrapper;", "", "isCompassEnabled", "", "()Z", "setCompassEnabled", "(Z)V", "isMyLocationButtonEnabled", "setMyLocationButtonEnabled", "isRotateGesturesEnabled", "setRotateGesturesEnabled", "isTiltGesturesEnabled", "setTiltGesturesEnabled", "isZoomControlsEnabled", "setZoomControlsEnabled", "isZoomGesturesEnabled", "setZoomGesturesEnabled", "mapToolbarEnabled", "getMapToolbarEnabled", "setMapToolbarEnabled", "scrollGesturesEnabled", "getScrollGesturesEnabled", "setScrollGesturesEnabled", "setAllGesturesEnabled", "", "b", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UiSettingsWrapper {
    boolean getMapToolbarEnabled();

    boolean getScrollGesturesEnabled();

    boolean isCompassEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isRotateGesturesEnabled();

    boolean isTiltGesturesEnabled();

    boolean isZoomControlsEnabled();

    boolean isZoomGesturesEnabled();

    void setAllGesturesEnabled(boolean z11);

    void setCompassEnabled(boolean z11);

    void setMapToolbarEnabled(boolean z11);

    void setMyLocationButtonEnabled(boolean z11);

    void setRotateGesturesEnabled(boolean z11);

    void setScrollGesturesEnabled(boolean z11);

    void setTiltGesturesEnabled(boolean z11);

    void setZoomControlsEnabled(boolean z11);

    void setZoomGesturesEnabled(boolean z11);
}
