package com.adyen.checkout.ui.internal.issuer;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.internal.model.InputDetailImpl;
import com.adyen.checkout.core.internal.model.PaymentMethodImpl;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.IssuerDetails;
import com.adyen.checkout.core.model.Item;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodFactory;
import com.adyen.checkout.ui.internal.common.util.RedirectUtil;
import com.adyen.checkout.ui.internal.issuer.IssuerCheckoutMethod;
import com.adyen.checkout.util.PaymentMethodTypes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class IssuerCheckoutMethodFactory extends CheckoutMethodFactory {
    private static final Map<String, String> IDEAL_ISSUER_APP_PACKAGE_NAMES = new HashMap<String, String>() {
        {
            put("ING", "com.ing.mobile");
            put("Triodos Bank", "com.triodos.ib.mobile");
            put("ASN Bank", "nl.asnbank.asnbankieren");
            put("SNS Bank", "nl.snsbank.snsbankieren");
            put("RegioBank", "nl.regiobank.regiobankiere");
            put("ABN Amro", "com.abnamro.nl.mobile.payments");
            put("Rabobank", "nl.rabomobiel");
            put("bunq", "com.bunq.android");
            put("Knab", "bvm.bvmapp");
        }
    };

    public IssuerCheckoutMethodFactory(@NonNull Application application) {
        super(application);
    }

    @Nullable
    public Callable<List<CheckoutMethod>> initCheckoutMethods(@NonNull PaymentSession paymentSession) {
        final ArrayList arrayList = new ArrayList();
        List<PaymentMethod> paymentMethods = paymentSession.getPaymentMethods();
        Application application = getApplication();
        for (PaymentMethod next : paymentMethods) {
            PaymentMethodHandler.Factory factory = IssuerHandler.FACTORY;
            if (factory.supports(application, next) && factory.isAvailableToShopper(application, paymentSession, next)) {
                arrayList.add(new IssuerCheckoutMethod.Default(application, next));
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
        InputDetail inputDetail;
        List<Item> list;
        RedirectUtil.ResolveResult resolveResult;
        IssuerCheckoutMethod.InstalledApp init;
        final ArrayList arrayList = new ArrayList();
        PaymentMethod findByType = PaymentMethodImpl.findByType(paymentSession.getPaymentMethods(), PaymentMethodTypes.IDEAL);
        if (findByType != null) {
            inputDetail = InputDetailImpl.findByKey(findByType.getInputDetails(), IssuerDetails.KEY_ISSUER);
        } else {
            inputDetail = null;
        }
        if (inputDetail != null) {
            list = inputDetail.getItems();
        } else {
            list = null;
        }
        if (list != null) {
            Application application = getApplication();
            for (Item next : list) {
                String str = IDEAL_ISSUER_APP_PACKAGE_NAMES.get(next.getName());
                if (str != null) {
                    resolveResult = RedirectUtil.determineResolveResult((Context) application, str);
                } else {
                    resolveResult = null;
                }
                if (!(resolveResult == null || resolveResult.getResolveType() != RedirectUtil.ResolveType.APPLICATION || (init = IssuerCheckoutMethod.InstalledApp.init(application, findByType, resolveResult, next)) == null)) {
                    arrayList.add(init);
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
