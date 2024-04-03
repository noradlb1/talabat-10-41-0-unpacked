package com.google.android.gms.internal.gtm;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

public final class zzmi extends zzhb {
    private final zzei zzary;

    public zzmi(zzei zzei) {
        this.zzary = zzei;
    }

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzog zzog;
        boolean z12;
        zzog zzog2;
        String str;
        boolean z13 = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        zzoa<?> zzoa = zzoaArr[0];
        Preconditions.checkArgument(!(zzoa instanceof zzog));
        if (zzoaArr.length > 1) {
            zzog = zzoaArr[1];
        } else {
            zzog = zzog.zzaum;
        }
        zzog zzog3 = zzog.zzaum;
        if (zzog == zzog3 || (zzog instanceof zzoh)) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        if (zzoaArr.length > 2) {
            zzog2 = zzoaArr[2];
        } else {
            zzog2 = zzog3;
        }
        if (zzog2 != zzog3 && (zzog2 instanceof zzog)) {
            z13 = false;
        }
        Preconditions.checkArgument(z13);
        Uri.Builder buildUpon = Uri.parse(zzha.zzd(zzoa)).buildUpon();
        if (zzog != zzog3) {
            for (zzoa zzoa2 : (List) ((zzoh) zzog).value()) {
                Preconditions.checkArgument(zzoa2 instanceof zzok);
                for (Map.Entry entry : ((Map) ((zzok) zzoa2).value()).entrySet()) {
                    buildUpon.appendQueryParameter(((String) entry.getKey()).toString(), zzha.zzd(zzoo.zza(zzfl, (zzoa) entry.getValue())));
                }
            }
        }
        String uri = buildUpon.build().toString();
        zzog zzog4 = zzog.zzaum;
        if (zzog2 == zzog4) {
            this.zzary.zzay(uri);
            String valueOf = String.valueOf(uri);
            if (valueOf.length() != 0) {
                str = "SendPixel: url = ".concat(valueOf);
            } else {
                str = new String("SendPixel: url = ");
            }
            zzev.zzab(str);
        } else {
            String zzd = zzha.zzd(zzog2);
            this.zzary.zzf(uri, zzd);
            StringBuilder sb2 = new StringBuilder(String.valueOf(uri).length() + 30 + String.valueOf(zzd).length());
            sb2.append("SendPixel: url = ");
            sb2.append(uri);
            sb2.append(", uniqueId = ");
            sb2.append(zzd);
            zzev.zzab(sb2.toString());
        }
        return zzog4;
    }
}
