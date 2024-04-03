package com.talabat.core.observabilityNew.domain.squads.home;

import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/squads/home/UserAccountScreenPerformanceParams;", "", "()V", "createScreenTrackerParams", "Lcom/talabat/core/observabilityNew/domain/entity/ScreenTrackerParams;", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserAccountScreenPerformanceParams {
    @NotNull
    public static final UserAccountScreenPerformanceParams INSTANCE = new UserAccountScreenPerformanceParams();

    private UserAccountScreenPerformanceParams() {
    }

    @NotNull
    public final ScreenTrackerParams createScreenTrackerParams() {
        return new ScreenTrackerParams("homeUserAccount", HomeScreenPerformanceParams.SCREEN_NAME, "userAccount");
    }
}
