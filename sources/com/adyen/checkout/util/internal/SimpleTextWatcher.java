package com.adyen.checkout.util.internal;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;

public abstract class SimpleTextWatcher implements TextWatcher {
    public void afterTextChanged(@NonNull Editable editable) {
    }

    public void beforeTextChanged(@NonNull CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(@NonNull CharSequence charSequence, int i11, int i12, int i13) {
    }
}
