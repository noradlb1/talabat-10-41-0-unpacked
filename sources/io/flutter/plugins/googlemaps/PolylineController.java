package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polyline;
import java.util.List;

class PolylineController implements PolylineOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final String googleMapsPolylineId;
    private final Polyline polyline;

    public PolylineController(Polyline polyline2, boolean z11, float f11) {
        this.polyline = polyline2;
        this.consumeTapEvents = z11;
        this.density = f11;
        this.googleMapsPolylineId = polyline2.getId();
    }

    public boolean a() {
        return this.consumeTapEvents;
    }

    public String b() {
        return this.googleMapsPolylineId;
    }

    public void c() {
        this.polyline.remove();
    }

    public void setColor(int i11) {
        this.polyline.setColor(i11);
    }

    public void setConsumeTapEvents(boolean z11) {
        this.consumeTapEvents = z11;
        this.polyline.setClickable(z11);
    }

    public void setEndCap(Cap cap) {
        this.polyline.setEndCap(cap);
    }

    public void setGeodesic(boolean z11) {
        this.polyline.setGeodesic(z11);
    }

    public void setJointType(int i11) {
        this.polyline.setJointType(i11);
    }

    public void setPattern(List<PatternItem> list) {
        this.polyline.setPattern(list);
    }

    public void setPoints(List<LatLng> list) {
        this.polyline.setPoints(list);
    }

    public void setStartCap(Cap cap) {
        this.polyline.setStartCap(cap);
    }

    public void setVisible(boolean z11) {
        this.polyline.setVisible(z11);
    }

    public void setWidth(float f11) {
        this.polyline.setWidth(f11 * this.density);
    }

    public void setZIndex(float f11) {
        this.polyline.setZIndex(f11);
    }
}
