package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.List;

class PolylineBuilder implements PolylineOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final PolylineOptions polylineOptions = new PolylineOptions();

    public PolylineBuilder(float f11) {
        this.density = f11;
    }

    public PolylineOptions a() {
        return this.polylineOptions;
    }

    public boolean b() {
        return this.consumeTapEvents;
    }

    public void setColor(int i11) {
        this.polylineOptions.color(i11);
    }

    public void setConsumeTapEvents(boolean z11) {
        this.consumeTapEvents = z11;
        this.polylineOptions.clickable(z11);
    }

    public void setEndCap(Cap cap) {
        this.polylineOptions.endCap(cap);
    }

    public void setGeodesic(boolean z11) {
        this.polylineOptions.geodesic(z11);
    }

    public void setJointType(int i11) {
        this.polylineOptions.jointType(i11);
    }

    public void setPattern(List<PatternItem> list) {
        this.polylineOptions.pattern(list);
    }

    public void setPoints(List<LatLng> list) {
        this.polylineOptions.addAll(list);
    }

    public void setStartCap(Cap cap) {
        this.polylineOptions.startCap(cap);
    }

    public void setVisible(boolean z11) {
        this.polylineOptions.visible(z11);
    }

    public void setWidth(float f11) {
        this.polylineOptions.width(f11 * this.density);
    }

    public void setZIndex(float f11) {
        this.polylineOptions.zIndex(f11);
    }
}
