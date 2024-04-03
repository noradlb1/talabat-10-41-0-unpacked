package com.uxcam;

public class UXCamKtxInternal {
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void occludeComposable(com.uxcam.datamodel.OccludeComposable r5) {
        /*
            java.lang.Class<com.uxcam.internals.ey> r0 = com.uxcam.internals.ey.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x0047 }
            com.uxcam.internals.ey r1 = com.uxcam.internals.ey.f13303b     // Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x000e
            com.uxcam.internals.ey r1 = new com.uxcam.internals.ey     // Catch:{ all -> 0x0044 }
            r1.<init>()     // Catch:{ all -> 0x0044 }
            com.uxcam.internals.ey.f13303b = r1     // Catch:{ all -> 0x0044 }
        L_0x000e:
            com.uxcam.internals.ey r1 = com.uxcam.internals.ey.f13303b     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)     // Catch:{ Exception -> 0x0047 }
            com.uxcam.internals.bf r0 = r1.f13304a     // Catch:{ Exception -> 0x0047 }
            java.util.List r1 = r0.f13062a     // Catch:{ Exception -> 0x0047 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0047 }
        L_0x0019:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0047 }
            if (r2 == 0) goto L_0x003e
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0047 }
            com.uxcam.datamodel.OccludeComposable r2 = (com.uxcam.datamodel.OccludeComposable) r2     // Catch:{ Exception -> 0x0047 }
            java.lang.Object r3 = r2.getIdentifier()     // Catch:{ Exception -> 0x0047 }
            java.lang.Object r4 = r5.getIdentifier()     // Catch:{ Exception -> 0x0047 }
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0047 }
            if (r3 == 0) goto L_0x0019
            java.util.List r1 = r0.f13062a     // Catch:{ Exception -> 0x0047 }
            r1.remove(r2)     // Catch:{ Exception -> 0x0047 }
            java.util.List r0 = r0.f13062a     // Catch:{ Exception -> 0x0047 }
            r0.add(r5)     // Catch:{ Exception -> 0x0047 }
            goto L_0x004b
        L_0x003e:
            java.util.List r0 = r0.f13062a     // Catch:{ Exception -> 0x0047 }
            r0.add(r5)     // Catch:{ Exception -> 0x0047 }
            goto L_0x004b
        L_0x0044:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ Exception -> 0x0047 }
            throw r5     // Catch:{ Exception -> 0x0047 }
        L_0x0047:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.UXCamKtxInternal.occludeComposable(com.uxcam.datamodel.OccludeComposable):void");
    }
}
