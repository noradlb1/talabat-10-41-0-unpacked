package com.instabug.library.model;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.offline.DownloadService;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.e0;
import com.instabug.library.experiments.di.a;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributesDbHelper;
import com.instabug.library.internal.storage.operation.ReadStateFromFileDiskOperation;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.logging.d;
import com.instabug.library.sessionprofiler.model.timeline.e;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.tracking.n;
import com.instabug.library.user.UserEvent;
import com.instabug.library.user.f;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.memory.MemoryGuard;
import com.instabug.library.util.memory.MemoryUtils;
import com.instabug.library.visualusersteps.VisualUserStep;
import com.instabug.library.visualusersteps.y;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Instrumented
public class State implements Cacheable, Serializable {
    private static final String BUILD_PERCENTAGE = "build_percentage";
    private static final float FULL_STATE_PERCENTAGE = 1.0f;
    public static final String KEY_APP_PACKAGE_NAME = "bundle_id";
    private static final String KEY_APP_STATUS = "app_status";
    public static final String KEY_APP_VERSION = "app_version";
    private static final String KEY_BATTERY_LEVEL = "battery_level";
    private static final String KEY_BATTERY_STATUS = "battery_state";
    public static final String KEY_CARRIER = "carrier";
    public static final String KEY_CONSOLE_LOG = "console_log";
    public static final String KEY_CURRENT_ACTIVITY = "current_activity";
    public static final String KEY_CURRENT_VIEW = "current_view";
    public static final String KEY_DENSITY = "density";
    public static final String KEY_DEVICE = "device";
    public static final String KEY_DEVICE_ARCHITECTURE = "device_architecture";
    public static final String KEY_DEVICE_ROOTED = "device_rooted";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_EXPERIMENTS = "experiments";
    public static final String KEY_INSTABUG_LOG = "instabug_log";
    public static final String KEY_LOCALE = "locale";
    private static final String KEY_MEMORY_FREE = "memory_free";
    private static final String KEY_MEMORY_TOTAL = "memory_total";
    private static final String KEY_MEMORY_USED = "memory_used";
    public static final String KEY_NAME = "name";
    public static final String KEY_NETWORK_LOGS = "network_log";
    public static final String KEY_ORIENTATION = "orientation";
    public static final String KEY_OS = "os";
    public static final String KEY_PUSH_TOKEN = "push_token";
    public static final String KEY_REPORTED_AT = "reported_at";
    public static final String KEY_SCREEN_SIZE = "screen_size";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_SESSIONS_PROFILER = "sessions_profiler";
    public static final String KEY_STORAGE_FREE = "storage_free";
    public static final String KEY_STORAGE_TOTAL = "storage_total";
    public static final String KEY_STORAGE_USED = "storage_used";
    public static final String KEY_TAGS = "tags";
    public static final String KEY_USER_ATTRIBUTES = "user_attributes";
    public static final String KEY_USER_DATA = "user_data";
    public static final String KEY_USER_EVENTS = "user_events";
    public static final String KEY_USER_STEPS = "user_steps";
    public static final String KEY_VISUAL_USER_STEPS = "user_repro_steps";
    public static final String KEY_WIFI_STATE = "wifi_state";
    private static final String[] USER_DATA_KEYS = {"user_attributes", "email", "name", KEY_PUSH_TOKEN};
    public static final String UUID = "UUID";
    @Nullable
    private String OS;
    @Nullable
    private String ScreenOrientation;
    @Nullable
    private String appPackageName;
    @Nullable
    private String appStatus;
    @Nullable
    private String appVersion;
    private int batteryLevel;
    @Nullable
    private String batteryState;
    private float buildPercentage = 1.0f;
    @Nullable
    private String carrier;
    @Nullable
    private ArrayList<a> consoleLog;
    @Nullable
    private String currentActivity;
    @Nullable
    private String currentView;
    @Nullable
    private String customUserAttribute;
    @Nullable
    private String device;
    @Nullable
    private String deviceArchitecture;
    private long duration;
    @Nullable
    private List<String> experiments;
    private long freeMemory;
    public long freeStorage;
    @Nullable
    private String instabugLog;
    private boolean isDeviceRooted;
    private boolean isMinimalState;
    @Nullable
    private String locale;
    @Nullable
    private String networkLogs;
    @Nullable
    private String pushToken;
    private long reportedAt;
    @Nullable
    private String screenDensity;
    @Nullable
    private String screenSize;
    @Nullable
    private String sdkVersion;
    @Nullable
    private e sessionProfilerTimeline;
    @Nullable
    private String tags;
    private long totalMemory;
    private long totalStorage;
    @Nullable
    private Uri uri;
    private long usedMemory;
    private long usedStorage;
    @Nullable
    private String userAttributes;
    @Nullable
    private String userData;
    @Nullable
    private String userEmail;
    @Nullable
    private String userEvents;
    @Nullable
    private String userName;
    @Nullable
    private List<o> userSteps;
    @Nullable
    private String uuid;
    @Nullable
    private ArrayList<VisualUserStep> visualUserSteps;
    private boolean wifiState;

    @Keep
    public enum Action {
        FINISHED,
        ERROR
    }

    @Instrumented
    public static class Builder implements Serializable {
        private Context context;
        private boolean withCurrentActivity = false;

        public Builder(Context context2) {
            this.context = context2;
        }

        /* access modifiers changed from: private */
        public static ArrayList<a> getConsoleLog(float f11) {
            return a.a(f11);
        }

        private String getCurrentActivity() {
            Activity currentRealActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentRealActivity();
            if (currentRealActivity == null) {
                return "NA";
            }
            return currentRealActivity.getClass().getName();
        }

        @Nullable
        private List<String> getExperiments(float f11) {
            List<String> a11 = a.c().a(f11);
            int round = Math.round(((float) a.d()) * f11);
            if (a11 != null && a11.size() > round) {
                while (a11.size() > 0 && a11.size() > round) {
                    a11.remove(0);
                }
            }
            return a11;
        }

        @Nullable
        private String getInstabugLog() {
            if (!MemoryUtils.isLowMemory(this.context)) {
                try {
                    if (e0.c().b((Object) Feature.INSTABUG_LOGS) == Feature.State.ENABLED) {
                        return InstabugLog.getLogs();
                    }
                    return null;
                } catch (OutOfMemoryError e11) {
                    InstabugCore.reportError(e11, "Got error while parsing user events logs");
                    InstabugSDKLogger.e("IBG-Core", "Got error while parsing user events logs", e11);
                    return null;
                }
            } else {
                InstabugSDKLogger.e("IBG-Core", "Running low on memory. Excluding UserEvents serialization from state builder.");
                return null;
            }
        }

        private String getPushNotificationToken() {
            return InstabugCore.getPushNotificationToken();
        }

        private long getReportedAt() {
            return InstabugDateFormatter.getCurrentUTCTimeStampInSeconds();
        }

        private e getSessionProfilerTimeline(float f11) {
            return com.instabug.library.sessionprofiler.e.a().a(f11);
        }

        private String getTags() {
            return SettingsManager.getInstance().getTagsAsString();
        }

        private String getUserData() {
            return SettingsManager.getInstance().getUserData();
        }

        private String getUserEmail() {
            return f.n();
        }

        private String getUserEvents(float f11) {
            if (!MemoryUtils.isLowMemory(this.context)) {
                try {
                    JSONArray json = UserEvent.toJson(InstabugUserEventLogger.getInstance().getUserEvents(f11));
                    if (!(json instanceof JSONArray)) {
                        return json.toString();
                    }
                    return JSONArrayInstrumentation.toString(json);
                } catch (OutOfMemoryError | JSONException e11) {
                    InstabugSDKLogger.e("IBG-Core", "Got error while parsing user events logs", e11);
                    return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                }
            } else {
                InstabugSDKLogger.e("IBG-Core", "Running low on memory. Excluding UserEvents serialization from state builder.");
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
        }

        private String getUserName() {
            return f.o();
        }

        private List<o> getUserSteps(float f11) {
            try {
                int round = Math.round(f11 * 100.0f);
                ArrayList b11 = n.a().b();
                if (b11.size() <= round) {
                    return b11;
                }
                return b11.subList(b11.size() - round, b11.size());
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Unable to get user steps", e11);
                return new ArrayList();
            }
        }

        /* access modifiers changed from: private */
        public static ArrayList<VisualUserStep> getVisualUserSteps() {
            return y.d().b();
        }

        @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
        public State build(boolean z11) {
            return build(z11, false, 1.0f);
        }

        public State buildInternalState() {
            String str;
            State carrier = new State().setSdkVersion(DeviceStateProvider.getSdkVersion()).setLocale(DeviceStateProvider.getLocale(this.context)).setDuration(DeviceStateProvider.getActiveSessionDuration()).setDevice(DeviceStateProvider.getDevice()).setIsDeviceRooted(DeviceStateProvider.isDeviceRooted()).setOS(DeviceStateProvider.getOS()).setCarrier(DeviceStateProvider.getCarrier(this.context));
            if (InstabugCore.getStartedActivitiesCount() > 0) {
                str = DownloadService.KEY_FOREGROUND;
            } else {
                str = "background";
            }
            return carrier.setAppStatus(str).setAppVersion(DeviceStateProvider.getAppVersion(this.context)).setAppPackageName(DeviceStateProvider.getAppPackageName(this.context)).setBatteryLevel(DeviceStateProvider.getBatteryLevel(this.context)).setBatteryState(DeviceStateProvider.getBatteryState(this.context)).setWifiState(DeviceStateProvider.getWifiState(this.context)).setFreeMemory(DeviceStateProvider.getFreeMemory(this.context)).setUsedMemory(DeviceStateProvider.getUsedMemory(this.context)).setTotalMemory(DeviceStateProvider.getTotalMemory(this.context)).setFreeStorage(DeviceStateProvider.getFreeStorage()).setUsedStorage(DeviceStateProvider.getUsedStorage()).setTotalStorage(DeviceStateProvider.getTotalStorage()).setScreenDensity(DeviceStateProvider.getScreenDensity(this.context)).setScreenSize(DeviceStateProvider.getScreenSize(this.context)).setScreenOrientation(DeviceStateProvider.getScreenOrientation(this.context)).setCurrentView(InstabugCore.getCurrentView()).setReportedAt(getReportedAt());
        }

        public State buildSimplifiedState() {
            String str;
            State carrier = new State().setSdkVersion(DeviceStateProvider.getSdkVersion()).setLocale(DeviceStateProvider.getLocale(this.context)).setDuration(DeviceStateProvider.getActiveSessionDuration()).setDevice(DeviceStateProvider.getDevice()).setIsDeviceRooted(DeviceStateProvider.isDeviceRooted()).setOS(DeviceStateProvider.getOS()).setCarrier(DeviceStateProvider.getCarrier(this.context));
            if (InstabugCore.getStartedActivitiesCount() > 0) {
                str = DownloadService.KEY_FOREGROUND;
            } else {
                str = "background";
            }
            return carrier.setAppStatus(str).setAppVersion(DeviceStateProvider.getAppVersion(this.context)).setAppPackageName(DeviceStateProvider.getAppPackageName(this.context)).setBatteryLevel(DeviceStateProvider.getBatteryLevel(this.context)).setBatteryState(DeviceStateProvider.getBatteryState(this.context)).setWifiState(DeviceStateProvider.getWifiState(this.context)).setFreeMemory(DeviceStateProvider.getFreeMemory(this.context)).setUsedMemory(DeviceStateProvider.getUsedMemory(this.context)).setTotalMemory(DeviceStateProvider.getTotalMemory(this.context)).setFreeStorage(DeviceStateProvider.getFreeStorage()).setUsedStorage(DeviceStateProvider.getUsedStorage()).setTotalStorage(DeviceStateProvider.getTotalStorage()).setScreenDensity(DeviceStateProvider.getScreenDensity(this.context)).setScreenSize(DeviceStateProvider.getScreenSize(this.context)).setScreenOrientation(DeviceStateProvider.getScreenOrientation(this.context)).setCurrentView(InstabugCore.getCurrentView()).setReportedAt(getReportedAt()).setDeviceArchitecture(DeviceStateProvider.getDeviceArchitecture()).setUuid(f.k());
        }

        public String formatSessionDuration(long j11) {
            StringBuilder sb2 = new StringBuilder();
            int i11 = ((int) j11) % 60;
            long j12 = j11 / 60;
            int i12 = ((int) j12) % 60;
            int i13 = ((int) (j12 / 60)) % 60;
            if (i13 <= 9) {
                sb2.append("0");
            }
            sb2.append(i13);
            sb2.append(CertificateUtil.DELIMITER);
            if (i12 <= 9) {
                sb2.append("0");
            }
            sb2.append(i12);
            sb2.append(CertificateUtil.DELIMITER);
            if (i11 <= 9) {
                sb2.append("0");
            }
            sb2.append(i11);
            return sb2.toString();
        }

        @Nullable
        public String getNetworkLogs(float f11) {
            return d.a(MemoryGuard.from(this.context), f11);
        }

        public Builder withCurrentActivity(boolean z11) {
            this.withCurrentActivity = z11;
            return this;
        }

        public State build(boolean z11, boolean z12, float f11) {
            State buildSimplifiedState = buildSimplifiedState();
            buildSimplifiedState.setBuildPercentage(f11).setConsoleLog(getConsoleLog(f11)).setUserSteps(getUserSteps(f11)).setUserEmail(getUserEmail()).setUserName(getUserName()).setPushToken(getPushNotificationToken()).setUserData(getUserData()).setTags(getTags()).setUserAttributes(UserAttributesDbHelper.getSDKUserAttributes()).setNetworkLogs(getNetworkLogs(f11)).setUserEvents(getUserEvents(f11));
            if (e0.c().b((Object) Feature.SESSION_PROFILER) == Feature.State.ENABLED) {
                buildSimplifiedState.setSessionProfilerTimeline(getSessionProfilerTimeline(f11));
            }
            if (z11 && getInstabugLog() != null) {
                buildSimplifiedState.setInstabugLog(getInstabugLog());
            }
            if (z12) {
                buildSimplifiedState.setExperiments(getExperiments(f11));
            }
            if (this.withCurrentActivity) {
                buildSimplifiedState.setCurrentActivity(getCurrentActivity());
            }
            return buildSimplifiedState;
        }
    }

    public static class StateItem<V> implements Serializable {
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public String f51505b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public V f51506c;

        public StateItem() {
        }

        @Nullable
        public String getKey() {
            return this.f51505b;
        }

        @Nullable
        public V getValue() {
            return this.f51506c;
        }

        public StateItem<V> setKey(@Nullable String str) {
            this.f51505b = str;
            return this;
        }

        public StateItem<V> setValue(@Nullable V v11) {
            this.f51506c = v11;
            return this;
        }

        @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
        @NonNull
        public String toString() {
            return "key: " + getKey() + ", value: " + getValue();
        }

        public StateItem(@Nullable String str, @Nullable V v11) {
            this.f51505b = str;
            this.f51506c = v11;
        }
    }

    @Nullable
    private String getDeviceArchitecture() {
        return this.deviceArchitecture;
    }

    private long getFreeStorage() {
        return this.freeStorage;
    }

    public static State getNonChangingState(Context context) {
        State uuid2 = new State().setSdkVersion(DeviceStateProvider.getSdkVersion()).setLocale(DeviceStateProvider.getLocale(context)).setDevice(DeviceStateProvider.getDevice()).setIsDeviceRooted(DeviceStateProvider.isDeviceRooted()).setOS(DeviceStateProvider.getOS()).setAppVersion(DeviceStateProvider.getAppVersion(context)).setAppPackageName(DeviceStateProvider.getAppPackageName(context)).setScreenDensity(DeviceStateProvider.getScreenDensity(context)).setScreenSize(DeviceStateProvider.getScreenSize(context)).setCurrentView("NA").setReportedAt(InstabugDateFormatter.getCurrentUTCTimeStampInSeconds()).setDeviceArchitecture(DeviceStateProvider.getDeviceArchitecture()).setUuid(f.k());
        uuid2.isMinimalState = true;
        return uuid2;
    }

    @Nullable
    private String getSessionProfilerTimeline() {
        e eVar = this.sessionProfilerTimeline;
        if (eVar == null) {
            return null;
        }
        JSONObject b11 = eVar.b();
        return !(b11 instanceof JSONObject) ? b11.toString() : JSONObjectInstrumentation.toString(b11);
    }

    public static State getState(Context context) {
        return getState(context, 1.0f);
    }

    private static String getTagsAsString(List<String> list) {
        StringBuilder sb2 = new StringBuilder();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                sb2.append(list.get(i11));
                if (i11 != size - 1) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
            }
        }
        return sb2.toString();
    }

    public static String[] getUserDataKeys() {
        return (String[]) USER_DATA_KEYS.clone();
    }

    /* access modifiers changed from: private */
    public State setAppStatus(String str) {
        this.appStatus = str;
        return this;
    }

    /* access modifiers changed from: private */
    public State setConsoleLog(ArrayList<a> arrayList) {
        this.consoleLog = arrayList;
        return this;
    }

    /* access modifiers changed from: private */
    public State setFreeStorage(long j11) {
        this.freeStorage = j11;
        return this;
    }

    /* access modifiers changed from: private */
    public State setIsDeviceRooted(boolean z11) {
        this.isDeviceRooted = z11;
        return this;
    }

    /* access modifiers changed from: private */
    public State setReportedAt(long j11) {
        this.reportedAt = j11;
        return this;
    }

    /* access modifiers changed from: private */
    public State setSdkVersion(String str) {
        this.sdkVersion = str;
        return this;
    }

    /* access modifiers changed from: private */
    public State setTotalStorage(long j11) {
        this.totalStorage = j11;
        return this;
    }

    /* access modifiers changed from: private */
    public State setUsedMemory(long j11) {
        this.usedMemory = j11;
        return this;
    }

    /* access modifiers changed from: private */
    public State setUsedStorage(long j11) {
        this.usedStorage = j11;
        return this;
    }

    /* access modifiers changed from: private */
    public State setWifiState(boolean z11) {
        this.wifiState = z11;
        return this;
    }

    @SuppressLint({"NP_METHOD_PARAMETER_TIGHTENS_ANNOTATION"})
    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof State)) {
            return false;
        }
        State state = (State) obj;
        if (!String.valueOf(state.getAppVersion()).equals(String.valueOf(getAppVersion())) || state.getBatteryLevel() != getBatteryLevel() || !String.valueOf(state.getBatteryState()).equals(String.valueOf(getBatteryState())) || !String.valueOf(state.getCarrier()).equals(String.valueOf(getCarrier())) || !String.valueOf(state.getAppStatus()).equals(String.valueOf(getAppStatus())) || !String.valueOf(state.getConsoleLog()).equals(String.valueOf(getConsoleLog())) || !String.valueOf(state.getCurrentView()).equals(String.valueOf(getCurrentView())) || state.getDuration() != getDuration() || !String.valueOf(state.getDevice()).equals(String.valueOf(getDevice())) || state.getFreeMemory() != getFreeMemory() || state.getFreeStorage() != getFreeStorage() || !String.valueOf(state.getLocale()).equals(String.valueOf(getLocale())) || !String.valueOf(state.getOS()).equals(String.valueOf(getOS())) || state.getReportedAt() != getReportedAt() || !String.valueOf(state.getScreenDensity()).equals(String.valueOf(getScreenDensity())) || !String.valueOf(state.getScreenOrientation()).equals(String.valueOf(getScreenOrientation())) || !String.valueOf(state.getScreenSize()).equals(String.valueOf(getScreenSize())) || !String.valueOf(state.getSdkVersion()).equals(String.valueOf(getSdkVersion())) || state.getTotalMemory() != getTotalMemory() || state.getTotalStorage() != getTotalStorage() || !String.valueOf(state.getTags()).equals(String.valueOf(getTags())) || state.getUsedMemory() != getUsedMemory() || state.getUsedStorage() != getUsedStorage() || !String.valueOf(state.getUserData()).equals(String.valueOf(getUserData())) || !String.valueOf(state.getUserEmail()).equals(String.valueOf(getUserEmail())) || !String.valueOf(state.getUserName()).equals(String.valueOf(getUserName())) || !String.valueOf(state.getPushToken()).equals(String.valueOf(getPushToken())) || !String.valueOf(state.getUserSteps()).equals(String.valueOf(getUserSteps())) || state.isDeviceRooted() != isDeviceRooted() || state.isWifiEnable() != isWifiEnable() || !String.valueOf(state.getInstabugLog()).equals(String.valueOf(getInstabugLog())) || !String.valueOf(state.getUserAttributes()).equals(String.valueOf(getUserAttributes())) || !String.valueOf(state.getNetworkLogs()).equals(String.valueOf(getNetworkLogs())) || !String.valueOf(state.getUserEvents()).equals(String.valueOf(getUserEvents())) || !String.valueOf(state.getVisualUserSteps()).equals(String.valueOf(getVisualUserSteps())) || !String.valueOf(state.getSessionProfilerTimeline()).equals(String.valueOf(getSessionProfilerTimeline()))) {
            return false;
        }
        return true;
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(KEY_APP_PACKAGE_NAME)) {
            setAppPackageName(jSONObject.getString(KEY_APP_PACKAGE_NAME));
        }
        if (jSONObject.has("app_version")) {
            setAppVersion(jSONObject.getString("app_version"));
        }
        if (jSONObject.has(KEY_BATTERY_LEVEL)) {
            setBatteryLevel(jSONObject.getInt(KEY_BATTERY_LEVEL));
        }
        if (jSONObject.has(KEY_BATTERY_STATUS)) {
            setBatteryState(jSONObject.getString(KEY_BATTERY_STATUS));
        }
        if (jSONObject.has("carrier")) {
            setCarrier(jSONObject.getString("carrier"));
        }
        if (jSONObject.has(KEY_CONSOLE_LOG)) {
            setConsoleLog(a.a(new JSONArray(jSONObject.getString(KEY_CONSOLE_LOG))));
        }
        if (jSONObject.has(KEY_CURRENT_VIEW)) {
            setCurrentView(jSONObject.getString(KEY_CURRENT_VIEW));
        }
        if (jSONObject.has(KEY_DENSITY)) {
            setScreenDensity(jSONObject.getString(KEY_DENSITY));
        }
        if (jSONObject.has("device")) {
            setDevice(jSONObject.getString("device"));
        }
        if (jSONObject.has(KEY_DEVICE_ROOTED)) {
            setIsDeviceRooted(jSONObject.getBoolean(KEY_DEVICE_ROOTED));
        }
        if (jSONObject.has("duration")) {
            setDuration(jSONObject.getLong("duration"));
        }
        if (jSONObject.has("email")) {
            setUserEmail(jSONObject.getString("email"));
        }
        if (jSONObject.has("name")) {
            setUserName(jSONObject.getString("name"));
        }
        if (jSONObject.has(KEY_PUSH_TOKEN)) {
            setPushToken(jSONObject.getString(KEY_PUSH_TOKEN));
        }
        if (jSONObject.has(KEY_INSTABUG_LOG)) {
            setInstabugLog(jSONObject.getString(KEY_INSTABUG_LOG));
        }
        if (jSONObject.has("locale")) {
            setLocale(jSONObject.getString("locale"));
        }
        if (jSONObject.has(KEY_MEMORY_FREE)) {
            setFreeMemory(jSONObject.getLong(KEY_MEMORY_FREE));
        }
        if (jSONObject.has(KEY_MEMORY_TOTAL)) {
            setTotalMemory(jSONObject.getLong(KEY_MEMORY_TOTAL));
        }
        if (jSONObject.has(KEY_MEMORY_USED)) {
            setUsedMemory(jSONObject.getLong(KEY_MEMORY_USED));
        }
        if (jSONObject.has("orientation")) {
            setScreenOrientation(jSONObject.getString("orientation"));
        }
        if (jSONObject.has("os")) {
            setOS(jSONObject.getString("os"));
        }
        if (jSONObject.has(KEY_APP_STATUS)) {
            setAppStatus(jSONObject.getString(KEY_APP_STATUS));
        }
        if (jSONObject.has(KEY_REPORTED_AT)) {
            setReportedAt(jSONObject.getLong(KEY_REPORTED_AT));
        }
        if (jSONObject.has(KEY_SCREEN_SIZE)) {
            setScreenSize(jSONObject.getString(KEY_SCREEN_SIZE));
        }
        if (jSONObject.has("sdk_version")) {
            setSdkVersion(jSONObject.getString("sdk_version"));
        }
        if (jSONObject.has(KEY_STORAGE_FREE)) {
            setFreeStorage(jSONObject.getLong(KEY_STORAGE_FREE));
        }
        if (jSONObject.has(KEY_STORAGE_TOTAL)) {
            setTotalStorage(jSONObject.getLong(KEY_STORAGE_TOTAL));
        }
        if (jSONObject.has(KEY_STORAGE_USED)) {
            setUsedStorage(jSONObject.getLong(KEY_STORAGE_USED));
        }
        if (jSONObject.has("tags")) {
            setTags(jSONObject.getString("tags"));
        }
        if (jSONObject.has(KEY_USER_DATA)) {
            setUserData(jSONObject.getString(KEY_USER_DATA));
        }
        if (jSONObject.has(KEY_USER_STEPS)) {
            setUserSteps(o.a(new JSONArray(jSONObject.getString(KEY_USER_STEPS))));
        }
        if (jSONObject.has(KEY_WIFI_STATE)) {
            setWifiState(jSONObject.getBoolean(KEY_WIFI_STATE));
        }
        if (jSONObject.has("user_attributes")) {
            setUserAttributes(jSONObject.getString("user_attributes"));
        }
        if (jSONObject.has(KEY_NETWORK_LOGS)) {
            setNetworkLogs(jSONObject.getString(KEY_NETWORK_LOGS));
        }
        if (jSONObject.has("user_events")) {
            setUserEvents(jSONObject.getString("user_events"));
        }
        if (jSONObject.has(KEY_VISUAL_USER_STEPS)) {
            setVisualUserSteps(VisualUserStep.fromJson(new JSONArray(jSONObject.getString(KEY_VISUAL_USER_STEPS))));
        }
        if (jSONObject.has(KEY_SESSIONS_PROFILER)) {
            setSessionProfilerTimeline(e.a(new JSONObject(jSONObject.getString(KEY_SESSIONS_PROFILER))));
        }
        if (jSONObject.has(KEY_EXPERIMENTS)) {
            JSONArray jSONArray = jSONObject.getJSONArray(KEY_EXPERIMENTS);
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add((String) jSONArray.get(i11));
            }
            setExperiments(arrayList);
        }
        if (jSONObject.has(BUILD_PERCENTAGE)) {
            setBuildPercentage((float) jSONObject.getDouble(BUILD_PERCENTAGE));
        }
        if (jSONObject.has(KEY_CURRENT_ACTIVITY)) {
            setCurrentActivity(jSONObject.getString(KEY_CURRENT_ACTIVITY));
        }
        setDeviceArchitecture(jSONObject.optString(KEY_DEVICE_ARCHITECTURE));
        setUuid(jSONObject.optString(this.uuid));
    }

    @Nullable
    public String getAppPackageName() {
        return this.appPackageName;
    }

    @Nullable
    public String getAppStatus() {
        return this.appStatus;
    }

    @Nullable
    public String getAppVersion() {
        return this.appVersion;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    @Nullable
    public String getBatteryState() {
        return this.batteryState;
    }

    public double getBuildPercentage() {
        return (double) this.buildPercentage;
    }

    @Nullable
    public String getCarrier() {
        return this.carrier;
    }

    public JSONArray getConsoleLog() {
        return a.a((ArrayList) this.consoleLog);
    }

    @Nullable
    public String getCurrentView() {
        return this.currentView;
    }

    @Nullable
    public String getCustomUserAttribute() {
        return this.customUserAttribute;
    }

    @Nullable
    public String getDevice() {
        return this.device;
    }

    public long getDuration() {
        return this.duration;
    }

    @Nullable
    public List<String> getExperiments() {
        return this.experiments;
    }

    public long getFreeMemory() {
        return this.freeMemory;
    }

    @Nullable
    public String getInstabugLog() {
        return this.instabugLog;
    }

    @Nullable
    public String getLocale() {
        return this.locale;
    }

    public ArrayList<StateItem> getLogsItems() {
        String str;
        String str2;
        ArrayList<StateItem> arrayList = new ArrayList<>();
        StateItem key = new StateItem().setKey(KEY_CONSOLE_LOG);
        JSONArray consoleLog2 = getConsoleLog();
        if (!(consoleLog2 instanceof JSONArray)) {
            str = consoleLog2.toString();
        } else {
            str = JSONArrayInstrumentation.toString(consoleLog2);
        }
        arrayList.add(key.setValue(str));
        arrayList.add(new StateItem().setKey(KEY_INSTABUG_LOG).setValue(getInstabugLog()));
        arrayList.add(new StateItem().setKey(KEY_USER_DATA).setValue(getUserData()));
        arrayList.add(new StateItem().setKey(KEY_NETWORK_LOGS).setValue(getNetworkLogs()));
        arrayList.add(new StateItem().setKey("user_events").setValue(getUserEvents()));
        Feature.State b11 = e0.c().b((Object) Feature.TRACK_USER_STEPS);
        Feature.State state = Feature.State.ENABLED;
        if (b11 == state) {
            StateItem key2 = new StateItem().setKey(KEY_USER_STEPS);
            JSONArray userSteps2 = getUserSteps();
            if (!(userSteps2 instanceof JSONArray)) {
                str2 = userSteps2.toString();
            } else {
                str2 = JSONArrayInstrumentation.toString(userSteps2);
            }
            arrayList.add(key2.setValue(str2));
        }
        if (e0.c().b((Object) Feature.REPRO_STEPS) == state) {
            arrayList.add(new StateItem().setKey(KEY_VISUAL_USER_STEPS).setValue(getVisualUserSteps()));
        }
        if (e0.c().b((Object) Feature.SESSION_PROFILER) == state && this.sessionProfilerTimeline != null) {
            arrayList.add(new StateItem().setKey(KEY_SESSIONS_PROFILER).setValue(getSessionProfilerTimeline()));
        }
        return arrayList;
    }

    @Nullable
    public String getNetworkLogs() {
        return this.networkLogs;
    }

    @Nullable
    public String getOS() {
        return this.OS;
    }

    @Nullable
    public String getPushToken() {
        return this.pushToken;
    }

    public long getReportedAt() {
        return this.reportedAt;
    }

    @Nullable
    public String getScreenDensity() {
        return this.screenDensity;
    }

    @Nullable
    public String getScreenOrientation() {
        return this.ScreenOrientation;
    }

    @Nullable
    public String getScreenSize() {
        return this.screenSize;
    }

    @Nullable
    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public ArrayList<StateItem> getStateItems() {
        ArrayList<StateItem> arrayList = new ArrayList<>();
        if (!this.isMinimalState) {
            arrayList.add(new StateItem().setKey(KEY_BATTERY_LEVEL).setValue(Integer.valueOf(getBatteryLevel())));
            arrayList.add(new StateItem().setKey(KEY_BATTERY_STATUS).setValue(getBatteryState()));
            arrayList.add(new StateItem().setKey("carrier").setValue(getCarrier()));
            arrayList.add(new StateItem().setKey("email").setValue(getUserEmail()));
            arrayList.add(new StateItem().setKey("name").setValue(getUserName()));
            arrayList.add(new StateItem().setKey(KEY_PUSH_TOKEN).setValue(getPushToken()));
            arrayList.add(new StateItem().setKey(KEY_MEMORY_FREE).setValue(Long.valueOf(getFreeMemory())));
            arrayList.add(new StateItem().setKey(KEY_MEMORY_TOTAL).setValue(Long.valueOf(getTotalMemory())));
            arrayList.add(new StateItem().setKey(KEY_MEMORY_USED).setValue(Long.valueOf(getUsedMemory())));
            arrayList.add(new StateItem().setKey("orientation").setValue(getScreenOrientation()));
            arrayList.add(new StateItem().setKey(KEY_STORAGE_FREE).setValue(Long.valueOf(getFreeStorage())));
            arrayList.add(new StateItem().setKey(KEY_STORAGE_TOTAL).setValue(Long.valueOf(getTotalStorage())));
            arrayList.add(new StateItem().setKey(KEY_STORAGE_USED).setValue(Long.valueOf(getUsedStorage())));
            arrayList.add(new StateItem().setKey("tags").setValue(getTags()));
            arrayList.add(new StateItem().setKey(KEY_WIFI_STATE).setValue(Boolean.valueOf(isWifiEnable())));
            arrayList.add(new StateItem().setKey("user_attributes").setValue(getUserAttributes()));
            arrayList.add(new StateItem().setKey(KEY_APP_STATUS).setValue(getAppStatus()));
            List<String> experiments2 = getExperiments();
            if (experiments2 != null && !experiments2.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String put : experiments2) {
                    jSONArray.put((Object) put);
                }
                arrayList.add(new StateItem().setKey(KEY_EXPERIMENTS).setValue(jSONArray));
            }
            if (this.currentActivity != null) {
                arrayList.add(new StateItem().setKey(KEY_CURRENT_ACTIVITY).setValue(this.currentActivity));
            }
        }
        arrayList.add(new StateItem().setKey(KEY_APP_PACKAGE_NAME).setValue(getAppPackageName()));
        arrayList.add(new StateItem().setKey("app_version").setValue(getAppVersion()));
        arrayList.add(new StateItem().setKey(KEY_CURRENT_VIEW).setValue(getCurrentView()));
        arrayList.add(new StateItem().setKey(KEY_DENSITY).setValue(getScreenDensity()));
        arrayList.add(new StateItem().setKey("device").setValue(getDevice()));
        arrayList.add(new StateItem().setKey(KEY_DEVICE_ROOTED).setValue(Boolean.valueOf(isDeviceRooted())));
        arrayList.add(new StateItem().setKey("duration").setValue(Long.valueOf(getDuration())));
        arrayList.add(new StateItem().setKey("locale").setValue(getLocale()));
        arrayList.add(new StateItem().setKey("os").setValue(getOS()));
        arrayList.add(new StateItem().setKey(KEY_REPORTED_AT).setValue(Long.valueOf(getReportedAt())));
        arrayList.add(new StateItem().setKey(KEY_SCREEN_SIZE).setValue(getScreenSize()));
        arrayList.add(new StateItem().setKey("sdk_version").setValue(getSdkVersion()));
        String deviceArchitecture2 = getDeviceArchitecture();
        if (deviceArchitecture2 != null && !deviceArchitecture2.isEmpty()) {
            arrayList.add(new StateItem().setKey(KEY_DEVICE_ARCHITECTURE).setValue(deviceArchitecture2));
        }
        return arrayList;
    }

    @Nullable
    public String getTags() {
        return this.tags;
    }

    public long getTotalMemory() {
        return this.totalMemory;
    }

    public long getTotalStorage() {
        return this.totalStorage;
    }

    @Nullable
    public Uri getUri() {
        return this.uri;
    }

    public long getUsedMemory() {
        return this.usedMemory;
    }

    public long getUsedStorage() {
        return this.usedStorage;
    }

    @Nullable
    public String getUserAttributes() {
        return this.userAttributes;
    }

    @Nullable
    public String getUserData() {
        return this.userData;
    }

    @Nullable
    public String getUserEmail() {
        return this.userEmail;
    }

    @Nullable
    public String getUserEvents() {
        return this.userEvents;
    }

    @Nullable
    public String getUserName() {
        return this.userName;
    }

    public JSONArray getUserSteps() {
        return o.a((List) this.userSteps);
    }

    @Nullable
    public String getUuid() {
        return this.uuid;
    }

    public String getVisualUserSteps() {
        return VisualUserStep.toJsonString(this.visualUserSteps);
    }

    public int hashCode() {
        return String.valueOf(getReportedAt()).hashCode();
    }

    public boolean isDeviceRooted() {
        return this.isDeviceRooted;
    }

    public boolean isMinimalState() {
        return this.isMinimalState;
    }

    public boolean isWifiEnable() {
        return this.wifiState;
    }

    public State setAppPackageName(String str) {
        this.appPackageName = str;
        return this;
    }

    public State setAppVersion(String str) {
        this.appVersion = str;
        return this;
    }

    public State setBatteryLevel(int i11) {
        this.batteryLevel = i11;
        return this;
    }

    public State setBatteryState(String str) {
        this.batteryState = str;
        return this;
    }

    public State setBuildPercentage(float f11) {
        this.buildPercentage = f11;
        return this;
    }

    public State setCarrier(String str) {
        this.carrier = str;
        return this;
    }

    public State setCurrentActivity(String str) {
        this.currentActivity = str;
        return this;
    }

    public State setCurrentView(String str) {
        this.currentView = str;
        return this;
    }

    public void setCustomUserAttribute(@Nullable String str) {
        this.customUserAttribute = str;
    }

    public State setDevice(String str) {
        this.device = str;
        return this;
    }

    public State setDeviceArchitecture(@Nullable String str) {
        this.deviceArchitecture = str;
        return this;
    }

    public State setDuration(long j11) {
        this.duration = j11;
        return this;
    }

    public State setExperiments(@Nullable List<String> list) {
        this.experiments = list;
        return this;
    }

    public State setFreeMemory(long j11) {
        this.freeMemory = j11;
        return this;
    }

    public void setInstabugLog(@Nullable String str) {
        this.instabugLog = str;
    }

    public State setLocale(String str) {
        this.locale = str;
        return this;
    }

    @VisibleForTesting
    public State setNetworkLogs(@Nullable String str) {
        this.networkLogs = str;
        return this;
    }

    public State setOS(String str) {
        this.OS = str;
        return this;
    }

    public State setPushToken(@Nullable String str) {
        this.pushToken = str;
        return this;
    }

    public State setScreenDensity(String str) {
        this.screenDensity = str;
        return this;
    }

    public State setScreenOrientation(String str) {
        this.ScreenOrientation = str;
        return this;
    }

    public State setScreenSize(String str) {
        this.screenSize = str;
        return this;
    }

    @VisibleForTesting
    public State setSessionProfilerTimeline(e eVar) {
        this.sessionProfilerTimeline = eVar;
        return this;
    }

    public State setTags(String str) {
        this.tags = str;
        return this;
    }

    public State setTotalMemory(long j11) {
        this.totalMemory = j11;
        return this;
    }

    public void setUri(@Nullable Uri uri2) {
        this.uri = uri2;
    }

    public State setUserAttributes(String str) {
        this.userAttributes = str;
        return this;
    }

    public State setUserData(String str) {
        this.userData = str;
        return this;
    }

    public State setUserEmail(String str) {
        this.userEmail = str;
        return this;
    }

    public State setUserEvents(String str) {
        this.userEvents = str;
        return this;
    }

    public State setUserName(@Nullable String str) {
        this.userName = str;
        return this;
    }

    @VisibleForTesting
    public State setUserSteps(List<o> list) {
        this.userSteps = list;
        return this;
    }

    public State setUuid(@Nullable String str) {
        this.uuid = str;
        return this;
    }

    @VisibleForTesting
    public void setVisualUserSteps(@Nullable ArrayList<VisualUserStep> arrayList) {
        this.visualUserSteps = arrayList;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toJson() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList<StateItem> stateItems = getStateItems();
            for (int i11 = 0; i11 < stateItems.size(); i11++) {
                String key = stateItems.get(i11).getKey();
                if (key != null) {
                    jSONObject.put(key, stateItems.get(i11).getValue());
                }
            }
            jSONObject.put("UUID", (Object) this.uuid);
            ArrayList<StateItem> logsItems = getLogsItems();
            for (int i12 = 0; i12 < logsItems.size(); i12++) {
                String key2 = logsItems.get(i12).getKey();
                if (key2 != null) {
                    jSONObject.put(key2, logsItems.get(i12).getValue());
                }
            }
            jSONObject.put(BUILD_PERCENTAGE, (double) this.buildPercentage);
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (OutOfMemoryError e11) {
            InstabugSDKLogger.e("IBG-Core", "Could create state json string, OOM", e11);
            return JSONObjectInstrumentation.toString(new JSONObject());
        }
    }

    @NonNull
    public String toString() {
        try {
            return toJson();
        } catch (JSONException e11) {
            e11.printStackTrace();
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while getting state.toString()" + e11.getMessage(), e11);
            return "error";
        }
    }

    public void updateConsoleLog() {
        setConsoleLog(Builder.getConsoleLog(this.buildPercentage));
    }

    public State updateIdentificationAttrs() {
        String str = this.userEmail;
        if (str == null || str.isEmpty()) {
            setUserEmail(f.n());
        }
        String str2 = this.userName;
        if (str2 == null || str2.isEmpty()) {
            setUserName(f.o());
        }
        return this;
    }

    public void updateUserEvents() throws JSONException {
        String str;
        JSONArray json = UserEvent.toJson(InstabugUserEventLogger.getInstance().getUserEvents(this.buildPercentage));
        if (!(json instanceof JSONArray)) {
            str = json.toString();
        } else {
            str = JSONArrayInstrumentation.toString(json);
        }
        setUserEvents(str);
    }

    public void updateVisualUserSteps() {
        setVisualUserSteps(Builder.getVisualUserSteps());
    }

    public static State getState(Context context, float f11) {
        return new Builder(context).build(true, true, f11);
    }

    public State setTags(List<String> list) {
        this.tags = getTagsAsString(list);
        return this;
    }

    public void updateConsoleLog(ArrayList<a> arrayList) {
        ArrayList a11 = Builder.getConsoleLog(this.buildPercentage);
        a11.addAll(arrayList);
        setConsoleLog(a11);
    }

    @WorkerThread
    public static State getState(Context context, @Nullable Uri uri2) {
        if (uri2 != null) {
            try {
                String execute = DiskUtils.with(context).readOperation(new ReadStateFromFileDiskOperation(uri2)).execute();
                String trim = execute.trim();
                if (!trim.equals("{}") && !trim.isEmpty()) {
                    State state = new State();
                    state.setUri(uri2);
                    state.fromJson(execute);
                    return state;
                }
            } catch (Exception | OutOfMemoryError e11) {
                InstabugCore.reportError(e11, "retrieving state throws an exception, falling back to non-changing");
                InstabugSDKLogger.e("IBG-Core", "Retrieving state throws an exception, falling back to non-changing", e11);
            }
        }
        State nonChangingState = getNonChangingState(context);
        nonChangingState.setUri(uri2);
        return nonChangingState;
    }
}
