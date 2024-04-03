package com.talabat.fluttercore.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/fluttercore/di/FlutterCoreViewComponent;", "", "inject", "", "target", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Factory", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationRemoteCoreLibApi.class, ExperimentCoreLibApi.class, FeatureFlagCoreLibApi.class, ObservabilityCoreLibApi.class, TrackingCoreLibApi.class})
public interface FlutterCoreViewComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/fluttercore/di/FlutterCoreViewComponent$Factory;", "", "create", "Lcom/talabat/fluttercore/di/FlutterCoreViewComponent;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        FlutterCoreViewComponent create(@NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi);
    }

    void inject(@NotNull TalabatFlutterFragmentActivity talabatFlutterFragmentActivity);
}
