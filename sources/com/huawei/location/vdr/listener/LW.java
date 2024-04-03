package com.huawei.location.vdr.listener;

import com.huawei.location.lite.common.log.LogConsole;
import java.util.ArrayList;
import java.util.List;

public class LW {
    private static final byte[] Vw = new byte[0];

    /* renamed from: yn  reason: collision with root package name */
    private static volatile LW f50296yn;
    private List<IVdrLocationListener> FB = new ArrayList(10);

    public static LW yn() {
        if (f50296yn == null) {
            synchronized (Vw) {
                if (f50296yn == null) {
                    f50296yn = new LW();
                }
            }
        }
        return f50296yn;
    }

    private void yn(IVdrLocationListener iVdrLocationListener) {
        synchronized (Vw) {
            if (Vw()) {
                this.FB.add(iVdrLocationListener);
                LogConsole.i("VdrLocationListenerManager", "vdrLocationListenerList is empty, add uuid here, uuid is: " + iVdrLocationListener.getUuid());
                return;
            }
            for (int i11 = 0; i11 < this.FB.size(); i11++) {
                if (this.FB.get(i11).getUuid().equals(iVdrLocationListener.getUuid())) {
                    this.FB.set(i11, iVdrLocationListener);
                    LogConsole.i("VdrLocationListenerManager", "replace uuid here, uuid is: " + iVdrLocationListener.getUuid());
                    return;
                }
            }
            this.FB.add(iVdrLocationListener);
            LogConsole.i("VdrLocationListenerManager", "new add uuid here, uuid is: " + iVdrLocationListener.getUuid());
        }
    }

    public void Vw(IVdrLocationListener iVdrLocationListener) {
        synchronized (Vw) {
            if (iVdrLocationListener != null) {
                if (this.FB == null) {
                    this.FB = new ArrayList();
                }
                yn(iVdrLocationListener);
                LogConsole.i("VdrLocationListenerManager", "add vdrLocationListener to vdrLocationListenerList, size is : " + this.FB.size());
            }
        }
    }

    public boolean Vw() {
        boolean z11;
        synchronized (Vw) {
            List<IVdrLocationListener> list = this.FB;
            if (list != null) {
                if (list.size() != 0) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void yn(android.location.Location r4) {
        /*
            r3 = this;
            byte[] r0 = Vw
            monitor-enter(r0)
            java.util.List<com.huawei.location.vdr.listener.IVdrLocationListener> r1 = r3.FB     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x0027
            int r1 = r1.size()     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0027
        L_0x000e:
            r1 = 0
        L_0x000f:
            java.util.List<com.huawei.location.vdr.listener.IVdrLocationListener> r2 = r3.FB     // Catch:{ all -> 0x0029 }
            int r2 = r2.size()     // Catch:{ all -> 0x0029 }
            if (r1 >= r2) goto L_0x0025
            java.util.List<com.huawei.location.vdr.listener.IVdrLocationListener> r2 = r3.FB     // Catch:{ all -> 0x0029 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0029 }
            com.huawei.location.vdr.listener.IVdrLocationListener r2 = (com.huawei.location.vdr.listener.IVdrLocationListener) r2     // Catch:{ all -> 0x0029 }
            r2.onVdrLocationChanged(r4)     // Catch:{ all -> 0x0029 }
            int r1 = r1 + 1
            goto L_0x000f
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return
        L_0x0029:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.vdr.listener.LW.yn(android.location.Location):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean yn(java.lang.String r6) {
        /*
            r5 = this;
            byte[] r0 = Vw
            monitor-enter(r0)
            r1 = 0
            if (r6 == 0) goto L_0x005d
            java.util.List<com.huawei.location.vdr.listener.IVdrLocationListener> r2 = r5.FB     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x005d
            int r2 = r2.size()     // Catch:{ all -> 0x005b }
            if (r2 != 0) goto L_0x0011
            goto L_0x005d
        L_0x0011:
            java.util.List<com.huawei.location.vdr.listener.IVdrLocationListener> r2 = r5.FB     // Catch:{ all -> 0x005b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x005b }
        L_0x0017:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x005b }
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x005b }
            com.huawei.location.vdr.listener.IVdrLocationListener r3 = (com.huawei.location.vdr.listener.IVdrLocationListener) r3     // Catch:{ all -> 0x005b }
            java.lang.String r4 = r3.getUuid()     // Catch:{ all -> 0x005b }
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x005b }
            if (r4 == 0) goto L_0x0017
            java.util.List<com.huawei.location.vdr.listener.IVdrLocationListener> r1 = r5.FB     // Catch:{ all -> 0x005b }
            r1.remove(r3)     // Catch:{ all -> 0x005b }
            java.lang.String r1 = "VdrLocationListenerManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            r2.<init>()     // Catch:{ all -> 0x005b }
            java.lang.String r3 = "remove vdrLocationListener from vdrLocationListenerList, size is : "
            r2.append(r3)     // Catch:{ all -> 0x005b }
            java.util.List<com.huawei.location.vdr.listener.IVdrLocationListener> r3 = r5.FB     // Catch:{ all -> 0x005b }
            int r3 = r3.size()     // Catch:{ all -> 0x005b }
            r2.append(r3)     // Catch:{ all -> 0x005b }
            java.lang.String r3 = ", uuid is: "
            r2.append(r3)     // Catch:{ all -> 0x005b }
            r2.append(r6)     // Catch:{ all -> 0x005b }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x005b }
            com.huawei.location.lite.common.log.LogConsole.i(r1, r6)     // Catch:{ all -> 0x005b }
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            r6 = 1
            return r6
        L_0x0059:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return r1
        L_0x005b:
            r6 = move-exception
            goto L_0x005f
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return r1
        L_0x005f:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.vdr.listener.LW.yn(java.lang.String):boolean");
    }
}
