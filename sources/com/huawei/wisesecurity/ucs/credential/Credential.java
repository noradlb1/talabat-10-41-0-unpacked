package com.huawei.wisesecurity.ucs.credential;

import android.content.Context;
import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsLongRange;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.entity.AccessKey;
import com.huawei.wisesecurity.ucs.credential.entity.KeyEncryptKey;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs_credential.e;
import com.huawei.wisesecurity.ucs_credential.s;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class Credential {
    public static final String AK = "accessKey";
    public static final String DK = "dataKey";
    public static final byte[] EMPTY_BYTES = new byte[0];
    public static final String EXPIRE_TIME = "expireTime";
    public static final String KEK = "kek";
    public static final String SK = "secretKey";
    public static final String TAG = "Credential";
    @KfsStringNotEmpty
    public String accessKey;

    /* renamed from: ak  reason: collision with root package name */
    public AccessKey f44852ak;
    @KfsStringNotEmpty
    public String dataKey;
    @KfsLongRange(max = Long.MAX_VALUE, min = 1)
    public long expireTime;
    public KeyEncryptKey kek;
    @KfsStringNotEmpty
    public String rawKek;
    @KfsStringNotEmpty
    public String secretKey;

    private byte[] base64DecodeForNative(String str) {
        try {
            return Decoder.BASE64.decode(str);
        } catch (CodecException unused) {
            return EMPTY_BYTES;
        }
    }

    public static Credential fromString(Context context, String str, s sVar) throws UcsException {
        String str2;
        try {
            Credential credential = new Credential();
            JSONObject jSONObject = new JSONObject(str);
            credential.secretKey = jSONObject.optString(SK);
            credential.dataKey = jSONObject.optString(DK);
            credential.accessKey = jSONObject.optString(AK);
            credential.rawKek = jSONObject.optString(KEK);
            credential.expireTime = jSONObject.optLong(EXPIRE_TIME);
            credential.kek = KeyEncryptKey.fromString(context, credential.rawKek);
            credential.checkParam();
            credential.f44852ak = AccessKey.fromString(credential.accessKey);
            sVar.linkedHashMap.put("credentialAppName", credential.getAppPkgName());
            sVar.linkedHashMap.put("akSkVersion", String.valueOf(credential.getAkskVersion()));
            if (credential.getKekVersion() == 3) {
                str2 = "AndroidKS";
            } else {
                str2 = "Kid";
            }
            sVar.linkedHashMap.put("cty", str2);
            if (credential.f44852ak.hasAkskVersion()) {
                UcsLib.checkNativeLibrary();
                if (!UcsLib.checkPkgNameCertFP(context, credential.f44852ak.getAppPkgName(), credential.f44852ak.getAppCertFP())) {
                    LogUcs.e(TAG, "check  AppPkgName appCertFP fail", new Object[0]);
                    throw new UcsException(1023, "check  AppPkgName appCertFP fail");
                }
            }
            e.a(credential).b(credential, context);
            return credential;
        } catch (JSONException e11) {
            LogUcs.e(TAG, "parse credentialStr get json exception : {0}", e11.getMessage());
            throw new UcsException(UcsErrorCode.JSON_ERROR, "parse credentialStr get json exception : " + e11.getMessage());
        } catch (UcsException e12) {
            LogUcs.e(TAG, "parse credentialStr get UCS exception : errorCode : {0} errorMsg : {1}", Long.valueOf(e12.getErrorCode()), e12.getMessage());
            throw e12;
        } catch (Exception e13) {
            String str3 = "parse credentialStr get exception : " + e13.getMessage();
            LogUcs.e(TAG, str3, new Object[0]);
            throw new UcsException(2001, str3);
        }
    }

    public void checkParam() throws UcsException {
        try {
            KfsValidator.validate(this);
        } catch (KfsValidationException e11) {
            throw new UcsParamException("credential get param exception : " + e11.getMessage());
        }
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public int getAkskVersion() {
        return this.f44852ak.getAkskVersion();
    }

    public int getAlg() {
        return this.kek.getAlg();
    }

    public String getAppCertFP() {
        return this.f44852ak.getAppCertFP();
    }

    public String getAppPkgName() {
        return this.f44852ak.getAppPkgName();
    }

    public String getDataKey() {
        return this.dataKey;
    }

    public byte[] getDataKeyBytes() {
        return base64DecodeForNative(this.dataKey);
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public int getKekAlg() {
        return this.kek.getKekAlg();
    }

    public byte[] getKekBytes() {
        return base64DecodeForNative(this.kek.getKey());
    }

    public String getKekString() {
        return this.kek.getKey();
    }

    public int getKekVersion() {
        return this.kek.getVersion();
    }

    public String getRawKek() {
        return this.rawKek;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public byte[] getSecretKeyBytes() {
        return base64DecodeForNative(this.secretKey);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SK, (Object) this.secretKey);
            jSONObject.put(AK, (Object) this.accessKey);
            jSONObject.put(DK, (Object) this.dataKey);
            jSONObject.put(KEK, (Object) this.rawKek);
            jSONObject.put(EXPIRE_TIME, this.expireTime);
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException e11) {
            LogUcs.e(TAG, "Credential toString exception : {0}", e11.getMessage());
            return "";
        }
    }
}
