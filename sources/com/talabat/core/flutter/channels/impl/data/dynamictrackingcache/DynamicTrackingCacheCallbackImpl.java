package com.talabat.core.flutter.channels.impl.data.dynamictrackingcache;

import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/dynamictrackingcache/DynamicTrackingCacheCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/dynamictrackingcache/DynamicTrackingCacheCallback;", "()V", "cacheEvent", "", "groupKey", "", "cacheKey", "resetWhen", "", "checkCacheEvent", "", "resetCacheEvent", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DynamicTrackingCacheCallbackImpl implements DynamicTrackingCacheCallback {
    public void cacheEvent(@NotNull String str, @NotNull String str2, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "groupKey");
        Intrinsics.checkNotNullParameter(str2, "cacheKey");
        Intrinsics.checkNotNullParameter(list, "resetWhen");
        EventsCache.INSTANCE.set(str, str2, list);
    }

    public boolean checkCacheEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "groupKey");
        Intrinsics.checkNotNullParameter(str2, "cacheKey");
        return EventsCache.INSTANCE.exists(str, str2);
    }

    public void resetCacheEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "groupKey");
        Intrinsics.checkNotNullParameter(str2, "resetWhen");
        EventsCache.INSTANCE.remove(str, str2);
    }
}
