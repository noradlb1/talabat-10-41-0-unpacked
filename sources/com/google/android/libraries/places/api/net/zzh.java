package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.model.Place;

final class zzh extends FetchPlaceResponse {
    private final Place zza;

    public zzh(Place place) {
        if (place != null) {
            this.zza = place;
            return;
        }
        throw new NullPointerException("Null place");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPlaceResponse) {
            return this.zza.equals(((FetchPlaceResponse) obj).getPlace());
        }
        return false;
    }

    public final Place getPlace() {
        return this.zza;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 26);
        sb2.append("FetchPlaceResponse{place=");
        sb2.append(valueOf);
        sb2.append("}");
        return sb2.toString();
    }
}
