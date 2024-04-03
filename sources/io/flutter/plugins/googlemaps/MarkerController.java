package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

class MarkerController implements MarkerOptionsSink {
    private boolean consumeTapEvents;
    private final String googleMapsMarkerId;
    private final Marker marker;

    public MarkerController(Marker marker2, boolean z11) {
        this.marker = marker2;
        this.consumeTapEvents = z11;
        this.googleMapsMarkerId = marker2.getId();
    }

    public boolean a() {
        return this.consumeTapEvents;
    }

    public String b() {
        return this.googleMapsMarkerId;
    }

    public void c() {
        this.marker.remove();
    }

    public void hideInfoWindow() {
        this.marker.hideInfoWindow();
    }

    public boolean isInfoWindowShown() {
        return this.marker.isInfoWindowShown();
    }

    public void setAlpha(float f11) {
        this.marker.setAlpha(f11);
    }

    public void setAnchor(float f11, float f12) {
        this.marker.setAnchor(f11, f12);
    }

    public void setConsumeTapEvents(boolean z11) {
        this.consumeTapEvents = z11;
    }

    public void setDraggable(boolean z11) {
        this.marker.setDraggable(z11);
    }

    public void setFlat(boolean z11) {
        this.marker.setFlat(z11);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        this.marker.setIcon(bitmapDescriptor);
    }

    public void setInfoWindowAnchor(float f11, float f12) {
        this.marker.setInfoWindowAnchor(f11, f12);
    }

    public void setInfoWindowText(String str, String str2) {
        this.marker.setTitle(str);
        this.marker.setSnippet(str2);
    }

    public void setPosition(LatLng latLng) {
        this.marker.setPosition(latLng);
    }

    public void setRotation(float f11) {
        this.marker.setRotation(f11);
    }

    public void setVisible(boolean z11) {
        this.marker.setVisible(z11);
    }

    public void setZIndex(float f11) {
        this.marker.setZIndex(f11);
    }

    public void showInfoWindow() {
        this.marker.showInfoWindow();
    }
}
