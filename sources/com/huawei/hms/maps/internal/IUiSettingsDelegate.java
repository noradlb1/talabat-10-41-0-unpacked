package com.huawei.hms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.model.internal.mab;

public interface IUiSettingsDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IUiSettingsDelegate {

        public static class Proxy implements IUiSettingsDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49395a;

            public Proxy(IBinder iBinder) {
                this.f49395a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49395a;
            }

            public boolean getGestureScaleByMapCenter() {
                return mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 23);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.internal.IUiSettingsDelegate";
            }

            public boolean isCompassEnabled() {
                return mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 1);
            }

            public boolean isIndoorLevelPickerEnabled() {
                return mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 2);
            }

            public boolean isMapToolbarEnabled() {
                return mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 3);
            }

            public boolean isMyLocationButtonEnabled() {
                return mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 4);
            }

            public boolean isRotateGesturesEnabled() {
                return mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 5);
            }

            public boolean isScrollGesturesEnabled() {
                return mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 6);
            }

            public boolean isScrollGesturesEnabledDuringRotateOrZoom() {
                return mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 7);
            }

            public boolean isTiltGesturesEnabled() {
                return mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 8);
            }

            public boolean isZoomControlsEnabled() {
                return mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 9);
            }

            public boolean isZoomGesturesEnabled() {
                return mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 10);
            }

            public void setAllGesturesEnabled(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 11);
            }

            public void setCompassEnabled(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 12);
            }

            public void setGestureScaleByMapCenter(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 22);
            }

            public void setIndoorLevelPickerEnabled(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 13);
            }

            public void setIndoorLevelPickerPadding(int i11, int i12, int i13, int i14) {
                mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 29, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
            }

            public void setLogoPadding(int i11, int i12, int i13, int i14) {
                mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 28, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
            }

            public void setLogoPosition(int i11) {
                mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 27, Integer.valueOf(i11));
            }

            public void setMapToolbarEnabled(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 14);
            }

            public void setMarkerClusterColor(int i11) {
                mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 25, Integer.valueOf(i11));
            }

            public void setMarkerClusterIcon(IObjectWrapper iObjectWrapper) {
                mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 24, iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
            }

            public void setMarkerClusterTextColor(int i11) {
                mab.a(this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 26, Integer.valueOf(i11));
            }

            public void setMyLocationButtonEnabled(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 15);
            }

            public void setRotateGesturesEnabled(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 16);
            }

            public void setScaleVisible(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 30);
            }

            public void setScrollGesturesEnabled(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 17);
            }

            public void setScrollGesturesEnabledDuringRotateOrZoom(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 18);
            }

            public void setTiltGesturesEnabled(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 19);
            }

            public void setZoomControlsEnabled(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 20);
            }

            public void setZoomGesturesEnabled(boolean z11) {
                mab.a(z11, this.f49395a, "com.huawei.hms.maps.internal.IUiSettingsDelegate", 21);
            }
        }

        public static IUiSettingsDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.internal.IUiSettingsDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IUiSettingsDelegate)) ? new Proxy(iBinder) : (IUiSettingsDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    boolean getGestureScaleByMapCenter();

    boolean isCompassEnabled();

    boolean isIndoorLevelPickerEnabled();

    boolean isMapToolbarEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScrollGesturesEnabled();

    boolean isScrollGesturesEnabledDuringRotateOrZoom();

    boolean isTiltGesturesEnabled();

    boolean isZoomControlsEnabled();

    boolean isZoomGesturesEnabled();

    void setAllGesturesEnabled(boolean z11);

    void setCompassEnabled(boolean z11);

    void setGestureScaleByMapCenter(boolean z11);

    void setIndoorLevelPickerEnabled(boolean z11);

    void setIndoorLevelPickerPadding(int i11, int i12, int i13, int i14);

    void setLogoPadding(int i11, int i12, int i13, int i14);

    void setLogoPosition(int i11);

    void setMapToolbarEnabled(boolean z11);

    void setMarkerClusterColor(int i11);

    void setMarkerClusterIcon(IObjectWrapper iObjectWrapper);

    void setMarkerClusterTextColor(int i11);

    void setMyLocationButtonEnabled(boolean z11);

    void setRotateGesturesEnabled(boolean z11);

    void setScaleVisible(boolean z11);

    void setScrollGesturesEnabled(boolean z11);

    void setScrollGesturesEnabledDuringRotateOrZoom(boolean z11);

    void setTiltGesturesEnabled(boolean z11);

    void setZoomControlsEnabled(boolean z11);

    void setZoomGesturesEnabled(boolean z11);
}
