package com.adyen.checkout.ui.internal.openinvoice.control;

import android.text.TextUtils;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.Item;
import com.adyen.checkout.ui.internal.openinvoice.control.ValidationCheckDelegate;

public class SimpleItemSpinnerValidator extends ValidationCheckDelegateBase {
    private InputDetail mInputDetail;
    private Spinner mSpinner;

    public SimpleItemSpinnerValidator(@NonNull InputDetail inputDetail, @NonNull Spinner spinner) {
        this.mInputDetail = inputDetail;
        this.mSpinner = spinner;
    }

    @Nullable
    private String getIdFromItemSpinner() {
        Spinner spinner = this.mSpinner;
        if (!(spinner == null || spinner.getSelectedItem() == null)) {
            Item item = (Item) this.mSpinner.getSelectedItem();
            if (!TextUtils.isEmpty(item.getId())) {
                return item.getId();
            }
        }
        return null;
    }

    @NonNull
    public ValidationCheckDelegate.ValidationState getValidationState() {
        if (this.mInputDetail.isOptional()) {
            return ValidationCheckDelegate.ValidationState.VALID;
        }
        if (getIdFromItemSpinner() == null) {
            return ValidationCheckDelegate.ValidationState.FIELD_EMPTY;
        }
        return ValidationCheckDelegate.ValidationState.VALID;
    }
}
