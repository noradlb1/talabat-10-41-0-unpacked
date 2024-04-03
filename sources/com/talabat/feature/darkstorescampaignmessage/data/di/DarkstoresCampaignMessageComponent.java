package com.talabat.feature.darkstorescampaignmessage.data.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.feature.darkstorescampaignmessage.domain.CampaignMessagingApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/data/di/DarkstoresCampaignMessageComponent;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/CampaignMessagingApi;", "Factory", "com_talabat_feature_darkstores-campaign-message_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {DispatcherCoreLibApi.class, FeatureFlagCoreLibApi.class, NetworkCoreLibApi.class, SecretCoreLibApi.class}, modules = {CampaignMessageNetworkModule.class, CampaignMessageDataModule.class})
public interface DarkstoresCampaignMessageComponent extends CampaignMessagingApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/data/di/DarkstoresCampaignMessageComponent$Factory;", "", "create", "Lcom/talabat/feature/darkstorescampaignmessage/data/di/DarkstoresCampaignMessageComponent;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "secretCoreLibApi", "Lcom/talabat/authentication/aaa/di/SecretCoreLibApi;", "com_talabat_feature_darkstores-campaign-message_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        DarkstoresCampaignMessageComponent create(@NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull SecretCoreLibApi secretCoreLibApi);
    }
}
