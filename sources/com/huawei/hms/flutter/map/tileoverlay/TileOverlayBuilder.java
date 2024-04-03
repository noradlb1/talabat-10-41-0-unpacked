package com.huawei.hms.flutter.map.tileoverlay;

import com.huawei.hms.maps.model.TileOverlayOptions;
import com.huawei.hms.maps.model.TileProvider;

public class TileOverlayBuilder implements TileOverlayMethods {
    private final TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();

    public TileOverlayOptions build() {
        return this.tileOverlayOptions;
    }

    public void clearTileCache() {
    }

    public void delete() {
    }

    public boolean isVisible() {
        return this.tileOverlayOptions.isVisible();
    }

    public void setFadeIn(boolean z11) {
        this.tileOverlayOptions.fadeIn(z11);
    }

    public void setTileProvider(TileProvider tileProvider) {
        this.tileOverlayOptions.tileProvider(tileProvider);
    }

    public void setTransparency(float f11) {
        this.tileOverlayOptions.transparency(f11);
    }

    public void setVisible(boolean z11) {
        this.tileOverlayOptions.visible(z11);
    }

    public void setZIndex(float f11) {
        this.tileOverlayOptions.zIndex(f11);
    }
}
