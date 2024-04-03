package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class zzahj {
    protected static final Comparator<byte[]> zza = new zzahi();
    private final List<byte[]> zzb = new ArrayList();
    private final List<byte[]> zzc = new ArrayList(64);
    private int zzd = 0;

    public zzahj(int i11) {
    }

    private final synchronized void zzc() {
        while (this.zzd > 4096) {
            byte[] remove = this.zzb.remove(0);
            this.zzc.remove(remove);
            this.zzd -= remove.length;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(byte[] r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 == 0) goto L_0x002d
            int r0 = r4.length     // Catch:{ all -> 0x002a }
            r1 = 4096(0x1000, float:5.74E-42)
            if (r0 <= r1) goto L_0x0009
            goto L_0x002d
        L_0x0009:
            java.util.List<byte[]> r1 = r3.zzb     // Catch:{ all -> 0x002a }
            r1.add(r4)     // Catch:{ all -> 0x002a }
            java.util.List<byte[]> r1 = r3.zzc     // Catch:{ all -> 0x002a }
            java.util.Comparator<byte[]> r2 = zza     // Catch:{ all -> 0x002a }
            int r1 = java.util.Collections.binarySearch(r1, r4, r2)     // Catch:{ all -> 0x002a }
            if (r1 >= 0) goto L_0x001b
            int r1 = -r1
            int r1 = r1 + -1
        L_0x001b:
            java.util.List<byte[]> r2 = r3.zzc     // Catch:{ all -> 0x002a }
            r2.add(r1, r4)     // Catch:{ all -> 0x002a }
            int r4 = r3.zzd     // Catch:{ all -> 0x002a }
            int r4 = r4 + r0
            r3.zzd = r4     // Catch:{ all -> 0x002a }
            r3.zzc()     // Catch:{ all -> 0x002a }
            monitor-exit(r3)
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x002d:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahj.zza(byte[]):void");
    }

    public final synchronized byte[] zzb(int i11) {
        for (int i12 = 0; i12 < this.zzc.size(); i12++) {
            byte[] bArr = this.zzc.get(i12);
            int length = bArr.length;
            if (length >= i11) {
                this.zzd -= length;
                this.zzc.remove(i12);
                this.zzb.remove(bArr);
                return bArr;
            }
        }
        return new byte[i11];
    }
}
