package com.talabat.userandlocation.compliance.verification.domain.usecase.business;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackContinueToCheckoutUseCase;", "", "trackContinueToCheckout", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackContinueToCheckoutUseCase {
    @Nullable
    Object trackContinueToCheckout(@NotNull Continuation<? super Unit> continuation);
}
