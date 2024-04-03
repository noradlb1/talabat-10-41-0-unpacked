package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.icing.zzbp;
import com.google.firebase.appindexing.Indexable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@SafeParcelable.Class(creator = "ThingCreator")
public final class Thing extends AbstractSafeParcelable implements Indexable, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Thing> CREATOR = new zzad();
    @SafeParcelable.Field(getter = "getVersionCode", id = 1000)
    public final int zza;
    @SafeParcelable.Field(getter = "getPropertyBundle", id = 1)
    private final Bundle zzb;
    @SafeParcelable.Field(getter = "getMetadata", id = 2)
    private final zzac zzc;
    @SafeParcelable.Field(getter = "getUrl", id = 3)
    private final String zzd;
    @SafeParcelable.Field(getter = "getType", id = 4)
    private final String zze;

    @SafeParcelable.Constructor
    public Thing(@SafeParcelable.Param(id = 1000) int i11, @SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) zzac zzac, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2) {
        this.zza = i11;
        this.zzb = bundle;
        this.zzc = zzac;
        this.zzd = str;
        this.zze = str2;
        ClassLoader classLoader = Thing.class.getClassLoader();
        zzbp.zza(classLoader);
        bundle.setClassLoader(classLoader);
    }

    /* access modifiers changed from: private */
    public static void zzd(@NonNull Bundle bundle, @NonNull StringBuilder sb2) {
        try {
            Set<String> keySet = bundle.keySet();
            String[] strArr = (String[]) keySet.toArray(new String[keySet.size()]);
            Arrays.sort(strArr, zzab.zza);
            for (String str : strArr) {
                sb2.append("{ key: '");
                sb2.append(str);
                sb2.append("' value: ");
                Object obj = bundle.get(str);
                if (obj == null) {
                    sb2.append("<null>");
                } else if (obj.getClass().isArray()) {
                    sb2.append("[ ");
                    for (int i11 = 0; i11 < Array.getLength(obj); i11++) {
                        sb2.append("'");
                        sb2.append(Array.get(obj, i11));
                        sb2.append("' ");
                    }
                    sb2.append("]");
                } else {
                    sb2.append(obj.toString());
                }
                sb2.append(" } ");
            }
        } catch (RuntimeException unused) {
            sb2.append("<error>");
        }
    }

    /* access modifiers changed from: private */
    public static boolean zze(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            Object obj2 = bundle2.get(next);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !zze((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(next)) {
                    return false;
                }
                obj2 = null;
            }
            if (obj instanceof boolean[]) {
                if (!(obj2 instanceof boolean[]) || !Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof long[]) {
                if (!(obj2 instanceof long[]) || !Arrays.equals((long[]) obj, (long[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof double[]) {
                if (!(obj2 instanceof double[]) || !Arrays.equals((double[]) obj, (double[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof byte[]) {
                if (!(obj2 instanceof byte[]) || !Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                    return false;
                }
            } else if ((obj instanceof Object[]) && (!(obj2 instanceof Object[]) || !Arrays.equals((Object[]) obj, (Object[]) obj2))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static int zzf(Bundle bundle) {
        ArrayList arrayList = new ArrayList(bundle.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = bundle.get((String) arrayList.get(i11));
            if (obj instanceof boolean[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((boolean[]) obj)));
            } else if (obj instanceof long[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((long[]) obj)));
            } else if (obj instanceof double[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((double[]) obj)));
            } else if (obj instanceof byte[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((byte[]) obj)));
            } else if (obj instanceof Object[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((Object[]) obj)));
            } else {
                arrayList2.add(Integer.valueOf(Objects.hashCode(obj)));
            }
        }
        return Objects.hashCode(arrayList2.toArray());
    }

    public final boolean equals(@NonNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Thing)) {
            return false;
        }
        Thing thing = (Thing) obj;
        if (!Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(thing.zza)) || !Objects.equal(this.zzd, thing.zzd) || !Objects.equal(this.zze, thing.zze) || !Objects.equal(this.zzc, thing.zzc) || !zze(this.zzb, thing.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzd, this.zze, Integer.valueOf(this.zzc.hashCode()), Integer.valueOf(zzf(this.zzb)));
    }

    @NonNull
    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        if (this.zze.equals("Thing")) {
            str = "Indexable";
        } else {
            str = this.zze;
        }
        sb2.append(str);
        sb2.append(" { { id: ");
        if (this.zzd == null) {
            sb2.append("<null>");
        } else {
            sb2.append("'");
            sb2.append(this.zzd);
            sb2.append("'");
        }
        sb2.append(" } Properties { ");
        zzd(this.zzb, sb2);
        sb2.append("} Metadata { ");
        sb2.append(this.zzc.toString());
        sb2.append(" } }");
        return sb2.toString();
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzc, i11, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 4, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public Thing(@NonNull Bundle bundle, @NonNull zzac zzac, String str, @NonNull String str2) {
        this.zza = 10;
        this.zzb = bundle;
        this.zzc = zzac;
        this.zzd = str;
        this.zze = str2;
    }
}
