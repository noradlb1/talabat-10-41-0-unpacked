package com.adyen.checkout.base;

import androidx.annotation.NonNull;

public interface TxVariantProvider {
    @NonNull
    String getTxVariant();
}
