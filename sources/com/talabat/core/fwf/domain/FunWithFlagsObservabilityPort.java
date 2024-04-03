package com.talabat.core.fwf.domain;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H&J\u001e\u0010\n\u001a\u00020\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H&J\u001e\u0010\f\u001a\u00020\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H&J&\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;", "", "observerFwfCount", "", "eventName", "", "map", "", "", "attrs", "trackCacheFill", "attributes", "trackFWFExpEvents", "trackUnExpectedScenario", "explanation", "com_talabat_core_fwf_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FunWithFlagsObservabilityPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void trackCacheFill$default(FunWithFlagsObservabilityPort funWithFlagsObservabilityPort, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                funWithFlagsObservabilityPort.trackCacheFill(map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackCacheFill");
        }

        public static /* synthetic */ void trackFWFExpEvents$default(FunWithFlagsObservabilityPort funWithFlagsObservabilityPort, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                funWithFlagsObservabilityPort.trackFWFExpEvents(map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackFWFExpEvents");
        }

        public static /* synthetic */ void trackUnExpectedScenario$default(FunWithFlagsObservabilityPort funWithFlagsObservabilityPort, String str, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                funWithFlagsObservabilityPort.trackUnExpectedScenario(str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackUnExpectedScenario");
        }
    }

    void observerFwfCount(@NotNull String str, @NotNull Map<String, Integer> map, @NotNull Map<String, String> map2);

    void trackCacheFill(@NotNull Map<String, String> map);

    void trackFWFExpEvents(@NotNull Map<String, String> map);

    void trackUnExpectedScenario(@NotNull String str, @NotNull Map<String, String> map);
}
