package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;

class TileOverlayBuilder implements TileOverlaySink {
    private final TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();

    public TileOverlayOptions a() {
        return this.tileOverlayOptions;
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
