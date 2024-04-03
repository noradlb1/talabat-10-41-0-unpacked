package com.apptimize;

import com.apptimize.cv;
import java.util.List;

public class cu extends ct<bw, cv> {

    /* renamed from: a  reason: collision with root package name */
    private final bb f41707a;

    public cu(bb bbVar) {
        super(bw.class, cv.a());
        this.f41707a = bbVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(java.util.List<com.apptimize.az> r2, com.apptimize.bb r3) {
        /*
            r0 = 1
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.Iterator r2 = r2.iterator()
        L_0x0008:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x0022
            java.lang.Object r1 = r2.next()
            com.apptimize.az r1 = (com.apptimize.az) r1
            java.lang.Boolean r1 = r1.b((com.apptimize.bb) r3)
            if (r1 == 0) goto L_0x0020
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0008
        L_0x0020:
            r2 = 0
            return r2
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.cu.b(java.util.List, com.apptimize.bb):boolean");
    }

    public boolean c() {
        return ((cv) a()).f41710c;
    }

    public boolean d() {
        return ((cv) a()).f41709b;
    }

    public cv a(bw bwVar) {
        boolean a11 = a(bwVar.c(), this.f41707a);
        boolean b11 = b(bwVar.b(), this.f41707a);
        boolean b12 = b();
        if (a11) {
            b12 = false;
        }
        if (!a11 && !b11) {
            b12 = true;
        }
        return new cv(b12 ? cv.c.REQUIRES_OVERRIDE : cv.c.NO_REQUIRED_OVERRIDE, a11 ? cv.b.IS_OVERRIDDEN : cv.b.NOT_OVERRIDDEN, b11 ? cv.a.FILTERS_PASSED : cv.a.FILTERS_FAILED);
    }

    public boolean b() {
        return ((cv) a()).f41708a;
    }

    private static boolean a(List<az> list, bb bbVar) {
        for (az b11 : list) {
            Boolean b12 = b11.b(bbVar);
            if (b12 != null && b12.booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
