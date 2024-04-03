package com.talabat.userandlocation.compliance.status.di.factory;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import buisnessmodels.Customer;
import com.talabat.application.device.id.data.impl.DeviceIdProviderImpl;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.userandlocation.compliance.status.di.module.UserStatusDomainModule;
import com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository;
import com.talabat.userandlocation.compliance.status.domain.usecase.business.CheckUserIsAllowedToOrderUseCase;
import com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl;
import com.talabat.userandlocation.compliance.status.presentation.viewmodel.CheckUserAllowedToOrderViewModel;
import com.talabat.userandlocation.compliance.verification.di.module.ComplianceVerificationDataModule;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackContinueToCheckoutUseCase;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackUserBlockedUseCase;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl.TrackContinueToCheckoutUseCaseImpl;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl.TrackUserBlockedUseCaseImpl;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/di/factory/CheckUserAllowedToOrderViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "isAllowedToOrderUseCase", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase;", "trackContinueToCheckoutUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackContinueToCheckoutUseCase;", "trackUserBlockedUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackUserBlockedUseCase;", "(Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase;Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackContinueToCheckoutUseCase;Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackUserBlockedUseCase;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckUserAllowedToOrderViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final CheckUserIsAllowedToOrderUseCase isAllowedToOrderUseCase;
    @NotNull
    private final TrackContinueToCheckoutUseCase trackContinueToCheckoutUseCase;
    @NotNull
    private final TrackUserBlockedUseCase trackUserBlockedUseCase;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/di/factory/CheckUserAllowedToOrderViewModelFactory$Companion;", "", "()V", "create", "Lcom/talabat/userandlocation/compliance/status/presentation/viewmodel/CheckUserAllowedToOrderViewModel;", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "provideCheckUserIsAllowedToOrderUseCase", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final CheckUserIsAllowedToOrderUseCase provideCheckUserIsAllowedToOrderUseCase(AppCompatActivity appCompatActivity) {
            UserStatusRepository provideUserStatusRepository = UserStatusDomainModule.INSTANCE.provideUserStatusRepository();
            CustomerRepositoryImpl customerRepositoryImpl = new CustomerRepositoryImpl(appCompatActivity, (Customer) null, (Function1) null, 6, (DefaultConstructorMarker) null);
            Application application = appCompatActivity.getApplication();
            if (application != null) {
                return new CheckUserIsAllowedToOrderUseCaseImpl(provideUserStatusRepository, customerRepositoryImpl, ((ConfigurationLocalCoreLibApi) ((ApiContainer) application).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository(), (Function0) null, new DeviceIdProviderImpl(appCompatActivity), (CoroutineDispatcher) null, 40, (DefaultConstructorMarker) null);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
        }

        @NotNull
        public final CheckUserAllowedToOrderViewModel create(@NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkNotNullParameter(appCompatActivity, "appCompatActivity");
            CheckUserIsAllowedToOrderUseCase provideCheckUserIsAllowedToOrderUseCase = provideCheckUserIsAllowedToOrderUseCase(appCompatActivity);
            ComplianceVerificationDataModule complianceVerificationDataModule = ComplianceVerificationDataModule.INSTANCE;
            return (CheckUserAllowedToOrderViewModel) new ViewModelProvider((ViewModelStoreOwner) appCompatActivity, (ViewModelProvider.Factory) new CheckUserAllowedToOrderViewModelFactory(provideCheckUserIsAllowedToOrderUseCase, new TrackContinueToCheckoutUseCaseImpl(complianceVerificationDataModule.provideComplianceVerificationTracker(appCompatActivity)), new TrackUserBlockedUseCaseImpl(complianceVerificationDataModule.provideComplianceVerificationTracker(appCompatActivity)), (DefaultConstructorMarker) null)).get(CheckUserAllowedToOrderViewModel.class);
        }
    }

    private CheckUserAllowedToOrderViewModelFactory(CheckUserIsAllowedToOrderUseCase checkUserIsAllowedToOrderUseCase, TrackContinueToCheckoutUseCase trackContinueToCheckoutUseCase2, TrackUserBlockedUseCase trackUserBlockedUseCase2) {
        this.isAllowedToOrderUseCase = checkUserIsAllowedToOrderUseCase;
        this.trackContinueToCheckoutUseCase = trackContinueToCheckoutUseCase2;
        this.trackUserBlockedUseCase = trackUserBlockedUseCase2;
    }

    public /* synthetic */ CheckUserAllowedToOrderViewModelFactory(CheckUserIsAllowedToOrderUseCase checkUserIsAllowedToOrderUseCase, TrackContinueToCheckoutUseCase trackContinueToCheckoutUseCase2, TrackUserBlockedUseCase trackUserBlockedUseCase2, DefaultConstructorMarker defaultConstructorMarker) {
        this(checkUserIsAllowedToOrderUseCase, trackContinueToCheckoutUseCase2, trackUserBlockedUseCase2);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new CheckUserAllowedToOrderViewModel(this.isAllowedToOrderUseCase, this.trackContinueToCheckoutUseCase, this.trackUserBlockedUseCase);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
