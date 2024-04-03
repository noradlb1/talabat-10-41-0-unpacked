package com.adyen.checkout.core.model;

import android.os.Parcelable;
import androidx.annotation.Nullable;

public interface StoredDetails extends Parcelable {
    @Nullable
    Card getCard();

    @Nullable
    String getEmailAddress();
}
