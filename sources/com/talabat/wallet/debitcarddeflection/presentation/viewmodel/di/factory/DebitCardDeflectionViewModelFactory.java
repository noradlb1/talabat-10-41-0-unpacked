package com.talabat.wallet.debitcarddeflection.presentation.viewmodel.di.factory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.debitcarddeflection.domain.business.GetBinVerificationDisplayModelUseCase;
import com.talabat.wallet.debitcarddeflection.domain.business.GetBinsDetailDisplayModelUseCase;
import com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel;
import com.talabat.wallet.debitcarddeflection.presentation.viewmodel.di.module.DebitCardDeflectionPresentationModule;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/debitcarddeflection/presentation/viewmodel/di/factory/DebitCardDeflectionViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getBinVerificationDisplayModelUseCase", "Lcom/talabat/wallet/debitcarddeflection/domain/business/GetBinVerificationDisplayModelUseCase;", "getBinsDetailDisplayModelUseCase", "Lcom/talabat/wallet/debitcarddeflection/domain/business/GetBinsDetailDisplayModelUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/wallet/debitcarddeflection/domain/business/GetBinVerificationDisplayModelUseCase;Lcom/talabat/wallet/debitcarddeflection/domain/business/GetBinsDetailDisplayModelUseCase;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebitCardDeflectionViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static BenefitManagerViewModel mockedBenefitManagerViewModel;
    @NotNull
    private final GetBinVerificationDisplayModelUseCase getBinVerificationDisplayModelUseCase;
    @NotNull
    private final GetBinsDetailDisplayModelUseCase getBinsDetailDisplayModelUseCase;
    @NotNull
    private final IObservabilityManager observabilityManager;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/talabat/wallet/debitcarddeflection/presentation/viewmodel/di/factory/DebitCardDeflectionViewModelFactory$Companion;", "", "()V", "mockedBenefitManagerViewModel", "Lcom/talabat/wallet/debitcarddeflection/presentation/viewmodel/BenefitManagerViewModel;", "getMockedBenefitManagerViewModel", "()Lcom/talabat/wallet/debitcarddeflection/presentation/viewmodel/BenefitManagerViewModel;", "setMockedBenefitManagerViewModel", "(Lcom/talabat/wallet/debitcarddeflection/presentation/viewmodel/BenefitManagerViewModel;)V", "create", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "flag", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BenefitManagerViewModel create(@NotNull AppCompatActivity appCompatActivity, @NotNull FWFKey fWFKey, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IObservabilityManager iObservabilityManager) {
            Intrinsics.checkNotNullParameter(appCompatActivity, "appCompatActivity");
            Intrinsics.checkNotNullParameter(fWFKey, "flag");
            Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
            Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
            BenefitManagerViewModel mockedBenefitManagerViewModel = getMockedBenefitManagerViewModel();
            if (mockedBenefitManagerViewModel != null) {
                return mockedBenefitManagerViewModel;
            }
            DebitCardDeflectionPresentationModule debitCardDeflectionPresentationModule = DebitCardDeflectionPresentationModule.INSTANCE;
            return (BenefitManagerViewModel) new ViewModelProvider((ViewModelStoreOwner) appCompatActivity, (ViewModelProvider.Factory) new DebitCardDeflectionViewModelFactory(debitCardDeflectionPresentationModule.provideGetBinVerificationDisplayModelUseCase(configurationLocalRepository, fWFKey, iTalabatFeatureFlag), debitCardDeflectionPresentationModule.provideGetBinsDetailDisplayModelUseCase(configurationLocalRepository, fWFKey, iTalabatFeatureFlag), iObservabilityManager, (DefaultConstructorMarker) null)).get(BenefitManagerViewModel.class);
        }

        @Nullable
        public final BenefitManagerViewModel getMockedBenefitManagerViewModel() {
            return DebitCardDeflectionViewModelFactory.mockedBenefitManagerViewModel;
        }

        public final void setMockedBenefitManagerViewModel(@Nullable BenefitManagerViewModel benefitManagerViewModel) {
            DebitCardDeflectionViewModelFactory.mockedBenefitManagerViewModel = benefitManagerViewModel;
        }
    }

    private DebitCardDeflectionViewModelFactory(GetBinVerificationDisplayModelUseCase getBinVerificationDisplayModelUseCase2, GetBinsDetailDisplayModelUseCase getBinsDetailDisplayModelUseCase2, IObservabilityManager iObservabilityManager) {
        this.getBinVerificationDisplayModelUseCase = getBinVerificationDisplayModelUseCase2;
        this.getBinsDetailDisplayModelUseCase = getBinsDetailDisplayModelUseCase2;
        this.observabilityManager = iObservabilityManager;
    }

    public /* synthetic */ DebitCardDeflectionViewModelFactory(GetBinVerificationDisplayModelUseCase getBinVerificationDisplayModelUseCase2, GetBinsDetailDisplayModelUseCase getBinsDetailDisplayModelUseCase2, IObservabilityManager iObservabilityManager, DefaultConstructorMarker defaultConstructorMarker) {
        this(getBinVerificationDisplayModelUseCase2, getBinsDetailDisplayModelUseCase2, iObservabilityManager);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new BenefitManagerViewModel(this.getBinVerificationDisplayModelUseCase, this.getBinsDetailDisplayModelUseCase, this.observabilityManager);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
