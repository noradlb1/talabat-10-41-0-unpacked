package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public NetworkCapability f44862a;

    /* renamed from: b  reason: collision with root package name */
    public Context f44863b;

    /* renamed from: c  reason: collision with root package name */
    public String f44864c;

    /* renamed from: d  reason: collision with root package name */
    public String f44865d;

    /* renamed from: e  reason: collision with root package name */
    public String f44866e;

    /* renamed from: f  reason: collision with root package name */
    public String f44867f;

    /* renamed from: g  reason: collision with root package name */
    public CredentialClient f44868g;

    public b(CredentialClient credentialClient, Context context, NetworkCapability networkCapability) {
        this.f44868g = credentialClient;
        this.f44863b = context;
        this.f44862a = networkCapability;
    }

    public abstract Credential a(String str) throws UcsException;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048 A[Catch:{ JSONException -> 0x006e, IOException -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051 A[Catch:{ JSONException -> 0x006e, IOException -> 0x008c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.wisesecurity.ucs.credential.Credential a(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) throws com.huawei.wisesecurity.ucs.common.exception.UcsException {
        /*
            r3 = this;
            r0 = 0
            r3.f44864c = r4     // Catch:{ IOException -> 0x008c }
            r3.f44865d = r5     // Catch:{ IOException -> 0x008c }
            r3.f44866e = r6     // Catch:{ IOException -> 0x008c }
            r3.f44867f = r7     // Catch:{ IOException -> 0x008c }
            java.lang.String r1 = r3.a()     // Catch:{ IOException -> 0x008c }
            com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest r2 = new com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest     // Catch:{ IOException -> 0x008c }
            java.util.Map r5 = com.huawei.wisesecurity.ucs_credential.i.a(r5, r6, r7)     // Catch:{ IOException -> 0x008c }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x006e }
            r6.<init>()     // Catch:{ JSONException -> 0x006e }
            java.lang.String r7 = "request"
            r6.put((java.lang.String) r7, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x006e }
            java.lang.String r6 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r6)     // Catch:{ JSONException -> 0x006e }
            r2.<init>(r4, r5, r6)     // Catch:{ IOException -> 0x008c }
            com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability r4 = r3.f44862a     // Catch:{ IOException -> 0x008c }
            com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse r4 = r4.post(r2)     // Catch:{ IOException -> 0x008c }
            int r5 = r4.getCode()     // Catch:{ IOException -> 0x008c }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 < r6) goto L_0x0036
            r6 = 300(0x12c, float:4.2E-43)
            if (r5 < r6) goto L_0x0045
        L_0x0036:
            r6 = 400(0x190, float:5.6E-43)
            if (r5 == r6) goto L_0x0045
            r6 = 403(0x193, float:5.65E-43)
            if (r5 == r6) goto L_0x0045
            r6 = 500(0x1f4, float:7.0E-43)
            if (r5 != r6) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r5 = r0
            goto L_0x0046
        L_0x0045:
            r5 = 1
        L_0x0046:
            if (r5 == 0) goto L_0x0051
            java.lang.String r4 = r3.a((com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse) r4)     // Catch:{ IOException -> 0x008c }
            com.huawei.wisesecurity.ucs.credential.Credential r4 = r3.a((java.lang.String) r4)     // Catch:{ IOException -> 0x008c }
            return r4
        L_0x0051:
            com.huawei.wisesecurity.ucs.common.exception.UcsException r5 = new com.huawei.wisesecurity.ucs.common.exception.UcsException     // Catch:{ IOException -> 0x008c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008c }
            r6.<init>()     // Catch:{ IOException -> 0x008c }
            java.lang.String r7 = "tsms req error, return "
            r6.append(r7)     // Catch:{ IOException -> 0x008c }
            int r4 = r4.getCode()     // Catch:{ IOException -> 0x008c }
            r6.append(r4)     // Catch:{ IOException -> 0x008c }
            java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x008c }
            r6 = 1013(0x3f5, double:5.005E-321)
            r5.<init>(r6, r4)     // Catch:{ IOException -> 0x008c }
            throw r5     // Catch:{ IOException -> 0x008c }
        L_0x006e:
            r4 = move-exception
            com.huawei.wisesecurity.ucs.common.exception.UcsException r5 = new com.huawei.wisesecurity.ucs.common.exception.UcsException     // Catch:{ IOException -> 0x008c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008c }
            r6.<init>()     // Catch:{ IOException -> 0x008c }
            java.lang.String r7 = "getReqBody error : "
            r6.append(r7)     // Catch:{ IOException -> 0x008c }
            java.lang.String r4 = r4.getMessage()     // Catch:{ IOException -> 0x008c }
            r6.append(r4)     // Catch:{ IOException -> 0x008c }
            java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x008c }
            r6 = 1002(0x3ea, double:4.95E-321)
            r5.<init>(r6, r4)     // Catch:{ IOException -> 0x008c }
            throw r5     // Catch:{ IOException -> 0x008c }
        L_0x008c:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "get credential from TSMS fail : "
            r5.append(r6)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r6 = "ApplyCredentialHandler"
            com.huawei.wisesecurity.ucs.common.log.LogUcs.e(r6, r4, r5)
            com.huawei.wisesecurity.ucs.common.exception.UcsException r5 = new com.huawei.wisesecurity.ucs.common.exception.UcsException
            r6 = 1006(0x3ee, double:4.97E-321)
            r5.<init>(r6, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.ucs_credential.b.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.huawei.wisesecurity.ucs.credential.Credential");
    }

    public abstract String a() throws UcsException;

    public abstract String a(NetworkResponse networkResponse) throws UcsException;
}
