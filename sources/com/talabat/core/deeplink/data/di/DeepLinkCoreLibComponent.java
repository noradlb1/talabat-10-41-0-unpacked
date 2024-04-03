package com.talabat.core.deeplink.data.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/deeplink/data/di/DeepLinkCoreLibComponent;", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "Factory", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {NavigationCoreLibApi.class, ObservabilityCoreLibApi.class, FeatureFlagCoreLibApi.class, ExperimentCoreLibApi.class, FlutterChannelsCoreLibApi.class, FlutterEngineCoreLibApi.class, DispatcherCoreLibApi.class, CustomerCoreLibApi.class}, modules = {DeepLinkCoreLibModule.class})
public interface DeepLinkCoreLibComponent extends DeepLinkCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/deeplink/data/di/DeepLinkCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/deeplink/data/di/DeepLinkCoreLibComponent;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "flutterChannelsCoreLibApi", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsCoreLibApi;", "flutterEngineCoreLibApi", "Lcom/talabat/core/flutter/engine/domain/di/FlutterEngineCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "customerCoreLibApi", "Lcom/talabat/customer/domain/di/CustomerCoreLibApi;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        DeepLinkCoreLibComponent create(@NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, @NotNull FlutterEngineCoreLibApi flutterEngineCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull CustomerCoreLibApi customerCoreLibApi);
    }
}
