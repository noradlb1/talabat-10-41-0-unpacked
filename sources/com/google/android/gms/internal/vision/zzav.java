package com.google.android.gms.internal.vision;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

final class zzav implements zzau {
    @GuardedBy("GservicesLoader.class")
    private static zzav zzfr;
    @Nullable
    private final Context zze;
    @Nullable
    private final ContentObserver zzfl;

    private zzav(Context context) {
        this.zze = context;
        zzax zzax = new zzax(this, (Handler) null);
        this.zzfl = zzax;
        context.getContentResolver().registerContentObserver(zzal.CONTENT_URI, true, zzax);
    }

    public static synchronized void zzaa() {
        Context context;
        synchronized (zzav.class) {
            zzav zzav = zzfr;
            if (!(zzav == null || (context = zzav.zze) == null || zzav.zzfl == null)) {
                context.getContentResolver().unregisterContentObserver(zzfr.zzfl);
            }
            zzfr = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zzb(String str) {
        String str2;
        if (this.zze == null) {
            return null;
        }
        try {
            return (String) zzat.zza(new zzay(this, str));
        } catch (IllegalStateException | SecurityException e11) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Unable to read GServices for: ".concat(valueOf);
            } else {
                str2 = new String("Unable to read GServices for: ");
            }
            Log.e("GservicesLoader", str2, e11);
            return null;
        }
    }

    public static zzav zze(Context context) {
        zzav zzav;
        boolean z11;
        zzav zzav2;
        synchronized (zzav.class) {
            if (zzfr == null) {
                if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    zzav2 = new zzav(context);
                } else {
                    zzav2 = new zzav();
                }
                zzfr = zzav2;
            }
            zzav = zzfr;
        }
        return zzav;
    }

    public final /* synthetic */ String zzd(String str) {
        return zzal.zza(this.zze.getContentResolver(), str, (String) null);
    }

    private zzav() {
        this.zze = null;
        this.zzfl = null;
    }
}
