package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Map;

final class zzgs extends zzgr {
    public final int zza(Map.Entry entry) {
        return ((zzhc) entry.getKey()).zza;
    }

    public final zzgv zzb(Object obj) {
        return ((zzhb) obj).zzb;
    }

    public final zzgv zzc(Object obj) {
        return ((zzhb) obj).zzi();
    }

    public final Object zzd(zzgq zzgq, zzip zzip, int i11) {
        return zzgq.zza(zzip, i11);
    }

    public final Object zze(Object obj, zzjb zzjb, Object obj2, zzgq zzgq, zzgv zzgv, Object obj3, zzjw zzjw) throws IOException {
        Object zze;
        zzhd zzhd = (zzhd) obj2;
        zzkm zzkm = zzhd.zzb.zzb;
        Object obj4 = null;
        if (zzkm != zzkm.ENUM) {
            switch (zzkm.ordinal()) {
                case 0:
                    obj4 = Double.valueOf(zzjb.zza());
                    break;
                case 1:
                    obj4 = Float.valueOf(zzjb.zzb());
                    break;
                case 2:
                    obj4 = Long.valueOf(zzjb.zzl());
                    break;
                case 3:
                    obj4 = Long.valueOf(zzjb.zzo());
                    break;
                case 4:
                    obj4 = Integer.valueOf(zzjb.zzg());
                    break;
                case 5:
                    obj4 = Long.valueOf(zzjb.zzk());
                    break;
                case 6:
                    obj4 = Integer.valueOf(zzjb.zzf());
                    break;
                case 7:
                    obj4 = Boolean.valueOf(zzjb.zzN());
                    break;
                case 8:
                    obj4 = zzjb.zzr();
                    break;
                case 9:
                    Object zze2 = zzgv.zze(zzhd.zzb);
                    if (zze2 instanceof zzhf) {
                        zzjc zzb = zziy.zza().zzb(zze2.getClass());
                        if (!((zzhf) zze2).zzF()) {
                            Object zze3 = zzb.zze();
                            zzb.zzg(zze3, zze2);
                            zzgv.zzi(zzhd.zzb, zze3);
                            zze2 = zze3;
                        }
                        zzjb.zzt(zze2, zzb, zzgq);
                        return obj3;
                    }
                    throw null;
                case 10:
                    Object zze4 = zzgv.zze(zzhd.zzb);
                    if (zze4 instanceof zzhf) {
                        zzjc zzb2 = zziy.zza().zzb(zze4.getClass());
                        if (!((zzhf) zze4).zzF()) {
                            Object zze5 = zzb2.zze();
                            zzb2.zzg(zze5, zze4);
                            zzgv.zzi(zzhd.zzb, zze5);
                            zze4 = zze5;
                        }
                        zzjb.zzu(zze4, zzb2, zzgq);
                        return obj3;
                    }
                    throw null;
                case 11:
                    obj4 = zzjb.zzp();
                    break;
                case 12:
                    obj4 = Integer.valueOf(zzjb.zzj());
                    break;
                case 13:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 14:
                    obj4 = Integer.valueOf(zzjb.zzh());
                    break;
                case 15:
                    obj4 = Long.valueOf(zzjb.zzm());
                    break;
                case 16:
                    obj4 = Integer.valueOf(zzjb.zzi());
                    break;
                case 17:
                    obj4 = Long.valueOf(zzjb.zzn());
                    break;
            }
            int ordinal = zzhd.zzb.zzb.ordinal();
            if ((ordinal == 9 || ordinal == 10) && (zze = zzgv.zze(zzhd.zzb)) != null) {
                byte[] bArr = zzhn.zzd;
                obj4 = ((zzip) zze).zzW().zzc((zzip) obj4).zzk();
            }
            zzgv.zzi(zzhd.zzb, obj4);
            return obj3;
        }
        zzjb.zzg();
        throw null;
    }

    public final void zzf(Object obj) {
        ((zzhb) obj).zzb.zzg();
    }

    public final void zzg(zzjb zzjb, Object obj, zzgq zzgq, zzgv zzgv) throws IOException {
        throw null;
    }

    public final void zzh(zzfi zzfi, Object obj, zzgq zzgq, zzgv zzgv) throws IOException {
        throw null;
    }

    public final void zzi(zzko zzko, Map.Entry entry) throws IOException {
        zzhc zzhc = (zzhc) entry.getKey();
        zzkm zzkm = zzkm.DOUBLE;
        switch (zzhc.zzb.ordinal()) {
            case 0:
                zzko.zzf(zzhc.zza, ((Double) entry.getValue()).doubleValue());
                return;
            case 1:
                zzko.zzo(zzhc.zza, ((Float) entry.getValue()).floatValue());
                return;
            case 2:
                zzko.zzt(zzhc.zza, ((Long) entry.getValue()).longValue());
                return;
            case 3:
                zzko.zzK(zzhc.zza, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                zzko.zzr(zzhc.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 5:
                zzko.zzm(zzhc.zza, ((Long) entry.getValue()).longValue());
                return;
            case 6:
                zzko.zzk(zzhc.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 7:
                zzko.zzb(zzhc.zza, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 8:
                zzko.zzG(zzhc.zza, (String) entry.getValue());
                return;
            case 9:
                zzko.zzq(zzhc.zza, entry.getValue(), zziy.zza().zzb(entry.getValue().getClass()));
                return;
            case 10:
                zzko.zzv(zzhc.zza, entry.getValue(), zziy.zza().zzb(entry.getValue().getClass()));
                return;
            case 11:
                zzko.zzd(zzhc.zza, (zzfi) entry.getValue());
                return;
            case 12:
                zzko.zzI(zzhc.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                zzko.zzr(zzhc.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 14:
                zzko.zzx(zzhc.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                zzko.zzz(zzhc.zza, ((Long) entry.getValue()).longValue());
                return;
            case 16:
                zzko.zzB(zzhc.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 17:
                zzko.zzD(zzhc.zza, ((Long) entry.getValue()).longValue());
                return;
            default:
                return;
        }
    }

    public final boolean zzj(zzip zzip) {
        return zzip instanceof zzhb;
    }
}
