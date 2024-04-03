package com.adyen.checkout.ui.internal.openinvoice.control;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.ui.internal.common.view.DatePickerWidget;
import com.adyen.checkout.ui.internal.openinvoice.control.ValidationCheckDelegate;
import java.util.Date;

public class DateValidator extends ValidationCheckDelegateBase implements DatePickerWidget.OnDateChangeListener {
    private DatePickerWidget mDatePicker;
    private InputDetail mInputDetail;

    public DateValidator(@NonNull InputDetail inputDetail, @NonNull DatePickerWidget datePickerWidget) {
        this.mInputDetail = inputDetail;
        this.mDatePicker = datePickerWidget;
        datePickerWidget.addOnDateChangeListener(this);
    }

    @NonNull
    public ValidationCheckDelegate.ValidationState getValidationState() {
        if (this.mInputDetail.isOptional()) {
            return ValidationCheckDelegate.ValidationState.VALID;
        }
        if (this.mDatePicker.getDate() == null) {
            return ValidationCheckDelegate.ValidationState.FIELD_EMPTY;
        }
        return ValidationCheckDelegate.ValidationState.VALID;
    }

    public void onDateChanged(@NonNull Date date) {
        isValid();
    }
}
