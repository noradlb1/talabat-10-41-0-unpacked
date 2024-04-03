package com.talabat.wallet.debitcarddeflection.presentation.viewmodel.di.module;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.talabatcommon.views.wallet.benefitmanager.di.module.BenefitManagerDomainModule;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.di.module.QPayDomainModule;
import com.talabat.wallet.debitcarddeflection.domain.business.GetBinVerificationDisplayModelUseCase;
import com.talabat.wallet.debitcarddeflection.domain.business.GetBinsDetailDisplayModelUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/debitcarddeflection/presentation/viewmodel/di/module/DebitCardDeflectionPresentationModule;", "", "()V", "provideGetBinVerificationDisplayModelUseCase", "Lcom/talabat/wallet/debitcarddeflection/domain/business/GetBinVerificationDisplayModelUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "flag", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "provideGetBinsDetailDisplayModelUseCase", "Lcom/talabat/wallet/debitcarddeflection/domain/business/GetBinsDetailDisplayModelUseCase;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebitCardDeflectionPresentationModule {
    @NotNull
    public static final DebitCardDeflectionPresentationModule INSTANCE = new DebitCardDeflectionPresentationModule();

    private DebitCardDeflectionPresentationModule() {
    }

    @NotNull
    public final GetBinVerificationDisplayModelUseCase provideGetBinVerificationDisplayModelUseCase(@NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull FWFKey fWFKey, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(fWFKey, "flag");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        return new GetBinVerificationDisplayModelUseCase(BenefitManagerDomainModule.INSTANCE.provideGetBenefitBinDetailUseCase(configurationLocalRepository, iTalabatFeatureFlag), QPayDomainModule.INSTANCE.provideGetQPayDeflectionBinsUseCase(fWFKey, iTalabatFeatureFlag), configurationLocalRepository);
    }

    @NotNull
    public final GetBinsDetailDisplayModelUseCase provideGetBinsDetailDisplayModelUseCase(@NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull FWFKey fWFKey, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(fWFKey, "flag");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        return new GetBinsDetailDisplayModelUseCase(BenefitManagerDomainModule.INSTANCE.provideGetBenefitBinDetailUseCase(configurationLocalRepository, iTalabatFeatureFlag), QPayDomainModule.INSTANCE.provideGetQPayDeflectionSavedCardUseCase(fWFKey, iTalabatFeatureFlag), configurationLocalRepository);
    }
}
