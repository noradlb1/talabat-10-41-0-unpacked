package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzcjd {
    public static Context zza(Context context) throws zzcjc {
        return zzc(context).getModuleContext();
    }

    public static <T> T zzb(Context context, String str, zzcjb<IBinder, T> zzcjb) throws zzcjc {
        try {
            return zzcjb.zza(zzc(context).instantiate(str));
        } catch (Exception e11) {
            throw new zzcjc(e11);
        }
    }

    private static DynamiteModule zzc(Context context) throws zzcjc {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e11) {
            throw new zzcjc(e11);
        }
    }
}
