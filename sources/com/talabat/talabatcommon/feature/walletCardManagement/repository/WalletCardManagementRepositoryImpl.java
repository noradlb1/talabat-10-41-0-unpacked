package com.talabat.talabatcommon.feature.walletCardManagement.repository;

import com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDao;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletAddCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletDeleteCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletSetDefaultCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletAddCardResponse;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletSetDefaultCardResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/repository/WalletCardManagementRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/walletCardManagement/repository/WalletCardManagementRepository;", "walletCardManagementNetworkDao", "Lcom/talabat/talabatcommon/feature/walletCardManagement/dao/WalletCardManagementNetworkDao;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/dao/WalletCardManagementNetworkDao;)V", "addCardToWallet", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletAddCardResponse;", "walletAddCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletAddCardRequestModel;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletAddCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCard", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResult;", "walletDeleteCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultCard", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletSetDefaultCardResult;", "walletSetDefaultCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletSetDefaultCardRequestModel;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletSetDefaultCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardManagementRepositoryImpl implements WalletCardManagementRepository {
    @NotNull
    private final WalletCardManagementNetworkDao walletCardManagementNetworkDao;

    public WalletCardManagementRepositoryImpl(@NotNull WalletCardManagementNetworkDao walletCardManagementNetworkDao2) {
        Intrinsics.checkNotNullParameter(walletCardManagementNetworkDao2, "walletCardManagementNetworkDao");
        this.walletCardManagementNetworkDao = walletCardManagementNetworkDao2;
    }

    @Nullable
    public Object addCardToWallet(@NotNull WalletAddCardRequestModel walletAddCardRequestModel, @NotNull Continuation<? super WalletAddCardResponse> continuation) {
        return this.walletCardManagementNetworkDao.addCardToWallet(walletAddCardRequestModel, continuation);
    }

    @Nullable
    public Object deleteCard(@NotNull WalletDeleteCardRequestModel walletDeleteCardRequestModel, @NotNull Continuation<? super WalletDeleteCardResult> continuation) {
        return this.walletCardManagementNetworkDao.deleteCard(walletDeleteCardRequestModel, continuation);
    }

    @Nullable
    public Object setDefaultCard(@NotNull WalletSetDefaultCardRequestModel walletSetDefaultCardRequestModel, @NotNull Continuation<? super WalletSetDefaultCardResult> continuation) {
        return this.walletCardManagementNetworkDao.setDefaultCard(walletSetDefaultCardRequestModel, continuation);
    }
}
