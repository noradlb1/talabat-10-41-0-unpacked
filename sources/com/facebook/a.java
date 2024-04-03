package com.facebook;

import com.facebook.AccessTokenManager;
import com.facebook.GraphRequest;

public final /* synthetic */ class a implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessTokenManager.RefreshResult f33575a;

    public /* synthetic */ a(AccessTokenManager.RefreshResult refreshResult) {
        this.f33575a = refreshResult;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        AccessTokenManager.m8857refreshCurrentAccessTokenImpl$lambda2(this.f33575a, graphResponse);
    }
}
