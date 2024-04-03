package com.instabug.library;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Feature;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.experiments.a;
import com.instabug.library.internal.resolver.c;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import com.instabug.library.internal.sharedpreferences.f;
import com.instabug.library.model.State;
import com.instabug.library.model.b;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.memory.MemoryUtils;
import com.instabug.library.util.threading.PoolProvider;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import j$.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import qc.l;

@Instrumented
public class e0 {

    /* renamed from: e  reason: collision with root package name */
    public static final Feature.State f50555e = Feature.State.ENABLED;

    /* renamed from: f  reason: collision with root package name */
    public static final Feature.State f50556f = Feature.State.DISABLED;

    /* renamed from: g  reason: collision with root package name */
    private static volatile e0 f50557g;

    /* renamed from: a  reason: collision with root package name */
    private boolean f50558a = false;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap f50559b = new ConcurrentHashMap(20, 0.9f, 2);

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap f50560c = new ConcurrentHashMap(20, 0.9f, 2);

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap f50561d = new ConcurrentHashMap(20, 0.9f, 2);

    private e0() {
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    private void a(Object obj, boolean z11) {
        if (!this.f50560c.containsKey(obj) || ((Boolean) this.f50560c.get(obj)).booleanValue() != z11) {
            this.f50560c.put(obj, Boolean.valueOf(z11));
        }
    }

    public static e0 c() {
        if (f50557g == null) {
            f50557g = new e0();
        }
        return f50557g;
    }

    private boolean d(Object obj) {
        return obj == Feature.VIEW_HIERARCHY_V2 || obj == Feature.VP_CUSTOMIZATION || obj == Feature.VZ_MESSAGES_CUSTOM_APPRATING_UI || obj == Feature.REPORT_PHONE_NUMBER || obj == Feature.PRODUCTION_USAGE_DETECTION || obj == a.BE_USERS_KEYS;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(Context context) {
        try {
            SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, SettingsManager.INSTABUG_SHARED_PREF_NAME);
            if (instabugSharedPreferences == null) {
                InstabugSDKLogger.e("IBG-Core", "Couldn't save features because SharedPref is not available, Instabug will be paused");
                Instabug.pauseSdk();
                return;
            }
            SharedPreferences.Editor edit = instabugSharedPreferences.edit();
            for (Object next : this.f50560c.keySet()) {
                if (next instanceof Feature) {
                    edit.putBoolean(((Feature) next).name() + "AVAIL", ((Boolean) this.f50560c.get(next)).booleanValue());
                }
            }
            for (Feature feature : this.f50561d.keySet()) {
                edit.putBoolean(a(feature.name()), ((Boolean) this.f50561d.get(feature)).booleanValue());
            }
            edit.apply();
        } catch (OutOfMemoryError unused) {
            InstabugSDKLogger.e("IBG-Core", "Couldn't save features because memory is low, Instabug will be paused");
            Instabug.pauseSdk();
        }
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public Feature.State b(Object obj) {
        if (this.f50558a) {
            InstabugSDKLogger.e("IBG-Core", "SDK is temporaryDisabled, returing disable for feature: " + obj.toString());
            return Feature.State.DISABLED;
        }
        Feature feature = Feature.INSTABUG;
        if (!c((Object) feature)) {
            InstabugSDKLogger.e("IBG-Core", "getFeatureState#!isFeatureAvailable, returing disable for feature: " + obj.toString());
            return Feature.State.DISABLED;
        }
        Object obj2 = this.f50559b.get(feature);
        Feature.State state = Feature.State.DISABLED;
        if (obj2 == state) {
            InstabugSDKLogger.e("IBG-Core", "Instabug is disabled ");
            return state;
        } else if (!c(obj)) {
            return state;
        } else {
            if (this.f50559b.containsKey(obj)) {
                return (Feature.State) this.f50559b.get(obj);
            }
            if (d(obj)) {
                return f50556f;
            }
            return f50555e;
        }
    }

    public boolean f() {
        Context applicationContext = Instabug.getApplicationContext();
        return applicationContext != null && f(applicationContext) > 0;
    }

    @VisibleForTesting
    public void g(Feature feature, boolean z11) {
        a((Object) feature, z11);
    }

    public void h() {
        this.f50558a = true;
    }

    @VisibleForTesting
    public void i() {
        b d11 = d();
        if (d11 != null && d11.b() != null && !d11.b().equalsIgnoreCase("11.7.0")) {
            try {
                d11.a("");
                SettingsManager.getInstance().setFeaturesCache(d11);
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-Core", "Failed to update previously cached feature settings due to: " + e11.getMessage());
            }
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void j(Context context) {
        if (!MemoryUtils.isLowMemory(context)) {
            SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, SettingsManager.INSTABUG_SHARED_PREF_NAME);
            if (instabugSharedPreferences == null) {
                InstabugSDKLogger.e("IBG-Core", "Couldn't restoreFeaturesFromSharedPreferences because SharedPref is not available,Instabug will be paused.");
                Instabug.pauseSdk();
                return;
            }
            if (!instabugSharedPreferences.contains(Feature.VP_CUSTOMIZATION.name() + "AVAIL")) {
                b(0, context);
                a(context);
                return;
            }
            for (Feature feature : Feature.values()) {
                this.f50561d.put(feature, Boolean.valueOf(instabugSharedPreferences.getBoolean(a(feature.name()), false)));
                String str = feature.name() + "AVAIL";
                boolean z11 = instabugSharedPreferences.getBoolean(feature.name() + "AVAIL", a(feature));
                if (instabugSharedPreferences.contains(str)) {
                    this.f50560c.put(feature, Boolean.valueOf(z11));
                } else if (!this.f50560c.containsKey(feature)) {
                    this.f50560c.putIfAbsent(feature, Boolean.valueOf(z11));
                }
                if (!this.f50559b.containsKey(feature)) {
                    this.f50559b.putIfAbsent(feature, Feature.State.valueOf(instabugSharedPreferences.getString(feature.name() + "STATE", b(feature))));
                }
            }
            return;
        }
        InstabugSDKLogger.e("IBG-Core", "Couldn't restoreFeaturesFromSharedPreferences because memory is low,Instabug will be paused.");
        Instabug.pauseSdk();
    }

    private boolean d(Context context) {
        b d11 = d();
        if (d11 == null || System.currentTimeMillis() - f(context) > d11.c()) {
            return true;
        }
        return false;
    }

    public void g(Context context) {
        if (context == null) {
            InstabugSDKLogger.e("IBG-Core", "unable to execute saveFeaturesToSharedPreferences. Null context reference");
        } else if (!MemoryUtils.isLowMemory(context)) {
            PoolProvider.getInstance().getIOExecutor().execute(new l(this, context));
        } else {
            InstabugSDKLogger.e("IBG-Core", "Couldn't save features because memory is low, Instabug will be paused");
            Instabug.pauseSdk();
        }
    }

    @VisibleForTesting
    public void h(String str) throws JSONException {
        String str2;
        InstabugSDKLogger.v("IBG-Core", "features response: " + str);
        JSONObject jSONObject = new JSONObject(str);
        boolean optBoolean = jSONObject.optBoolean("is_active", true);
        g(Feature.INSTABUG, optBoolean);
        if (optBoolean) {
            Instabug.resumeSdk();
        } else {
            Instabug.pauseSdk();
            InstabugSDKLogger.w("IBG-Core", "SDK is disabled. Please make sure you are using a valid application token");
        }
        g(Feature.PUSH_NOTIFICATION, jSONObject.optBoolean("push_notifications", false));
        g(Feature.WHITE_LABELING, jSONObject.optBoolean("white_label", false));
        g(Feature.CUSTOM_FONT, jSONObject.optBoolean("custom_font", false));
        g(Feature.IN_APP_MESSAGING, jSONObject.optBoolean("in_app_messaging", false));
        g(Feature.MULTIPLE_ATTACHMENTS, jSONObject.optBoolean("multiple_attachments", false));
        g(Feature.TRACK_USER_STEPS, jSONObject.optBoolean(State.KEY_USER_STEPS, false));
        g(Feature.REPRO_STEPS, jSONObject.optBoolean("repro_steps", false));
        g(Feature.CONSOLE_LOGS, jSONObject.optBoolean(State.KEY_CONSOLE_LOG, false));
        g(Feature.INSTABUG_LOGS, jSONObject.optBoolean("ibg_log", false));
        g(Feature.USER_DATA, jSONObject.optBoolean(State.KEY_USER_DATA, true));
        g(Feature.SURVEYS, jSONObject.optBoolean("surveys", false));
        g(Feature.VIEW_HIERARCHY_V2, jSONObject.optBoolean("view_hierarchy_v2", false));
        g(Feature.USER_EVENTS, jSONObject.optBoolean("user_events", false));
        g(Feature.DISCLAIMER, jSONObject.optBoolean("disclaimer_text", false));
        g(Feature.SESSION_PROFILER, jSONObject.optBoolean(State.KEY_SESSIONS_PROFILER, false));
        boolean optBoolean2 = jSONObject.optBoolean("feature_requests", false);
        Feature feature = Feature.FEATURE_REQUESTS;
        g(feature, optBoolean2);
        g(Feature.VP_CUSTOMIZATION, jSONObject.optBoolean("vp_customizations", false));
        c(feature, jSONObject.optBoolean("experimental_prompt_fr", false));
        g(Feature.ANNOUNCEMENTS, jSONObject.optBoolean("announcements", false));
        c(Feature.BE_USER_ATTRIBUTES, jSONObject.optBoolean("be_user_attributes", false));
        a(a.BE_DISABLE_SIGNING, !jSONObject.optBoolean("disable_signing", false));
        g(Feature.REPORT_PHONE_NUMBER, jSONObject.optBoolean("report_phone_number", false));
        SettingsManager.getInstance().setUsersPageEnabled(jSONObject.optBoolean("users_keys", false));
        g(Feature.VZ_MESSAGES_CUSTOM_APPRATING_UI, jSONObject.optBoolean("vz_messages_custom_app_rating_ui", false));
        a(jSONObject.optBoolean("android_db_transaction_disabled", true));
        g(Feature.PRODUCTION_USAGE_DETECTION, jSONObject.optBoolean("production_usage_detection", false));
        c.a().b(jSONObject.optJSONObject("sdk_log_v2"));
        JSONObject optJSONObject = jSONObject.optJSONObject("sessions");
        if (optJSONObject == null) {
            str2 = "{}";
        } else {
            str2 = JSONObjectInstrumentation.toString(optJSONObject);
        }
        SettingsManager.getInstance().setSessionsSyncConfigurations(str2);
        if (optJSONObject != null) {
            com.instabug.library.sessionV3.di.c.c().a(optJSONObject.optJSONObject("v3"));
        }
        c(optJSONObject);
        com.instabug.library.sessionV3.di.c.c().b(jSONObject);
        boolean optBoolean3 = jSONObject.optBoolean("android_encryption", false);
        Feature.State state = optBoolean3 ? Feature.State.ENABLED : Feature.State.DISABLED;
        Feature.State b11 = b();
        c(optBoolean3);
        SettingsManager.getInstance().setFeatureEnabled(Feature.ENCRYPTION.name(), optBoolean3);
        if (b11 != state) {
            f.b(optBoolean3, Instabug.getApplicationContext());
            SDKCoreEventPublisher.post(new SDKCoreEvent("encryption_state"));
        }
        boolean optBoolean4 = jSONObject.optBoolean("android_db_encryption", false);
        Feature.State state2 = optBoolean4 ? Feature.State.ENABLED : Feature.State.DISABLED;
        Feature.State a11 = a();
        b(optBoolean4);
        SettingsManager.getInstance().setFeatureEnabled(Feature.DB_ENCRYPTION.name(), optBoolean4);
        SettingsManager.getInstance().setFeatureEnabled(Feature.SCREEN_OFF_MONITOR.name(), jSONObject.optBoolean("an_exp_session_screenoff", true));
        if (a11 != state2) {
            SDKCoreEventPublisher.post(new SDKCoreEvent("db_encryption_state", state2 == Feature.State.ENABLED ? "encrypt_db" : "decrypt_db"));
        }
        a c11 = com.instabug.library.experiments.di.a.c();
        if (c11 != null) {
            c11.a(jSONObject);
        }
        b(jSONObject);
        a(jSONObject);
        com.instabug.library.internal.utils.memory.a.a(jSONObject);
    }

    @VisibleForTesting
    public long f(Context context) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, SettingsManager.INSTABUG_SHARED_PREF_NAME);
        if (instabugSharedPreferences == null) {
            return 0;
        }
        return instabugSharedPreferences.getLong("LAST_FETCHED_AT", 0);
    }

    private void a(a aVar, boolean z11) {
        a((Object) aVar, z11);
    }

    @Nullable
    private b d() {
        try {
            b featuresCache = SettingsManager.getInstance().getFeaturesCache();
            if (featuresCache != null) {
                InstabugSDKLogger.v("IBG-Core", "Previously cached feature settings : " + featuresCache.toJson());
            }
            return featuresCache;
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-Core", "Failed to load previously cached feature settings due to: " + e11.getMessage());
            return null;
        }
    }

    public boolean c(Context context) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, SettingsManager.INSTABUG_SHARED_PREF_NAME);
        if (instabugSharedPreferences == null) {
            return true;
        }
        return instabugSharedPreferences.getBoolean(Feature.DATABASE_TRANSACTIONS_DISABLED.name(), true);
    }

    public void a(boolean z11) {
        SharedPreferences instabugSharedPreferences;
        if (Instabug.getApplicationContext() != null && (instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(Instabug.getApplicationContext(), SettingsManager.INSTABUG_SHARED_PREF_NAME)) != null) {
            instabugSharedPreferences.edit().putBoolean(Feature.DATABASE_TRANSACTIONS_DISABLED.name(), z11).apply();
        }
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public void c(Feature feature, boolean z11) {
        if (!this.f50561d.containsKey(feature) || ((Boolean) this.f50561d.get(feature)).booleanValue() != z11) {
            InstabugSDKLogger.v("IBG-Core", "Experimental feature " + feature + " availability to " + z11);
            this.f50561d.put(feature, Boolean.valueOf(z11));
        }
    }

    public boolean g() {
        if (!f() || SettingsManager.getInstance().getFeatureState(Feature.SDK_STITCHING, false) == Feature.State.ENABLED) {
            return true;
        }
        return false;
    }

    public void a(Feature feature, Feature.State state) {
        if (this.f50559b.get(feature) != state) {
            InstabugSDKLogger.v("IBG-Core", "Setting " + feature + " state to " + state);
            this.f50559b.put(feature, state);
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public boolean c(Feature feature) {
        if (!this.f50561d.containsKey(feature) || this.f50561d.get(feature) == null) {
            InstabugSDKLogger.v("IBG-Core", "Experimental Feature " + feature + " availability not found, returning " + false);
            return false;
        }
        InstabugSDKLogger.v("IBG-Core", "Experimental Feature " + feature + " availability is " + this.f50561d.get(feature));
        return ((Boolean) this.f50561d.get(feature)).booleanValue();
    }

    public Feature.State a() {
        Application a11;
        if (com.instabug.library.internal.contentprovider.a.b() == null || (a11 = com.instabug.library.internal.contentprovider.a.b().a()) == null) {
            return Feature.State.DISABLED;
        }
        return a11.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0).getBoolean(Feature.DB_ENCRYPTION.name(), false) ? Feature.State.ENABLED : Feature.State.DISABLED;
    }

    public Feature.State b() {
        Application a11;
        if (com.instabug.library.internal.contentprovider.a.b() == null || (a11 = com.instabug.library.internal.contentprovider.a.b().a()) == null) {
            return Feature.State.DISABLED;
        }
        return a11.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0).getBoolean(Feature.ENCRYPTION.name(), false) ? Feature.State.ENABLED : Feature.State.DISABLED;
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public Feature.State a(Object obj) {
        if (this.f50558a) {
            InstabugSDKLogger.e("IBG-Core", "SDK is temp disabled, returing disable for " + obj.toString());
            return Feature.State.DISABLED;
        } else if (!c(obj)) {
            return Feature.State.DISABLED;
        } else {
            if (this.f50559b.containsKey(obj)) {
                return (Feature.State) this.f50559b.get(obj);
            }
            if (d(obj)) {
                return f50556f;
            }
            return f50555e;
        }
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public boolean c(Object obj) {
        if (this.f50560c.containsKey(obj)) {
            return ((Boolean) this.f50560c.get(obj)).booleanValue();
        }
        if (d(obj)) {
            InstabugSDKLogger.v("IBG-Core", "isFeatureAvailable#shouldDisableFeature: " + obj.toString() + " return: DEFAULT_CUSTOMIZED_FEATURE_AVAILABILITY");
            return false;
        }
        InstabugSDKLogger.v("IBG-Core", "isFeatureAvailable: " + obj.toString() + " return: DEFAULT_FEATURE_AVAILABILITY");
        return true;
    }

    private void b(boolean z11) {
        Application a11;
        if (com.instabug.library.internal.contentprovider.a.b() != null && (a11 = com.instabug.library.internal.contentprovider.a.b().a()) != null) {
            a11.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0).edit().putBoolean(Feature.DB_ENCRYPTION.name(), z11).apply();
        }
    }

    private void c(boolean z11) {
        Application a11;
        if (com.instabug.library.internal.contentprovider.a.b() != null && (a11 = com.instabug.library.internal.contentprovider.a.b().a()) != null) {
            a11.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0).edit().putBoolean(Feature.ENCRYPTION.name(), z11).apply();
        }
    }

    private String b(Feature feature) {
        if (d((Object) feature)) {
            return f50556f.name();
        }
        return f50555e.name();
    }

    private void c(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("sdk_stitching_enabled", false);
            SettingsManager instance = SettingsManager.getInstance();
            Feature feature = Feature.SDK_STITCHING;
            instance.setFeatureEnabled(feature.name(), optBoolean);
            g(feature, optBoolean);
            if (jSONObject.has("sdk_stitching_session_timeout")) {
                SettingsManager.getInstance().setSessionStitchingTimeout(jSONObject.optInt("sdk_stitching_session_timeout"));
            }
        }
    }

    private String a(@NonNull String str) {
        return str + "EXP_AVAIL";
    }

    private boolean a(Feature feature) {
        return !d((Object) feature);
    }

    @VisibleForTesting
    public void b(long j11, Context context) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, SettingsManager.INSTABUG_SHARED_PREF_NAME);
        if (instabugSharedPreferences != null) {
            SharedPreferences.Editor edit = instabugSharedPreferences.edit();
            edit.putLong("LAST_FETCHED_AT", j11);
            edit.apply();
        }
    }

    public synchronized void a(Context context) {
        i();
        if (d(context)) {
            com.instabug.library.networkv2.service.c.b().b(new d0(this, context));
        }
    }

    private void a(JSONObject jSONObject) {
        g(Feature.CRASHES_CUSTOM_IDENTIFIED_EMAIL, jSONObject.optBoolean("crashes_custom_identified_email", false));
    }

    private void b(JSONObject jSONObject) {
        long optLong = jSONObject.optLong("android_db_time_to_dequeue_threshold", 4000);
        long optLong2 = jSONObject.optLong("android_db_time_to_completion_threshold", 5000);
        com.instabug.library.settings.f s11 = com.instabug.library.settings.f.s();
        if (s11 != null) {
            s11.b(optLong);
            s11.a(optLong2);
        }
    }
}
