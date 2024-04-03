package com.talabat.core.tracking.data.platform;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H&¨\u0006\t"}, d2 = {"Lcom/talabat/core/tracking/data/platform/TrackingPlatform;", "", "getCommonAttributes", "", "", "eventName", "track", "", "attributes", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackingPlatform {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Map<String, Object> getCommonAttributes(@NotNull TrackingPlatform trackingPlatform, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            return MapsKt__MapsKt.emptyMap();
        }
    }

    @NotNull
    Map<String, Object> getCommonAttributes(@NotNull String str);

    void track(@NotNull String str, @NotNull Map<String, ? extends Object> map);
}
