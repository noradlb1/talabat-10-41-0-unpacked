package com.huawei.location.crowdsourcing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.internal.security.CertificateUtil;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.config.ConfigBaseResponse;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.security.LocationSecurityManager;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

final class Config implements com.huawei.location.crowdsourcing.common.yn {
    private long E5;
    private long FB;
    private long G3;
    private long LW;
    private int Ot;
    private Vw Vw;
    private SharedPreferences.Editor Wf;
    private String Yx;

    /* renamed from: d2  reason: collision with root package name */
    private int f50021d2;
    private int dC;
    @NonNull
    private String dW;

    /* renamed from: h1  reason: collision with root package name */
    private boolean f50022h1;

    /* renamed from: oc  reason: collision with root package name */
    private int f50023oc;

    /* renamed from: ut  reason: collision with root package name */
    private long f50024ut;

    /* renamed from: yn  reason: collision with root package name */
    private Configurations f50025yn;

    /* renamed from: zp  reason: collision with root package name */
    private int f50026zp;

    public static class Configurations extends ConfigBaseResponse {
        /* access modifiers changed from: private */
        @SerializedName("LOCAL_RECORD_FILE_MAX_SIZE")
        public int cacheSizeLimit = 50;
        /* access modifiers changed from: private */
        @SerializedName("CELL_COLLECT_INTERVAL")
        public long cellCollectInterval = 10000;
        /* access modifiers changed from: private */
        @SerializedName("CELL_COLLECT_MAX_NUM")
        public int cellDailyLimit = 1000;
        /* access modifiers changed from: private */
        @SerializedName("CELL_SCANRESULT_VALID_INTERVAL")
        public long cellValidInterval = 20000;
        /* access modifiers changed from: private */
        @SerializedName("LOCATION_DISTANCE_INTERVAL")
        public int collectDistance = 5;
        /* access modifiers changed from: private */
        @SerializedName("LOCATION_COLLECT_INTERVAL")
        public long collectInterval = 5000;
        /* access modifiers changed from: private */
        @SerializedName("GEO_LOCATION_COLLECT_TYPE")
        public int collectType = -1;
        /* access modifiers changed from: private */
        @SerializedName("MCC_EXCLUDE_LIST")
        public List<String> excludeMccList = new ArrayList();
        /* access modifiers changed from: private */
        @SerializedName("LOG_SERVER_KEY")
        public String logServerKey = "";
        /* access modifiers changed from: private */
        @SerializedName("LOCATION_UPLOAD_TIME")
        public long uploadInterval = 1800;
        /* access modifiers changed from: private */
        @SerializedName("LOCATION_UPLOAD_NUM")
        public int uploadNumThreshold = 5;
        /* access modifiers changed from: private */
        @SerializedName("UPLOAD_PUBLIC_KEY")
        public String uploadPublicKey = "";
        /* access modifiers changed from: private */
        @SerializedName("WIFI_AP_COLLCT_MAX_NUM")
        public int wifiApNumLimit = 200;
        /* access modifiers changed from: private */
        @SerializedName("WIFI_COLLECT_MAX_NUM")
        public int wifiDailyLimit = 1000;
        /* access modifiers changed from: private */
        @SerializedName("WIFI_SCANRESULT_VALID_INTERVAL")
        public long wifiValidInterval = 5000;

        private Configurations() {
        }

        private boolean checkWifiCell() {
            String str;
            if (this.wifiDailyLimit < 0) {
                str = "wifiDailyLimit error";
            } else if (this.wifiApNumLimit < 0) {
                str = "wifiApNumLimit error";
            } else if (this.wifiValidInterval < 0) {
                str = "wifiValidInterval error";
            } else if (this.cellDailyLimit < 0) {
                str = "cellDailyLimit error";
            } else if (this.cellCollectInterval < 0) {
                str = "cellCollectInterval error";
            } else if (this.cellValidInterval >= 0) {
                return true;
            } else {
                str = "cellValidInterval error";
            }
            LogConsole.d("Config", str);
            return false;
        }

        /* access modifiers changed from: private */
        public boolean valid() {
            String str;
            int i11 = this.collectType;
            if (i11 < -1 || i11 > 2) {
                str = "collectType error";
            } else if (this.collectInterval < 0 || this.collectDistance < 0) {
                str = "collectInterval or collectDistance error";
            } else if (this.uploadInterval < 0 || this.uploadNumThreshold < 0) {
                str = "uploadInterval or uploadNumThreshold error";
            } else if (!checkWifiCell()) {
                return false;
            } else {
                if (this.cacheSizeLimit < 0) {
                    str = "cacheSizeLimit error";
                } else if (this.logServerKey.isEmpty()) {
                    str = "logServer error";
                } else if (!TextUtils.isEmpty(this.uploadPublicKey)) {
                    return true;
                } else {
                    str = "public key config error";
                }
            }
            LogConsole.d("Config", str);
            return false;
        }

        public String toString() {
            return "Configurations{collectType=" + this.collectType + ", collectInterval=" + this.collectInterval + ", collectDistance=" + this.collectDistance + ", uploadInterval=" + this.uploadInterval + ", uploadNumThreshold=" + this.uploadNumThreshold + ", wifiDailyLimit=" + this.wifiDailyLimit + ", wifiApNumLimit=" + this.wifiApNumLimit + ", wifiValidInterval=" + this.wifiValidInterval + ", cellDailyLimit=" + this.cellDailyLimit + ", cellCollectInterval=" + this.cellCollectInterval + ", cellValidInterval=" + this.cellValidInterval + ", cacheSizeLimit=" + this.cacheSizeLimit + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static class FB {
        /* access modifiers changed from: private */

        /* renamed from: yn  reason: collision with root package name */
        public static final Config f50027yn = new Config();
    }

    public class LW extends Handler {
        public LW(Looper looper) {
            super(looper);
        }

        private void yn() {
            long w11 = Config.w(Config.this) + 10000;
            LogConsole.i("Config", String.format(Locale.ENGLISH, "reset need wait %dms", new Object[]{Long.valueOf(w11)}));
            sendEmptyMessageDelayed(0, w11);
        }

        public void a() {
            yn();
        }

        public void handleMessage(@NonNull Message message) {
            if (message.what == 0) {
                yn();
                return;
            }
            LogConsole.e("Config", "unknown msg:" + message.what);
        }
    }

    public enum Vw {
        CLOSE,
        OPEN,
        WIFI,
        CELL
    }

    private Config() {
        this.Vw = Vw.CLOSE;
        this.f50021d2 = 0;
        this.f50026zp = 0;
        this.f50024ut = 0;
        this.G3 = 0;
        this.Yx = "";
        this.f50022h1 = false;
        this.dW = "";
    }

    private static String LW() {
        LocationSecurityManager locationSecurityManager = new LocationSecurityManager(3);
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(32);
        String encrypt = locationSecurityManager.encrypt(generateSecureRandomStr, "RECORD_CROWD");
        String encrypt2 = locationSecurityManager.encrypt(SHA.sha256Encrypt(encrypt), "RECORD_CROWD");
        PreferencesHelper preferencesHelper = new PreferencesHelper("crowdsourcing_config");
        preferencesHelper.saveString("sp_random_key", encrypt + CertificateUtil.DELIMITER + encrypt2);
        return generateSecureRandomStr;
    }

    public static String t() {
        LocationSecurityManager locationSecurityManager = new LocationSecurityManager(3);
        String string = new PreferencesHelper("crowdsourcing_config").getString("sp_random_key");
        if (string != null) {
            String[] split = string.split(CertificateUtil.DELIMITER);
            if (split.length != 2) {
                return LW();
            }
            if (!TextUtils.isEmpty(split[0]) && SHA.validateSHA256(split[0], locationSecurityManager.decrypt(split[1], "RECORD_CROWD"))) {
                return locationSecurityManager.decrypt(split[0], "RECORD_CROWD");
            }
        }
        return LW();
    }

    public static long w(Config config) {
        config.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - config.f50024ut) > 86400000) {
            LogConsole.i("Config", "checkReset reset");
            config.f50024ut = currentTimeMillis;
            config.Wf.putLong("RESET_TIMESTAMP", currentTimeMillis).apply();
            LogConsole.i("Config", "reset Counters");
            config.f50021d2 = 0;
            config.f50026zp = 0;
            config.Wf.putInt("WIFI_NUM", 0).putInt("CELL_NUM", config.f50026zp).apply();
        }
        return (config.f50024ut + 86400000) - currentTimeMillis;
    }

    public long a() {
        return this.f50025yn.cellCollectInterval;
    }

    public long b() {
        return this.f50025yn.wifiValidInterval;
    }

    public boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z11 = Math.abs(currentTimeMillis - this.G3) >= (this.FB << this.f50023oc);
        if (z11) {
            this.G3 = currentTimeMillis;
            this.Wf.putLong("UPLOAD_TIMESTAMP", currentTimeMillis).apply();
        }
        return z11;
    }

    public void d() {
        int i11 = this.f50021d2 + 1;
        this.f50021d2 = i11;
        this.Wf.putInt("WIFI_NUM", i11).apply();
    }

    @NonNull
    public String e() {
        return this.dW;
    }

    public long f() {
        return this.E5;
    }

    @NonNull
    public String g() {
        return this.f50025yn.logServerKey;
    }

    public boolean h() {
        return this.Vw == Vw.CLOSE;
    }

    public void i() {
        int i11 = this.f50026zp + 1;
        this.f50026zp = i11;
        this.Wf.putInt("CELL_NUM", i11).apply();
    }

    public void j(@NonNull String str) {
        this.Wf.putString("PATCH_POLICY", str).apply();
    }

    public int k() {
        return this.f50025yn.wifiApNumLimit;
    }

    @NonNull
    public String l() {
        return this.Yx;
    }

    public boolean m() {
        Vw vw2 = this.Vw;
        return (vw2 == Vw.CLOSE || vw2 == Vw.CELL || this.f50021d2 >= this.f50025yn.wifiDailyLimit) ? false : true;
    }

    public long n() {
        return this.LW;
    }

    public int o() {
        return this.dC;
    }

    @NonNull
    public String p() {
        return this.f50025yn.uploadPublicKey;
    }

    public int q() {
        return this.f50025yn.uploadNumThreshold;
    }

    public void r() {
        int i11 = this.f50023oc;
        int i12 = this.Ot;
        if (i11 != i12) {
            if (i11 < i12) {
                this.f50023oc = i11 + 1;
            } else {
                this.f50023oc = i12;
            }
            this.Wf.putInt("CONTINUOUS_UPLOAD_FAIL_NUM", this.f50023oc).apply();
        }
        LogConsole.i("Config", "continuous upload failed num:" + this.f50023oc);
    }

    public void s() {
        if (this.f50023oc != 0) {
            this.f50023oc = 0;
            this.Wf.putInt("CONTINUOUS_UPLOAD_FAIL_NUM", 0).apply();
        }
    }

    public boolean u() {
        Vw vw2 = this.Vw;
        return (vw2 == Vw.CLOSE || vw2 == Vw.WIFI || this.f50026zp >= this.f50025yn.cellDailyLimit) ? false : true;
    }

    public long v() {
        return this.f50025yn.collectInterval;
    }

    public boolean x(Context context, Looper looper) {
        Vw vw2;
        Configurations configurations = (Configurations) ConfigManager.getInstance().getConfig("crowdsourcing", Configurations.class);
        this.f50025yn = configurations;
        if (configurations == null) {
            LogConsole.e("Config", "failed to get config");
            return false;
        } else if (!configurations.valid()) {
            LogConsole.e("Config", "config not valid");
            return false;
        } else {
            LogConsole.d("Config", "configurations:" + this.f50025yn.toString());
            this.FB = this.f50025yn.uploadInterval * 1000;
            this.dC = this.f50025yn.cacheSizeLimit * 1024 * 1024;
            this.LW = this.f50025yn.cellValidInterval * 1000 * 1000;
            this.E5 = this.f50025yn.wifiValidInterval * 1000;
            int n11 = this.f50025yn.collectType;
            if (n11 == 0) {
                vw2 = Vw.OPEN;
            } else if (n11 == 1) {
                vw2 = Vw.WIFI;
            } else if (n11 == 2) {
                vw2 = Vw.CELL;
            } else {
                vw2 = Vw.CLOSE;
            }
            this.Vw = vw2;
            long j11 = this.FB;
            if (j11 == 0) {
                this.Ot = 0;
            } else {
                this.Ot = (int) (Math.log(1.728E8d / ((double) j11)) / Math.log(2.0d));
            }
            LogConsole.i("Config", "upload fail max num:" + this.Ot);
            if (Build.VERSION.SDK_INT >= 24) {
                context = context.createDeviceProtectedStorageContext();
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("crowdsourcing_config", 0);
            if (sharedPreferences == null) {
                LogConsole.e("Config", "create sharedPreferences failed");
                return false;
            }
            this.f50021d2 = sharedPreferences.getInt("WIFI_NUM", 0);
            this.f50026zp = sharedPreferences.getInt("CELL_NUM", 0);
            this.f50024ut = sharedPreferences.getLong("RESET_TIMESTAMP", 0);
            this.G3 = sharedPreferences.getLong("UPLOAD_TIMESTAMP", 0);
            this.f50023oc = sharedPreferences.getInt("CONTINUOUS_UPLOAD_FAIL_NUM", 0);
            this.f50022h1 = sharedPreferences.getBoolean("MCC_CHECK_RESULT", false);
            this.dW = sharedPreferences.getString("PATCH_POLICY", "");
            this.Yx = sharedPreferences.getString("SERIAL_NUMBER", "");
            LogConsole.i("Config", String.format(Locale.ENGLISH, "wifiNum:%d, cellNum:%d, resetTimeStamp:%d, uploadTimeStamp:%d, uploadContinuousFailNum:%d", new Object[]{Integer.valueOf(this.f50021d2), Integer.valueOf(this.f50026zp), Long.valueOf(this.f50024ut), Long.valueOf(this.G3), Integer.valueOf(this.f50023oc)}));
            this.Wf = sharedPreferences.edit();
            if (this.Yx.isEmpty()) {
                this.Yx = UUID.randomUUID().toString();
                LogConsole.i("Config", "create serial number:" + this.Yx);
                this.Wf.putString("SERIAL_NUMBER", this.Yx);
            }
            this.Wf.apply();
            new LW(looper).a();
            return true;
        }
    }

    public boolean y(String str) {
        boolean z11;
        if (str.isEmpty()) {
            LogConsole.d("Config", "no mcc, use last mcc result:" + this.f50022h1);
        } else {
            Iterator it = this.f50025yn.excludeMccList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        z11 = false;
                        break;
                    }
                } else {
                    z11 = true;
                    break;
                }
            }
            if (this.f50022h1 != z11) {
                this.f50022h1 = z11;
                this.Wf.putBoolean("MCC_CHECK_RESULT", z11);
                this.Wf.apply();
            }
            LogConsole.i("Config", "got mcc, check result:" + this.f50022h1);
        }
        return this.f50022h1;
    }

    public void yn() {
        LogConsole.w("Config", "Stop");
    }

    public int z() {
        return this.f50025yn.collectDistance;
    }
}
