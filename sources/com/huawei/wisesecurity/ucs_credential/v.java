package com.huawei.wisesecurity.ucs_credential;

import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

public class v {

    /* renamed from: a  reason: collision with root package name */
    public String f44890a;

    /* renamed from: b  reason: collision with root package name */
    public String f44891b;

    /* renamed from: c  reason: collision with root package name */
    public String f44892c;

    @Instrumented
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f44893a;

        public a(String str) {
            this.f44893a = str;
        }

        public String toString() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alg", (Object) this.f44893a);
                return StringUtil.base64EncodeToString(JSONObjectInstrumentation.toString(jSONObject).getBytes(StandardCharsets.UTF_8), 10);
            } catch (UcsException | JSONException e11) {
                LogUcs.e("AppAuthticationJws", "generate Header exception: {0}", e11.getMessage());
                return "";
            }
        }
    }

    @Instrumented
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f44894a;

        /* renamed from: b  reason: collision with root package name */
        public String f44895b;

        /* renamed from: c  reason: collision with root package name */
        public String f44896c;

        public b(String str, String str2, String str3) {
            this.f44894a = str;
            this.f44895b = str2;
            this.f44896c = str3;
        }

        public String toString() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pkgName", (Object) this.f44894a);
                jSONObject.put("certSig", (Object) this.f44895b);
                if (!TextUtils.isEmpty(this.f44896c)) {
                    jSONObject.put("extra", (Object) this.f44896c);
                }
                return StringUtil.base64EncodeToString(JSONObjectInstrumentation.toString(jSONObject).getBytes(StandardCharsets.UTF_8), 10);
            } catch (UcsException | JSONException e11) {
                LogUcs.e("AppAuthticationJws", "generate PayLoad exception: {0}", e11.getMessage());
                return "";
            }
        }
    }

    public String a() throws UcsException {
        if (TextUtils.isEmpty(this.f44890a) || TextUtils.isEmpty(this.f44891b) || TextUtils.isEmpty(this.f44892c)) {
            throw new UcsException(2001, "get  AppAuthtication JWS is empty...");
        }
        return b() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + this.f44892c;
    }

    public String b() throws UcsException {
        if (TextUtils.isEmpty(this.f44890a) || TextUtils.isEmpty(this.f44891b)) {
            throw new UcsException(2001, "Get AppAuthtication signStr error");
        }
        return this.f44890a + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + this.f44891b;
    }
}
