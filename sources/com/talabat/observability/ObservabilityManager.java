package com.talabat.observability;

import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.observability.common.ApiStatus;
import com.talabat.observability.common.BackgroundAction;
import com.talabat.observability.common.EventType;
import com.talabat.observability.common.RegistrationStatus;
import com.talabat.observability.common.UserAction;
import com.talabat.observability.common.ViewStatus;
import com.talabat.observability.tracker.ObservabilityTracker;
import com.talabat.observability.tracker.impl.NewRelicObservabilityTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.utility.JavaConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0006J.\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fH\u0007J$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fH\u0007J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0007J&\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fH\u0007J.\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fH\u0007J6\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fH\u0007J6\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fH\u0007J.\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fH\u0007J8\u0010\"\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020#0\u000f2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fH\u0007J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020\fH\u0007J.\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fH\u0007J&\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fH\u0007J\u000e\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/talabat/observability/ObservabilityManager;", "", "()V", "disableObservability", "", "observabilityTracker", "Lcom/talabat/observability/tracker/ObservabilityTracker;", "", "disable", "setObservabilityTracker", "track", "eventName", "", "featureName", "attributes", "", "trackAdExEvent", "map", "trackAttribute", "name", "value", "trackEvent", "backgroundAction", "Lcom/talabat/observability/common/BackgroundAction;", "apiName", "apiStatus", "Lcom/talabat/observability/common/ApiStatus;", "screenName", "viewName", "userAction", "Lcom/talabat/observability/common/UserAction;", "viewStatus", "Lcom/talabat/observability/common/ViewStatus;", "eventType", "trackFwfCount", "", "attrs", "trackRegistration", "registrationStatus", "Lcom/talabat/observability/common/RegistrationStatus;", "trackUnExpectedScenario", "explanation", "trackUserId", "userId", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Use injected IObservabilityManager instead")
public final class ObservabilityManager {
    @NotNull
    public static final ObservabilityManager INSTANCE = new ObservabilityManager();
    private static boolean disableObservability;
    @Nullable
    private static ObservabilityTracker observabilityTracker = new NewRelicObservabilityTracker();

    private ObservabilityManager() {
    }

    @JvmStatic
    public static final void track(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        ObservabilityTracker observabilityTracker2;
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!disableObservability && (observabilityTracker2 = observabilityTracker) != null) {
            observabilityTracker2.trackEvent(str2, str, map);
        }
    }

    public static /* synthetic */ void track$default(String str, String str2, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        track(str, str2, map);
    }

    @JvmStatic
    public static final void trackAdExEvent(@NotNull String str, @NotNull Map<String, String> map) {
        ObservabilityTracker observabilityTracker2;
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        if (!disableObservability && (observabilityTracker2 = observabilityTracker) != null) {
            observabilityTracker2.trackEvent(EventType.Android_AdsExpo_Events.name(), str, map);
        }
    }

    @JvmStatic
    public static final void trackAttribute(@NotNull String str, @NotNull String str2) {
        ObservabilityTracker observabilityTracker2;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        if (!disableObservability && (observabilityTracker2 = observabilityTracker) != null) {
            observabilityTracker2.trackAttribute(str, str2);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackEvent(@NotNull BackgroundAction backgroundAction) {
        Intrinsics.checkNotNullParameter(backgroundAction, "backgroundAction");
        trackEvent$default(backgroundAction, (Map) null, 2, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackEvent(@NotNull String str, @NotNull ApiStatus apiStatus) {
        Intrinsics.checkNotNullParameter(str, "apiName");
        Intrinsics.checkNotNullParameter(apiStatus, "apiStatus");
        trackEvent$default(str, apiStatus, (Map) null, 4, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackEvent(@NotNull String str, @NotNull ApiStatus apiStatus, @NotNull Map<String, String> map) {
        ObservabilityTracker observabilityTracker2;
        Intrinsics.checkNotNullParameter(str, "apiName");
        Intrinsics.checkNotNullParameter(apiStatus, "apiStatus");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!disableObservability && (observabilityTracker2 = observabilityTracker) != null) {
            String name2 = EventType.ApiStatus.name();
            String value = apiStatus.getValue();
            observabilityTracker2.trackEvent(name2, str + JavaConstant.Dynamic.DEFAULT_NAME + value, map);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        trackEvent$default(str, str2, (Map) null, 4, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackEvent(@NotNull String str, @NotNull String str2, @NotNull UserAction userAction) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "viewName");
        Intrinsics.checkNotNullParameter(userAction, "userAction");
        trackEvent$default(str, str2, userAction, (Map) null, 8, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackEvent(@NotNull String str, @NotNull String str2, @NotNull ViewStatus viewStatus) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "viewName");
        Intrinsics.checkNotNullParameter(viewStatus, "viewStatus");
        trackEvent$default(str, str2, viewStatus, (Map) null, 8, (Object) null);
    }

    public static /* synthetic */ void trackEvent$default(String str, ApiStatus apiStatus, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        trackEvent(str, apiStatus, (Map<String, String>) map);
    }

    @JvmStatic
    public static final void trackFwfCount(@NotNull String str, @NotNull Map<String, Integer> map, @NotNull Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        Intrinsics.checkNotNullParameter(map2, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        if (!disableObservability) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(map2);
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put((String) next.getKey(), String.valueOf(((Number) next.getValue()).intValue()));
            }
            ObservabilityTracker observabilityTracker2 = observabilityTracker;
            if (observabilityTracker2 != null) {
                observabilityTracker2.trackEvent(EventType.FwfCount.name(), str, linkedHashMap);
            }
        }
    }

    @JvmStatic
    public static final void trackRegistration(@NotNull RegistrationStatus registrationStatus, @NotNull String str) {
        Intrinsics.checkNotNullParameter(registrationStatus, "registrationStatus");
        Intrinsics.checkNotNullParameter(str, "eventName");
        trackRegistration(registrationStatus, str, MapsKt__MapsKt.emptyMap());
    }

    public static /* synthetic */ void trackRegistration$default(RegistrationStatus registrationStatus, String str, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        trackRegistration(registrationStatus, str, map);
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackUnExpectedScenario(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "explanation");
        trackUnExpectedScenario$default(str, (Map) null, 2, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackUnExpectedScenario(@NotNull String str, @NotNull Map<String, String> map) {
        ObservabilityTracker observabilityTracker2;
        Intrinsics.checkNotNullParameter(str, "explanation");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!disableObservability && (observabilityTracker2 = observabilityTracker) != null) {
            observabilityTracker2.trackEvent(EventType.UnExpectedScenario.name(), str, map);
        }
    }

    public static /* synthetic */ void trackUnExpectedScenario$default(String str, Map map, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        trackUnExpectedScenario(str, map);
    }

    public final void disableObservability(boolean z11) {
        disableObservability = z11;
    }

    public final void setObservabilityTracker(@NotNull ObservabilityTracker observabilityTracker2) {
        Intrinsics.checkNotNullParameter(observabilityTracker2, "observabilityTracker");
        observabilityTracker = observabilityTracker2;
    }

    public final void trackUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        ObservabilityTracker observabilityTracker2 = observabilityTracker;
        if (observabilityTracker2 != null) {
            observabilityTracker2.trackUserId(str);
        }
    }

    @JvmStatic
    public static final void trackRegistration(@NotNull RegistrationStatus registrationStatus, @NotNull String str, @NotNull Map<String, String> map) {
        ObservabilityTracker observabilityTracker2;
        Intrinsics.checkNotNullParameter(registrationStatus, "registrationStatus");
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!disableObservability && (observabilityTracker2 = observabilityTracker) != null) {
            String name2 = EventType.Registration.name();
            String name3 = registrationStatus.name();
            observabilityTracker2.trackEvent(name2, name3 + JavaConstant.Dynamic.DEFAULT_NAME + str, map);
        }
    }

    public static /* synthetic */ void trackEvent$default(String str, String str2, ViewStatus viewStatus, Map map, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        trackEvent(str, str2, viewStatus, (Map<String, String>) map);
    }

    public static /* synthetic */ void trackEvent$default(String str, String str2, UserAction userAction, Map map, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        trackEvent(str, str2, userAction, (Map<String, String>) map);
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackEvent(@NotNull String str, @NotNull String str2, @NotNull ViewStatus viewStatus, @NotNull Map<String, String> map) {
        ObservabilityTracker observabilityTracker2;
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "viewName");
        Intrinsics.checkNotNullParameter(viewStatus, "viewStatus");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!disableObservability && (observabilityTracker2 = observabilityTracker) != null) {
            String name2 = EventType.ViewStatus.name();
            String value = viewStatus.getValue();
            observabilityTracker2.trackEvent(name2, str + JavaConstant.Dynamic.DEFAULT_NAME + str2 + JavaConstant.Dynamic.DEFAULT_NAME + value, map);
        }
    }

    public static /* synthetic */ void trackEvent$default(BackgroundAction backgroundAction, Map map, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        trackEvent(backgroundAction, (Map<String, String>) map);
    }

    public static /* synthetic */ void trackEvent$default(String str, String str2, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        trackEvent(str, str2, (Map<String, String>) map);
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackEvent(@NotNull String str, @NotNull String str2, @NotNull UserAction userAction, @NotNull Map<String, String> map) {
        ObservabilityTracker observabilityTracker2;
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "viewName");
        Intrinsics.checkNotNullParameter(userAction, "userAction");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!disableObservability && (observabilityTracker2 = observabilityTracker) != null) {
            String name2 = EventType.UserAction.name();
            String value = userAction.getValue();
            observabilityTracker2.trackEvent(name2, str + JavaConstant.Dynamic.DEFAULT_NAME + str2 + JavaConstant.Dynamic.DEFAULT_NAME + value, map);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackEvent(@NotNull BackgroundAction backgroundAction, @NotNull Map<String, String> map) {
        ObservabilityTracker observabilityTracker2;
        Intrinsics.checkNotNullParameter(backgroundAction, "backgroundAction");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!disableObservability && (observabilityTracker2 = observabilityTracker) != null) {
            observabilityTracker2.trackEvent(EventType.BackgroundAction.name(), backgroundAction.getValue(), map);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void trackEvent(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        ObservabilityTracker observabilityTracker2;
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!disableObservability && (observabilityTracker2 = observabilityTracker) != null) {
            observabilityTracker2.trackEvent(str2, str, map);
        }
    }
}
