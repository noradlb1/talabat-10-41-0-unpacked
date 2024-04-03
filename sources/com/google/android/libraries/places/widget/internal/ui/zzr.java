package com.google.android.libraries.places.widget.internal.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListAdapter;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.internal.zzdh;
import java.util.List;

public final class zzr extends ListAdapter<AutocompletePrediction, zzs> {
    private int zza;
    private boolean zzb = true;
    private final zze zzc;

    public zzr(zze zze, byte[] bArr) {
        super(new zzq((zzp) null));
        this.zzc = zze;
    }

    public final void submitList(@Nullable List<AutocompletePrediction> list) {
        boolean z11;
        try {
            int i11 = 0;
            if (this.zza != 0 || list == null || list.isEmpty()) {
                z11 = false;
            } else {
                z11 = true;
            }
            this.zzb = z11;
            if (list != null) {
                i11 = list.size();
            }
            this.zza = i11;
            super.submitList(list);
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    /* renamed from: zza */
    public final zzs onCreateViewHolder(ViewGroup viewGroup, int i11) {
        try {
            return new zzs(this.zzc, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.places_autocomplete_prediction, viewGroup, false), (byte[]) null);
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    /* renamed from: zzb */
    public final void onBindViewHolder(zzs zzs, int i11) {
        try {
            zzs.zza((AutocompletePrediction) getItem(i11), this.zzb);
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }
}
