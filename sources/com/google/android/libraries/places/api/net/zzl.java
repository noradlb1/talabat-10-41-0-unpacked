package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.model.AutocompletePrediction;
import java.util.List;

final class zzl extends FindAutocompletePredictionsResponse {
    private final List<AutocompletePrediction> zza;

    public zzl(List<AutocompletePrediction> list) {
        if (list != null) {
            this.zza = list;
            return;
        }
        throw new NullPointerException("Null autocompletePredictions");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindAutocompletePredictionsResponse) {
            return this.zza.equals(((FindAutocompletePredictionsResponse) obj).getAutocompletePredictions());
        }
        return false;
    }

    public final List<AutocompletePrediction> getAutocompletePredictions() {
        return this.zza;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 61);
        sb2.append("FindAutocompletePredictionsResponse{autocompletePredictions=");
        sb2.append(valueOf);
        sb2.append("}");
        return sb2.toString();
    }
}
