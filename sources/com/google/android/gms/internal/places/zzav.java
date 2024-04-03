package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzax;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzav<FieldDescriptorType extends zzax<FieldDescriptorType>> {
    private static final zzav zzfm = new zzav(true);
    final zzdb<FieldDescriptorType, Object> zzfj = zzdb.zzal(16);
    private boolean zzfk;
    private boolean zzfl = false;

    private zzav() {
    }

    public static <T extends zzax<T>> zzav<T> zzau() {
        return zzfm;
    }

    private final Object zzb(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzfj.get(fielddescriptortype);
        return obj instanceof zzbl ? zzbl.zzbv() : obj;
    }

    private static boolean zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        zzax zzax = (zzax) entry.getKey();
        if (zzax.zzay() == zzem.MESSAGE) {
            if (zzax.zzaz()) {
                for (zzck isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzck) {
                    if (!((zzck) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzbl) {
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
        zzax zzax = (zzax) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzbl) {
            value = zzbl.zzbv();
        }
        if (zzax.zzaz()) {
            Object zzb = zzb(zzax);
            if (zzb == null) {
                zzb = new ArrayList();
            }
            for (Object zze : (List) value) {
                ((List) zzb).add(zze(zze));
            }
            this.zzfj.put(zzax, zzb);
        } else if (zzax.zzay() == zzem.MESSAGE) {
            Object zzb2 = zzb(zzax);
            if (zzb2 == null) {
                this.zzfj.put(zzax, zze(value));
                return;
            }
            if (zzb2 instanceof zzcp) {
                obj = zzax.zzb((zzcp) zzb2, (zzcp) value);
            } else {
                obj = zzax.zzb(((zzck) zzb2).zzbk(), (zzck) value).zzbf();
            }
            this.zzfj.put(zzax, obj);
        } else {
            this.zzfj.put(zzax, zze(value));
        }
    }

    private static Object zze(Object obj) {
        if (obj instanceof zzcp) {
            return ((zzcp) obj).zzcm();
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
        zzav zzav = new zzav();
        for (int i11 = 0; i11 < this.zzfj.zzcu(); i11++) {
            Map.Entry<FieldDescriptorType, Object> zzam = this.zzfj.zzam(i11);
            zzav.zzb((zzax) zzam.getKey(), zzam.getValue());
        }
        for (Map.Entry next : this.zzfj.zzcv()) {
            zzav.zzb((zzax) next.getKey(), next.getValue());
        }
        zzav.zzfl = this.zzfl;
        return zzav;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzfl) {
            return new zzbq(this.zzfj.zzcw().iterator());
        }
        return this.zzfj.zzcw().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzav)) {
            return false;
        }
        return this.zzfj.equals(((zzav) obj).zzfj);
    }

    public final int hashCode() {
        return this.zzfj.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzfk;
    }

    public final boolean isInitialized() {
        for (int i11 = 0; i11 < this.zzfj.zzcu(); i11++) {
            if (!zzc(this.zzfj.zzam(i11))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zzc : this.zzfj.zzcv()) {
            if (!zzc(zzc)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzfl) {
            return new zzbq(this.zzfj.entrySet().iterator());
        }
        return this.zzfj.entrySet().iterator();
    }

    public final void zzab() {
        if (!this.zzfk) {
            this.zzfj.zzab();
            this.zzfk = true;
        }
    }

    public final int zzav() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzfj.zzcu(); i12++) {
            i11 += zze(this.zzfj.zzam(i12));
        }
        for (Map.Entry<FieldDescriptorType, Object> zze : this.zzfj.zzcv()) {
            i11 += zze(zze);
        }
        return i11;
    }

    private zzav(boolean z11) {
        zzab();
    }

    private final void zzb(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzaz()) {
            zzb(fielddescriptortype.zzax(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj2 = arrayList.get(i11);
                i11++;
                zzb(fielddescriptortype.zzax(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzbl) {
            this.zzfl = true;
        }
        this.zzfj.put(fielddescriptortype, obj);
    }

    private static int zze(Map.Entry<FieldDescriptorType, Object> entry) {
        zzax zzax = (zzax) entry.getKey();
        Object value = entry.getValue();
        if (zzax.zzay() != zzem.MESSAGE || zzax.zzaz() || zzax.zzba()) {
            return zzc((zzax<?>) zzax, value);
        }
        if (value instanceof zzbl) {
            return zzaj.zzc(((zzax) entry.getKey()).zzaw(), (zzbp) (zzbl) value);
        }
        return zzaj.zzc(((zzax) entry.getKey()).zzaw(), (zzck) value);
    }

    private static int zzc(zzef zzef, Object obj) {
        switch (zzau.zzfi[zzef.ordinal()]) {
            case 1:
                return zzaj.zzc(((Double) obj).doubleValue());
            case 2:
                return zzaj.zze(((Float) obj).floatValue());
            case 3:
                return zzaj.zzf(((Long) obj).longValue());
            case 4:
                return zzaj.zzg(((Long) obj).longValue());
            case 5:
                return zzaj.zzs(((Integer) obj).intValue());
            case 6:
                return zzaj.zzi(((Long) obj).longValue());
            case 7:
                return zzaj.zzv(((Integer) obj).intValue());
            case 8:
                return zzaj.zzd(((Boolean) obj).booleanValue());
            case 9:
                return zzaj.zze((zzck) obj);
            case 10:
                if (obj instanceof zzbl) {
                    return zzaj.zzb((zzbp) (zzbl) obj);
                }
                return zzaj.zzd((zzck) obj);
            case 11:
                if (obj instanceof zzw) {
                    return zzaj.zzc((zzw) obj);
                }
                return zzaj.zzk((String) obj);
            case 12:
                if (obj instanceof zzw) {
                    return zzaj.zzc((zzw) obj);
                }
                return zzaj.zzd((byte[]) obj);
            case 13:
                return zzaj.zzt(((Integer) obj).intValue());
            case 14:
                return zzaj.zzw(((Integer) obj).intValue());
            case 15:
                return zzaj.zzj(((Long) obj).longValue());
            case 16:
                return zzaj.zzu(((Integer) obj).intValue());
            case 17:
                return zzaj.zzh(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzbg) {
                    return zzaj.zzx(((zzbg) obj).zzaw());
                }
                return zzaj.zzx(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if ((r3 instanceof com.google.android.gms.internal.places.zzbg) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.places.zzbl) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzb(com.google.android.gms.internal.places.zzef r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.places.zzbd.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.places.zzau.zzfh
            com.google.android.gms.internal.places.zzem r2 = r2.zzdr()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.places.zzck
            if (r2 != 0) goto L_0x0043
            boolean r2 = r3 instanceof com.google.android.gms.internal.places.zzbl
            if (r2 == 0) goto L_0x001e
            goto L_0x0043
        L_0x001e:
            r0 = r1
            goto L_0x0043
        L_0x0020:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0043
            boolean r2 = r3 instanceof com.google.android.gms.internal.places.zzbg
            if (r2 == 0) goto L_0x001e
            goto L_0x0043
        L_0x0029:
            boolean r2 = r3 instanceof com.google.android.gms.internal.places.zzw
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzav.zzb(com.google.android.gms.internal.places.zzef, java.lang.Object):void");
    }

    public final void zzb(zzav<FieldDescriptorType> zzav) {
        for (int i11 = 0; i11 < zzav.zzfj.zzcu(); i11++) {
            zzd(zzav.zzfj.zzam(i11));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzd : zzav.zzfj.zzcv()) {
            zzd(zzd);
        }
    }

    public static void zzb(zzaj zzaj, zzef zzef, int i11, Object obj) throws IOException {
        if (zzef == zzef.GROUP) {
            zzck zzck = (zzck) obj;
            zzbd.zzg(zzck);
            zzaj.zzc(i11, 3);
            zzck.zzc(zzaj);
            zzaj.zzc(i11, 4);
            return;
        }
        zzaj.zzc(i11, zzef.zzds());
        switch (zzau.zzfi[zzef.ordinal()]) {
            case 1:
                zzaj.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzaj.zzd(((Float) obj).floatValue());
                return;
            case 3:
                zzaj.zzc(((Long) obj).longValue());
                return;
            case 4:
                zzaj.zzc(((Long) obj).longValue());
                return;
            case 5:
                zzaj.zzn(((Integer) obj).intValue());
                return;
            case 6:
                zzaj.zze(((Long) obj).longValue());
                return;
            case 7:
                zzaj.zzq(((Integer) obj).intValue());
                return;
            case 8:
                zzaj.zzc(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzck) obj).zzc(zzaj);
                return;
            case 10:
                zzaj.zzc((zzck) obj);
                return;
            case 11:
                if (obj instanceof zzw) {
                    zzaj.zzb((zzw) obj);
                    return;
                } else {
                    zzaj.zzj((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzw) {
                    zzaj.zzb((zzw) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzaj.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zzaj.zzo(((Integer) obj).intValue());
                return;
            case 14:
                zzaj.zzq(((Integer) obj).intValue());
                return;
            case 15:
                zzaj.zze(((Long) obj).longValue());
                return;
            case 16:
                zzaj.zzp(((Integer) obj).intValue());
                return;
            case 17:
                zzaj.zzd(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzbg) {
                    zzaj.zzn(((zzbg) obj).zzaw());
                    return;
                } else {
                    zzaj.zzn(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static int zzc(zzax<?> zzax, Object obj) {
        zzef zzax2 = zzax.zzax();
        int zzaw = zzax.zzaw();
        if (!zzax.zzaz()) {
            return zzb(zzax2, zzaw, obj);
        }
        int i11 = 0;
        if (zzax.zzba()) {
            for (Object zzc : (List) obj) {
                i11 += zzc(zzax2, zzc);
            }
            return zzaj.zzr(zzaw) + i11 + zzaj.zzz(i11);
        }
        for (Object zzb : (List) obj) {
            i11 += zzb(zzax2, zzaw, zzb);
        }
        return i11;
    }

    public static int zzb(zzef zzef, int i11, Object obj) {
        int zzr = zzaj.zzr(i11);
        if (zzef == zzef.GROUP) {
            zzbd.zzg((zzck) obj);
            zzr <<= 1;
        }
        return zzr + zzc(zzef, obj);
    }
}
