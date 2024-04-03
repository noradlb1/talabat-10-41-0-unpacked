package com.talabat.core.fwf.data.observability;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.core.fwf.domain.FunWithFlagsObservabilityPort;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004H\u0016J$\u0010$\u001a\u00020\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0016J\u0010\u0010(\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\"H\u0016J\u0018\u0010*\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0016J\u0018\u0010,\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0016J\u0010\u00100\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004H\u0016J$\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00042\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.04H\u0016J \u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00068"}, d2 = {"Lcom/talabat/core/fwf/data/observability/FunWithFlagsObservabilityImpl;", "Lcom/talabat/core/fwf/data/observability/FunWithFlagsObservability;", "()V", "OBSERVABILITY_ATTRIBUTE_ERROR", "", "OBSERVABILITY_ATTRIBUTE_EXP_EVENT_NAME", "OBSERVABILITY_ATTRIBUTE_EXP_EVENT_VARIATION", "OBSERVABILITY_ATTRIBUTE_FLAG_NAME", "OBSERVABILITY_ATTRIBUTE_KEYS_CACHED_SIZE", "OBSERVABILITY_ATTRIBUTE_KEYS_SUBSCRIBED_BUT_NOT_CACHED", "OBSERVABILITY_ATTRIBUTE_KEYS_SUBSCRIBED_SIZE", "OBSERVABILITY_ATTRIBUTE_MODULE", "OBSERVABILITY_ATTRIBUTE_MODULE_VALUE", "OBSERVABILITY_ATTRIBUTE_PLATFORM", "OBSERVABILITY_ATTRIBUTE_PLATFORM_VALUE", "OBSERVABILITY_ATTRIBUTE_REASON", "OBSERVABILITY_ATTRIBUTE_REASON_EMPTY_CACHE", "OBSERVABILITY_ATTRIBUTE_REASON_EXP_TRACKING", "OBSERVABILITY_ATTRIBUTE_REASON_FLAG_NOT_FOUND_IN_CACHE", "OBSERVABILITY_ATTRIBUTE_REASON_INVALID_NAME", "OBSERVABILITY_ATTRIBUTE_SOURCE", "OBSERVABILITY_ATTRIBUTE_SOURCE_VALUE", "OBSERVABILITY_ERROR_EMPTY_RESPONSE", "OBSERVABILITY_ERROR_GETTING_VALUE_ASYNC", "OBSERVABILITY_ERROR_GETTING_VALUE_SYNC", "OBSERVABILITY_ERROR_NOT_SUPPORTED_VARIATION_TYPE", "observability", "Lkotlin/Function0;", "Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;", "getObservability$com_talabat_core_fwf_data_data", "()Lkotlin/jvm/functions/Function0;", "setObservability$com_talabat_core_fwf_data_data", "(Lkotlin/jvm/functions/Function0;)V", "observeAsyncInvalidFlagNameError", "", "flagName", "observeCacheFill", "flagsSubscribed", "", "flagsCached", "observeEmptyCacheError", "observeEmptyResponseError", "observeFWFNotSupportedVariationType", "error", "observeFlagNotFoundInCacheError", "cacheSize", "", "observeFwfSdkError", "observeInvalidFlagNameError", "observerFwfCount", "eventName", "map", "", "observerTrackingEvent", "flagKey", "eventVariation", "com_talabat_core_fwf_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FunWithFlagsObservabilityImpl implements FunWithFlagsObservability {
    @NotNull
    public static final FunWithFlagsObservabilityImpl INSTANCE = new FunWithFlagsObservabilityImpl();
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_ERROR = "error";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_EXP_EVENT_NAME = "eventName";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_EXP_EVENT_VARIATION = "eventVariation";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_FLAG_NAME = "flagName";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_KEYS_CACHED_SIZE = "keysCachedSize";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_KEYS_SUBSCRIBED_BUT_NOT_CACHED = "keysNotCached";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_KEYS_SUBSCRIBED_SIZE = "keysSubscribedSize";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_MODULE = "module";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_MODULE_VALUE = "FunWithFlags";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_PLATFORM = "target_platform";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_PLATFORM_VALUE = "android";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_REASON = "reason";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_REASON_EMPTY_CACHE = "EmptyCache";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_REASON_EXP_TRACKING = "ExpTracking";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_REASON_FLAG_NOT_FOUND_IN_CACHE = "FlagNotFoundInCache";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_REASON_INVALID_NAME = "InvalidName";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_SOURCE = "source";
    @NotNull
    public static final String OBSERVABILITY_ATTRIBUTE_SOURCE_VALUE = "android";
    @NotNull
    public static final String OBSERVABILITY_ERROR_EMPTY_RESPONSE = "ErrorEmptyResponse";
    @NotNull
    public static final String OBSERVABILITY_ERROR_GETTING_VALUE_ASYNC = "ErrorGettingValueAsync";
    @NotNull
    public static final String OBSERVABILITY_ERROR_GETTING_VALUE_SYNC = "ErrorGettingValueSync";
    @NotNull
    public static final String OBSERVABILITY_ERROR_NOT_SUPPORTED_VARIATION_TYPE = "ErrorNotSupportedVarationType";
    @NotNull
    private static Function0<? extends FunWithFlagsObservabilityPort> observability = FunWithFlagsObservabilityImpl$observability$1.INSTANCE;

    private FunWithFlagsObservabilityImpl() {
    }

    @NotNull
    public final Function0<FunWithFlagsObservabilityPort> getObservability$com_talabat_core_fwf_data_data() {
        return observability;
    }

    public void observeAsyncInvalidFlagNameError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "flagName");
        FunWithFlagsObservabilityPort funWithFlagsObservabilityPort = (FunWithFlagsObservabilityPort) observability.invoke();
        if (funWithFlagsObservabilityPort != null) {
            funWithFlagsObservabilityPort.trackUnExpectedScenario(OBSERVABILITY_ERROR_GETTING_VALUE_ASYNC, MapsKt__MapsKt.mapOf(TuplesKt.to("flagName", str), TuplesKt.to("module", "FunWithFlags"), TuplesKt.to("reason", OBSERVABILITY_ATTRIBUTE_REASON_INVALID_NAME), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_PLATFORM, "android"), TuplesKt.to("source", "android")));
        }
    }

    public void observeCacheFill(@NotNull Set<String> set, @NotNull Set<String> set2) {
        Intrinsics.checkNotNullParameter(set, "flagsSubscribed");
        Intrinsics.checkNotNullParameter(set2, "flagsCached");
        Set subtract = CollectionsKt___CollectionsKt.subtract(set, set2);
        FunWithFlagsObservabilityPort funWithFlagsObservabilityPort = (FunWithFlagsObservabilityPort) observability.invoke();
        if (funWithFlagsObservabilityPort != null) {
            funWithFlagsObservabilityPort.trackCacheFill(MapsKt__MapsKt.mapOf(TuplesKt.to(OBSERVABILITY_ATTRIBUTE_KEYS_SUBSCRIBED_SIZE, String.valueOf(set.size())), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_KEYS_CACHED_SIZE, String.valueOf(set2.size())), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_KEYS_SUBSCRIBED_BUT_NOT_CACHED, subtract.toString()), TuplesKt.to("module", "FunWithFlags"), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_PLATFORM, "android"), TuplesKt.to("source", "android")));
        }
    }

    public void observeEmptyCacheError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "flagName");
        FunWithFlagsObservabilityPort funWithFlagsObservabilityPort = (FunWithFlagsObservabilityPort) observability.invoke();
        if (funWithFlagsObservabilityPort != null) {
            funWithFlagsObservabilityPort.trackUnExpectedScenario(OBSERVABILITY_ERROR_GETTING_VALUE_SYNC, MapsKt__MapsKt.mapOf(TuplesKt.to("flagName", str), TuplesKt.to("module", "FunWithFlags"), TuplesKt.to("reason", OBSERVABILITY_ATTRIBUTE_REASON_EMPTY_CACHE), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_PLATFORM, "android"), TuplesKt.to("source", "android")));
        }
    }

    public void observeEmptyResponseError() {
        FunWithFlagsObservabilityPort funWithFlagsObservabilityPort = (FunWithFlagsObservabilityPort) observability.invoke();
        if (funWithFlagsObservabilityPort != null) {
            funWithFlagsObservabilityPort.trackUnExpectedScenario(OBSERVABILITY_ERROR_EMPTY_RESPONSE, MapsKt__MapsKt.mapOf(TuplesKt.to("module", "FunWithFlags"), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_PLATFORM, "android"), TuplesKt.to("source", "android")));
        }
    }

    public void observeFWFNotSupportedVariationType(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "flagName");
        Intrinsics.checkNotNullParameter(str2, "error");
        FunWithFlagsObservabilityPort funWithFlagsObservabilityPort = (FunWithFlagsObservabilityPort) observability.invoke();
        if (funWithFlagsObservabilityPort != null) {
            funWithFlagsObservabilityPort.trackUnExpectedScenario(OBSERVABILITY_ERROR_NOT_SUPPORTED_VARIATION_TYPE, MapsKt__MapsKt.mapOf(TuplesKt.to("flagName", str), TuplesKt.to("module", "FunWithFlags"), TuplesKt.to("error", str2), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_PLATFORM, "android"), TuplesKt.to("source", "android")));
        }
    }

    public void observeFlagNotFoundInCacheError(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "flagName");
        FunWithFlagsObservabilityPort funWithFlagsObservabilityPort = (FunWithFlagsObservabilityPort) observability.invoke();
        if (funWithFlagsObservabilityPort != null) {
            funWithFlagsObservabilityPort.trackUnExpectedScenario(OBSERVABILITY_ERROR_GETTING_VALUE_SYNC, MapsKt__MapsKt.mapOf(TuplesKt.to("flagName", str), TuplesKt.to("module", "FunWithFlags"), TuplesKt.to("reason", OBSERVABILITY_ATTRIBUTE_REASON_FLAG_NOT_FOUND_IN_CACHE), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_KEYS_CACHED_SIZE, String.valueOf(i11)), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_PLATFORM, "android"), TuplesKt.to("source", "android")));
        }
    }

    public void observeFwfSdkError(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "flagName");
        Intrinsics.checkNotNullParameter(str2, "error");
        FunWithFlagsObservabilityPort funWithFlagsObservabilityPort = (FunWithFlagsObservabilityPort) observability.invoke();
        if (funWithFlagsObservabilityPort != null) {
            funWithFlagsObservabilityPort.trackUnExpectedScenario(OBSERVABILITY_ERROR_GETTING_VALUE_ASYNC, MapsKt__MapsKt.mapOf(TuplesKt.to("flagName", str), TuplesKt.to("module", "FunWithFlags"), TuplesKt.to("error", str2), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_PLATFORM, "android"), TuplesKt.to("source", "android")));
        }
    }

    public void observeInvalidFlagNameError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "flagName");
        FunWithFlagsObservabilityPort funWithFlagsObservabilityPort = (FunWithFlagsObservabilityPort) observability.invoke();
        if (funWithFlagsObservabilityPort != null) {
            funWithFlagsObservabilityPort.trackUnExpectedScenario(OBSERVABILITY_ERROR_GETTING_VALUE_SYNC, MapsKt__MapsKt.mapOf(TuplesKt.to("flagName", str), TuplesKt.to("module", "FunWithFlags"), TuplesKt.to("reason", OBSERVABILITY_ATTRIBUTE_REASON_INVALID_NAME), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_PLATFORM, "android"), TuplesKt.to("source", "android")));
        }
    }

    public void observerFwfCount(@NotNull String str, @NotNull Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        FunWithFlagsObservabilityPort funWithFlagsObservabilityPort = (FunWithFlagsObservabilityPort) observability.invoke();
        if (funWithFlagsObservabilityPort != null) {
            funWithFlagsObservabilityPort.observerFwfCount(str, map, MapsKt__MapsKt.mapOf(TuplesKt.to("module", "FunWithFlags"), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_PLATFORM, "android"), TuplesKt.to("source", "android")));
        }
    }

    public void observerTrackingEvent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "flagKey");
        Intrinsics.checkNotNullParameter(str2, "eventName");
        Intrinsics.checkNotNullParameter(str3, "eventVariation");
        FunWithFlagsObservabilityPort funWithFlagsObservabilityPort = (FunWithFlagsObservabilityPort) observability.invoke();
        if (funWithFlagsObservabilityPort != null) {
            funWithFlagsObservabilityPort.trackFWFExpEvents(MapsKt__MapsKt.mapOf(TuplesKt.to("flagName", str), TuplesKt.to("eventName", str2), TuplesKt.to("eventVariation", str3), TuplesKt.to("module", "FunWithFlags"), TuplesKt.to("reason", "ExpTracking"), TuplesKt.to(OBSERVABILITY_ATTRIBUTE_PLATFORM, "android"), TuplesKt.to("source", "android")));
        }
    }

    public final void setObservability$com_talabat_core_fwf_data_data(@NotNull Function0<? extends FunWithFlagsObservabilityPort> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        observability = function0;
    }
}
