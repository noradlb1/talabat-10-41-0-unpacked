package com.instabug.library.model.session;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributesDbHelper;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.model.UserAttributes;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.user.UserEvent;
import com.instabug.library.user.f;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.a;
import com.instabug.library.util.filters.Filters;
import com.instabug.library.util.filters.h;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class SessionLocalEntity {
    private final String appToken;
    private final String appVersion;
    private final boolean crashReportingEnabled;
    private final String customAttributes;
    private final String customAttributesKeys;
    private final String device;
    private final long duration;

    /* renamed from: id  reason: collision with root package name */
    private final String f51578id;
    private final boolean isStitchedSessionLead;

    /* renamed from: os  reason: collision with root package name */
    private final String f51579os;
    @Nullable
    private final String productionUsage;
    private final String sdkVersion;
    private final long startedAt;
    private final int syncStatus;
    private final String userEmail;
    private final String userEvents;
    private final String userEventsKeys;
    private final String userName;
    private final boolean usersPageEnabled;
    private final String uuid;

    @Instrumented
    public static class Factory {
        @Nullable
        private String getAppToken() {
            return SettingsManager.getInstance().getAppToken();
        }

        @Nullable
        private String getAppVersion(Context context) {
            if (context == null) {
                return null;
            }
            return InstabugDeviceProperties.getAppVersion(context);
        }

        private long getCurrentSessionTimeUntilNow() {
            long sessionStartedAt = SettingsManager.getInstance().getSessionStartedAt();
            if (sessionStartedAt == 0) {
                return 0;
            }
            return (System.currentTimeMillis() / 1000) - sessionStartedAt;
        }

        @Nullable
        private String getDevice(boolean z11) {
            if (z11) {
                return InstabugDeviceProperties.getDeviceType();
            }
            return null;
        }

        @Nullable
        private String getOs(boolean z11) {
            if (!z11) {
                return null;
            }
            return "SDK Level " + InstabugDeviceProperties.getCurrentOSLevel();
        }

        @Nullable
        private String getProductionUsage() {
            if (InstabugCore.isFeatureAvailable(Feature.PRODUCTION_USAGE_DETECTION)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    String a11 = a.a(Instabug.getApplicationContext());
                    if (a11 != null) {
                        jSONObject.put("store_url", (Object) a11);
                    } else {
                        jSONObject.put("store_url", (Object) "other");
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("enabled", InstabugCore.isFeatureEnabled(Feature.BUG_REPORTING));
                    jSONObject2.put("bugs", (Object) jSONObject3);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("enabled", InstabugCore.isFeatureEnabled(Feature.SURVEYS));
                    jSONObject2.put("surveys", (Object) jSONObject4);
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("enabled", InstabugCore.isFeatureEnabled(Feature.FEATURE_REQUESTS));
                    jSONObject2.put("feature_requests", (Object) jSONObject5);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("enabled", InstabugCore.isAPMEnabled());
                    jSONObject2.put("apm", (Object) jSONObject6);
                    jSONObject.put("features", (Object) jSONObject2);
                    return JSONObjectInstrumentation.toString(jSONObject);
                } catch (JSONException unused) {
                }
            }
            return null;
        }

        @NonNull
        private String getSdkVersion() {
            return "11.7.0";
        }

        private long getSessionStartedAt() {
            return SettingsManager.getInstance().getSessionStartedAt();
        }

        private int getSyncStatus() {
            return isFirstSession() ? 1 : 0;
        }

        @NonNull
        private String getUserAttributesAsStringJsonObject() {
            HashMap hashMap = (HashMap) Filters.applyOn(UserAttributesDbHelper.getAll()).apply(h.g()).thenGet();
            if (hashMap == null || hashMap.size() == 0) {
                return "{}";
            }
            UserAttributes userAttributes = new UserAttributes();
            userAttributes.putMap(hashMap);
            return userAttributes.toString();
        }

        @NonNull
        private String getUserAttributesKeysAsStringJsonArray() {
            HashMap hashMap = (HashMap) Filters.applyOn(UserAttributesDbHelper.getAll()).apply(h.g()).thenGet();
            if (hashMap == null || hashMap.size() == 0) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            UserAttributes userAttributes = new UserAttributes();
            userAttributes.putMap(hashMap);
            return userAttributes.keysAsStringJsonArray();
        }

        @Nullable
        private String getUserEmail(boolean z11) {
            if (z11) {
                return f.h();
            }
            return null;
        }

        @NonNull
        private String getUserEventsAsStringJsonArray() {
            try {
                JSONArray json = UserEvent.toJson(new ArrayList(InstabugUserEventLogger.getInstance().getUserEvents()));
                if (!(json instanceof JSONArray)) {
                    return json.toString();
                }
                return JSONArrayInstrumentation.toString(json);
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-Core", "parsing user events got error: " + e11.getMessage(), e11);
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
        }

        @NonNull
        private String getUserEventsKeysAsStringJsonArray() {
            JSONArray keysAsJsonArray = UserEvent.keysAsJsonArray(new ArrayList(InstabugUserEventLogger.getInstance().getUserEvents()));
            if (!(keysAsJsonArray instanceof JSONArray)) {
                return keysAsJsonArray.toString();
            }
            return JSONArrayInstrumentation.toString(keysAsJsonArray);
        }

        @Nullable
        private String getUserName(boolean z11) {
            if (z11) {
                return f.i();
            }
            return null;
        }

        @NonNull
        private String getUuid() {
            return f.k();
        }

        private boolean isCrashReportingEnabled() {
            return InstabugCore.isCrashReportingEnabled();
        }

        private boolean isFirstSession() {
            return SettingsManager.getInstance().isFirstSession();
        }

        @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
        @NonNull
        public SessionLocalEntity create(Context context, @NonNull com.instabug.library.model.common.a aVar, boolean z11) {
            boolean z12 = z11;
            return new SessionLocalEntity(aVar.getId(), getOs(z12), getDevice(z12), getCurrentSessionTimeUntilNow(), getSessionStartedAt(), getUserName(z12), getUserEmail(z12), getSdkVersion(), getAppVersion(context), getUserEventsAsStringJsonArray(), getUserAttributesAsStringJsonObject(), getUserEventsKeysAsStringJsonArray(), getUserAttributesKeysAsStringJsonArray(), isCrashReportingEnabled(), getSyncStatus(), getUuid(), getAppToken(), z11, getProductionUsage(), aVar.isStitchedSessionLead());
        }
    }

    public SessionLocalEntity(String str, String str2, String str3, long j11, long j12, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z11, int i11, String str12, String str13, boolean z12, @Nullable String str14, boolean z13) {
        this.f51578id = str;
        this.f51579os = str2;
        this.device = str3;
        this.duration = j11;
        this.startedAt = j12;
        this.userName = str4;
        this.userEmail = str5;
        this.sdkVersion = str6;
        this.appVersion = str7;
        this.userEvents = str8;
        this.customAttributes = str9;
        this.userEventsKeys = str10;
        this.customAttributesKeys = str11;
        this.crashReportingEnabled = z11;
        this.syncStatus = i11;
        this.uuid = str12;
        this.appToken = str13;
        this.usersPageEnabled = z12;
        this.productionUsage = str14;
        this.isStitchedSessionLead = z13;
    }

    public String getAppToken() {
        return this.appToken;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getCustomAttributes() {
        return this.customAttributes;
    }

    public String getCustomAttributesKeys() {
        return this.customAttributesKeys;
    }

    public String getDevice() {
        return this.device;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getId() {
        return this.f51578id;
    }

    public String getOs() {
        return this.f51579os;
    }

    @Nullable
    public String getProductionUsage() {
        return this.productionUsage;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public long getStartTimestampMicros() {
        return this.startedAt;
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getUserEvents() {
        return this.userEvents;
    }

    public String getUserEventsKeys() {
        return this.userEventsKeys;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isCrashReportingEnabled() {
        return this.crashReportingEnabled;
    }

    public boolean isStitchedSessionLead() {
        return this.isStitchedSessionLead;
    }

    public boolean isUsersPageEnabled() {
        return this.usersPageEnabled;
    }
}
