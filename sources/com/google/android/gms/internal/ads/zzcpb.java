package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcpb {
    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.internal.ads.zzcop, java.lang.Object] */
    public static final zzcop zza(Context context, zzcqe zzcqe, String str, boolean z11, boolean z12, @Nullable zzalt zzalt, @Nullable zzbmi zzbmi, zzcjf zzcjf, @Nullable zzbly zzbly, @Nullable zzl zzl, @Nullable zza zza, zzbay zzbay, @Nullable zzfdn zzfdn, @Nullable zzfdq zzfdq) throws zzcpa {
        StrictMode.ThreadPolicy threadPolicy;
        zzblj.zzc(context);
        try {
            zzcoy zzcoy = new zzcoy(context, zzcqe, str, z11, z12, zzalt, zzbmi, zzcjf, (zzbly) null, zzl, zza, zzbay, zzfdn, zzfdq);
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            ? zza2 = zzcoy.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return zza2;
        } catch (Throwable th2) {
            throw new zzcpa("Webview initialization failed.", th2);
        }
    }
}
