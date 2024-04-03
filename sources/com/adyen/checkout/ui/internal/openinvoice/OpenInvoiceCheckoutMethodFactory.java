package com.adyen.checkout.ui.internal.openinvoice;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class OpenInvoiceCheckoutMethodFactory extends CheckoutMethodFactory {
    public OpenInvoiceCheckoutMethodFactory(@NonNull Application application) {
        super(application);
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initCheckoutMethods(@NonNull PaymentSession paymentSession) {
        final ArrayList arrayList = new ArrayList();
        for (PaymentMethod next : paymentSession.getPaymentMethods()) {
            PaymentMethodHandler.Factory factory = OpenInvoiceHandler.FACTORY;
            if (factory.supports(getApplication(), next) && factory.isAvailableToShopper(getApplication(), paymentSession, next)) {
                arrayList.add(new OpenInvoiceCheckoutMethod(getApplication(), next));
            }
        }
        return new Callable<List<CheckoutMethod>>() {
            public List<CheckoutMethod> call() {
                return arrayList;
            }
        };
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initOneClickCheckoutMethods(@NonNull PaymentSession paymentSession) {
        return null;
    }
}
