package com.checkout.tokenization;

import com.checkout.network.response.NetworkApiResponse;
import com.checkout.tokenization.request.GooglePayTokenNetworkRequest;
import com.checkout.tokenization.request.TokenRequest;
import com.checkout.tokenization.response.TokenDetailsResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/checkout/tokenization/NetworkApiClient;", "", "sendCardTokenRequest", "Lcom/checkout/network/response/NetworkApiResponse;", "Lcom/checkout/tokenization/response/TokenDetailsResponse;", "cardTokenRequest", "Lcom/checkout/tokenization/request/TokenRequest;", "(Lcom/checkout/tokenization/request/TokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendGooglePayTokenRequest", "googlePayTokenNetworkRequest", "Lcom/checkout/tokenization/request/GooglePayTokenNetworkRequest;", "(Lcom/checkout/tokenization/request/GooglePayTokenNetworkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface NetworkApiClient {
    @Nullable
    Object sendCardTokenRequest(@NotNull TokenRequest tokenRequest, @NotNull Continuation<? super NetworkApiResponse<TokenDetailsResponse>> continuation);

    @Nullable
    Object sendGooglePayTokenRequest(@NotNull GooglePayTokenNetworkRequest googlePayTokenNetworkRequest, @NotNull Continuation<? super NetworkApiResponse<TokenDetailsResponse>> continuation);
}
