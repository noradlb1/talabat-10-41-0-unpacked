package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class zzvz {
    public final List<byte[]> zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final float zze;
    @Nullable
    public final String zzf;

    private zzvz(List<byte[]> list, int i11, int i12, int i13, float f11, @Nullable String str) {
        this.zza = list;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = f11;
        this.zzf = str;
    }

    public static zzvz zza(zzfd zzfd) throws zzbj {
        String str;
        float f11;
        int i11;
        int i12;
        try {
            zzfd.zzG(4);
            int zzk = (zzfd.zzk() & 3) + 1;
            if (zzk != 3) {
                ArrayList arrayList = new ArrayList();
                int zzk2 = zzfd.zzk() & 31;
                for (int i13 = 0; i13 < zzk2; i13++) {
                    arrayList.add(zzb(zzfd));
                }
                int zzk3 = zzfd.zzk();
                for (int i14 = 0; i14 < zzk3; i14++) {
                    arrayList.add(zzb(zzfd));
                }
                if (zzk2 > 0) {
                    zzet zzd2 = zzeu.zzd((byte[]) arrayList.get(0), zzk + 1, ((byte[]) arrayList.get(0)).length);
                    int i15 = zzd2.zze;
                    int i16 = zzd2.zzf;
                    float f12 = zzd2.zzg;
                    str = zzea.zza(zzd2.zza, zzd2.zzb, zzd2.zzc);
                    i12 = i15;
                    i11 = i16;
                    f11 = f12;
                } else {
                    i12 = -1;
                    i11 = -1;
                    f11 = 1.0f;
                    str = null;
                }
                return new zzvz(arrayList, zzk, i12, i11, f11, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw zzbj.zza("Error parsing AVC config", e11);
        }
    }

    private static byte[] zzb(zzfd zzfd) {
        int zzo = zzfd.zzo();
        int zzc2 = zzfd.zzc();
        zzfd.zzG(zzo);
        return zzea.zzc(zzfd.zzH(), zzc2, zzo);
    }
}
