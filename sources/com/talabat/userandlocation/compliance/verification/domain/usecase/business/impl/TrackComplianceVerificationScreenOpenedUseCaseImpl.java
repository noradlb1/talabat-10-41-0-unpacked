package com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl;

import com.talabat.userandlocation.compliance.verification.domain.tracker.ComplianceVerificationTracker;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackComplianceVerificationScreenOpenedUseCase;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/impl/TrackComplianceVerificationScreenOpenedUseCaseImpl;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase;", "complianceVerificationTracker", "Lcom/talabat/userandlocation/compliance/verification/domain/tracker/ComplianceVerificationTracker;", "(Lcom/talabat/userandlocation/compliance/verification/domain/tracker/ComplianceVerificationTracker;)V", "trackComplianceVerificationScreenOpened", "", "type", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase$Type;", "(Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase$Type;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackComplianceVerificationScreenOpenedUseCaseImpl implements TrackComplianceVerificationScreenOpenedUseCase {
    @NotNull
    private final ComplianceVerificationTracker complianceVerificationTracker;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TrackComplianceVerificationScreenOpenedUseCase.Type.values().length];
            iArr[TrackComplianceVerificationScreenOpenedUseCase.Type.NEW_ACCOUNT.ordinal()] = 1;
            iArr[TrackComplianceVerificationScreenOpenedUseCase.Type.EXISTING_ACCOUNT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TrackComplianceVerificationScreenOpenedUseCaseImpl(@NotNull ComplianceVerificationTracker complianceVerificationTracker2) {
        Intrinsics.checkNotNullParameter(complianceVerificationTracker2, "complianceVerificationTracker");
        this.complianceVerificationTracker = complianceVerificationTracker2;
    }

    @Nullable
    public Object trackComplianceVerificationScreenOpened(@NotNull TrackComplianceVerificationScreenOpenedUseCase.Type type, @NotNull Continuation<? super Unit> continuation) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i11 == 1) {
            this.complianceVerificationTracker.trackNewAccountVerificationScreenOpened();
            return Unit.INSTANCE;
        } else if (i11 == 2) {
            this.complianceVerificationTracker.trackExistingAccountVerificationScreenOpened();
            return Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
