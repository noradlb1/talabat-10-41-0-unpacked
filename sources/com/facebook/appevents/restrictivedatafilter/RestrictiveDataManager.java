package com.facebook.appevents.restrictivedatafilter;

import android.util.Log;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Instrumented
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J&\u0010\u0019\u001a\u00020\u00122\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001b2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/appevents/restrictivedatafilter/RestrictiveDataManager;", "", "()V", "PROCESS_EVENT_NAME", "", "REPLACEMENT_STRING", "RESTRICTIVE_PARAM", "RESTRICTIVE_PARAM_KEY", "TAG", "kotlin.jvm.PlatformType", "enabled", "", "restrictedEvents", "", "restrictiveParamFilters", "", "Lcom/facebook/appevents/restrictivedatafilter/RestrictiveDataManager$RestrictiveParamFilter;", "enable", "", "getMatchedRuleType", "eventName", "paramKey", "initialize", "isRestrictedEvent", "processEvent", "processParameters", "parameters", "", "RestrictiveParamFilter", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class RestrictiveDataManager {
    @NotNull
    public static final RestrictiveDataManager INSTANCE = new RestrictiveDataManager();
    @NotNull
    private static final String PROCESS_EVENT_NAME = "process_event_name";
    @NotNull
    private static final String REPLACEMENT_STRING = "_removed_";
    @NotNull
    private static final String RESTRICTIVE_PARAM = "restrictive_param";
    @NotNull
    private static final String RESTRICTIVE_PARAM_KEY = "_restrictedParams";
    private static final String TAG = RestrictiveDataManager.class.getCanonicalName();
    private static boolean enabled;
    @NotNull
    private static final Set<String> restrictedEvents = new CopyOnWriteArraySet();
    @NotNull
    private static final List<RestrictiveParamFilter> restrictiveParamFilters = new ArrayList();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/facebook/appevents/restrictivedatafilter/RestrictiveDataManager$RestrictiveParamFilter;", "", "eventName", "", "restrictiveParams", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "getRestrictiveParams", "()Ljava/util/Map;", "setRestrictiveParams", "(Ljava/util/Map;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class RestrictiveParamFilter {
        @NotNull
        private String eventName;
        @NotNull
        private Map<String, String> restrictiveParams;

        public RestrictiveParamFilter(@NotNull String str, @NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            Intrinsics.checkNotNullParameter(map, "restrictiveParams");
            this.eventName = str;
            this.restrictiveParams = map;
        }

        @NotNull
        public final String getEventName() {
            return this.eventName;
        }

        @NotNull
        public final Map<String, String> getRestrictiveParams() {
            return this.restrictiveParams;
        }

        public final void setEventName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.eventName = str;
        }

        public final void setRestrictiveParams(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.restrictiveParams = map;
        }
    }

    private RestrictiveDataManager() {
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
        INSTANCE.initialize();
    }

    private final String getMatchedRuleType(String str, String str2) {
        try {
            for (RestrictiveParamFilter restrictiveParamFilter : new ArrayList(restrictiveParamFilters)) {
                if (restrictiveParamFilter != null) {
                    if (Intrinsics.areEqual((Object) str, (Object) restrictiveParamFilter.getEventName())) {
                        for (String next : restrictiveParamFilter.getRestrictiveParams().keySet()) {
                            if (Intrinsics.areEqual((Object) str2, (Object) next)) {
                                return restrictiveParamFilter.getRestrictiveParams().get(next);
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
            return null;
        } catch (Exception e11) {
            Log.w(TAG, "getMatchedRuleType failed", e11);
            return null;
        }
    }

    private final void initialize() {
        String restrictiveDataSetting;
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            boolean z11 = false;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings != null && (restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting()) != null) {
                if (restrictiveDataSetting.length() == 0) {
                    z11 = true;
                }
                if (!z11) {
                    JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
                    restrictiveParamFilters.clear();
                    restrictedEvents.clear();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        if (jSONObject2 != null) {
                            JSONObject optJSONObject = jSONObject2.optJSONObject(RESTRICTIVE_PARAM);
                            Intrinsics.checkNotNullExpressionValue(next, "key");
                            RestrictiveParamFilter restrictiveParamFilter = new RestrictiveParamFilter(next, new HashMap());
                            if (optJSONObject != null) {
                                restrictiveParamFilter.setRestrictiveParams(Utility.convertJSONObjectToStringMap(optJSONObject));
                                restrictiveParamFilters.add(restrictiveParamFilter);
                            }
                            if (jSONObject2.has(PROCESS_EVENT_NAME)) {
                                restrictedEvents.add(restrictiveParamFilter.getEventName());
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private final boolean isRestrictedEvent(String str) {
        return restrictedEvents.contains(str);
    }

    @JvmStatic
    @NotNull
    public static final String processEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        if (!enabled || !INSTANCE.isRestrictedEvent(str)) {
            return str;
        }
        return REPLACEMENT_STRING;
    }

    @JvmStatic
    public static final void processParameters(@NotNull Map<String, String> map, @NotNull String str) {
        Intrinsics.checkNotNullParameter(map, "parameters");
        Intrinsics.checkNotNullParameter(str, "eventName");
        if (enabled) {
            HashMap hashMap = new HashMap();
            for (String str2 : new ArrayList(map.keySet())) {
                String matchedRuleType = INSTANCE.getMatchedRuleType(str, str2);
                if (matchedRuleType != null) {
                    hashMap.put(str2, matchedRuleType);
                    map.remove(str2);
                }
            }
            if (!hashMap.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        jSONObject.put((String) entry.getKey(), (Object) (String) entry.getValue());
                    }
                    map.put(RESTRICTIVE_PARAM_KEY, JSONObjectInstrumentation.toString(jSONObject));
                } catch (JSONException unused) {
                }
            }
        }
    }
}
