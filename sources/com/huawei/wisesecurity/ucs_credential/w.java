package com.huawei.wisesecurity.ucs_credential;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs.credential.entity.AccessKey;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class w {

    /* renamed from: a  reason: collision with root package name */
    public int f44897a;

    /* renamed from: b  reason: collision with root package name */
    public int f44898b;

    /* renamed from: c  reason: collision with root package name */
    public String f44899c;

    /* renamed from: d  reason: collision with root package name */
    public String f44900d;

    /* renamed from: e  reason: collision with root package name */
    public int f44901e;

    /* renamed from: f  reason: collision with root package name */
    public String f44902f;

    /* renamed from: g  reason: collision with root package name */
    public String f44903g;

    public w(int i11, int i12, String str, String str2, int i13, String str3, String str4) {
        this.f44897a = i11;
        this.f44898b = i12;
        this.f44899c = str;
        this.f44900d = str2;
        this.f44901e = i13;
        this.f44902f = str3;
        this.f44903g = str4;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("alg", this.f44897a);
            jSONObject.put("kekAlg", this.f44898b);
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, (Object) this.f44899c);
            jSONObject.put("appId", (Object) this.f44900d);
            jSONObject.put(AccessKey.AKSK_VERSION, this.f44901e);
            jSONObject.put("appPkgName", (Object) this.f44902f);
            jSONObject.put(AccessKey.APP_CERT_FP, (Object) this.f44903g);
            return StringUtil.base64EncodeToString(JSONObjectInstrumentation.toString(jSONObject).getBytes(StandardCharsets.UTF_8), 10);
        } catch (UcsException | JSONException e11) {
            LogUcs.e("CredentialJws", "generate payload exception: {0}", e11.getMessage());
            return "";
        }
    }
}
