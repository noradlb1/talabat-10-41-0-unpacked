package com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl;

import com.talabat.userandlocation.compliance.verification.domain.tracker.ComplianceVerificationTracker;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackContinueToCheckoutUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/impl/TrackContinueToCheckoutUseCaseImpl;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackContinueToCheckoutUseCase;", "verificationTracker", "Lcom/talabat/userandlocation/compliance/verification/domain/tracker/ComplianceVerificationTracker;", "(Lcom/talabat/userandlocation/compliance/verification/domain/tracker/ComplianceVerificationTracker;)V", "trackContinueToCheckout", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackContinueToCheckoutUseCaseImpl implements TrackContinueToCheckoutUseCase {
    @NotNull
    private final ComplianceVerificationTracker verificationTracker;

    public TrackContinueToCheckoutUseCaseImpl(@NotNull ComplianceVerificationTracker complianceVerificationTracker) {
        Intrinsics.checkNotNullParameter(complianceVerificationTracker, "verificationTracker");
        this.verificationTracker = complianceVerificationTracker;
    }

    @Nullable
    public Object trackContinueToCheckout(@NotNull Continuation<? super Unit> continuation) {
        this.verificationTracker.trackContinueToCheckout();
        return Unit.INSTANCE;
    }
}
