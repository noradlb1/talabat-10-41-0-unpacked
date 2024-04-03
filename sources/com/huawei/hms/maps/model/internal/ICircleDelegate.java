package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.internal.IAnimationListener;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import com.huawei.hms.maps.model.animation.Animation;
import java.util.List;

public interface ICircleDelegate extends maa {

    public static abstract class Stub extends Binder implements ICircleDelegate {

        public static class Proxy implements ICircleDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49590a;

            public Proxy(IBinder iBinder) {
                this.f49590a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49590a;
            }

            public boolean clearAnimation() {
                return mab.a(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 28);
            }

            public boolean equalsRemote(ICircleDelegate iCircleDelegate) {
                return mab.a((IInterface) iCircleDelegate, this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 24);
            }

            public LatLng getCenter() {
                return mab.e(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 1);
            }

            public int getFillColor() {
                return mab.b(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 2);
            }

            public String getId() {
                return mab.d(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 3);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.ICircleDelegate";
            }

            public double getRadius() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.ICircleDelegate");
                    this.f49590a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readDouble();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getStrokeColor() {
                return mab.b(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 5);
            }

            public List<PatternItem> getStrokePattern() {
                return mab.h(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 6);
            }

            public float getStrokeWidth() {
                return mab.c(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 7);
            }

            public IObjectWrapper getTag() {
                return IObjectWrapper.Stub.asInterface(mab.j(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 8));
            }

            public float getZIndex() {
                return mab.c(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 9);
            }

            public int hashCodeRemote() {
                return mab.b(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 10);
            }

            public boolean isClickable() {
                return mab.a(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 11);
            }

            public boolean isVisible() {
                return mab.a(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 12);
            }

            public void remove() {
                mab.i(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 13);
            }

            public void setAnimation(Animation animation) {
                mab.a(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 25, animation);
            }

            public void setAnimationListener(IAnimationListener iAnimationListener) {
                mab.a(iAnimationListener != null ? iAnimationListener.asBinder() : null, this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 27);
            }

            public void setCenter(LatLng latLng) {
                mab.a(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 14, latLng);
            }

            public void setClickable(boolean z11) {
                mab.a(z11, this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 15);
            }

            public void setFillColor(int i11) {
                mab.a(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 16, Integer.valueOf(i11));
            }

            public void setRadius(double d11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.ICircleDelegate");
                    obtain.writeDouble(d11);
                    this.f49590a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setStrokeColor(int i11) {
                mab.a(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 18, Integer.valueOf(i11));
            }

            public void setStrokePattern(List<PatternItem> list) {
                mab.b(list, this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 19);
            }

            public void setStrokeWidth(float f11) {
                mab.a(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 20, Float.valueOf(f11));
            }

            public void setTag(IObjectWrapper iObjectWrapper) {
                mab.a(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 21, iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
            }

            public void setVisible(boolean z11) {
                mab.a(z11, this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 22);
            }

            public void setZIndex(float f11) {
                mab.a(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 23, Float.valueOf(f11));
            }

            public void startAnimation() {
                mab.a(this.f49590a, "com.huawei.hms.maps.model.internal.ICircleDelegate", 26, new Parcelable[0]);
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.ICircleDelegate");
        }

        public static ICircleDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.ICircleDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICircleDelegate)) ? new Proxy(iBinder) : (ICircleDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    boolean clearAnimation();

    boolean equalsRemote(ICircleDelegate iCircleDelegate);

    LatLng getCenter();

    int getFillColor();

    double getRadius();

    int getStrokeColor();

    List<PatternItem> getStrokePattern();

    float getStrokeWidth();

    void setAnimation(Animation animation);

    void setAnimationListener(IAnimationListener iAnimationListener);

    void setCenter(LatLng latLng);

    void setFillColor(int i11);

    void setRadius(double d11);

    void setStrokeColor(int i11);

    void setStrokePattern(List<PatternItem> list);

    void setStrokeWidth(float f11);

    void startAnimation();
}
