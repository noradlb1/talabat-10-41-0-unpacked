package com.adyen.checkout.ui.internal.wechatpay;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.internal.model.PaymentMethodImpl;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodFactory;
import com.adyen.checkout.util.PaymentMethodTypes;
import com.adyen.checkout.wechatpay.WeChatPayHandler;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class WeChatPayCheckoutMethodFactory extends CheckoutMethodFactory {

    public static final class WeChatPayCallable implements Callable<List<CheckoutMethod>> {
        private static final String ERROR_MESSAGE_FORMAT = "PaymentMethod with type %s is present, but the 'checkout-wechatpay' dependency is missing. Add the dependency to your dependency list.";
        private static final String TAG = "WeChatPayCallable";
        private final Application mApplication;
        private final PaymentSession mPaymentSession;

        private WeChatPayCallable(@NonNull Application application, @NonNull PaymentSession paymentSession) {
            this.mApplication = application;
            this.mPaymentSession = paymentSession;
        }

        public List<CheckoutMethod> call() {
            PaymentMethod findByType = PaymentMethodImpl.findByType(this.mPaymentSession.getPaymentMethods(), PaymentMethodTypes.WECHAT_PAY_SDK);
            if (findByType == null) {
                return null;
            }
            try {
                if (!WeChatPayHandler.FACTORY.supports(this.mApplication, findByType) || !WeChatPayHandler.FACTORY.isAvailableToShopper(this.mApplication, this.mPaymentSession, findByType)) {
                    return null;
                }
                return Collections.singletonList(new WeChatPayCheckoutMethod(this.mApplication, findByType));
            } catch (NoClassDefFoundError unused) {
                Log.e(TAG, String.format(ERROR_MESSAGE_FORMAT, new Object[]{findByType}));
                return null;
            } catch (Exception e11) {
                Log.w(TAG, e11);
                return null;
            }
        }
    }

    public WeChatPayCheckoutMethodFactory(@NonNull Application application) {
        super(application);
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initCheckoutMethods(@NonNull PaymentSession paymentSession) {
        return new WeChatPayCallable(getApplication(), paymentSession);
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initOneClickCheckoutMethods(@NonNull PaymentSession paymentSession) {
        return null;
    }
}
