package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import java.util.List;

class PolygonController implements PolygonOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final String googleMapsPolygonId;
    private final Polygon polygon;

    public PolygonController(Polygon polygon2, boolean z11, float f11) {
        this.polygon = polygon2;
        this.density = f11;
        this.consumeTapEvents = z11;
        this.googleMapsPolygonId = polygon2.getId();
    }

    public boolean a() {
        return this.consumeTapEvents;
    }

    public String b() {
        return this.googleMapsPolygonId;
    }

    public void c() {
        this.polygon.remove();
    }

    public void setConsumeTapEvents(boolean z11) {
        this.consumeTapEvents = z11;
        this.polygon.setClickable(z11);
    }

    public void setFillColor(int i11) {
        this.polygon.setFillColor(i11);
    }

    public void setGeodesic(boolean z11) {
        this.polygon.setGeodesic(z11);
    }

    public void setHoles(List<List<LatLng>> list) {
        this.polygon.setHoles(list);
    }

    public void setPoints(List<LatLng> list) {
        this.polygon.setPoints(list);
    }

    public void setStrokeColor(int i11) {
        this.polygon.setStrokeColor(i11);
    }

    public void setStrokeWidth(float f11) {
        this.polygon.setStrokeWidth(f11 * this.density);
    }

    public void setVisible(boolean z11) {
        this.polygon.setVisible(z11);
    }

    public void setZIndex(float f11) {
        this.polygon.setZIndex(f11);
    }
}
