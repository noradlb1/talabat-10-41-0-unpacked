package com.adyen.checkout.ui.internal.common.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.model.PaymentSession;
import java.util.List;
import java.util.concurrent.Callable;

public abstract class CheckoutMethodFactory {
    private Application mApplication;

    public CheckoutMethodFactory(@NonNull Application application) {
        this.mApplication = application;
    }

    @NonNull
    public Application getApplication() {
        return this.mApplication;
    }

    @Nullable
    public abstract Callable<List<CheckoutMethod>> initCheckoutMethods(@NonNull PaymentSession paymentSession);

    @Nullable
    public abstract Callable<List<CheckoutMethod>> initOneClickCheckoutMethods(@NonNull PaymentSession paymentSession);
}
