package com.google.android.gms.internal.gtm;

import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzoh extends zzoa<List<zzoa<?>>> {
    private static final Map<String, zzgz> zzaug;
    /* access modifiers changed from: private */
    public final ArrayList<zzoa<?>> zzaup;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("concat", new zzhc());
        hashMap.put("every", new zzhd());
        hashMap.put("filter", new zzhe());
        hashMap.put("forEach", new zzhf());
        hashMap.put("indexOf", new zzhg());
        hashMap.put("hasOwnProperty", zzja.zzark);
        hashMap.put("join", new zzhh());
        hashMap.put("lastIndexOf", new zzhi());
        hashMap.put(Param.MAP, new zzhj());
        hashMap.put("pop", new zzhk());
        hashMap.put(Constants.PUSH, new zzhl());
        hashMap.put("reduce", new zzhm());
        hashMap.put("reduceRight", new zzhn());
        hashMap.put("reverse", new zzho());
        hashMap.put("shift", new zzhp());
        hashMap.put("slice", new zzhq());
        hashMap.put("some", new zzhr());
        hashMap.put("sort", new zzhs());
        hashMap.put("splice", new zzhw());
        hashMap.put("toString", new zzkc());
        hashMap.put("unshift", new zzhx());
        zzaug = Collections.unmodifiableMap(hashMap);
    }

    public zzoh(List<zzoa<?>> list) {
        Preconditions.checkNotNull(list);
        this.zzaup = new ArrayList<>(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzoh) {
            List list = (List) ((zzoh) obj).value();
            if (this.zzaup.size() == list.size()) {
                boolean z11 = true;
                for (int i11 = 0; i11 < this.zzaup.size(); i11++) {
                    if (this.zzaup.get(i11) != null) {
                        z11 = this.zzaup.get(i11).equals(list.get(i11));
                    } else if (list.get(i11) == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        break;
                    }
                }
                return z11;
            }
        }
        return false;
    }

    public final void setSize(int i11) {
        boolean z11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid array length");
        if (this.zzaup.size() != i11) {
            if (this.zzaup.size() < i11) {
                this.zzaup.ensureCapacity(i11);
                for (int size = this.zzaup.size(); size < i11; size++) {
                    this.zzaup.add((Object) null);
                }
                return;
            }
            ArrayList<zzoa<?>> arrayList = this.zzaup;
            arrayList.subList(i11, arrayList.size()).clear();
        }
    }

    public final String toString() {
        return this.zzaup.toString();
    }

    public final /* synthetic */ Object value() {
        return this.zzaup;
    }

    public final void zza(int i11, zzoa<?> zzoa) {
        if (i11 >= 0) {
            if (i11 >= this.zzaup.size()) {
                setSize(i11 + 1);
            }
            this.zzaup.set(i11, zzoa);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final zzoa<?> zzac(int i11) {
        if (i11 < 0 || i11 >= this.zzaup.size()) {
            return zzog.zzaum;
        }
        zzoa<?> zzoa = this.zzaup.get(i11);
        if (zzoa == null) {
            return zzog.zzaum;
        }
        return zzoa;
    }

    public final boolean zzad(int i11) {
        return i11 >= 0 && i11 < this.zzaup.size() && this.zzaup.get(i11) != null;
    }

    public final boolean zzcp(String str) {
        return zzaug.containsKey(str);
    }

    public final zzgz zzcq(String str) {
        if (zzcp(str)) {
            return zzaug.get(str);
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51);
        sb2.append("Native Method ");
        sb2.append(str);
        sb2.append(" is not defined for type ListWrapper.");
        throw new IllegalStateException(sb2.toString());
    }

    public final Iterator<zzoa<?>> zzmf() {
        return new zzoj(this, new zzoi(this), super.zzmg());
    }
}
