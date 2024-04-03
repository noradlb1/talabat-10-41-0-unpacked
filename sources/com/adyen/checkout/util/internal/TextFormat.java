package com.adyen.checkout.util.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.SpannableStringBuilder;

public final class TextFormat {
    private static final int INDEXED_STRING_ARG_LENGTH = 4;
    private static final int STRING_ARG_LENGTH = 2;

    private TextFormat() {
        throw new IllegalStateException("No instances.");
    }

    @NonNull
    public static CharSequence format(@NonNull Context context, @StringRes int i11, @Nullable Object... objArr) {
        int i12;
        CharSequence charSequence;
        String string = context.getString(i11, objArr);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getText(i11));
        if (objArr != null) {
            for (CharSequence charSequence2 : objArr) {
                int indexOf = string.indexOf(charSequence2.toString());
                if (indexOf != -1) {
                    if (Character.isDigit(spannableStringBuilder.charAt(indexOf + 1))) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    int i13 = i12 + indexOf;
                    if (charSequence2 instanceof CharSequence) {
                        charSequence = charSequence2;
                    } else {
                        charSequence = charSequence2.toString();
                    }
                    spannableStringBuilder.replace(indexOf, i13, charSequence);
                }
            }
        }
        return spannableStringBuilder;
    }
}
