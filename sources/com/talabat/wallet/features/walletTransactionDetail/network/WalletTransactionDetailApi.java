package com.talabat.wallet.features.walletTransactionDetail.network;

import com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionDetail/network/WalletTransactionDetailApi;", "", "getWalletTransactionDetail", "Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailResponse;", "version", "", "transactionType", "transactionId", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletTransactionDetailApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getWalletTransactionDetail$default(WalletTransactionDetailApi walletTransactionDetailApi, int i11, int i12, int i13, Continuation continuation, int i14, Object obj) {
            if (obj == null) {
                if ((i14 & 1) != 0) {
                    i11 = 3;
                }
                return walletTransactionDetailApi.getWalletTransactionDetail(i11, i12, i13, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWalletTransactionDetail");
        }
    }

    @Nullable
    @GET("/api/v{version}/wallet/transactionDetails/{transactionType}/{transactionId}")
    Object getWalletTransactionDetail(@Path("version") int i11, @Path("transactionType") int i12, @Path("transactionId") int i13, @NotNull Continuation<? super WalletTransactionDetailResponse> continuation);
}
