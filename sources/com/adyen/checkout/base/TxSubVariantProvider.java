package com.adyen.checkout.base;

import androidx.annotation.NonNull;

public interface TxSubVariantProvider {
    @NonNull
    String getTxSubVariant();
}
