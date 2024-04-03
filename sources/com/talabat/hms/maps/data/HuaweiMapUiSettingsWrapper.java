package com.talabat.hms.maps.data;

import com.huawei.hms.maps.UiSettings;
import com.talabat.maps.domain.UiSettingsWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR$\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR$\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR$\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/hms/maps/data/HuaweiMapUiSettingsWrapper;", "Lcom/talabat/maps/domain/UiSettingsWrapper;", "uiSettings", "Lcom/huawei/hms/maps/UiSettings;", "(Lcom/huawei/hms/maps/UiSettings;)V", "value", "", "isCompassEnabled", "()Z", "setCompassEnabled", "(Z)V", "isMyLocationButtonEnabled", "setMyLocationButtonEnabled", "isRotateGesturesEnabled", "setRotateGesturesEnabled", "isTiltGesturesEnabled", "setTiltGesturesEnabled", "isZoomControlsEnabled", "setZoomControlsEnabled", "isZoomGesturesEnabled", "setZoomGesturesEnabled", "mapToolbarEnabled", "getMapToolbarEnabled", "setMapToolbarEnabled", "scrollGesturesEnabled", "getScrollGesturesEnabled", "setScrollGesturesEnabled", "setAllGesturesEnabled", "", "b", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class HuaweiMapUiSettingsWrapper implements UiSettingsWrapper {
    @NotNull
    private final UiSettings uiSettings;

    public HuaweiMapUiSettingsWrapper(@NotNull UiSettings uiSettings2) {
        Intrinsics.checkNotNullParameter(uiSettings2, "uiSettings");
        this.uiSettings = uiSettings2;
    }

    public boolean getMapToolbarEnabled() {
        return this.uiSettings.isMapToolbarEnabled();
    }

    public boolean getScrollGesturesEnabled() {
        return this.uiSettings.isScrollGesturesEnabled();
    }

    public boolean isCompassEnabled() {
        return this.uiSettings.isCompassEnabled();
    }

    public boolean isMyLocationButtonEnabled() {
        return this.uiSettings.isMyLocationButtonEnabled();
    }

    public boolean isRotateGesturesEnabled() {
        return this.uiSettings.isRotateGesturesEnabled();
    }

    public boolean isTiltGesturesEnabled() {
        return this.uiSettings.isTiltGesturesEnabled();
    }

    public boolean isZoomControlsEnabled() {
        return this.uiSettings.isZoomControlsEnabled();
    }

    public boolean isZoomGesturesEnabled() {
        return this.uiSettings.isZoomGesturesEnabled();
    }

    public void setAllGesturesEnabled(boolean z11) {
        this.uiSettings.setAllGesturesEnabled(z11);
    }

    public void setCompassEnabled(boolean z11) {
        this.uiSettings.setCompassEnabled(z11);
    }

    public void setMapToolbarEnabled(boolean z11) {
        this.uiSettings.setMapToolbarEnabled(z11);
    }

    public void setMyLocationButtonEnabled(boolean z11) {
        this.uiSettings.setMyLocationButtonEnabled(z11);
    }

    public void setRotateGesturesEnabled(boolean z11) {
        this.uiSettings.setRotateGesturesEnabled(z11);
    }

    public void setScrollGesturesEnabled(boolean z11) {
        this.uiSettings.setScrollGesturesEnabled(z11);
    }

    public void setTiltGesturesEnabled(boolean z11) {
        this.uiSettings.setTiltGesturesEnabled(z11);
    }

    public void setZoomControlsEnabled(boolean z11) {
        this.uiSettings.setZoomControlsEnabled(z11);
    }

    public void setZoomGesturesEnabled(boolean z11) {
        this.uiSettings.setZoomGesturesEnabled(z11);
    }
}
