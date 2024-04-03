package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.ErrorBody;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends b {

    /* renamed from: h  reason: collision with root package name */
    public j f44872h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44873i = true;

    public d(CredentialClient credentialClient, Context context, NetworkCapability networkCapability, j jVar) throws UcsException {
        super(credentialClient, context, networkCapability);
        this.f44872h = jVar;
        jVar.a();
    }

    public String a() throws UcsException {
        int i11 = SpUtil.getInt("Local-C1-Version", -1, this.f44863b);
        LogUcs.d("KidHandler", "c1 version is " + i11 + ", so version is " + ((int) UcsLib.ucsGetSoVersion()), new Object[0]);
        return new String(UcsLib.genReqJws(this.f44863b, this.f44865d, this.f44866e, 0, i11), StandardCharsets.UTF_8);
    }

    public String a(NetworkResponse networkResponse) throws UcsException {
        boolean isSuccessful = networkResponse.isSuccessful();
        String body = networkResponse.getBody();
        if (isSuccessful) {
            return body;
        }
        ErrorBody fromString = ErrorBody.fromString(body);
        String str = "tsms service error, " + fromString.getErrorMessage();
        LogUcs.e("KidHandler", str, new Object[0]);
        throw new UcsException(1024, str);
    }

    public Credential a(String str) throws UcsException {
        try {
            int parseInt = Integer.parseInt(new JSONObject(str).getString("expire"));
            if (parseInt == 0) {
                return this.f44868g.genCredentialFromString(str);
            }
            if (parseInt != 1) {
                if (parseInt != 2) {
                    throw new UcsException(1017, "unenable expire.");
                }
                throw new UcsException(1016, "so version is unenable.");
            } else if (this.f44873i) {
                LogUcs.d("KidHandler", "c1 version expired, start to force update c1!", new Object[0]);
                this.f44872h.a(true, new k());
                this.f44873i = false;
                return a(this.f44864c, this.f44865d, this.f44866e, this.f44867f);
            } else {
                throw new UcsException(1021, "c1 vision is unenable.");
            }
        } catch (JSONException e11) {
            throw new UcsException(UcsErrorCode.JSON_ERROR, "parse TSMS resp get json error : " + e11.getMessage());
        } catch (NumberFormatException e12) {
            throw new UcsException(2001, "parse TSMS resp expire error : " + e12.getMessage());
        }
    }
}
