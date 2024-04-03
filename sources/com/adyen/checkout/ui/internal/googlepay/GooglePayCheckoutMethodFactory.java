package com.adyen.checkout.ui.internal.googlepay;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.internal.model.PaymentMethodImpl;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.googlepay.GooglePayHandler;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodFactory;
import com.adyen.checkout.util.PaymentMethodTypes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class GooglePayCheckoutMethodFactory extends CheckoutMethodFactory {

    public static final class GooglePayCallable implements Callable<List<CheckoutMethod>> {
        private static final String ERROR_MESSAGE_FORMAT = "PaymentMethod with type '%s' is present, but the 'checkout-googlepay' dependency is missing. Add the dependency to your dependency list.";
        private static final String TAG = "GooglePayCallable";
        private final Application mApplication;
        private final PaymentSession mPaymentSession;

        private GooglePayCallable(@NonNull Application application, @NonNull PaymentSession paymentSession) {
            this.mApplication = application;
            this.mPaymentSession = paymentSession;
        }

        public List<CheckoutMethod> call() {
            ArrayList arrayList = new ArrayList();
            PaymentMethod findByType = PaymentMethodImpl.findByType(this.mPaymentSession.getPaymentMethods(), PaymentMethodTypes.GOOGLE_PAY);
            if (findByType != null) {
                try {
                    if (GooglePayHandler.FACTORY.supports(this.mApplication, findByType) && GooglePayHandler.FACTORY.isAvailableToShopper(this.mApplication, this.mPaymentSession, findByType) && ((Boolean) GooglePayHandler.getReadyToPayCallable(this.mApplication, this.mPaymentSession, findByType).call()).booleanValue()) {
                        arrayList.add(new GooglePayCheckoutMethod(this.mApplication, findByType));
                    }
                } catch (NoClassDefFoundError unused) {
                    Log.e(TAG, String.format(ERROR_MESSAGE_FORMAT, new Object[]{findByType.getType()}));
                } catch (Exception e11) {
                    Log.w(TAG, e11);
                }
            }
            return arrayList;
        }
    }

    public GooglePayCheckoutMethodFactory(@NonNull Application application) {
        super(application);
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initCheckoutMethods(@NonNull PaymentSession paymentSession) {
        return new GooglePayCallable(getApplication(), paymentSession);
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initOneClickCheckoutMethods(@NonNull PaymentSession paymentSession) {
        return null;
    }
}
