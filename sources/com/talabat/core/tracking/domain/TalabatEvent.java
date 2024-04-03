package com.talabat.core.tracking.domain;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/talabat/core/tracking/domain/TalabatEvent;", "", "()V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_core_tracking_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TalabatEvent {
    @NotNull
    public abstract Map<String, Object> attributes(@NotNull PlatformName platformName);

    @NotNull
    public abstract String featureName(@NotNull PlatformName platformName);

    @NotNull
    public abstract String name(@NotNull PlatformName platformName);

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsKt.listOf(PlatformName.NEW_RELIC, PlatformName.GOOGLE_ANALYTICS);
    }
}
