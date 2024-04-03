package com.talabat.feature.rewards.presentation.mission.details;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragmentComponent;", "", "inject", "", "target", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment;", "Factory", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {RewardsFeatureApi.class, DeepLinkCoreLibApi.class})
public interface MissionDetailsDialogFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragmentComponent$Factory;", "", "create", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragmentComponent;", "rewardsFeatureApi", "Lcom/talabat/feature/rewards/domain/RewardsFeatureApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        MissionDetailsDialogFragmentComponent create(@NotNull RewardsFeatureApi rewardsFeatureApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi);
    }

    void inject(@NotNull MissionDetailsDialogFragment missionDetailsDialogFragment);
}
