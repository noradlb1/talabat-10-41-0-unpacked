package com.adyen.checkout.util.sepadirectdebit;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.adyen.checkout.util.internal.SimpleTextWatcher;

public final class AsYouTypeIbanFormatter extends SimpleTextWatcher {
    private static final int BLOCK_SIZE_WITH_SPACE;
    private static final char SPACING_CHAR = ' ';
    private static final String SPACING_STRING;
    private boolean mDeleted;
    private final EditText mEditText;
    private boolean mTransforming;

    static {
        String valueOf = String.valueOf(' ');
        SPACING_STRING = valueOf;
        BLOCK_SIZE_WITH_SPACE = valueOf.length() + 4;
    }

    private AsYouTypeIbanFormatter(@NonNull EditText editText) {
        this.mEditText = editText;
    }

    @NonNull
    public static TextWatcher attach(@NonNull EditText editText) {
        AsYouTypeIbanFormatter asYouTypeIbanFormatter = new AsYouTypeIbanFormatter(editText);
        editText.addTextChangedListener(asYouTypeIbanFormatter);
        return asYouTypeIbanFormatter;
    }

    private boolean isSpacingIndex(int i11) {
        return (i11 + 1) % BLOCK_SIZE_WITH_SPACE == 0;
    }

    private boolean isValidCharacterClass(char c11) {
        return Character.isLetterOrDigit(c11);
    }

    @Nullable
    private Character transform(char c11) {
        if (Character.isLowerCase(c11)) {
            return Character.valueOf(Character.toUpperCase(c11));
        }
        return null;
    }

    public void afterTextChanged(@NonNull Editable editable) {
        if (!this.mTransforming) {
            this.mTransforming = true;
            int length = editable.length();
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = editable.charAt(i11);
                if (isSpacingIndex(i11)) {
                    if (charAt != ' ') {
                        if (!isValidCharacterClass(charAt)) {
                            editable.replace(i11, i11 + 1, SPACING_STRING);
                        } else {
                            editable.insert(i11, SPACING_STRING);
                            length = editable.length();
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
                } else if (!isValidCharacterClass(charAt)) {
                    editable.delete(i11, i11 + 1);
                    length = editable.length();
                } else {
                    Character transform = transform(charAt);
                    if (transform != null) {
                        editable.replace(i11, i11 + 1, String.valueOf(transform));
                    }
                }
            }
            this.mTransforming = false;
        }
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
