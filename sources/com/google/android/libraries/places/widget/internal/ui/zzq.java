package com.google.android.libraries.places.widget.internal.ui;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.DiffUtil;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.internal.zzdh;

final class zzq extends DiffUtil.ItemCallback<AutocompletePrediction> {
    private zzq() {
    }

    public static final boolean zza(AutocompletePrediction autocompletePrediction, AutocompletePrediction autocompletePrediction2) {
        try {
            return autocompletePrediction.getPlaceId().equals(autocompletePrediction2.getPlaceId());
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    @SuppressLint({"DiffUtilEquals"})
    public final /* bridge */ /* synthetic */ boolean areContentsTheSame(Object obj, Object obj2) {
        return ((AutocompletePrediction) obj).equals((AutocompletePrediction) obj2);
    }

    public final /* bridge */ /* synthetic */ boolean areItemsTheSame(Object obj, Object obj2) {
        return zza((AutocompletePrediction) obj, (AutocompletePrediction) obj2);
    }

    public /* synthetic */ zzq(zzp zzp) {
    }
}
