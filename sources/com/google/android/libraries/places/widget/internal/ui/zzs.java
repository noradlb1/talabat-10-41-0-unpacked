package com.google.android.libraries.places.widget.internal.ui;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.internal.zzdh;

public final class zzs extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView zza;
    private final TextView zzb;
    private AutocompletePrediction zzc;
    private boolean zzd;
    private final zze zze;

    public zzs(zze zze2, View view, byte[] bArr) {
        super(view);
        this.zze = zze2;
        this.zza = (TextView) view.findViewById(R.id.places_autocomplete_prediction_primary_text);
        this.zzb = (TextView) view.findViewById(R.id.places_autocomplete_prediction_secondary_text);
        this.itemView.setOnClickListener(this);
    }

    public final void onClick(View view) {
        try {
            zze zze2 = this.zze;
            zze2.zza.zze(this.zzc, getAdapterPosition());
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    public final void zza(AutocompletePrediction autocompletePrediction, boolean z11) {
        this.zzc = autocompletePrediction;
        this.zzd = z11;
        this.zza.setText(autocompletePrediction.getPrimaryText(new ForegroundColorSpan(ContextCompat.getColor(this.itemView.getContext(), R.color.places_autocomplete_prediction_primary_text_highlight))));
        SpannableString secondaryText = autocompletePrediction.getSecondaryText((CharacterStyle) null);
        this.zzb.setText(secondaryText);
        if (secondaryText.length() == 0) {
            this.zzb.setVisibility(8);
            this.zza.setGravity(16);
            return;
        }
        this.zzb.setVisibility(0);
        this.zza.setGravity(80);
    }

    public final boolean zzb() {
        return this.zzd;
    }
}
