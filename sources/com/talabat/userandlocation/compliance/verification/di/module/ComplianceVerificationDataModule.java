package com.talabat.userandlocation.compliance.verification.di.module;

import android.content.Context;
import android.content.res.Resources;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.userandlocation.compliance.verification.data.impl.ComplianceVerificationTrackerImpl;
import com.talabat.userandlocation.compliance.verification.domain.tracker.ComplianceVerificationTracker;
import com.talabat.userandlocation.compliance.verification.presentation.StringProvider;
import com.talabat.userandlocation.compliance.verification.presentation.impl.StringProviderImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/di/module/ComplianceVerificationDataModule;", "", "()V", "provideComplianceVerificationTracker", "Lcom/talabat/userandlocation/compliance/verification/domain/tracker/ComplianceVerificationTracker;", "context", "Landroid/content/Context;", "provideStringProvider", "Lcom/talabat/userandlocation/compliance/verification/presentation/StringProvider;", "resources", "Landroid/content/res/Resources;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ComplianceVerificationDataModule {
    @NotNull
    public static final ComplianceVerificationDataModule INSTANCE = new ComplianceVerificationDataModule();

    private ComplianceVerificationDataModule() {
    }

    @NotNull
    public final ComplianceVerificationTracker provideComplianceVerificationTracker(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ComplianceVerificationTrackerImpl(context, ComplianceVerificationDataModuleKt.getTalabatTracker(context), ComplianceVerificationDataModuleKt.isNewTrackingLibraryEnabled(context), ((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository(), ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository(), (Function0) null, (Function0) null, 96, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final StringProvider provideStringProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new StringProviderImpl(resources);
    }
}
