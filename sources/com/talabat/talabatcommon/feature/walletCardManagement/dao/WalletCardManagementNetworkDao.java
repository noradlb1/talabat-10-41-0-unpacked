package com.talabat.talabatcommon.feature.walletCardManagement.dao;

import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletAddCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletDeleteCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletSetDefaultCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletAddCardResponse;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletSetDefaultCardResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/dao/WalletCardManagementNetworkDao;", "", "addCardToWallet", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletAddCardResponse;", "walletAddCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletAddCardRequestModel;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletAddCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCard", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResult;", "walletDeleteCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultCard", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletSetDefaultCardResult;", "walletSetDefaultCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletSetDefaultCardRequestModel;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletSetDefaultCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletCardManagementNetworkDao {
    @Nullable
    Object addCardToWallet(@NotNull WalletAddCardRequestModel walletAddCardRequestModel, @NotNull Continuation<? super WalletAddCardResponse> continuation);

    @Nullable
    Object deleteCard(@NotNull WalletDeleteCardRequestModel walletDeleteCardRequestModel, @NotNull Continuation<? super WalletDeleteCardResult> continuation);

    @Nullable
    Object setDefaultCard(@NotNull WalletSetDefaultCardRequestModel walletSetDefaultCardRequestModel, @NotNull Continuation<? super WalletSetDefaultCardResult> continuation);
}
