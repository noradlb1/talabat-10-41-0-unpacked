package com.huawei.wisesecurity.ucs.credential.entity;

import android.content.Context;
import com.huawei.hms.feature.dynamic.b;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIntegerRange;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs_credential.i;
import com.huawei.wisesecurity.ucs_credential.k;
import org.json.JSONException;
import org.json.JSONObject;

public class KeyEncryptKey {
    public static final int KEK_ALG_GCM = 1;
    @KfsIntegerRange(max = 2, min = 0)
    public int alg;
    @KfsIntegerRange(max = 1, min = 0)
    public int kekAlg;
    @KfsStringNotEmpty
    public String key;

    /* renamed from: v1  reason: collision with root package name */
    public int f44857v1;

    /* renamed from: v2  reason: collision with root package name */
    public int f44858v2;
    public int version;

    private void checkVersion(Context context) throws UcsException {
        UcsLib.checkNativeLibrary();
        int i11 = SpUtil.getInt("Local-C1-Version", -1, context);
        if (this.f44857v1 != ((int) UcsLib.ucsGetSoVersion())) {
            throw new UcsException(1020, "kek V1 with so version check fail,  please reapply the credential.");
        } else if (this.f44858v2 != i11) {
            throw new UcsException(1020, "kek V2 with C1 version check fail,  please reapply the credential.");
        } else if (!UcsLib.isRootKeyUpdated()) {
            i.a(context, new k());
        }
    }

    public static KeyEncryptKey fromString(Context context, String str) throws UcsException {
        try {
            KeyEncryptKey keyEncryptKey = new KeyEncryptKey();
            boolean z11 = false;
            JSONObject jSONObject = new JSONObject(StringUtil.base64DecodeToString(str, 0));
            keyEncryptKey.version = jSONObject.getInt("version");
            keyEncryptKey.alg = jSONObject.getInt("alg");
            keyEncryptKey.kekAlg = jSONObject.getInt("kekAlg");
            keyEncryptKey.key = jSONObject.getString("key");
            keyEncryptKey.f44857v1 = jSONObject.optInt("v1");
            keyEncryptKey.f44858v2 = jSONObject.optInt(b.f48777t);
            if (keyEncryptKey.version == 3) {
                z11 = true;
            }
            KfsValidator.validate(keyEncryptKey);
            if (!z11) {
                keyEncryptKey.checkVersion(context);
            }
            if (keyEncryptKey.kekAlg == 1) {
                return keyEncryptKey;
            }
            throw new UcsException(1020, "unsupported kek alg");
        } catch (JSONException e11) {
            throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "kek param is not a valid json string : " + e11.getMessage());
        } catch (KfsValidationException e12) {
            throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "kek param invalid : " + e12.getMessage());
        }
    }

    public int getAlg() {
        return this.alg;
    }

    public int getKekAlg() {
        return this.kekAlg;
    }

    public String getKey() {
        return this.key;
    }

    public int getV1() {
        return this.f44857v1;
    }

    public int getV2() {
        return this.f44858v2;
    }

    public int getVersion() {
        return this.version;
    }
}
