package com.checkout.frames.api;

import com.checkout.tokenization.model.TokenDetails;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/checkout/frames/api/PaymentFlowHandler;", "", "onBackPressed", "", "onFailure", "errorMessage", "", "onSubmit", "onSuccess", "tokenDetails", "Lcom/checkout/tokenization/model/TokenDetails;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PaymentFlowHandler {
    void onBackPressed();

    void onFailure(@NotNull String str);

    void onSubmit();

    void onSuccess(@NotNull TokenDetails tokenDetails);
}
