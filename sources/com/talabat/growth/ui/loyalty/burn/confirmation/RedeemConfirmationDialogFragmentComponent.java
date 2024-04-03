package com.talabat.growth.ui.loyalty.burn.confirmation;

import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/confirmation/RedeemConfirmationDialogFragmentComponent;", "", "inject", "", "fragment", "Lcom/talabat/growth/ui/loyalty/burn/confirmation/RedeemConfirmationDialogFragment;", "Factory", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ObservabilityCoreLibApi.class, RewardsFeatureApi.class})
public interface RedeemConfirmationDialogFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/confirmation/RedeemConfirmationDialogFragmentComponent$Factory;", "", "create", "Lcom/talabat/growth/ui/loyalty/burn/confirmation/RedeemConfirmationDialogFragmentComponent;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "rewardsFeatureApi", "Lcom/talabat/feature/rewards/domain/RewardsFeatureApi;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        RedeemConfirmationDialogFragmentComponent create(@NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull RewardsFeatureApi rewardsFeatureApi);
    }

    void inject(@NotNull RedeemConfirmationDialogFragment redeemConfirmationDialogFragment);
}
