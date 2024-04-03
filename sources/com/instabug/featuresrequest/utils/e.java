package com.instabug.featuresrequest.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public abstract class e {
    public static String a(String str) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(AbstractJsonLexerKt.COMMA);
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return decimalFormat.format((long) Integer.parseInt(str));
    }
}
