package com.huawei.hms.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate;
import com.huawei.hms.maps.utils.LogM;
import com.huawei.hms.maps.utils.mab;
import com.huawei.hms.maps.utils.mac;
import com.huawei.hms.maps.utils.mae;
import com.huawei.hms.maps.utils.mag;
import com.huawei.hms.maps.utils.mah;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;

    /* renamed from: a  reason: collision with root package name */
    private static IBitmapDescriptorDelegate f49419a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f49420b;

    public static BitmapDescriptor defaultMarker() {
        IBitmapDescriptorDelegate iBitmapDescriptorDelegate = f49419a;
        if (iBitmapDescriptorDelegate == null) {
            LogM.w("BitmapDescriptorFactory", "defaultMarker null == IBitmapDescriptorDelegate");
            return null;
        }
        try {
            IObjectWrapper defaultMarker = iBitmapDescriptorDelegate.defaultMarker();
            if (defaultMarker != null) {
                return new BitmapDescriptor(defaultMarker);
            }
            LogM.w("BitmapDescriptorFactory", "defaultMarker null == objectWrapper");
            return null;
        } catch (RemoteException unused) {
            LogM.e("BitmapDescriptorFactory", "defaultMarker error");
            return null;
        }
    }

    public static BitmapDescriptor defaultMarker(float f11) {
        IBitmapDescriptorDelegate iBitmapDescriptorDelegate = f49419a;
        if (iBitmapDescriptorDelegate == null) {
            LogM.w("BitmapDescriptorFactory", "defaultMarker hue null == IBitmapDescriptorDelegate");
            return null;
        }
        try {
            IObjectWrapper defaultMarkerWithHue = iBitmapDescriptorDelegate.defaultMarkerWithHue(f11);
            if (defaultMarkerWithHue != null) {
                return new BitmapDescriptor(defaultMarkerWithHue);
            }
            LogM.w("BitmapDescriptorFactory", "defaultMarker hue null == objectWrapper");
            return null;
        } catch (RemoteException unused) {
            LogM.e("BitmapDescriptorFactory", "defaultMarkerWithHue error");
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        Bitmap bitmap;
        try {
            bitmap = new mab(str).a(f49420b);
        } catch (NullPointerException unused) {
            LogM.e("BitmapDescriptorFactory", "the sContext is null");
            bitmap = null;
        }
        return new BitmapDescriptor(ObjectWrapper.wrap(bitmap));
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        Bitmap bitmap2;
        try {
            bitmap2 = new mac(bitmap).a(f49420b);
        } catch (NullPointerException unused) {
            LogM.e("BitmapDescriptorFactory", "the sContext is null");
            bitmap2 = null;
        }
        return new BitmapDescriptor(ObjectWrapper.wrap(bitmap2));
    }

    public static BitmapDescriptor fromFile(String str) {
        Bitmap bitmap;
        try {
            bitmap = new mae(str).a(f49420b);
        } catch (NullPointerException unused) {
            LogM.e("BitmapDescriptorFactory", "the sContext is null");
            bitmap = null;
        }
        return new BitmapDescriptor(ObjectWrapper.wrap(bitmap));
    }

    public static BitmapDescriptor fromPath(String str) {
        Bitmap bitmap;
        try {
            bitmap = new mag(str).a(f49420b);
        } catch (NullPointerException unused) {
            LogM.e("BitmapDescriptorFactory", "the sContext is null");
            bitmap = null;
        }
        return new BitmapDescriptor(ObjectWrapper.wrap(bitmap));
    }

    public static BitmapDescriptor fromResource(int i11) {
        Bitmap bitmap;
        try {
            bitmap = new mah(i11).a(f49420b);
        } catch (NullPointerException unused) {
            LogM.e("BitmapDescriptorFactory", "the sContext is null");
            bitmap = null;
        }
        return new BitmapDescriptor(ObjectWrapper.wrap(bitmap));
    }

    public static void setContext(Context context) {
        f49420b = context == null ? null : context.getApplicationContext();
    }

    public static void setIBitmapDescriptorDelegate(IBitmapDescriptorDelegate iBitmapDescriptorDelegate) {
        f49419a = iBitmapDescriptorDelegate;
    }
}
