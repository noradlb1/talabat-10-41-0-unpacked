package com.huawei.hms.maps.model;

import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.maps.model.internal.IPolygonDelegate;
import com.huawei.hms.maps.utils.LogM;
import java.util.List;

public final class Polygon {

    /* renamed from: a  reason: collision with root package name */
    private IPolygonDelegate f49532a;

    public Polygon(IPolygonDelegate iPolygonDelegate) {
        LogM.d("Polygon", "Polygon: ");
        this.f49532a = iPolygonDelegate;
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof Polygon) {
                return this.f49532a.equalsRemote(((Polygon) obj).f49532a);
            }
            return false;
        } catch (RemoteException e11) {
            LogM.d("Polygon", "equals RemoteException: " + e11.toString());
            return false;
        }
    }

    public int getFillColor() {
        try {
            return this.f49532a.getFillColor();
        } catch (RemoteException e11) {
            LogM.d("Polygon", "getFillColor RemoteException: " + e11.toString());
            return 0;
        }
    }

    public List<List<LatLng>> getHoles() {
        try {
            return this.f49532a.getHoles();
        } catch (RemoteException e11) {
            LogM.e("Polygon", "getHoles RemoteException: " + e11.toString());
            return null;
        }
    }

    public String getId() {
        try {
            return this.f49532a.getId();
        } catch (RemoteException e11) {
            LogM.d("Polygon", "getId RemoteException: " + e11.toString());
            return null;
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.f49532a.getPoints();
        } catch (RemoteException e11) {
            LogM.d("Polygon", "getPoints RemoteException: " + e11.toString());
            return null;
        }
    }

    public int getStrokeColor() {
        try {
            return this.f49532a.getStrokeColor();
        } catch (RemoteException e11) {
            LogM.d("Polygon", "getStrokeColor RemoteException: " + e11.toString());
            return 0;
        }
    }

    public int getStrokeJointType() {
        try {
            return this.f49532a.getStrokeJointType();
        } catch (RemoteException e11) {
            LogM.d("Polygon", "getStrokeJointType RemoteException: " + e11.toString());
            return 0;
        }
    }

    public List<PatternItem> getStrokePattern() {
        try {
            return this.f49532a.getStrokePattern();
        } catch (RemoteException e11) {
            LogM.e("Polygon", "getStrokePattern RemoteException: " + e11.toString());
            return null;
        }
    }

    public float getStrokeWidth() {
        try {
            return this.f49532a.getStrokeWidth();
        } catch (RemoteException e11) {
            LogM.d("Polygon", "getStrokeWidth RemoteException: " + e11.toString());
            return -1.0f;
        }
    }

    public Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.f49532a.getTag());
        } catch (RemoteException e11) {
            LogM.d("Polygon", "getTag RemoteException: " + e11.toString());
            return null;
        }
    }

    public float getZIndex() {
        try {
            return this.f49532a.getZIndex();
        } catch (RemoteException e11) {
            LogM.e("Polygon", "getZIndex RemoteException: " + e11.toString());
            return -1.0f;
        }
    }

    public int hashCode() {
        try {
            return this.f49532a.hashCodeRemote();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isClickable() {
        try {
            return this.f49532a.isClickable();
        } catch (RemoteException e11) {
            LogM.d("Polygon", "isClickable RemoteException: " + e11.toString());
            return true;
        }
    }

    public boolean isGeodesic() {
        try {
            return this.f49532a.isGeodesic();
        } catch (RemoteException e11) {
            LogM.e("Polygon", "isGeodesic RemoteException: " + e11.toString());
            return true;
        }
    }

    public boolean isVisible() {
        try {
            return this.f49532a.isVisible();
        } catch (RemoteException e11) {
            LogM.e("Polygon", "isVisible RemoteException: " + e11.toString());
            return true;
        }
    }

    public void remove() {
        try {
            this.f49532a.remove();
        } catch (RemoteException e11) {
            LogM.d("Polygon", "remove RemoteException: " + e11.toString());
        }
    }

    public void setClickable(boolean z11) {
        try {
            this.f49532a.setClickable(z11);
        } catch (RemoteException e11) {
            LogM.d("Polygon", "setClickable RemoteException: " + e11.toString());
        }
    }

    public void setFillColor(int i11) {
        try {
            this.f49532a.setFillColor(i11);
        } catch (RemoteException e11) {
            LogM.d("Polygon", "setFillColor RemoteException: " + e11.toString());
        }
    }

    public void setGeodesic(boolean z11) {
        try {
            this.f49532a.setGeodesic(z11);
        } catch (RemoteException e11) {
            LogM.e("Polygon", "setGeodesic RemoteException: " + e11.toString());
        }
    }

    public void setHoles(List<? extends List<LatLng>> list) {
        try {
            this.f49532a.setHoles(list);
        } catch (RemoteException e11) {
            LogM.e("Polygon", "setHoles RemoteException: " + e11.toString());
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.f49532a.setPoints(list);
        } catch (RemoteException e11) {
            LogM.d("Polygon", "setPoints RemoteException: " + e11.toString());
        }
    }

    public void setStrokeColor(int i11) {
        try {
            this.f49532a.setStrokeColor(i11);
        } catch (RemoteException e11) {
            LogM.d("Polygon", "setStrokeColor RemoteException: " + e11.toString());
        }
    }

    public void setStrokeJointType(int i11) {
        try {
            this.f49532a.setStrokeJointType(i11);
        } catch (RemoteException e11) {
            LogM.e("Polygon", "setStrokeJointType RemoteException: " + e11.toString());
        }
    }

    public void setStrokePattern(List<PatternItem> list) {
        try {
            this.f49532a.setStrokePattern(list);
        } catch (RemoteException e11) {
            LogM.e("Polygon", "setStrokePattern RemoteException: " + e11.toString());
        }
    }

    public void setStrokeWidth(float f11) {
        try {
            this.f49532a.setStrokeWidth(f11);
        } catch (RemoteException e11) {
            LogM.d("Polygon", "setStrokeWidth RemoteException: " + e11.toString());
        }
    }

    public void setTag(Object obj) {
        try {
            this.f49532a.setTag(ObjectWrapper.wrap(obj));
        } catch (RemoteException e11) {
            LogM.d("Polygon", "setTag RemoteException: " + e11.toString());
        }
    }

    public void setVisible(boolean z11) {
        try {
            this.f49532a.setVisible(z11);
        } catch (RemoteException e11) {
            LogM.e("Polygon", "setVisible RemoteException: " + e11.toString());
        }
    }

    public void setZIndex(float f11) {
        try {
            this.f49532a.setZIndex(f11);
        } catch (RemoteException e11) {
            LogM.e("Polygon", "setZIndex RemoteException: " + e11.toString());
        }
    }
}
