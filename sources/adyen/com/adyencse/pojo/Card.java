package adyen.com.adyencse.pojo;

import adyen.com.adyencse.encrypter.ClientSideEncrypter;
import adyen.com.adyencse.encrypter.exception.EncrypterException;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.bytebuddy.pool.TypePool;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class Card {
    private static final SimpleDateFormat GENERATION_DATE_FORMAT;
    private static final String tag = "Card";
    /* access modifiers changed from: private */
    public String cardHolderName;
    /* access modifiers changed from: private */
    public String cvc;
    /* access modifiers changed from: private */
    public String expiryMonth;
    /* access modifiers changed from: private */
    public String expiryYear;
    /* access modifiers changed from: private */
    public Date generationTime;
    /* access modifiers changed from: private */
    public String number;

    public static final class Builder {
        private final Card card = new Card();

        private String removeWhiteSpaces(String str) {
            if (str != null) {
                return str.replaceAll("\\s", "");
            }
            return null;
        }

        private void require(boolean z11, String str) throws IllegalStateException {
            if (!z11) {
                throw new IllegalStateException(str);
            }
        }

        private void requireNonNull(Object obj, String str) throws IllegalStateException {
            if (obj == null) {
                throw new NullPointerException(String.format("%s may not be null.", new Object[]{str}));
            }
        }

        private String trimAndRemoveMultipleWhiteSpaces(String str) {
            if (str != null) {
                return str.trim().replaceAll("\\s{2,}", " ");
            }
            return null;
        }

        public Card build() throws NullPointerException, IllegalStateException {
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            requireNonNull(this.card.generationTime, "generationTime");
            boolean z15 = false;
            if (this.card.number == null || this.card.number.matches("[0-9]{8,19}")) {
                z11 = true;
            } else {
                z11 = false;
            }
            require(z11, "number must be null or have 8 to 19 digits (inclusive).");
            if (this.card.cardHolderName == null || this.card.cardHolderName.length() > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            require(z12, "cardHolderName must be null or not empty.");
            if (this.card.cvc == null || this.card.cvc.matches("[0-9]{3,4}")) {
                z13 = true;
            } else {
                z13 = false;
            }
            require(z13, "cvc must be null or have 3 to 4 digits.");
            if (this.card.expiryMonth == null || this.card.expiryMonth.matches("0?[1-9]|1[0-2]")) {
                z14 = true;
            } else {
                z14 = false;
            }
            require(z14, "expiryMonth must be null or between 1 and 12.");
            if (this.card.expiryYear == null || this.card.expiryYear.matches("20\\d{2}")) {
                z15 = true;
            }
            require(z15, "expiryYear must be in the second millennium and first century.");
            return this.card;
        }

        public Builder setCvc(String str) {
            String unused = this.card.cvc = removeWhiteSpaces(str);
            return this;
        }

        public Builder setExpiryMonth(String str) {
            String unused = this.card.expiryMonth = removeWhiteSpaces(str);
            return this;
        }

        public Builder setExpiryYear(String str) {
            String unused = this.card.expiryYear = removeWhiteSpaces(str);
            return this;
        }

        public Builder setGenerationTime(Date date) {
            Date unused = this.card.generationTime = date;
            return this;
        }

        public Builder setHolderName(String str) {
            String unused = this.card.cardHolderName = trimAndRemoveMultipleWhiteSpaces(str);
            return this;
        }

        public Builder setNumber(String str) {
            String unused = this.card.number = removeWhiteSpaces(str);
            return this;
        }
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        GENERATION_DATE_FORMAT = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
    }

    private String encryptData(String str, String str2) throws EncrypterException {
        try {
            return new ClientSideEncrypter(str2).encrypt(str);
        } catch (EncrypterException e11) {
            throw e11;
        }
    }

    private String getLastFourDigitsFromCardNumber(String str) {
        if (str == null || str.length() < 14) {
            return "";
        }
        return str.substring(str.length() - 4);
    }

    private String getMaskingChars(int i11) {
        int i12 = i11 - 4;
        if (i12 <= 0) {
            return "";
        }
        char[] cArr = new char[i12];
        while (i12 > 0) {
            i12--;
            cArr[i12] = TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH;
        }
        return new String(cArr);
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public String getCvc() {
        return this.cvc;
    }

    public String getExpiryMonth() {
        return this.expiryMonth;
    }

    public String getExpiryYear() {
        return this.expiryYear;
    }

    public Date getGenerationTime() {
        return this.generationTime;
    }

    public String getNumber() {
        return this.number;
    }

    public String serialize(String str) throws EncrypterException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("generationtime", (Object) GENERATION_DATE_FORMAT.format(this.generationTime));
            jSONObject.put(CardTokenizationPlugin.ARG_NUMBER_KEY, (Object) this.number);
            jSONObject.put("holderName", (Object) this.cardHolderName);
            jSONObject.put("cvc", (Object) this.cvc);
            jSONObject.put(CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY, (Object) this.expiryMonth);
            jSONObject.put(CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY, (Object) this.expiryYear);
            return encryptData(JSONObjectInstrumentation.toString(jSONObject), str);
        } catch (JSONException e11) {
            Log.e(tag, e11.getMessage(), e11);
            return null;
        }
    }

    @Deprecated
    public void setCardHolderName(String str) {
        this.cardHolderName = str;
    }

    @Deprecated
    public void setCvc(String str) {
        this.cvc = str;
    }

    @Deprecated
    public void setExpiryMonth(String str) {
        this.expiryMonth = str;
    }

    @Deprecated
    public void setExpiryYear(String str) {
        this.expiryYear = str;
    }

    @Deprecated
    public void setGenerationTime(Date date) {
        this.generationTime = date;
    }

    @Deprecated
    public void setNumber(String str) {
        this.number = str;
    }

    public String toMaskedCardNumber() {
        String str = this.number;
        if (str == null || str.length() < 14) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(this.number.length());
        sb2.append(getMaskingChars(this.number.length()));
        sb2.append(getLastFourDigitsFromCardNumber(this.number));
        return sb2.toString();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("generationtime", (Object) GENERATION_DATE_FORMAT.format(this.generationTime));
            if (this.number.length() >= 4) {
                jSONObject.put(CardTokenizationPlugin.ARG_NUMBER_KEY, (Object) this.number.substring(0, 3));
            }
            jSONObject.put("holderName", (Object) this.cardHolderName);
        } catch (JSONException e11) {
            Log.e(tag, e11.getMessage(), e11);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
