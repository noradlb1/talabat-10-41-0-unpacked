package com.huawei.hms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.analytics.abc;
import com.huawei.hms.analytics.cj;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class l implements ServiceConnection {
    IConfig ghi;
    n hij;
    cj.lmn ijk;
    t ikl;
    Context klm;
    CountDownLatch lmn;

    public static class klm implements OnSuccessListener<w> {
        private final CountDownLatch hij;
        private final cj.lmn ijk;
        private final ServiceConnection ikl;
        private final Context klm;
        private final Task<w> lmn;

        public klm(Task<w> task, Context context, ServiceConnection serviceConnection, cj.lmn lmn2, CountDownLatch countDownLatch) {
            this.lmn = task;
            this.klm = context;
            this.ikl = serviceConnection;
            this.ijk = lmn2;
            this.hij = countDownLatch;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
            if (r1 == false) goto L_0x0035;
         */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onSuccess(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.String r6 = "Task bindApkService onSuccess enter."
                java.lang.String r0 = "HAServiceCommander"
                com.huawei.hms.analytics.core.log.HiLog.i(r0, r6)
                com.huawei.hmf.tasks.Task<com.huawei.hms.analytics.w> r6 = r5.lmn
                java.lang.Object r6 = r6.getResult()
                com.huawei.hms.analytics.w r6 = (com.huawei.hms.analytics.w) r6
                android.content.Intent r6 = r6.lmn
                r1 = 0
                if (r6 == 0) goto L_0x0035
                java.lang.String r2 = "Task bindApkService success."
                com.huawei.hms.analytics.core.log.HiLog.i(r0, r2)
                android.content.Context r2 = r5.klm     // Catch:{ IllegalArgumentException -> 0x0043, Exception -> 0x003d }
                java.lang.String r2 = r2.getPackageName()     // Catch:{ IllegalArgumentException -> 0x0043, Exception -> 0x003d }
                r6.setPackage(r2)     // Catch:{ IllegalArgumentException -> 0x0043, Exception -> 0x003d }
                android.content.Context r2 = r5.klm     // Catch:{ IllegalArgumentException -> 0x0043, Exception -> 0x003d }
                android.content.ServiceConnection r3 = r5.ikl     // Catch:{ IllegalArgumentException -> 0x0043, Exception -> 0x003d }
                r4 = 1
                boolean r6 = r2.bindService(r6, r3, r4)     // Catch:{ IllegalArgumentException -> 0x0043, Exception -> 0x003d }
                if (r6 == 0) goto L_0x0033
                java.lang.String r6 = "bind service success"
                com.huawei.hms.analytics.core.log.HiLog.i(r0, r6)     // Catch:{ IllegalArgumentException -> 0x0043, Exception -> 0x003d }
                r1 = r4
            L_0x0033:
                if (r1 != 0) goto L_0x004c
            L_0x0035:
                java.util.concurrent.CountDownLatch r6 = r5.hij
                r6.countDown()
                goto L_0x004c
            L_0x003b:
                r6 = move-exception
                goto L_0x0046
            L_0x003d:
                java.lang.String r6 = "bindService exception"
            L_0x003f:
                com.huawei.hms.analytics.core.log.HiLog.w(r0, r6)     // Catch:{ all -> 0x003b }
                goto L_0x0035
            L_0x0043:
                java.lang.String r6 = "setPackage IllegalArgumentException"
                goto L_0x003f
            L_0x0046:
                java.util.concurrent.CountDownLatch r0 = r5.hij
                r0.countDown()
                throw r6
            L_0x004c:
                com.huawei.hms.analytics.cj$lmn r6 = r5.ijk
                if (r6 == 0) goto L_0x0057
                if (r1 != 0) goto L_0x0057
                java.lang.String r0 = "1"
                r6.lmn(r0)
            L_0x0057:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.l.klm.onSuccess(java.lang.Object):void");
        }
    }

    public static class lmn implements OnFailureListener {
        CountDownLatch klm;
        cj.lmn lmn;

        public lmn(cj.lmn lmn2, CountDownLatch countDownLatch) {
            this.lmn = lmn2;
            this.klm = countDownLatch;
        }

        public final void onFailure(Exception exc) {
            HiLog.e("HAServiceCommander", "Task bindApkService fail." + exc.getMessage());
            cj.lmn lmn2 = this.lmn;
            if (lmn2 != null) {
                lmn2.lmn("1");
            }
            this.klm.countDown();
        }
    }

    public l(Context context, bl blVar, cj.lmn lmn2) {
        this.klm = context;
        this.hij = new n(blVar);
        this.ikl = new t(context);
        this.ijk = lmn2;
    }

    private static String lmn(ax axVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_restriction_enabled", axVar.efg);
            jSONObject.put("_restriction_shared", axVar.def);
            jSONObject.put("_region", (Object) axVar.f47867n.lmn("_openness_config_tag"));
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException unused) {
            return "";
        }
    }

    public final void lmn() {
        HiLog.i("HAServiceCommander", "unBindService is running");
        if (av.lmn().lmn.abc) {
            this.klm.unbindService(this);
            av.lmn().lmn.abc = false;
        }
    }

    public final void onBindingDied(ComponentName componentName) {
        HiLog.e("HAServiceCommander", "onBindingDied");
        av.lmn().lmn.abc = false;
    }

    public final void onNullBinding(ComponentName componentName) {
        cj.lmn lmn2 = this.ijk;
        if (lmn2 != null) {
            lmn2.lmn("1");
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HiLog.i("HAServiceCommander", "onServiceConnected");
        cj.lmn lmn2 = this.ijk;
        if (lmn2 != null) {
            lmn2.lmn();
        }
        ax axVar = av.lmn().lmn;
        axVar.abc = true;
        try {
            abc lmn3 = abc.lmn.lmn(iBinder);
            axVar.f47855b = lmn3;
            UploadInfo uploadInfo = new UploadInfo();
            uploadInfo.lmn = axVar.ghi.getPackageName();
            uploadInfo.klm = dh.lmn().klm();
            uploadInfo.ikl = axVar.f47867n.klm;
            uploadInfo.ijk = lmn(axVar);
            bc bcVar = axVar.f47867n;
            uploadInfo.lmn(bcVar.lmn.get(bcVar.lmn("_openness_config_tag")));
            if (TextUtils.isEmpty(uploadInfo.klm) || TextUtils.isEmpty(uploadInfo.lmn)) {
                HiLog.w("HAServiceCommander", "Upload info is not correct");
            } else {
                HiLog.i("HAServiceCommander", "Upload info is correct");
                lmn3.lmn(this.hij, uploadInfo);
            }
        } catch (RemoteException unused) {
            HiLog.e("HAServiceCommander", "registerCallback RemoteException");
        } catch (Throwable th2) {
            this.lmn.countDown();
            throw th2;
        }
        this.lmn.countDown();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        HiLog.e("HAServiceCommander", "onServiceDisconnected");
        av.lmn().lmn.abc = false;
        cj.lmn lmn2 = this.ijk;
        if (lmn2 != null) {
            lmn2.lmn(ExifInterface.GPS_MEASUREMENT_2D);
        }
    }
}
