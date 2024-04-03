package com.adyen.checkout.ui.internal.common.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.Collections;
import java.util.List;

public class CheckoutMethodsLiveData extends MutableLiveData<CheckoutMethodsModel> {
    private boolean mPreselectedCheckoutMethodCleared;

    @NonNull
    public List<CheckoutMethod> getAllCheckoutMethods() {
        CheckoutMethodsModel checkoutMethodsModel = (CheckoutMethodsModel) getValue();
        if (checkoutMethodsModel != null) {
            return checkoutMethodsModel.getAllCheckoutMethods();
        }
        return Collections.emptyList();
    }

    public int getCheckoutMethodCount() {
        CheckoutMethodsModel checkoutMethodsModel = (CheckoutMethodsModel) getValue();
        if (checkoutMethodsModel != null) {
            return checkoutMethodsModel.getCheckoutMethodCount();
        }
        return 0;
    }

    @NonNull
    public List<CheckoutMethod> getCheckoutMethods() {
        CheckoutMethodsModel checkoutMethodsModel = (CheckoutMethodsModel) getValue();
        if (checkoutMethodsModel != null) {
            return checkoutMethodsModel.getCheckoutMethods();
        }
        return Collections.emptyList();
    }

    public int getOneClickCheckoutMethodCount() {
        CheckoutMethodsModel checkoutMethodsModel = (CheckoutMethodsModel) getValue();
        if (checkoutMethodsModel != null) {
            return checkoutMethodsModel.getOneClickCheckoutMethodCount();
        }
        return 0;
    }

    @NonNull
    public List<CheckoutMethod> getOneClickCheckoutMethods() {
        CheckoutMethodsModel checkoutMethodsModel = (CheckoutMethodsModel) getValue();
        if (checkoutMethodsModel != null) {
            return checkoutMethodsModel.getOneClickCheckoutMethods();
        }
        return Collections.emptyList();
    }

    @Nullable
    public CheckoutMethod getPreselectedCheckoutMethod() {
        CheckoutMethodsModel checkoutMethodsModel = (CheckoutMethodsModel) getValue();
        if (checkoutMethodsModel != null) {
            return checkoutMethodsModel.getPreselectedCheckoutMethod();
        }
        return null;
    }

    public boolean isPreselectedCheckoutMethodCleared() {
        return this.mPreselectedCheckoutMethodCleared;
    }

    public void observeOnce(@NonNull LifecycleOwner lifecycleOwner, @NonNull final Observer<CheckoutMethodsModel> observer) {
        super.observe(lifecycleOwner, new Observer<CheckoutMethodsModel>() {
            public void onChanged(@Nullable CheckoutMethodsModel checkoutMethodsModel) {
                if (checkoutMethodsModel != null) {
                    observer.onChanged(checkoutMethodsModel);
                    CheckoutMethodsLiveData.this.removeObserver(this);
                }
            }
        });
    }

    public void setPreselectedCheckoutMethodCleared() {
        CheckoutMethodsModel checkoutMethodsModel = (CheckoutMethodsModel) getValue();
        if (checkoutMethodsModel != null) {
            this.mPreselectedCheckoutMethodCleared = true;
            setValue(CheckoutMethodsModel.a(checkoutMethodsModel.getOneClickCheckoutMethods(), checkoutMethodsModel.getCheckoutMethods(), false));
        }
    }
}
