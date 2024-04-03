package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.GiroPayIssuer;
import org.json.JSONException;
import org.json.JSONObject;

public final class GiroPayIssuerImpl extends JsonObject implements GiroPayIssuer {
    @NonNull
    public static final Parcelable.Creator<GiroPayIssuerImpl> CREATOR = new JsonObject.DefaultCreator(GiroPayIssuerImpl.class);
    private static final String KEY_BANK_NAME = "bankName";
    private static final String KEY_BIC = "bic";
    private static final String KEY_BLZ = "blz";
    private String mBankName;
    private String mBic;
    private String mBlz;

    private GiroPayIssuerImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mBankName = jSONObject.getString(KEY_BANK_NAME);
        this.mBic = jSONObject.getString("bic");
        this.mBlz = jSONObject.getString(KEY_BLZ);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GiroPayIssuerImpl.class != obj.getClass()) {
            return false;
        }
        GiroPayIssuerImpl giroPayIssuerImpl = (GiroPayIssuerImpl) obj;
        String str = this.mBankName;
        if (str == null ? giroPayIssuerImpl.mBankName != null : !str.equals(giroPayIssuerImpl.mBankName)) {
            return false;
        }
        String str2 = this.mBic;
        if (str2 == null ? giroPayIssuerImpl.mBic != null : !str2.equals(giroPayIssuerImpl.mBic)) {
            return false;
        }
        String str3 = this.mBlz;
        String str4 = giroPayIssuerImpl.mBlz;
        if (str3 != null) {
            return str3.equals(str4);
        }
        if (str4 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getBankName() {
        return this.mBankName;
    }

    @NonNull
    public String getBic() {
        return this.mBic;
    }

    @NonNull
    public String getBlz() {
        return this.mBlz;
    }

    public int hashCode() {
        int i11;
        int i12;
        String str = this.mBankName;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = i11 * 31;
        String str2 = this.mBic;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        String str3 = this.mBlz;
        if (str3 != null) {
            i13 = str3.hashCode();
        }
        return i15 + i13;
    }
}
