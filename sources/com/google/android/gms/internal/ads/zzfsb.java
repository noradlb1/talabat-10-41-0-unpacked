package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

final class zzfsb<K, V> extends AbstractMap<K, V> implements Serializable {
    /* access modifiers changed from: private */
    public static final Object zzd = new Object();
    @CheckForNull
    transient int[] zza;
    @CheckForNull
    transient Object[] zzb;
    @CheckForNull
    transient Object[] zzc;
    @CheckForNull
    private transient Object zze;
    /* access modifiers changed from: private */
    public transient int zzf;
    /* access modifiers changed from: private */
    public transient int zzg;
    @CheckForNull
    private transient Set<K> zzh;
    @CheckForNull
    private transient Set<Map.Entry<K, V>> zzi;
    @CheckForNull
    private transient Collection<V> zzj;

    public zzfsb() {
        zzp(3);
    }

    /* access modifiers changed from: private */
    public final int[] zzA() {
        int[] iArr = this.zza;
        iArr.getClass();
        return iArr;
    }

    /* access modifiers changed from: private */
    public final Object[] zzB() {
        Object[] objArr = this.zzb;
        objArr.getClass();
        return objArr;
    }

    /* access modifiers changed from: private */
    public final Object[] zzC() {
        Object[] objArr = this.zzc;
        objArr.getClass();
        return objArr;
    }

    public static /* synthetic */ Object zzg(zzfsb zzfsb, int i11) {
        return zzfsb.zzB()[i11];
    }

    public static /* synthetic */ Object zzi(zzfsb zzfsb) {
        Object obj = zzfsb.zze;
        obj.getClass();
        return obj;
    }

    public static /* synthetic */ Object zzj(zzfsb zzfsb, int i11) {
        return zzfsb.zzC()[i11];
    }

    public static /* synthetic */ void zzn(zzfsb zzfsb, int i11, Object obj) {
        zzfsb.zzC()[i11] = obj;
    }

    /* access modifiers changed from: private */
    public final int zzv() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public final int zzw(@CheckForNull Object obj) {
        if (zzr()) {
            return -1;
        }
        int zzb2 = zzfsk.zzb(obj);
        int zzv = zzv();
        Object obj2 = this.zze;
        obj2.getClass();
        int zzc2 = zzfsc.zzc(obj2, zzb2 & zzv);
        if (zzc2 != 0) {
            int i11 = ~zzv;
            int i12 = zzb2 & i11;
            do {
                int i13 = zzc2 - 1;
                int i14 = zzA()[i13];
                if ((i14 & i11) == i12 && zzfqc.zza(obj, zzB()[i13])) {
                    return i13;
                }
                zzc2 = i14 & zzv;
            } while (zzc2 != 0);
        }
        return -1;
    }

    private final int zzx(int i11, int i12, int i13, int i14) {
        Object zzd2 = zzfsc.zzd(i12);
        int i15 = i12 - 1;
        if (i14 != 0) {
            zzfsc.zze(zzd2, i13 & i15, i14 + 1);
        }
        Object obj = this.zze;
        obj.getClass();
        int[] zzA = zzA();
        for (int i16 = 0; i16 <= i11; i16++) {
            int zzc2 = zzfsc.zzc(obj, i16);
            while (zzc2 != 0) {
                int i17 = zzc2 - 1;
                int i18 = zzA[i17];
                int i19 = ((~i11) & i18) | i16;
                int i21 = i19 & i15;
                int zzc3 = zzfsc.zzc(zzd2, i21);
                zzfsc.zze(zzd2, i21, zzc2);
                zzA[i17] = ((~i15) & i19) | (zzc3 & i15);
                zzc2 = i18 & i11;
            }
        }
        this.zze = zzd2;
        zzz(i15);
        return i15;
    }

    /* access modifiers changed from: private */
    public final Object zzy(@CheckForNull Object obj) {
        if (zzr()) {
            return zzd;
        }
        int zzv = zzv();
        Object obj2 = this.zze;
        obj2.getClass();
        int zzb2 = zzfsc.zzb(obj, (Object) null, zzv, obj2, zzA(), zzB(), (Object[]) null);
        if (zzb2 == -1) {
            return zzd;
        }
        Object obj3 = zzC()[zzb2];
        zzq(zzb2, zzv);
        this.zzg--;
        zzo();
        return obj3;
    }

    private final void zzz(int i11) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i11)) & 31) | (this.zzf & -32);
    }

    public final void clear() {
        if (!zzr()) {
            zzo();
            Map zzl = zzl();
            if (zzl != null) {
                this.zzf = zzfva.zza(size(), 3, 1073741823);
                zzl.clear();
                this.zze = null;
                this.zzg = 0;
                return;
            }
            Arrays.fill(zzB(), 0, this.zzg, (Object) null);
            Arrays.fill(zzC(), 0, this.zzg, (Object) null);
            Object obj = this.zze;
            obj.getClass();
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(zzA(), 0, this.zzg, 0);
            this.zzg = 0;
        }
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsKey(obj);
        }
        if (zzw(obj) == -1) {
            return false;
        }
        return true;
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsValue(obj);
        }
        for (int i11 = 0; i11 < this.zzg; i11++) {
            if (zzfqc.zza(obj, zzC()[i11])) {
                return true;
            }
        }
        return false;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zzi;
        if (set != null) {
            return set;
        }
        zzfrv zzfrv = new zzfrv(this);
        this.zzi = zzfrv;
        return zzfrv;
    }

    @CheckForNull
    public final V get(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.get(obj);
        }
        int zzw = zzw(obj);
        if (zzw == -1) {
            return null;
        }
        return zzC()[zzw];
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Set<K> keySet() {
        Set<K> set = this.zzh;
        if (set != null) {
            return set;
        }
        zzfry zzfry = new zzfry(this);
        this.zzh = zzfry;
        return zzfry;
    }

    @CheckForNull
    public final V put(K k11, V v11) {
        int min;
        K k12 = k11;
        V v12 = v11;
        if (zzr()) {
            zzfqg.zzg(zzr(), "Arrays already allocated");
            int i11 = this.zzf;
            int max = Math.max(i11 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > ((int) ((double) highestOneBit)) && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzfsc.zzd(max2);
            zzz(max2 - 1);
            this.zza = new int[i11];
            this.zzb = new Object[i11];
            this.zzc = new Object[i11];
        }
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.put(k12, v12);
        }
        int[] zzA = zzA();
        Object[] zzB = zzB();
        V[] zzC = zzC();
        int i12 = this.zzg;
        int i13 = i12 + 1;
        int zzb2 = zzfsk.zzb(k11);
        int zzv = zzv();
        int i14 = zzb2 & zzv;
        Object obj = this.zze;
        obj.getClass();
        int zzc2 = zzfsc.zzc(obj, i14);
        if (zzc2 != 0) {
            int i15 = ~zzv;
            int i16 = zzb2 & i15;
            int i17 = 0;
            while (true) {
                int i18 = zzc2 - 1;
                int i19 = zzA[i18];
                int i21 = i19 & i15;
                if (i21 != i16 || !zzfqc.zza(k12, zzB[i18])) {
                    int i22 = i19 & zzv;
                    i17++;
                    if (i22 != 0) {
                        zzc2 = i22;
                    } else if (i17 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzv() + 1, 1.0f);
                        for (int zze2 = zze(); zze2 >= 0; zze2 = zzf(zze2)) {
                            linkedHashMap.put(zzB()[zze2], zzC()[zze2]);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzo();
                        return linkedHashMap.put(k12, v12);
                    } else if (i13 > zzv) {
                        zzv = zzx(zzv, zzfsc.zza(zzv), zzb2, i12);
                    } else {
                        zzA[i18] = (i13 & zzv) | i21;
                    }
                } else {
                    V v13 = zzC[i18];
                    zzC[i18] = v12;
                    return v13;
                }
            }
        } else if (i13 > zzv) {
            zzv = zzx(zzv, zzfsc.zza(zzv), zzb2, i12);
        } else {
            Object obj2 = this.zze;
            obj2.getClass();
            zzfsc.zze(obj2, i14, i13);
        }
        int length = zzA().length;
        if (i13 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(zzA(), min);
            this.zzb = Arrays.copyOf(zzB(), min);
            this.zzc = Arrays.copyOf(zzC(), min);
        }
        zzA()[i12] = (~zzv) & zzb2;
        zzB()[i12] = k12;
        zzC()[i12] = v12;
        this.zzg = i13;
        zzo();
        return null;
    }

    @CheckForNull
    public final V remove(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.remove(obj);
        }
        V zzy = zzy(obj);
        if (zzy == zzd) {
            return null;
        }
        return zzy;
    }

    public final int size() {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.size();
        }
        return this.zzg;
    }

    public final Collection<V> values() {
        Collection<V> collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzfsa zzfsa = new zzfsa(this);
        this.zzj = zzfsa;
        return zzfsa;
    }

    public final int zze() {
        return isEmpty() ? -1 : 0;
    }

    public final int zzf(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.zzg) {
            return i12;
        }
        return -1;
    }

    @CheckForNull
    public final Map<K, V> zzl() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzo() {
        this.zzf += 32;
    }

    public final void zzp(int i11) {
        this.zzf = zzfva.zza(i11, 1, 1073741823);
    }

    public final void zzq(int i11, int i12) {
        Object obj = this.zze;
        obj.getClass();
        int[] zzA = zzA();
        Object[] zzB = zzB();
        Object[] zzC = zzC();
        int size = size() - 1;
        if (i11 < size) {
            Object obj2 = zzB[size];
            zzB[i11] = obj2;
            zzC[i11] = zzC[size];
            zzB[size] = null;
            zzC[size] = null;
            zzA[i11] = zzA[size];
            zzA[size] = 0;
            int zzb2 = zzfsk.zzb(obj2) & i12;
            int zzc2 = zzfsc.zzc(obj, zzb2);
            int i13 = size + 1;
            if (zzc2 != i13) {
                while (true) {
                    int i14 = zzc2 - 1;
                    int i15 = zzA[i14];
                    int i16 = i15 & i12;
                    if (i16 != i13) {
                        zzc2 = i16;
                    } else {
                        zzA[i14] = ((i11 + 1) & i12) | (i15 & (~i12));
                        return;
                    }
                }
            } else {
                zzfsc.zze(obj, zzb2, i11 + 1);
            }
        } else {
            zzB[i11] = null;
            zzC[i11] = null;
            zzA[i11] = 0;
        }
    }

    public final boolean zzr() {
        return this.zze == null;
    }

    public zzfsb(int i11) {
        zzp(8);
    }
}
