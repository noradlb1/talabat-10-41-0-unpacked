package com.google.android.libraries.places.api.net;

import androidx.annotation.RecentlyNonNull;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.internal.zzge;
import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
public abstract class FindCurrentPlaceResponse {
    @RecentlyNonNull
    public static FindCurrentPlaceResponse newInstance(@RecentlyNonNull List<PlaceLikelihood> list) {
        return new zzp(zzge.zzk(list));
    }

    @RecentlyNonNull
    public abstract List<PlaceLikelihood> getPlaceLikelihoods();
}
