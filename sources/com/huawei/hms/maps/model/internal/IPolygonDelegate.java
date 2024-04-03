package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import java.util.List;

public interface IPolygonDelegate extends maa {

    public static abstract class Stub extends Binder implements IPolygonDelegate {

        public static class Proxy implements IPolygonDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49597a;

            public Proxy(IBinder iBinder) {
                this.f49597a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49597a;
            }

            public boolean equalsRemote(IPolygonDelegate iPolygonDelegate) {
                return mab.a((IInterface) iPolygonDelegate, this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 28);
            }

            public int getFillColor() {
                return mab.b(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 1);
            }

            public List getHoles() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.IPolygonDelegate");
                    this.f49597a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readArrayList(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getId() {
                return mab.d(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 3);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.IPolygonDelegate";
            }

            public List<LatLng> getPoints() {
                return mab.g(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 4);
            }

            public int getStrokeColor() {
                return mab.b(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 5);
            }

            public int getStrokeJointType() {
                return mab.b(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 6);
            }

            public List<PatternItem> getStrokePattern() {
                return mab.h(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 7);
            }

            public float getStrokeWidth() {
                return mab.c(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 8);
            }

            public IObjectWrapper getTag() {
                return IObjectWrapper.Stub.asInterface(mab.j(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 9));
            }

            public float getZIndex() {
                return mab.c(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 10);
            }

            public int hashCodeRemote() {
                return mab.b(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 11);
            }

            public boolean isClickable() {
                return mab.a(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 12);
            }

            public boolean isGeodesic() {
                return mab.a(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 13);
            }

            public boolean isVisible() {
                return mab.a(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 14);
            }

            public void remove() {
                mab.i(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 15);
            }

            public void setClickable(boolean z11) {
                mab.a(z11, this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 16);
            }

            public void setFillColor(int i11) {
                mab.a(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 17, Integer.valueOf(i11));
            }

            public void setGeodesic(boolean z11) {
                mab.a(z11, this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 18);
            }

            public void setHoles(List list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.IPolygonDelegate");
                    obtain.writeList(list);
                    this.f49597a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPoints(List<LatLng> list) {
                mab.a(list, this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 20);
            }

            public void setStrokeColor(int i11) {
                mab.a(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 21, Integer.valueOf(i11));
            }

            public void setStrokeJointType(int i11) {
                mab.a(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 22, Integer.valueOf(i11));
            }

            public void setStrokePattern(List<PatternItem> list) {
                mab.b(list, this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 23);
            }

            public void setStrokeWidth(float f11) {
                mab.a(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 24, Float.valueOf(f11));
            }

            public void setTag(IObjectWrapper iObjectWrapper) {
                mab.a(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 25, iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
            }

            public void setVisible(boolean z11) {
                mab.a(z11, this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 26);
            }

            public void setZIndex(float f11) {
                mab.a(this.f49597a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 27, Float.valueOf(f11));
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.IPolygonDelegate");
        }

        public static IPolygonDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.IPolygonDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPolygonDelegate)) ? new Proxy(iBinder) : (IPolygonDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    boolean equalsRemote(IPolygonDelegate iPolygonDelegate);

    int getFillColor();

    List getHoles();

    List<LatLng> getPoints();

    int getStrokeColor();

    int getStrokeJointType();

    List<PatternItem> getStrokePattern();

    float getStrokeWidth();

    boolean isGeodesic();

    void setFillColor(int i11);

    void setGeodesic(boolean z11);

    void setHoles(List list);

    void setPoints(List<LatLng> list);

    void setStrokeColor(int i11);

    void setStrokeJointType(int i11);

    void setStrokePattern(List<PatternItem> list);

    void setStrokeWidth(float f11);
}
