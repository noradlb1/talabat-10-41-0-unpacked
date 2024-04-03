package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.talabat.feature.rewards.presentation.mission.details.MissionDetailsDialogFragment;

final class zzaz implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ boolean zzd;

    public zzaz(zzba zzba, Context context, String str, boolean z11, boolean z12) {
        this.zza = context;
        this.zzb = str;
        this.zzc = z11;
        this.zzd = z12;
    }

    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.zza);
        builder.setMessage(this.zzb);
        if (this.zzc) {
            builder.setTitle("Error");
        } else {
            builder.setTitle(MissionDetailsDialogFragment.Section.Info.TYPE);
        }
        if (this.zzd) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new zzay(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
