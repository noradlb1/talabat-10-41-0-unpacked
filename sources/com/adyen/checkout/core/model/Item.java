package com.adyen.checkout.core.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.adyen.checkout.base.TxSubVariantProvider;

public interface Item extends TxSubVariantProvider, Parcelable {
    @NonNull
    String getId();

    @NonNull
    String getName();
}
