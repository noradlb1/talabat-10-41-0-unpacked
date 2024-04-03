package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import java.util.List;

final class zzk extends FindAutocompletePredictionsRequest {
    private final String zza;
    private final LocationBias zzb;
    private final LocationRestriction zzc;
    private final LatLng zzd;
    private final List<String> zze;
    private final AutocompleteSessionToken zzf;
    private final TypeFilter zzg;
    private final CancellationToken zzh;

    public /* synthetic */ zzk(String str, LocationBias locationBias, LocationRestriction locationRestriction, LatLng latLng, List list, AutocompleteSessionToken autocompleteSessionToken, TypeFilter typeFilter, CancellationToken cancellationToken, zzj zzj) {
        this.zza = str;
        this.zzb = locationBias;
        this.zzc = locationRestriction;
        this.zzd = latLng;
        this.zze = list;
        this.zzf = autocompleteSessionToken;
        this.zzg = typeFilter;
        this.zzh = cancellationToken;
    }

    public final boolean equals(Object obj) {
        AutocompleteSessionToken autocompleteSessionToken;
        TypeFilter typeFilter;
        CancellationToken cancellationToken;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindAutocompletePredictionsRequest) {
            FindAutocompletePredictionsRequest findAutocompletePredictionsRequest = (FindAutocompletePredictionsRequest) obj;
            String str = this.zza;
            if (str != null ? str.equals(findAutocompletePredictionsRequest.getQuery()) : findAutocompletePredictionsRequest.getQuery() == null) {
                LocationBias locationBias = this.zzb;
                if (locationBias != null ? locationBias.equals(findAutocompletePredictionsRequest.getLocationBias()) : findAutocompletePredictionsRequest.getLocationBias() == null) {
                    LocationRestriction locationRestriction = this.zzc;
                    if (locationRestriction != null ? locationRestriction.equals(findAutocompletePredictionsRequest.getLocationRestriction()) : findAutocompletePredictionsRequest.getLocationRestriction() == null) {
                        LatLng latLng = this.zzd;
                        if (latLng != null ? latLng.equals(findAutocompletePredictionsRequest.getOrigin()) : findAutocompletePredictionsRequest.getOrigin() == null) {
                            if (!this.zze.equals(findAutocompletePredictionsRequest.getCountries()) || ((autocompleteSessionToken = this.zzf) != null ? !autocompleteSessionToken.equals(findAutocompletePredictionsRequest.getSessionToken()) : findAutocompletePredictionsRequest.getSessionToken() != null) || ((typeFilter = this.zzg) != null ? !typeFilter.equals(findAutocompletePredictionsRequest.getTypeFilter()) : findAutocompletePredictionsRequest.getTypeFilter() != null) || ((cancellationToken = this.zzh) != null ? !cancellationToken.equals(findAutocompletePredictionsRequest.getCancellationToken()) : findAutocompletePredictionsRequest.getCancellationToken() != null)) {
                                return false;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    public final CancellationToken getCancellationToken() {
        return this.zzh;
    }

    public final List<String> getCountries() {
        return this.zze;
    }

    @Nullable
    public final LocationBias getLocationBias() {
        return this.zzb;
    }

    @Nullable
    public final LocationRestriction getLocationRestriction() {
        return this.zzc;
    }

    @Nullable
    public final LatLng getOrigin() {
        return this.zzd;
    }

    @Nullable
    public final String getQuery() {
        return this.zza;
    }

    @Nullable
    public final AutocompleteSessionToken getSessionToken() {
        return this.zzf;
    }

    @Nullable
    public final TypeFilter getTypeFilter() {
        return this.zzg;
    }

    public final int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        String str = this.zza;
        int i17 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int i18 = (i11 ^ 1000003) * 1000003;
        LocationBias locationBias = this.zzb;
        if (locationBias == null) {
            i12 = 0;
        } else {
            i12 = locationBias.hashCode();
        }
        int i19 = (i18 ^ i12) * 1000003;
        LocationRestriction locationRestriction = this.zzc;
        if (locationRestriction == null) {
            i13 = 0;
        } else {
            i13 = locationRestriction.hashCode();
        }
        int i21 = (i19 ^ i13) * 1000003;
        LatLng latLng = this.zzd;
        if (latLng == null) {
            i14 = 0;
        } else {
            i14 = latLng.hashCode();
        }
        int hashCode = (((i21 ^ i14) * 1000003) ^ this.zze.hashCode()) * 1000003;
        AutocompleteSessionToken autocompleteSessionToken = this.zzf;
        if (autocompleteSessionToken == null) {
            i15 = 0;
        } else {
            i15 = autocompleteSessionToken.hashCode();
        }
        int i22 = (hashCode ^ i15) * 1000003;
        TypeFilter typeFilter = this.zzg;
        if (typeFilter == null) {
            i16 = 0;
        } else {
            i16 = typeFilter.hashCode();
        }
        int i23 = (i22 ^ i16) * 1000003;
        CancellationToken cancellationToken = this.zzh;
        if (cancellationToken != null) {
            i17 = cancellationToken.hashCode();
        }
        return i23 ^ i17;
    }

    public final String toString() {
        String str = this.zza;
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        String valueOf3 = String.valueOf(this.zzd);
        String valueOf4 = String.valueOf(this.zze);
        String valueOf5 = String.valueOf(this.zzf);
        String valueOf6 = String.valueOf(this.zzg);
        String valueOf7 = String.valueOf(this.zzh);
        int length = String.valueOf(str).length();
        int length2 = valueOf.length();
        int length3 = valueOf2.length();
        int length4 = valueOf3.length();
        int length5 = valueOf4.length();
        int length6 = valueOf5.length();
        StringBuilder sb2 = new StringBuilder(length + 148 + length2 + length3 + length4 + length5 + length6 + valueOf6.length() + valueOf7.length());
        sb2.append("FindAutocompletePredictionsRequest{query=");
        sb2.append(str);
        sb2.append(", locationBias=");
        sb2.append(valueOf);
        sb2.append(", locationRestriction=");
        sb2.append(valueOf2);
        sb2.append(", origin=");
        sb2.append(valueOf3);
        sb2.append(", countries=");
        sb2.append(valueOf4);
        sb2.append(", sessionToken=");
        sb2.append(valueOf5);
        sb2.append(", typeFilter=");
        sb2.append(valueOf6);
        sb2.append(", cancellationToken=");
        sb2.append(valueOf7);
        sb2.append("}");
        return sb2.toString();
    }
}
