package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.internal.IAnimationListener;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.animation.Animation;

public interface IMarkerDelegate extends IInterface {

    public static abstract class Stub extends Binder implements IMarkerDelegate {

        public static class Proxy implements IMarkerDelegate {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49596a;

            public Proxy(IBinder iBinder) {
                this.f49596a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49596a;
            }

            public boolean equalsRemote(IMarkerDelegate iMarkerDelegate) {
                return mab.a((IInterface) iMarkerDelegate, this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 16);
            }

            public float getAlpha() {
                return mab.c(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 26);
            }

            public String getId() {
                return mab.d(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 2);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.IMarkerDelegate";
            }

            public LatLng getPosition() {
                return mab.e(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 4);
            }

            public float getRotation() {
                return mab.c(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 23);
            }

            public String getSnippet() {
                return mab.d(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 8);
            }

            public IObjectWrapper getTag() {
                return IObjectWrapper.Stub.asInterface(mab.j(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 30));
            }

            public String getTitle() {
                return mab.d(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 6);
            }

            public float getZIndex() {
                return mab.c(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 28);
            }

            public int hashCodeRemote() {
                return mab.b(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 17);
            }

            public void hideInfoWindow() {
                mab.i(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 12);
            }

            public boolean isClickable() {
                return mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 37);
            }

            public boolean isClusterable() {
                return mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 31);
            }

            public boolean isDraggable() {
                return mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 10);
            }

            public boolean isFlat() {
                return mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 21);
            }

            public boolean isInfoWindowShown() {
                return mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 13);
            }

            public boolean isVisible() {
                return mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 15);
            }

            public void remove() {
                mab.i(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 1);
            }

            public void setAlpha(float f11) {
                mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 25, Float.valueOf(f11));
            }

            public void setAnchor(float f11, float f12) {
                mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 19, Float.valueOf(f11), Float.valueOf(f12));
            }

            public void setAnimation(Animation animation) {
                mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 33, animation);
            }

            public void setAnimationListener(IAnimationListener iAnimationListener) {
                mab.a(iAnimationListener != null ? iAnimationListener.asBinder() : null, this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 35);
            }

            public void setClickable(boolean z11) {
                mab.a(z11, this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 36);
            }

            public void setDraggable(boolean z11) {
                mab.a(z11, this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 9);
            }

            public void setFlat(boolean z11) {
                mab.a(z11, this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 20);
            }

            public void setIcon(IObjectWrapper iObjectWrapper) {
                mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 18, iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
            }

            public void setInfoWindowAnchor(float f11, float f12) {
                mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 24, Float.valueOf(f11), Float.valueOf(f12));
            }

            public void setMarkerAnchor(float f11, float f12) {
                mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 32, Float.valueOf(f11), Float.valueOf(f12));
            }

            public void setPosition(LatLng latLng) {
                mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 3, latLng);
            }

            public void setRotation(float f11) {
                mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 22, Float.valueOf(f11));
            }

            public void setSnippet(String str) {
                mab.a(str, this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 7);
            }

            public void setTag(IObjectWrapper iObjectWrapper) {
                mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 29, iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
            }

            public void setTitle(String str) {
                mab.a(str, this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 5);
            }

            public void setVisible(boolean z11) {
                mab.a(z11, this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 14);
            }

            public void setZIndex(float f11) {
                mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 27, Float.valueOf(f11));
            }

            public void showInfoWindow() {
                mab.i(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 11);
            }

            public void startAnimation() {
                mab.a(this.f49596a, "com.huawei.hms.maps.model.internal.IMarkerDelegate", 34, new Parcelable[0]);
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.IMarkerDelegate");
        }

        public static IMarkerDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.IMarkerDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMarkerDelegate)) ? new Proxy(iBinder) : (IMarkerDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    boolean equalsRemote(IMarkerDelegate iMarkerDelegate);

    float getAlpha();

    String getId();

    LatLng getPosition();

    float getRotation();

    String getSnippet();

    IObjectWrapper getTag();

    String getTitle();

    float getZIndex();

    int hashCodeRemote();

    void hideInfoWindow();

    boolean isClickable();

    boolean isClusterable();

    boolean isDraggable();

    boolean isFlat();

    boolean isInfoWindowShown();

    boolean isVisible();

    void remove();

    void setAlpha(float f11);

    void setAnchor(float f11, float f12);

    void setAnimation(Animation animation);

    void setAnimationListener(IAnimationListener iAnimationListener);

    void setClickable(boolean z11);

    void setDraggable(boolean z11);

    void setFlat(boolean z11);

    void setIcon(IObjectWrapper iObjectWrapper);

    void setInfoWindowAnchor(float f11, float f12);

    void setMarkerAnchor(float f11, float f12);

    void setPosition(LatLng latLng);

    void setRotation(float f11);

    void setSnippet(String str);

    void setTag(IObjectWrapper iObjectWrapper);

    void setTitle(String str);

    void setVisible(boolean z11);

    void setZIndex(float f11);

    void showInfoWindow();

    void startAnimation();
}
