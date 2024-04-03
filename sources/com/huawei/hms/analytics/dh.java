package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.SyncManager;
import com.huawei.hms.analytics.framework.config.IConfig;
import java.util.concurrent.Callable;

public final class dh {
    private static dh lmn;
    private String ikl = "";
    private Task<String> klm;

    public static class klm implements OnSuccessListener<String> {
        public final /* synthetic */ void onSuccess(Object obj) {
            HiLog.i("AAIDAssignment", "Task<String>.addOnSuccessListener onSuccess!");
        }
    }

    public static class lmn implements Callable<String> {
        private String lmn;

        private lmn(String str) {
            this.lmn = str;
        }

        public /* synthetic */ lmn(String str, byte b11) {
            this(str);
        }

        public final /* synthetic */ Object call() {
            HiLog.i("AAIDAssignment", "MyAAIDCallable.call() executed");
            return this.lmn;
        }
    }

    private static synchronized void hij() {
        synchronized (dh.class) {
            if (lmn == null) {
                lmn = new dh();
            }
        }
    }

    public static void ijk() {
        o oVar = av.lmn().lmn.f47854a;
        if (oVar == null) {
            o oVar2 = new o(cde.lmn().lmn("_openness_config_tag"));
            av.lmn().lmn.f47854a = oVar2;
            oVar = oVar2;
        }
        if (av.lmn().lmn.abc) {
            oVar.lmn();
        }
        oVar.lmn((IConfig) null);
    }

    public static dh lmn() {
        if (lmn == null) {
            hij();
        }
        return lmn;
    }

    public final synchronized Task<String> ikl() {
        return this.klm;
    }

    public final synchronized void ikl(Context context) {
        SyncManager.getInstance().start(SyncManager.TaskNames.AAID_TASK);
        try {
            HmsInstanceId.getInstance(context).deleteAAID();
        } catch (Exception unused) {
            HiLog.w("AAIDAssignment", "delete aaid ApiException");
        } catch (NoClassDefFoundError unused2) {
            HiLog.e("AAIDAssignment", HiLog.ErrorCode.IE005, "Missing hms opendevice sdk, delete aaid failed, Please upgrade the hms version");
        }
        lmn(context);
        SyncManager.getInstance().countDown(SyncManager.TaskNames.AAID_TASK);
    }

    public final synchronized String klm() {
        return this.ikl;
    }

    public final synchronized boolean klm(Context context) {
        String str = this.ikl;
        boolean z11 = false;
        try {
            this.ikl = HmsInstanceId.getInstance(context).getId();
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(this.ikl)) {
                return false;
            }
            boolean z12 = !this.ikl.equals(str);
            if (z12) {
                Task<String> callInBackground = Tasks.callInBackground(new lmn(this.ikl, (byte) 0));
                this.klm = callInBackground;
                callInBackground.addOnSuccessListener(new klm());
            }
            z11 = z12;
        } catch (Throwable th2) {
            HiLog.e("AAIDAssignment", HiLog.ErrorCode.IE005, th2.getMessage());
            dr.lmn(th2);
            return z11;
        }
    }

    public final synchronized void lmn(Context context) {
        String str = "1";
        String str2 = "";
        cj lmn2 = ck.lmn("HmsInstanceId#getId()");
        try {
            HiLog.i("AAIDAssignment", "begin sync aaid from opendevice sdk");
            String id2 = HmsInstanceId.getInstance(context).getId();
            this.ikl = id2;
            if (TextUtils.isEmpty(id2)) {
                HiLog.w("AAIDAssignment", HiLog.ErrorCode.SE002, "Failed to obtain AAID  from hms core sdk");
                this.ikl = "";
                str2 = HiLog.ErrorCode.SE002;
            } else {
                HiLog.i("AAIDAssignment", "get aaid success");
                str = "0";
            }
            Task<String> callInBackground = Tasks.callInBackground(new lmn(this.ikl, (byte) 0));
            this.klm = callInBackground;
            callInBackground.addOnSuccessListener(new klm());
            lmn2.lmn = str;
            lmn2.klm = str2;
            ck.lmn(lmn2);
        } catch (NoClassDefFoundError unused) {
            HiLog.e("AAIDAssignment", HiLog.ErrorCode.IE005, "Missing hms opendevice sdk,get aaid failed.Please upgrade the hms version");
            lmn2.lmn = str;
            lmn2.klm = HiLog.ErrorCode.IE005;
            ck.lmn(lmn2);
        } catch (Exception e11) {
            try {
                HiLog.w("AAIDAssignment", HiLog.ErrorCode.SE002, "Failed to obtain AAID from hms core sdk,unknown exception: " + e11.getMessage());
                str2 = HiLog.ErrorCode.SE002;
            } finally {
                lmn2.lmn = str;
                lmn2.klm = str2;
                ck.lmn(lmn2);
            }
        }
    }
}
