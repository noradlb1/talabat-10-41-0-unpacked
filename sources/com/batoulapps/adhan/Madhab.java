package com.batoulapps.adhan;

import com.batoulapps.adhan.internal.ShadowLength;

public enum Madhab {
    SHAFI,
    HANAFI;

    /* renamed from: com.batoulapps.adhan.Madhab$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43252a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.batoulapps.adhan.Madhab[] r0 = com.batoulapps.adhan.Madhab.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f43252a = r0
                com.batoulapps.adhan.Madhab r1 = com.batoulapps.adhan.Madhab.SHAFI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f43252a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.batoulapps.adhan.Madhab r1 = com.batoulapps.adhan.Madhab.HANAFI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.batoulapps.adhan.Madhab.AnonymousClass1.<clinit>():void");
        }
    }

    public ShadowLength a() {
        int i11 = AnonymousClass1.f43252a[ordinal()];
        if (i11 == 1) {
            return ShadowLength.SINGLE;
        }
        if (i11 == 2) {
            return ShadowLength.DOUBLE;
        }
        throw new IllegalArgumentException("Invalid Madhab");
    }
}
