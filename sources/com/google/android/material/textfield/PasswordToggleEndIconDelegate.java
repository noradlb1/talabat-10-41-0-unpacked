package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;

class PasswordToggleEndIconDelegate extends EndIconDelegate {
    private final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() {
        public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = PasswordToggleEndIconDelegate.this;
            passwordToggleEndIconDelegate.endIconView.setChecked(!passwordToggleEndIconDelegate.hasPasswordTransformation());
            editText.removeTextChangedListener(PasswordToggleEndIconDelegate.this.textWatcher);
            editText.addTextChangedListener(PasswordToggleEndIconDelegate.this.textWatcher);
        }
    };
    private final TextInputLayout.OnEndIconChangedListener onEndIconChangedListener = new TextInputLayout.OnEndIconChangedListener() {
        public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i11) {
            final EditText editText = textInputLayout.getEditText();
            if (editText != null && i11 == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.post(new Runnable() {
                    public void run() {
                        editText.removeTextChangedListener(PasswordToggleEndIconDelegate.this.textWatcher);
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */
    public final TextWatcher textWatcher = new TextWatcherAdapter() {
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = PasswordToggleEndIconDelegate.this;
            passwordToggleEndIconDelegate.endIconView.setChecked(!passwordToggleEndIconDelegate.hasPasswordTransformation());
        }
    };

    public PasswordToggleEndIconDelegate(@NonNull TextInputLayout textInputLayout, @DrawableRes int i11) {
        super(textInputLayout, i11);
    }

    /* access modifiers changed from: private */
    public boolean hasPasswordTransformation() {
        EditText editText = this.textInputLayout.getEditText();
        if (editText == null || !(editText.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return false;
        }
        return true;
    }

    private static boolean isInputTypePassword(EditText editText) {
        if (editText == null || (editText.getInputType() != 16 && editText.getInputType() != 128 && editText.getInputType() != 144 && editText.getInputType() != 224)) {
            return false;
        }
        return true;
    }

    public void initialize() {
        TextInputLayout textInputLayout = this.textInputLayout;
        int i11 = this.customEndIcon;
        if (i11 == 0) {
            i11 = R.drawable.design_password_eye;
        }
        textInputLayout.setEndIconDrawable(i11);
        TextInputLayout textInputLayout2 = this.textInputLayout;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R.string.password_toggle_content_description));
        this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText editText = PasswordToggleEndIconDelegate.this.textInputLayout.getEditText();
                if (editText != null) {
                    int selectionEnd = editText.getSelectionEnd();
                    if (PasswordToggleEndIconDelegate.this.hasPasswordTransformation()) {
                        editText.setTransformationMethod((TransformationMethod) null);
                    } else {
                        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                    if (selectionEnd >= 0) {
                        editText.setSelection(selectionEnd);
                    }
                    PasswordToggleEndIconDelegate.this.textInputLayout.refreshEndIconDrawableState();
                }
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.onEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.onEndIconChangedListener);
        EditText editText = this.textInputLayout.getEditText();
        if (isInputTypePassword(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
