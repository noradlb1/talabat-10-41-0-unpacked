package com.adyen.checkout.base;

import androidx.annotation.NonNull;

public interface HostProvider {
    @NonNull
    String getUrl();
}
