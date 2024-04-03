package com.huawei.location.crowdsourcing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.newrelic.agent.android.instrumentation.Instrumented;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.io.File;
import java.io.IOException;

@Instrumented
final class FB implements com.huawei.location.crowdsourcing.common.yn {

    /* renamed from: yn  reason: collision with root package name */
    private static int f50030yn;
    private byte[] E5;
    private final LW FB;
    private int LW;
    /* access modifiers changed from: private */
    public final Vw Vw;
    @Nullable

    /* renamed from: d2  reason: collision with root package name */
    private C0077FB f50031d2;
    private final File dC;

    /* renamed from: com.huawei.location.crowdsourcing.FB$FB  reason: collision with other inner class name */
    public class C0077FB extends BroadcastReceiver {
        private C0077FB() {
        }

        public void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (action == null) {
                LogConsole.e("Recorder", "get null action");
            } else if (!action.equals(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION)) {
                LogConsole.e("Recorder", "receive unknown action,action:" + action);
            } else {
                LogConsole.i("Recorder", "onReceive action=" + action);
                NetworkInfo networkInfo = (NetworkInfo) safeIntent.getParcelableExtra("networkInfo");
                if (networkInfo == null) {
                    LogConsole.e("Recorder", "no EXTRA_NETWORK_INFO");
                } else if (networkInfo.isConnected() && networkInfo.getType() == 1) {
                    FB.this.Vw.obtainMessage(0).sendToTarget();
                }
            }
        }
    }

    public class Vw extends Handler {
        public Vw(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            if (message.what == 0) {
                FB.d(FB.this);
                return;
            }
            LogConsole.e("Recorder", "unknown msg:" + message.what);
        }
    }

    public FB(Looper looper, String str) {
        this.Vw = new Vw(looper);
        this.FB = new LW(str);
        this.dC = new File(str + File.separator + "crowdsourcing_record");
    }

    private void LW() {
        if (!this.dC.exists()) {
            LogConsole.i("Recorder", "file not exists, not upload");
            return;
        }
        try {
            if (!this.FB.b(this.dC.getCanonicalPath())) {
                LogConsole.i("Recorder", "not upload file");
            } else if (this.dC.delete()) {
                LogConsole.i("Recorder", "upload file success and delete file success");
                this.LW = 0;
            } else {
                LogConsole.e("Recorder", "upload file success but delete file failed");
            }
        } catch (IOException unused) {
            LogConsole.e("Recorder", "get path failed");
        }
    }

    public static void d(FB fb2) {
        fb2.getClass();
        LogConsole.i("Recorder", "wifi connected, try upload");
        fb2.LW();
    }

    public void Vw() {
        if (this.dC.delete()) {
            LogConsole.w("Recorder", "clear file success");
            this.LW = 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() {
        /*
            r6 = this;
            java.io.File r0 = r6.dC
            boolean r1 = r0.exists()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0028
            boolean r1 = r0.isFile()
            java.lang.String r4 = "FileUtil"
            if (r1 != 0) goto L_0x001b
            boolean r0 = r0.delete()
            if (r0 != 0) goto L_0x0028
            java.lang.String r0 = "file delete failed"
            goto L_0x0023
        L_0x001b:
            boolean r0 = r0.canWrite()
            if (r0 != 0) goto L_0x0028
            java.lang.String r0 = "file can not write"
        L_0x0023:
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
            r0 = r3
            goto L_0x0029
        L_0x0028:
            r0 = r2
        L_0x0029:
            java.lang.String r1 = "Recorder"
            if (r0 != 0) goto L_0x0033
            java.lang.String r0 = "regularize file failed"
        L_0x002f:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r0)
            return r3
        L_0x0033:
            com.huawei.location.crowdsourcing.LW r0 = r6.FB
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x003e
            java.lang.String r0 = "uploader init failed"
            goto L_0x002f
        L_0x003e:
            com.huawei.location.crowdsourcing.FB$FB r0 = new com.huawei.location.crowdsourcing.FB$FB
            r3 = 0
            r0.<init>()
            r6.f50031d2 = r0
            android.content.Context r3 = com.huawei.location.crowdsourcing.Vw.b()
            android.content.IntentFilter r4 = new android.content.IntentFilter
            java.lang.String r5 = "android.net.conn.CONNECTIVITY_CHANGE"
            r4.<init>(r5)
            r3.registerReceiver(r0, r4)
            java.lang.String r0 = "wifi connect register success"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.FB.a():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0159, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0162, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(@androidx.annotation.NonNull android.location.Location r7, @androidx.annotation.Nullable java.util.List<android.net.wifi.ScanResult> r8, @androidx.annotation.Nullable java.util.List<com.huawei.location.crowdsourcing.common.entity.yn> r9) {
        /*
            r6 = this;
            com.huawei.location.crowdsourcing.record.yn r0 = new com.huawei.location.crowdsourcing.record.yn
            r0.<init>()
            r0.yn((android.location.Location) r7)
            r7 = 1
            r1 = 0
            if (r8 == 0) goto L_0x0015
            android.content.Context r2 = com.huawei.location.crowdsourcing.Vw.b()
            r0.yn(r8, r2)
            r2 = r7
            goto L_0x0016
        L_0x0015:
            r2 = r1
        L_0x0016:
            if (r9 == 0) goto L_0x001c
            r0.yn((java.util.List<com.huawei.location.crowdsourcing.common.entity.yn>) r9)
            r2 = r7
        L_0x001c:
            java.lang.String r3 = "Recorder"
            if (r2 != 0) goto L_0x0025
            java.lang.String r2 = "record not filled cell or wifi"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r2)
        L_0x0025:
            com.google.gson.Gson r2 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            boolean r4 = r2 instanceof com.google.gson.Gson
            if (r4 != 0) goto L_0x0032
            java.lang.String r0 = r2.toJson((java.lang.Object) r0)
            goto L_0x0036
        L_0x0032:
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r2, (java.lang.Object) r0)
        L_0x0036:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "generate record.w:"
            r2.append(r4)
            if (r8 != 0) goto L_0x0044
            r8 = r1
            goto L_0x0048
        L_0x0044:
            int r8 = r8.size()
        L_0x0048:
            r2.append(r8)
            java.lang.String r8 = " c:"
            r2.append(r8)
            if (r9 != 0) goto L_0x0054
            r8 = r1
            goto L_0x0058
        L_0x0054:
            int r8 = r9.size()
        L_0x0058:
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r3, r8)
            int r8 = f50030yn
            if (r8 == 0) goto L_0x0068
            goto L_0x00f4
        L_0x0068:
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r8 = r0.getBytes(r8)
            int r8 = r8.length
            if (r8 != 0) goto L_0x007a
            java.lang.String r8 = "calcLocalNum first record bytes empty."
            com.huawei.location.lite.common.log.LogConsole.w(r3, r8)
            int r8 = r0.length()
        L_0x007a:
            if (r8 != 0) goto L_0x0082
            java.lang.String r8 = "calcLocalNum first record empty."
        L_0x007e:
            com.huawei.location.lite.common.log.LogConsole.e(r3, r8)
            goto L_0x00f4
        L_0x0082:
            f50030yn = r8
            java.io.File r8 = r6.dC
            boolean r8 = r8.exists()
            if (r8 != 0) goto L_0x0092
            java.lang.String r8 = "calcLocalNum no file"
            com.huawei.location.lite.common.log.LogConsole.i(r3, r8)
            goto L_0x00f4
        L_0x0092:
            java.io.File r8 = r6.dC
            long r8 = r8.length()
            r4 = 0
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x00b0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "calcLocalNum file exist, but size is abnormal."
            r2.append(r4)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            goto L_0x007e
        L_0x00b0:
            int r2 = f50030yn
            long r4 = (long) r2
            long r4 = r8 / r4
            int r2 = (int) r4
            int r2 = r2 + r7
            r6.LW = r2
            com.huawei.location.crowdsourcing.Config r2 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            int r4 = r2.o()
            long r4 = (long) r4
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x00cf
            int r4 = r6.LW
            int r2 = r2.q()
            int r4 = r4 + r2
            r6.LW = r4
        L_0x00cf:
            java.util.Locale r2 = java.util.Locale.ENGLISH
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            r4[r1] = r8
            int r8 = f50030yn
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r4[r7] = r8
            int r8 = r6.LW
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9 = 2
            r4[r9] = r8
            java.lang.String r8 = "calcLocalNum file size:%d, one record size:%d, num:%d"
            java.lang.String r8 = java.lang.String.format(r2, r8, r4)
            com.huawei.location.lite.common.log.LogConsole.i(r3, r8)
        L_0x00f4:
            byte[] r8 = r6.E5
            if (r8 != 0) goto L_0x010d
            java.lang.String r8 = com.huawei.location.crowdsourcing.Config.t()
            byte[] r8 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(r8)
            r6.E5 = r8
            if (r8 == 0) goto L_0x0107
            int r8 = r8.length
            if (r8 != 0) goto L_0x010d
        L_0x0107:
            java.lang.String r8 = "store get aes key error"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r8)
            goto L_0x016b
        L_0x010d:
            java.io.File r8 = r6.dC
            long r8 = r8.length()
            com.huawei.location.crowdsourcing.Config r2 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            int r2 = r2.o()
            long r4 = (long) r2
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x0122
            r8 = r7
            goto L_0x0123
        L_0x0122:
            r8 = r1
        L_0x0123:
            if (r8 == 0) goto L_0x012b
            java.lang.String r8 = "local cache too big, can not write"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r8)
            goto L_0x016b
        L_0x012b:
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0166, IOException -> 0x0163 }
            java.io.File r9 = r6.dC     // Catch:{ FileNotFoundException -> 0x0166, IOException -> 0x0163 }
            r8.<init>(r9, r7)     // Catch:{ FileNotFoundException -> 0x0166, IOException -> 0x0163 }
            byte[] r9 = r6.E5     // Catch:{ all -> 0x0157 }
            java.lang.String r9 = com.huawei.secure.android.common.encrypt.aes.AesGcm.encrypt((java.lang.String) r0, (byte[]) r9)     // Catch:{ all -> 0x0157 }
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0157 }
            byte[] r9 = r9.getBytes(r0)     // Catch:{ all -> 0x0157 }
            r8.write(r9)     // Catch:{ all -> 0x0157 }
            java.lang.String r9 = java.lang.System.lineSeparator()     // Catch:{ all -> 0x0157 }
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0157 }
            byte[] r9 = r9.getBytes(r0)     // Catch:{ all -> 0x0157 }
            r8.write(r9)     // Catch:{ all -> 0x0157 }
            int r9 = r6.LW     // Catch:{ all -> 0x0157 }
            int r9 = r9 + r7
            r6.LW = r9     // Catch:{ all -> 0x0157 }
            r8.close()     // Catch:{ FileNotFoundException -> 0x0166, IOException -> 0x0163 }
            goto L_0x016b
        L_0x0157:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0159 }
        L_0x0159:
            r0 = move-exception
            r8.close()     // Catch:{ all -> 0x015e }
            goto L_0x0162
        L_0x015e:
            r8 = move-exception
            r9.addSuppressed(r8)     // Catch:{ FileNotFoundException -> 0x0166, IOException -> 0x0163 }
        L_0x0162:
            throw r0     // Catch:{ FileNotFoundException -> 0x0166, IOException -> 0x0163 }
        L_0x0163:
            java.lang.String r8 = "local cache IO or close failed"
            goto L_0x0168
        L_0x0166:
            java.lang.String r8 = "local cache open failed"
        L_0x0168:
            com.huawei.location.lite.common.log.LogConsole.e(r3, r8)
        L_0x016b:
            int r8 = r6.LW
            com.huawei.location.crowdsourcing.Config r9 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            int r9 = r9.q()
            if (r8 < r9) goto L_0x0178
            goto L_0x0179
        L_0x0178:
            r7 = r1
        L_0x0179:
            if (r7 != 0) goto L_0x0181
            java.lang.String r7 = "not reach upload num"
            com.huawei.location.lite.common.log.LogConsole.d(r3, r7)
            goto L_0x0184
        L_0x0181:
            r6.LW()
        L_0x0184:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.FB.c(android.location.Location, java.util.List, java.util.List):void");
    }

    public void yn() {
        LogConsole.w("Recorder", "Stop");
        C0077FB fb2 = this.f50031d2;
        if (fb2 != null) {
            Vw.b().unregisterReceiver(fb2);
        }
        this.FB.getClass();
        LogConsole.w("Uploader", "Stop");
    }
}
