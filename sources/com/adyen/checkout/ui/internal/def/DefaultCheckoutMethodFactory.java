package com.adyen.checkout.ui.internal.def;

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

public class DefaultCheckoutMethodFactory extends CheckoutMethodFactory {
    private final List<PaymentMethod> mHandledOneClickPaymentMethods = new ArrayList();
    private final List<PaymentMethod> mHandledPaymentMethods = new ArrayList();

    public DefaultCheckoutMethodFactory(@NonNull Application application) {
        super(application);
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initCheckoutMethods(@NonNull PaymentSession paymentSession) {
        final ArrayList arrayList = new ArrayList();
        List<PaymentMethod> paymentMethods = paymentSession.getPaymentMethods();
        Application application = getApplication();
        for (PaymentMethod next : paymentMethods) {
            if (!this.mHandledPaymentMethods.contains(next)) {
                PaymentMethodHandler.Factory factory = DefaultPaymentMethodHandler.FACTORY;
                if (factory.supports(application, next) && factory.isAvailableToShopper(application, paymentSession, next)) {
                    arrayList.add(new DefaultCheckoutMethod(application, next));
                }
            }
        }
        return new Callable<List<CheckoutMethod>>() {
            public List<CheckoutMethod> call() throws Exception {
                return arrayList;
            }
        };
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initOneClickCheckoutMethods(@NonNull PaymentSession paymentSession) {
        final ArrayList arrayList = new ArrayList();
        List<PaymentMethod> oneClickPaymentMethods = paymentSession.getOneClickPaymentMethods();
        if (oneClickPaymentMethods != null) {
            Application application = getApplication();
            for (PaymentMethod next : oneClickPaymentMethods) {
                if (!this.mHandledOneClickPaymentMethods.contains(next)) {
                    PaymentMethodHandler.Factory factory = DefaultPaymentMethodHandler.FACTORY;
                    if (factory.supports(application, next) && factory.isAvailableToShopper(application, paymentSession, next)) {
                        arrayList.add(new DefaultCheckoutMethod(application, next));
                    }
                }
            }
        }
        return new Callable<List<CheckoutMethod>>() {
            public List<CheckoutMethod> call() {
                return arrayList;
            }
        };
    }

    public void setHandledOneClickPaymentMethods(@Nullable List<PaymentMethod> list) {
        this.mHandledOneClickPaymentMethods.clear();
        if (list != null) {
            this.mHandledOneClickPaymentMethods.addAll(list);
        }
    }

    public void setHandledPaymentMethods(@Nullable List<PaymentMethod> list) {
        this.mHandledPaymentMethods.clear();
        if (list != null) {
            this.mHandledPaymentMethods.addAll(list);
        }
    }
}
