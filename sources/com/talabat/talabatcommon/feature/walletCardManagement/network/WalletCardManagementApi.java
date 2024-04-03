package com.talabat.talabatcommon.feature.walletCardManagement.network;

import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletAddCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletDeleteCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletSetDefaultCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletAddCardResponse;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResponse;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletSetDefaultCardResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0010\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;", "", "addCardToWallet", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletAddCardResponse;", "version", "", "walletAddCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletAddCardRequestModel;", "(ILcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletAddCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCard", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResponse;", "walletDeleteCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;", "(ILcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultCard", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletSetDefaultCardResponse;", "walletSetDefaultCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletSetDefaultCardRequestModel;", "(ILcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletSetDefaultCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletCardManagementApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object addCardToWallet$default(WalletCardManagementApi walletCardManagementApi, int i11, WalletAddCardRequestModel walletAddCardRequestModel, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 1;
                }
                return walletCardManagementApi.addCardToWallet(i11, walletAddCardRequestModel, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCardToWallet");
        }

        public static /* synthetic */ Object deleteCard$default(WalletCardManagementApi walletCardManagementApi, int i11, WalletDeleteCardRequestModel walletDeleteCardRequestModel, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 2;
                }
                return walletCardManagementApi.deleteCard(i11, walletDeleteCardRequestModel, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteCard");
        }

        public static /* synthetic */ Object setDefaultCard$default(WalletCardManagementApi walletCardManagementApi, int i11, WalletSetDefaultCardRequestModel walletSetDefaultCardRequestModel, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 1;
                }
                return walletCardManagementApi.setDefaultCard(i11, walletSetDefaultCardRequestModel, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDefaultCard");
        }
    }

    @POST("checkoutapi/v{version}/card/add")
    @Nullable
    Object addCardToWallet(@Path("version") int i11, @NotNull @Body WalletAddCardRequestModel walletAddCardRequestModel, @NotNull Continuation<? super WalletAddCardResponse> continuation);

    @POST("v{version}/customer/delcard")
    @Nullable
    Object deleteCard(@Path("version") int i11, @NotNull @Body WalletDeleteCardRequestModel walletDeleteCardRequestModel, @NotNull Continuation<? super WalletDeleteCardResponse> continuation);

    @POST("v{version}/customer/setcard")
    @Nullable
    Object setDefaultCard(@Path("version") int i11, @NotNull @Body WalletSetDefaultCardRequestModel walletSetDefaultCardRequestModel, @NotNull Continuation<? super WalletSetDefaultCardResponse> continuation);
}
