package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;

public interface IGroundOverlayDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IGroundOverlayDelegate {

        public static class Proxy implements IGroundOverlayDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49592a;

            public Proxy(IBinder iBinder) {
                this.f49592a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49592a;
            }

            public boolean equalsRemote(IGroundOverlayDelegate iGroundOverlayDelegate) {
                return mab.a((IInterface) iGroundOverlayDelegate, this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 25);
            }

            public float getBearing() {
                return mab.c(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 1);
            }

            public LatLngBounds getBounds() {
                return mab.f(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 2);
            }

            public float getHeight() {
                return mab.c(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 3);
            }

            public String getId() {
                return mab.d(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 4);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate";
            }

            public LatLng getPosition() {
                return mab.e(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 5);
            }

            public IObjectWrapper getTag() {
                return IObjectWrapper.Stub.asInterface(mab.j(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 6));
            }

            public float getTransparency() {
                return mab.c(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 7);
            }

            public float getWidth() {
                return mab.c(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 8);
            }

            public float getZIndex() {
                return mab.c(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 9);
            }

            public int hashCodeRemote() {
                return mab.b(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 10);
            }

            public boolean isClickable() {
                return mab.a(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 11);
            }

            public boolean isVisible() {
                return mab.a(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 12);
            }

            public void remove() {
                mab.i(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 13);
            }

            public void setBearing(float f11) {
                mab.a(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 14, Float.valueOf(f11));
            }

            public void setClickable(boolean z11) {
                mab.a(z11, this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 15);
            }

            public void setDimension(float f11) {
                mab.a(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 16, Float.valueOf(f11));
            }

            public void setDimensions(float f11, float f12) {
                mab.a(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 17, Float.valueOf(f11), Float.valueOf(f12));
            }

            public void setImage(IObjectWrapper iObjectWrapper) {
                mab.a(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 19, iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
            }

            public void setPosition(LatLng latLng) {
                mab.a(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 18, latLng);
            }

            public void setPositionFromBounds(LatLngBounds latLngBounds) {
                mab.a(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 20, latLngBounds);
            }

            public void setTag(IObjectWrapper iObjectWrapper) {
                mab.a(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 21, iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
            }

            public void setTransparency(float f11) {
                mab.a(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 22, Float.valueOf(f11));
            }

            public void setVisible(boolean z11) {
                mab.a(z11, this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 23);
            }

            public void setZIndex(float f11) {
                mab.a(this.f49592a, "com.huawei.hms.maps.model.internal.IGroundOverlayDelegate", 24, Float.valueOf(f11));
            }
        }

        public static IGroundOverlayDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.IGroundOverlayDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGroundOverlayDelegate)) ? new Proxy(iBinder) : (IGroundOverlayDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    boolean equalsRemote(IGroundOverlayDelegate iGroundOverlayDelegate);

    float getBearing();

    LatLngBounds getBounds();

    float getHeight();

    String getId();

    LatLng getPosition();

    IObjectWrapper getTag();

    float getTransparency();

    float getWidth();

    float getZIndex();

    int hashCodeRemote();

    boolean isClickable();

    boolean isVisible();

    void remove();

    void setBearing(float f11);

    void setClickable(boolean z11);

    void setDimension(float f11);

    void setDimensions(float f11, float f12);

    void setImage(IObjectWrapper iObjectWrapper);

    void setPosition(LatLng latLng);

    void setPositionFromBounds(LatLngBounds latLngBounds);

    void setTag(IObjectWrapper iObjectWrapper);

    void setTransparency(float f11);

    void setVisible(boolean z11);

    void setZIndex(float f11);
}
