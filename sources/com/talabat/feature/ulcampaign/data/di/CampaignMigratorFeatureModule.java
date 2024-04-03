package com.talabat.feature.ulcampaign.data.di;

import com.talabat.feature.ulcampaign.data.CampaignMigratorObservability;
import com.talabat.feature.ulcampaign.data.CampaignMigratorObservabilityImpl;
import com.talabat.feature.ulcampaign.data.CampaignMigratorRepositoryImpl;
import com.talabat.feature.ulcampaign.data.CampaignMigratorSharedPreferencesImpl;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorRepository;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH'¨\u0006\r"}, d2 = {"Lcom/talabat/feature/ulcampaign/data/di/CampaignMigratorFeatureModule;", "", "campaignMigratorObservability", "Lcom/talabat/feature/ulcampaign/data/CampaignMigratorObservability;", "imp", "Lcom/talabat/feature/ulcampaign/data/CampaignMigratorObservabilityImpl;", "campaignMigratorRepository", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorRepository;", "Lcom/talabat/feature/ulcampaign/data/CampaignMigratorRepositoryImpl;", "provideSharedPreferenceManager", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;", "impl", "Lcom/talabat/feature/ulcampaign/data/CampaignMigratorSharedPreferencesImpl;", "com_talabat_feature_ul-campaign_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface CampaignMigratorFeatureModule {
    @NotNull
    @Binds
    @Reusable
    CampaignMigratorObservability campaignMigratorObservability(@NotNull CampaignMigratorObservabilityImpl campaignMigratorObservabilityImpl);

    @NotNull
    @Binds
    @Reusable
    CampaignMigratorRepository campaignMigratorRepository(@NotNull CampaignMigratorRepositoryImpl campaignMigratorRepositoryImpl);

    @NotNull
    @Binds
    @Reusable
    CampaignMigratorSharedPreferences provideSharedPreferenceManager(@NotNull CampaignMigratorSharedPreferencesImpl campaignMigratorSharedPreferencesImpl);
}
