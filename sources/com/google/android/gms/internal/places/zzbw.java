package com.google.android.gms.internal.places;

import java.util.Collections;
import java.util.List;

final class zzbw extends zzbu {
    private static final Class<?> zzkd = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzbw() {
        super();
    }

    private static <E> List<E> zzd(Object obj, long j11) {
        return (List) zzdy.zzp(obj, j11);
    }

    public final void zzb(Object obj, long j11) {
        Object obj2;
        List list = (List) zzdy.zzp(obj, j11);
        if (list instanceof zzbr) {
            obj2 = ((zzbr) list).zzbz();
        } else if (!zzkd.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzcw) || !(list instanceof zzbh)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzbh zzbh = (zzbh) list;
                if (zzbh.zzaa()) {
                    zzbh.zzab();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzdy.zzb(obj, j11, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.internal.places.zzbs} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: com.google.android.gms.internal.places.zzbs} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: com.google.android.gms.internal.places.zzbs} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E> void zzb(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.util.List r6 = zzd(r6, r7)
            int r0 = r6.size()
            java.util.List r1 = zzd(r5, r7)
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0035
            boolean r2 = r1 instanceof com.google.android.gms.internal.places.zzbr
            if (r2 == 0) goto L_0x001c
            com.google.android.gms.internal.places.zzbs r1 = new com.google.android.gms.internal.places.zzbs
            r1.<init>((int) r0)
            goto L_0x0031
        L_0x001c:
            boolean r2 = r1 instanceof com.google.android.gms.internal.places.zzcw
            if (r2 == 0) goto L_0x002c
            boolean r2 = r1 instanceof com.google.android.gms.internal.places.zzbh
            if (r2 == 0) goto L_0x002c
            com.google.android.gms.internal.places.zzbh r1 = (com.google.android.gms.internal.places.zzbh) r1
            com.google.android.gms.internal.places.zzbh r0 = r1.zzh(r0)
            r1 = r0
            goto L_0x0031
        L_0x002c:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L_0x0031:
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r5, (long) r7, (java.lang.Object) r1)
            goto L_0x0087
        L_0x0035:
            java.lang.Class<?> r2 = zzkd
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x0053
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r5, (long) r7, (java.lang.Object) r2)
        L_0x0051:
            r1 = r2
            goto L_0x0087
        L_0x0053:
            boolean r2 = r1 instanceof com.google.android.gms.internal.places.zzdt
            if (r2 == 0) goto L_0x006a
            com.google.android.gms.internal.places.zzbs r2 = new com.google.android.gms.internal.places.zzbs
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>((int) r3)
            com.google.android.gms.internal.places.zzdt r1 = (com.google.android.gms.internal.places.zzdt) r1
            r2.addAll(r1)
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r5, (long) r7, (java.lang.Object) r2)
            goto L_0x0051
        L_0x006a:
            boolean r2 = r1 instanceof com.google.android.gms.internal.places.zzcw
            if (r2 == 0) goto L_0x0087
            boolean r2 = r1 instanceof com.google.android.gms.internal.places.zzbh
            if (r2 == 0) goto L_0x0087
            r2 = r1
            com.google.android.gms.internal.places.zzbh r2 = (com.google.android.gms.internal.places.zzbh) r2
            boolean r3 = r2.zzaa()
            if (r3 != 0) goto L_0x0087
            int r1 = r1.size()
            int r1 = r1 + r0
            com.google.android.gms.internal.places.zzbh r1 = r2.zzh(r1)
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r5, (long) r7, (java.lang.Object) r1)
        L_0x0087:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L_0x0096
            if (r2 <= 0) goto L_0x0096
            r1.addAll(r6)
        L_0x0096:
            if (r0 <= 0) goto L_0x0099
            r6 = r1
        L_0x0099:
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r5, (long) r7, (java.lang.Object) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzbw.zzb(java.lang.Object, java.lang.Object, long):void");
    }
}
