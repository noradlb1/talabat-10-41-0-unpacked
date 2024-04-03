package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

class MarkerBuilder implements MarkerOptionsSink {
    private boolean consumeTapEvents;
    private final MarkerOptions markerOptions = new MarkerOptions();

    public MarkerOptions a() {
        return this.markerOptions;
    }

    public boolean b() {
        return this.consumeTapEvents;
    }

    public void setAlpha(float f11) {
        this.markerOptions.alpha(f11);
    }

    public void setAnchor(float f11, float f12) {
        this.markerOptions.anchor(f11, f12);
    }

    public void setConsumeTapEvents(boolean z11) {
        this.consumeTapEvents = z11;
    }

    public void setDraggable(boolean z11) {
        this.markerOptions.draggable(z11);
    }

    public void setFlat(boolean z11) {
        this.markerOptions.flat(z11);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        this.markerOptions.icon(bitmapDescriptor);
    }

    public void setInfoWindowAnchor(float f11, float f12) {
        this.markerOptions.infoWindowAnchor(f11, f12);
    }

    public void setInfoWindowText(String str, String str2) {
        this.markerOptions.title(str);
        this.markerOptions.snippet(str2);
    }

    public void setPosition(LatLng latLng) {
        this.markerOptions.position(latLng);
    }

    public void setRotation(float f11) {
        this.markerOptions.rotation(f11);
    }

    public void setVisible(boolean z11) {
        this.markerOptions.visible(z11);
    }

    public void setZIndex(float f11) {
        this.markerOptions.zIndex(f11);
    }
}
