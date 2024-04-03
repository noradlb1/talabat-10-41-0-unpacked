package com.talabat.wallet.features.walletTransactionList.network;

import com.talabat.wallet.features.walletTransactionList.model.response.WalletTransactionListResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H'¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionList/network/WalletTransactionListApi;", "", "getWalletTransactionList", "Lretrofit2/Call;", "Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResponse;", "countryId", "", "version", "take", "skip", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletTransactionListApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getWalletTransactionList$default(WalletTransactionListApi walletTransactionListApi, int i11, int i12, int i13, int i14, int i15, Object obj) {
            if (obj == null) {
                if ((i15 & 2) != 0) {
                    i12 = 2;
                }
                return walletTransactionListApi.getWalletTransactionList(i11, i12, i13, i14);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWalletTransactionList");
        }
    }

    @NotNull
    @GET("/api/v{version}/wallet/transactionList/{countryId}/{skip}/{take}")
    Call<WalletTransactionListResponse> getWalletTransactionList(@Path("countryId") int i11, @Path("version") int i12, @Path("take") int i13, @Path("skip") int i14);
}
