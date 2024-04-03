package com.huawei.hms.analytics;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.analytics.cj;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.huawei.hms.analytics.l;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiMobileServicesUtil;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class o {
    private boolean klm;
    private final l lmn;

    public static class lmn implements cj.lmn {
        public final void lmn() {
            cj lmn = ck.lmn("BindService");
            lmn.lmn = "0";
            ck.lmn(lmn);
        }

        public final void lmn(String str) {
            cj lmn = ck.lmn("BindService");
            lmn.lmn = str;
            ck.lmn(lmn);
        }
    }

    public o(bl blVar) {
        this.lmn = new l(av.lmn().lmn.ghi, blVar, new lmn());
    }

    public final void lmn() {
        try {
            if (this.klm) {
                this.lmn.lmn();
                this.klm = false;
            }
        } catch (Exception unused) {
            HiLog.w("ServiceWatcher", "service unbind exception");
        }
    }

    public final void lmn(IConfig iConfig) {
        HiLog.d("ServiceWatcher", "service bind");
        try {
            if (!this.klm) {
                l lVar = this.lmn;
                lVar.ghi = iConfig;
                HiLog.i("HAServiceCommander", "bindService is running");
                if (av.lmn().lmn.abc) {
                    HiLog.i("HAServiceCommander", "Service is already bind, when want to bind.");
                } else if (HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(lVar.klm, HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE) != 0) {
                    HiLog.w("HAServiceCommander", HiLog.ErrorCode.IE005, "Missing hms core sdk,or HMS version is too low");
                    cj.lmn lmn2 = lVar.ijk;
                    if (lmn2 != null) {
                        lmn2.lmn(ExifInterface.GPS_MEASUREMENT_3D);
                    }
                } else {
                    lVar.hij.lmn = lVar.ghi;
                    lVar.lmn = new CountDownLatch(1);
                    Task doWrite = lVar.ikl.doWrite(new x("hianalytics.analyticsEvtService", ""));
                    doWrite.addOnFailureListener(new l.lmn(lVar.ijk, lVar.lmn)).addOnSuccessListener(new l.klm(doWrite, lVar.klm, lVar, lVar.ijk, lVar.lmn));
                }
                CountDownLatch countDownLatch = this.lmn.lmn;
                if (countDownLatch != null) {
                    countDownLatch.await(500, TimeUnit.MILLISECONDS);
                }
                this.klm = av.lmn().lmn.abc;
            }
        } catch (Exception unused) {
            HiLog.w("ServiceWatcher", "service bind exception");
        }
    }
}
