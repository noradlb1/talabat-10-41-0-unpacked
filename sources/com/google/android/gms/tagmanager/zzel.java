package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@VisibleForTesting
final class zzel extends zzfz {
    private static final String ID = zza.REGEX.toString();
    private static final String zzajb = zzb.IGNORE_CASE.toString();

    public zzel() {
        super(ID);
    }

    public final boolean zza(String str, String str2, Map<String, zzl> map) {
        int i11;
        if (zzgj.zzg(map.get(zzajb)).booleanValue()) {
            i11 = 66;
        } else {
            i11 = 64;
        }
        try {
            return Pattern.compile(str2, i11).matcher(str).find();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }
}
