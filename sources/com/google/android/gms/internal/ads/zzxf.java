package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzxf {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            int i11 = zzfn.zza;
            int parseInt = Integer.parseInt(group, 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.zza = parseInt;
            this.zzb = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }

    public final boolean zzb(zzdd zzdd) {
        for (int i11 = 0; i11 < zzdd.zza(); i11++) {
            zzdc zzb2 = zzdd.zzb(i11);
            if (zzb2 instanceof zzzn) {
                zzzn zzzn = (zzzn) zzb2;
                if ("iTunSMPB".equals(zzzn.zzb) && zzc(zzzn.zzc)) {
                    return true;
                }
            } else if (zzb2 instanceof zzzw) {
                zzzw zzzw = (zzzw) zzb2;
                if ("com.apple.iTunes".equals(zzzw.zza) && "iTunSMPB".equals(zzzw.zzb) && zzc(zzzw.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
