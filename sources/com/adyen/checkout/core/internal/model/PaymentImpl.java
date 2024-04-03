package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.Payment;
import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentImpl extends JsonObject implements Payment {
    @NonNull
    public static final Parcelable.Creator<PaymentImpl> CREATOR = new JsonObject.DefaultCreator(PaymentImpl.class);
    private AmountImpl mAmount = ((AmountImpl) b("amount", AmountImpl.class));
    private String mCountryCode;
    private String mReference;
    private String mReturnUrl;
    private Date mSessionValidity = c("sessionValidity");
    private String mShopperLocale;
    private String mShopperReference;

    private PaymentImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mCountryCode = jSONObject.getString("countryCode");
        this.mReference = jSONObject.getString("reference");
        this.mReturnUrl = jSONObject.getString("returnUrl");
        this.mShopperLocale = jSONObject.getString("shopperLocale");
        this.mShopperReference = jSONObject.optString("shopperReference", (String) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PaymentImpl.class != obj.getClass()) {
            return false;
        }
        PaymentImpl paymentImpl = (PaymentImpl) obj;
        String str = this.mCountryCode;
        if (str == null ? paymentImpl.mCountryCode != null : !str.equals(paymentImpl.mCountryCode)) {
            return false;
        }
        String str2 = this.mReference;
        if (str2 == null ? paymentImpl.mReference != null : !str2.equals(paymentImpl.mReference)) {
            return false;
        }
        Date date = this.mSessionValidity;
        if (date == null ? paymentImpl.mSessionValidity != null : !date.equals(paymentImpl.mSessionValidity)) {
            return false;
        }
        AmountImpl amountImpl = this.mAmount;
        if (amountImpl == null ? paymentImpl.mAmount != null : !amountImpl.equals(paymentImpl.mAmount)) {
            return false;
        }
        String str3 = this.mReturnUrl;
        if (str3 == null ? paymentImpl.mReturnUrl != null : !str3.equals(paymentImpl.mReturnUrl)) {
            return false;
        }
        String str4 = this.mShopperLocale;
        if (str4 == null ? paymentImpl.mShopperLocale != null : !str4.equals(paymentImpl.mShopperLocale)) {
            return false;
        }
        String str5 = this.mShopperReference;
        String str6 = paymentImpl.mShopperReference;
        if (str5 != null) {
            return str5.equals(str6);
        }
        if (str6 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getCountryCode() {
        return this.mCountryCode;
    }

    @NonNull
    public String getReference() {
        return this.mReference;
    }

    @NonNull
    public String getReturnUrl() {
        return this.mReturnUrl;
    }

    @NonNull
    public Date getSessionValidity() {
        return new Date(this.mSessionValidity.getTime());
    }

    @NonNull
    public String getShopperLocale() {
        return this.mShopperLocale;
    }

    @Nullable
    public String getShopperReference() {
        return this.mShopperReference;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        String str = this.mCountryCode;
        int i17 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i18 = i11 * 31;
        String str2 = this.mReference;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i19 = (i18 + i12) * 31;
        Date date = this.mSessionValidity;
        if (date != null) {
            i13 = date.hashCode();
        } else {
            i13 = 0;
        }
        int i21 = (i19 + i13) * 31;
        AmountImpl amountImpl = this.mAmount;
        if (amountImpl != null) {
            i14 = amountImpl.hashCode();
        } else {
            i14 = 0;
        }
        int i22 = (i21 + i14) * 31;
        String str3 = this.mReturnUrl;
        if (str3 != null) {
            i15 = str3.hashCode();
        } else {
            i15 = 0;
        }
        int i23 = (i22 + i15) * 31;
        String str4 = this.mShopperLocale;
        if (str4 != null) {
            i16 = str4.hashCode();
        } else {
            i16 = 0;
        }
        int i24 = (i23 + i16) * 31;
        String str5 = this.mShopperReference;
        if (str5 != null) {
            i17 = str5.hashCode();
        }
        return i24 + i17;
    }

    @NonNull
    public String toString() {
        return "Payment{CountryCode='" + this.mCountryCode + '\'' + ", Amount=" + this.mAmount + AbstractJsonLexerKt.END_OBJ;
    }

    @NonNull
    public AmountImpl getAmount() {
        return this.mAmount;
    }
}
