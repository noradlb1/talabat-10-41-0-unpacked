package com.adyen.checkout.ui.internal.openinvoice.control;

import androidx.annotation.NonNull;
import com.adyen.checkout.ui.internal.openinvoice.control.ValidationChanger;
import com.adyen.checkout.ui.internal.openinvoice.control.ValidationCheckDelegate;

public abstract class ValidationCheckDelegateBase implements ValidationCheckDelegate {
    private ValidationCheckDelegate.ValidationState mCurrentValidationState;
    private ValidationChanger.ValidationChangeListener mListener;

    public void addValidationChangeListener(@NonNull ValidationChanger.ValidationChangeListener validationChangeListener) {
        this.mListener = validationChangeListener;
    }

    @NonNull
    public abstract ValidationCheckDelegate.ValidationState getValidationState();

    public boolean isValid() {
        boolean z11;
        ValidationCheckDelegate.ValidationState validationState = getValidationState();
        if (validationState == ValidationCheckDelegate.ValidationState.VALID) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.mCurrentValidationState != validationState) {
            this.mCurrentValidationState = validationState;
            this.mListener.onValidationChanged(z11);
        }
        return z11;
    }

    public void removeValidationChangeListener(@NonNull ValidationChanger.ValidationChangeListener validationChangeListener) {
        this.mListener = null;
    }
}
