package com.talabat.core.safety.data.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.advertisement.google.domain.GoogleAdvertisementCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/safety/data/di/SafetyCoreLibComponent;", "Lcom/talabat/core/safety/domain/SafetyCoreLibApi;", "Factory", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, ContextCoreLibApi.class, DispatcherCoreLibApi.class, GoogleAdvertisementCoreLibApi.class, GmsBaseCoreLibApi.class, NetworkCoreLibApi.class, ObservabilityCoreLibApi.class, SecretCoreLibApi.class, TalabatPerseusCoreLibApi.class}, modules = {IdentifiersModule.class, PlayIntegrityNetworkModule.class, SafetyModule.class})
public interface SafetyCoreLibComponent extends SafetyCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JX\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, d2 = {"Lcom/talabat/core/safety/data/di/SafetyCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/safety/data/di/SafetyCoreLibComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "googleAdvertisementCoreLibApi", "Lcom/talabat/core/advertisement/google/domain/GoogleAdvertisementCoreLibApi;", "gmsBaseCoreLibApi", "Lcom/talabat/core/gms/base/domain/GmsBaseCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "secretCoreLibApi", "Lcom/talabat/authentication/aaa/di/SecretCoreLibApi;", "talabatPerseusCoreLibApi", "Lcom/talabat/core/perseus/domain/TalabatPerseusCoreLibApi;", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        SafetyCoreLibComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi, @NotNull GmsBaseCoreLibApi gmsBaseCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull SecretCoreLibApi secretCoreLibApi, @NotNull TalabatPerseusCoreLibApi talabatPerseusCoreLibApi);
    }
}
