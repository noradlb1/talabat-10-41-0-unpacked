package com.adyen.checkout.core.card.internal;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.adyen.checkout.core.card.CardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class AsYouTypeCardNumberFormatter implements TextWatcher {
    private static final Set<Integer> AMEX_SPACING_INDEXES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{4, 11, 17})));
    private static final int CARD_SPACE_POSITION_MULTIPLIER = 5;
    private boolean mDeleted;
    private final EditText mEditText;
    private final char mSeparatorChar;
    private final String mSeparatorString;
    private boolean mTransforming;

    private AsYouTypeCardNumberFormatter(@NonNull EditText editText, char c11) {
        this.mEditText = editText;
        this.mSeparatorChar = c11;
        this.mSeparatorString = String.valueOf(c11);
    }

    @NonNull
    public static TextWatcher a(@NonNull EditText editText, char c11) {
        AsYouTypeCardNumberFormatter asYouTypeCardNumberFormatter = new AsYouTypeCardNumberFormatter(editText, c11);
        editText.addTextChangedListener(asYouTypeCardNumberFormatter);
        return asYouTypeCardNumberFormatter;
    }

    private boolean isSpacingIndex(int i11) {
        if (CardType.AMERICAN_EXPRESS.isEstimateFor(this.mEditText.getText().toString())) {
            return AMEX_SPACING_INDEXES.contains(Integer.valueOf(i11));
        }
        if ((i11 + 1) % 5 == 0) {
            return true;
        }
        return false;
    }

    public void afterTextChanged(@NonNull Editable editable) {
        if (!this.mTransforming) {
            this.mTransforming = true;
            int length = editable.length();
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = editable.charAt(i11);
                if (isSpacingIndex(i11)) {
                    if (charAt != this.mSeparatorChar) {
                        if (!Character.isDigit(charAt)) {
                            editable.replace(i11, i11 + 1, this.mSeparatorString);
                        } else {
                            editable.insert(i11, this.mSeparatorString);
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
                } else if (!Character.isDigit(charAt)) {
                    editable.delete(i11, i11 + 1);
                    length = editable.length();
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
