package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.model.Cap;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import java.util.List;

public interface IPolylineDelegate extends maa {

    public static abstract class Stub extends Binder implements IPolylineDelegate {

        public static class Proxy implements IPolylineDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49598a;

            public Proxy(IBinder iBinder) {
                this.f49598a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49598a;
            }

            public boolean equalsRemote(IPolylineDelegate iPolylineDelegate) {
                return mab.a((IInterface) iPolylineDelegate, this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 1);
            }

            public int getColor() {
                return mab.b(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 2);
            }

            public List getColorValues() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.IPolylineDelegate");
                    this.f49598a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readArrayList(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Cap getEndCap() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.IPolylineDelegate");
                    this.f49598a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Cap.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getId() {
                return mab.d(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 4);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.IPolylineDelegate";
            }

            public int getJointType() {
                return mab.b(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 5);
            }

            public List<PatternItem> getPattern() {
                return mab.h(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 6);
            }

            public List<LatLng> getPoints() {
                return mab.g(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 7);
            }

            public Cap getStartCap() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.IPolylineDelegate");
                    this.f49598a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Cap.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IObjectWrapper getTag() {
                return IObjectWrapper.Stub.asInterface(mab.j(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 9));
            }

            public float getWidth() {
                return mab.c(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 10);
            }

            public float getZIndex() {
                return mab.c(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 11);
            }

            public int hashCodeRemote() {
                return mab.b(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 12);
            }

            public boolean isClickable() {
                return mab.a(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 13);
            }

            public boolean isGeodesic() {
                return mab.a(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 14);
            }

            public boolean isGradient() {
                return mab.a(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 32);
            }

            public boolean isVisible() {
                return mab.a(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 15);
            }

            public void remove() {
                mab.i(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 16);
            }

            public void setClickable(boolean z11) {
                mab.a(z11, this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 17);
            }

            public void setColor(int i11) {
                mab.a(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 18, Integer.valueOf(i11));
            }

            public void setColorValues(List list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.IPolylineDelegate");
                    obtain.writeList(list);
                    this.f49598a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setEndCap(Cap cap) {
                mab.a(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 19, cap);
            }

            public void setGeodesic(boolean z11) {
                mab.a(z11, this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 20);
            }

            public void setGradient(boolean z11) {
                mab.a(z11, this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 31);
            }

            public void setJointType(int i11) {
                mab.a(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 21, Integer.valueOf(i11));
            }

            public void setPattern(List<PatternItem> list) {
                mab.b(list, this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 22);
            }

            public void setPoints(List<LatLng> list) {
                mab.a(list, this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 23);
            }

            public void setStartCap(Cap cap) {
                mab.a(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 24, cap);
            }

            public void setTag(IObjectWrapper iObjectWrapper) {
                mab.a(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 25, iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
            }

            public void setVisible(boolean z11) {
                mab.a(z11, this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 26);
            }

            public void setWidth(float f11) {
                mab.a(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 27, Float.valueOf(f11));
            }

            public void setZIndex(float f11) {
                mab.a(this.f49598a, "com.huawei.hms.maps.model.internal.IPolylineDelegate", 28, Float.valueOf(f11));
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.IPolylineDelegate");
        }

        public static IPolylineDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.IPolylineDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPolylineDelegate)) ? new Proxy(iBinder) : (IPolylineDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    boolean equalsRemote(IPolylineDelegate iPolylineDelegate);

    int getColor();

    List getColorValues();

    Cap getEndCap();

    int getJointType();

    List<PatternItem> getPattern();

    List<LatLng> getPoints();

    Cap getStartCap();

    float getWidth();

    boolean isGeodesic();

    boolean isGradient();

    void setColor(int i11);

    void setColorValues(List list);

    void setEndCap(Cap cap);

    void setGeodesic(boolean z11);

    void setGradient(boolean z11);

    void setJointType(int i11);

    void setPattern(List<PatternItem> list);

    void setPoints(List<LatLng> list);

    void setStartCap(Cap cap);

    void setWidth(float f11);
}
