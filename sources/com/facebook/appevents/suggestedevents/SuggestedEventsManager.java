package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import t6.a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0002J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0011J\b\u0010\u0012\u001a\u00020\u000fH\u0007J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0014J\u0017\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/appevents/suggestedevents/SuggestedEventsManager;", "", "()V", "ELIGIBLE_EVENTS_KEY", "", "PRODUCTION_EVENTS_KEY", "eligibleEvents", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "productionEvents", "enable", "", "initialize", "isEligibleEvents", "", "event", "isEligibleEvents$facebook_core_release", "isEnabled", "isProductionEvents", "isProductionEvents$facebook_core_release", "populateEventsFromRawJsonString", "rawSuggestedEventSetting", "populateEventsFromRawJsonString$facebook_core_release", "trackActivity", "activity", "Landroid/app/Activity;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class SuggestedEventsManager {
    @NotNull
    private static final String ELIGIBLE_EVENTS_KEY = "eligible_for_prediction_events";
    @NotNull
    public static final SuggestedEventsManager INSTANCE = new SuggestedEventsManager();
    @NotNull
    private static final String PRODUCTION_EVENTS_KEY = "production_events";
    @NotNull
    private static final Set<String> eligibleEvents = new LinkedHashSet();
    @NotNull
    private static final AtomicBoolean enabled = new AtomicBoolean(false);
    @NotNull
    private static final Set<String> productionEvents = new LinkedHashSet();

    private SuggestedEventsManager() {
    }

    @JvmStatic
    public static final synchronized void enable() {
        synchronized (SuggestedEventsManager.class) {
            FacebookSdk.getExecutor().execute(new a());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    public static final void m8928enable$lambda0() {
        AtomicBoolean atomicBoolean = enabled;
        if (!atomicBoolean.get()) {
            atomicBoolean.set(true);
            INSTANCE.initialize();
        }
    }

    private final void initialize() {
        String suggestedEventsSetting;
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings != null && (suggestedEventsSetting = queryAppSettings.getSuggestedEventsSetting()) != null) {
                populateEventsFromRawJsonString$facebook_core_release(suggestedEventsSetting);
                if ((!productionEvents.isEmpty()) || (!eligibleEvents.isEmpty())) {
                    ModelManager modelManager = ModelManager.INSTANCE;
                    File ruleFile = ModelManager.getRuleFile(ModelManager.Task.MTML_APP_EVENT_PREDICTION);
                    if (ruleFile != null) {
                        FeatureExtractor.initialize(ruleFile);
                        Activity currentActivity = ActivityLifecycleTracker.getCurrentActivity();
                        if (currentActivity != null) {
                            trackActivity(currentActivity);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final boolean isEligibleEvents$facebook_core_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "event");
        return eligibleEvents.contains(str);
    }

    @JvmStatic
    public static final boolean isEnabled() {
        return enabled.get();
    }

    @JvmStatic
    public static final boolean isProductionEvents$facebook_core_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "event");
        return productionEvents.contains(str);
    }

    @JvmStatic
    public static final void trackActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            if (!enabled.get() || !FeatureExtractor.isInitialized() || (productionEvents.isEmpty() && eligibleEvents.isEmpty())) {
                ViewObserver.Companion.stopTrackingActivity(activity);
            } else {
                ViewObserver.Companion.startTrackingActivity(activity);
            }
        } catch (Exception unused) {
        }
    }

    @VisibleForTesting(otherwise = 2)
    public final void populateEventsFromRawJsonString$facebook_core_release(@Nullable String str) {
        JSONArray jSONArray;
        int length;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i11 = 0;
            if (jSONObject.has(PRODUCTION_EVENTS_KEY)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(PRODUCTION_EVENTS_KEY);
                int length2 = jSONArray2.length();
                if (length2 > 0) {
                    int i12 = 0;
                    while (true) {
                        int i13 = i12 + 1;
                        Set<String> set = productionEvents;
                        String string = jSONArray2.getString(i12);
                        Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                        set.add(string);
                        if (i13 >= length2) {
                            break;
                        }
                        i12 = i13;
                    }
                }
            }
            if (jSONObject.has(ELIGIBLE_EVENTS_KEY) && (length = jSONArray.length()) > 0) {
                while (true) {
                    int i14 = i11 + 1;
                    Set<String> set2 = eligibleEvents;
                    String string2 = (jSONArray = jSONObject.getJSONArray(ELIGIBLE_EVENTS_KEY)).getString(i11);
                    Intrinsics.checkNotNullExpressionValue(string2, "jsonArray.getString(i)");
                    set2.add(string2);
                    if (i14 < length) {
                        i11 = i14;
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
