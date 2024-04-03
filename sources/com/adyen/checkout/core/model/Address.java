package com.adyen.checkout.core.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.base.internal.JsonSerializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class Address extends JsonObject implements JsonSerializable {
    @NonNull
    public static final Parcelable.Creator<Address> CREATOR = new JsonObject.DefaultCreator(Address.class);
    @NonNull
    public static final String KEY_CITY = "city";
    @NonNull
    public static final String KEY_COUNTRY = "country";
    @NonNull
    public static final String KEY_HOUSE_NUMBER_OR_NAME = "houseNumberOrName";
    @NonNull
    public static final String KEY_POSTAL_CODE = "postalCode";
    @NonNull
    public static final String KEY_STATE_OR_PROVINCE = "stateOrProvince";
    @NonNull
    public static final String KEY_STREET = "street";
    private String mCity;
    private String mCountry;
    private String mHouseNumberOrName;
    private String mPostalCode;
    private String mStateOrProvince;
    private String mStreet;

    public static final class Builder {
        private JSONObject mAddress;

        public Builder(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5) {
            JSONObject jSONObject = new JSONObject();
            this.mAddress = jSONObject;
            try {
                jSONObject.put(Address.KEY_STREET, (Object) str);
                this.mAddress.put(Address.KEY_HOUSE_NUMBER_OR_NAME, (Object) str2);
                this.mAddress.put(Address.KEY_CITY, (Object) str3);
                this.mAddress.put("country", (Object) str4);
                this.mAddress.put("postalCode", (Object) str5);
            } catch (JSONException e11) {
                throw new RuntimeException("Failed to create Address", e11);
            }
        }

        @NonNull
        public Address build() {
            try {
                return (Address) JsonObject.parseFrom(this.mAddress, Address.class);
            } catch (JSONException e11) {
                throw new RuntimeException("Failed to create Address", e11);
            }
        }

        @NonNull
        public Builder setStateOrProvince(@Nullable String str) {
            try {
                this.mAddress.put(Address.KEY_STATE_OR_PROVINCE, (Object) str);
                return this;
            } catch (JSONException e11) {
                throw new RuntimeException("Failed to create Address", e11);
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Address.class != obj.getClass()) {
            return false;
        }
        Address address = (Address) obj;
        String str = this.mStreet;
        if (str == null ? address.mStreet != null : !str.equals(address.mStreet)) {
            return false;
        }
        String str2 = this.mHouseNumberOrName;
        if (str2 == null ? address.mHouseNumberOrName != null : !str2.equals(address.mHouseNumberOrName)) {
            return false;
        }
        String str3 = this.mCity;
        if (str3 == null ? address.mCity != null : !str3.equals(address.mCity)) {
            return false;
        }
        String str4 = this.mCountry;
        if (str4 == null ? address.mCountry != null : !str4.equals(address.mCountry)) {
            return false;
        }
        String str5 = this.mPostalCode;
        if (str5 == null ? address.mPostalCode != null : !str5.equals(address.mPostalCode)) {
            return false;
        }
        String str6 = this.mStateOrProvince;
        String str7 = address.mStateOrProvince;
        if (str6 != null) {
            return str6.equals(str7);
        }
        if (str7 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getCity() {
        return this.mCity;
    }

    @NonNull
    public String getCountry() {
        return this.mCountry;
    }

    @NonNull
    public String getHouseNumberOrName() {
        return this.mHouseNumberOrName;
    }

    @NonNull
    public String getPostalCode() {
        return this.mPostalCode;
    }

    @Nullable
    public String getStateOrProvince() {
        return this.mStateOrProvince;
    }

    @NonNull
    public String getStreet() {
        return this.mStreet;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        String str = this.mStreet;
        int i16 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i17 = i11 * 31;
        String str2 = this.mHouseNumberOrName;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i18 = (i17 + i12) * 31;
        String str3 = this.mCity;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i19 = (i18 + i13) * 31;
        String str4 = this.mCountry;
        if (str4 != null) {
            i14 = str4.hashCode();
        } else {
            i14 = 0;
        }
        int i21 = (i19 + i14) * 31;
        String str5 = this.mPostalCode;
        if (str5 != null) {
            i15 = str5.hashCode();
        } else {
            i15 = 0;
        }
        int i22 = (i21 + i15) * 31;
        String str6 = this.mStateOrProvince;
        if (str6 != null) {
            i16 = str6.hashCode();
        }
        return i22 + i16;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_STREET, (Object) this.mStreet);
        jSONObject.put(KEY_HOUSE_NUMBER_OR_NAME, (Object) this.mHouseNumberOrName);
        jSONObject.put(KEY_CITY, (Object) this.mCity);
        jSONObject.put("country", (Object) this.mCountry);
        jSONObject.put("postalCode", (Object) this.mPostalCode);
        jSONObject.put(KEY_STATE_OR_PROVINCE, (Object) this.mStateOrProvince);
        return jSONObject;
    }
}
