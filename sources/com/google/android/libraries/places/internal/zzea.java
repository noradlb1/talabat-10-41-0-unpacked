package com.google.android.libraries.places.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.Place;

public final class zzea {
    public static Status zza(Intent intent) {
        boolean z11;
        try {
            zzfm.zzc(intent, "Intent must not be null.");
            Status status = (Status) intent.getParcelableExtra("places/status");
            if (status != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzfm.zze(z11, "Intent expected to contain a Status, but doesn't.");
            return status;
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    public static Place zzb(Intent intent) {
        boolean z11;
        try {
            zzfm.zzc(intent, "Intent must not be null.");
            Place place = (Place) intent.getParcelableExtra("places/selected_place");
            if (place != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzfm.zze(z11, "Intent expected to contain a Place, but doesn't.");
            return place;
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }
}
