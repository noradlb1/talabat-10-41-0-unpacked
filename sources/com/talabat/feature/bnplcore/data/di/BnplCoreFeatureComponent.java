package com.talabat.feature.bnplcore.data.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.bnplcore.domain.BnplCoreFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/bnplcore/data/di/BnplCoreFeatureComponent;", "Lcom/talabat/feature/bnplcore/domain/BnplCoreFeatureApi;", "Factory", "com_talabat_feature_bnpl-core_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ContextCoreLibApi.class, FeatureFlagCoreLibApi.class, FlutterEngineCoreLibApi.class, FlutterChannelsCoreLibApi.class, NetworkCoreLibApi.class, TrackingCoreLibApi.class, TrackingCoreLibApi.class}, modules = {BnplModule.class})
public interface BnplCoreFeatureComponent extends BnplCoreFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/bnplcore/data/di/BnplCoreFeatureComponent$Factory;", "", "create", "Lcom/talabat/feature/bnplcore/data/di/BnplCoreFeatureComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "flutterEngineCoreLibApi", "Lcom/talabat/core/flutter/engine/domain/di/FlutterEngineCoreLibApi;", "flutterChannelsCoreLibApi", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsCoreLibApi;", "com_talabat_feature_bnpl-core_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        BnplCoreFeatureComponent create(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi, @NotNull FlutterEngineCoreLibApi flutterEngineCoreLibApi, @NotNull FlutterChannelsCoreLibApi flutterChannelsCoreLibApi);
    }
}
