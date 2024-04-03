package com.apptimize;

public class fe {
    public static void a(String str, fi fiVar) {
        a(str, fiVar, true);
    }

    public static void a(String str, fi fiVar, boolean z11) {
        a(str, fiVar, "Apptimize threw an exception which wasn't caught; this should not have happened.", z11);
    }

    public static void a(String str, fi fiVar, String str2) {
        a(str, fiVar, str2, true);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x004b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r3, com.apptimize.fi r4, java.lang.String r5, boolean r6) {
        /*
            java.lang.String r6 = "Apptimize: Internal Error %s"
            r0 = 0
            r1 = 1
            com.apptimize.bs r2 = com.apptimize.bs.f41454a     // Catch:{ RuntimeException -> 0x0068, NoClassDefFoundError -> 0x005d, NoSuchMethodError -> 0x004b, NoSuchFieldError -> 0x0039, Error -> 0x0015 }
            if (r2 == 0) goto L_0x000b
            r2.a((java.lang.Object) r4)     // Catch:{ RuntimeException -> 0x0068, NoClassDefFoundError -> 0x005d, NoSuchMethodError -> 0x004b, NoSuchFieldError -> 0x0039, Error -> 0x0015 }
        L_0x000b:
            r4.run()     // Catch:{ RuntimeException -> 0x0068, NoClassDefFoundError -> 0x005d, NoSuchMethodError -> 0x004b, NoSuchFieldError -> 0x0039, Error -> 0x0015 }
            com.apptimize.bs r3 = com.apptimize.bs.f41454a
            if (r3 == 0) goto L_0x0073
            goto L_0x0070
        L_0x0013:
            r3 = move-exception
            goto L_0x0074
        L_0x0015:
            r4 = move-exception
            java.lang.Class r5 = r4.getClass()     // Catch:{ all -> 0x0013 }
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0013 }
            java.lang.String r2 = "UnsatisfiedLinkError"
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x0013 }
            if (r5 == 0) goto L_0x0038
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0013 }
            java.lang.String r5 = "AN1000"
            r4[r0] = r5     // Catch:{ all -> 0x0013 }
            java.lang.String r4 = java.lang.String.format(r6, r4)     // Catch:{ all -> 0x0013 }
            com.apptimize.bo.j(r3, r4)     // Catch:{ all -> 0x0013 }
            com.apptimize.bs r3 = com.apptimize.bs.f41454a
            if (r3 == 0) goto L_0x0073
            goto L_0x0070
        L_0x0038:
            throw r4     // Catch:{ all -> 0x0013 }
        L_0x0039:
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0013 }
            java.lang.String r5 = "AN1004"
            r4[r0] = r5     // Catch:{ all -> 0x0013 }
            java.lang.String r4 = java.lang.String.format(r6, r4)     // Catch:{ all -> 0x0013 }
            com.apptimize.bo.j(r3, r4)     // Catch:{ all -> 0x0013 }
            com.apptimize.bs r3 = com.apptimize.bs.f41454a
            if (r3 == 0) goto L_0x0073
            goto L_0x0070
        L_0x004b:
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0013 }
            java.lang.String r5 = "AN1003"
            r4[r0] = r5     // Catch:{ all -> 0x0013 }
            java.lang.String r4 = java.lang.String.format(r6, r4)     // Catch:{ all -> 0x0013 }
            com.apptimize.bo.j(r3, r4)     // Catch:{ all -> 0x0013 }
            com.apptimize.bs r3 = com.apptimize.bs.f41454a
            if (r3 == 0) goto L_0x0073
            goto L_0x0070
        L_0x005d:
            r4 = move-exception
            java.lang.String r5 = "Apptimize threw an exception which wasn't caught; this should not have happened"
            com.apptimize.bo.g(r3, r5, r4)     // Catch:{ all -> 0x0013 }
            com.apptimize.bs r3 = com.apptimize.bs.f41454a
            if (r3 == 0) goto L_0x0073
            goto L_0x0070
        L_0x0068:
            r4 = move-exception
            com.apptimize.bo.g(r3, r5, r4)     // Catch:{ all -> 0x0013 }
            com.apptimize.bs r3 = com.apptimize.bs.f41454a
            if (r3 == 0) goto L_0x0073
        L_0x0070:
            r3.a()
        L_0x0073:
            return
        L_0x0074:
            com.apptimize.bs r4 = com.apptimize.bs.f41454a
            if (r4 == 0) goto L_0x007b
            r4.a()
        L_0x007b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.fe.a(java.lang.String, com.apptimize.fi, java.lang.String, boolean):void");
    }

    public static <T> T a(String str, T t11, fk<T> fkVar) {
        return a(str, t11, fkVar, true);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x005e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T a(java.lang.String r5, T r6, com.apptimize.fk<T> r7, boolean r8) {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = "Apptimize: Internal Error %s"
            if (r8 == 0) goto L_0x000d
            com.apptimize.bs r3 = com.apptimize.bs.f41454a     // Catch:{ RuntimeException -> 0x0085, NoClassDefFoundError -> 0x0075, NoSuchMethodError -> 0x005e, NoSuchFieldError -> 0x0047, Error -> 0x001e }
            if (r3 == 0) goto L_0x000d
            r3.a((java.lang.Object) r7)     // Catch:{ RuntimeException -> 0x0085, NoClassDefFoundError -> 0x0075, NoSuchMethodError -> 0x005e, NoSuchFieldError -> 0x0047, Error -> 0x001e }
        L_0x000d:
            java.lang.Object r5 = r7.b()     // Catch:{ RuntimeException -> 0x0085, NoClassDefFoundError -> 0x0075, NoSuchMethodError -> 0x005e, NoSuchFieldError -> 0x0047, Error -> 0x001e }
            if (r8 == 0) goto L_0x001a
            com.apptimize.bs r6 = com.apptimize.bs.f41454a
            if (r6 == 0) goto L_0x001a
            r6.a()
        L_0x001a:
            return r5
        L_0x001b:
            r5 = move-exception
            goto L_0x0095
        L_0x001e:
            r7 = move-exception
            java.lang.Class r3 = r7.getClass()     // Catch:{ all -> 0x001b }
            java.lang.String r3 = r3.getSimpleName()     // Catch:{ all -> 0x001b }
            java.lang.String r4 = "UnsatisfiedLinkError"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x001b }
            if (r3 == 0) goto L_0x0046
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x001b }
            java.lang.String r1 = "AN1000"
            r7[r0] = r1     // Catch:{ all -> 0x001b }
            java.lang.String r7 = java.lang.String.format(r2, r7)     // Catch:{ all -> 0x001b }
            com.apptimize.bo.j(r5, r7)     // Catch:{ all -> 0x001b }
            if (r8 == 0) goto L_0x0045
            com.apptimize.bs r5 = com.apptimize.bs.f41454a
            if (r5 == 0) goto L_0x0045
            r5.a()
        L_0x0045:
            return r6
        L_0x0046:
            throw r7     // Catch:{ all -> 0x001b }
        L_0x0047:
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x001b }
            java.lang.String r1 = "AN1004"
            r7[r0] = r1     // Catch:{ all -> 0x001b }
            java.lang.String r7 = java.lang.String.format(r2, r7)     // Catch:{ all -> 0x001b }
            com.apptimize.bo.j(r5, r7)     // Catch:{ all -> 0x001b }
            if (r8 == 0) goto L_0x005d
            com.apptimize.bs r5 = com.apptimize.bs.f41454a
            if (r5 == 0) goto L_0x005d
            r5.a()
        L_0x005d:
            return r6
        L_0x005e:
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x001b }
            java.lang.String r1 = "AN1003"
            r7[r0] = r1     // Catch:{ all -> 0x001b }
            java.lang.String r7 = java.lang.String.format(r2, r7)     // Catch:{ all -> 0x001b }
            com.apptimize.bo.j(r5, r7)     // Catch:{ all -> 0x001b }
            if (r8 == 0) goto L_0x0074
            com.apptimize.bs r5 = com.apptimize.bs.f41454a
            if (r5 == 0) goto L_0x0074
            r5.a()
        L_0x0074:
            return r6
        L_0x0075:
            r7 = move-exception
            java.lang.String r0 = "Apptimize threw an exception which wasn't caught; this should not have happened"
            com.apptimize.bo.g(r5, r0, r7)     // Catch:{ all -> 0x001b }
            if (r8 == 0) goto L_0x0084
            com.apptimize.bs r5 = com.apptimize.bs.f41454a
            if (r5 == 0) goto L_0x0084
            r5.a()
        L_0x0084:
            return r6
        L_0x0085:
            r7 = move-exception
            java.lang.String r0 = "Apptimize threw an exception which wasn't caught; this should not have happened."
            com.apptimize.bo.g(r5, r0, r7)     // Catch:{ all -> 0x001b }
            if (r8 == 0) goto L_0x0094
            com.apptimize.bs r5 = com.apptimize.bs.f41454a
            if (r5 == 0) goto L_0x0094
            r5.a()
        L_0x0094:
            return r6
        L_0x0095:
            if (r8 == 0) goto L_0x009e
            com.apptimize.bs r6 = com.apptimize.bs.f41454a
            if (r6 == 0) goto L_0x009e
            r6.a()
        L_0x009e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.fe.a(java.lang.String, java.lang.Object, com.apptimize.fk, boolean):java.lang.Object");
    }
}
