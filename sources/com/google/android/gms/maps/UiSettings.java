package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings {
    private final IUiSettingsDelegate zza;

    public UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        this.zza = iUiSettingsDelegate;
    }

    public boolean isCompassEnabled() {
        try {
            return this.zza.isCompassEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isIndoorLevelPickerEnabled() {
        try {
            return this.zza.isIndoorLevelPickerEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isMapToolbarEnabled() {
        try {
            return this.zza.isMapToolbarEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.zza.isMyLocationButtonEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            return this.zza.isRotateGesturesEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.zza.isScrollGesturesEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isScrollGesturesEnabledDuringRotateOrZoom() {
        try {
            return this.zza.isScrollGesturesEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            return this.zza.isTiltGesturesEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.zza.isZoomControlsEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.zza.isZoomGesturesEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setAllGesturesEnabled(boolean z11) {
        try {
            this.zza.setAllGesturesEnabled(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setCompassEnabled(boolean z11) {
        try {
            this.zza.setCompassEnabled(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setIndoorLevelPickerEnabled(boolean z11) {
        try {
            this.zza.setIndoorLevelPickerEnabled(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setMapToolbarEnabled(boolean z11) {
        try {
            this.zza.setMapToolbarEnabled(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setMyLocationButtonEnabled(boolean z11) {
        try {
            this.zza.setMyLocationButtonEnabled(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setRotateGesturesEnabled(boolean z11) {
        try {
            this.zza.setRotateGesturesEnabled(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setScrollGesturesEnabled(boolean z11) {
        try {
            this.zza.setScrollGesturesEnabled(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setScrollGesturesEnabledDuringRotateOrZoom(boolean z11) {
        try {
            this.zza.setScrollGesturesEnabledDuringRotateOrZoom(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setTiltGesturesEnabled(boolean z11) {
        try {
            this.zza.setTiltGesturesEnabled(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setZoomControlsEnabled(boolean z11) {
        try {
            this.zza.setZoomControlsEnabled(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setZoomGesturesEnabled(boolean z11) {
        try {
            this.zza.setZoomGesturesEnabled(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
