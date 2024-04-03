package com.talabat.wallet.features.refund.network;

import com.talabat.wallet.features.refund.model.WalletRefundCanRevertToBankResponse;
import com.talabat.wallet.features.refund.model.WalletRefundRevertToBankResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ/\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/features/refund/network/WalletRefundToBankApi;", "", "getCanRefundToBankStatus", "Lcom/talabat/wallet/features/refund/model/WalletRefundCanRevertToBankResponse;", "version", "", "orderId", "", "countryId", "(ILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refundToBank", "Lcom/talabat/wallet/features/refund/model/WalletRefundRevertToBankResponse;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletRefundToBankApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getCanRefundToBankStatus$default(WalletRefundToBankApi walletRefundToBankApi, int i11, String str, int i12, Continuation continuation, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 1;
                }
                return walletRefundToBankApi.getCanRefundToBankStatus(i11, str, i12, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCanRefundToBankStatus");
        }

        public static /* synthetic */ Object refundToBank$default(WalletRefundToBankApi walletRefundToBankApi, int i11, String str, int i12, Continuation continuation, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 1;
                }
                return walletRefundToBankApi.refundToBank(i11, str, i12, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refundToBank");
        }
    }

    @Nullable
    @GET("/api/v{version}/wallet/refunds/orders/{orderId}/Country/{countryId}/can-revert-to-bank")
    Object getCanRefundToBankStatus(@Path("version") int i11, @NotNull @Path("orderId") String str, @Path("countryId") int i12, @NotNull Continuation<? super WalletRefundCanRevertToBankResponse> continuation);

    @POST("/api/v{version}/wallet/refunds/orders/{orderId}/Country/{countryId}/revert-to-bank")
    @Nullable
    Object refundToBank(@Path("version") int i11, @NotNull @Path("orderId") String str, @Path("countryId") int i12, @NotNull Continuation<? super WalletRefundRevertToBankResponse> continuation);
}
