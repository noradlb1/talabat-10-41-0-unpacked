package com.adyen.checkout.ui.internal.common.model;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.ui.internal.card.CardCheckoutMethodFactory;
import com.adyen.checkout.ui.internal.def.DefaultCheckoutMethodFactory;
import com.adyen.checkout.ui.internal.doku.DokuCheckoutMethodFactory;
import com.adyen.checkout.ui.internal.giropay.GiroPayCheckoutMethodFactory;
import com.adyen.checkout.ui.internal.googlepay.GooglePayCheckoutMethodFactory;
import com.adyen.checkout.ui.internal.issuer.IssuerCheckoutMethodFactory;
import com.adyen.checkout.ui.internal.openinvoice.OpenInvoiceCheckoutMethodFactory;
import com.adyen.checkout.ui.internal.paypal.PayPalCheckoutMethodFactory;
import com.adyen.checkout.ui.internal.qiwiwallet.QiwiWalletCheckoutMethodFactory;
import com.adyen.checkout.ui.internal.sepadirectdebit.SddCheckoutMethodFactory;
import com.adyen.checkout.ui.internal.wechatpay.WeChatPayCheckoutMethodFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public class UpdateCheckoutMethodsCallable implements Callable<CheckoutMethodsModel> {
    private static final String TAG = "UpdateCheckoutMethodsCallable";
    private final List<CheckoutMethodFactory> mCheckoutMethodFactories;
    private final DefaultCheckoutMethodFactory mDefaultCheckoutMethodFactory;
    private final boolean mIncludePreselectedCheckoutMethod;
    private final PaymentSession mPaymentSession;

    public static final class CheckoutMethodComparator implements Comparator<CheckoutMethod> {
        private final List<PaymentMethod> mPaymentMethods;

        private int getIndexOfPaymentMethod(@NonNull PaymentMethod paymentMethod) {
            if (this.mPaymentMethods == null) {
                return Integer.MAX_VALUE;
            }
            for (int i11 = 0; i11 < this.mPaymentMethods.size(); i11++) {
                PaymentMethod paymentMethod2 = this.mPaymentMethods.get(i11);
                if (paymentMethod.equals(paymentMethod2) || paymentMethod.equals(paymentMethod2.getGroup())) {
                    return i11;
                }
            }
            return Integer.MAX_VALUE;
        }

        private CheckoutMethodComparator(@Nullable List<PaymentMethod> list) {
            this.mPaymentMethods = list;
        }

        public int compare(CheckoutMethod checkoutMethod, CheckoutMethod checkoutMethod2) {
            int indexOfPaymentMethod = getIndexOfPaymentMethod(checkoutMethod.getPaymentMethod());
            int indexOfPaymentMethod2 = getIndexOfPaymentMethod(checkoutMethod2.getPaymentMethod());
            if (indexOfPaymentMethod < indexOfPaymentMethod2) {
                return -1;
            }
            return indexOfPaymentMethod == indexOfPaymentMethod2 ? 0 : 1;
        }
    }

    public UpdateCheckoutMethodsCallable(@NonNull Application application, @NonNull PaymentSession paymentSession, boolean z11) {
        this.mPaymentSession = paymentSession;
        this.mCheckoutMethodFactories = initCheckoutMethodFactories(application);
        this.mDefaultCheckoutMethodFactory = new DefaultCheckoutMethodFactory(application);
        this.mIncludePreselectedCheckoutMethod = z11;
    }

    private void callAndAddToList(@Nullable Callable<List<CheckoutMethod>> callable, @NonNull List<CheckoutMethod> list) {
        if (callable != null) {
            try {
                List call = callable.call();
                if (call != null) {
                    list.addAll(call);
                }
            } catch (Exception e11) {
                Log.e(TAG, "Error updating checkout methods.", e11);
            }
        }
    }

    @NonNull
    private List<PaymentMethod> getHandledPaymentMethods(@NonNull List<CheckoutMethod> list) {
        ArrayList arrayList = new ArrayList();
        for (CheckoutMethod paymentMethod : list) {
            arrayList.add(paymentMethod.getPaymentMethod());
        }
        return arrayList;
    }

    @NonNull
    private List<CheckoutMethodFactory> initCheckoutMethodFactories(@NonNull Application application) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CardCheckoutMethodFactory(application));
        arrayList.add(new DokuCheckoutMethodFactory(application));
        arrayList.add(new GiroPayCheckoutMethodFactory(application));
        arrayList.add(new GooglePayCheckoutMethodFactory(application));
        arrayList.add(new IssuerCheckoutMethodFactory(application));
        arrayList.add(new OpenInvoiceCheckoutMethodFactory(application));
        arrayList.add(new PayPalCheckoutMethodFactory(application));
        arrayList.add(new QiwiWalletCheckoutMethodFactory(application));
        arrayList.add(new SddCheckoutMethodFactory(application));
        arrayList.add(new WeChatPayCheckoutMethodFactory(application));
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    public CheckoutMethodsModel call() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (CheckoutMethodFactory next : this.mCheckoutMethodFactories) {
            callAndAddToList(next.initOneClickCheckoutMethods(this.mPaymentSession), arrayList);
            callAndAddToList(next.initCheckoutMethods(this.mPaymentSession), arrayList2);
        }
        this.mDefaultCheckoutMethodFactory.setHandledOneClickPaymentMethods(getHandledPaymentMethods(arrayList));
        this.mDefaultCheckoutMethodFactory.setHandledPaymentMethods(getHandledPaymentMethods(arrayList2));
        callAndAddToList(this.mDefaultCheckoutMethodFactory.initOneClickCheckoutMethods(this.mPaymentSession), arrayList);
        callAndAddToList(this.mDefaultCheckoutMethodFactory.initCheckoutMethods(this.mPaymentSession), arrayList2);
        Collections.sort(arrayList, new CheckoutMethodComparator(this.mPaymentSession.getOneClickPaymentMethods()));
        Collections.sort(arrayList2, new CheckoutMethodComparator(this.mPaymentSession.getPaymentMethods()));
        return CheckoutMethodsModel.a(arrayList, arrayList2, this.mIncludePreselectedCheckoutMethod);
    }
}
