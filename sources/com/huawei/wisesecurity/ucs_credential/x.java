package com.huawei.wisesecurity.ucs_credential;

import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class x {

    /* renamed from: a  reason: collision with root package name */
    public String f44904a;

    /* renamed from: b  reason: collision with root package name */
    public String f44905b;

    /* renamed from: c  reason: collision with root package name */
    public Certificate[] f44906c;

    public x(String str, Certificate[] certificateArr, String str2) {
        this.f44904a = str;
        this.f44905b = str2;
        this.f44906c = certificateArr;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("alg", (Object) this.f44904a);
            jSONObject.put("cty", (Object) this.f44905b);
            Certificate[] certificateArr = this.f44906c;
            int i11 = 3;
            if (certificateArr.length <= 3) {
                i11 = certificateArr.length;
            }
            for (int i12 = 0; i12 < i11; i12++) {
                jSONArray.put((Object) StringUtil.base64EncodeToString(this.f44906c[i12].getEncoded(), 2));
            }
            jSONObject.put("x5c", (Object) jSONArray);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("len", 32);
            jSONObject.put("kid", (Object) StringUtil.base64EncodeToString(JSONObjectInstrumentation.toString(jSONObject2).getBytes(StandardCharsets.UTF_8), 10));
            return StringUtil.base64EncodeToString(JSONObjectInstrumentation.toString(jSONObject).getBytes(StandardCharsets.UTF_8), 10);
        } catch (UcsException | CertificateEncodingException | JSONException e11) {
            LogUcs.e("CredentialJws", "generate TAHeader exception: {0}", e11.getMessage());
            return "";
        }
    }
}
