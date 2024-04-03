package com.uxcam.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.uxcam.internals.dc;
import com.uxcam.internals.gc;
import com.uxcam.internals.gk;
import com.uxcam.internals.gu;
import com.uxcam.internals.ia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HttpPostService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f13678a = false;

    /* renamed from: b  reason: collision with root package name */
    public static List f13679b = Collections.synchronizedList(new ArrayList());

    public final class aa extends Handler {
        public aa(HttpPostService httpPostService, Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            String string = message.getData().getString("arg_which_service");
            boolean z11 = HttpPostService.f13678a;
            gu.a("HttpPostService").getClass();
            string.getClass();
            char c11 = 65535;
            switch (string.hashCode()) {
                case 666429405:
                    if (string.equals("send_offline_data")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 901710240:
                    if (string.equals("stop_foreground")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1586837812:
                    if (string.equals("screen_upload")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1592315741:
                    if (string.equals("value_stop_uxcam")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    new gc(ia.f13617c).b();
                    return;
                case 1:
                    gu.a("HttpPostService").getClass();
                    return;
                case 2:
                    try {
                        new dc(ia.f13617c).a();
                        return;
                    } catch (Exception unused) {
                        boolean z12 = HttpPostService.f13678a;
                        gu.a("HttpPostService").getClass();
                        return;
                    }
                case 3:
                    gk.a().a(ia.f13617c, "");
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        a(r4);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(java.io.File r4) {
        /*
            java.lang.Class<com.uxcam.service.HttpPostService> r0 = com.uxcam.service.HttpPostService.class
            monitor-enter(r0)
            java.util.List r1 = f13679b     // Catch:{ ConcurrentModificationException -> 0x0027 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ ConcurrentModificationException -> 0x0027 }
        L_0x0009:
            boolean r2 = r1.hasNext()     // Catch:{ ConcurrentModificationException -> 0x0027 }
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r1.next()     // Catch:{ ConcurrentModificationException -> 0x0027 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ ConcurrentModificationException -> 0x0027 }
            java.lang.String r3 = r4.getAbsolutePath()     // Catch:{ ConcurrentModificationException -> 0x0027 }
            boolean r3 = r3.equals(r2)     // Catch:{ ConcurrentModificationException -> 0x0027 }
            if (r3 == 0) goto L_0x0009
            java.util.List r3 = f13679b     // Catch:{ ConcurrentModificationException -> 0x0027 }
            r3.remove(r2)     // Catch:{ ConcurrentModificationException -> 0x0027 }
            goto L_0x0009
        L_0x0025:
            r4 = move-exception
            goto L_0x002c
        L_0x0027:
            a(r4)     // Catch:{ all -> 0x0025 }
        L_0x002a:
            monitor-exit(r0)
            return
        L_0x002c:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.service.HttpPostService.a(java.io.File):void");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e11) {
            e11.printStackTrace();
        }
        f13678a = false;
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        if (!(intent == null || intent.getExtras() == null)) {
            f13678a = true;
            String string = intent.getExtras().getString("arg_which_service");
            if (string != null && !string.equalsIgnoreCase("stop_foreground")) {
                HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
                handlerThread.start();
                aa aaVar = new aa(this, handlerThread.getLooper());
                Message obtainMessage = aaVar.obtainMessage();
                obtainMessage.arg1 = i12;
                obtainMessage.setData(intent.getExtras());
                aaVar.sendMessage(obtainMessage);
            }
        }
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        stopSelf();
    }
}
