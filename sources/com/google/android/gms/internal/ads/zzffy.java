package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class zzffy implements zzffx {
    private final Object[] zza;

    public zzffy(zzbfd zzbfd, String str, int i11, String str2, zzbfo zzbfo) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i11));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzbfd.zzb));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zza(zzbfd.zzc));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzbfd.zzc.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzbfd.zzd));
        }
        if (hashSet.contains("keywords")) {
            List<String> list = zzbfd.zze;
            if (list != null) {
                arrayList.add(list.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzbfd.zzf));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzbfd.zzg));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzbfd.zzh));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzbfd.zzi);
        }
        if (hashSet.contains("location")) {
            Location location = zzbfd.zzk;
            if (location != null) {
                arrayList.add(location.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzbfd.zzl);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zza(zzbfd.zzm));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zza(zzbfd.zzn));
        }
        if (hashSet.contains("categoryExclusions")) {
            List<String> list2 = zzbfd.zzo;
            if (list2 != null) {
                arrayList.add(list2.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzbfd.zzp);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzbfd.zzq);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzbfd.zzr));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzbfd.zzt));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzbfd.zzu);
        }
        if (hashSet.contains("orientation")) {
            if (zzbfo != null) {
                arrayList.add(Integer.valueOf(zzbfo.zza));
            } else {
                arrayList.add((Object) null);
            }
        }
        this.zza = arrayList.toArray();
    }

    private static String zza(@Nullable Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            if (obj == null) {
                str = "null";
            } else if (obj instanceof Bundle) {
                str = zza((Bundle) obj);
            } else {
                str = obj.toString();
            }
            sb2.append(str);
        }
        return sb2.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzffy)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzffy) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        int hashCode = Arrays.hashCode(this.zza);
        String arrays = Arrays.toString(this.zza);
        StringBuilder sb2 = new StringBuilder(String.valueOf(arrays).length() + 22);
        sb2.append("[PoolKey#");
        sb2.append(hashCode);
        sb2.append(" ");
        sb2.append(arrays);
        sb2.append("]");
        return sb2.toString();
    }
}
