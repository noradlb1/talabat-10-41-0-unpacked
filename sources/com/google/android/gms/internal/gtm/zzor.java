package com.google.android.gms.internal.gtm;

import com.braze.models.FeatureFlag;
import com.google.android.gms.internal.gtm.zzc;
import com.google.android.gms.internal.gtm.zzg;
import com.google.android.gms.tagmanager.zzdi;
import com.google.android.gms.tagmanager.zzgj;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class zzor {
    public static zzov zza(zzi zzi) throws zzoz {
        zzl[] zzlArr = new zzl[zzi.zzpj.length];
        for (int i11 = 0; i11 < zzi.zzpj.length; i11++) {
            zza(i11, zzi, zzlArr, (Set<Integer>) new HashSet(0));
        }
        zzow zzmn = zzov.zzmn();
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        while (true) {
            zzc.zzb[] zzbArr = zzi.zzpm;
            if (i12 >= zzbArr.length) {
                break;
            }
            arrayList.add(zza(zzbArr[i12], zzi, zzlArr, i12));
            i12++;
        }
        ArrayList arrayList2 = new ArrayList();
        int i13 = 0;
        while (true) {
            zzc.zzb[] zzbArr2 = zzi.zzpn;
            if (i13 >= zzbArr2.length) {
                break;
            }
            arrayList2.add(zza(zzbArr2[i13], zzi, zzlArr, i13));
            i13++;
        }
        ArrayList arrayList3 = new ArrayList();
        int i14 = 0;
        while (true) {
            zzc.zzb[] zzbArr3 = zzi.zzpl;
            if (i14 >= zzbArr3.length) {
                break;
            }
            zzot zza = zza(zzbArr3[i14], zzi, zzlArr, i14);
            zzmn.zzc(zza);
            arrayList3.add(zza);
            i14++;
        }
        for (zzc.zze zze : zzi.zzpo) {
            zzoy zzoy = new zzoy();
            for (Integer intValue : zze.zzn()) {
                zzoy.zzd((zzot) arrayList2.get(intValue.intValue()));
            }
            for (Integer intValue2 : zze.zzo()) {
                zzoy.zze((zzot) arrayList2.get(intValue2.intValue()));
            }
            for (Integer intValue3 : zze.zzp()) {
                zzoy.zzf((zzot) arrayList.get(intValue3.intValue()));
            }
            for (Integer intValue4 : zze.zzr()) {
                zzoy.zzct(zzi.zzpj[intValue4.intValue()].string);
            }
            for (Integer intValue5 : zze.zzq()) {
                zzoy.zzg((zzot) arrayList.get(intValue5.intValue()));
            }
            for (Integer intValue6 : zze.zzs()) {
                zzoy.zzcu(zzi.zzpj[intValue6.intValue()].string);
            }
            for (Integer intValue7 : zze.zzt()) {
                zzoy.zzh((zzot) arrayList3.get(intValue7.intValue()));
            }
            for (Integer intValue8 : zze.zzv()) {
                zzoy.zzcv(zzi.zzpj[intValue8.intValue()].string);
            }
            for (Integer intValue9 : zze.zzu()) {
                zzoy.zzi((zzot) arrayList3.get(intValue9.intValue()));
            }
            for (Integer intValue10 : zze.zzw()) {
                zzoy.zzcw(zzi.zzpj[intValue10.intValue()].string);
            }
            zzmn.zzb(zzoy.zzms());
        }
        zzmn.zzcs(zzi.version);
        zzmn.zzaf(zzi.zzpw);
        return zzmn.zzmp();
    }

    private static void zzcf(String str) throws zzoz {
        zzdi.zzav(str);
        throw new zzoz(str);
    }

    public static zzl zzk(zzl zzl) {
        zzl zzl2 = new zzl();
        zzl2.type = zzl.type;
        zzl2.zzqv = (int[]) zzl.zzqv.clone();
        boolean z11 = zzl.zzqw;
        if (z11) {
            zzl2.zzqw = z11;
        }
        return zzl2;
    }

    private static zzg.zza zzl(zzl zzl) throws zzoz {
        zzur zzur = zzg.zza.zzpx;
        if (((zzg.zza) zzl.zza(zzur)) == null) {
            String valueOf = String.valueOf(zzl);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 54);
            sb2.append("Expected a ServingValue and didn't get one. Value is: ");
            sb2.append(valueOf);
            zzcf(sb2.toString());
        }
        return (zzg.zza) zzl.zza(zzur);
    }

    private static zzl zza(int i11, zzi zzi, zzl[] zzlArr, Set<Integer> set) throws zzoz {
        zzl zzl;
        if (set.contains(Integer.valueOf(i11))) {
            String valueOf = String.valueOf(set);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 90);
            sb2.append("Value cycle detected.  Current value reference: ");
            sb2.append(i11);
            sb2.append(".  Previous value references: ");
            sb2.append(valueOf);
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            zzcf(sb2.toString());
        }
        zzl zzl2 = (zzl) zza(zzi.zzpj, i11, "values");
        zzl zzl3 = zzlArr[i11];
        if (zzl3 != null) {
            return zzl3;
        }
        set.add(Integer.valueOf(i11));
        int i12 = 0;
        switch (zzl2.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                zzl = zzl2;
                break;
            case 2:
                zzg.zza zzl4 = zzl(zzl2);
                zzl zzk = zzk(zzl2);
                int[] iArr = zzl4.zzpz;
                zzk.zzqn = new zzl[iArr.length];
                int length = iArr.length;
                int i13 = 0;
                while (i12 < length) {
                    int i14 = i13 + 1;
                    zzk.zzqn[i13] = zza(iArr[i12], zzi, zzlArr, set);
                    i12++;
                    i13 = i14;
                }
                zzl = zzk;
                break;
            case 3:
                zzl = zzk(zzl2);
                zzg.zza zzl5 = zzl(zzl2);
                int[] iArr2 = zzl5.zzqa;
                int length2 = iArr2.length;
                int[] iArr3 = zzl5.zzqb;
                if (length2 != iArr3.length) {
                    int length3 = iArr2.length;
                    int length4 = iArr3.length;
                    StringBuilder sb3 = new StringBuilder(58);
                    sb3.append("Uneven map keys (");
                    sb3.append(length3);
                    sb3.append(") and map values (");
                    sb3.append(length4);
                    sb3.append(")");
                    zzcf(sb3.toString());
                }
                int[] iArr4 = zzl5.zzqa;
                zzl.zzqo = new zzl[iArr4.length];
                zzl.zzqp = new zzl[iArr4.length];
                int length5 = iArr4.length;
                int i15 = 0;
                int i16 = 0;
                while (i15 < length5) {
                    zzl.zzqo[i16] = zza(iArr4[i15], zzi, zzlArr, set);
                    i15++;
                    i16++;
                }
                int[] iArr5 = zzl5.zzqb;
                int length6 = iArr5.length;
                int i17 = 0;
                while (i12 < length6) {
                    zzl.zzqp[i17] = zza(iArr5[i12], zzi, zzlArr, set);
                    i12++;
                    i17++;
                }
                break;
            case 4:
                zzl = zzk(zzl2);
                zzl.zzqq = zzgj.zzc(zza(zzl(zzl2).zzqe, zzi, zzlArr, set));
                break;
            case 7:
                zzl = zzk(zzl2);
                int[] iArr6 = zzl(zzl2).zzqd;
                zzl.zzqu = new zzl[iArr6.length];
                int length7 = iArr6.length;
                int i18 = 0;
                while (i12 < length7) {
                    zzl.zzqu[i18] = zza(iArr6[i12], zzi, zzlArr, set);
                    i12++;
                    i18++;
                }
                break;
            default:
                zzl = null;
                break;
        }
        if (zzl == null) {
            String valueOf2 = String.valueOf(zzl2);
            StringBuilder sb4 = new StringBuilder(valueOf2.length() + 15);
            sb4.append("Invalid value: ");
            sb4.append(valueOf2);
            zzcf(sb4.toString());
        }
        zzlArr[i11] = zzl;
        set.remove(Integer.valueOf(i11));
        return zzl;
    }

    private static <T> T zza(T[] tArr, int i11, String str) throws zzoz {
        if (i11 < 0 || i11 >= tArr.length) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 45);
            sb2.append("Index out of bounds detected: ");
            sb2.append(i11);
            sb2.append(" in ");
            sb2.append(str);
            zzcf(sb2.toString());
        }
        return tArr[i11];
    }

    private static zzot zza(zzc.zzb zzb, zzi zzi, zzl[] zzlArr, int i11) throws zzoz {
        zzou zzml = zzot.zzml();
        for (Integer intValue : zzb.zze()) {
            zzc.zzd zzd = (zzc.zzd) zza(zzi.zzpk, intValue.intValue(), FeatureFlag.PROPERTIES);
            String str = (String) zza(zzi.zzpi, zzd.zzl(), UserMetadata.KEYDATA_FILENAME);
            zzl zzl = (zzl) zza(zzlArr, zzd.getValue(), "values");
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzml.zzm(zzl);
            } else {
                zzml.zzb(str, zzl);
            }
        }
        return zzml.zzmm();
    }

    public static void zza(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
