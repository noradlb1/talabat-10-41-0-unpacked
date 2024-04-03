package com.adyen.checkout.ui.internal.openinvoice.control;

import androidx.annotation.NonNull;

public interface ValidationCheckDelegate extends ValidationChanger {

    public enum ValidationState {
        VALID,
        FIELD_EMPTY,
        INCORRECT_FORMAT
    }

    @NonNull
    ValidationState getValidationState();
}
