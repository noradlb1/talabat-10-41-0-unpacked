package com.adyen.checkout.core;

import android.app.Activity;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.LogoApi;
import com.adyen.checkout.core.handler.AdditionalDetailsHandler;
import com.adyen.checkout.core.handler.AuthenticationHandler;
import com.adyen.checkout.core.handler.ErrorHandler;
import com.adyen.checkout.core.handler.RedirectHandler;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentMethodDetails;
import com.adyen.checkout.core.model.PaymentSession;

public interface PaymentHandler {
    void deleteOneClickPaymentMethod(@NonNull PaymentMethod paymentMethod);

    @NonNull
    LogoApi getLogoApi();

    @NonNull
    Observable<NetworkingState> getNetworkingStateObservable();

    @NonNull
    Observable<PaymentResult> getPaymentResultObservable();

    @NonNull
    Observable<PaymentSession> getPaymentSessionObservable();

    void handleRedirectResult(@NonNull Uri uri);

    void initiatePayment(@NonNull PaymentMethod paymentMethod, @Nullable PaymentMethodDetails paymentMethodDetails);

    void setAdditionalDetailsHandler(@NonNull Activity activity, @NonNull AdditionalDetailsHandler additionalDetailsHandler);

    void setAuthenticationHandler(@NonNull Activity activity, @NonNull AuthenticationHandler authenticationHandler);

    void setErrorHandler(@NonNull Activity activity, @NonNull ErrorHandler errorHandler);

    void setRedirectHandler(@NonNull Activity activity, @NonNull RedirectHandler redirectHandler);

    void submitAdditionalDetails(@NonNull PaymentMethodDetails paymentMethodDetails);

    void submitAuthenticationDetails(@NonNull PaymentMethodDetails paymentMethodDetails);
}
