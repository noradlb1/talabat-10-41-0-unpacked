package com.huawei.location.nlp.scan.cell;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.PermissionUtil;
import java.util.List;

public class yn {
    private TelephonyManager Vw;

    /* renamed from: yn  reason: collision with root package name */
    private Context f50199yn;

    public interface Vw {
        void yn(List<CellInfo> list);
    }

    /* renamed from: com.huawei.location.nlp.scan.cell.yn$yn  reason: collision with other inner class name */
    public class C0086yn extends TelephonyManager.CellInfoCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Vw f50200a;

        public C0086yn(yn ynVar, Vw vw2) {
            this.f50200a = vw2;
        }

        public void onCellInfo(@NonNull List<CellInfo> list) {
            this.f50200a.yn(list);
        }
    }

    public yn() {
        Context context = ContextUtil.getContext();
        this.f50199yn = context;
        Object systemService = context.getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            this.Vw = (TelephonyManager) systemService;
        }
    }

    public void yn(@NonNull Vw vw2) {
        String str;
        if (this.Vw == null) {
            Object systemService = this.f50199yn.getSystemService("phone");
            if (systemService instanceof TelephonyManager) {
                this.Vw = (TelephonyManager) systemService;
            } else {
                str = "telephonyManager is null";
                LogConsole.e("CellScanManager", str);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (!PermissionUtil.checkSelfPermission(this.f50199yn, "android.permission.ACCESS_FINE_LOCATION")) {
                str = "do not ACCESS_FINE_LOCATION";
                LogConsole.e("CellScanManager", str);
                return;
            }
            try {
                this.Vw.requestCellInfoUpdate(ExecutorUtil.getInstance().getExecutor(), new C0086yn(this, vw2));
                return;
            } catch (Exception unused) {
                LogConsole.e("CellScanManager", "requestCellInfoUpdate exception");
            }
        }
        vw2.yn(this.Vw.getAllCellInfo());
    }
}
