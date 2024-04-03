package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzlk extends zzhb {
    private static void zzb(StringBuilder sb2, String str, int i11, Set<Character> set) {
        sb2.append(zzb(str, i11, set));
    }

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        String str;
        zzog zzog;
        zzog zzog2;
        boolean z11 = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0);
        zzoh zzoh = zzoaArr[0];
        zzog zzog3 = zzoaArr.length > 1 ? zzoaArr[1] : zzog.zzaum;
        int i11 = 2;
        if (zzoaArr.length <= 2 || (zzog2 = zzoaArr[2]) == zzog.zzaum) {
            str = "";
        } else {
            str = zzha.zzd(zzog2);
        }
        String str2 = "=";
        if (zzoaArr.length > 3 && (zzog = zzoaArr[3]) != zzog.zzaum) {
            str2 = zzha.zzd(zzog);
        }
        HashSet hashSet = null;
        if (zzog3 != zzog.zzaum) {
            Preconditions.checkArgument(zzog3 instanceof zzom);
            if ("url".equals(zzog3.value())) {
                i11 = 1;
            } else if (!"backslash".equals(zzog3.value())) {
                return new zzom("");
            } else {
                hashSet = new HashSet();
                zza((Set<Character>) hashSet, str);
                zza((Set<Character>) hashSet, str2);
                hashSet.remove('\\');
            }
        } else {
            i11 = 0;
        }
        StringBuilder sb2 = new StringBuilder();
        if (zzoh instanceof zzoh) {
            for (zzoa zzoa : (List) zzoh.value()) {
                if (!z11) {
                    sb2.append(str);
                }
                zzb(sb2, zzha.zzd(zzoa), i11, hashSet);
                z11 = false;
            }
        } else if (zzoh instanceof zzok) {
            Map map = (Map) ((zzok) zzoh).value();
            for (String str3 : map.keySet()) {
                if (!z11) {
                    sb2.append(str);
                }
                String zzd = zzha.zzd((zzoa) map.get(str3));
                zzb(sb2, str3, i11, hashSet);
                sb2.append(str2);
                zzb(sb2, zzd, i11, hashSet);
                z11 = false;
            }
        } else {
            zzb(sb2, zzha.zzd(zzoh), i11, hashSet);
        }
        return new zzom(sb2.toString());
    }

    private static String zzb(String str, int i11, Set<Character> set) {
        if (i11 == 1) {
            try {
                return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        } else if (i11 != 2) {
            return str;
        } else {
            String replace = str.replace("\\", "\\\\");
            for (Character ch2 : set) {
                String ch3 = ch2.toString();
                String valueOf = String.valueOf(ch3);
                replace = replace.replace(ch3, valueOf.length() != 0 ? "\\".concat(valueOf) : new String("\\"));
            }
            return replace;
        }
    }

    private static void zza(Set<Character> set, String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            set.add(Character.valueOf(str.charAt(i11)));
        }
    }
}
