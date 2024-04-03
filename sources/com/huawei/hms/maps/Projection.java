package com.huawei.hms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.huawei.hms.maps.internal.IProjectionDelegate;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.VisibleRegion;
import com.huawei.hms.maps.utils.LogM;

public final class Projection {

    /* renamed from: a  reason: collision with root package name */
    private final IProjectionDelegate f49345a;

    public Projection(IProjectionDelegate iProjectionDelegate) {
        this.f49345a = iProjectionDelegate;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.f49345a.fromScreenLocation(point);
        } catch (RemoteException e11) {
            LogM.e("Projection", "fromScreenLocation: " + e11.getMessage());
            return null;
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.f49345a.getVisibleRegion();
        } catch (RemoteException e11) {
            LogM.e("Projection", "getVisibleRegion: " + e11.getMessage());
            return null;
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            return this.f49345a.toScreenLocation(latLng);
        } catch (RemoteException e11) {
            LogM.e("Projection", "toScreenLocation: " + e11.getMessage());
            return null;
        }
    }
}
