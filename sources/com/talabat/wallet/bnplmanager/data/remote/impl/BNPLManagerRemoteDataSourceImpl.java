package com.talabat.wallet.bnplmanager.data.remote.impl;

import com.talabat.wallet.bnplmanager.data.remote.BNPLManagerRemoteDataSource;
import com.talabat.wallet.bnplmanager.data.remote.api.BNPLEligibilityApi;
import com.talabat.wallet.bnplmanager.data.remote.api.BNPLManagerApi;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentRequestModel;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentsRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLPlansRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLOrderPaymentRequestDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.response.BNPLOrderPaymentRemoteDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/impl/BNPLManagerRemoteDataSourceImpl;", "Lcom/talabat/wallet/bnplmanager/data/remote/BNPLManagerRemoteDataSource;", "bNPLManagerApi", "Lcom/talabat/wallet/bnplmanager/data/remote/api/BNPLManagerApi;", "bNPLEligibilityApi", "Lcom/talabat/wallet/bnplmanager/data/remote/api/BNPLEligibilityApi;", "(Lcom/talabat/wallet/bnplmanager/data/remote/api/BNPLManagerApi;Lcom/talabat/wallet/bnplmanager/data/remote/api/BNPLEligibilityApi;)V", "getBNPLEligibilityStatus", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteDto;", "bNPLEligibilityRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBNPLInstallments", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentsRemoteDto;", "bNPLInstallmentRequestModel", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRequestModel;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBNPLPlans", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPlansRemoteDto;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payOrderWithBNPL", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentRemoteDto;", "bNPLOrderPaymentRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLManagerRemoteDataSourceImpl implements BNPLManagerRemoteDataSource {
    @NotNull
    private final BNPLEligibilityApi bNPLEligibilityApi;
    @NotNull
    private final BNPLManagerApi bNPLManagerApi;

    public BNPLManagerRemoteDataSourceImpl(@NotNull BNPLManagerApi bNPLManagerApi2, @NotNull BNPLEligibilityApi bNPLEligibilityApi2) {
        Intrinsics.checkNotNullParameter(bNPLManagerApi2, "bNPLManagerApi");
        Intrinsics.checkNotNullParameter(bNPLEligibilityApi2, "bNPLEligibilityApi");
        this.bNPLManagerApi = bNPLManagerApi2;
        this.bNPLEligibilityApi = bNPLEligibilityApi2;
    }

    @Nullable
    public Object getBNPLEligibilityStatus(@NotNull BNPLEligibilityRequestDto bNPLEligibilityRequestDto, @NotNull Continuation<? super BNPLEligibilityRemoteDto> continuation) {
        return this.bNPLEligibilityApi.getBNPLEligibilityStatus(bNPLEligibilityRequestDto, continuation);
    }

    @Nullable
    public Object getBNPLInstallments(@NotNull BNPLInstallmentRequestModel bNPLInstallmentRequestModel, @NotNull Continuation<? super BNPLInstallmentsRemoteDto> continuation) {
        return this.bNPLManagerApi.getBNPLInstallments(bNPLInstallmentRequestModel, continuation);
    }

    @Nullable
    public Object getBNPLPlans(int i11, @NotNull Continuation<? super BNPLPlansRemoteDto> continuation) {
        return this.bNPLEligibilityApi.getBNPLPlans(i11, continuation);
    }

    @Nullable
    public Object payOrderWithBNPL(@NotNull BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto, @NotNull Continuation<? super BNPLOrderPaymentRemoteDto> continuation) {
        return this.bNPLManagerApi.payOrderWithBNPL(bNPLOrderPaymentRequestDto, continuation);
    }
}
