package com.google.android.libraries.places.api.net;

import androidx.annotation.RecentlyNonNull;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.internal.zzge;
import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
public abstract class FindAutocompletePredictionsResponse {
    @RecentlyNonNull
    public static FindAutocompletePredictionsResponse newInstance(@RecentlyNonNull List<AutocompletePrediction> list) {
        return new zzl(zzge.zzk(list));
    }

    @RecentlyNonNull
    public abstract List<AutocompletePrediction> getAutocompletePredictions();
}
