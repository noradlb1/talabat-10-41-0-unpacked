package com.talabat.feature.ulcampaign.data.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/ulcampaign/data/di/CampaignMigratorFeatureComponent;", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorFeatureApi;", "Factory", "com_talabat_feature_ul-campaign_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ContextCoreLibApi.class, ObservabilityCoreLibApi.class}, modules = {CampaignMigratorFeatureModule.class})
public interface CampaignMigratorFeatureComponent extends CampaignMigratorFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/ulcampaign/data/di/CampaignMigratorFeatureComponent$Factory;", "", "create", "Lcom/talabat/feature/ulcampaign/data/di/CampaignMigratorFeatureComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "com_talabat_feature_ul-campaign_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        CampaignMigratorFeatureComponent create(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi);
    }
}
