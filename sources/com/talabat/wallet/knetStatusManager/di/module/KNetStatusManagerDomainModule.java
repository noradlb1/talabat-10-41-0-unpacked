package com.talabat.wallet.knetStatusManager.di.module;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.endpoint.MonolithEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.knetStatusManager.data.impl.KNetStatusManagerRepositoryImpl;
import com.talabat.wallet.knetStatusManager.data.remote.api.KNetStatusManagerApi;
import com.talabat.wallet.knetStatusManager.data.remote.impl.KNetStatusManagerRemoteDataSourceImpl;
import com.talabat.wallet.knetStatusManager.domain.application.usecase.IsKNetStatusCheckEnabledUseCase;
import com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase;
import com.talabat.wallet.knetStatusManager.domain.repository.KNetStatusManagerRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/di/module/KNetStatusManagerDomainModule;", "", "()V", "provideGetKNetStatusUseCase", "Lcom/talabat/wallet/knetStatusManager/domain/business/usecase/GetKNetStatusUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "provideIsKNetStatusCheckEnabledUseCase", "Lcom/talabat/wallet/knetStatusManager/domain/application/usecase/IsKNetStatusCheckEnabledUseCase;", "provideKNetStatusManagerRepository", "Lcom/talabat/wallet/knetStatusManager/domain/repository/KNetStatusManagerRepository;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KNetStatusManagerDomainModule {
    @NotNull
    public static final KNetStatusManagerDomainModule INSTANCE = new KNetStatusManagerDomainModule();

    private KNetStatusManagerDomainModule() {
    }

    @NotNull
    public final GetKNetStatusUseCase provideGetKNetStatusUseCase(@NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        return new GetKNetStatusUseCase(provideIsKNetStatusCheckEnabledUseCase(configurationLocalRepository, iTalabatFeatureFlag), provideKNetStatusManagerRepository(), iObservabilityManager);
    }

    @NotNull
    public final IsKNetStatusCheckEnabledUseCase provideIsKNetStatusCheckEnabledUseCase(@NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        return new IsKNetStatusCheckEnabledUseCase(iTalabatFeatureFlag, configurationLocalRepository);
    }

    @NotNull
    public final KNetStatusManagerRepository provideKNetStatusManagerRepository() {
        return new KNetStatusManagerRepositoryImpl(new KNetStatusManagerRemoteDataSourceImpl((KNetStatusManagerApi) new TalabatAPIBuilder().createApi(MonolithEndPointProvider.INSTANCE.getBaseUrl(), KNetStatusManagerApi.class)));
    }
}
