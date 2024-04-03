package com.huawei.location.sdm;

import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.config.ConfigBaseResponse;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.utility.JavaConstant;

public class Config {

    /* renamed from: yn  reason: collision with root package name */
    private Configurations f50214yn;

    public static class Configurations extends ConfigBaseResponse {
        /* access modifiers changed from: private */
        @SerializedName("AR_WALK_SPEED")
        public int arWalkSpeed = 3;
        /* access modifiers changed from: private */
        @SerializedName("DEVICE_LIST")
        public List<String> deviceList = new ArrayList();
        /* access modifiers changed from: private */
        @SerializedName("EPHEMERIS_VALID_TIME")
        public long ephemerisValidTime = 3600;
        /* access modifiers changed from: private */
        @SerializedName("SMOOTH_COUNT_ENTER")
        public int smoothEnter = 3;
        /* access modifiers changed from: private */
        @SerializedName("SMOOTH_COUNT_EXIT")
        public int smoothExit = 10;
        /* access modifiers changed from: private */
        @SerializedName("TILE_DAILY_MAX_NUM")
        public int tileDailyMaxNum = 25;
        /* access modifiers changed from: private */
        @SerializedName("TILE_MAX_NUM")
        public int tileMaxNum = 30;

        private Configurations() {
        }

        /* access modifiers changed from: private */
        public boolean valid() {
            String str;
            long j11 = this.ephemerisValidTime;
            if (j11 > 7200 || j11 < 600) {
                str = "ephemerisValidTime error";
            } else {
                int i11 = this.tileDailyMaxNum;
                if (i11 <= 200 && i11 >= 0) {
                    return true;
                }
                str = "tileDailyMaxNum error";
            }
            LogConsole.d("Config", str);
            return false;
        }

        public String toString() {
            return "Configurations{ephemerisValidTime=" + this.ephemerisValidTime + ", tileDailyMaxNum=" + this.tileDailyMaxNum + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public int Vw() {
        return this.f50214yn.smoothExit;
    }

    public boolean a() {
        String str;
        Configurations configurations = (Configurations) ConfigManager.getInstance().getConfig("sdm", Configurations.class);
        this.f50214yn = configurations;
        if (configurations == null) {
            str = "failed to get config";
        } else if (!configurations.valid()) {
            str = "config not valid";
        } else {
            LogConsole.d("Config", "configurations:" + this.f50214yn.toString());
            long unused = this.f50214yn.ephemerisValidTime;
            return true;
        }
        LogConsole.e("Config", str);
        return false;
    }

    public int b() {
        return this.f50214yn.tileDailyMaxNum;
    }

    public int c() {
        return this.f50214yn.tileMaxNum;
    }

    public boolean d(String str, String str2) {
        String str3 = str + JavaConstant.Dynamic.DEFAULT_NAME + str2;
        for (String equals : this.f50214yn.deviceList) {
            if (equals.equals(str3)) {
                return true;
            }
        }
        return false;
    }

    public int dC() {
        return this.f50214yn.arWalkSpeed;
    }

    public int yn() {
        return this.f50214yn.smoothEnter;
    }
}
