package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import java.util.Map;

public interface IHeatMapDelegate extends IInterface {

    public static class Default implements IHeatMapDelegate {
        public IBinder asBinder() {
            return null;
        }

        public void changeDataSet(String str) {
        }

        public void changeDataSetFromRes(int i11) {
        }

        public String getId() {
            return null;
        }

        public int getRadiusUnit() {
            return 0;
        }

        public void remove() {
        }

        public void setColor(Map map) {
        }

        public void setIntensity(String str) {
        }

        public void setIntensityMap(Map map) {
        }

        public void setOpacity(String str) {
        }

        public void setOpacityMap(Map map) {
        }

        public void setRadius(String str) {
        }

        public void setRadiusMap(Map map) {
        }

        public void setRadiusUnit(int i11) {
        }

        public void setVisible(boolean z11) {
        }
    }

    public static abstract class Stub extends Binder implements IHeatMapDelegate {

        public static class Proxy implements IHeatMapDelegate {
            public static IHeatMapDelegate sDefaultImpl;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49593a;

            public Proxy(IBinder iBinder) {
                this.f49593a = iBinder;
            }

            public IBinder asBinder() {
                return this.f49593a;
            }

            public void changeDataSet(String str) {
                mab.a(str, this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 11);
            }

            public void changeDataSetFromRes(int i11) {
                mab.a(this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 12, Integer.valueOf(i11));
            }

            public String getId() {
                return mab.d(this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 1);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.IHeatMapDelegate";
            }

            public int getRadiusUnit() {
                return mab.b(this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 14);
            }

            public void remove() {
                mab.i(this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 2);
            }

            public void setColor(Map map) {
                mab.a(map, this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 3);
            }

            public void setIntensity(String str) {
                mab.a(str, this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 8);
            }

            public void setIntensityMap(Map map) {
                mab.a(map, this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 9);
            }

            public void setOpacity(String str) {
                mab.a(str, this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 4);
            }

            public void setOpacityMap(Map map) {
                mab.a(map, this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 5);
            }

            public void setRadius(String str) {
                mab.a(str, this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 6);
            }

            public void setRadiusMap(Map map) {
                mab.a(map, this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 7);
            }

            public void setRadiusUnit(int i11) {
                mab.a(this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 10, Integer.valueOf(i11));
            }

            public void setVisible(boolean z11) {
                mab.a(z11, this.f49593a, "com.huawei.hms.maps.model.internal.IHeatMapDelegate", 13);
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.IHeatMapDelegate");
        }

        public static IHeatMapDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.IHeatMapDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IHeatMapDelegate)) ? new Proxy(iBinder) : (IHeatMapDelegate) queryLocalInterface;
        }

        public static IHeatMapDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IHeatMapDelegate iHeatMapDelegate) {
            if (Proxy.sDefaultImpl != null || iHeatMapDelegate == null) {
                return false;
            }
            Proxy.sDefaultImpl = iHeatMapDelegate;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }
    }

    void changeDataSet(String str);

    void changeDataSetFromRes(int i11);

    String getId();

    int getRadiusUnit();

    void remove();

    void setColor(Map map);

    void setIntensity(String str);

    void setIntensityMap(Map map);

    void setOpacity(String str);

    void setOpacityMap(Map map);

    void setRadius(String str);

    void setRadiusMap(Map map);

    void setRadiusUnit(int i11);

    void setVisible(boolean z11);
}
