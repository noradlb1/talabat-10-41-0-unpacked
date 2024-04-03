package com.talabat.feature.ridertips.data.observability;

import com.talabat.feature.ridertips.domain.IRiderTipObservability;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.observability.ObservabilityManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/feature/ridertips/data/observability/RiderTipObservability;", "Lcom/talabat/feature/ridertips/domain/IRiderTipObservability;", "()V", "observeUnexpectedScenario", "", "name", "", "attributes", "", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipObservability implements IRiderTipObservability {
    public void observeUnexpectedScenario(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        ObservabilityManager.trackUnExpectedScenario(str, map);
    }
}
