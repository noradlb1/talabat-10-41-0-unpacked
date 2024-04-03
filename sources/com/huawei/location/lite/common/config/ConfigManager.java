package com.huawei.location.lite.common.config;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.security.LocationSecurityManager;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ConfigManager {
    private static final String CONFIG_URL = "/networklocation/v1/configurations";
    private static final long EXPIRED_TIME = 86400000;
    private static final String GROUP_NAME = "groupName";
    private static final String GROUP_NAME_LITE_SDK = "liteSDK";
    private static final String KEY_CACHE_TIME = "KEY_CACHE_TIME";
    private static final String KEY_CONFIG_DATA = "KEY_CONFIG_DATA";
    private static final String SECURITY_PARAMS = "LOCATION_LITE_SDK";
    private static final String SP_NAME = "com.huawei.hms.location.config";
    private static final Object SYNC_LOCK = new Object();
    private static final String TAG = "ConfigManager";
    private HashMap<String, String> configCache;

    public static class Vw {
        /* access modifiers changed from: private */

        /* renamed from: yn  reason: collision with root package name */
        public static final ConfigManager f50111yn = new ConfigManager((yn) null);
    }

    public class yn extends TypeToken<HashMap<String, String>> {
        public yn(ConfigManager configManager) {
        }
    }

    private ConfigManager() {
    }

    public /* synthetic */ ConfigManager(yn ynVar) {
        this();
    }

    private boolean checkCacheExpired(PreferencesHelper preferencesHelper) {
        long j11 = preferencesHelper.getLong(KEY_CACHE_TIME);
        return j11 == -1 || System.currentTimeMillis() > j11 + 86400000;
    }

    private void checkConfigData() {
        PreferencesHelper preferencesHelper = new PreferencesHelper(SP_NAME);
        if (checkCacheExpired(preferencesHelper)) {
            this.configCache = null;
        } else {
            loadConfigCache(preferencesHelper);
            if (this.configCache == null) {
                LogConsole.e(TAG, "load cache config fail ,reload config from network");
            } else {
                return;
            }
        }
        requestConfigSync();
    }

    public static ConfigManager getInstance() {
        return Vw.f50111yn;
    }

    private void jsonArray2Map(String str) throws JSONException {
        JSONArray jSONArray = new JSONArray(str);
        this.configCache = new HashMap<>();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            String string = jSONArray.getString(i11);
            try {
                Gson instance = GsonUtil.getInstance();
                Class cls = ConfigResponseItem.class;
                ConfigResponseItem configResponseItem = (ConfigResponseItem) (!(instance instanceof Gson) ? instance.fromJson(string, cls) : GsonInstrumentation.fromJson(instance, string, cls));
                this.configCache.put(configResponseItem.getItemName(), configResponseItem.getItemValue());
            } catch (JsonSyntaxException unused) {
                LogConsole.e(TAG, "jsonArray2Map failed");
            }
        }
    }

    private void loadConfigCache(PreferencesHelper preferencesHelper) {
        synchronized (SYNC_LOCK) {
            if (this.configCache == null) {
                String string = preferencesHelper.getString(KEY_CONFIG_DATA);
                if (TextUtils.isEmpty(string)) {
                    LogConsole.e(TAG, "load cache config empty");
                    return;
                }
                String decrypt = new LocationSecurityManager(3).decrypt(string, SECURITY_PARAMS);
                if (TextUtils.isEmpty(decrypt)) {
                    LogConsole.e(TAG, "load config decrypt failed");
                    return;
                }
                try {
                    Type type = new yn(this).getType();
                    Gson instance = GsonUtil.getInstance();
                    this.configCache = (HashMap) (!(instance instanceof Gson) ? instance.fromJson(decrypt, type) : GsonInstrumentation.fromJson(instance, decrypt, type));
                } catch (JsonSyntaxException unused) {
                    LogConsole.e(TAG, "load config jsonSyntax failed");
                }
            }
        }
    }

    private String requestConfig() {
        StringBuilder sb2;
        String str;
        try {
            BaseRequest.Builder body = new BaseRequest.Builder(CONFIG_URL).setHeads(new HeadBuilder(String.valueOf(UUID.randomUUID()))).setBody(new RequestJsonBody.Builder().add(GROUP_NAME, GROUP_NAME_LITE_SDK).build());
            Gson instance = GsonUtil.getInstance();
            ArrayList<ConfigResponseItem> data = ((ConfigResponseData) new HttpClientEx().newSubmit(body.build()).execute(ConfigResponseData.class)).getData();
            return !(instance instanceof Gson) ? instance.toJson((Object) data) : GsonInstrumentation.toJson(instance, (Object) data);
        } catch (OnErrorException e11) {
            sb2 = new StringBuilder();
            sb2.append("OnErrorException:code:");
            sb2.append(e11.getErrorCode().code);
            sb2.append(",apiCode:");
            sb2.append(e11.getApiCode());
            sb2.append(",apiMsg:");
            str = e11.getApiMsg();
            sb2.append(str);
            LogConsole.e(TAG, sb2.toString());
            return null;
        } catch (OnFailureException e12) {
            sb2 = new StringBuilder();
            sb2.append("OnFailureException:");
            sb2.append(e12.getErrorCode().code);
            sb2.append(",");
            str = e12.getErrorCode().msg;
            sb2.append(str);
            LogConsole.e(TAG, sb2.toString());
            return null;
        }
    }

    private void save2Storage(String str) {
        String encrypt = new LocationSecurityManager(3).encrypt(str, SECURITY_PARAMS);
        if (TextUtils.isEmpty(encrypt)) {
            LogConsole.e(TAG, "save config to storage fail");
            return;
        }
        PreferencesHelper preferencesHelper = new PreferencesHelper(SP_NAME);
        preferencesHelper.saveString(KEY_CONFIG_DATA, encrypt);
        preferencesHelper.saveLong(KEY_CACHE_TIME, System.currentTimeMillis());
        LogConsole.i(TAG, "save config to storage end");
    }

    public <T extends ConfigBaseResponse> T getConfig(String str, Class<T> cls) {
        checkConfigData();
        HashMap<String, String> hashMap = this.configCache;
        if (hashMap == null) {
            return null;
        }
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Gson instance = GsonUtil.getInstance();
            return (ConfigBaseResponse) (!(instance instanceof Gson) ? instance.fromJson(str2, cls) : GsonInstrumentation.fromJson(instance, str2, cls));
        } catch (JsonSyntaxException unused) {
            LogConsole.e(TAG, "getConfig failed");
            return null;
        }
    }

    public String getConfig(String str) {
        checkConfigData();
        HashMap<String, String> hashMap = this.configCache;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }

    public String getConfig(String str, String str2) {
        checkConfigData();
        HashMap<String, String> hashMap = this.configCache;
        String str3 = null;
        if (hashMap == null) {
            return null;
        }
        String str4 = hashMap.get(str);
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        try {
            str3 = (String) new JSONObject(str4).get(str2);
        } catch (JSONException unused) {
            LogConsole.e(TAG, "json parse failed");
        }
        LogConsole.d(TAG, "key=" + str2 + ",value=" + str3);
        return str3;
    }

    public void requestConfigSync() {
        synchronized (SYNC_LOCK) {
            LogConsole.i(TAG, "requestConfigSync start");
            if (this.configCache != null) {
                LogConsole.i(TAG, "configCache is init");
                return;
            }
            try {
                String requestConfig = requestConfig();
                if (!TextUtils.isEmpty(requestConfig)) {
                    jsonArray2Map(requestConfig);
                    Gson instance = GsonUtil.getInstance();
                    HashMap<String, String> hashMap = this.configCache;
                    save2Storage(!(instance instanceof Gson) ? instance.toJson((Object) hashMap) : GsonInstrumentation.toJson(instance, (Object) hashMap));
                }
            } catch (JSONException unused) {
                LogConsole.e(TAG, "JSONException");
            }
        }
    }

    public <T extends ConfigBaseResponse> T updateAndGetConfig(String str, Class<T> cls) {
        this.configCache = null;
        requestConfigSync();
        return getConfig(str, cls);
    }

    public String updateAndGetConfig(String str) {
        this.configCache = null;
        requestConfigSync();
        return getConfig(str);
    }
}
