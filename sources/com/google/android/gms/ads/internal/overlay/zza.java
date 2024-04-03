package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzciz;

public final class zza {
    public static final boolean zza(Context context, Intent intent, zzw zzw, @Nullable zzu zzu, boolean z11) {
        String str;
        if (z11) {
            return zzc(context, intent.getData(), zzw, zzu);
        }
        try {
            String valueOf = String.valueOf(intent.toURI());
            if (valueOf.length() != 0) {
                str = "Launching an intent: ".concat(valueOf);
            } else {
                str = new String("Launching an intent: ");
            }
            zze.zza(str);
            zzt.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzQ(context, intent);
            if (zzw != null) {
                zzw.zzg();
            }
            if (zzu != null) {
                zzu.zza(true);
            }
            return true;
        } catch (ActivityNotFoundException e11) {
            zzciz.zzj(e11.getMessage());
            if (zzu != null) {
                zzu.zza(false);
            }
            return false;
        }
    }

    public static final boolean zzb(Context context, @Nullable zzc zzc, zzw zzw, @Nullable zzu zzu) {
        String str;
        int i11 = 0;
        if (zzc == null) {
            zzciz.zzj("No intent data for launcher overlay.");
            return false;
        }
        zzblj.zzc(context);
        Intent intent = zzc.zzh;
        if (intent != null) {
            return zza(context, intent, zzw, zzu, zzc.zzj);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzc.zzb)) {
            zzciz.zzj("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzc.zzc)) {
            intent2.setDataAndType(Uri.parse(zzc.zzb), zzc.zzc);
        } else {
            intent2.setData(Uri.parse(zzc.zzb));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzc.zzd)) {
            intent2.setPackage(zzc.zzd);
        }
        if (!TextUtils.isEmpty(zzc.zze)) {
            String[] split = zzc.zze.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzc.zze);
                if (valueOf.length() != 0) {
                    str = "Could not parse component name from open GMSG: ".concat(valueOf);
                } else {
                    str = new String("Could not parse component name from open GMSG: ");
                }
                zzciz.zzj(str);
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str2 = zzc.zzf;
        if (!TextUtils.isEmpty(str2)) {
            try {
                i11 = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                zzciz.zzj("Could not parse intent flags.");
            }
            intent2.addFlags(i11);
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdb)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzda)).booleanValue()) {
                zzt.zzp();
                com.google.android.gms.ads.internal.util.zzt.zzu(context, intent2);
            }
        }
        return zza(context, intent2, zzw, zzu, zzc.zzj);
    }

    private static final boolean zzc(Context context, Uri uri, zzw zzw, zzu zzu) {
        int i11;
        try {
            i11 = zzt.zzp().zzs(context, uri);
            if (zzw != null) {
                zzw.zzg();
            }
        } catch (ActivityNotFoundException e11) {
            zzciz.zzj(e11.getMessage());
            i11 = 6;
        }
        if (zzu != null) {
            zzu.zzb(i11);
        }
        if (i11 != 5) {
            return false;
        }
        return true;
    }
}
