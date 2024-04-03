package com.talabat.feature.rating.data.di;

import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/rating/data/di/RatingFeatureComponent;", "Lcom/talabat/feature/rating/domain/RatingFeatureApi;", "Factory", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ContextCoreLibApi.class, ConfigurationLocalCoreLibApi.class, NetworkCoreLibApi.class, TokenCoreLibApi.class, TrackingCoreLibApi.class}, modules = {RatingFeatureModule.class})
public interface RatingFeatureComponent extends RatingFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/rating/data/di/RatingFeatureComponent$Factory;", "", "create", "Lcom/talabat/feature/rating/data/di/RatingFeatureComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "tokenCoreLibApi", "Lcom/talabat/authentication/token/domain/TokenCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        RatingFeatureComponent create(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull TokenCoreLibApi tokenCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi);
    }
}
