package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.Card;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public final class CardImpl extends JsonObject implements Card {
    @NonNull
    public static final Parcelable.Creator<CardImpl> CREATOR = new JsonObject.DefaultCreator(CardImpl.class);
    private Integer mExpiryMonth;
    private Integer mExpiryYear;
    private String mHolderName;
    private String mNumber;

    private CardImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mHolderName = jSONObject.getString("holderName");
        this.mExpiryMonth = Integer.valueOf(jSONObject.getInt(CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY));
        this.mExpiryYear = Integer.valueOf(jSONObject.getInt(CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY));
        this.mNumber = jSONObject.getString(CardTokenizationPlugin.ARG_NUMBER_KEY);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CardImpl.class != obj.getClass()) {
            return false;
        }
        CardImpl cardImpl = (CardImpl) obj;
        String str = this.mHolderName;
        if (str == null ? cardImpl.mHolderName != null : !str.equals(cardImpl.mHolderName)) {
            return false;
        }
        Integer num = this.mExpiryMonth;
        if (num == null ? cardImpl.mExpiryMonth != null : !num.equals(cardImpl.mExpiryMonth)) {
            return false;
        }
        Integer num2 = this.mExpiryYear;
        if (num2 == null ? cardImpl.mExpiryYear != null : !num2.equals(cardImpl.mExpiryYear)) {
            return false;
        }
        String str2 = this.mNumber;
        String str3 = cardImpl.mNumber;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int getExpiryMonth() {
        return this.mExpiryMonth.intValue();
    }

    public int getExpiryYear() {
        return this.mExpiryYear.intValue();
    }

    @NonNull
    public String getHolderName() {
        return this.mHolderName;
    }

    @NonNull
    public String getLastFourDigits() {
        return this.mNumber;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        String str = this.mHolderName;
        int i14 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i15 = i11 * 31;
        Integer num = this.mExpiryMonth;
        if (num != null) {
            i12 = num.hashCode();
        } else {
            i12 = 0;
        }
        int i16 = (i15 + i12) * 31;
        Integer num2 = this.mExpiryYear;
        if (num2 != null) {
            i13 = num2.hashCode();
        } else {
            i13 = 0;
        }
        int i17 = (i16 + i13) * 31;
        String str2 = this.mNumber;
        if (str2 != null) {
            i14 = str2.hashCode();
        }
        return i17 + i14;
    }

    @NonNull
    public String toString() {
        return "Card{Number='" + this.mNumber + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
