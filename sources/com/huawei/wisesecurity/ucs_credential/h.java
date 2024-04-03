package com.huawei.wisesecurity.ucs_credential;

import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public a f44874a;

    /* renamed from: b  reason: collision with root package name */
    public b f44875b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f44876c;

    /* renamed from: d  reason: collision with root package name */
    public String f44877d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f44878a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f44879b;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f44880a;

        /* renamed from: b  reason: collision with root package name */
        public String f44881b;
    }

    public h(String str) throws UcsException {
        String[] split = str.split("\\.");
        a(split);
        b(split);
        a(str, split);
    }

    public void a(String str, String[] strArr) throws UcsException {
        try {
            this.f44876c = StringUtil.base64Decode(strArr[2], 8);
            this.f44877d = str.substring(0, str.lastIndexOf(RealDiscoveryConfigurationRepository.VERSION_DELIMETER));
        } catch (UcsException e11) {
            throw new UcsException(UcsErrorCode.VERIFY_JWS_ERROR, "Fail to convert jws string to Content, " + e11.getMessage());
        }
    }

    public void a(String[] strArr) throws UcsException {
        try {
            JSONObject jSONObject = new JSONObject(new String(StringUtil.base64Decode(strArr[0], 8), StandardCharsets.UTF_8));
            JSONArray optJSONArray = jSONObject.optJSONArray("x5c");
            String[] strArr2 = {optJSONArray.optString(0), optJSONArray.optString(1)};
            a aVar = new a();
            this.f44874a = aVar;
            aVar.f44878a = jSONObject.getString("alg");
            this.f44874a.f44879b = strArr2;
        } catch (RuntimeException e11) {
            throw new UcsException(UcsErrorCode.VERIFY_JWS_ERROR, "Fail to convert jws string to header, " + e11.getMessage());
        }
    }

    public void b(String[] strArr) throws UcsException {
        try {
            JSONObject jSONObject = new JSONObject(new String(StringUtil.base64Decode(strArr[1], 8), StandardCharsets.UTF_8));
            b bVar = new b();
            this.f44875b = bVar;
            bVar.f44881b = jSONObject.getString(FluidHomeScreenViewModel.METADATA_COMPONENT_KEY);
            this.f44875b.f44880a = jSONObject.getInt("version");
        } catch (RuntimeException e11) {
            throw new UcsException(UcsErrorCode.VERIFY_JWS_ERROR, "Fail to convert jws string to payload, " + e11.getMessage());
        }
    }
}
