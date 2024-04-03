package com.checkout.api;

import androidx.annotation.UiThread;
import com.checkout.threedsecure.model.ThreeDSRequest;
import com.checkout.tokenization.model.CardTokenRequest;
import com.checkout.tokenization.model.GooglePayTokenRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/checkout/api/CheckoutApiService;", "", "createToken", "", "request", "Lcom/checkout/tokenization/model/CardTokenRequest;", "Lcom/checkout/tokenization/model/GooglePayTokenRequest;", "handleThreeDS", "Lcom/checkout/threedsecure/model/ThreeDSRequest;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface CheckoutApiService {
    @UiThread
    void createToken(@NotNull CardTokenRequest cardTokenRequest);

    @UiThread
    void createToken(@NotNull GooglePayTokenRequest googlePayTokenRequest);

    void handleThreeDS(@NotNull ThreeDSRequest threeDSRequest);
}
