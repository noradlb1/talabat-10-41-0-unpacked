package com.adyen.checkout.core.model;

import androidx.annotation.NonNull;

public interface Name {
    @NonNull
    String getFirstName();

    @NonNull
    String getLastName();
}
