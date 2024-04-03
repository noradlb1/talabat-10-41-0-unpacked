package com.adyen.checkout.core.handler;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.AdditionalDetails;

public interface AdditionalDetailsHandler {
    void onAdditionalDetailsRequired(@NonNull AdditionalDetails additionalDetails);
}
