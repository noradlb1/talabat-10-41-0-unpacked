package com.talabat.feature.rewards.domain;

import com.talabat.core.di.Api;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/rewards/domain/RewardsFeatureApi;", "Lcom/talabat/core/di/Api;", "missionTracker", "Lcom/talabat/feature/rewards/domain/MissionTracker;", "getMissionTracker", "()Lcom/talabat/feature/rewards/domain/MissionTracker;", "repository", "Lcom/talabat/feature/rewards/domain/RewardsMissionRepository;", "getRepository", "()Lcom/talabat/feature/rewards/domain/RewardsMissionRepository;", "rewardsTracker", "Lcom/talabat/feature/rewards/domain/RewardsTracker;", "getRewardsTracker", "()Lcom/talabat/feature/rewards/domain/RewardsTracker;", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RewardsFeatureApi extends Api {
    @NotNull
    MissionTracker getMissionTracker();

    @NotNull
    RewardsMissionRepository getRepository();

    @NotNull
    RewardsTracker getRewardsTracker();
}
