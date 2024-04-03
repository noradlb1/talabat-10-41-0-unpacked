package com.talabat.wallet.bnplmanager.data.local;

import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/local/BNPLManagerLocalDataSource;", "", "getBNPLEligibilityStatus", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIsUserSeenBnplPaymentFallbackOption", "", "setBNPLEligibilityStatus", "", "eligibilityRemoteDto", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setIsUserSeenBnplPaymentFallbackOption", "seenOptions", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BNPLManagerLocalDataSource {
    @Nullable
    Object getBNPLEligibilityStatus(@NotNull Continuation<? super BNPLEligibilityRemoteDto> continuation);

    @Nullable
    Object getIsUserSeenBnplPaymentFallbackOption(@NotNull Continuation<? super Boolean> continuation);

    @Nullable
    Object setBNPLEligibilityStatus(@NotNull BNPLEligibilityRemoteDto bNPLEligibilityRemoteDto, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object setIsUserSeenBnplPaymentFallbackOption(boolean z11, @NotNull Continuation<? super Unit> continuation);
}
