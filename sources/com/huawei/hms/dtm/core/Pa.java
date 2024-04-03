package com.huawei.hms.dtm.core;

public class Pa extends Y {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
        if (r0.equals("i") == false) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.dtm.core.C0435sc<?> a(com.huawei.hms.dtm.core.X r7, java.util.List<com.huawei.hms.dtm.core.C0435sc<?>> r8) throws com.huawei.hms.dtm.core.V {
        /*
            r6 = this;
            java.lang.String r0 = "__log#params error"
            if (r8 == 0) goto L_0x00a7
            if (r7 == 0) goto L_0x00a7
            int r7 = r8.size()
            r1 = 2
            if (r7 != r1) goto L_0x00a1
            r7 = 0
            java.lang.Object r2 = r8.get(r7)
            if (r2 == 0) goto L_0x00a1
            r2 = 1
            java.lang.Object r3 = r8.get(r2)
            if (r3 == 0) goto L_0x00a1
            java.lang.Object r0 = r8.get(r7)
            com.huawei.hms.dtm.core.sc r0 = (com.huawei.hms.dtm.core.C0435sc) r0
            java.lang.Object r8 = r8.get(r2)
            com.huawei.hms.dtm.core.sc r8 = (com.huawei.hms.dtm.core.C0435sc) r8
            boolean r3 = r0 instanceof com.huawei.hms.dtm.core.Cc
            java.lang.String r4 = "__log#wrong params.The 1st param must be v/d/i/w/e"
            if (r3 == 0) goto L_0x009b
            com.huawei.hms.dtm.core.Cc r0 = (com.huawei.hms.dtm.core.Cc) r0
            java.lang.Object r0 = r0.value()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r8 = r8.toString()
            r0.hashCode()
            int r3 = r0.hashCode()
            r5 = -1
            switch(r3) {
                case 100: goto L_0x0070;
                case 101: goto L_0x0065;
                case 105: goto L_0x005c;
                case 118: goto L_0x0051;
                case 119: goto L_0x0046;
                default: goto L_0x0044;
            }
        L_0x0044:
            r1 = r5
            goto L_0x007a
        L_0x0046:
            java.lang.String r7 = "w"
            boolean r7 = r0.equals(r7)
            if (r7 != 0) goto L_0x004f
            goto L_0x0044
        L_0x004f:
            r1 = 4
            goto L_0x007a
        L_0x0051:
            java.lang.String r7 = "v"
            boolean r7 = r0.equals(r7)
            if (r7 != 0) goto L_0x005a
            goto L_0x0044
        L_0x005a:
            r1 = 3
            goto L_0x007a
        L_0x005c:
            java.lang.String r7 = "i"
            boolean r7 = r0.equals(r7)
            if (r7 != 0) goto L_0x007a
            goto L_0x0044
        L_0x0065:
            java.lang.String r7 = "e"
            boolean r7 = r0.equals(r7)
            if (r7 != 0) goto L_0x006e
            goto L_0x0044
        L_0x006e:
            r1 = r2
            goto L_0x007a
        L_0x0070:
            java.lang.String r1 = "d"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0079
            goto L_0x0044
        L_0x0079:
            r1 = r7
        L_0x007a:
            java.lang.String r7 = "DTM-Execute"
            switch(r1) {
                case 0: goto L_0x0095;
                case 1: goto L_0x0091;
                case 2: goto L_0x008d;
                case 3: goto L_0x0089;
                case 4: goto L_0x0085;
                default: goto L_0x007f;
            }
        L_0x007f:
            com.huawei.hms.dtm.core.V r7 = new com.huawei.hms.dtm.core.V
            r7.<init>(r4)
            throw r7
        L_0x0085:
            com.huawei.hms.dtm.core.util.Logger.warn(r7, r8)
            goto L_0x0098
        L_0x0089:
            com.huawei.hms.dtm.core.util.Logger.verbose(r7, r8)
            goto L_0x0098
        L_0x008d:
            com.huawei.hms.dtm.core.util.Logger.info(r7, r8)
            goto L_0x0098
        L_0x0091:
            com.huawei.hms.dtm.core.util.Logger.error(r7, r8)
            goto L_0x0098
        L_0x0095:
            com.huawei.hms.dtm.core.util.Logger.debug(r7, r8)
        L_0x0098:
            com.huawei.hms.dtm.core.Ec r7 = com.huawei.hms.dtm.core.Ec.f48288a
            return r7
        L_0x009b:
            com.huawei.hms.dtm.core.V r7 = new com.huawei.hms.dtm.core.V
            r7.<init>(r4)
            throw r7
        L_0x00a1:
            com.huawei.hms.dtm.core.V r7 = new com.huawei.hms.dtm.core.V
            r7.<init>(r0)
            throw r7
        L_0x00a7:
            com.huawei.hms.dtm.core.V r7 = new com.huawei.hms.dtm.core.V
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.Pa.a(com.huawei.hms.dtm.core.X, java.util.List):com.huawei.hms.dtm.core.sc");
    }

    public String a() {
        return "__log";
    }
}
