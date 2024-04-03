package com.talabat.darkstores.feature.observability;

import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bH&J0\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/feature/observability/DarkStoreObservabilityTracker;", "", "trackQCPerformance", "", "performance", "Lcom/talabat/darkstores/feature/observability/PerformanceAttribute;", "vendorCode", "", "screenName", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "additionalAttributes", "", "trackUnExpectedScenarios", "error", "", "globalVendorId", "apiName", "excludedHttpResponseCodes", "", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkStoreObservabilityTracker {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void trackUnExpectedScenarios$default(DarkStoreObservabilityTracker darkStoreObservabilityTracker, Throwable th2, String str, String str2, Set set, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 8) != 0) {
                    set = SetsKt__SetsKt.emptySet();
                }
                darkStoreObservabilityTracker.trackUnExpectedScenarios(th2, str, str2, set);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackUnExpectedScenarios");
        }
    }

    void trackQCPerformance(@NotNull PerformanceAttribute performanceAttribute, @NotNull String str, @NotNull ScreenTrackingProvider.ScreenName screenName, @NotNull Map<String, String> map);

    void trackUnExpectedScenarios(@NotNull Throwable th2, @NotNull String str, @NotNull String str2, @NotNull Set<Integer> set);
}
