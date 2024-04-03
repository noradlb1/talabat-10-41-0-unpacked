package com.talabat.wallet.qPayManager.data.remote.api;

import com.talabat.wallet.qPayManager.data.remote.dto.QPayRedirectUrlRemoteDto;
import com.talabat.wallet.qPayManager.data.remote.dto.QPayRedirectUrlRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/qPayManager/data/remote/api/QPayManagerApi;", "", "getQPayRedirectUrl", "Lcom/talabat/wallet/qPayManager/data/remote/dto/QPayRedirectUrlRemoteDto;", "url", "", "request", "Lcom/talabat/wallet/qPayManager/data/remote/dto/QPayRedirectUrlRequest;", "(Ljava/lang/String;Lcom/talabat/wallet/qPayManager/data/remote/dto/QPayRedirectUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface QPayManagerApi {
    @POST
    @Nullable
    Object getQPayRedirectUrl(@NotNull @Url String str, @NotNull @Body QPayRedirectUrlRequest qPayRedirectUrlRequest, @NotNull Continuation<? super QPayRedirectUrlRemoteDto> continuation);
}
