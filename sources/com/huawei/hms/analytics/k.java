package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.analytics.core.log.HiLog;

public final class k {
    public u lmn;

    public static class klm implements OnSuccessListener<String> {
        public final /* synthetic */ void onSuccess(Object obj) {
            HiLog.i("HAObservableHolder", (String) obj);
        }
    }

    public static class lmn implements OnFailureListener {
        public final void onFailure(Exception exc) {
            HiLog.e("HAObservableHolder", "Task notifyKitAPP fail." + exc.getMessage());
        }
    }

    public k(Context context) {
        this.lmn = new u(context);
    }
}
