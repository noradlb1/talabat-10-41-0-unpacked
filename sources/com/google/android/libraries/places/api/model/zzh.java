package com.google.android.libraries.places.api.model;

import android.os.ParcelUuid;

abstract class zzh extends AutocompleteSessionToken {
    private final ParcelUuid zza;

    public zzh(ParcelUuid parcelUuid) {
        if (parcelUuid != null) {
            this.zza = parcelUuid;
            return;
        }
        throw new NullPointerException("Null UUID");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutocompleteSessionToken) {
            return this.zza.equals(((AutocompleteSessionToken) obj).zza());
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    public final ParcelUuid zza() {
        return this.zza;
    }
}
