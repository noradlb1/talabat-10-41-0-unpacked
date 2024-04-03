package com.adyen.checkout.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import com.adyen.checkout.core.model.Amount;
import com.adyen.checkout.util.internal.CheckoutCurrency;
import com.adyen.checkout.util.internal.TextFormat;
import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

public final class AmountFormat {
    private static final String TAG = "AmountFormat";

    public static final class TopAlignSuperscriptSpan extends SuperscriptSpan {
        private static final float SCALE_PERCENTAGE = 0.7f;
        private static final float SHIFT_PERCENTAGE = 0.1f;

        private TopAlignSuperscriptSpan() {
        }

        private void updateState(@NonNull TextPaint textPaint) {
            float ascent = textPaint.ascent();
            textPaint.setTextSize(textPaint.getTextSize() * 0.7f);
            float f11 = textPaint.getFontMetrics().ascent;
            textPaint.baselineShift = (int) (((float) textPaint.baselineShift) + ((ascent - (ascent * 0.1f)) - (f11 - (0.1f * f11))));
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            updateState(textPaint);
        }

        public void updateMeasureState(@NonNull TextPaint textPaint) {
            updateState(textPaint);
        }
    }

    private AmountFormat() {
        throw new IllegalStateException("No instances.");
    }

    @NonNull
    public static CharSequence format(@NonNull Context context, @NonNull Amount amount) {
        return format(context, amount.getValue(), amount.getCurrency());
    }

    @NonNull
    private static String getCurrencySymbol(@NonNull Locale locale, @NonNull String str) {
        try {
            String symbol = Currency.getInstance(str).getSymbol(locale);
            if (!str.equals(symbol)) {
                return symbol;
            }
            throw new IllegalArgumentException("Missing currency symbol for " + str);
        } catch (IllegalArgumentException | NullPointerException unused) {
            String str2 = TAG;
            Log.e(str2, "Could not determine currency symbol for " + str);
            return str;
        }
    }

    private static int getFractionDigits(@NonNull String str) {
        String upperCase = str.replaceAll("[^A-Z]", "").toUpperCase(Locale.US);
        try {
            return CheckoutCurrency.valueOf(upperCase).getFractionDigits();
        } catch (IllegalArgumentException unused) {
            String str2 = TAG;
            Log.e(str2, upperCase + " is an unsupported currency. Falling back to information from java.util.Currency.");
            try {
                return Math.max(Currency.getInstance(upperCase).getDefaultFractionDigits(), 0);
            } catch (IllegalArgumentException | NullPointerException e11) {
                String str3 = TAG;
                Log.e(str3, "Could not determine fraction digits for " + upperCase, e11);
                return 0;
            }
        }
    }

    @NonNull
    public static CharSequence getStringWithFormattedAmounts(@NonNull Context context, @StringRes int i11, @Nullable Object... objArr) {
        Object[] objArr2;
        if (objArr != null) {
            objArr2 = Arrays.copyOf(objArr, objArr.length);
        } else {
            objArr2 = null;
        }
        if (objArr2 != null) {
            for (int i12 = 0; i12 < objArr2.length; i12++) {
                Object obj = objArr2[i12];
                if (obj instanceof Amount) {
                    objArr2[i12] = format(context, (Amount) obj);
                }
            }
        }
        return TextFormat.format(context, i11, objArr2);
    }

    @NonNull
    public static BigDecimal toBigDecimal(@NonNull Amount amount) {
        return toBigDecimal(amount.getValue(), amount.getCurrency());
    }

    @NonNull
    public static CharSequence format(@NonNull Context context, long j11, @NonNull String str) {
        CharSequence charSequence;
        Locale locale = LocaleUtil.getLocale(context);
        BigDecimal bigDecimal = toBigDecimal(j11, str);
        int scale = bigDecimal.scale();
        try {
            Currency instance = Currency.getInstance(str);
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
            currencyInstance.setCurrency(instance);
            currencyInstance.setMinimumFractionDigits(scale);
            currencyInstance.setMaximumFractionDigits(scale);
            charSequence = currencyInstance.format(bigDecimal);
        } catch (IllegalArgumentException | NullPointerException e11) {
            String str2 = TAG;
            Log.e(str2, "Could not determine currency for code." + str, e11);
            NumberFormat instance2 = NumberFormat.getInstance(locale);
            instance2.setMinimumFractionDigits(scale);
            instance2.setMaximumFractionDigits(scale);
            String format = instance2.format(bigDecimal);
            charSequence = new SpannableStringBuilder(context.getString(R.string.amount_format, new Object[]{str, format}));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        String[] split = spannableStringBuilder.toString().split(String.format("\\%s", new Object[]{String.valueOf(DecimalFormatSymbols.getInstance(locale).getDecimalSeparator())}));
        if (split.length == 2) {
            int length = split[0].length() + 1;
            int i11 = scale + length;
            if (i11 > spannableStringBuilder.length()) {
                i11 = length + split[1].length();
            }
            spannableStringBuilder.setSpan(new TopAlignSuperscriptSpan(), length, i11, 33);
        }
        return spannableStringBuilder;
    }

    @NonNull
    public static BigDecimal toBigDecimal(long j11, @NonNull String str) {
        return BigDecimal.valueOf(j11, getFractionDigits(str));
    }
}
