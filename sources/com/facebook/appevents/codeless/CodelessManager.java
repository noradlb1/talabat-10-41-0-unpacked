package com.facebook.appevents.codeless;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o6.b;
import o6.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Instrumented
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0007J\b\u0010\u0014\u001a\u00020\u0011H\u0007J\r\u0010\u0015\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0015\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\bH\u0001¢\u0006\u0002\b!R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/appevents/codeless/CodelessManager;", "", "()V", "deviceSessionID", "", "isAppIndexingEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCheckingSession", "", "isCodelessEnabled", "sensorManager", "Landroid/hardware/SensorManager;", "viewIndexer", "Lcom/facebook/appevents/codeless/ViewIndexer;", "viewIndexingTrigger", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger;", "checkCodelessSession", "", "applicationId", "disable", "enable", "getCurrentDeviceSessionID", "getCurrentDeviceSessionID$facebook_core_release", "getIsAppIndexingEnabled", "getIsAppIndexingEnabled$facebook_core_release", "isDebugOnEmulator", "onActivityDestroyed", "activity", "Landroid/app/Activity;", "onActivityPaused", "onActivityResumed", "updateAppIndexing", "appIndexingEnabled", "updateAppIndexing$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class CodelessManager {
    @NotNull
    public static final CodelessManager INSTANCE = new CodelessManager();
    @Nullable
    private static String deviceSessionID;
    @NotNull
    private static final AtomicBoolean isAppIndexingEnabled = new AtomicBoolean(false);
    private static volatile boolean isCheckingSession;
    @NotNull
    private static final AtomicBoolean isCodelessEnabled = new AtomicBoolean(true);
    @Nullable
    private static SensorManager sensorManager;
    @Nullable
    private static ViewIndexer viewIndexer;
    @NotNull
    private static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();

    private CodelessManager() {
    }

    private final void checkCodelessSession(String str) {
        if (!isCheckingSession) {
            isCheckingSession = true;
            FacebookSdk.getExecutor().execute(new b(str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkCodelessSession$lambda-1  reason: not valid java name */
    public static final void m8905checkCodelessSession$lambda1(String str) {
        String str2;
        Bundle bundle = new Bundle();
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
        JSONArray jSONArray = new JSONArray();
        String str3 = Build.MODEL;
        if (str3 == null) {
            str3 = "";
        }
        jSONArray.put((Object) str3);
        if (attributionIdentifiers == null) {
            str2 = null;
        } else {
            str2 = attributionIdentifiers.getAndroidAdvertiserId();
        }
        if (str2 != null) {
            jSONArray.put((Object) attributionIdentifiers.getAndroidAdvertiserId());
        } else {
            jSONArray.put((Object) "");
        }
        String str4 = "0";
        jSONArray.put((Object) str4);
        if (AppEventUtility.isEmulator()) {
            str4 = "1";
        }
        jSONArray.put((Object) str4);
        Locale currentLocale = Utility.getCurrentLocale();
        jSONArray.put((Object) currentLocale.getLanguage() + '_' + currentLocale.getCountry());
        String jSONArrayInstrumentation = JSONArrayInstrumentation.toString(jSONArray);
        Intrinsics.checkNotNullExpressionValue(jSONArrayInstrumentation, "extInfoArray.toString()");
        bundle.putString(Constants.DEVICE_SESSION_ID, getCurrentDeviceSessionID$facebook_core_release());
        bundle.putString(Constants.EXTINFO, jSONArrayInstrumentation);
        GraphRequest.Companion companion = GraphRequest.Companion;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        boolean z11 = true;
        String format = String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        JSONObject jSONObject = companion.newPostRequestWithBundle((AccessToken) null, format, bundle, (GraphRequest.Callback) null).executeAndWait().getJSONObject();
        AtomicBoolean atomicBoolean = isAppIndexingEnabled;
        if (jSONObject == null || !jSONObject.optBoolean(Constants.APP_INDEXING_ENABLED, false)) {
            z11 = false;
        }
        atomicBoolean.set(z11);
        if (!atomicBoolean.get()) {
            deviceSessionID = null;
        } else {
            ViewIndexer viewIndexer2 = viewIndexer;
            if (viewIndexer2 != null) {
                viewIndexer2.schedule();
            }
        }
        isCheckingSession = false;
    }

    @JvmStatic
    public static final void disable() {
        isCodelessEnabled.set(false);
    }

    @JvmStatic
    public static final void enable() {
        isCodelessEnabled.set(true);
    }

    @JvmStatic
    @NotNull
    public static final String getCurrentDeviceSessionID$facebook_core_release() {
        if (deviceSessionID == null) {
            deviceSessionID = UUID.randomUUID().toString();
        }
        String str = deviceSessionID;
        if (str != null) {
            return str;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @JvmStatic
    public static final boolean getIsAppIndexingEnabled$facebook_core_release() {
        return isAppIndexingEnabled.get();
    }

    private final boolean isDebugOnEmulator() {
        return false;
    }

    @JvmStatic
    public static final void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        CodelessMatcher.Companion.getInstance().destroy(activity);
    }

    @JvmStatic
    public static final void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (isCodelessEnabled.get()) {
            CodelessMatcher.Companion.getInstance().remove(activity);
            ViewIndexer viewIndexer2 = viewIndexer;
            if (viewIndexer2 != null) {
                viewIndexer2.unschedule();
            }
            SensorManager sensorManager2 = sensorManager;
            if (sensorManager2 != null) {
                sensorManager2.unregisterListener(viewIndexingTrigger);
            }
        }
    }

    @JvmStatic
    public static final void onActivityResumed(@NotNull Activity activity) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (isCodelessEnabled.get()) {
            CodelessMatcher.Companion.getInstance().add(activity);
            Context applicationContext = activity.getApplicationContext();
            String applicationId = FacebookSdk.getApplicationId();
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
            if (appSettingsWithoutQuery == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(appSettingsWithoutQuery.getCodelessEventsEnabled());
            }
            if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE) || INSTANCE.isDebugOnEmulator()) {
                SensorManager sensorManager2 = (SensorManager) applicationContext.getSystemService("sensor");
                if (sensorManager2 != null) {
                    sensorManager = sensorManager2;
                    Sensor defaultSensor = sensorManager2.getDefaultSensor(1);
                    ViewIndexer viewIndexer2 = new ViewIndexer(activity);
                    viewIndexer = viewIndexer2;
                    ViewIndexingTrigger viewIndexingTrigger2 = viewIndexingTrigger;
                    viewIndexingTrigger2.setOnShakeListener(new c(appSettingsWithoutQuery, applicationId));
                    sensorManager2.registerListener(viewIndexingTrigger2, defaultSensor, 2);
                    if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                        viewIndexer2.schedule();
                    }
                } else {
                    return;
                }
            }
            CodelessManager codelessManager = INSTANCE;
            if (codelessManager.isDebugOnEmulator() && !isAppIndexingEnabled.get()) {
                codelessManager.checkCodelessSession(applicationId);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityResumed$lambda-0  reason: not valid java name */
    public static final void m8906onActivityResumed$lambda0(FetchedAppSettings fetchedAppSettings, String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "$appId");
        boolean z12 = true;
        if (fetchedAppSettings == null || !fetchedAppSettings.getCodelessEventsEnabled()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!FacebookSdk.getCodelessSetupEnabled()) {
            z12 = false;
        }
        if (z11 && z12) {
            INSTANCE.checkCodelessSession(str);
        }
    }

    @JvmStatic
    public static final void updateAppIndexing$facebook_core_release(boolean z11) {
        isAppIndexingEnabled.set(z11);
    }
}
