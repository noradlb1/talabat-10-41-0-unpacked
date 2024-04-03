package com.adyen.checkout.ui.internal.qiwiwallet;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.internal.model.PaymentMethodImpl;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodFactory;
import com.adyen.checkout.util.PaymentMethodTypes;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class QiwiWalletCheckoutMethodFactory extends CheckoutMethodFactory {
    public QiwiWalletCheckoutMethodFactory(@NonNull Application application) {
        super(application);
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initCheckoutMethods(@NonNull PaymentSession paymentSession) {
        final PaymentMethod findByType = PaymentMethodImpl.findByType(paymentSession.getPaymentMethods(), PaymentMethodTypes.QIWIWALLET);
        final Application application = getApplication();
        if (findByType == null) {
            return null;
        }
        PaymentMethodHandler.Factory factory = QiwiWalletHandler.FACTORY;
        if (!factory.supports(application, findByType) || !factory.isAvailableToShopper(application, paymentSession, findByType)) {
            return null;
        }
        return new Callable<List<CheckoutMethod>>() {
            public List<CheckoutMethod> call() {
                return Collections.singletonList(new QiwiWalletCheckoutMethod(application, findByType));
            }
        };
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initOneClickCheckoutMethods(@NonNull PaymentSession paymentSession) {
        return null;
    }
}
