package com.talabat.darkstores.feature.cart;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetailsRepo;
import com.talabat.darkstores.data.grocery.GroceryShoppingRepository;
import com.talabat.darkstores.feature.campaigns.CampaignProgressStateMapper;
import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressResponseMapper;
import com.talabat.feature.darkstorescampaignmessage.domain.usecase.GetCampaignMessageUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class CampaignProgressUseCase_Factory implements Factory<CampaignProgressUseCase> {
    private final Provider<CampaignProgressResponseMapper> campaignProgressResponseMapperProvider;
    private final Provider<CampaignProgressStateMapper> campaignProgressStateMapperProvider;
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<DeliveryDetailsRepo> deliveryDetailsRepoProvider;
    private final Provider<GroceryDeliveryFeeTierFeatureFlagUseCase> deliveryFeeTierFeatureFlagUseCaseProvider;
    private final Provider<GetCampaignMessageUseCase> getCampaignMessageUseCaseProvider;
    private final Provider<GroceryShoppingRepository> groceryShoppingRepoProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public CampaignProgressUseCase_Factory(Provider<DarkstoresRepo> provider, Provider<GroceryShoppingRepository> provider2, Provider<DeliveryDetailsRepo> provider3, Provider<Scheduler> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<GetCampaignMessageUseCase> provider6, Provider<ConfigurationParameters> provider7, Provider<CampaignProgressResponseMapper> provider8, Provider<CampaignProgressStateMapper> provider9, Provider<GroceryDeliveryFeeTierFeatureFlagUseCase> provider10) {
        this.darkstoresRepoProvider = provider;
        this.groceryShoppingRepoProvider = provider2;
        this.deliveryDetailsRepoProvider = provider3;
        this.ioSchedulerProvider = provider4;
        this.talabatFeatureFlagProvider = provider5;
        this.getCampaignMessageUseCaseProvider = provider6;
        this.configurationParametersProvider = provider7;
        this.campaignProgressResponseMapperProvider = provider8;
        this.campaignProgressStateMapperProvider = provider9;
        this.deliveryFeeTierFeatureFlagUseCaseProvider = provider10;
    }

    public static CampaignProgressUseCase_Factory create(Provider<DarkstoresRepo> provider, Provider<GroceryShoppingRepository> provider2, Provider<DeliveryDetailsRepo> provider3, Provider<Scheduler> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<GetCampaignMessageUseCase> provider6, Provider<ConfigurationParameters> provider7, Provider<CampaignProgressResponseMapper> provider8, Provider<CampaignProgressStateMapper> provider9, Provider<GroceryDeliveryFeeTierFeatureFlagUseCase> provider10) {
        return new CampaignProgressUseCase_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static CampaignProgressUseCase newInstance(DarkstoresRepo darkstoresRepo, GroceryShoppingRepository groceryShoppingRepository, DeliveryDetailsRepo deliveryDetailsRepo, Scheduler scheduler, ITalabatFeatureFlag iTalabatFeatureFlag, GetCampaignMessageUseCase getCampaignMessageUseCase, ConfigurationParameters configurationParameters, CampaignProgressResponseMapper campaignProgressResponseMapper, CampaignProgressStateMapper campaignProgressStateMapper, GroceryDeliveryFeeTierFeatureFlagUseCase groceryDeliveryFeeTierFeatureFlagUseCase) {
        return new CampaignProgressUseCase(darkstoresRepo, groceryShoppingRepository, deliveryDetailsRepo, scheduler, iTalabatFeatureFlag, getCampaignMessageUseCase, configurationParameters, campaignProgressResponseMapper, campaignProgressStateMapper, groceryDeliveryFeeTierFeatureFlagUseCase);
    }

    public CampaignProgressUseCase get() {
        return newInstance(this.darkstoresRepoProvider.get(), this.groceryShoppingRepoProvider.get(), this.deliveryDetailsRepoProvider.get(), this.ioSchedulerProvider.get(), this.talabatFeatureFlagProvider.get(), this.getCampaignMessageUseCaseProvider.get(), this.configurationParametersProvider.get(), this.campaignProgressResponseMapperProvider.get(), this.campaignProgressStateMapperProvider.get(), this.deliveryFeeTierFeatureFlagUseCaseProvider.get());
    }
}
