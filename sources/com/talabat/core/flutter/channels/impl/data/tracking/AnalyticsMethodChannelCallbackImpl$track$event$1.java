package com.talabat.core.flutter.channels.impl.data.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\fH\u0016¨\u0006\r"}, d2 = {"com/talabat/core/flutter/channels/impl/data/tracking/AnalyticsMethodChannelCallbackImpl$track$event$1", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsMethodChannelCallbackImpl$track$event$1 extends TalabatEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f55931a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f55932b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f55933c;

    public AnalyticsMethodChannelCallbackImpl$track$event$1(String str, String str2, Map<String, String> map) {
        this.f55931a = str;
        this.f55932b = str2;
        this.f55933c = map;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.f55933c;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.f55932b;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.f55931a;
    }

    @NotNull
    public ArrayList<PlatformName> platforms() {
        return CollectionsKt__CollectionsKt.arrayListOf(PlatformName.NEW_RELIC);
    }
}
