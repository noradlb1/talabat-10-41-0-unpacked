package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzt;
import com.google.common.net.HttpHeaders;
import java.util.Map;

public final class zzcai extends zzcaq {
    private final Map<String, String> zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    private final String zzc = zze("description");
    private final long zzd = zzd("start_ticks");
    private final long zze = zzd("end_ticks");
    private final String zzf = zze("summary");
    private final String zzg = zze("location");

    public zzcai(zzcop zzcop, Map<String, String> map) {
        super(zzcop, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcop.zzk();
    }

    private final long zzd(String str) {
        String str2 = this.zza.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final String zze(String str) {
        return TextUtils.isEmpty(this.zza.get(str)) ? "" : this.zza.get(str);
    }

    @TargetApi(14)
    public final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra("description", this.zzf);
        long j11 = this.zzd;
        if (j11 > -1) {
            data.putExtra("beginTime", j11);
        }
        long j12 = this.zze;
        if (j12 > -1) {
            data.putExtra("endTime", j12);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void zzc() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.zzb == null) {
            zzg("Activity context is not available.");
            return;
        }
        zzt.zzp();
        if (!new zzbkt(this.zzb).zzb()) {
            zzg("This feature is not available on the device.");
            return;
        }
        zzt.zzp();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.zzb);
        Resources zzd2 = zzt.zzo().zzd();
        if (zzd2 != null) {
            str = zzd2.getString(R.string.f35092s5);
        } else {
            str = "Create calendar event";
        }
        builder.setTitle(str);
        if (zzd2 != null) {
            str2 = zzd2.getString(R.string.f35093s6);
        } else {
            str2 = "Allow Ad to create a calendar event?";
        }
        builder.setMessage(str2);
        if (zzd2 != null) {
            str3 = zzd2.getString(R.string.f35090s3);
        } else {
            str3 = HttpHeaders.ACCEPT;
        }
        builder.setPositiveButton(str3, new zzcag(this));
        if (zzd2 != null) {
            str4 = zzd2.getString(R.string.f35091s4);
        } else {
            str4 = "Decline";
        }
        builder.setNegativeButton(str4, new zzcah(this));
        builder.create().show();
    }
}
