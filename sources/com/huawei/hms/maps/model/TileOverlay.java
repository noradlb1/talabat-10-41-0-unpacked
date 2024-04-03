package com.huawei.hms.maps.model;

import android.os.RemoteException;
import com.huawei.hms.maps.model.internal.ITileOverlayDelegate;

public final class TileOverlay {

    /* renamed from: a  reason: collision with root package name */
    private final ITileOverlayDelegate f49560a;

    public TileOverlay(ITileOverlayDelegate iTileOverlayDelegate) {
        this.f49560a = iTileOverlayDelegate;
    }

    public void clearTileCache() {
        try {
            this.f49560a.clearTileCache();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.f49560a.equalsRemote(((TileOverlay) obj).f49560a);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean getFadeIn() {
        try {
            return this.f49560a.getFadeIn();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public String getId() {
        try {
            return this.f49560a.getId();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getTransparency() {
        try {
            return this.f49560a.getTransparency();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getZIndex() {
        try {
            return this.f49560a.getZIndex();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public int hashCode() {
        try {
            return this.f49560a.hashCodeRemote();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isVisible() {
        try {
            return this.f49560a.isVisible();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void remove() {
        try {
            this.f49560a.remove();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setFadeIn(boolean z11) {
        try {
            this.f49560a.setFadeIn(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setTransparency(float f11) {
        try {
            this.f49560a.setTransparency(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setVisible(boolean z11) {
        try {
            this.f49560a.setVisible(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setZIndex(float f11) {
        try {
            this.f49560a.setZIndex(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
