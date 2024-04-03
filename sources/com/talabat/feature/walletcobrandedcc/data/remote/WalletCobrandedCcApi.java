package com.talabat.feature.walletcobrandedcc.data.remote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcApi;", "", "getWalletStatus", "Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletStatusResponse;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldNotifyUser", "Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcNotificationResponse;", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletCobrandedCcApi {
    @Nullable
    @GET("/api/v1/wallet/bff/account/page/content/{countryId}")
    Object getWalletStatus(@Path("countryId") int i11, @NotNull Continuation<? super WalletStatusResponse> continuation);

    @Nullable
    @GET("/api/v1/wallet/bff/account/badge/notifications/{countryId}")
    Object shouldNotifyUser(@Path("countryId") int i11, @NotNull Continuation<? super WalletCobrandedCcNotificationResponse> continuation);
}
