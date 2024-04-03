package com.adyen.checkout.ui.internal.openinvoice.control;

import android.graphics.PorterDuff;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.adyen.checkout.ui.R;

class EditTextVisualizationControl implements VisibilityControlDelegate {
    private EditText mEditText;

    public EditTextVisualizationControl(EditText editText) {
        this.mEditText = editText;
    }

    public void setEditableInputView() {
        this.mEditText.getBackground().clearColorFilter();
        this.mEditText.setEnabled(true);
    }

    public void setErrorFeedbackView() {
        this.mEditText.getBackground().setColorFilter(ContextCompat.getColor(this.mEditText.getContext(), R.color.error), PorterDuff.Mode.SRC_IN);
    }

    public void setReadOnlyInputView() {
        this.mEditText.getBackground().clearColorFilter();
        this.mEditText.setEnabled(false);
    }
}
