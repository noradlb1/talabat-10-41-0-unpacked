package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface ITileOverlayDelegate extends IInterface {

    public static abstract class Stub extends Binder implements ITileOverlayDelegate {

        public static class Proxy implements ITileOverlayDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49599a;

            public Proxy(IBinder iBinder) {
                this.f49599a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49599a;
            }

            public void clearTileCache() {
                mab.i(this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 1);
            }

            public boolean equalsRemote(ITileOverlayDelegate iTileOverlayDelegate) {
                return mab.a((IInterface) iTileOverlayDelegate, this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 12);
            }

            public boolean getFadeIn() {
                return mab.a(this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 2);
            }

            public String getId() {
                return mab.d(this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 3);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.ITileOverlayDelegate";
            }

            public float getTransparency() {
                return mab.c(this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 4);
            }

            public float getZIndex() {
                return mab.c(this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 5);
            }

            public int hashCodeRemote() {
                return mab.b(this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 13);
            }

            public boolean isVisible() {
                return mab.a(this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 6);
            }

            public void remove() {
                mab.i(this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 7);
            }

            public void setFadeIn(boolean z11) {
                mab.a(z11, this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 8);
            }

            public void setTransparency(float f11) {
                mab.a(this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 9, Float.valueOf(f11));
            }

            public void setVisible(boolean z11) {
                mab.a(z11, this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 10);
            }

            public void setZIndex(float f11) {
                mab.a(this.f49599a, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate", 11, Float.valueOf(f11));
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.ITileOverlayDelegate");
        }

        public static ITileOverlayDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.ITileOverlayDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITileOverlayDelegate)) ? new Proxy(iBinder) : (ITileOverlayDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void clearTileCache();

    boolean equalsRemote(ITileOverlayDelegate iTileOverlayDelegate);

    boolean getFadeIn();

    String getId();

    float getTransparency();

    float getZIndex();

    int hashCodeRemote();

    boolean isVisible();

    void remove();

    void setFadeIn(boolean z11);

    void setTransparency(float f11);

    void setVisible(boolean z11);

    void setZIndex(float f11);
}
