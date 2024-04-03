package com.adyen.checkout.core.model;

import androidx.annotation.NonNull;

public interface KlarnaSsnLookupResponse {
    @NonNull
    Address getAddress();

    @NonNull
    Name getName();
}
