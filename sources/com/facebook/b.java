package com.facebook;

import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.facebook.GraphRequestBatch;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class b implements GraphRequestBatch.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessTokenManager.RefreshResult f33583a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccessToken f33584b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AccessToken.AccessTokenRefreshCallback f33585c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f33586d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Set f33587e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Set f33588f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Set f33589g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AccessTokenManager f33590h;

    public /* synthetic */ b(AccessTokenManager.RefreshResult refreshResult, AccessToken accessToken, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, AccessTokenManager accessTokenManager) {
        this.f33583a = refreshResult;
        this.f33584b = accessToken;
        this.f33585c = accessTokenRefreshCallback;
        this.f33586d = atomicBoolean;
        this.f33587e = set;
        this.f33588f = set2;
        this.f33589g = set3;
        this.f33590h = accessTokenManager;
    }

    public final void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        AccessTokenManager.m8858refreshCurrentAccessTokenImpl$lambda3(this.f33583a, this.f33584b, this.f33585c, this.f33586d, this.f33587e, this.f33588f, this.f33589g, this.f33590h, graphRequestBatch);
    }
}
