package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahp  reason: invalid package */
final class zzahp extends zzaht {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzahp() {
        super((zzahs) null);
    }

    public /* synthetic */ zzahp(zzaho zzaho) {
        super((zzahs) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.firebase-auth-api.zzahm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.firebase-auth-api.zzahm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.firebase-auth-api.zzahm} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List zzf(java.lang.Object r3, long r4, int r6) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r3, r4)
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002f
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzahn
            if (r1 == 0) goto L_0x0016
            com.google.android.gms.internal.firebase-auth-api.zzahm r0 = new com.google.android.gms.internal.firebase-auth-api.zzahm
            r0.<init>((int) r6)
            goto L_0x002b
        L_0x0016:
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzaim
            if (r1 == 0) goto L_0x0026
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzahf
            if (r1 == 0) goto L_0x0026
            com.google.android.gms.internal.firebase-auth-api.zzahf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzahf) r0
            com.google.android.gms.internal.firebase-auth-api.zzahf r6 = r0.zzd(r6)
            r0 = r6
            goto L_0x002b
        L_0x0026:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x002b:
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r3, r4, r0)
            goto L_0x0087
        L_0x002f:
            java.lang.Class r1 = zza
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004d
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r3, r4, r1)
        L_0x004b:
            r0 = r1
            goto L_0x0087
        L_0x004d:
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzajq
            if (r1 == 0) goto L_0x0068
            com.google.android.gms.internal.firebase-auth-api.zzahm r1 = new com.google.android.gms.internal.firebase-auth-api.zzahm
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.firebase-auth-api.zzajq r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzajq) r0
            int r6 = r1.size()
            r1.addAll(r6, r0)
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r3, r4, r1)
            goto L_0x004b
        L_0x0068:
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzaim
            if (r1 == 0) goto L_0x0087
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzahf
            if (r1 == 0) goto L_0x0087
            r1 = r0
            com.google.android.gms.internal.firebase-auth-api.zzahf r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzahf) r1
            boolean r2 = r1.zzc()
            if (r2 == 0) goto L_0x007a
            goto L_0x0087
        L_0x007a:
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.firebase-auth-api.zzahf r6 = r1.zzd(r0)
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r3, r4, r6)
            return r6
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzahp.zzf(java.lang.Object, long, int):java.util.List");
    }

    public final List zza(Object obj, long j11) {
        return zzf(obj, j11, 10);
    }

    public final void zzb(Object obj, long j11) {
        Object obj2;
        List list = (List) zzajv.zzf(obj, j11);
        if (list instanceof zzahn) {
            obj2 = ((zzahn) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzaim) || !(list instanceof zzahf)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzahf zzahf = (zzahf) list;
                if (zzahf.zzc()) {
                    zzahf.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzajv.zzs(obj, j11, obj2);
    }

    public final void zzc(Object obj, Object obj2, long j11) {
        List list = (List) zzajv.zzf(obj2, j11);
        List zzf = zzf(obj, j11, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzajv.zzs(obj, j11, list);
    }
}
