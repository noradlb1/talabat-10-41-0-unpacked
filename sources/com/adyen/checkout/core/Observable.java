package com.adyen.checkout.core;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

public interface Observable<T> {
    @MainThread
    void observe(@NonNull Activity activity, @NonNull Observer<T> observer);

    @MainThread
    void removeObserver(@NonNull Observer<T> observer);
}
