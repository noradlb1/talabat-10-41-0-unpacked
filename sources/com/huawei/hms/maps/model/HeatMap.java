package com.huawei.hms.maps.model;

import android.content.Context;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.RuntimeRemoteException;
import com.huawei.hms.maps.model.HeatMapOptions;
import com.huawei.hms.maps.model.internal.IHeatMapDelegate;
import java.util.HashMap;
import java.util.Map;

public class HeatMap {

    /* renamed from: a  reason: collision with root package name */
    private IHeatMapDelegate f49476a;

    public HeatMap(IHeatMapDelegate iHeatMapDelegate) {
        if (iHeatMapDelegate != null) {
            this.f49476a = iHeatMapDelegate;
            return;
        }
        throw new NullPointerException("Object is null");
    }

    private Map<String, String> a(Map<Float, Float> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(String.valueOf(next.getKey()), String.valueOf(next.getValue()));
        }
        return hashMap;
    }

    private Map<String, String> b(Map<Float, Integer> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(String.valueOf(next.getKey()), String.valueOf(next.getValue()));
        }
        return hashMap;
    }

    public void changeDataSet(Context context, int i11) {
        try {
            this.f49476a.changeDataSetFromRes(i11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void changeDataSet(String str) {
        try {
            this.f49476a.changeDataSet(str);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public String getId() {
        try {
            return this.f49476a.getId();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public HeatMapOptions.RadiusUnit getRadiusUnit() {
        try {
            return this.f49476a.getRadiusUnit() == 2 ? HeatMapOptions.RadiusUnit.METER : HeatMapOptions.RadiusUnit.PIXEL;
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void remove() {
        try {
            this.f49476a.remove();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setColor(Map<Float, Integer> map) {
        if (map != null) {
            try {
                this.f49476a.setColor(b(map));
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }
    }

    public void setIntensity(Float f11) {
        try {
            this.f49476a.setIntensity(String.valueOf(f11));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setIntensity(Map<Float, Float> map) {
        if (map != null) {
            try {
                this.f49476a.setIntensityMap(a(map));
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }
    }

    public void setOpacity(Float f11) {
        if (f11.floatValue() < 0.0f || f11.floatValue() > 1.0f) {
            throw new IllegalArgumentException("Opacity must be in the range [0..1]");
        }
        try {
            this.f49476a.setOpacity(String.valueOf(f11));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setOpacity(Map<Float, Float> map) {
        if (map != null) {
            try {
                this.f49476a.setOpacityMap(a(map));
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }
    }

    public void setRadius(Float f11) {
        try {
            this.f49476a.setRadius(String.valueOf(f11));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setRadius(Map<Float, Float> map) {
        if (map != null) {
            try {
                this.f49476a.setRadiusMap(a(map));
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }
    }

    public void setRadiusUnit(HeatMapOptions.RadiusUnit radiusUnit) {
        try {
            this.f49476a.setRadiusUnit(radiusUnit.equals(HeatMapOptions.RadiusUnit.METER) ? 2 : 1);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setVisible(boolean z11) {
        try {
            this.f49476a.setVisible(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
