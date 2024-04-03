package com.adyen.checkout.ui.internal.openinvoice.control;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.model.FieldSetConfiguration;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.ui.internal.common.view.DatePickerWidget;
import com.adyen.checkout.ui.internal.openinvoice.control.ValidationChanger;
import com.adyen.checkout.ui.internal.openinvoice.control.ValidationCheckDelegate;
import com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout;
import java.util.HashSet;
import java.util.Iterator;

public class InputDetailController implements ValidationChanger, ValidationChanger.ValidationChangeListener {
    private static final String TAG = "InputDetailController";
    private InputErrorFeedbackLayout mErrorFeedbackLayout;
    private ViewGroup mInputContainer;
    private InputDetail mInputDetail;
    private View mInputView;
    private boolean mIsValid;
    private HashSet<ValidationChanger.ValidationChangeListener> mListeners = new HashSet<>();
    /* access modifiers changed from: private */
    public ValidationCheckDelegate mValidationCheckDelegate;
    private VisibilityControlDelegate mVisibilityControlDelegate;

    /* renamed from: com.adyen.checkout.ui.internal.openinvoice.control.InputDetailController$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40306a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility[] r0 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40306a = r0
                com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r1 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.READ_ONLY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40306a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r1 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.HIDDEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f40306a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r1 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.EDITABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.ui.internal.openinvoice.control.InputDetailController.AnonymousClass2.<clinit>():void");
        }
    }

    public static class VisibilityControlFactory {
        private VisibilityControlFactory() {
        }

        public static VisibilityControlDelegate a(View view) {
            if (view instanceof EditText) {
                return new EditTextVisualizationControl((EditText) view);
            }
            if (view instanceof Spinner) {
                return new GenericVisualizationControl(view);
            }
            if (view instanceof DatePickerWidget) {
                return new GenericVisualizationControl(view);
            }
            return new GenericVisualizationControl(view);
        }
    }

    public InputDetailController(@NonNull InputDetail inputDetail, @NonNull View view, @Nullable ViewGroup viewGroup, @NonNull ValidationCheckDelegate validationCheckDelegate) {
        this.mInputDetail = inputDetail;
        this.mInputView = view;
        this.mInputContainer = viewGroup;
        this.mValidationCheckDelegate = validationCheckDelegate;
        validationCheckDelegate.addValidationChangeListener(this);
        this.mVisibilityControlDelegate = VisibilityControlFactory.a(this.mInputView);
        this.mErrorFeedbackLayout = getErrorFeedbackLayout();
        setDetailViewVisibility();
        this.mInputView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                if (!z11 && InputDetailController.this.mValidationCheckDelegate.getValidationState() == ValidationCheckDelegate.ValidationState.INCORRECT_FORMAT) {
                    InputDetailController.this.setErrorStateUiFeedback(InputErrorFeedbackLayout.ErrorFeedbackState.INCORRECT_FORMAT);
                }
            }
        });
    }

    @NonNull
    private FieldSetConfiguration.FieldVisibility getConfigVisibility() {
        try {
            FieldSetConfiguration fieldSetConfiguration = (FieldSetConfiguration) this.mInputDetail.getConfiguration(FieldSetConfiguration.class);
            if (fieldSetConfiguration != null) {
                return fieldSetConfiguration.getFieldVisibility();
            }
        } catch (CheckoutException unused) {
        }
        return FieldSetConfiguration.FieldVisibility.EDITABLE;
    }

    @Nullable
    private InputErrorFeedbackLayout getErrorFeedbackLayout() {
        for (int i11 = 0; i11 < this.mInputContainer.getChildCount(); i11++) {
            if (this.mInputContainer.getChildAt(i11) instanceof InputErrorFeedbackLayout) {
                return (InputErrorFeedbackLayout) this.mInputContainer.getChildAt(i11);
            }
        }
        return null;
    }

    private synchronized void notifyValidationListeners(boolean z11) {
        Iterator<ValidationChanger.ValidationChangeListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onValidationChanged(z11);
        }
    }

    private void setDetailViewVisibility() {
        if (this.mInputDetail.isOptional()) {
            this.mInputContainer.setVisibility(8);
            return;
        }
        this.mInputContainer.setVisibility(0);
        int i11 = AnonymousClass2.f40306a[getConfigVisibility().ordinal()];
        if (i11 == 1) {
            this.mVisibilityControlDelegate.setReadOnlyInputView();
        } else if (i11 == 2) {
            this.mInputContainer.setVisibility(8);
        } else if (i11 != 3) {
            String str = TAG;
            Log.e(str, "Unexpected field visibility - " + getConfigVisibility());
            this.mVisibilityControlDelegate.setEditableInputView();
        } else {
            this.mVisibilityControlDelegate.setEditableInputView();
        }
    }

    /* access modifiers changed from: private */
    public void setErrorStateUiFeedback(InputErrorFeedbackLayout.ErrorFeedbackState errorFeedbackState) {
        if (getConfigVisibility() == FieldSetConfiguration.FieldVisibility.EDITABLE) {
            InputErrorFeedbackLayout.ErrorFeedbackState errorFeedbackState2 = InputErrorFeedbackLayout.ErrorFeedbackState.INCORRECT_FORMAT;
            if (errorFeedbackState == errorFeedbackState2) {
                this.mVisibilityControlDelegate.setErrorFeedbackView();
            } else {
                this.mVisibilityControlDelegate.setEditableInputView();
            }
            InputErrorFeedbackLayout inputErrorFeedbackLayout = this.mErrorFeedbackLayout;
            if (inputErrorFeedbackLayout == null) {
                return;
            }
            if (errorFeedbackState == InputErrorFeedbackLayout.ErrorFeedbackState.NONE || errorFeedbackState == errorFeedbackState2) {
                inputErrorFeedbackLayout.setErrorState(errorFeedbackState);
            }
        }
    }

    public synchronized void addValidationChangeListener(@NonNull ValidationChanger.ValidationChangeListener validationChangeListener) {
        this.mListeners.add(validationChangeListener);
    }

    public boolean isValid() {
        return this.mValidationCheckDelegate.isValid();
    }

    public void onValidationChanged(boolean z11) {
        if (this.mIsValid != z11) {
            this.mIsValid = z11;
            notifyValidationListeners(z11);
        }
        if (this.mValidationCheckDelegate.getValidationState() != ValidationCheckDelegate.ValidationState.INCORRECT_FORMAT) {
            setErrorStateUiFeedback(InputErrorFeedbackLayout.ErrorFeedbackState.NONE);
        }
    }

    public void removeValidationChangeListener(@NonNull ValidationChanger.ValidationChangeListener validationChangeListener) {
        this.mListeners.remove(validationChangeListener);
    }
}
