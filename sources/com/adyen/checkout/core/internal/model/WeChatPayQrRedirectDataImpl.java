package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.WeChatPayQrRedirectData;
import org.json.JSONException;
import org.json.JSONObject;

public final class WeChatPayQrRedirectDataImpl extends JsonObject implements WeChatPayQrRedirectData {
    @NonNull
    public static final Parcelable.Creator<WeChatPayQrRedirectDataImpl> CREATOR = new JsonObject.DefaultCreator(WeChatPayQrRedirectDataImpl.class);
    private final String mQrCodeImage;
    private final String mQrCodeUrl;

    private WeChatPayQrRedirectDataImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mQrCodeImage = jSONObject.getString("qrCodeImage");
        this.mQrCodeUrl = jSONObject.getString("qrCodeUrl");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WeChatPayQrRedirectDataImpl.class != obj.getClass()) {
            return false;
        }
        WeChatPayQrRedirectDataImpl weChatPayQrRedirectDataImpl = (WeChatPayQrRedirectDataImpl) obj;
        String str = this.mQrCodeImage;
        if (str == null ? weChatPayQrRedirectDataImpl.mQrCodeImage != null : !str.equals(weChatPayQrRedirectDataImpl.mQrCodeImage)) {
            return false;
        }
        String str2 = this.mQrCodeUrl;
        String str3 = weChatPayQrRedirectDataImpl.mQrCodeUrl;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getQrCodeUrl() {
        return this.mQrCodeImage;
    }

    @NonNull
    public String getRedirectTargetUrl() {
        return this.mQrCodeUrl;
    }

    public int hashCode() {
        int i11;
        String str = this.mQrCodeImage;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        String str2 = this.mQrCodeUrl;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }
}
