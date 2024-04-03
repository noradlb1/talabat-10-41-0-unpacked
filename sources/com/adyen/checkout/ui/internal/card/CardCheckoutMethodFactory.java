package com.adyen.checkout.ui.internal.card;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.model.Card;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.core.model.StoredDetails;
import com.adyen.checkout.ui.internal.card.CardCheckoutMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodFactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.Callable;

public class CardCheckoutMethodFactory extends CheckoutMethodFactory {
    public CardCheckoutMethodFactory(@NonNull Application application) {
        super(application);
    }

    @NonNull
    public Callable<List<CheckoutMethod>> initCheckoutMethods(@NonNull PaymentSession paymentSession) {
        final ArrayList arrayList = new ArrayList();
        TreeSet<PaymentMethod> treeSet = new TreeSet<>(new Comparator<PaymentMethod>() {
            public int compare(PaymentMethod paymentMethod, PaymentMethod paymentMethod2) {
                return paymentMethod.getType().equals(paymentMethod2.getType()) ? 0 : -1;
            }
        });
        Application application = getApplication();
        for (PaymentMethod next : paymentSession.getPaymentMethods()) {
            PaymentMethod group = next.getGroup();
            if (group != null) {
                PaymentMethodHandler.Factory factory = CardHandler.FACTORY;
                if (factory.supports(application, group)) {
                    if (factory.isAvailableToShopper(application, paymentSession, next)) {
                        treeSet.add(group);
                    }
                }
            }
            PaymentMethodHandler.Factory factory2 = CardHandler.FACTORY;
            if (factory2.supports(application, next) && factory2.isAvailableToShopper(application, paymentSession, next)) {
                treeSet.add(next);
            }
        }
        for (PaymentMethod paymentMethod : treeSet) {
            arrayList.add(new CardCheckoutMethod.Default(application, paymentMethod));
        }
        return new Callable<List<CheckoutMethod>>() {
            public List<CheckoutMethod> call() {
                return arrayList;
            }
        };
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initOneClickCheckoutMethods(@NonNull PaymentSession paymentSession) {
        Card card;
        final ArrayList arrayList = new ArrayList();
        List<PaymentMethod> oneClickPaymentMethods = paymentSession.getOneClickPaymentMethods();
        if (oneClickPaymentMethods != null) {
            Application application = getApplication();
            for (PaymentMethod next : oneClickPaymentMethods) {
                if (CardHandler.FACTORY.isAvailableToShopper(application, paymentSession, next)) {
                    StoredDetails storedDetails = next.getStoredDetails();
                    if (storedDetails != null) {
                        card = storedDetails.getCard();
                    } else {
                        card = null;
                    }
                    if (card != null) {
                        arrayList.add(new CardCheckoutMethod.OneClick(application, next, card));
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
}
