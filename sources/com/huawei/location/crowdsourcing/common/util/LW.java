package com.huawei.location.crowdsourcing.common.util;

import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.huawei.location.lite.common.log.LogConsole;
import i2.b;
import java.util.List;

class LW {
    /* access modifiers changed from: private */

    /* renamed from: yn  reason: collision with root package name */
    public static final byte[] f50049yn = new byte[0];

    public static class yn extends TelephonyManager.CellInfoCallback {
        public void onCellInfo(@NonNull List<CellInfo> list) {
            synchronized (LW.f50049yn) {
                LW.f50049yn.notifyAll();
            }
        }
    }

    @RequiresApi(api = 29)
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static void a(TelephonyManager telephonyManager) {
        String str;
        String str2;
        yn ynVar = new yn();
        byte[] bArr = f50049yn;
        synchronized (bArr) {
            try {
                telephonyManager.requestCellInfoUpdate(new b(), ynVar);
                bArr.wait(1000);
            } catch (InterruptedException unused) {
                str = "RefreshByCellInfoCallback";
                str2 = "Get cell sleep interrupted!";
            } catch (Exception unused2) {
                str = "RefreshByCellInfoCallback";
                str2 = "Request cellInfoUpdate failed";
            }
        }
        LogConsole.e(str, str2);
    }
}
