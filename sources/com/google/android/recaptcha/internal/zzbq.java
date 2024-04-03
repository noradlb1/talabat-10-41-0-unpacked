package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class zzbq implements zzca {
    @NotNull
    public static final zzbq zza = new zzbq();

    private zzbq() {
    }

    private static final boolean zzb(List list) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((zznl) it.next()).zzM()));
        }
        if (!arrayList.contains(Boolean.FALSE)) {
            return true;
        }
        return false;
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        if (zzb(ArraysKt___ArraysKt.toList((T[]) zznlArr))) {
            for (zznl zzi : zznlArr) {
                zzbh.zze().zzb(zzi.zzi());
            }
            return;
        }
        throw new zzs(4, 5, (Throwable) null);
    }
}
