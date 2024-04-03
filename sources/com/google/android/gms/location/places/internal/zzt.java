package com.google.android.gms.location.places.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public interface zzt extends IInterface {
    void zzb(AddPlaceRequest addPlaceRequest, zzau zzau, zzx zzx) throws RemoteException;

    void zzb(String str, int i11, int i12, int i13, zzau zzau, zzv zzv) throws RemoteException;

    void zzb(String str, zzau zzau, zzv zzv) throws RemoteException;

    void zzb(String str, LatLngBounds latLngBounds, int i11, AutocompleteFilter autocompleteFilter, zzau zzau, zzx zzx) throws RemoteException;

    void zzb(List<String> list, zzau zzau, zzx zzx) throws RemoteException;
}
