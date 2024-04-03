package com.adyen.checkout.core.model;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.internal.model.FieldSetConfigurationImpl;

@ProvidedBy(FieldSetConfigurationImpl.class)
public interface FieldSetConfiguration extends Configuration {

    public enum FieldVisibility {
        HIDDEN,
        READ_ONLY,
        EDITABLE
    }

    @NonNull
    FieldVisibility getFieldVisibility();
}
