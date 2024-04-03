package com.huawei.wisesecurity.ucs.credential.entity;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class AccessKey {
    public static final String AKSK_VERSION = "akskVersion";
    public static final String APP_CERT_FP = "appCertFP";
    public static final String APP_PKG_NAME = "appPkgName";
    public int akskVersion;
    @KfsStringNotEmpty
    public String appCertFP;
    @KfsStringNotEmpty
    public String appPkgName;

    public static AccessKey fromString(String str) throws UcsException {
        try {
            AccessKey accessKey = new AccessKey();
            JSONObject jSONObject = new JSONObject(StringUtil.base64DecodeToString(str, 0));
            accessKey.akskVersion = jSONObject.optInt(AKSK_VERSION);
            accessKey.appPkgName = jSONObject.optString("appPkgName");
            accessKey.appCertFP = jSONObject.optString(APP_CERT_FP);
            if (accessKey.hasAkskVersion()) {
                KfsValidator.validate(accessKey);
            }
            return accessKey;
        } catch (JSONException e11) {
            throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "accessKey param is not a valid json string : " + e11.getMessage());
        } catch (KfsValidationException e12) {
            throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "accessKey param invalid : " + e12.getMessage());
        }
    }

    public int getAkskVersion() {
        return this.akskVersion;
    }

    public String getAppCertFP() {
        return this.appCertFP;
    }

    public String getAppPkgName() {
        return this.appPkgName;
    }

    public boolean hasAkskVersion() {
        return this.akskVersion >= 1;
    }
}
