package com.talabat.core.flutter.channels.domain.dynamictrackingcache;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/dynamictrackingcache/DynamicTrackingCacheCallback;", "", "cacheEvent", "", "groupKey", "", "cacheKey", "resetWhen", "", "checkCacheEvent", "", "resetCacheEvent", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DynamicTrackingCacheCallback {
    void cacheEvent(@NotNull String str, @NotNull String str2, @NotNull List<String> list);

    boolean checkCacheEvent(@NotNull String str, @NotNull String str2);

    void resetCacheEvent(@NotNull String str, @NotNull String str2);
}
