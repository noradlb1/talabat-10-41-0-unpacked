package com.huawei.location.logic;

import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.location.LocationRequest;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.secure.android.common.intent.SafeBundle;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;

public class d2 {
    private Handler FB;
    private int Vw;

    /* renamed from: yn  reason: collision with root package name */
    private ConcurrentHashMap<com.huawei.location.callback.d2, E5> f50165yn;

    public static class Vw {
        /* access modifiers changed from: private */

        /* renamed from: yn  reason: collision with root package name */
        public static final d2 f50166yn = new d2((yn) null);
    }

    public class yn implements Handler.Callback {
        public yn() {
        }

        public boolean handleMessage(Message message) {
            return d2.a(d2.this, message);
        }
    }

    private d2() {
        this.Vw = 0;
        this.f50165yn = new ConcurrentHashMap<>();
        HandlerThread handlerThread = new HandlerThread("MaxWaitTimeManager");
        handlerThread.start();
        this.FB = new Handler(handlerThread.getLooper(), new yn());
    }

    public /* synthetic */ d2(yn ynVar) {
        this();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005e, code lost:
        r5 = (com.huawei.location.callback.d2) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
        r5 = (com.huawei.location.callback.d2) r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.huawei.location.logic.d2 r4, android.os.Message r5) {
        /*
            r4.getClass()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleMessage msg what:"
            r0.append(r1)
            int r1 = r5.what
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "MaxWaitTimeManager"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r0)
            j$.util.concurrent.ConcurrentHashMap<com.huawei.location.callback.d2, com.huawei.location.logic.E5> r0 = r4.f50165yn
            if (r0 != 0) goto L_0x0021
            goto L_0x00bf
        L_0x0021:
            int r2 = r5.what
            r3 = 2147483636(0x7ffffff4, float:NaN)
            if (r2 == r3) goto L_0x007f
            r3 = 2147483637(0x7ffffff5, float:NaN)
            if (r2 == r3) goto L_0x0058
            java.lang.Object r5 = r5.obj
            boolean r1 = r5 instanceof com.huawei.location.callback.d2
            if (r1 == 0) goto L_0x00bf
            com.huawei.location.callback.d2 r5 = (com.huawei.location.callback.d2) r5
            java.lang.Object r0 = r0.get(r5)
            com.huawei.location.logic.E5 r0 = (com.huawei.location.logic.E5) r0
            if (r0 == 0) goto L_0x00bf
            r4.yn((com.huawei.location.callback.d2) r5, (com.huawei.location.logic.E5) r0)
            android.os.Handler r1 = r4.FB
            android.os.Message r1 = r1.obtainMessage()
            int r2 = r0.FB()
            r1.what = r2
            r1.obj = r5
            android.os.Handler r4 = r4.FB
            long r2 = r0.Vw()
            r4.sendMessageDelayed(r1, r2)
            goto L_0x00bf
        L_0x0058:
            java.lang.Object r5 = r5.obj
            boolean r2 = r5 instanceof com.huawei.location.callback.d2
            if (r2 == 0) goto L_0x00bf
            com.huawei.location.callback.d2 r5 = (com.huawei.location.callback.d2) r5
            java.lang.Object r0 = r0.get(r5)
            com.huawei.location.logic.E5 r0 = (com.huawei.location.logic.E5) r0
            if (r0 == 0) goto L_0x00bf
            android.os.Handler r2 = r4.FB
            int r3 = r0.FB()
            r2.removeMessages(r3)
            r4.yn((com.huawei.location.callback.d2) r5, (com.huawei.location.logic.E5) r0)
            j$.util.concurrent.ConcurrentHashMap<com.huawei.location.callback.d2, com.huawei.location.logic.E5> r4 = r4.f50165yn
            r4.remove(r5)
            java.lang.String r4 = "removeMaxWaitTimeQueue success"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r4)
            goto L_0x00bf
        L_0x007f:
            java.lang.Object r2 = r5.obj
            boolean r3 = r2 instanceof com.huawei.location.callback.d2
            if (r3 == 0) goto L_0x00bf
            com.huawei.location.callback.d2 r2 = (com.huawei.location.callback.d2) r2
            java.lang.Object r0 = r0.get(r2)
            com.huawei.location.logic.E5 r0 = (com.huawei.location.logic.E5) r0
            if (r0 != 0) goto L_0x0095
            java.lang.String r4 = "updateLocations failed , no find bean"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r4)
            goto L_0x00bd
        L_0x0095:
            android.os.Bundle r5 = r5.getData()
            if (r5 == 0) goto L_0x00bd
            com.huawei.secure.android.common.intent.SafeBundle r3 = new com.huawei.secure.android.common.intent.SafeBundle
            r3.<init>(r5)
            java.lang.String r5 = "TAG_BEAN"
            java.io.Serializable r5 = r3.getSerializable(r5)
            boolean r3 = r5 instanceof com.huawei.location.logic.E5
            if (r3 == 0) goto L_0x00bd
            com.huawei.location.logic.E5 r5 = (com.huawei.location.logic.E5) r5
            java.util.List r5 = r5.yn()
            r0.yn((java.util.List<android.location.Location>) r5)
            j$.util.concurrent.ConcurrentHashMap<com.huawei.location.callback.d2, com.huawei.location.logic.E5> r4 = r4.f50165yn
            r4.put(r2, r0)
            java.lang.String r4 = "updateLocations success"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r4)
        L_0x00bd:
            r4 = 1
            goto L_0x00c0
        L_0x00bf:
            r4 = 0
        L_0x00c0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.logic.d2.a(com.huawei.location.logic.d2, android.os.Message):boolean");
    }

    public static d2 yn() {
        return Vw.f50166yn;
    }

    private void yn(com.huawei.location.callback.d2 d2Var, E5 e52) {
        String str;
        LogConsole.i("MaxWaitTimeManager", "callback maxWaitTime start :" + e52.LW());
        if (d2Var == null) {
            LogConsole.e("MaxWaitTimeManager", "callback maxWaitTime failed , callback is null");
            return;
        }
        if (e52.yn() == null || e52.yn().size() <= 0) {
            str = "not need callback, locations size is null";
        } else {
            LogConsole.i("MaxWaitTimeManager", "callback locationResult size is " + e52.yn().size());
            for (Location hwLocationResult : e52.yn()) {
                d2Var.Vw(new HwLocationResult(0, com.huawei.location.constant.yn.yn(0), hwLocationResult));
            }
            if (e52.yn() != null) {
                e52.yn().clear();
            }
            this.f50165yn.put(d2Var, e52);
            str = "callback maxWaitTime end";
        }
        LogConsole.i("MaxWaitTimeManager", str);
    }

    public void yn(@NonNull com.huawei.location.cache.Vw vw2, String str) {
        LogConsole.i("MaxWaitTimeManager", "removeMaxWaitTimeQueue transactionID:" + str);
        if (vw2.yn() != null) {
            com.huawei.location.callback.d2 yn2 = vw2.yn();
            if (this.f50165yn.containsKey(yn2)) {
                Message obtainMessage = this.FB.obtainMessage(2147483637);
                obtainMessage.obj = yn2;
                this.FB.sendMessage(obtainMessage);
                LogConsole.i("MaxWaitTimeManager", "removeMaxWaitTimeQueue send msg");
            }
        }
    }

    public void yn(com.huawei.location.callback.d2 d2Var, String str, long j11, LocationRequest locationRequest) {
        String str2;
        String str3;
        LogConsole.i("MaxWaitTimeManager", "addMaxWaitTimeQueue start transactionID:" + str);
        if (d2Var == null) {
            str3 = "addMaxWaitTimeQueue failed , callback is null";
        } else if (this.Vw == 1073741822) {
            str3 = "addMaxWaitTimeQueue failed , msgWhat is out of number";
        } else {
            if (this.f50165yn == null) {
                this.f50165yn = new ConcurrentHashMap<>();
            }
            if (this.f50165yn.containsKey(d2Var)) {
                LogConsole.i("MaxWaitTimeManager", "addMaxWaitTimeQueue update bean and restart queue");
                E5 e52 = this.f50165yn.get(d2Var);
                if (e52 != null) {
                    e52.yn(j11);
                    e52.yn(str);
                    this.f50165yn.putIfAbsent(d2Var, e52);
                    Message obtainMessage = this.FB.obtainMessage();
                    obtainMessage.what = e52.FB();
                    obtainMessage.obj = d2Var;
                    this.FB.removeMessages(e52.FB());
                    this.FB.sendMessageDelayed(obtainMessage, j11);
                    str2 = "addMaxWaitTimeQueue update bean and restart queue send msg";
                } else {
                    return;
                }
            } else {
                LogConsole.i("MaxWaitTimeManager", "addMaxWaitTimeQueue new bean and start queue");
                this.f50165yn.put(d2Var, new E5(str, this.Vw, j11, (List<Location>) null, locationRequest));
                Message obtainMessage2 = this.FB.obtainMessage();
                obtainMessage2.what = this.Vw;
                obtainMessage2.obj = d2Var;
                this.FB.sendMessageDelayed(obtainMessage2, j11);
                this.Vw++;
                str2 = "addMaxWaitTimeQueue new bean and restart queue send msg";
            }
            LogConsole.i("MaxWaitTimeManager", str2);
            return;
        }
        LogConsole.e("MaxWaitTimeManager", str3);
    }

    public boolean yn(String str, com.huawei.location.callback.d2 d2Var, List<Location> list) {
        LogConsole.i("MaxWaitTimeManager", "updateLocations start transactionID:" + str);
        if (this.f50165yn.size() == 0) {
            LogConsole.i("MaxWaitTimeManager", "map is null , no need update");
            return false;
        } else if (list.isEmpty()) {
            LogConsole.i("MaxWaitTimeManager", "updateLocations failed , locations is null");
            return false;
        } else if (this.f50165yn.containsKey(d2Var)) {
            Message obtainMessage = this.FB.obtainMessage(2147483636);
            obtainMessage.obj = d2Var;
            E5 e52 = new E5(str, -1, -1, list, (LocationRequest) null);
            SafeBundle safeBundle = new SafeBundle();
            safeBundle.putSerializable("TAG_BEAN", e52);
            obtainMessage.setData(safeBundle.getBundle());
            this.FB.sendMessage(obtainMessage);
            LogConsole.i("MaxWaitTimeManager", "updateLocations send msg");
            return true;
        } else {
            LogConsole.e("MaxWaitTimeManager", "updateLocations failed , not contains id");
            return false;
        }
    }
}
