package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;

public interface IUiSettingsDelegate extends IInterface {
    boolean isCompassEnabled() throws RemoteException;

    boolean isIndoorLevelPickerEnabled() throws RemoteException;

    boolean isMapToolbarEnabled() throws RemoteException;

    boolean isMyLocationButtonEnabled() throws RemoteException;

    boolean isRotateGesturesEnabled() throws RemoteException;

    boolean isScrollGesturesEnabled() throws RemoteException;

    boolean isScrollGesturesEnabledDuringRotateOrZoom() throws RemoteException;

    boolean isTiltGesturesEnabled() throws RemoteException;

    boolean isZoomControlsEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    void setAllGesturesEnabled(boolean z11) throws RemoteException;

    void setCompassEnabled(boolean z11) throws RemoteException;

    void setIndoorLevelPickerEnabled(boolean z11) throws RemoteException;

    void setMapToolbarEnabled(boolean z11) throws RemoteException;

    void setMyLocationButtonEnabled(boolean z11) throws RemoteException;

    void setRotateGesturesEnabled(boolean z11) throws RemoteException;

    void setScrollGesturesEnabled(boolean z11) throws RemoteException;

    void setScrollGesturesEnabledDuringRotateOrZoom(boolean z11) throws RemoteException;

    void setTiltGesturesEnabled(boolean z11) throws RemoteException;

    void setZoomControlsEnabled(boolean z11) throws RemoteException;

    void setZoomGesturesEnabled(boolean z11) throws RemoteException;
}
