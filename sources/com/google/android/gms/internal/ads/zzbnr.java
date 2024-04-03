package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public final class zzbnr extends zzbnz {
    static final int zza;
    static final int zzb;
    private static final int zzc;
    private static final int zzd;
    private final String zze;
    private final List<zzbnu> zzf = new ArrayList();
    private final List<zzboi> zzg = new ArrayList();
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;

    static {
        int rgb = Color.rgb(12, Opcodes.FRETURN, 206);
        zzc = rgb;
        int rgb2 = Color.rgb(204, 204, 204);
        zzd = rgb2;
        zza = rgb2;
        zzb = rgb;
    }

    public zzbnr(String str, List<zzbnu> list, Integer num, Integer num2, Integer num3, int i11, int i12, boolean z11) {
        int i13;
        int i14;
        int i15;
        this.zze = str;
        for (int i16 = 0; i16 < list.size(); i16++) {
            zzbnu zzbnu = list.get(i16);
            this.zzf.add(zzbnu);
            this.zzg.add(zzbnu);
        }
        if (num != null) {
            i13 = num.intValue();
        } else {
            i13 = zza;
        }
        this.zzh = i13;
        if (num2 != null) {
            i14 = num2.intValue();
        } else {
            i14 = zzb;
        }
        this.zzi = i14;
        if (num3 != null) {
            i15 = num3.intValue();
        } else {
            i15 = 12;
        }
        this.zzj = i15;
        this.zzk = i11;
        this.zzl = i12;
    }

    public final int zzb() {
        return this.zzk;
    }

    public final int zzc() {
        return this.zzl;
    }

    public final int zzd() {
        return this.zzh;
    }

    public final int zze() {
        return this.zzi;
    }

    public final int zzf() {
        return this.zzj;
    }

    public final String zzg() {
        return this.zze;
    }

    public final List<zzboi> zzh() {
        return this.zzg;
    }

    public final List<zzbnu> zzi() {
        return this.zzf;
    }
}
