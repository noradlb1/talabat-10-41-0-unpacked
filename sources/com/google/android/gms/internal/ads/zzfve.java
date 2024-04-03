package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import javax.annotation.CheckForNull;

abstract class zzfve<V, X extends Throwable, F, T> extends zzfwg<V> implements Runnable {
    @CheckForNull
    zzfxa<? extends V> zza;
    @CheckForNull
    Class<X> zzb;
    @CheckForNull
    F zzc;

    public zzfve(zzfxa<? extends V> zzfxa, Class<X> cls, F f11) {
        zzfxa.getClass();
        this.zza = zzfxa;
        this.zzb = cls;
        f11.getClass();
        this.zzc = f11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzfxa<? extends V> r0 = r10.zza
            java.lang.Class<X> r1 = r10.zzb
            F r2 = r10.zzc
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000c
            r5 = r3
            goto L_0x000d
        L_0x000c:
            r5 = r4
        L_0x000d:
            if (r1 != 0) goto L_0x0011
            r6 = r3
            goto L_0x0012
        L_0x0011:
            r6 = r4
        L_0x0012:
            r5 = r5 | r6
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r3 = r4
        L_0x0017:
            r3 = r3 | r5
            if (r3 != 0) goto L_0x00ad
            boolean r3 = r10.isCancelled()
            if (r3 == 0) goto L_0x0022
            goto L_0x00ad
        L_0x0022:
            r3 = 0
            r10.zza = r3
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzfxs     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            if (r4 == 0) goto L_0x0031
            r4 = r0
            com.google.android.gms.internal.ads.zzfxs r4 = (com.google.android.gms.internal.ads.zzfxs) r4     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            java.lang.Throwable r4 = r4.zzk()     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            goto L_0x0032
        L_0x0031:
            r4 = r3
        L_0x0032:
            if (r4 != 0) goto L_0x003a
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzfwq.zzp(r0)     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            goto L_0x0083
        L_0x0039:
            r4 = move-exception
        L_0x003a:
            r5 = r3
            goto L_0x0083
        L_0x003c:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L_0x0081
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r7 = r6.length()
            int r8 = r4.length()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            int r7 = r7 + 35
            int r7 = r7 + r8
            r9.<init>(r7)
            java.lang.String r7 = "Future type "
            r9.append(r7)
            r9.append(r6)
            java.lang.String r6 = " threw "
            r9.append(r6)
            r9.append(r4)
            java.lang.String r4 = " without a cause"
            r9.append(r4)
            java.lang.String r4 = r9.toString()
            r5.<init>(r4)
        L_0x0081:
            r4 = r5
            goto L_0x003a
        L_0x0083:
            if (r4 != 0) goto L_0x0089
            r10.zzs(r5)
            return
        L_0x0089:
            boolean r1 = r1.isInstance(r4)
            if (r1 == 0) goto L_0x00aa
            java.lang.Object r0 = r10.zza(r2, r4)     // Catch:{ all -> 0x009b }
            r10.zzb = r3
            r10.zzc = r3
            r10.zzb(r0)
            return
        L_0x009b:
            r0 = move-exception
            r10.zzt(r0)     // Catch:{ all -> 0x00a4 }
            r10.zzb = r3
            r10.zzc = r3
            return
        L_0x00a4:
            r0 = move-exception
            r10.zzb = r3
            r10.zzc = r3
            throw r0
        L_0x00aa:
            r10.zzu(r0)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfve.run():void");
    }

    public abstract T zza(F f11, X x11) throws Exception;

    public abstract void zzb(T t11);

    @CheckForNull
    public final String zzd() {
        String str;
        zzfxa<? extends V> zzfxa = this.zza;
        Class<X> cls = this.zzb;
        F f11 = this.zzc;
        String zzd = super.zzd();
        if (zzfxa != null) {
            String obj = zzfxa.toString();
            StringBuilder sb2 = new StringBuilder(obj.length() + 16);
            sb2.append("inputFuture=[");
            sb2.append(obj);
            sb2.append("], ");
            str = sb2.toString();
        } else {
            str = "";
        }
        if (cls != null && f11 != null) {
            String obj2 = cls.toString();
            String obj3 = f11.toString();
            StringBuilder sb3 = new StringBuilder(str.length() + 29 + obj2.length() + obj3.length());
            sb3.append(str);
            sb3.append("exceptionType=[");
            sb3.append(obj2);
            sb3.append("], fallback=[");
            sb3.append(obj3);
            sb3.append("]");
            return sb3.toString();
        } else if (zzd == null) {
            return null;
        } else {
            if (zzd.length() != 0) {
                return str.concat(zzd);
            }
            return new String(str);
        }
    }

    public final void zze() {
        zzq(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }
}
