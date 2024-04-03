package com.adyen.checkout.ui.internal.common.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.adyen.checkout.core.model.PaymentSession;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CheckoutViewModel extends AndroidViewModel {
    /* access modifiers changed from: private */
    public final CheckoutMethodsLiveData mCheckoutMethodsLiveData = new CheckoutMethodsLiveData();
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    public CheckoutViewModel(@NonNull Application application) {
        super(application);
    }

    @NonNull
    public CheckoutMethodsLiveData getCheckoutMethodsLiveData() {
        return this.mCheckoutMethodsLiveData;
    }

    public void updateCheckoutMethodsViewModel(@NonNull PaymentSession paymentSession) {
        final UpdateCheckoutMethodsCallable updateCheckoutMethodsCallable = new UpdateCheckoutMethodsCallable(getApplication(), paymentSession, !this.mCheckoutMethodsLiveData.isPreselectedCheckoutMethodCleared());
        this.mExecutorService.submit(new Runnable() {
            public void run() {
                CheckoutViewModel.this.mCheckoutMethodsLiveData.postValue(updateCheckoutMethodsCallable.call());
            }
        });
    }
}
