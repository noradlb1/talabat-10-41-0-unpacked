package com.huawei.hms.maps;

import android.graphics.Point;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.CameraUpdateParam;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.utils.LogM;

public final class CameraUpdateFactory {
    private CameraUpdateFactory() {
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        LogM.d("CameraUpdateFactory", "newCameraPosition: ");
        CameraUpdateParam cameraUpdateParam = new CameraUpdateParam();
        cameraUpdateParam.setCameraPosition(cameraPosition);
        return new CameraUpdate(cameraUpdateParam);
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        LogM.d("CameraUpdateFactory", "newLatLng: ");
        CameraUpdateParam cameraUpdateParam = new CameraUpdateParam();
        cameraUpdateParam.setLatLng(latLng);
        return new CameraUpdate(cameraUpdateParam);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i11) {
        LogM.d("CameraUpdateFactory", "newLatLngBounds: ");
        CameraUpdateParam cameraUpdateParam = new CameraUpdateParam();
        cameraUpdateParam.setNewLatLngBounds(new CameraUpdateParam.NewLatLngBounds(latLngBounds, i11));
        return new CameraUpdate(cameraUpdateParam);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i11, int i12, int i13) {
        LogM.d("CameraUpdateFactory", "newLatLngBoundsWithSize: ");
        CameraUpdateParam cameraUpdateParam = new CameraUpdateParam();
        cameraUpdateParam.setNewLatLngBoundsWidthHeight(new CameraUpdateParam.NewLatLngBoundsWidthHeight(latLngBounds, i11, i12, i13));
        return new CameraUpdate(cameraUpdateParam);
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f11) {
        LogM.d("CameraUpdateFactory", "newLatLngZoom: ");
        CameraUpdateParam cameraUpdateParam = new CameraUpdateParam();
        cameraUpdateParam.setNewLatLngZoom(new CameraUpdateParam.NewLatLngZoom(latLng, f11));
        return new CameraUpdate(cameraUpdateParam);
    }

    public static CameraUpdate scrollBy(float f11, float f12) {
        LogM.d("CameraUpdateFactory", "scrollBy: ");
        CameraUpdateParam cameraUpdateParam = new CameraUpdateParam();
        cameraUpdateParam.setScrollBy(new CameraUpdateParam.ScrollBy(f11, f12));
        return new CameraUpdate(cameraUpdateParam);
    }

    public static CameraUpdate zoomBy(float f11) {
        LogM.d("CameraUpdateFactory", "zoomBy: ");
        CameraUpdateParam cameraUpdateParam = new CameraUpdateParam();
        cameraUpdateParam.setZoomBy(new CameraUpdateParam.ZoomBy(f11));
        return new CameraUpdate(cameraUpdateParam);
    }

    public static CameraUpdate zoomBy(float f11, Point point) {
        LogM.d("CameraUpdateFactory", "zoomBy: ");
        CameraUpdateParam cameraUpdateParam = new CameraUpdateParam();
        cameraUpdateParam.setZoomByWithFocus(new CameraUpdateParam.ZoomByWithFocus(f11, point));
        return new CameraUpdate(cameraUpdateParam);
    }

    public static CameraUpdate zoomIn() {
        LogM.d("CameraUpdateFactory", "zoomIn ");
        return zoomBy(1.0f);
    }

    public static CameraUpdate zoomOut() {
        return zoomBy(-1.0f);
    }

    public static CameraUpdate zoomTo(float f11) {
        LogM.d("CameraUpdateFactory", "zoomTo ");
        CameraUpdateParam cameraUpdateParam = new CameraUpdateParam();
        cameraUpdateParam.setZoomTo(new CameraUpdateParam.ZoomTo(f11));
        return new CameraUpdate(cameraUpdateParam);
    }
}
