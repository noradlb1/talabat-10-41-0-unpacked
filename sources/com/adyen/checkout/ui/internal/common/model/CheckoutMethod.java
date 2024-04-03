package com.adyen.checkout.ui.internal.common.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import com.adyen.checkout.base.LogoApi;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.internal.common.util.image.Rembrandt;
import com.adyen.checkout.ui.internal.common.util.image.RequestArgs;
import com.adyen.checkout.ui.internal.common.util.recyclerview.SimpleDiffCallback;

public abstract class CheckoutMethod implements SimpleDiffCallback.Comparable<CheckoutMethod> {
    private final Application mApplication;
    private final PaymentMethod mPaymentMethod;

    public CheckoutMethod(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
        this.mApplication = application;
        this.mPaymentMethod = paymentMethod;
    }

    @NonNull
    public RequestArgs buildLogoRequestArgs(@NonNull LogoApi logoApi) {
        return Rembrandt.createDefaultLogoRequestArgs(this.mApplication, logoApi.newBuilder(this.mPaymentMethod).buildCallable());
    }

    @NonNull
    public final Application getApplication() {
        return this.mApplication;
    }

    @NonNull
    public final PaymentMethod getPaymentMethod() {
        return this.mPaymentMethod;
    }

    @NonNull
    public String getPrimaryText() {
        return this.mPaymentMethod.getName();
    }

    @Nullable
    public String getSecondaryText() {
        return null;
    }

    public abstract void onSelected(@NonNull CheckoutHandler checkoutHandler);

    public boolean isSameContent(@NonNull CheckoutMethod checkoutMethod) {
        return ObjectsCompat.equals(getPrimaryText(), checkoutMethod.getPrimaryText()) && ObjectsCompat.equals(getSecondaryText(), checkoutMethod.getSecondaryText());
    }

    public boolean isSameItem(@NonNull CheckoutMethod checkoutMethod) {
        return this.mPaymentMethod.equals(checkoutMethod.mPaymentMethod);
    }
}
