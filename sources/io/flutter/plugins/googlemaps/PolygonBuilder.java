package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.List;

class PolygonBuilder implements PolygonOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final PolygonOptions polygonOptions = new PolygonOptions();

    public PolygonBuilder(float f11) {
        this.density = f11;
    }

    public PolygonOptions a() {
        return this.polygonOptions;
    }

    public boolean b() {
        return this.consumeTapEvents;
    }

    public void setConsumeTapEvents(boolean z11) {
        this.consumeTapEvents = z11;
        this.polygonOptions.clickable(z11);
    }

    public void setFillColor(int i11) {
        this.polygonOptions.fillColor(i11);
    }

    public void setGeodesic(boolean z11) {
        this.polygonOptions.geodesic(z11);
    }

    public void setHoles(List<List<LatLng>> list) {
        for (List<LatLng> addHole : list) {
            this.polygonOptions.addHole(addHole);
        }
    }

    public void setPoints(List<LatLng> list) {
        this.polygonOptions.addAll(list);
    }

    public void setStrokeColor(int i11) {
        this.polygonOptions.strokeColor(i11);
    }

    public void setStrokeWidth(float f11) {
        this.polygonOptions.strokeWidth(f11 * this.density);
    }

    public void setVisible(boolean z11) {
        this.polygonOptions.visible(z11);
    }

    public void setZIndex(float f11) {
        this.polygonOptions.zIndex(f11);
    }
}
