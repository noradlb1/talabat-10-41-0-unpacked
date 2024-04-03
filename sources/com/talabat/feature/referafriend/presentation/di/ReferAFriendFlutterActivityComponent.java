package com.talabat.feature.referafriend.presentation.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.referafriend.domain.di.ReferAFriendFeatureApi;
import com.talabat.feature.referafriend.presentation.ui.ReferAFriendReceiverFlutterActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/referafriend/presentation/di/ReferAFriendFlutterActivityComponent;", "", "inject", "", "activity", "Lcom/talabat/feature/referafriend/presentation/ui/ReferAFriendReceiverFlutterActivity;", "Factory", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ContextCoreLibApi.class, FeatureFlagCoreLibApi.class, TrackingCoreLibApi.class, ConfigurationLocalCoreLibApi.class, DispatcherCoreLibApi.class, ReferAFriendFeatureApi.class}, modules = {GrowthTrackerModule.class, ReferAFriendFlutterActivityModule.class})
public interface ReferAFriendFlutterActivityComponent {

    @Component.Factory
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/referafriend/presentation/di/ReferAFriendFlutterActivityComponent$Factory;", "", "create", "Lcom/talabat/feature/referafriend/presentation/di/ReferAFriendFlutterActivityComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "referAFriendFeatureApi", "Lcom/talabat/feature/referafriend/domain/di/ReferAFriendFeatureApi;", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        ReferAFriendFlutterActivityComponent create(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull ReferAFriendFeatureApi referAFriendFeatureApi);
    }

    void inject(@NotNull ReferAFriendReceiverFlutterActivity referAFriendReceiverFlutterActivity);
}
