package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.TileProvider;

interface TileOverlaySink {
    void setFadeIn(boolean z11);

    void setTileProvider(TileProvider tileProvider);

    void setTransparency(float f11);

    void setVisible(boolean z11);

    void setZIndex(float f11);
}
