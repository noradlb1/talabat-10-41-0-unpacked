package com.talabat.userandlocation.compliance.verification.di.factory;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.userandlocation.compliance.verification.di.module.ComplianceVerificationDataModule;
import com.talabat.userandlocation.compliance.verification.di.module.ComplianceVerificationDomainModule;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackComplianceVerificationScreenOpenedUseCase;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.UpdateUserProfileUseCase;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.VerifyUserDetailsForComplianceUseCase;
import com.talabat.userandlocation.compliance.verification.presentation.StringProvider;
import com.talabat.userandlocation.compliance.verification.presentation.viewmodel.UserVerificationViewModel;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/di/factory/UserVerificationViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "verifyUserDetailsForComplianceUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase;", "trackComplianceVerificationScreenOpenedUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase;", "updateUserProfileUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase;", "stringProvider", "Lcom/talabat/userandlocation/compliance/verification/presentation/StringProvider;", "(Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase;Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase;Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase;Lcom/talabat/userandlocation/compliance/verification/presentation/StringProvider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserVerificationViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final StringProvider stringProvider;
    @NotNull
    private final TrackComplianceVerificationScreenOpenedUseCase trackComplianceVerificationScreenOpenedUseCase;
    @NotNull
    private final UpdateUserProfileUseCase updateUserProfileUseCase;
    @NotNull
    private final VerifyUserDetailsForComplianceUseCase verifyUserDetailsForComplianceUseCase;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/di/factory/UserVerificationViewModelFactory$Companion;", "", "()V", "newInstance", "Lcom/talabat/userandlocation/compliance/verification/di/factory/UserVerificationViewModelFactory;", "activity", "Landroid/app/Activity;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserVerificationViewModelFactory newInstance(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ComplianceVerificationDomainModule complianceVerificationDomainModule = ComplianceVerificationDomainModule.INSTANCE;
            VerifyUserDetailsForComplianceUseCase provideVerifyUserDetailsForComplianceUseCase = complianceVerificationDomainModule.provideVerifyUserDetailsForComplianceUseCase();
            ComplianceVerificationDataModule complianceVerificationDataModule = ComplianceVerificationDataModule.INSTANCE;
            TrackComplianceVerificationScreenOpenedUseCase provideTrackComplianceVerificationScreenOpenedUseCase = complianceVerificationDomainModule.provideTrackComplianceVerificationScreenOpenedUseCase(complianceVerificationDataModule.provideComplianceVerificationTracker(activity));
            Application application = activity.getApplication();
            if (application != null) {
                ConfigurationLocalRepository repository = ((ConfigurationLocalCoreLibApi) ((ApiContainer) application).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
                Application application2 = activity.getApplication();
                if (application2 != null) {
                    UpdateUserProfileUseCase provideUpdateUserProfileUseCase = complianceVerificationDomainModule.provideUpdateUserProfileUseCase(complianceVerificationDomainModule.provideCustomerInfoUpdateDelegate(activity, repository, ((ConfigurationRemoteCoreLibApi) ((ApiContainer) application2).getFeature(ConfigurationRemoteCoreLibApi.class)).getAppVersionProvider()));
                    Resources resources = activity.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
                    return new UserVerificationViewModelFactory(provideVerifyUserDetailsForComplianceUseCase, provideTrackComplianceVerificationScreenOpenedUseCase, provideUpdateUserProfileUseCase, complianceVerificationDataModule.provideStringProvider(resources), (DefaultConstructorMarker) null);
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
        }
    }

    private UserVerificationViewModelFactory(VerifyUserDetailsForComplianceUseCase verifyUserDetailsForComplianceUseCase2, TrackComplianceVerificationScreenOpenedUseCase trackComplianceVerificationScreenOpenedUseCase2, UpdateUserProfileUseCase updateUserProfileUseCase2, StringProvider stringProvider2) {
        this.verifyUserDetailsForComplianceUseCase = verifyUserDetailsForComplianceUseCase2;
        this.trackComplianceVerificationScreenOpenedUseCase = trackComplianceVerificationScreenOpenedUseCase2;
        this.updateUserProfileUseCase = updateUserProfileUseCase2;
        this.stringProvider = stringProvider2;
    }

    public /* synthetic */ UserVerificationViewModelFactory(VerifyUserDetailsForComplianceUseCase verifyUserDetailsForComplianceUseCase2, TrackComplianceVerificationScreenOpenedUseCase trackComplianceVerificationScreenOpenedUseCase2, UpdateUserProfileUseCase updateUserProfileUseCase2, StringProvider stringProvider2, DefaultConstructorMarker defaultConstructorMarker) {
        this(verifyUserDetailsForComplianceUseCase2, trackComplianceVerificationScreenOpenedUseCase2, updateUserProfileUseCase2, stringProvider2);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new UserVerificationViewModel(this.verifyUserDetailsForComplianceUseCase, this.trackComplianceVerificationScreenOpenedUseCase, this.updateUserProfileUseCase, this.stringProvider);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
