package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.model.PlaceLikelihood;
import java.util.List;

final class zzp extends FindCurrentPlaceResponse {
    private final List<PlaceLikelihood> zza;

    public zzp(List<PlaceLikelihood> list) {
        if (list != null) {
            this.zza = list;
            return;
        }
        throw new NullPointerException("Null placeLikelihoods");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindCurrentPlaceResponse) {
            return this.zza.equals(((FindCurrentPlaceResponse) obj).getPlaceLikelihoods());
        }
        return false;
    }

    public final List<PlaceLikelihood> getPlaceLikelihoods() {
        return this.zza;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 43);
        sb2.append("FindCurrentPlaceResponse{placeLikelihoods=");
        sb2.append(valueOf);
        sb2.append("}");
        return sb2.toString();
    }
}
