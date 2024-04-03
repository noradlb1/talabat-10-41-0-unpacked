package com.talabat.wallet.qPayManager.di.module;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.wallet.qPayManager.domain.application.usecase.GetQPayFeatureFlagUseCase;
import com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayEnabledUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/qPayManager/di/module/QPayManagerDomainModule;", "", "()V", "provideGetQPayEnabledUseCase", "Lcom/talabat/wallet/qPayManager/domain/business/usecase/GetQPayEnabledUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "provideGetQPayFeatureFlagUseCase", "Lcom/talabat/wallet/qPayManager/domain/application/usecase/GetQPayFeatureFlagUseCase;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayManagerDomainModule {
    @NotNull
    public static final QPayManagerDomainModule INSTANCE = new QPayManagerDomainModule();

    private QPayManagerDomainModule() {
    }

    private final GetQPayFeatureFlagUseCase provideGetQPayFeatureFlagUseCase(ConfigurationLocalRepository configurationLocalRepository, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new GetQPayFeatureFlagUseCase(iTalabatFeatureFlag, configurationLocalRepository);
    }

    @NotNull
    public final GetQPayEnabledUseCase provideGetQPayEnabledUseCase(@NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        return new GetQPayEnabledUseCase(provideGetQPayFeatureFlagUseCase(configurationLocalRepository, iTalabatFeatureFlag));
    }
}
