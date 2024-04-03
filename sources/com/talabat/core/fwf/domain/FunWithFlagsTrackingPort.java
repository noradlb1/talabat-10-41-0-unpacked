package com.talabat.core.fwf.domain;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;", "", "track", "", "eventName", "", "attributes", "", "com_talabat_core_fwf_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FunWithFlagsTrackingPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void track$default(FunWithFlagsTrackingPort funWithFlagsTrackingPort, String str, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                funWithFlagsTrackingPort.track(str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }
    }

    void track(@NotNull String str, @NotNull Map<String, String> map);
}
