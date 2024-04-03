package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.WeChatPaySdkRedirectData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

public final class WeChatPaySdkRedirectDataImpl extends JsonObject implements WeChatPaySdkRedirectData {
    @NonNull
    public static final Parcelable.Creator<WeChatPaySdkRedirectDataImpl> CREATOR = new JsonObject.DefaultCreator(WeChatPaySdkRedirectDataImpl.class);
    private final String mAppId;
    private final String mNonceStr;
    private final String mPackageValue;
    private final String mPartnerId;
    private final String mPrepayId;
    private final String mSignature;
    private final String mTimestamp;

    private WeChatPaySdkRedirectDataImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mAppId = jSONObject.getString(HiAnalyticsConstant.HaKey.BI_KEY_APPID);
        this.mPartnerId = jSONObject.getString("partnerid");
        this.mPrepayId = jSONObject.getString("prepayid");
        this.mTimestamp = jSONObject.getString("timestamp");
        this.mPackageValue = jSONObject.getString("package");
        this.mNonceStr = jSONObject.getString("noncestr");
        this.mSignature = jSONObject.getString("sign");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WeChatPaySdkRedirectDataImpl.class != obj.getClass()) {
            return false;
        }
        WeChatPaySdkRedirectDataImpl weChatPaySdkRedirectDataImpl = (WeChatPaySdkRedirectDataImpl) obj;
        String str = this.mAppId;
        if (str == null ? weChatPaySdkRedirectDataImpl.mAppId != null : !str.equals(weChatPaySdkRedirectDataImpl.mAppId)) {
            return false;
        }
        String str2 = this.mPartnerId;
        if (str2 == null ? weChatPaySdkRedirectDataImpl.mPartnerId != null : !str2.equals(weChatPaySdkRedirectDataImpl.mPartnerId)) {
            return false;
        }
        String str3 = this.mPrepayId;
        if (str3 == null ? weChatPaySdkRedirectDataImpl.mPrepayId != null : !str3.equals(weChatPaySdkRedirectDataImpl.mPrepayId)) {
            return false;
        }
        String str4 = this.mTimestamp;
        if (str4 == null ? weChatPaySdkRedirectDataImpl.mTimestamp != null : !str4.equals(weChatPaySdkRedirectDataImpl.mTimestamp)) {
            return false;
        }
        String str5 = this.mPackageValue;
        if (str5 == null ? weChatPaySdkRedirectDataImpl.mPackageValue != null : !str5.equals(weChatPaySdkRedirectDataImpl.mPackageValue)) {
            return false;
        }
        String str6 = this.mNonceStr;
        if (str6 == null ? weChatPaySdkRedirectDataImpl.mNonceStr != null : !str6.equals(weChatPaySdkRedirectDataImpl.mNonceStr)) {
            return false;
        }
        String str7 = this.mSignature;
        String str8 = weChatPaySdkRedirectDataImpl.mSignature;
        if (str7 != null) {
            return str7.equals(str8);
        }
        if (str8 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getAppId() {
        return this.mAppId;
    }

    @NonNull
    public String getNonceStr() {
        return this.mNonceStr;
    }

    @NonNull
    public String getPackageValue() {
        return this.mPackageValue;
    }

    @NonNull
    public String getPartnerId() {
        return this.mPartnerId;
    }

    @NonNull
    public String getPrepayId() {
        return this.mPrepayId;
    }

    @NonNull
    public String getSignature() {
        return this.mSignature;
    }

    @NonNull
    public String getTimestamp() {
        return this.mTimestamp;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        String str = this.mAppId;
        int i17 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i18 = i11 * 31;
        String str2 = this.mPartnerId;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i19 = (i18 + i12) * 31;
        String str3 = this.mPrepayId;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i21 = (i19 + i13) * 31;
        String str4 = this.mTimestamp;
        if (str4 != null) {
            i14 = str4.hashCode();
        } else {
            i14 = 0;
        }
        int i22 = (i21 + i14) * 31;
        String str5 = this.mPackageValue;
        if (str5 != null) {
            i15 = str5.hashCode();
        } else {
            i15 = 0;
        }
        int i23 = (i22 + i15) * 31;
        String str6 = this.mNonceStr;
        if (str6 != null) {
            i16 = str6.hashCode();
        } else {
            i16 = 0;
        }
        int i24 = (i23 + i16) * 31;
        String str7 = this.mSignature;
        if (str7 != null) {
            i17 = str7.hashCode();
        }
        return i24 + i17;
    }
}
