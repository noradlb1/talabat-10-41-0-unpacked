package com.talabat.core.observabilityNew.domain;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/RequestResponseObservability;", "", "track", "", "eventType", "", "eventName", "attributes", "", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RequestResponseObservability {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void track$default(RequestResponseObservability requestResponseObservability, String str, String str2, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                requestResponseObservability.track(str, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }
    }

    void track(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);
}
