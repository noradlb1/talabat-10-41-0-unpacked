package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzgjq extends IOException {
    public zzgjq() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzgjq(java.lang.String r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r0 = r3.length()
            java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
            if (r0 == 0) goto L_0x0011
            java.lang.String r3 = r1.concat(r3)
            goto L_0x0016
        L_0x0011:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r1)
        L_0x0016:
            r2.<init>(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgjq.<init>(java.lang.String, java.lang.Throwable):void");
    }

    public zzgjq(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
