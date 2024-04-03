package com.adyen.checkout.core.card.internal;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class AsYouTypeExpiryDateFormatter implements TextWatcher {
    private boolean mDeleted;
    private final EditText mEditText;
    private final char mSeparatorChar;
    private final String mSeparatorString;
    private boolean mTransforming;

    private AsYouTypeExpiryDateFormatter(@NonNull EditText editText, char c11) {
        this.mEditText = editText;
        this.mSeparatorChar = c11;
        this.mSeparatorString = String.valueOf(c11);
    }

    @NonNull
    public static TextWatcher a(@NonNull EditText editText, char c11) {
        AsYouTypeExpiryDateFormatter asYouTypeExpiryDateFormatter = new AsYouTypeExpiryDateFormatter(editText, c11);
        editText.addTextChangedListener(asYouTypeExpiryDateFormatter);
        return asYouTypeExpiryDateFormatter;
    }

    public void afterTextChanged(@NonNull Editable editable) {
        if (!this.mTransforming) {
            this.mTransforming = true;
            if (editable.length() == 1 && editable.charAt(0) > '1') {
                editable.insert(0, "0");
            }
            if (editable.length() == 2 && !this.mDeleted) {
                if (editable.toString().matches("\\d\\" + this.mSeparatorChar)) {
                    editable.insert(0, "0");
                } else if (!editable.toString().contains(this.mSeparatorString)) {
                    editable.append(this.mSeparatorChar);
                }
            }
            for (int i11 = 0; i11 < editable.length(); i11++) {
                char charAt = editable.charAt(i11);
                if (i11 == 2) {
                    if (charAt != this.mSeparatorChar) {
                        if (!Character.isDigit(charAt)) {
                            editable.replace(i11, i11 + 1, this.mSeparatorString);
                        } else {
                            editable.insert(i11, this.mSeparatorString);
                            if (this.mDeleted) {
                                int selectionStart = this.mEditText.getSelectionStart();
                                int selectionEnd = this.mEditText.getSelectionEnd();
                                int i12 = selectionStart - 1;
                                if (i12 == i11) {
                                    selectionStart = i12;
                                }
                                int i13 = selectionEnd - 1;
                                if (i13 == i11) {
                                    selectionEnd = i13;
                                }
                                this.mEditText.setSelection(selectionStart, selectionEnd);
                            }
                        }
                    }
                } else if (!Character.isDigit(charAt)) {
                    editable.delete(i11, i11 + 1);
                }
            }
            this.mTransforming = false;
        }
    }

    public void beforeTextChanged(@NonNull CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(@NonNull CharSequence charSequence, int i11, int i12, int i13) {
        boolean z11;
        if (!this.mTransforming) {
            if (i13 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.mDeleted = z11;
        }
    }
}
