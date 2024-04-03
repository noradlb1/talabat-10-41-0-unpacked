package com.talabat.talabatcommon.views.wallet.benefitmanager.di.module;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.endpoint.BenefitPayEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.views.wallet.benefitmanager.data.impl.BenefitManagerRepositoryImpl;
import com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.api.BenefitManagerApi;
import com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.impl.BenefitManagerRemoteDataSourceImpl;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.application.usecase.GetBenefitBinDetailFeatureFlagUseCase;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.repository.BenefitManagerRepository;
import com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.data.impl.CheckoutPaymentManagerRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/benefitmanager/di/module/BenefitManagerDomainModule;", "", "()V", "provideBenefitManagerRepository", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/repository/BenefitManagerRepository;", "provideGetBenefitBinDetailUseCase", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/business/usecase/GetBenefitBinDetailUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitManagerDomainModule {
    @NotNull
    public static final BenefitManagerDomainModule INSTANCE = new BenefitManagerDomainModule();

    private BenefitManagerDomainModule() {
    }

    private final BenefitManagerRepository provideBenefitManagerRepository() {
        return new BenefitManagerRepositoryImpl(new BenefitManagerRemoteDataSourceImpl((BenefitManagerApi) new TalabatAPIBuilder().createApi(BenefitPayEndPointProvider.INSTANCE.getBaseUrl(), BenefitManagerApi.class)));
    }

    @NotNull
    public final GetBenefitBinDetailUseCase provideGetBenefitBinDetailUseCase(@NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        return new GetBenefitBinDetailUseCase(provideBenefitManagerRepository(), new GetBenefitBinDetailFeatureFlagUseCase(iTalabatFeatureFlag, configurationLocalRepository), new CheckoutPaymentManagerRepositoryImpl(), (CoroutineDispatcher) null, 8, (DefaultConstructorMarker) null);
    }
}
