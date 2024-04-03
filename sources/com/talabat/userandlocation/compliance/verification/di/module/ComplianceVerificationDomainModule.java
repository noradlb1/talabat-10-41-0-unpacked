package com.talabat.userandlocation.compliance.verification.di.module;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.userandlocation.compliance.verification.domain.tracker.ComplianceVerificationTracker;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackComplianceVerificationScreenOpenedUseCase;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.UpdateUserProfileUseCase;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.VerifyUserDetailsForComplianceUseCase;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl.TrackComplianceVerificationScreenOpenedUseCaseImpl;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl.UpdateUserProfileUseCaseImpl;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl.VerifyUserDetailsForComplianceUseCaseImpl;
import com.talabat.userandlocation.customerinfo.CustomerInfoUpdateDelegate;
import com.talabat.userandlocation.customerinfo.CustomerInfoUpdateDelegateImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/di/module/ComplianceVerificationDomainModule;", "", "()V", "provideCustomerInfoUpdateDelegate", "Lcom/talabat/userandlocation/customerinfo/CustomerInfoUpdateDelegate;", "context", "Landroid/content/Context;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "provideTrackComplianceVerificationScreenOpenedUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase;", "complianceVerificationTracker", "Lcom/talabat/userandlocation/compliance/verification/domain/tracker/ComplianceVerificationTracker;", "provideUpdateUserProfileUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase;", "customerInfoUpdateDelegate", "provideVerifyUserDetailsForComplianceUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ComplianceVerificationDomainModule {
    @NotNull
    public static final ComplianceVerificationDomainModule INSTANCE = new ComplianceVerificationDomainModule();

    private ComplianceVerificationDomainModule() {
    }

    @NotNull
    public final CustomerInfoUpdateDelegate provideCustomerInfoUpdateDelegate(@NotNull Context context, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull AppVersionProvider appVersionProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        return new CustomerInfoUpdateDelegateImpl(context, configurationLocalRepository, ComplianceVerificationDomainModule$provideCustomerInfoUpdateDelegate$1.INSTANCE, appVersionProvider);
    }

    @NotNull
    public final TrackComplianceVerificationScreenOpenedUseCase provideTrackComplianceVerificationScreenOpenedUseCase(@NotNull ComplianceVerificationTracker complianceVerificationTracker) {
        Intrinsics.checkNotNullParameter(complianceVerificationTracker, "complianceVerificationTracker");
        return new TrackComplianceVerificationScreenOpenedUseCaseImpl(complianceVerificationTracker);
    }

    @NotNull
    public final UpdateUserProfileUseCase provideUpdateUserProfileUseCase(@NotNull CustomerInfoUpdateDelegate customerInfoUpdateDelegate) {
        Intrinsics.checkNotNullParameter(customerInfoUpdateDelegate, "customerInfoUpdateDelegate");
        return new UpdateUserProfileUseCaseImpl((CoroutineDispatcher) null, customerInfoUpdateDelegate, 1, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final VerifyUserDetailsForComplianceUseCase provideVerifyUserDetailsForComplianceUseCase() {
        return new VerifyUserDetailsForComplianceUseCaseImpl((CoroutineDispatcher) null, 1, (DefaultConstructorMarker) null);
    }
}
