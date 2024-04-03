package io.flutter.plugins.googlemaps;

import android.content.Context;
import android.graphics.Rect;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.List;
import java.util.Map;

class GoogleMapBuilder implements GoogleMapOptionsSink {
    private boolean buildingsEnabled = true;
    private boolean indoorEnabled = true;
    private Object initialCircles;
    private Object initialMarkers;
    private Object initialPolygons;
    private Object initialPolylines;
    private List<Map<String, ?>> initialTileOverlays;
    private boolean myLocationButtonEnabled = false;
    private boolean myLocationEnabled = false;
    private final GoogleMapOptions options = new GoogleMapOptions();
    private Rect padding = new Rect(0, 0, 0, 0);
    private boolean trackCameraPosition = false;
    private boolean trafficEnabled = false;

    public GoogleMapController a(int i11, Context context, BinaryMessenger binaryMessenger, LifecycleProvider lifecycleProvider) {
        GoogleMapController googleMapController = new GoogleMapController(i11, context, binaryMessenger, lifecycleProvider, this.options);
        googleMapController.a();
        googleMapController.setMyLocationEnabled(this.myLocationEnabled);
        googleMapController.setMyLocationButtonEnabled(this.myLocationButtonEnabled);
        googleMapController.setIndoorEnabled(this.indoorEnabled);
        googleMapController.setTrafficEnabled(this.trafficEnabled);
        googleMapController.setBuildingsEnabled(this.buildingsEnabled);
        googleMapController.setTrackCameraPosition(this.trackCameraPosition);
        googleMapController.setInitialMarkers(this.initialMarkers);
        googleMapController.setInitialPolygons(this.initialPolygons);
        googleMapController.setInitialPolylines(this.initialPolylines);
        googleMapController.setInitialCircles(this.initialCircles);
        Rect rect = this.padding;
        googleMapController.setPadding((float) rect.top, (float) rect.left, (float) rect.bottom, (float) rect.right);
        googleMapController.setInitialTileOverlays(this.initialTileOverlays);
        return googleMapController;
    }

    public void b(CameraPosition cameraPosition) {
        this.options.camera(cameraPosition);
    }

    public void setBuildingsEnabled(boolean z11) {
        this.buildingsEnabled = z11;
    }

    public void setCameraTargetBounds(LatLngBounds latLngBounds) {
        this.options.latLngBoundsForCameraTarget(latLngBounds);
    }

    public void setCompassEnabled(boolean z11) {
        this.options.compassEnabled(z11);
    }

    public void setIndoorEnabled(boolean z11) {
        this.indoorEnabled = z11;
    }

    public void setInitialCircles(Object obj) {
        this.initialCircles = obj;
    }

    public void setInitialMarkers(Object obj) {
        this.initialMarkers = obj;
    }

    public void setInitialPolygons(Object obj) {
        this.initialPolygons = obj;
    }

    public void setInitialPolylines(Object obj) {
        this.initialPolylines = obj;
    }

    public void setInitialTileOverlays(List<Map<String, ?>> list) {
        this.initialTileOverlays = list;
    }

    public void setLiteModeEnabled(boolean z11) {
        this.options.liteMode(z11);
    }

    public void setMapToolbarEnabled(boolean z11) {
        this.options.mapToolbarEnabled(z11);
    }

    public void setMapType(int i11) {
        this.options.mapType(i11);
    }

    public void setMinMaxZoomPreference(Float f11, Float f12) {
        if (f11 != null) {
            this.options.minZoomPreference(f11.floatValue());
        }
        if (f12 != null) {
            this.options.maxZoomPreference(f12.floatValue());
        }
    }

    public void setMyLocationButtonEnabled(boolean z11) {
        this.myLocationButtonEnabled = z11;
    }

    public void setMyLocationEnabled(boolean z11) {
        this.myLocationEnabled = z11;
    }

    public void setPadding(float f11, float f12, float f13, float f14) {
        this.padding = new Rect((int) f12, (int) f11, (int) f14, (int) f13);
    }

    public void setRotateGesturesEnabled(boolean z11) {
        this.options.rotateGesturesEnabled(z11);
    }

    public void setScrollGesturesEnabled(boolean z11) {
        this.options.scrollGesturesEnabled(z11);
    }

    public void setTiltGesturesEnabled(boolean z11) {
        this.options.tiltGesturesEnabled(z11);
    }

    public void setTrackCameraPosition(boolean z11) {
        this.trackCameraPosition = z11;
    }

    public void setTrafficEnabled(boolean z11) {
        this.trafficEnabled = z11;
    }

    public void setZoomControlsEnabled(boolean z11) {
        this.options.zoomControlsEnabled(z11);
    }

    public void setZoomGesturesEnabled(boolean z11) {
        this.options.zoomGesturesEnabled(z11);
    }
}
