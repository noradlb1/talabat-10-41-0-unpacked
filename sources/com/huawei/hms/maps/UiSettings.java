package com.huawei.hms.maps;

import android.os.RemoteException;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.maps.internal.IUiSettingsDelegate;
import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.utils.LogM;

public class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    private final IUiSettingsDelegate f49376a;

    public UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        LogM.d("UISettings", "UISettings: ");
        this.f49376a = iUiSettingsDelegate;
    }

    public boolean isCompassEnabled() {
        try {
            return this.f49376a.isCompassEnabled();
        } catch (RemoteException e11) {
            LogM.d("UISettings", "isCompassEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isIndoorLevelPickerEnabled() {
        try {
            return this.f49376a.isIndoorLevelPickerEnabled();
        } catch (RemoteException e11) {
            LogM.d("UISettings", "isIndoorLevelPickerEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isMapToolbarEnabled() {
        try {
            return this.f49376a.isMapToolbarEnabled();
        } catch (RemoteException e11) {
            LogM.d("UISettings", "isMapToolbarEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.f49376a.isMyLocationButtonEnabled();
        } catch (RemoteException e11) {
            LogM.d("UISettings", "isMyLocationButtonEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            return this.f49376a.isRotateGesturesEnabled();
        } catch (RemoteException e11) {
            LogM.d("UISettings", "isRotateGesturesEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.f49376a.isScrollGesturesEnabled();
        } catch (RemoteException e11) {
            LogM.d("UISettings", "isScrollGesturesEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isScrollGesturesEnabledDuringRotateOrZoom() {
        try {
            return this.f49376a.isScrollGesturesEnabledDuringRotateOrZoom();
        } catch (RemoteException e11) {
            LogM.e("UISettings", "isScrollGesturesEnabledDuringRotateOrZoom RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            return this.f49376a.isTiltGesturesEnabled();
        } catch (RemoteException e11) {
            LogM.d("UISettings", "isTiltGesturesEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.f49376a.isZoomControlsEnabled();
        } catch (RemoteException e11) {
            LogM.d("UISettings", "isZoomControlsEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.f49376a.isZoomGesturesEnabled();
        } catch (RemoteException e11) {
            LogM.d("UISettings", "isZoomGesturesEnabled RemoteException: " + e11.toString());
            return false;
        }
    }

    public void setAllGesturesEnabled(boolean z11) {
        try {
            this.f49376a.setAllGesturesEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setAllGesturesEnabled RemoteException: " + e11.toString());
        }
    }

    public void setCompassEnabled(boolean z11) {
        try {
            this.f49376a.setCompassEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setCompassEnabled RemoteException: " + e11.toString());
        }
    }

    public void setGestureScaleByMapCenter(boolean z11) {
        try {
            this.f49376a.setGestureScaleByMapCenter(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setGestureScaleByMapCenter RemoteException: " + e11.toString());
        }
    }

    public void setIndoorLevelPickerEnabled(boolean z11) {
        try {
            this.f49376a.setIndoorLevelPickerEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setIndoorLevelPickerEnabled RemoteException: " + e11.toString());
        }
    }

    public void setIndoorLevelPickerPadding(int i11, int i12, int i13, int i14) {
        try {
            this.f49376a.setIndoorLevelPickerPadding(i11, i12, i13, i14);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setIndoorLevelPickerPadding RemoteException: " + e11.toString());
        }
    }

    public void setLogoPadding(int i11, int i12, int i13, int i14) {
        try {
            this.f49376a.setLogoPadding(i11, i12, i13, i14);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setLogoPadding RemoteException: " + e11.toString());
        }
    }

    public void setLogoPosition(int i11) {
        switch (i11) {
            case 81:
            case BadgeDrawable.TOP_START:
            case BadgeDrawable.TOP_END:
            case BadgeDrawable.BOTTOM_START:
            case BadgeDrawable.BOTTOM_END:
                try {
                    this.f49376a.setLogoPosition(i11);
                    return;
                } catch (RemoteException e11) {
                    LogM.d("UISettings", "setLogoPosition RemoteException: " + e11.toString());
                    return;
                }
            default:
                return;
        }
    }

    public void setMapToolbarEnabled(boolean z11) {
        try {
            this.f49376a.setMapToolbarEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setMyLocationButtonEnabled RemoteException: " + e11.toString());
        }
    }

    public void setMarkerClusterColor(int i11) {
        try {
            this.f49376a.setMarkerClusterColor(i11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setMarkerClusterColor RemoteException: " + e11.toString());
        }
    }

    public void setMarkerClusterIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            try {
                this.f49376a.setMarkerClusterIcon(ObjectWrapper.wrap(null));
            } catch (RemoteException e11) {
                LogM.d("UISettings", "setMarkerClusterIcon RemoteException: " + e11.toString());
            }
        } else {
            this.f49376a.setMarkerClusterIcon(bitmapDescriptor.getObject());
        }
    }

    public void setMarkerClusterTextColor(int i11) {
        try {
            this.f49376a.setMarkerClusterTextColor(i11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setMarkerClusterColor RemoteException: " + e11.toString());
        }
    }

    public void setMyLocationButtonEnabled(boolean z11) {
        try {
            this.f49376a.setMyLocationButtonEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setMyLocationButtonEnabled RemoteException: " + e11.toString());
        }
    }

    public void setRotateGesturesEnabled(boolean z11) {
        try {
            this.f49376a.setRotateGesturesEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setRotateGesturesEnabled RemoteException: " + e11.toString());
        }
    }

    public void setScaleVisible(boolean z11) {
        try {
            this.f49376a.setScaleVisible(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setScaleVisible RemoteException: " + e11.toString());
        }
    }

    public void setScrollGesturesEnabled(boolean z11) {
        try {
            this.f49376a.setScrollGesturesEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setScrollGesturesEnabled RemoteException: " + e11.toString());
        }
    }

    public void setScrollGesturesEnabledDuringRotateOrZoom(boolean z11) {
        try {
            this.f49376a.setScrollGesturesEnabledDuringRotateOrZoom(z11);
        } catch (RemoteException e11) {
            LogM.e("UISettings", "setScrollGesturesEnabledDuringRotateOrZoom RemoteException: " + e11.toString());
        }
    }

    public void setTiltGesturesEnabled(boolean z11) {
        try {
            this.f49376a.setTiltGesturesEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setTiltGesturesEnabled RemoteException: " + e11.toString());
        }
    }

    public void setZoomControlsEnabled(boolean z11) {
        try {
            this.f49376a.setZoomControlsEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setZoomControlsEnabled RemoteException: " + e11.toString());
        }
    }

    public void setZoomGesturesEnabled(boolean z11) {
        try {
            this.f49376a.setZoomGesturesEnabled(z11);
        } catch (RemoteException e11) {
            LogM.d("UISettings", "setZoomGesturesEnabled RemoteException: " + e11.toString());
        }
    }
}
