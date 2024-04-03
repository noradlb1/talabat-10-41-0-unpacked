package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzek extends zzbq {
    private static final String ID = zza.REGEX_GROUP.toString();
    private static final String zzaiz = zzb.ARG0.toString();
    private static final String zzaja = zzb.ARG1.toString();
    private static final String zzajb = zzb.IGNORE_CASE.toString();
    private static final String zzajc = zzb.GROUP.toString();

    public zzek() {
        super(ID, zzaiz, zzaja);
    }

    public final zzl zzb(Map<String, zzl> map) {
        int i11;
        int i12;
        String str;
        zzl zzl = map.get(zzaiz);
        zzl zzl2 = map.get(zzaja);
        if (zzl == null || zzl == zzgj.zzkc() || zzl2 == null || zzl2 == zzgj.zzkc()) {
            return zzgj.zzkc();
        }
        if (zzgj.zzg(map.get(zzajb)).booleanValue()) {
            i11 = 66;
        } else {
            i11 = 64;
        }
        zzl zzl3 = map.get(zzajc);
        if (zzl3 != null) {
            Long zze = zzgj.zze(zzl3);
            if (zze == zzgj.zzjx()) {
                return zzgj.zzkc();
            }
            i12 = zze.intValue();
            if (i12 < 0) {
                return zzgj.zzkc();
            }
        } else {
            i12 = 1;
        }
        try {
            Matcher matcher = Pattern.compile(zzgj.zzc(zzl2), i11).matcher(zzgj.zzc(zzl));
            if (!matcher.find() || matcher.groupCount() < i12) {
                str = null;
            } else {
                str = matcher.group(i12);
            }
            if (str == null) {
                return zzgj.zzkc();
            }
            return zzgj.zzi(str);
        } catch (PatternSyntaxException unused) {
            return zzgj.zzkc();
        }
    }

    public final boolean zzgw() {
        return true;
    }
}
