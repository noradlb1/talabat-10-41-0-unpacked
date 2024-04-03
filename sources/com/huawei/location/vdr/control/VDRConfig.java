package com.huawei.location.vdr.control;

import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.config.ConfigBaseResponse;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.utility.JavaConstant;

public class VDRConfig {

    /* renamed from: yn  reason: collision with root package name */
    private ConfigEntity f50272yn = null;

    public static class ConfigEntity extends ConfigBaseResponse {
        /* access modifiers changed from: private */
        @SerializedName("DEVICE_LIST")
        public List<String> deviceList = new ArrayList();
        /* access modifiers changed from: private */
        @SerializedName("MIN_SPEED")
        public int minSpeed = 3;
        /* access modifiers changed from: private */
        @SerializedName("PACKAGE_LIST")
        public List<String> packageList = new ArrayList();
        @SerializedName("VDR_SWITCH")
        private boolean vdrSwitch = false;

        private ConfigEntity() {
        }

        public String toString() {
            return "ConfigEntity{vdrSwitch=" + this.vdrSwitch + ", PACKAGE_LIST=" + this.packageList.toString() + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public void a() {
        LogConsole.i("VDRConfig", "init vdr config");
        this.f50272yn = (ConfigEntity) ConfigManager.getInstance().getConfig("vdr", ConfigEntity.class);
    }

    public boolean b() {
        boolean z11;
        if (this.f50272yn == null) {
            LogConsole.i("VDRConfig", "init vdr config");
            this.f50272yn = (ConfigEntity) ConfigManager.getInstance().getConfig("vdr", ConfigEntity.class);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("get config failed, configEntity is Empty, get again not null:");
            if (this.f50272yn != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            sb2.append(z11);
            LogConsole.w("VDRConfig", sb2.toString());
        }
        if (this.f50272yn != null) {
            return true;
        }
        return false;
    }

    public boolean c(int i11) {
        LogConsole.i("VDRConfig", "checkSpeed :" + i11);
        return i11 > this.f50272yn.minSpeed;
    }

    public boolean d(String str) {
        for (String equals : this.f50272yn.packageList) {
            if (equals.equals(str)) {
                return true;
            }
        }
        LogConsole.w("VDRConfig", "checkPackage not support:" + str);
        return false;
    }

    public boolean e(String str, String str2) {
        String str3 = str + JavaConstant.Dynamic.DEFAULT_NAME + str2;
        for (String equals : this.f50272yn.deviceList) {
            if (equals.equals(str3)) {
                return true;
            }
        }
        LogConsole.w("VDRConfig", "checkDevice not support :" + str3);
        return false;
    }
}
