package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileProvider;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.HashMap;
import java.util.Map;

class TileOverlayController implements TileOverlaySink {
    private final TileOverlay tileOverlay;

    public TileOverlayController(TileOverlay tileOverlay2) {
        this.tileOverlay = tileOverlay2;
    }

    public void a() {
        this.tileOverlay.clearTileCache();
    }

    public Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        hashMap.put(Param.FADE_IN, Boolean.valueOf(this.tileOverlay.getFadeIn()));
        hashMap.put(Param.TRANSPARENCY, Float.valueOf(this.tileOverlay.getTransparency()));
        hashMap.put("id", this.tileOverlay.getId());
        hashMap.put(Param.Z_INDEX, Float.valueOf(this.tileOverlay.getZIndex()));
        hashMap.put(Param.VISIBLE, Boolean.valueOf(this.tileOverlay.isVisible()));
        return hashMap;
    }

    public void c() {
        this.tileOverlay.remove();
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
