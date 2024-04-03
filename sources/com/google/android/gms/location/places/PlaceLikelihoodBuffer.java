package com.google.android.gms.location.places;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.location.places.internal.zzak;
import com.google.android.gms.location.places.internal.zzam;
import java.util.Comparator;

@Deprecated
public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private static final Comparator<zzak> zzac = new zzj();
    private final int zzad;
    private final boolean zzae;
    private final Status zzp;
    private final String zzq;

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int i11) {
        this(dataHolder, false, i11);
    }

    public static int zzb(Bundle bundle) {
        return bundle.getInt("com.google.android.gms.location.places.PlaceLikelihoodBuffer.SOURCE_EXTRA_KEY");
    }

    public PlaceLikelihood get(int i11) {
        return new zzam(this.mDataHolder, i11);
    }

    @Nullable
    public CharSequence getAttributions() {
        return this.zzq;
    }

    public Status getStatus() {
        return this.zzp;
    }

    @ShowFirstParty
    public String toString() {
        return Objects.toStringHelper(this).add("status", getStatus()).add("attributions", this.zzq).toString();
    }

    private PlaceLikelihoodBuffer(DataHolder dataHolder, boolean z11, int i11) {
        super(dataHolder);
        this.zzp = PlacesStatusCodes.zzb(dataHolder.getStatusCode());
        switch (i11) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
                this.zzad = i11;
                this.zzae = false;
                if (dataHolder.getMetadata() != null) {
                    this.zzq = dataHolder.getMetadata().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
                    return;
                } else {
                    this.zzq = null;
                    return;
                }
            default:
                StringBuilder sb2 = new StringBuilder(27);
                sb2.append("invalid source: ");
                sb2.append(i11);
                throw new IllegalArgumentException(sb2.toString());
        }
    }
}
