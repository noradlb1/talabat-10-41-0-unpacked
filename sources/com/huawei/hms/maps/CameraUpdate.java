package com.huawei.hms.maps;

import com.huawei.hms.maps.model.CameraUpdateParam;

public final class CameraUpdate {

    /* renamed from: a  reason: collision with root package name */
    private CameraUpdateParam f49227a;

    public CameraUpdate(CameraUpdateParam cameraUpdateParam) {
        if (cameraUpdateParam != null) {
            this.f49227a = cameraUpdateParam;
            return;
        }
        throw new NullPointerException("Object is null");
    }

    @Deprecated
    public CameraUpdateParam getCameraUpdate() {
        return this.f49227a;
    }

    public CameraUpdateParam getCameraUpdateParam() {
        return this.f49227a;
    }
}
