package com.huawei.location.vdr.control;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.SystemPropertiesUtil;
import com.huawei.location.vdr.util.Vw;
import com.huawei.location.vdr.util.yn;

public class VDRControl {
    private static final String TAG = "VDRControl";
    private static final String VDR_ENABLE = "1";
    public static final String VDR_GNSS_OPTION = "vdrEnable";
    private VDRConfig config = null;

    public VDRControl() {
        VDRConfig vDRConfig = new VDRConfig();
        this.config = vDRConfig;
        vDRConfig.a();
    }

    public boolean isSpeedSupport(int i11) {
        VDRConfig vDRConfig = this.config;
        return vDRConfig != null && vDRConfig.c(i11);
    }

    public boolean isSupport(String str) {
        if (this.config == null) {
            this.config = new VDRConfig();
        }
        return this.config.b() && this.config.d(str) && this.config.e(yn.yn(SystemPropertiesUtil.getPlatform()), Vw.yn(Build.VERSION.SDK_INT));
    }

    public boolean isVdrRequest(String str) {
        LogConsole.i(TAG, "isVdrRequest:" + str);
        return TextUtils.equals("1", str);
    }
}
