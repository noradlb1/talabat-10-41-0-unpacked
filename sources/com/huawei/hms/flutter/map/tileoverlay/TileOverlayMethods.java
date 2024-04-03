package com.huawei.hms.flutter.map.tileoverlay;

import com.huawei.hms.maps.model.TileProvider;

public interface TileOverlayMethods {
    void clearTileCache();

    void delete();

    boolean isVisible();

    void setFadeIn(boolean z11);

    void setTileProvider(TileProvider tileProvider);

    void setTransparency(float f11);

    void setVisible(boolean z11);

    void setZIndex(float f11);
}
