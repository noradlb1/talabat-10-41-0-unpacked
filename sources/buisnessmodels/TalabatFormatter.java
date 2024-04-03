package buisnessmodels;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationExtensionsKt;
import com.talabat.growth.ui.loyalty.views.LoyaltyPointsSummaryView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class TalabatFormatter {
    private static TalabatFormatter ourInstance = new TalabatFormatter();
    int countryId;
    String currencySymbol;
    int numberOfDecimalPlaces;

    public static TalabatFormatter getInstance() {
        return ourInstance;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public String getDecimalPattern() {
        return shouldCommaDecimalPatternApply() ? LoyaltyPointsSummaryView.COMMA_PATTERN : LocationExtensionsKt.DECIMAL_PATTERN_DEFAULT;
    }

    public String getFormattedCurrency(float f11) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(new Locale("en"));
        String decimalPattern = getDecimalPattern();
        for (int i11 = 0; i11 < this.numberOfDecimalPlaces; i11++) {
            decimalPattern = decimalPattern + "0";
        }
        decimalFormat.applyPattern(decimalPattern);
        return this.currencySymbol + " " + decimalFormat.format((double) f11);
    }

    public String getGemFormattedCurrency(float f11, boolean z11) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(new Locale("en"));
        if (!z11) {
            return decimalFormat.format((double) f11);
        }
        return decimalFormat.format((double) f11) + " " + getCurrencySymbol();
    }

    public float getRoundedAmount(float f11) {
        float parseFloat = Float.parseFloat(getFormattedCurrency(f11, false).replaceAll(",", ""));
        return parseFloat <= 0.0f ? f11 : parseFloat;
    }

    public void setFormat(String str, int i11, int i12) {
        this.currencySymbol = str;
        this.numberOfDecimalPlaces = i11;
        this.countryId = i12;
    }

    public boolean shouldCommaDecimalPatternApply() {
        return this.countryId == Country.IRAQ.getCountryId() && this.numberOfDecimalPlaces == 0;
    }

    public String getFormattedCurrency(float f11, boolean z11) {
        if (z11) {
            return getFormattedCurrency(f11);
        }
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(new Locale("en"));
        String decimalPattern = getDecimalPattern();
        for (int i11 = 0; i11 < this.numberOfDecimalPlaces; i11++) {
            decimalPattern = decimalPattern + "0";
        }
        decimalFormat.applyPattern(decimalPattern);
        return decimalFormat.format((double) f11);
    }
}
