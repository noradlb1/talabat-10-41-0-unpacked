package com.adyen.checkout.ui.internal.openinvoice.control;

import android.text.Editable;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.ui.internal.openinvoice.control.ValidationCheckDelegate;
import com.adyen.checkout.util.internal.SimpleTextWatcher;

public class EmailValidator extends ValidationCheckDelegateBase {
    private EditText mEditText;
    private InputDetail mInputDetail;

    public EmailValidator(@NonNull InputDetail inputDetail, @NonNull EditText editText) {
        this.mInputDetail = inputDetail;
        this.mEditText = editText;
        editText.addTextChangedListener(new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                EmailValidator.this.isValid();
            }
        });
    }

    @NonNull
    public ValidationCheckDelegate.ValidationState getValidationState() {
        if (this.mInputDetail.isOptional()) {
            return ValidationCheckDelegate.ValidationState.VALID;
        }
        if (TextUtils.isEmpty(this.mEditText.getText())) {
            return ValidationCheckDelegate.ValidationState.FIELD_EMPTY;
        }
        if (Patterns.EMAIL_ADDRESS.matcher(this.mEditText.getText()).matches()) {
            return ValidationCheckDelegate.ValidationState.VALID;
        }
        return ValidationCheckDelegate.ValidationState.INCORRECT_FORMAT;
    }
}
