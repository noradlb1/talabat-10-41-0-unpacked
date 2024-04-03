package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public final class zzq extends GmsClient<zzt> {
    private final zzau zzbt;

    private zzq(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 65, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzbt = new zzau(str, Locale.getDefault(), clientSettings.getAccount() != null ? clientSettings.getAccount().name : null, (String) null, 0);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (queryLocalInterface instanceof zzt) {
            return (zzt) queryLocalInterface;
        }
        return new zzw(iBinder);
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    public final void zzb(zzm zzm, String str, @Nullable LatLngBounds latLngBounds, int i11, @Nullable AutocompleteFilter autocompleteFilter) throws RemoteException {
        Preconditions.checkNotNull(zzm, "callback == null");
        if (str == null) {
            str = "";
        }
        String str2 = str;
        if (autocompleteFilter == null) {
            autocompleteFilter = new AutocompleteFilter.Builder().build();
        }
        ((zzt) getService()).zzb(str2, latLngBounds, i11, autocompleteFilter, this.zzbt, (zzx) zzm);
    }

    public final void zzb(zzm zzm, List<String> list) throws RemoteException {
        Preconditions.checkNotNull(zzm, "callback == null");
        ((zzt) getService()).zzb(list, this.zzbt, (zzx) zzm);
    }

    public final void zzb(zzm zzm, AddPlaceRequest addPlaceRequest) throws RemoteException {
        Preconditions.checkNotNull(zzm, "callback == null");
        ((zzt) getService()).zzb(addPlaceRequest, this.zzbt, (zzx) zzm);
    }

    public final void zzb(zzf zzf, String str) throws RemoteException {
        Preconditions.checkNotNull(zzf, "callback cannot be null");
        ((zzt) getService()).zzb(str, this.zzbt, (zzv) zzf);
    }

    public final void zzb(zzf zzf, String str, int i11, int i12, int i13) throws RemoteException {
        Preconditions.checkNotNull(zzf, "callback cannot be null");
        ((zzt) getService()).zzb(str, i11, i12, i13, this.zzbt, (zzv) zzf);
    }
}
