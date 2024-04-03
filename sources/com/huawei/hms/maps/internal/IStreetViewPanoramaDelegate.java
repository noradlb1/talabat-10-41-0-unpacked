package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.StreetViewPanoramaCamera;
import com.huawei.hms.maps.model.StreetViewPanoramaLocation;
import com.huawei.hms.maps.model.StreetViewPanoramaOrientation;
import com.huawei.hms.maps.model.StreetViewSource;
import com.huawei.hms.maps.model.internal.mab;

public interface IStreetViewPanoramaDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IStreetViewPanoramaDelegate {

        public static class Proxy implements IStreetViewPanoramaDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49392a;

            public Proxy(IBinder iBinder) {
                this.f49392a = iBinder;
            }

            public void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j11) {
                mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 1, (Number) Long.valueOf(j11), streetViewPanoramaCamera);
            }

            public IBinder asBinder() {
                return this.f49392a;
            }

            public void enablePanning(boolean z11) {
                mab.a(z11, this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 2);
            }

            public void enableStreetNames(boolean z11) {
                mab.a(z11, this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 3);
            }

            public void enableUserNavigation(boolean z11) {
                mab.a(z11, this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 4);
            }

            public void enableZoom(boolean z11) {
                mab.a(z11, this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 5);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate";
            }

            public StreetViewPanoramaLocation getLocation() {
                return null;
            }

            public StreetViewPanoramaCamera getPanoramaCamera() {
                return null;
            }

            public StreetViewPanoramaLocation getStreetViewPanoramaLocation() {
                return null;
            }

            public boolean isPanningGesturesEnabled() {
                return mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 8);
            }

            public boolean isStreetNamesEnabled() {
                return mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 9);
            }

            public boolean isUserNavigationEnabled() {
                return mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 10);
            }

            public boolean isZoomGesturesEnabled() {
                return mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 11);
            }

            public IObjectWrapper orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
                return IObjectWrapper.Stub.asInterface(mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 12, (Parcelable) streetViewPanoramaOrientation));
            }

            public StreetViewPanoramaOrientation pointToOrientation(IObjectWrapper iObjectWrapper) {
                return null;
            }

            public void setOnStreetViewPanoramaCameraChangeListener(IOnStreetViewPanoramaCameraChangeListener iOnStreetViewPanoramaCameraChangeListener) {
                mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 14, iOnStreetViewPanoramaCameraChangeListener != null ? iOnStreetViewPanoramaCameraChangeListener.asBinder() : null);
            }

            public void setOnStreetViewPanoramaChangeListener(IOnStreetViewPanoramaChangeListener iOnStreetViewPanoramaChangeListener) {
                mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 15, iOnStreetViewPanoramaChangeListener != null ? iOnStreetViewPanoramaChangeListener.asBinder() : null);
            }

            public void setOnStreetViewPanoramaClickListener(IOnStreetViewPanoramaClickListener iOnStreetViewPanoramaClickListener) {
                mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 16, iOnStreetViewPanoramaClickListener != null ? iOnStreetViewPanoramaClickListener.asBinder() : null);
            }

            public void setOnStreetViewPanoramaLongClickListener(IOnStreetViewPanoramaLongClickListener iOnStreetViewPanoramaLongClickListener) {
                mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 17, iOnStreetViewPanoramaLongClickListener != null ? iOnStreetViewPanoramaLongClickListener.asBinder() : null);
            }

            public void setPanningGesturesEnabled(boolean z11) {
                mab.a(z11, this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 24);
            }

            public void setPosition(LatLng latLng) {
                mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 18, latLng);
            }

            public void setPositionWithID(String str) {
                mab.a(str, this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 19);
            }

            public void setPositionWithRadius(LatLng latLng, int i11) {
                mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 20, (Number) Integer.valueOf(i11), latLng);
            }

            public void setPositionWithRadiusAndSource(LatLng latLng, int i11, StreetViewSource streetViewSource) {
                mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 21, (Number) Integer.valueOf(i11), latLng, streetViewSource);
            }

            public void setPositionWithSource(LatLng latLng, StreetViewSource streetViewSource) {
                mab.a(this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 21, latLng, streetViewSource);
            }

            public void setStreetNamesEnabled(boolean z11) {
                mab.a(z11, this.f49392a, "com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate", 25);
            }
        }

        public static IStreetViewPanoramaDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IStreetViewPanoramaDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IStreetViewPanoramaDelegate)) ? new Proxy(iBinder) : (IStreetViewPanoramaDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j11);

    void enablePanning(boolean z11);

    void enableStreetNames(boolean z11);

    void enableUserNavigation(boolean z11);

    void enableZoom(boolean z11);

    StreetViewPanoramaLocation getLocation();

    StreetViewPanoramaCamera getPanoramaCamera();

    StreetViewPanoramaLocation getStreetViewPanoramaLocation();

    boolean isPanningGesturesEnabled();

    boolean isStreetNamesEnabled();

    boolean isUserNavigationEnabled();

    boolean isZoomGesturesEnabled();

    IObjectWrapper orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation);

    StreetViewPanoramaOrientation pointToOrientation(IObjectWrapper iObjectWrapper);

    void setOnStreetViewPanoramaCameraChangeListener(IOnStreetViewPanoramaCameraChangeListener iOnStreetViewPanoramaCameraChangeListener);

    void setOnStreetViewPanoramaChangeListener(IOnStreetViewPanoramaChangeListener iOnStreetViewPanoramaChangeListener);

    void setOnStreetViewPanoramaClickListener(IOnStreetViewPanoramaClickListener iOnStreetViewPanoramaClickListener);

    void setOnStreetViewPanoramaLongClickListener(IOnStreetViewPanoramaLongClickListener iOnStreetViewPanoramaLongClickListener);

    void setPanningGesturesEnabled(boolean z11);

    void setPosition(LatLng latLng);

    void setPositionWithID(String str);

    void setPositionWithRadius(LatLng latLng, int i11);

    void setPositionWithRadiusAndSource(LatLng latLng, int i11, StreetViewSource streetViewSource);

    void setPositionWithSource(LatLng latLng, StreetViewSource streetViewSource);

    void setStreetNamesEnabled(boolean z11);
}
