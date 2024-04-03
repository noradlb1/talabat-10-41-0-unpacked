package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.analytics.bg;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.framework.SyncManager;
import com.huawei.hms.analytics.framework.config.IConfig;
import java.util.List;

public final class ghi extends hij {
    public ghi(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
    }

    public final void lmn(bc bcVar) {
        if (TextUtils.isEmpty(this.hij) && !bcVar.lmn.containsKey(bcVar.hij)) {
            throw new IllegalArgumentException("collect urls check failed");
        } else if (!TextUtils.isEmpty(this.hij) && !bcVar.lmn.containsKey(this.hij)) {
            throw new IllegalArgumentException("The serviceCountryCode Invalid!");
        }
    }

    public final void run() {
        boolean z11;
        try {
            lmn();
            be.lmn(this.ikl, Boolean.TRUE);
            z11 = false;
            if (!be.ijk()) {
                String[] strArr = aq.ghi;
                if (!strArr[0].equals(this.ikl) && aq.fgh.contains(this.ikl)) {
                    Context context = this.klm;
                    String klm = dv.klm(context, "Privacy_MY", strArr[0] + "_region", "");
                    if (!TextUtils.isEmpty(klm)) {
                        List<Event> klm2 = bg.lmn(this.klm).klm(strArr[0]);
                        if (klm2.size() != 0) {
                            bl lmn = cde.lmn().lmn(this.ikl);
                            if (lmn != null) {
                                lmn.lmn((IConfig) new ca(klm, this.lmn.f47867n.lmn.get(klm)), klm2);
                                be.hij();
                            }
                        }
                    }
                }
            }
        } catch (bg.lmn unused) {
            HiLog.w("connectInit", "db controller exception");
        } catch (Throwable th2) {
            try {
                be.lmn(this.ikl, Boolean.FALSE);
                HiLog.e("connectInit", HiLog.ErrorCode.SE001, this.ikl + " instance config init failed! " + th2.getMessage());
            } catch (Throwable th3) {
                SyncManager.getInstance().countDown(this.fgh);
                throw th3;
            }
        }
        this.lmn.f47867n.lmn(this.ikl, klm());
        String str = TextUtils.isEmpty(this.hij) ? this.lmn.f47867n.hij : this.hij;
        b lmn2 = b.lmn(this.klm, this.ikl);
        if (av.lmn().lmn.f47867n.lmn.containsKey(str)) {
            if (!TextUtils.isEmpty(lmn2.lmn) && !str.equals(lmn2.lmn)) {
                z11 = true;
            }
            if (z11) {
                HiLog.d("connectInit", "change region: ".concat(String.valueOf(str)));
                lmn2.klm();
                ch.lmn(this.klm, klm(), System.currentTimeMillis());
            } else {
                if (TextUtils.isEmpty(lmn2.lmn)) {
                }
                HiLog.i("connectInit", this.ikl + " init success");
                SyncManager.getInstance().countDown(this.fgh);
                return;
            }
            lmn2.lmn(str);
            HiLog.i("connectInit", this.ikl + " init success");
            SyncManager.getInstance().countDown(this.fgh);
            return;
        }
        lmn2.klm();
        throw new IllegalArgumentException("Config json error, please check collector url from region: ".concat(String.valueOf(str)));
    }
}
