package com.talabat.userandlocation.compliance.verification.domain.usecase.business;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase;", "", "trackComplianceVerificationScreenOpened", "", "type", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase$Type;", "(Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase$Type;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Type", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackComplianceVerificationScreenOpenedUseCase {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase$Type;", "", "(Ljava/lang/String;I)V", "NEW_ACCOUNT", "EXISTING_ACCOUNT", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Type {
        NEW_ACCOUNT,
        EXISTING_ACCOUNT
    }

    @Nullable
    Object trackComplianceVerificationScreenOpened(@NotNull Type type, @NotNull Continuation<? super Unit> continuation);
}
