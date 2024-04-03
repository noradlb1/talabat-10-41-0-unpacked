package com.huawei.hms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.hms.analytics.core.log.HiLog;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class ab {
    private String ghi;
    private String hij;
    private Intent ijk;
    private final aa ikl;
    lmn klm;
    final Context lmn;

    public static final class lmn implements ServiceConnection {
        private final aa ikl;
        private boolean klm;
        private final LinkedBlockingQueue<IBinder> lmn = new LinkedBlockingQueue<>(1);

        public lmn(aa aaVar) {
            this.ikl = aaVar;
        }

        public final IBinder lmn() {
            if (!this.klm) {
                this.klm = true;
                return this.lmn.poll(1000, TimeUnit.MILLISECONDS);
            }
            throw new IllegalStateException();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.lmn.offer(iBinder, 300, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
                HiLog.w("idServiceConn", "onServiceConnected handler Ibinder error");
                this.ikl.lmn("getOaid error,begin get gaid");
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            HiLog.w("idServiceConn", "onServiceDisconnected");
        }
    }

    public ab(Context context, Intent intent, aa aaVar) {
        this.lmn = context;
        this.ijk = intent;
        this.ikl = aaVar;
    }

    public ab(Context context, String str, String str2, aa aaVar) {
        this.lmn = context;
        this.hij = str;
        this.ghi = str2;
        this.ikl = aaVar;
    }

    public final void lmn() {
        if (this.ijk == null) {
            Intent intent = new Intent(this.hij);
            this.ijk = intent;
            intent.setPackage(this.ghi);
        }
        lmn lmn2 = new lmn(this.ikl);
        this.klm = lmn2;
        boolean bindService = this.lmn.bindService(this.ijk, lmn2, 1);
        HiLog.i("oaidService", "isBind: ".concat(String.valueOf(bindService)));
        if (bindService) {
            this.ikl.lmn(this.klm);
        } else {
            this.ikl.lmn("bindService fail,begin get gaid");
        }
    }
}
