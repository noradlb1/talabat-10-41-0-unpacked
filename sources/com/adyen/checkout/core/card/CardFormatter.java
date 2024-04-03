package com.adyen.checkout.core.card;

import android.support.annotation.NonNull;
import android.text.TextWatcher;
import android.widget.EditText;

public interface CardFormatter {
    @NonNull
    TextWatcher attachAsYouTypeExpiryDateFormatter(@NonNull EditText editText);

    @NonNull
    TextWatcher attachAsYouTypeNumberFormatter(@NonNull EditText editText);

    @NonNull
    String formatExpiryDate(int i11, int i12);

    @NonNull
    String formatNumber(@NonNull String str);

    @NonNull
    String formatSecurityCode(@NonNull String str);

    @NonNull
    String maskNumber(@NonNull String str);
}
