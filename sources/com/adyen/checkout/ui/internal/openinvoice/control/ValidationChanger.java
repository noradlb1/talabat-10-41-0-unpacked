package com.adyen.checkout.ui.internal.openinvoice.control;

import androidx.annotation.NonNull;

public interface ValidationChanger {

    public interface ValidationChangeListener {
        void onValidationChanged(boolean z11);
    }

    void addValidationChangeListener(@NonNull ValidationChangeListener validationChangeListener);

    boolean isValid();

    void removeValidationChangeListener(@NonNull ValidationChangeListener validationChangeListener);
}
