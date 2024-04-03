package com.talabat.feature.tmart.growth.domain;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthTracker;", "", "claimClicked", "", "trackingInfo", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "homeWidgetLoaded", "openTMartClicked", "screenType", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;", "preferenceSelected", "selectedPreference", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthSelectedPreference;", "reminderWidgetLoaded", "title", "", "shopNowClicked", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITMartGrowthTracker {
    void claimClicked(@NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo);

    void homeWidgetLoaded(@NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo);

    void openTMartClicked(@NotNull TMartGrowthScreenType tMartGrowthScreenType, @NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo);

    void preferenceSelected(@NotNull TMartGrowthSelectedPreference tMartGrowthSelectedPreference, @NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo);

    void reminderWidgetLoaded(@NotNull String str, @NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo);

    void shopNowClicked(@NotNull TMartGrowthScreenType tMartGrowthScreenType, @NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo);
}
