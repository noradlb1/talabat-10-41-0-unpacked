package com.huawei.hms.flutter.map.tileoverlay;

import com.huawei.hms.maps.model.TileOverlay;
import com.huawei.hms.maps.model.TileProvider;

public class TileOverlayController implements TileOverlayMethods {
    private final String mapTileOverlayId;
    private final TileOverlay tileOverlay;

    public TileOverlayController(TileOverlay tileOverlay2) {
        this.tileOverlay = tileOverlay2;
        this.mapTileOverlayId = tileOverlay2.getId();
    }

    public void clearTileCache() {
        this.tileOverlay.clearTileCache();
    }

    public void delete() {
        this.tileOverlay.remove();
    }

    public String getMapTileOverlayId() {
        return this.mapTileOverlayId;
    }

    public boolean isVisible() {
        return this.tileOverlay.isVisible();
    }

    public void setFadeIn(boolean z11) {
        this.tileOverlay.setFadeIn(z11);
    }

    public void setTileProvider(TileProvider tileProvider) {
    }

    public void setTransparency(float f11) {
        this.tileOverlay.setTransparency(f11);
    }

    public void setVisible(boolean z11) {
        this.tileOverlay.setVisible(z11);
    }

    public void setZIndex(float f11) {
        this.tileOverlay.setZIndex(f11);
    }
}
