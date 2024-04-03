package com.adyen.checkout.ui.internal.common.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CheckoutMethodsModel {
    private final List<CheckoutMethod> mAllCheckoutMethods;
    private final int mCheckoutMethodCount;
    private final int mOneClickCheckoutMethodCount;
    private final CheckoutMethod mPreselectedCheckoutMethod;

    private CheckoutMethodsModel(int i11, int i12, @NonNull List<CheckoutMethod> list, @Nullable CheckoutMethod checkoutMethod) {
        this.mOneClickCheckoutMethodCount = i11;
        this.mCheckoutMethodCount = i12;
        this.mAllCheckoutMethods = list;
        this.mPreselectedCheckoutMethod = checkoutMethod;
    }

    @Nullable
    public static CheckoutMethodsModel a(@Nullable List<CheckoutMethod> list, @Nullable List<CheckoutMethod> list2, boolean z11) {
        int i11;
        int i12;
        CheckoutMethod checkoutMethod = null;
        if (list == null && list2 == null) {
            return null;
        }
        if (list != null) {
            i11 = list.size();
        } else {
            i11 = 0;
        }
        if (list2 != null) {
            i12 = list2.size();
        } else {
            i12 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        if (z11 && i11 > 0) {
            checkoutMethod = list.get(0);
        }
        return new CheckoutMethodsModel(i11, i12, arrayList, checkoutMethod);
    }

    @NonNull
    public List<CheckoutMethod> getAllCheckoutMethods() {
        return new ArrayList(this.mAllCheckoutMethods);
    }

    public int getCheckoutMethodCount() {
        return this.mCheckoutMethodCount;
    }

    @NonNull
    public List<CheckoutMethod> getCheckoutMethods() {
        if (this.mCheckoutMethodCount == 0) {
            return Collections.emptyList();
        }
        List<CheckoutMethod> list = this.mAllCheckoutMethods;
        return list.subList(this.mOneClickCheckoutMethodCount, list.size());
    }

    public int getOneClickCheckoutMethodCount() {
        return this.mOneClickCheckoutMethodCount;
    }

    @NonNull
    public List<CheckoutMethod> getOneClickCheckoutMethods() {
        int i11 = this.mOneClickCheckoutMethodCount;
        if (i11 == 0) {
            return Collections.emptyList();
        }
        return this.mAllCheckoutMethods.subList(0, i11);
    }

    @Nullable
    public CheckoutMethod getPreselectedCheckoutMethod() {
        return this.mPreselectedCheckoutMethod;
    }
}
