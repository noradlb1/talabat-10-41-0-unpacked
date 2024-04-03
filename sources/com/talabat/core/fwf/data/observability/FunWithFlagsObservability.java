package com.talabat.core.fwf.data.observability;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u0016H&J \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H&¨\u0006\u001a"}, d2 = {"Lcom/talabat/core/fwf/data/observability/FunWithFlagsObservability;", "", "observeAsyncInvalidFlagNameError", "", "flagName", "", "observeCacheFill", "flagsSubscribed", "", "flagsCached", "observeEmptyCacheError", "observeEmptyResponseError", "observeFWFNotSupportedVariationType", "error", "observeFlagNotFoundInCacheError", "cacheSize", "", "observeFwfSdkError", "observeInvalidFlagNameError", "observerFwfCount", "eventName", "map", "", "observerTrackingEvent", "flagKey", "eventVariation", "com_talabat_core_fwf_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FunWithFlagsObservability {
    void observeAsyncInvalidFlagNameError(@NotNull String str);

    void observeCacheFill(@NotNull Set<String> set, @NotNull Set<String> set2);

    void observeEmptyCacheError(@NotNull String str);

    void observeEmptyResponseError();

    void observeFWFNotSupportedVariationType(@NotNull String str, @NotNull String str2);

    void observeFlagNotFoundInCacheError(@NotNull String str, int i11);

    void observeFwfSdkError(@NotNull String str, @NotNull String str2);

    void observeInvalidFlagNameError(@NotNull String str);

    void observerFwfCount(@NotNull String str, @NotNull Map<String, Integer> map);

    void observerTrackingEvent(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
