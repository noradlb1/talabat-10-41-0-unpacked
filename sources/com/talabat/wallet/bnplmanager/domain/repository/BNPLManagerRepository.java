package com.talabat.wallet.bnplmanager.domain.repository;

import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentRequestModel;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentsRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLPlansRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLOrderPaymentRequestDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.response.BNPLOrderPaymentRemoteDto;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H&J\u0011\u0010\u0015\u001a\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;", "", "getBNPLEligibilityStatus", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteDto;", "bNPLEligibilityRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBNPLEligibilityStatusFromLocal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBNPLInstallments", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentsRemoteDto;", "bNPLInstallmentRequestModel", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRequestModel;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBNPLPlans", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPlansRemoteDto;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBnplTrackingStatus", "", "getIsUserSeenBnplPaymentFallbackOption", "payOrderWithBNPL", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentRemoteDto;", "bNPLOrderPaymentRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setIsUserSeenBnplPaymentFallbackOption", "", "seen", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BNPLManagerRepository {
    @Nullable
    Object getBNPLEligibilityStatus(@NotNull BNPLEligibilityRequestDto bNPLEligibilityRequestDto, @NotNull Continuation<? super BNPLEligibilityRemoteDto> continuation);

    @Nullable
    Object getBNPLEligibilityStatusFromLocal(@NotNull Continuation<? super BNPLEligibilityRemoteDto> continuation);

    @Nullable
    Object getBNPLInstallments(@NotNull BNPLInstallmentRequestModel bNPLInstallmentRequestModel, @NotNull Continuation<? super BNPLInstallmentsRemoteDto> continuation);

    @Nullable
    Object getBNPLPlans(int i11, @NotNull Continuation<? super BNPLPlansRemoteDto> continuation);

    boolean getBnplTrackingStatus();

    @Nullable
    Object getIsUserSeenBnplPaymentFallbackOption(@NotNull Continuation<? super Boolean> continuation);

    @Nullable
    Object payOrderWithBNPL(@NotNull BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto, @NotNull Continuation<? super BNPLOrderPaymentRemoteDto> continuation);

    @Nullable
    Object setIsUserSeenBnplPaymentFallbackOption(boolean z11, @NotNull Continuation<? super Unit> continuation);
}
