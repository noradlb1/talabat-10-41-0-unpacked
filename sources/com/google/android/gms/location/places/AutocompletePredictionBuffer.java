package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.location.places.internal.zzd;

@Deprecated
public class AutocompletePredictionBuffer extends AbstractDataBuffer<AutocompletePrediction> implements Result {
    public AutocompletePredictionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public AutocompletePrediction get(int i11) {
        return new zzd(this.mDataHolder, i11);
    }

    public Status getStatus() {
        return PlacesStatusCodes.zzb(this.mDataHolder.getStatusCode());
    }

    public String toString() {
        return Objects.toStringHelper(this).add("status", getStatus()).toString();
    }
}
