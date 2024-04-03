package com.google.android.gms.internal.maps;

import com.talabat.helpers.GlobalConstants;
import java.util.Arrays;
import java.util.Set;
import javax.annotation.CheckForNull;

public abstract class zzba extends zzaw implements Set {
    @CheckForNull
    private transient zzaz zza;

    public static int zzf(int i11) {
        int max = Math.max(i11, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        } else if (max < 1073741824) {
            return 1073741824;
        } else {
            throw new IllegalArgumentException("collection too large");
        }
    }

    @SafeVarargs
    public static zzba zzi(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = {"ADMINISTRATIVE_AREA_LEVEL_1", "ADMINISTRATIVE_AREA_LEVEL_2", GlobalConstants.PrefsConstants.COUNTRY_ID, "LOCALITY", "POSTAL_CODE", "SCHOOL_DISTRICT"};
        System.arraycopy(objArr, 0, objArr2, 6, 0);
        return zzk(6, objArr2);
    }

    private static zzba zzk(int i11, Object... objArr) {
        if (i11 == 0) {
            return zzbd.zza;
        }
        if (i11 != 1) {
            int zzf = zzf(i11);
            Object[] objArr2 = new Object[zzf];
            int i12 = zzf - 1;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i13 < i11) {
                Object obj = objArr[i13];
                if (obj != null) {
                    int hashCode = obj.hashCode();
                    int zza2 = zzav.zza(hashCode);
                    while (true) {
                        int i16 = zza2 & i12;
                        Object obj2 = objArr2[i16];
                        if (obj2 != null) {
                            if (obj2.equals(obj)) {
                                break;
                            }
                            zza2++;
                        } else {
                            objArr[i15] = obj;
                            objArr2[i16] = obj;
                            i14 += hashCode;
                            i15++;
                            break;
                        }
                    }
                    i13++;
                } else {
                    throw new NullPointerException("at index " + i13);
                }
            }
            Arrays.fill(objArr, i15, i11, (Object) null);
            if (i15 == 1) {
                Object obj3 = objArr[0];
                obj3.getClass();
                return new zzbe(obj3);
            }
            if (zzf(i15) < zzf / 2) {
                return zzk(i15, objArr);
            }
            if (i15 < 4) {
                objArr = Arrays.copyOf(objArr, i15);
            }
            return new zzbd(objArr, i14, objArr2, i12, i15);
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        return new zzbe(obj4);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzba) && zzj() && ((zzba) obj).zzj() && hashCode() != obj.hashCode()) {
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
        int i11;
        int i12 = 0;
        for (Object next : this) {
            if (next != null) {
                i11 = next.hashCode();
            } else {
                i11 = 0;
            }
            i12 += i11;
        }
        return i12;
    }

    /* renamed from: zzd */
    public abstract zzbf iterator();

    public final zzaz zzg() {
        zzaz zzaz = this.zza;
        if (zzaz != null) {
            return zzaz;
        }
        zzaz zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    public zzaz zzh() {
        Object[] array = toArray();
        int i11 = zzaz.zzd;
        return zzaz.zzg(array, array.length);
    }

    public boolean zzj() {
        return false;
    }
}
