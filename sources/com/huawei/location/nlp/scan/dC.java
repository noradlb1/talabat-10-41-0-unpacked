package com.huawei.location.nlp.scan;

import android.text.TextUtils;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.nlp.api.Vw;
import com.huawei.location.nlp.scan.wifi.yn;

public class dC {

    /* renamed from: yn  reason: collision with root package name */
    private yn f50201yn;

    public dC(Vw vw2) {
        yn ynVar;
        int yn2 = yn();
        if (yn2 == 0) {
            ynVar = new E5(vw2);
        } else if (yn2 == 1) {
            ynVar = new yn(vw2);
        } else if (yn2 != 2) {
            this.f50201yn = new Vw();
            return;
        } else {
            ynVar = new com.huawei.location.nlp.scan.cell.Vw(vw2);
        }
        this.f50201yn = ynVar;
    }

    public static int yn() {
        int i11;
        String config = ConfigManager.getInstance().getConfig("location", "geo_position_type");
        LogConsole.i("ScanTask", "getConfig, model is " + config);
        if (!TextUtils.isEmpty(config)) {
            try {
                i11 = Integer.parseInt(config);
            } catch (NumberFormatException unused) {
                LogConsole.e("ScanTask", "scan model parse fail, NumberFormatException");
            }
            LogConsole.i("ScanTask", "final model is " + i11);
            return i11;
        }
        i11 = 0;
        LogConsole.i("ScanTask", "final model is " + i11);
        return i11;
    }

    public void FB() {
        this.f50201yn.Vw();
    }

    public void Vw() {
        this.f50201yn.yn();
    }

    public void yn(long j11) {
        this.f50201yn.yn(j11);
    }
}
