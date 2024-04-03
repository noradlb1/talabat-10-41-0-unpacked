package com.talabat.wallet.bnplmanager.data.remote;

import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentRequestModel;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentsRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLPlansRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLOrderPaymentRequestDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.response.BNPLOrderPaymentRemoteDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/BNPLManagerRemoteDataSource;", "", "getBNPLEligibilityStatus", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteDto;", "bNPLEligibilityRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBNPLInstallments", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentsRemoteDto;", "bNPLInstallmentRequestModel", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRequestModel;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBNPLPlans", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPlansRemoteDto;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payOrderWithBNPL", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentRemoteDto;", "bNPLOrderPaymentRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BNPLManagerRemoteDataSource {
    @Nullable
    Object getBNPLEligibilityStatus(@NotNull BNPLEligibilityRequestDto bNPLEligibilityRequestDto, @NotNull Continuation<? super BNPLEligibilityRemoteDto> continuation);

    @Nullable
    Object getBNPLInstallments(@NotNull BNPLInstallmentRequestModel bNPLInstallmentRequestModel, @NotNull Continuation<? super BNPLInstallmentsRemoteDto> continuation);

    @Nullable
    Object getBNPLPlans(int i11, @NotNull Continuation<? super BNPLPlansRemoteDto> continuation);

    @Nullable
    Object payOrderWithBNPL(@NotNull BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto, @NotNull Continuation<? super BNPLOrderPaymentRemoteDto> continuation);
}
