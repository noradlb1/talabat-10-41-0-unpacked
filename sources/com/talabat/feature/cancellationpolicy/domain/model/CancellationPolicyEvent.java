package com.talabat.feature.cancellationpolicy.domain.model;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/domain/model/CancellationPolicyEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "eventName", "", "(Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_feature_helpcenter_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyEvent extends TalabatEvent {
    @NotNull
    private final String eventName;

    public CancellationPolicyEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        this.eventName = str;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("screenName", "Checkout Screen"), TuplesKt.to("screenType", "checkout"));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return CancellationPolicyEventKt.FEATURE_CANCELLATION_POLICY;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.eventName;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsKt.listOf(PlatformName.GOOGLE_ANALYTICS, PlatformName.NEW_RELIC);
    }
}
