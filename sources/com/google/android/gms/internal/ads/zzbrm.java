package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;

final class zzbrm implements zzbrt<Object> {
    public final void zza(Object obj, Map<String, String> map) {
        String str;
        String valueOf = String.valueOf(map.get(TypedValues.Custom.S_STRING));
        if (valueOf.length() != 0) {
            str = "Received log message: ".concat(valueOf);
        } else {
            str = new String("Received log message: ");
        }
        zzciz.zzi(str);
    }
}
