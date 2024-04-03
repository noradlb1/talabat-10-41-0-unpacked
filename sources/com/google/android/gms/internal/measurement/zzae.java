package com.google.android.gms.internal.measurement;

import com.adjust.sdk.Constants;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzae implements Iterable, zzap, zzal {
    final SortedMap zza;
    final Map zzb;

    public zzae() {
        this.zza = new TreeMap();
        this.zzb = new TreeMap();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzae)) {
            return false;
        }
        zzae zzae = (zzae) obj;
        if (zzc() != zzae.zzc()) {
            return false;
        }
        if (this.zza.isEmpty()) {
            return zzae.zza.isEmpty();
        }
        for (int intValue = ((Integer) this.zza.firstKey()).intValue(); intValue <= ((Integer) this.zza.lastKey()).intValue(); intValue++) {
            if (!zze(intValue).equals(zzae.zze(intValue))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode() * 31;
    }

    public final Iterator iterator() {
        return new zzad(this);
    }

    public final String toString() {
        return zzj(",");
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final zzap zzbU(String str, zzg zzg, List list) {
        if ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || Param.MAP.equals(str) || "pop".equals(str) || Constants.PUSH.equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) {
            return zzbb.zza(str, this, zzg, list);
        }
        return zzaj.zza(this, new zzat(str), zzg, list);
    }

    public final int zzc() {
        if (this.zza.isEmpty()) {
            return 0;
        }
        return ((Integer) this.zza.lastKey()).intValue() + 1;
    }

    public final zzap zzd() {
        zzae zzae = new zzae();
        for (Map.Entry entry : this.zza.entrySet()) {
            if (entry.getValue() instanceof zzal) {
                zzae.zza.put((Integer) entry.getKey(), (zzap) entry.getValue());
            } else {
                zzae.zza.put((Integer) entry.getKey(), ((zzap) entry.getValue()).zzd());
            }
        }
        return zzae;
    }

    public final zzap zze(int i11) {
        zzap zzap;
        if (i11 >= zzc()) {
            throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
        } else if (!zzs(i11) || (zzap = (zzap) this.zza.get(Integer.valueOf(i11))) == null) {
            return zzap.zzf;
        } else {
            return zzap;
        }
    }

    public final zzap zzf(String str) {
        zzap zzap;
        if ("length".equals(str)) {
            return new zzah(Double.valueOf((double) zzc()));
        }
        if (!zzt(str) || (zzap = (zzap) this.zzb.get(str)) == null) {
            return zzap.zzf;
        }
        return zzap;
    }

    public final Boolean zzg() {
        return Boolean.TRUE;
    }

    public final Double zzh() {
        if (this.zza.size() == 1) {
            return zze(0).zzh();
        }
        if (this.zza.size() <= 0) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(Double.NaN);
    }

    public final String zzi() {
        return zzj(",");
    }

    public final String zzj(String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        if (!this.zza.isEmpty()) {
            int i11 = 0;
            while (true) {
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i11 >= zzc()) {
                    break;
                }
                zzap zze = zze(i11);
                sb2.append(str2);
                if (!(zze instanceof zzau) && !(zze instanceof zzan)) {
                    sb2.append(zze.zzi());
                }
                i11++;
            }
            sb2.delete(0, str2.length());
        }
        return sb2.toString();
    }

    public final Iterator zzk() {
        return this.zza.keySet().iterator();
    }

    public final Iterator zzl() {
        return new zzac(this, this.zza.keySet().iterator(), this.zzb.keySet().iterator());
    }

    public final List zzm() {
        ArrayList arrayList = new ArrayList(zzc());
        for (int i11 = 0; i11 < zzc(); i11++) {
            arrayList.add(zze(i11));
        }
        return arrayList;
    }

    public final void zzn() {
        this.zza.clear();
    }

    public final void zzo(int i11, zzap zzap) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Invalid value index: " + i11);
        } else if (i11 >= zzc()) {
            zzq(i11, zzap);
        } else {
            for (int intValue = ((Integer) this.zza.lastKey()).intValue(); intValue >= i11; intValue--) {
                SortedMap sortedMap = this.zza;
                Integer valueOf = Integer.valueOf(intValue);
                zzap zzap2 = (zzap) sortedMap.get(valueOf);
                if (zzap2 != null) {
                    zzq(intValue + 1, zzap2);
                    this.zza.remove(valueOf);
                }
            }
            zzq(i11, zzap);
        }
    }

    public final void zzp(int i11) {
        int intValue = ((Integer) this.zza.lastKey()).intValue();
        if (i11 <= intValue && i11 >= 0) {
            this.zza.remove(Integer.valueOf(i11));
            if (i11 == intValue) {
                SortedMap sortedMap = this.zza;
                int i12 = i11 - 1;
                Integer valueOf = Integer.valueOf(i12);
                if (!sortedMap.containsKey(valueOf) && i12 >= 0) {
                    this.zza.put(valueOf, zzap.zzf);
                    return;
                }
                return;
            }
            while (true) {
                i11++;
                if (i11 <= ((Integer) this.zza.lastKey()).intValue()) {
                    SortedMap sortedMap2 = this.zza;
                    Integer valueOf2 = Integer.valueOf(i11);
                    zzap zzap = (zzap) sortedMap2.get(valueOf2);
                    if (zzap != null) {
                        this.zza.put(Integer.valueOf(i11 - 1), zzap);
                        this.zza.remove(valueOf2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    @RequiresNonNull({"elements"})
    public final void zzq(int i11, zzap zzap) {
        if (i11 > 32468) {
            throw new IllegalStateException("Array too large");
        } else if (i11 < 0) {
            throw new IndexOutOfBoundsException("Out of bounds index: " + i11);
        } else if (zzap == null) {
            this.zza.remove(Integer.valueOf(i11));
        } else {
            this.zza.put(Integer.valueOf(i11), zzap);
        }
    }

    public final void zzr(String str, zzap zzap) {
        if (zzap == null) {
            this.zzb.remove(str);
        } else {
            this.zzb.put(str, zzap);
        }
    }

    public final boolean zzs(int i11) {
        if (i11 >= 0 && i11 <= ((Integer) this.zza.lastKey()).intValue()) {
            return this.zza.containsKey(Integer.valueOf(i11));
        }
        throw new IndexOutOfBoundsException("Out of bounds index: " + i11);
    }

    public final boolean zzt(String str) {
        if ("length".equals(str) || this.zzb.containsKey(str)) {
            return true;
        }
        return false;
    }

    public zzae(List list) {
        this();
        if (list != null) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                zzq(i11, (zzap) list.get(i11));
            }
        }
    }
}
