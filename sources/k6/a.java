package k6;

import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccessTokenManager f34502b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AccessToken.AccessTokenRefreshCallback f34503c;

    public /* synthetic */ a(AccessTokenManager accessTokenManager, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        this.f34502b = accessTokenManager;
        this.f34503c = accessTokenRefreshCallback;
    }

    public final void run() {
        AccessTokenManager.m8855refreshCurrentAccessToken$lambda0(this.f34502b, this.f34503c);
    }
}
