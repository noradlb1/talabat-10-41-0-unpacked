package com.huawei.hms.maps.model;

import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.maps.model.internal.IPolylineDelegate;
import com.huawei.hms.maps.utils.LogM;
import java.util.ArrayList;
import java.util.List;

public final class Polyline {

    /* renamed from: a  reason: collision with root package name */
    private IPolylineDelegate f49544a;

    public Polyline(IPolylineDelegate iPolylineDelegate) {
        this.f49544a = iPolylineDelegate;
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof Polyline) {
                return this.f49544a.equalsRemote(((Polyline) obj).f49544a);
            }
            return false;
        } catch (RemoteException e11) {
            LogM.e("Polyline", "equals RemoteException: " + e11.toString());
            return false;
        }
    }

    public int getColor() {
        try {
            return this.f49544a.getColor();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "getId RemoteException: " + e11.toString());
            return 0;
        }
    }

    public List<Integer> getColorValues() {
        try {
            List colorValues = this.f49544a.getColorValues();
            ArrayList arrayList = new ArrayList();
            for (Object next : colorValues) {
                if (next instanceof Integer) {
                    arrayList.add((Integer) next);
                }
            }
            return arrayList;
        } catch (RemoteException e11) {
            LogM.e("Polyline", "getId RemoteException: " + e11.toString());
            return new ArrayList(0);
        }
    }

    public Cap getEndCap() {
        try {
            return this.f49544a.getEndCap();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "getEndCap RemoteException: " + e11.toString());
            return null;
        }
    }

    public String getId() {
        try {
            return this.f49544a.getId();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "getId RemoteException: " + e11.toString());
            return null;
        }
    }

    public int getJointType() {
        try {
            return this.f49544a.getJointType();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "getJointType RemoteException: " + e11.toString());
            return -1;
        }
    }

    public List<PatternItem> getPattern() {
        try {
            return this.f49544a.getPattern();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "getPattern RemoteException: " + e11.toString());
            return null;
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.f49544a.getPoints();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "getPoints RemoteException: " + e11.toString());
            return null;
        }
    }

    public Cap getStartCap() {
        try {
            return this.f49544a.getStartCap();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "getStartCap RemoteException: " + e11.toString());
            return null;
        }
    }

    public Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.f49544a.getTag());
        } catch (RemoteException e11) {
            LogM.e("Polyline", "getTag RemoteException: " + e11.toString());
            return null;
        }
    }

    public float getWidth() {
        try {
            return this.f49544a.getWidth();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "getId RemoteException: " + e11.toString());
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            return this.f49544a.getZIndex();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "getZIndex RemoteException: " + e11.toString());
            return -1.0f;
        }
    }

    public int hashCode() {
        try {
            return this.f49544a.hashCodeRemote();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isClickable() {
        try {
            return this.f49544a.isClickable();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "isClickable RemoteException: " + e11.toString());
            return true;
        }
    }

    public boolean isGeodesic() {
        try {
            return this.f49544a.isGeodesic();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "isGeodesic RemoteException: " + e11.toString());
            return true;
        }
    }

    public boolean isGradient() {
        try {
            return this.f49544a.isGradient();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "isGradient RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isVisible() {
        try {
            return this.f49544a.isVisible();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "isVisible RemoteException: " + e11.toString());
            return true;
        }
    }

    public void remove() {
        try {
            this.f49544a.remove();
        } catch (RemoteException e11) {
            LogM.e("Polyline", "remove RemoteException: " + e11.toString());
        }
    }

    public void setClickable(boolean z11) {
        try {
            this.f49544a.setClickable(z11);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setClickable RemoteException: " + e11.toString());
        }
    }

    public void setColor(int i11) {
        try {
            this.f49544a.setColor(i11);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setColor RemoteException: " + e11.toString());
        }
    }

    public void setColorValues(List<Integer> list) {
        try {
            this.f49544a.setColorValues(list);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setColorValues RemoteException: " + e11.toString());
        }
    }

    public void setEndCap(Cap cap) {
        try {
            this.f49544a.setEndCap(cap);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setEndCap RemoteException: " + e11.toString());
        }
    }

    public void setGeodesic(boolean z11) {
        try {
            this.f49544a.setGeodesic(z11);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setGeodesic RemoteException: " + e11.toString());
        }
    }

    public void setGradient(boolean z11) {
        try {
            this.f49544a.setGradient(z11);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setGradient RemoteException: " + e11.toString());
        }
    }

    public void setJointType(int i11) {
        try {
            this.f49544a.setJointType(i11);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setJointType RemoteException: " + e11.toString());
        }
    }

    public void setPattern(List<PatternItem> list) {
        try {
            this.f49544a.setPattern(list);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setPattern RemoteException: " + e11.toString());
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.f49544a.setPoints(list);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setPoints RemoteException: " + e11.toString());
        }
    }

    public void setStartCap(Cap cap) {
        try {
            this.f49544a.setStartCap(cap);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setStartCap RemoteException: " + e11.toString());
        }
    }

    public void setTag(Object obj) {
        try {
            this.f49544a.setTag(ObjectWrapper.wrap(obj));
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setTag RemoteException: " + e11.toString());
        }
    }

    public void setVisible(boolean z11) {
        try {
            this.f49544a.setVisible(z11);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setVisible RemoteException: " + e11.toString());
        }
    }

    public void setWidth(float f11) {
        if (f11 >= 0.0f) {
            try {
                this.f49544a.setWidth(f11);
            } catch (RemoteException e11) {
                LogM.e("Polyline", "setWidth RemoteException: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("Polyline width value is illegal ,this value must be non-negative");
        }
    }

    public void setZIndex(float f11) {
        try {
            this.f49544a.setZIndex(f11);
        } catch (RemoteException e11) {
            LogM.e("Polyline", "setZIndex RemoteException: " + e11.toString());
        }
    }
}
