package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public final class zzwm {
    public final String zza;

    private zzwm(int i11, int i12, String str) {
        this.zza = str;
    }

    @Nullable
    public static zzwm zza(zzfd zzfd) {
        String str;
        String str2;
        zzfd.zzG(2);
        int zzk = zzfd.zzk();
        int i11 = zzk >> 1;
        int zzk2 = (zzfd.zzk() >> 3) | ((zzk & 1) << 5);
        if (i11 == 4 || i11 == 5 || i11 == 7) {
            str = "dvhe";
        } else if (i11 == 8) {
            str = "hev1";
        } else if (i11 != 9) {
            return null;
        } else {
            str = "avc3";
        }
        if (zzk2 < 10) {
            str2 = ".0";
        } else {
            str2 = RealDiscoveryConfigurationRepository.VERSION_DELIMETER;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 24 + str2.length());
        sb2.append(str);
        sb2.append(".0");
        sb2.append(i11);
        sb2.append(str2);
        sb2.append(zzk2);
        return new zzwm(i11, zzk2, sb2.toString());
    }
}
