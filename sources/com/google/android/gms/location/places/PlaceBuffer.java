package com.google.android.gms.location.places;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzar;

@Deprecated
public class PlaceBuffer extends AbstractDataBuffer<Place> implements Result {
    private final Status zzp;
    private final String zzq;

    public PlaceBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzp = PlacesStatusCodes.zzb(dataHolder.getStatusCode());
        if (dataHolder.getMetadata() != null) {
            this.zzq = dataHolder.getMetadata().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
        } else {
            this.zzq = null;
        }
    }

    public Place get(int i11) {
        return new zzar(this.mDataHolder, i11);
    }

    @Nullable
    public CharSequence getAttributions() {
        return this.zzq;
    }

    public Status getStatus() {
        return this.zzp;
    }
}
