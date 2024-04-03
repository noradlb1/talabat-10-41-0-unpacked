package com.adyen.checkout.core;

import androidx.annotation.NonNull;

public interface Observer<T> {
    void onChanged(@NonNull T t11);
}
