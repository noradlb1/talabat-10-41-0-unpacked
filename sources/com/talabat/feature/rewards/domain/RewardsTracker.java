package com.talabat.feature.rewards.domain;

import com.talabat.feature.rewards.domain.model.ButtonType;
import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/rewards/domain/RewardsTracker;", "", "onPointsCatalogueLoaded", "", "missionOrigin", "Lcom/talabat/feature/rewards/domain/model/MissionOrigin;", "missions", "", "Lcom/talabat/feature/rewards/domain/model/Mission;", "rewardsCatalogueOrigin", "", "onPointsSuccessLoaded", "offerVoucherId", "buttonType", "Lcom/talabat/feature/rewards/domain/model/ButtonType;", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RewardsTracker {
    void onPointsCatalogueLoaded(@Nullable MissionOrigin missionOrigin, @NotNull List<Mission> list, @Nullable String str);

    void onPointsSuccessLoaded(@Nullable String str, @NotNull ButtonType buttonType);
}
