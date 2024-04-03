package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Set;
import javax.annotation.CheckForNull;

public abstract class zzftc<E> extends zzfsn<E> implements Set<E> {
    @CheckForNull
    private transient zzfss<E> zza;

    public static int zzh(int i11) {
        boolean z11;
        int max = Math.max(i11, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        }
        if (max < 1073741824) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfqg.zze(z11, "collection too large");
        return 1073741824;
    }

    public static <E> zzftb<E> zzj(int i11) {
        return new zzftb<>(i11);
    }

    public static <E> zzftc<E> zzl() {
        return zzfum.zza;
    }

    @SafeVarargs
    public static <E> zzftc<E> zzm(E e11, E e12, E e13, E e14, E e15, E e16, E... eArr) {
        Object[] objArr = new Object[11];
        objArr[0] = e11;
        objArr[1] = e12;
        objArr[2] = e13;
        objArr[3] = e14;
        objArr[4] = e15;
        objArr[5] = e16;
        System.arraycopy(eArr, 0, objArr, 6, 5);
        return zzp(11, objArr);
    }

    /* access modifiers changed from: private */
    public static <E> zzftc<E> zzp(int i11, Object... objArr) {
        if (i11 == 0) {
            return zzfum.zza;
        }
        if (i11 != 1) {
            int zzh = zzh(i11);
            Object[] objArr2 = new Object[zzh];
            int i12 = zzh - 1;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                Object obj = objArr[i15];
                zzfue.zza(obj, i15);
                int hashCode = obj.hashCode();
                int zza2 = zzfsk.zza(hashCode);
                while (true) {
                    int i16 = zza2 & i12;
                    Object obj2 = objArr2[i16];
                    if (obj2 == null) {
                        objArr[i14] = obj;
                        objArr2[i16] = obj;
                        i13 += hashCode;
                        i14++;
                        break;
                    } else if (obj2.equals(obj)) {
                        break;
                    } else {
                        zza2++;
                    }
                }
            }
            Arrays.fill(objArr, i14, i11, (Object) null);
            if (i14 == 1) {
                Object obj3 = objArr[0];
                obj3.getClass();
                return new zzfur(obj3);
            } else if (zzh(i14) < zzh / 2) {
                return zzp(i14, objArr);
            } else {
                if (zzq(i14, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i14);
                }
                return new zzfum(objArr, i13, objArr2, i12, i14);
            }
        } else {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzfur(obj4);
        }
    }

    /* access modifiers changed from: private */
    public static boolean zzq(int i11, int i12) {
        return i11 < (i12 >> 1) + (i12 >> 2);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzftc) && zzo() && ((zzftc) obj).zzo() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return zzfuq.zza(this);
    }

    public zzfss<E> zzd() {
        zzfss<E> zzfss = this.zza;
        if (zzfss != null) {
            return zzfss;
        }
        zzfss<E> zzi = zzi();
        this.zza = zzi;
        return zzi;
    }

    /* renamed from: zze */
    public abstract zzfuu<E> iterator();

    public zzfss<E> zzi() {
        return zzfss.zzj(toArray());
    }

    public boolean zzo() {
        return false;
    }
}
