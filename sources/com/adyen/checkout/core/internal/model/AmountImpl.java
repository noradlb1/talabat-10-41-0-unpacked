package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.Amount;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public final class AmountImpl extends JsonObject implements Amount {
    @NonNull
    public static final Parcelable.Creator<AmountImpl> CREATOR = new JsonObject.DefaultCreator(AmountImpl.class);
    private final String mCurrency;
    private final long mValue;

    private AmountImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mValue = jSONObject.getLong("value");
        this.mCurrency = jSONObject.getString("currency");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AmountImpl.class != obj.getClass()) {
            return false;
        }
        AmountImpl amountImpl = (AmountImpl) obj;
        if (this.mValue != amountImpl.mValue) {
            return false;
        }
        String str = this.mCurrency;
        String str2 = amountImpl.mCurrency;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getCurrency() {
        return this.mCurrency;
    }

    public long getValue() {
        return this.mValue;
    }

    public int hashCode() {
        int i11;
        int hashCode = Long.valueOf(this.mValue).hashCode() * 31;
        String str = this.mCurrency;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        return hashCode + i11;
    }

    @NonNull
    public String toString() {
        return "Amount{Value=" + this.mValue + ", Currency='" + this.mCurrency + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
