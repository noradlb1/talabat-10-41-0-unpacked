package com.huawei.hms.maps.model;

import android.os.RemoteException;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.maps.model.internal.IGroundOverlayDelegate;
import com.huawei.hms.maps.utils.LogM;

public final class GroundOverlay {

    /* renamed from: a  reason: collision with root package name */
    private final IGroundOverlayDelegate f49463a;

    public GroundOverlay(IGroundOverlayDelegate iGroundOverlayDelegate) {
        this.f49463a = iGroundOverlayDelegate;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.f49463a.equalsRemote(((GroundOverlay) obj).f49463a);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getBearing() {
        try {
            return this.f49463a.getBearing();
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "getBearing RemoteException: " + e11.toString());
            return 0.0f;
        }
    }

    public LatLngBounds getBounds() {
        try {
            return this.f49463a.getBounds();
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "getBounds RemoteException: " + e11.toString());
            return null;
        }
    }

    public float getHeight() {
        try {
            return this.f49463a.getHeight();
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "getHeight RemoteException: " + e11.toString());
            return 0.0f;
        }
    }

    public String getId() {
        try {
            return this.f49463a.getId();
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "getId RemoteException: " + e11.toString());
            return null;
        }
    }

    public LatLng getPosition() {
        try {
            return this.f49463a.getPosition();
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "getPosition RemoteException: " + e11.toString());
            return null;
        }
    }

    public Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.f49463a.getTag());
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "getTag RemoteException: " + e11.toString());
            return null;
        }
    }

    public float getTransparency() {
        try {
            return this.f49463a.getTransparency();
        } catch (RemoteException e11) {
            LogM.e("GroundOverlay", "getTransparency RemoteException: " + e11.toString());
            return -1.0f;
        }
    }

    public float getWidth() {
        try {
            return this.f49463a.getWidth();
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "getWidth RemoteException: " + e11.toString());
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            return this.f49463a.getZIndex();
        } catch (RemoteException e11) {
            LogM.e("GroundOverlay", "getZIndex RemoteException: " + e11.toString());
            return -1.0f;
        }
    }

    public int hashCode() {
        try {
            return this.f49463a.hashCodeRemote();
        } catch (RemoteException e11) {
            LogM.e("GroundOverlay", "hashCode RemoteException: " + e11.toString());
            return 0;
        }
    }

    public boolean isClickable() {
        try {
            return this.f49463a.isClickable();
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "isClickable RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isVisible() {
        try {
            return this.f49463a.isVisible();
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "isVisible RemoteException: " + e11.toString());
            return true;
        }
    }

    public void remove() {
        try {
            IGroundOverlayDelegate iGroundOverlayDelegate = this.f49463a;
            if (iGroundOverlayDelegate != null) {
                iGroundOverlayDelegate.remove();
            }
        } catch (RemoteException e11) {
            LogM.e("GroundOverlay", "remove RemoteException: " + e11.toString());
        }
    }

    public void setBearing(float f11) {
        try {
            this.f49463a.setBearing(f11);
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "setBearing RemoteException: " + e11.toString());
        }
    }

    public void setClickable(boolean z11) {
        try {
            this.f49463a.setClickable(z11);
        } catch (RemoteException e11) {
            LogM.e("GroundOverlay", "setClickable RemoteException: " + e11.toString());
        }
    }

    public void setDimensions(float f11) {
        try {
            this.f49463a.setDimension(f11);
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "setDimensions RemoteException: " + e11.toString());
        }
    }

    public void setDimensions(float f11, float f12) {
        try {
            this.f49463a.setDimensions(f11, f12);
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "setDimensions RemoteException: " + e11.toString());
        }
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        Preconditions.checkNotNull(bitmapDescriptor, "you should check image , it can not be null.");
        try {
            this.f49463a.setImage(bitmapDescriptor.getObject());
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "setImage RemoteException: " + e11.toString());
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.f49463a.setPosition(latLng);
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "setPosition RemoteException: " + e11.toString());
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            this.f49463a.setPositionFromBounds(latLngBounds);
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "setPositionFromBounds RemoteException: " + e11.toString());
        }
    }

    public void setTag(Object obj) {
        try {
            this.f49463a.setTag(ObjectWrapper.wrap(obj));
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "setTag RemoteException: " + e11.toString());
        }
    }

    public void setTransparency(float f11) {
        try {
            this.f49463a.setTransparency(f11);
        } catch (RemoteException e11) {
            LogM.e("GroundOverlay", "setTransparency RemoteException: " + e11.toString());
        }
    }

    public void setVisible(boolean z11) {
        try {
            this.f49463a.setVisible(z11);
        } catch (RemoteException e11) {
            LogM.d("GroundOverlay", "setVisible RemoteException: " + e11.toString());
        }
    }

    public void setZIndex(float f11) {
        try {
            this.f49463a.setZIndex(f11);
        } catch (RemoteException e11) {
            LogM.e("GroundOverlay", "setZIndex RemoteException: " + e11.toString());
        }
    }
}
