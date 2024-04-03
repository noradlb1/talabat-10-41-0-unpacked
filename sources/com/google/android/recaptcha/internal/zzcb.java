package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class zzcb implements zzca {
    @NotNull
    public static final zzcb zza = new zzcb();

    private zzcb() {
    }

    private static final List zzc(Object obj) {
        if (obj instanceof byte[]) {
            return ArraysKt___ArraysKt.toList((byte[]) obj);
        }
        if (obj instanceof short[]) {
            return ArraysKt___ArraysKt.toList((short[]) obj);
        }
        if (obj instanceof int[]) {
            return ArraysKt___ArraysKt.toList((int[]) obj);
        }
        if (obj instanceof long[]) {
            return ArraysKt___ArraysKt.toList((long[]) obj);
        }
        if (obj instanceof float[]) {
            return ArraysKt___ArraysKt.toList((float[]) obj);
        }
        if (!(obj instanceof double[])) {
            return null;
        }
        return ArraysKt___ArraysKt.toList((double[]) obj);
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        if (zznlArr.length == 2) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                Object zza3 = zzbh.zze().zza(zznlArr[1]);
                if (true != (zza3 instanceof Object)) {
                    zza3 = null;
                }
                if (zza3 != null) {
                    zzbh.zze().zzf(i11, zzb(zza2, zza3));
                    return;
                }
                throw new zzs(4, 5, (Throwable) null);
            }
            throw new zzs(4, 5, (Throwable) null);
        }
        throw new zzs(4, 3, (Throwable) null);
    }

    @NotNull
    public final Object zzb(@NotNull Object obj, @NotNull Object obj2) throws zzs {
        List<Number> zzc = zzc(obj);
        List<Number> zzc2 = zzc(obj2);
        if (obj instanceof Number) {
            if (obj2 instanceof Number) {
                return Double.valueOf(Math.pow(((Number) obj).doubleValue(), ((Number) obj2).doubleValue()));
            }
            if (zzc2 != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(zzc2, 10));
                for (Number doubleValue : zzc2) {
                    arrayList.add(Double.valueOf(Math.pow(doubleValue.doubleValue(), ((Number) obj).doubleValue())));
                }
                return arrayList.toArray(new Double[0]);
            }
        }
        if (zzc != null && (obj2 instanceof Number)) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(zzc, 10));
            for (Number doubleValue2 : zzc) {
                arrayList2.add(Double.valueOf(Math.pow(doubleValue2.doubleValue(), ((Number) obj2).doubleValue())));
            }
            return arrayList2.toArray(new Double[0]);
        } else if (zzc == null || zzc2 == null) {
            throw new zzs(4, 5, (Throwable) null);
        } else {
            zzbz.zzb(this, zzc.size(), zzc2.size());
            int size = zzc.size();
            Double[] dArr = new Double[size];
            for (int i11 = 0; i11 < size; i11++) {
                dArr[i11] = Double.valueOf(Math.pow(((Number) zzc.get(i11)).doubleValue(), ((Number) zzc2.get(i11)).doubleValue()));
            }
            return dArr;
        }
    }
}
