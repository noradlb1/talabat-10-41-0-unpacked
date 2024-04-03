package com.adyen.checkout.ui.internal.openinvoice.control;

import android.view.View;

class GenericVisualizationControl implements VisibilityControlDelegate {
    private View mView;

    public GenericVisualizationControl(View view) {
        this.mView = view;
    }

    public void setEditableInputView() {
        this.mView.setEnabled(true);
    }

    public void setErrorFeedbackView() {
    }

    public void setReadOnlyInputView() {
        this.mView.setEnabled(false);
    }
}
