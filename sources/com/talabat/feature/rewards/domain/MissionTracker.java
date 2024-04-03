package com.talabat.feature.rewards.domain;

import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.domain.model.MissionButtonType;
import com.talabat.feature.rewards.domain.model.MissionClickType;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH&J \u0010\u0010\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/rewards/domain/MissionTracker;", "", "onMissionButtonClicked", "", "buttonType", "Lcom/talabat/feature/rewards/domain/model/MissionButtonType;", "origin", "Lcom/talabat/feature/rewards/domain/model/MissionOrigin;", "onMissionClicked", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "clickType", "Lcom/talabat/feature/rewards/domain/model/MissionClickType;", "onMissionCompleted", "onMissionDetailLoaded", "onMissionSuccessLoaded", "onMissionsShopListLoaded", "missions", "", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MissionTracker {
    void onMissionButtonClicked(@NotNull MissionButtonType missionButtonType, @Nullable MissionOrigin missionOrigin);

    void onMissionClicked(@Nullable MissionOrigin missionOrigin, @NotNull Mission mission, @NotNull MissionClickType missionClickType);

    void onMissionCompleted(@Nullable MissionOrigin missionOrigin, @NotNull Mission mission);

    void onMissionDetailLoaded(@Nullable MissionOrigin missionOrigin, @NotNull Mission mission);

    void onMissionSuccessLoaded(@Nullable MissionOrigin missionOrigin, @NotNull Mission mission);

    void onMissionsShopListLoaded(@Nullable MissionOrigin missionOrigin, @NotNull List<Mission> list);
}
