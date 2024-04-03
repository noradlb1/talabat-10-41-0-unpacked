package com.google.android.gms.internal.vision;

import android.content.Context;
import android.util.Log;

public final class zzl {
    public static boolean zza(Context context, String str, String str2) {
        String zzk = zzcv.zzk(str2);
        if ("face".equals(str) || "ica".equals(str) || "ocr".equals(str) || "barcode".equals(str)) {
            int lastIndexOf = zzk.lastIndexOf(".so");
            if (lastIndexOf == zzk.length() - 3) {
                zzk = zzk.substring(0, lastIndexOf);
            }
            if (zzk.indexOf("lib") == 0) {
                zzk = zzk.substring(3);
            }
            boolean zza = zzm.zza(str, zzk);
            if (!zza) {
                String.format("%s engine not loaded with %s.", new Object[]{str, zzk});
            }
            return zza;
        }
        Log.e("NativeLibraryLoader", String.format("Unrecognized engine: %s", new Object[]{str}));
        return false;
    }
}
