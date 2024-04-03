package com.adyen.checkout.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.PaymentController;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.StartPaymentParameters;
import com.adyen.checkout.core.handler.StartPaymentParametersHandler;
import com.adyen.checkout.core.internal.model.DeviceFingerprint;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.googlepay.GooglePayHandler;
import com.adyen.checkout.ui.internal.CheckoutHandler;
import com.adyen.checkout.ui.internal.card.CardHandler;
import com.adyen.checkout.ui.internal.doku.DokuHandler;
import com.adyen.checkout.ui.internal.giropay.GiroPayHandler;
import com.adyen.checkout.ui.internal.issuer.IssuerHandler;
import com.adyen.checkout.ui.internal.openinvoice.OpenInvoiceHandler;
import com.adyen.checkout.ui.internal.qiwiwallet.QiwiWalletHandler;
import com.adyen.checkout.ui.internal.sepadirectdebit.SepaDirectDebitHandler;
import com.adyen.checkout.wechatpay.WeChatPayHandler;

public final class CheckoutController {

    public static final class CheckoutSetupParametersImpl implements CheckoutSetupParameters {
        private final String mReturnUrl;
        private final String mSdkToken;

        @NonNull
        public String getReturnUrl() {
            return this.mReturnUrl;
        }

        @NonNull
        public String getSdkToken() {
            return this.mSdkToken;
        }

        private CheckoutSetupParametersImpl(@NonNull Context context) throws CheckoutException {
            this.mSdkToken = DeviceFingerprint.generateSdkToken(context, "quick");
            this.mReturnUrl = "checkout://" + context.getPackageName();
        }
    }

    private CheckoutController() {
        throw new IllegalStateException("No instances.");
    }

    @NonNull
    public static PaymentMethodHandler getCheckoutHandler(@NonNull StartPaymentParameters startPaymentParameters) {
        return new CheckoutHandler(startPaymentParameters);
    }

    @Nullable
    public static PaymentMethodHandler getPaymentMethodHandler(@NonNull Activity activity, @NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        Application application = activity.getApplication();
        if (CardHandler.FACTORY.supports(application, paymentMethod)) {
            return new CardHandler(paymentReference, paymentMethod);
        }
        if (DokuHandler.FACTORY.supports(application, paymentMethod)) {
            return new DokuHandler(paymentReference, paymentMethod);
        }
        if (GiroPayHandler.FACTORY.supports(application, paymentMethod)) {
            return new GiroPayHandler(paymentReference, paymentMethod);
        }
        if (GooglePayHandler.FACTORY.supports(application, paymentMethod)) {
            return new GooglePayHandler(paymentReference, paymentMethod);
        }
        if (IssuerHandler.FACTORY.supports(application, paymentMethod)) {
            return new IssuerHandler(paymentReference, paymentMethod);
        }
        if (OpenInvoiceHandler.FACTORY.supports(application, paymentMethod)) {
            return new OpenInvoiceHandler(paymentReference, paymentMethod);
        }
        if (QiwiWalletHandler.FACTORY.supports(application, paymentMethod)) {
            return new QiwiWalletHandler(paymentReference, paymentMethod);
        }
        if (SepaDirectDebitHandler.FACTORY.supports(application, paymentMethod)) {
            return new SepaDirectDebitHandler(paymentReference, paymentMethod);
        }
        if (WeChatPayHandler.FACTORY.supports(application, paymentMethod)) {
            return new WeChatPayHandler(paymentReference, paymentMethod);
        }
        return null;
    }

    public static void handlePaymentSessionResponse(@NonNull Activity activity, @NonNull String str, @NonNull StartPaymentParametersHandler startPaymentParametersHandler) {
        PaymentController.handlePaymentSessionResponse(activity, str, startPaymentParametersHandler);
    }

    public static void startPayment(@NonNull Activity activity, @NonNull CheckoutSetupParametersHandler checkoutSetupParametersHandler) {
        try {
            checkoutSetupParametersHandler.onRequestPaymentSession(new CheckoutSetupParametersImpl(activity));
        } catch (CheckoutException e11) {
            checkoutSetupParametersHandler.onError(e11);
        }
    }
}
