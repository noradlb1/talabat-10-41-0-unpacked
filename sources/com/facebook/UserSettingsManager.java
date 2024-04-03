package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.concurrent.atomic.AtomicBoolean;
import k6.t;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0010\bÁ\u0002\u0018\u00002\u00020\u0001:\u00018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010 \u001a\u00020\u001fH\u0007J\b\u0010!\u001a\u00020\u001fH\u0007J\b\u0010\"\u001a\u00020\u001fH\u0007J\b\u0010#\u001a\u00020\u001fH\u0007J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J!\u0010'\u001a\u00020%2\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140)\"\u00020\u0014H\u0002¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0014H\u0002J\b\u0010-\u001a\u00020%H\u0007J\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002J\u0010\u00100\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0014H\u0002J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u001fH\u0007J\u0010\u00103\u001a\u00020%2\u0006\u00102\u001a\u00020\u001fH\u0007J\u0010\u00104\u001a\u00020%2\u0006\u00102\u001a\u00020\u001fH\u0007J\u0010\u00105\u001a\u00020%2\u0006\u00102\u001a\u00020\u001fH\u0007J\b\u00106\u001a\u00020%H\u0002J\u0010\u00107\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/UserSettingsManager;", "", "()V", "ADVERTISERID_COLLECTION_FALSE_WARNING", "", "ADVERTISERID_COLLECTION_NOT_SET_WARNING", "ADVERTISER_ID_KEY", "APPLICATION_FIELDS", "AUTOLOG_APPEVENT_NOT_SET_WARNING", "AUTO_APP_LINK_WARNING", "EVENTS_CODELESS_SETUP_ENABLED", "LAST_TIMESTAMP", "TAG", "kotlin.jvm.PlatformType", "TIMEOUT_7D", "", "USER_SETTINGS", "USER_SETTINGS_BITMASK", "VALUE", "advertiserIDCollectionEnabled", "Lcom/facebook/UserSettingsManager$UserSetting;", "autoInitEnabled", "autoLogAppEventsEnabled", "codelessSetupEnabled", "isFetchingCodelessStatus", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized", "monitorEnabled", "userSettingPref", "Landroid/content/SharedPreferences;", "getAdvertiserIDCollectionEnabled", "", "getAutoInitEnabled", "getAutoLogAppEventsEnabled", "getCodelessSetupEnabled", "getMonitorEnabled", "initializeCodelessSetupEnabledAsync", "", "initializeIfNotInitialized", "initializeUserSetting", "userSettings", "", "([Lcom/facebook/UserSettingsManager$UserSetting;)V", "loadSettingFromManifest", "userSetting", "logIfAutoAppLinkEnabled", "logIfSDKSettingsChanged", "logWarnings", "readSettingFromCache", "setAdvertiserIDCollectionEnabled", "flag", "setAutoInitEnabled", "setAutoLogAppEventsEnabled", "setMonitorEnabled", "validateInitialized", "writeSettingToCache", "UserSetting", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class UserSettingsManager {
    @NotNull
    private static final String ADVERTISERID_COLLECTION_FALSE_WARNING = "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.";
    @NotNull
    private static final String ADVERTISERID_COLLECTION_NOT_SET_WARNING = "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.";
    @NotNull
    private static final String ADVERTISER_ID_KEY = "advertiser_id";
    @NotNull
    private static final String APPLICATION_FIELDS = "fields";
    @NotNull
    private static final String AUTOLOG_APPEVENT_NOT_SET_WARNING = "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.";
    @NotNull
    private static final String AUTO_APP_LINK_WARNING = "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest";
    @NotNull
    private static final String EVENTS_CODELESS_SETUP_ENABLED = "auto_event_setup_enabled";
    @NotNull
    public static final UserSettingsManager INSTANCE = new UserSettingsManager();
    @NotNull
    private static final String LAST_TIMESTAMP = "last_timestamp";
    private static final String TAG = UserSettingsManager.class.getName();
    private static final long TIMEOUT_7D = 604800000;
    @NotNull
    private static final String USER_SETTINGS = "com.facebook.sdk.USER_SETTINGS";
    @NotNull
    private static final String USER_SETTINGS_BITMASK = "com.facebook.sdk.USER_SETTINGS_BITMASK";
    @NotNull
    private static final String VALUE = "value";
    @NotNull
    private static final UserSetting advertiserIDCollectionEnabled = new UserSetting(true, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY);
    @NotNull
    private static final UserSetting autoInitEnabled = new UserSetting(true, FacebookSdk.AUTO_INIT_ENABLED_PROPERTY);
    @NotNull
    private static final UserSetting autoLogAppEventsEnabled = new UserSetting(true, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY);
    @NotNull
    private static final UserSetting codelessSetupEnabled = new UserSetting(false, EVENTS_CODELESS_SETUP_ENABLED);
    @NotNull
    private static final AtomicBoolean isFetchingCodelessStatus = new AtomicBoolean(false);
    @NotNull
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);
    @NotNull
    private static final UserSetting monitorEnabled = new UserSetting(true, FacebookSdk.MONITOR_ENABLED_PROPERTY);
    private static SharedPreferences userSettingPref;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/facebook/UserSettingsManager$UserSetting;", "", "defaultVal", "", "key", "", "(ZLjava/lang/String;)V", "getDefaultVal", "()Z", "setDefaultVal", "(Z)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "lastTS", "", "getLastTS", "()J", "setLastTS", "(J)V", "value", "getValue", "()Ljava/lang/Boolean;", "setValue", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UserSetting {
        private boolean defaultVal;
        @NotNull
        private String key;
        private long lastTS;
        @Nullable
        private Boolean value;

        public UserSetting(boolean z11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.defaultVal = z11;
            this.key = str;
        }

        public final boolean getDefaultVal() {
            return this.defaultVal;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        public final long getLastTS() {
            return this.lastTS;
        }

        @Nullable
        public final Boolean getValue() {
            return this.value;
        }

        public final void setDefaultVal(boolean z11) {
            this.defaultVal = z11;
        }

        public final void setKey(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.key = str;
        }

        public final void setLastTS(long j11) {
            this.lastTS = j11;
        }

        public final void setValue(@Nullable Boolean bool) {
            this.value = bool;
        }

        /* renamed from: getValue  reason: collision with other method in class */
        public final boolean m8877getValue() {
            Boolean bool = this.value;
            return bool == null ? this.defaultVal : bool.booleanValue();
        }
    }

    private UserSettingsManager() {
    }

    @JvmStatic
    public static final boolean getAdvertiserIDCollectionEnabled() {
        INSTANCE.initializeIfNotInitialized();
        return advertiserIDCollectionEnabled.getValue();
    }

    @JvmStatic
    public static final boolean getAutoInitEnabled() {
        INSTANCE.initializeIfNotInitialized();
        return autoInitEnabled.getValue();
    }

    @JvmStatic
    public static final boolean getAutoLogAppEventsEnabled() {
        INSTANCE.initializeIfNotInitialized();
        return autoLogAppEventsEnabled.getValue();
    }

    @JvmStatic
    public static final boolean getCodelessSetupEnabled() {
        INSTANCE.initializeIfNotInitialized();
        return codelessSetupEnabled.getValue();
    }

    @JvmStatic
    public static final boolean getMonitorEnabled() {
        INSTANCE.initializeIfNotInitialized();
        return monitorEnabled.getValue();
    }

    private final void initializeCodelessSetupEnabledAsync() {
        UserSetting userSetting = codelessSetupEnabled;
        readSettingFromCache(userSetting);
        long currentTimeMillis = System.currentTimeMillis();
        if (userSetting.getValue() == null || currentTimeMillis - userSetting.getLastTS() >= TIMEOUT_7D) {
            userSetting.setValue((Boolean) null);
            userSetting.setLastTS(0);
            if (isFetchingCodelessStatus.compareAndSet(false, true)) {
                FacebookSdk.getExecutor().execute(new t(currentTimeMillis));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeCodelessSetupEnabledAsync$lambda-0  reason: not valid java name */
    public static final void m8876initializeCodelessSetupEnabledAsync$lambda0(long j11) {
        String str;
        if (advertiserIDCollectionEnabled.getValue()) {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings != null && queryAppSettings.getCodelessEventsEnabled()) {
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                if (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) {
                    str = null;
                } else {
                    str = attributionIdentifiers.getAndroidAdvertiserId();
                }
                if (str != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(ADVERTISER_ID_KEY, str);
                    bundle.putString("fields", EVENTS_CODELESS_SETUP_ENABLED);
                    GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, "app", (GraphRequest.Callback) null);
                    newGraphPathRequest.setParameters(bundle);
                    JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
                    if (jSONObject != null) {
                        UserSetting userSetting = codelessSetupEnabled;
                        userSetting.setValue(Boolean.valueOf(jSONObject.optBoolean(EVENTS_CODELESS_SETUP_ENABLED, false)));
                        userSetting.setLastTS(j11);
                        INSTANCE.writeSettingToCache(userSetting);
                    }
                }
            }
        }
        isFetchingCodelessStatus.set(false);
    }

    private final void initializeIfNotInitialized() {
        if (FacebookSdk.isInitialized() && isInitialized.compareAndSet(false, true)) {
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(USER_SETTINGS, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(USER_SETTINGS, Context.MODE_PRIVATE)");
            userSettingPref = sharedPreferences;
            initializeUserSetting(autoLogAppEventsEnabled, advertiserIDCollectionEnabled, autoInitEnabled);
            initializeCodelessSetupEnabledAsync();
            logWarnings();
            logIfSDKSettingsChanged();
        }
    }

    private final void initializeUserSetting(UserSetting... userSettingArr) {
        int length = userSettingArr.length;
        int i11 = 0;
        while (i11 < length) {
            UserSetting userSetting = userSettingArr[i11];
            i11++;
            if (userSetting == codelessSetupEnabled) {
                initializeCodelessSetupEnabledAsync();
            } else if (userSetting.getValue() == null) {
                readSettingFromCache(userSetting);
                if (userSetting.getValue() == null) {
                    loadSettingFromManifest(userSetting);
                }
            } else {
                writeSettingToCache(userSetting);
            }
        }
    }

    private final void loadSettingFromManifest(UserSetting userSetting) {
        validateInitialized();
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && bundle.containsKey(userSetting.getKey())) {
                userSetting.setValue(Boolean.valueOf(applicationInfo.metaData.getBoolean(userSetting.getKey(), userSetting.getDefaultVal())));
            }
        } catch (PackageManager.NameNotFoundException e11) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e11);
        }
    }

    @JvmStatic
    public static final void logIfAutoAppLinkEnabled() {
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && bundle.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                Bundle bundle2 = new Bundle();
                if (!Utility.isAutoAppLinkSetup()) {
                    bundle2.putString("SchemeWarning", AUTO_APP_LINK_WARNING);
                    Log.w(TAG, AUTO_APP_LINK_WARNING);
                }
                internalAppEventsLogger.logEvent("fb_auto_applink", bundle2);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final void logIfSDKSettingsChanged() {
        int i11;
        int i12;
        int i13;
        if (isInitialized.get() && FacebookSdk.isInitialized()) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            int i14 = 0;
            int i15 = ((autoInitEnabled.getValue() ? 1 : 0) << false) | 0 | ((autoLogAppEventsEnabled.getValue() ? 1 : 0) << true) | ((advertiserIDCollectionEnabled.getValue() ? 1 : 0) << true) | ((monitorEnabled.getValue() ? 1 : 0) << true);
            SharedPreferences sharedPreferences = userSettingPref;
            if (sharedPreferences != null) {
                int i16 = sharedPreferences.getInt(USER_SETTINGS_BITMASK, 0);
                if (i16 != i15) {
                    SharedPreferences sharedPreferences2 = userSettingPref;
                    if (sharedPreferences2 != null) {
                        sharedPreferences2.edit().putInt(USER_SETTINGS_BITMASK, i15).apply();
                        try {
                            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                            Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
                            if (applicationInfo.metaData != null) {
                                String[] strArr = {FacebookSdk.AUTO_INIT_ENABLED_PROPERTY, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY, FacebookSdk.MONITOR_ENABLED_PROPERTY};
                                boolean[] zArr = {true, true, true, true};
                                int i17 = 0;
                                i12 = 0;
                                i11 = 0;
                                while (true) {
                                    int i18 = i17 + 1;
                                    try {
                                        if (applicationInfo.metaData.containsKey(strArr[i17])) {
                                            i13 = 1;
                                        } else {
                                            i13 = 0;
                                        }
                                        i12 |= i13 << i17;
                                        i11 |= (applicationInfo.metaData.getBoolean(strArr[i17], zArr[i17]) ? 1 : 0) << i17;
                                        if (i18 > 3) {
                                            break;
                                        }
                                        i17 = i18;
                                    } catch (PackageManager.NameNotFoundException unused) {
                                        i14 = i11;
                                        i11 = i14;
                                        i14 = i12;
                                        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                                        Bundle bundle = new Bundle();
                                        bundle.putInt("usage", i14);
                                        bundle.putInt("initial", i11);
                                        bundle.putInt("previous", i16);
                                        bundle.putInt("current", i15);
                                        internalAppEventsLogger.logChangedSettingsEvent(bundle);
                                    }
                                }
                                i14 = i12;
                                InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
                                Bundle bundle2 = new Bundle();
                                bundle2.putInt("usage", i14);
                                bundle2.putInt("initial", i11);
                                bundle2.putInt("previous", i16);
                                bundle2.putInt("current", i15);
                                internalAppEventsLogger2.logChangedSettingsEvent(bundle2);
                            }
                            i11 = 0;
                            InternalAppEventsLogger internalAppEventsLogger22 = new InternalAppEventsLogger(applicationContext);
                            Bundle bundle22 = new Bundle();
                            bundle22.putInt("usage", i14);
                            bundle22.putInt("initial", i11);
                            bundle22.putInt("previous", i16);
                            bundle22.putInt("current", i15);
                            internalAppEventsLogger22.logChangedSettingsEvent(bundle22);
                        } catch (PackageManager.NameNotFoundException unused2) {
                            i12 = 0;
                            i11 = i14;
                            i14 = i12;
                            InternalAppEventsLogger internalAppEventsLogger222 = new InternalAppEventsLogger(applicationContext);
                            Bundle bundle222 = new Bundle();
                            bundle222.putInt("usage", i14);
                            bundle222.putInt("initial", i11);
                            bundle222.putInt("previous", i16);
                            bundle222.putInt("current", i15);
                            internalAppEventsLogger222.logChangedSettingsEvent(bundle222);
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                        throw null;
                    }
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                throw null;
            }
        }
    }

    private final void logWarnings() {
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                if (!bundle.containsKey(FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY)) {
                    Log.w(TAG, AUTOLOG_APPEVENT_NOT_SET_WARNING);
                }
                if (!applicationInfo.metaData.containsKey(FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY)) {
                    Log.w(TAG, ADVERTISERID_COLLECTION_NOT_SET_WARNING);
                }
                if (!getAdvertiserIDCollectionEnabled()) {
                    Log.w(TAG, ADVERTISERID_COLLECTION_FALSE_WARNING);
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final void readSettingFromCache(UserSetting userSetting) {
        boolean z11;
        String str = "";
        validateInitialized();
        try {
            SharedPreferences sharedPreferences = userSettingPref;
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(userSetting.getKey(), str);
                if (string != null) {
                    str = string;
                }
                if (str.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    JSONObject jSONObject = new JSONObject(str);
                    userSetting.setValue(Boolean.valueOf(jSONObject.getBoolean("value")));
                    userSetting.setLastTS(jSONObject.getLong(LAST_TIMESTAMP));
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
            throw null;
        } catch (JSONException e11) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e11);
        }
    }

    @JvmStatic
    public static final void setAdvertiserIDCollectionEnabled(boolean z11) {
        UserSetting userSetting = advertiserIDCollectionEnabled;
        userSetting.setValue(Boolean.valueOf(z11));
        userSetting.setLastTS(System.currentTimeMillis());
        if (isInitialized.get()) {
            INSTANCE.writeSettingToCache(userSetting);
        } else {
            INSTANCE.initializeIfNotInitialized();
        }
    }

    @JvmStatic
    public static final void setAutoInitEnabled(boolean z11) {
        UserSetting userSetting = autoInitEnabled;
        userSetting.setValue(Boolean.valueOf(z11));
        userSetting.setLastTS(System.currentTimeMillis());
        if (isInitialized.get()) {
            INSTANCE.writeSettingToCache(userSetting);
        } else {
            INSTANCE.initializeIfNotInitialized();
        }
    }

    @JvmStatic
    public static final void setAutoLogAppEventsEnabled(boolean z11) {
        UserSetting userSetting = autoLogAppEventsEnabled;
        userSetting.setValue(Boolean.valueOf(z11));
        userSetting.setLastTS(System.currentTimeMillis());
        if (isInitialized.get()) {
            INSTANCE.writeSettingToCache(userSetting);
        } else {
            INSTANCE.initializeIfNotInitialized();
        }
    }

    @JvmStatic
    public static final void setMonitorEnabled(boolean z11) {
        UserSetting userSetting = monitorEnabled;
        userSetting.setValue(Boolean.valueOf(z11));
        userSetting.setLastTS(System.currentTimeMillis());
        if (isInitialized.get()) {
            INSTANCE.writeSettingToCache(userSetting);
        } else {
            INSTANCE.initializeIfNotInitialized();
        }
    }

    private final void validateInitialized() {
        if (!isInitialized.get()) {
            throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
        }
    }

    private final void writeSettingToCache(UserSetting userSetting) {
        validateInitialized();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", (Object) userSetting.getValue());
            jSONObject.put(LAST_TIMESTAMP, userSetting.getLastTS());
            SharedPreferences sharedPreferences = userSettingPref;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(userSetting.getKey(), JSONObjectInstrumentation.toString(jSONObject)).apply();
                logIfSDKSettingsChanged();
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
            throw null;
        } catch (Exception e11) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, e11);
        }
    }
}
