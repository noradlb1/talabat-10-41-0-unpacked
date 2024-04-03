package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public class zzfd {
    private static zzfd zzaoq;
    private volatile String zzaec = null;
    private volatile String zzais = null;
    private volatile int zzaor = zza.zzaos;

    /* 'enum' modifier removed */
    public static final class zza {
        public static final int zzaos = 1;
        public static final int zzaot = 2;
        private static final /* synthetic */ int[] zzaou = {1, 2};
    }

    @VisibleForTesting
    public static zzfd zzkr() {
        zzfd zzfd;
        synchronized (zzfd.class) {
            if (zzaoq == null) {
                zzaoq = new zzfd();
            }
            zzfd = zzaoq;
        }
        return zzfd;
    }

    public final String getContainerId() {
        return this.zzaec;
    }

    public final boolean isPreview() {
        return this.zzaor == zza.zzaot;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b2, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zza(java.lang.String r6, android.net.Uri r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            java.lang.String r1 = r7.toString()     // Catch:{ UnsupportedEncodingException -> 0x00e6 }
            java.lang.String r2 = "UTF-8"
            java.lang.String r1 = java.net.URLDecoder.decode(r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x00e6 }
            java.lang.String r2 = "^tagmanager.c.\\S+:\\/\\/preview\\/p\\S+"
            boolean r2 = r1.matches(r2)     // Catch:{ all -> 0x00e4 }
            if (r2 != 0) goto L_0x002c
            java.lang.String r6 = "Bad preview url: "
            int r7 = r1.length()     // Catch:{ all -> 0x00e4 }
            if (r7 == 0) goto L_0x0021
            java.lang.String r6 = r6.concat(r1)     // Catch:{ all -> 0x00e4 }
            goto L_0x0027
        L_0x0021:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x00e4 }
            r7.<init>(r6)     // Catch:{ all -> 0x00e4 }
            r6 = r7
        L_0x0027:
            com.google.android.gms.internal.gtm.zzev.zzac(r6)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r5)
            return r0
        L_0x002c:
            java.lang.String r2 = "id"
            java.lang.String r2 = r7.getQueryParameter(r2)     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = "gtm_auth"
            java.lang.String r3 = r7.getQueryParameter(r3)     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "gtm_preview"
            java.lang.String r4 = r7.getQueryParameter(r4)     // Catch:{ all -> 0x00e4 }
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x00e4 }
            if (r6 != 0) goto L_0x004b
            java.lang.String r6 = "Preview fails (container doesn't match the container specified by the asset)"
            com.google.android.gms.internal.gtm.zzev.zzac(r6)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r5)
            return r0
        L_0x004b:
            if (r2 == 0) goto L_0x00cc
            int r6 = r2.length()     // Catch:{ all -> 0x00e4 }
            if (r6 <= 0) goto L_0x00cc
            if (r4 == 0) goto L_0x0095
            int r6 = r4.length()     // Catch:{ all -> 0x00e4 }
            if (r6 != 0) goto L_0x0095
            java.lang.String r6 = r5.zzaec     // Catch:{ all -> 0x00e4 }
            boolean r6 = r2.equals(r6)     // Catch:{ all -> 0x00e4 }
            if (r6 == 0) goto L_0x008e
            int r6 = r5.zzaor     // Catch:{ all -> 0x00e4 }
            int r7 = com.google.android.gms.internal.gtm.zzfd.zza.zzaos     // Catch:{ all -> 0x00e4 }
            if (r6 != r7) goto L_0x006a
            goto L_0x008e
        L_0x006a:
            java.lang.String r6 = "Exit preview mode for container: "
            java.lang.String r0 = r5.zzaec     // Catch:{ all -> 0x00e4 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00e4 }
            int r1 = r0.length()     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x007d
            java.lang.String r6 = r6.concat(r0)     // Catch:{ all -> 0x00e4 }
            goto L_0x0083
        L_0x007d:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x00e4 }
            r0.<init>(r6)     // Catch:{ all -> 0x00e4 }
            r6 = r0
        L_0x0083:
            com.google.android.gms.internal.gtm.zzev.zzab(r6)     // Catch:{ all -> 0x00e4 }
            r5.zzaor = r7     // Catch:{ all -> 0x00e4 }
            r6 = 0
            r5.zzaec = r6     // Catch:{ all -> 0x00e4 }
            r5.zzais = r6     // Catch:{ all -> 0x00e4 }
            goto L_0x00b1
        L_0x008e:
            java.lang.String r6 = "Error in exiting preview mode. The container is not in preview."
            com.google.android.gms.internal.gtm.zzev.zzac(r6)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r5)
            return r0
        L_0x0095:
            if (r4 == 0) goto L_0x00b4
            int r6 = r4.length()     // Catch:{ all -> 0x00e4 }
            if (r6 <= 0) goto L_0x00b4
            if (r3 == 0) goto L_0x00b4
            int r6 = r3.length()     // Catch:{ all -> 0x00e4 }
            if (r6 <= 0) goto L_0x00b4
            int r6 = com.google.android.gms.internal.gtm.zzfd.zza.zzaot     // Catch:{ all -> 0x00e4 }
            r5.zzaor = r6     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = r7.getQuery()     // Catch:{ all -> 0x00e4 }
            r5.zzais = r6     // Catch:{ all -> 0x00e4 }
            r5.zzaec = r2     // Catch:{ all -> 0x00e4 }
        L_0x00b1:
            monitor-exit(r5)
            r6 = 1
            return r6
        L_0x00b4:
            java.lang.String r6 = "Bad preview url: "
            int r7 = r1.length()     // Catch:{ all -> 0x00e4 }
            if (r7 == 0) goto L_0x00c1
            java.lang.String r6 = r6.concat(r1)     // Catch:{ all -> 0x00e4 }
            goto L_0x00c7
        L_0x00c1:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x00e4 }
            r7.<init>(r6)     // Catch:{ all -> 0x00e4 }
            r6 = r7
        L_0x00c7:
            com.google.android.gms.internal.gtm.zzev.zzac(r6)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r5)
            return r0
        L_0x00cc:
            java.lang.String r6 = "Bad preview url: "
            int r7 = r1.length()     // Catch:{ all -> 0x00e4 }
            if (r7 == 0) goto L_0x00d9
            java.lang.String r6 = r6.concat(r1)     // Catch:{ all -> 0x00e4 }
            goto L_0x00df
        L_0x00d9:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x00e4 }
            r7.<init>(r6)     // Catch:{ all -> 0x00e4 }
            r6 = r7
        L_0x00df:
            com.google.android.gms.internal.gtm.zzev.zzac(r6)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r5)
            return r0
        L_0x00e4:
            r6 = move-exception
            goto L_0x0107
        L_0x00e6:
            r6 = move-exception
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x00e4 }
            int r7 = r6.length()     // Catch:{ all -> 0x00e4 }
            int r7 = r7 + 32
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r1.<init>(r7)     // Catch:{ all -> 0x00e4 }
            java.lang.String r7 = "Error decoding the preview url: "
            r1.append(r7)     // Catch:{ all -> 0x00e4 }
            r1.append(r6)     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x00e4 }
            com.google.android.gms.internal.gtm.zzev.zzac(r6)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r5)
            return r0
        L_0x0107:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfd.zza(java.lang.String, android.net.Uri):boolean");
    }

    public final boolean zzbw(String str) {
        if (!isPreview() || !this.zzaec.equals(str)) {
            return false;
        }
        return true;
    }

    public final String zzks() {
        return this.zzais;
    }
}
