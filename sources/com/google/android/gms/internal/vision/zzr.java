package com.google.android.gms.internal.vision;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.vision.L;

public final class zzr {
    public static boolean zza(Context context, String str) {
        return DynamiteModule.getLocalVersion(context, str) > DynamiteModule.getRemoteVersion(context, "com.google.android.gms.vision.dynamite");
    }

    @Nullable
    public static DynamiteModule zza(Context context, String str, boolean z11) {
        DynamiteModule.VersionPolicy versionPolicy;
        String format = String.format("%s.%s", new Object[]{"com.google.android.gms.vision", str});
        if (!z11) {
            format = "com.google.android.gms.vision.dynamite";
        }
        try {
            L.d("Loading module %s", format);
            if (z11) {
                versionPolicy = DynamiteModule.PREFER_REMOTE;
            } else {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            }
            return DynamiteModule.load(context, versionPolicy, format);
        } catch (DynamiteModule.LoadingException e11) {
            L.e(e11, "Error loading module %s optional module %b", format, Boolean.valueOf(z11));
            return null;
        }
    }
}
