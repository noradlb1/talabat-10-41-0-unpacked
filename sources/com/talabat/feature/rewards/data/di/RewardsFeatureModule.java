package com.talabat.feature.rewards.data.di;

import com.talabat.feature.rewards.data.RealRewardsMissionRepository;
import com.talabat.feature.rewards.data.tracking.DefaultMissionTracker;
import com.talabat.feature.rewards.data.tracking.DefaultRewardsTracker;
import com.talabat.feature.rewards.domain.MissionTracker;
import com.talabat.feature.rewards.domain.RewardsMissionRepository;
import com.talabat.feature.rewards.domain.RewardsTracker;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'¨\u0006\f"}, d2 = {"Lcom/talabat/feature/rewards/data/di/RewardsFeatureModule;", "", "missionTracker", "Lcom/talabat/feature/rewards/domain/MissionTracker;", "impl", "Lcom/talabat/feature/rewards/data/tracking/DefaultMissionTracker;", "rewardsMissionRepository", "Lcom/talabat/feature/rewards/domain/RewardsMissionRepository;", "Lcom/talabat/feature/rewards/data/RealRewardsMissionRepository;", "rewardsTracker", "Lcom/talabat/feature/rewards/domain/RewardsTracker;", "Lcom/talabat/feature/rewards/data/tracking/DefaultRewardsTracker;", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {RewardsNetworkModule.class})
public interface RewardsFeatureModule {
    @NotNull
    @Binds
    MissionTracker missionTracker(@NotNull DefaultMissionTracker defaultMissionTracker);

    @NotNull
    @Binds
    @Reusable
    RewardsMissionRepository rewardsMissionRepository(@NotNull RealRewardsMissionRepository realRewardsMissionRepository);

    @NotNull
    @Binds
    RewardsTracker rewardsTracker(@NotNull DefaultRewardsTracker defaultRewardsTracker);
}
