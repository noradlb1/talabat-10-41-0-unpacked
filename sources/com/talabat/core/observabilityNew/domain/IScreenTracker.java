package com.talabat.core.observabilityNew.domain;

import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "", "initialize", "", "startTrace", "params", "Lcom/talabat/core/observabilityNew/domain/entity/ScreenTrackerParams;", "stopTrace", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IScreenTracker {
    void initialize();

    void startTrace(@NotNull ScreenTrackerParams screenTrackerParams);

    void stopTrace(@NotNull ScreenTrackerParams screenTrackerParams);
}
