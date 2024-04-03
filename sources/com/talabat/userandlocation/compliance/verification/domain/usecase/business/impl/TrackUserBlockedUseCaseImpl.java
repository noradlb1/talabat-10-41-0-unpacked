package com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl;

import com.talabat.userandlocation.compliance.verification.domain.tracker.ComplianceVerificationTracker;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackUserBlockedUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/impl/TrackUserBlockedUseCaseImpl;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackUserBlockedUseCase;", "complianceVerificationTracker", "Lcom/talabat/userandlocation/compliance/verification/domain/tracker/ComplianceVerificationTracker;", "(Lcom/talabat/userandlocation/compliance/verification/domain/tracker/ComplianceVerificationTracker;)V", "trackUserBlocked", "", "message", "", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackUserBlockedUseCaseImpl implements TrackUserBlockedUseCase {
    @NotNull
    private final ComplianceVerificationTracker complianceVerificationTracker;

    public TrackUserBlockedUseCaseImpl(@NotNull ComplianceVerificationTracker complianceVerificationTracker2) {
        Intrinsics.checkNotNullParameter(complianceVerificationTracker2, "complianceVerificationTracker");
        this.complianceVerificationTracker = complianceVerificationTracker2;
    }

    public void trackUserBlocked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.complianceVerificationTracker.trackUserBlocked(str);
    }
}
