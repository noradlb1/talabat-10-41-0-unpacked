package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzqv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzqt<FieldDescriptorType extends zzqv<FieldDescriptorType>> {
    private static final zzqt zzaxq = new zzqt(true);
    private boolean zzaut;
    final zztc<FieldDescriptorType, Object> zzaxo = zztc.zzbu(16);
    private boolean zzaxp = false;

    private zzqt() {
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzaxo.get(fielddescriptortype);
        return obj instanceof zzrn ? zzrn.zzpy() : obj;
    }

    private static int zzb(zzug zzug, Object obj) {
        switch (zzqu.zzaws[zzug.ordinal()]) {
            case 1:
                return zzqj.zzc(((Double) obj).doubleValue());
            case 2:
                return zzqj.zzb(((Float) obj).floatValue());
            case 3:
                return zzqj.zzs(((Long) obj).longValue());
            case 4:
                return zzqj.zzt(((Long) obj).longValue());
            case 5:
                return zzqj.zzbc(((Integer) obj).intValue());
            case 6:
                return zzqj.zzv(((Long) obj).longValue());
            case 7:
                return zzqj.zzbf(((Integer) obj).intValue());
            case 8:
                return zzqj.zzj(((Boolean) obj).booleanValue());
            case 9:
                return zzqj.zzd((zzsk) obj);
            case 10:
                if (obj instanceof zzrn) {
                    return zzqj.zza((zzrr) (zzrn) obj);
                }
                return zzqj.zzc((zzsk) obj);
            case 11:
                if (obj instanceof zzps) {
                    return zzqj.zzb((zzps) obj);
                }
                return zzqj.zzda((String) obj);
            case 12:
                if (obj instanceof zzps) {
                    return zzqj.zzb((zzps) obj);
                }
                return zzqj.zzh((byte[]) obj);
            case 13:
                return zzqj.zzbd(((Integer) obj).intValue());
            case 14:
                return zzqj.zzbg(((Integer) obj).intValue());
            case 15:
                return zzqj.zzw(((Long) obj).longValue());
            case 16:
                return zzqj.zzbe(((Integer) obj).intValue());
            case 17:
                return zzqj.zzu(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzrf) {
                    return zzqj.zzbh(((zzrf) obj).zzc());
                }
                return zzqj.zzbh(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        zzqv zzqv = (zzqv) entry.getKey();
        if (zzqv.zzoy() == zzul.MESSAGE) {
            if (zzqv.zzoz()) {
                for (zzsk isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzsk) {
                    if (!((zzsk) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzrn) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private final void zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzqv zzqv = (zzqv) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzrn) {
            value = zzrn.zzpy();
        }
        if (zzqv.zzoz()) {
            Object zza = zza(zzqv);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzu : (List) value) {
                ((List) zza).add(zzu(zzu));
            }
            this.zzaxo.put(zzqv, zza);
        } else if (zzqv.zzoy() == zzul.MESSAGE) {
            Object zza2 = zza(zzqv);
            if (zza2 == null) {
                this.zzaxo.put(zzqv, zzu(value));
                return;
            }
            if (zza2 instanceof zzsq) {
                obj = zzqv.zza((zzsq) zza2, (zzsq) value);
            } else {
                obj = zzqv.zza(((zzsk) zza2).zzpg(), (zzsk) value).zzpm();
            }
            this.zzaxo.put(zzqv, obj);
        } else {
            this.zzaxo.put(zzqv, zzu(value));
        }
    }

    private static int zze(Map.Entry<FieldDescriptorType, Object> entry) {
        zzqv zzqv = (zzqv) entry.getKey();
        Object value = entry.getValue();
        if (zzqv.zzoy() != zzul.MESSAGE || zzqv.zzoz() || zzqv.zzpa()) {
            return zzb((zzqv<?>) zzqv, value);
        }
        if (value instanceof zzrn) {
            return zzqj.zzb(((zzqv) entry.getKey()).zzc(), (zzrr) (zzrn) value);
        }
        return zzqj.zzd(((zzqv) entry.getKey()).zzc(), (zzsk) value);
    }

    public static <T extends zzqv<T>> zzqt<T> zzov() {
        return zzaxq;
    }

    private static Object zzu(Object obj) {
        if (obj instanceof zzsq) {
            return ((zzsq) obj).zzqo();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzqt zzqt = new zzqt();
        for (int i11 = 0; i11 < this.zzaxo.zzra(); i11++) {
            Map.Entry<FieldDescriptorType, Object> zzbv = this.zzaxo.zzbv(i11);
            zzqt.zza((zzqv) zzbv.getKey(), zzbv.getValue());
        }
        for (Map.Entry next : this.zzaxo.zzrb()) {
            zzqt.zza((zzqv) next.getKey(), next.getValue());
        }
        zzqt.zzaxp = this.zzaxp;
        return zzqt;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzaxp) {
            return new zzrq(this.zzaxo.zzrc().iterator());
        }
        return this.zzaxo.zzrc().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzqt)) {
            return false;
        }
        return this.zzaxo.equals(((zzqt) obj).zzaxo);
    }

    public final int hashCode() {
        return this.zzaxo.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzaut;
    }

    public final boolean isInitialized() {
        for (int i11 = 0; i11 < this.zzaxo.zzra(); i11++) {
            if (!zzc(this.zzaxo.zzbv(i11))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zzc : this.zzaxo.zzrb()) {
            if (!zzc(zzc)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzaxp) {
            return new zzrq(this.zzaxo.entrySet().iterator());
        }
        return this.zzaxo.entrySet().iterator();
    }

    public final void zzmi() {
        if (!this.zzaut) {
            this.zzaxo.zzmi();
            this.zzaut = true;
        }
    }

    public final int zzow() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzaxo.zzra(); i12++) {
            i11 += zze(this.zzaxo.zzbv(i12));
        }
        for (Map.Entry<FieldDescriptorType, Object> zze : this.zzaxo.zzrb()) {
            i11 += zze(zze);
        }
        return i11;
    }

    private zzqt(boolean z11) {
        zzmi();
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzoz()) {
            zza(fielddescriptortype.zzox(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj2 = arrayList.get(i11);
                i11++;
                zza(fielddescriptortype.zzox(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzrn) {
            this.zzaxp = true;
        }
        this.zzaxo.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if ((r3 instanceof com.google.android.gms.internal.gtm.zzrf) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.gtm.zzrn) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.gtm.zzug r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.gtm.zzre.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.gtm.zzqu.zzaxr
            com.google.android.gms.internal.gtm.zzul r2 = r2.zzrs()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0041;
                case 2: goto L_0x003e;
                case 3: goto L_0x003b;
                case 4: goto L_0x0038;
                case 5: goto L_0x0035;
                case 6: goto L_0x0032;
                case 7: goto L_0x0029;
                case 8: goto L_0x0020;
                case 9: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0044
        L_0x0015:
            boolean r2 = r3 instanceof com.google.android.gms.internal.gtm.zzsk
            if (r2 != 0) goto L_0x0043
            boolean r2 = r3 instanceof com.google.android.gms.internal.gtm.zzrn
            if (r2 == 0) goto L_0x001e
            goto L_0x0043
        L_0x001e:
            r0 = r1
            goto L_0x0043
        L_0x0020:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0043
            boolean r2 = r3 instanceof com.google.android.gms.internal.gtm.zzrf
            if (r2 == 0) goto L_0x001e
            goto L_0x0043
        L_0x0029:
            boolean r2 = r3 instanceof com.google.android.gms.internal.gtm.zzps
            if (r2 != 0) goto L_0x0043
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x001e
            goto L_0x0043
        L_0x0032:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0043
        L_0x0035:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0043
        L_0x0038:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0043
        L_0x003b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0043
        L_0x003e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0043
        L_0x0041:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0043:
            r1 = r0
        L_0x0044:
            if (r1 == 0) goto L_0x0047
            return
        L_0x0047:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzqt.zza(com.google.android.gms.internal.gtm.zzug, java.lang.Object):void");
    }

    public final void zza(zzqt<FieldDescriptorType> zzqt) {
        for (int i11 = 0; i11 < zzqt.zzaxo.zzra(); i11++) {
            zzd(zzqt.zzaxo.zzbv(i11));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzd : zzqt.zzaxo.zzrb()) {
            zzd(zzd);
        }
    }

    public static int zzb(zzqv<?> zzqv, Object obj) {
        zzug zzox = zzqv.zzox();
        int zzc = zzqv.zzc();
        if (!zzqv.zzoz()) {
            return zza(zzox, zzc, obj);
        }
        int i11 = 0;
        if (zzqv.zzpa()) {
            for (Object zzb : (List) obj) {
                i11 += zzb(zzox, zzb);
            }
            return zzqj.zzbb(zzc) + i11 + zzqj.zzbj(i11);
        }
        for (Object zza : (List) obj) {
            i11 += zza(zzox, zzc, zza);
        }
        return i11;
    }

    public static void zza(zzqj zzqj, zzug zzug, int i11, Object obj) throws IOException {
        if (zzug == zzug.GROUP) {
            zzsk zzsk = (zzsk) obj;
            zzre.zzf(zzsk);
            zzqj.zzd(i11, 3);
            zzsk.zzb(zzqj);
            zzqj.zzd(i11, 4);
            return;
        }
        zzqj.zzd(i11, zzug.zzrt());
        switch (zzqu.zzaws[zzug.ordinal()]) {
            case 1:
                zzqj.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzqj.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzqj.zzp(((Long) obj).longValue());
                return;
            case 4:
                zzqj.zzp(((Long) obj).longValue());
                return;
            case 5:
                zzqj.zzax(((Integer) obj).intValue());
                return;
            case 6:
                zzqj.zzr(((Long) obj).longValue());
                return;
            case 7:
                zzqj.zzba(((Integer) obj).intValue());
                return;
            case 8:
                zzqj.zzi(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzsk) obj).zzb(zzqj);
                return;
            case 10:
                zzqj.zzb((zzsk) obj);
                return;
            case 11:
                if (obj instanceof zzps) {
                    zzqj.zza((zzps) obj);
                    return;
                } else {
                    zzqj.zzcz((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzps) {
                    zzqj.zza((zzps) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzqj.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zzqj.zzay(((Integer) obj).intValue());
                return;
            case 14:
                zzqj.zzba(((Integer) obj).intValue());
                return;
            case 15:
                zzqj.zzr(((Long) obj).longValue());
                return;
            case 16:
                zzqj.zzaz(((Integer) obj).intValue());
                return;
            case 17:
                zzqj.zzq(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzrf) {
                    zzqj.zzax(((zzrf) obj).zzc());
                    return;
                } else {
                    zzqj.zzax(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static int zza(zzug zzug, int i11, Object obj) {
        int zzbb = zzqj.zzbb(i11);
        if (zzug == zzug.GROUP) {
            zzre.zzf((zzsk) obj);
            zzbb <<= 1;
        }
        return zzbb + zzb(zzug, obj);
    }
}
