package com.huawei.hms.maps.model;

import com.huawei.hms.feature.dynamic.IObjectWrapper;

public final class BitmapDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final IObjectWrapper f49418a;

    public BitmapDescriptor(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.f49418a = iObjectWrapper;
            return;
        }
        throw new NullPointerException("Object is null");
    }

    public IObjectWrapper getObject() {
        return this.f49418a;
    }
}
