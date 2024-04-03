package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public Context f44907a;

    /* renamed from: b  reason: collision with root package name */
    public NetworkCapability f44908b;

    /* renamed from: c  reason: collision with root package name */
    public String f44909c;

    /* renamed from: d  reason: collision with root package name */
    public l f44910d;

    /* renamed from: e  reason: collision with root package name */
    public j f44911e;

    /* renamed from: f  reason: collision with root package name */
    public CredentialClient f44912f;

    /* renamed from: g  reason: collision with root package name */
    public String f44913g;

    public y(CredentialClient credentialClient, Context context, NetworkCapability networkCapability, l lVar, String str) {
        this.f44912f = credentialClient;
        this.f44907a = context;
        this.f44908b = networkCapability;
        this.f44909c = str;
        this.f44910d = lVar;
        this.f44911e = new j(context, lVar, networkCapability);
    }

    public Credential a(String str, String str2) throws UcsException {
        try {
            this.f44913g = "AndroidKS";
            return new c(this.f44912f, this.f44907a, this.f44908b).a(this.f44910d.b(), this.f44909c, str, str2);
        } catch (Throwable th2) {
            this.f44913g = "Kid";
            LogUcs.e("CredentialManager", "applyCredential use KeyStoreHandler get exception: " + th2.getMessage(), new Object[0]);
            return new d(this.f44912f, this.f44907a, this.f44908b, this.f44911e).a(this.f44910d.b(), this.f44909c, str, str2);
        }
    }
}
