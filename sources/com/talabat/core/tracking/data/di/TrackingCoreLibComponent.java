package com.talabat.core.tracking.data.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibModule;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/tracking/data/di/TrackingCoreLibComponent;", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "Factory", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ContextCoreLibApi.class, FeatureFlagCoreLibApi.class, GmsBaseCoreLibApi.class, HmsBaseCoreLibApi.class, ObservabilityCoreLibApi.class, TalabatPerseusCoreLibApi.class}, modules = {AdjustTrackerModule.class, FlutterMigrationModule.class, RemoteConfigCoreLibModule.class, PerseusModule.class, TrackingCoreModule.class})
public interface TrackingCoreLibComponent extends TrackingCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/tracking/data/di/TrackingCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/tracking/data/di/TrackingCoreLibComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "gmsBaseCoreLibApi", "Lcom/talabat/core/gms/base/domain/GmsBaseCoreLibApi;", "hmsBaseCoreLibApi", "Lcom/talabat/core/hms/base/domain/HmsBaseCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "talabatPerseusCoreLibApi", "Lcom/talabat/core/perseus/domain/TalabatPerseusCoreLibApi;", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        TrackingCoreLibComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull GmsBaseCoreLibApi gmsBaseCoreLibApi, @NotNull HmsBaseCoreLibApi hmsBaseCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull TalabatPerseusCoreLibApi talabatPerseusCoreLibApi);
    }
}
