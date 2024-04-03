package com.talabat.talabatcommon.feature.walletCardManagement;

import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletAddCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletAddCardResponse;
import com.talabat.talabatcommon.feature.walletCardManagement.repository.WalletCardManagementRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/GetAddCardToWalletUseCase;", "", "walletCardManagementRepository", "Lcom/talabat/talabatcommon/feature/walletCardManagement/repository/WalletCardManagementRepository;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/repository/WalletCardManagementRepository;)V", "invoke", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletAddCardResponse;", "walletAddCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletAddCardRequestModel;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletAddCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetAddCardToWalletUseCase {
    @NotNull
    private final WalletCardManagementRepository walletCardManagementRepository;

    public GetAddCardToWalletUseCase(@NotNull WalletCardManagementRepository walletCardManagementRepository2) {
        Intrinsics.checkNotNullParameter(walletCardManagementRepository2, "walletCardManagementRepository");
        this.walletCardManagementRepository = walletCardManagementRepository2;
    }

    @Nullable
    public final Object invoke(@NotNull WalletAddCardRequestModel walletAddCardRequestModel, @NotNull Continuation<? super WalletAddCardResponse> continuation) {
        return this.walletCardManagementRepository.addCardToWallet(walletAddCardRequestModel, continuation);
    }
}
