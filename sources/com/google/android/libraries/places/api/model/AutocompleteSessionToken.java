package com.google.android.libraries.places.api.model;

import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.auto.value.AutoValue;
import java.util.UUID;

@AutoValue
public abstract class AutocompleteSessionToken implements Parcelable {
    @RecentlyNonNull
    public static AutocompleteSessionToken newInstance() {
        return new zzah(new ParcelUuid(UUID.randomUUID()));
    }

    @RecentlyNonNull
    public final String toString() {
        return zza().toString();
    }

    public abstract ParcelUuid zza();
}
