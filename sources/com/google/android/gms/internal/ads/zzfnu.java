package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apptimize.c;
import com.google.android.exoplayer2.PlaybackException;
import java.util.HashMap;
import java.util.Map;

final class zzfnu implements zzfmk {
    private final Object zza;
    private final zzfnv zzb;
    private final zzfog zzc;
    private final zzfmh zzd;

    public zzfnu(@NonNull Object obj, @NonNull zzfnv zzfnv, @NonNull zzfog zzfog, @NonNull zzfmh zzfmh) {
        this.zza = obj;
        this.zzb = zzfnv;
        this.zzc = zzfog;
        this.zzd = zzfmh;
    }

    @Nullable
    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzakb zza2 = zzakc.zza();
        zza2.zzc(5);
        zza2.zza(zzgjf.zzv(bArr));
        return Base64.encodeToString(((zzakc) zza2.zzah()).zzar(), 11);
    }

    @Nullable
    private final synchronized byte[] zzj(Map<String, String> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e11) {
            this.zzd.zzc(PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED, System.currentTimeMillis() - currentTimeMillis, e11);
            return null;
        }
        return (byte[]) this.zza.getClass().getDeclaredMethod("xss", new Class[]{Map.class, Map.class}).invoke(this.zza, new Object[]{null, map2});
    }

    @Nullable
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map<String, Object> zza2;
        zza2 = this.zzc.zza();
        zza2.put("f", c.f41585a);
        zza2.put("ctx", context);
        zza2.put("cs", str2);
        zza2.put("aid", (Object) null);
        zza2.put("view", view);
        zza2.put("act", activity);
        return zzi(zzj((Map<String, String>) null, zza2));
    }

    @Nullable
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map<String, Object> zzc2;
        zzc2 = this.zzc.zzc();
        zzc2.put("f", "v");
        zzc2.put("ctx", context);
        zzc2.put("aid", (Object) null);
        zzc2.put("view", view);
        zzc2.put("act", (Object) null);
        return zzi(zzj((Map<String, String>) null, zzc2));
    }

    @Nullable
    public final synchronized String zzc(Context context, String str) {
        Map<String, Object> zzb2;
        zzb2 = this.zzc.zzb();
        zzb2.put("f", "q");
        zzb2.put("ctx", context);
        zzb2.put("aid", (Object) null);
        return zzi(zzj((Map<String, String>) null, zzb2));
    }

    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzfoe {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put("aid", (Object) null);
            hashMap.put("evt", motionEvent);
            this.zza.getClass().getDeclaredMethod("he", new Class[]{Map.class}).invoke(this.zza, new Object[]{hashMap});
            this.zzd.zzd(3003, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e11) {
            throw new zzfoe((int) PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND, (Throwable) e11);
        }
    }

    public final synchronized int zze() throws zzfoe {
        try {
        } catch (Exception e11) {
            throw new zzfoe((int) PlaybackException.ERROR_CODE_IO_NO_PERMISSION, (Throwable) e11);
        }
        return ((Integer) this.zza.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zza, new Object[0])).intValue();
    }

    public final zzfnv zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() throws zzfoe {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zza.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zza, new Object[0]);
            this.zzd.zzd(3001, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e11) {
            throw new zzfoe(2003, (Throwable) e11);
        }
    }

    public final synchronized boolean zzh() throws zzfoe {
        try {
        } catch (Exception e11) {
            throw new zzfoe(2001, (Throwable) e11);
        }
        return ((Boolean) this.zza.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zza, new Object[0])).booleanValue();
    }
}
