package com.talabat.core.facebook.login.data.impl;

import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.talabat.core.facebook.login.data.FacebookAccessTokenProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/core/facebook/login/data/impl/FacebookAccessTokenProviderImpl;", "Lcom/talabat/core/facebook/login/data/FacebookAccessTokenProvider;", "accessTokenManager", "Lcom/facebook/AccessTokenManager;", "(Lcom/facebook/AccessTokenManager;)V", "getAccessTokenOrNull", "Lcom/facebook/AccessToken;", "isCurrentAccessTokenActive", "", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FacebookAccessTokenProviderImpl implements FacebookAccessTokenProvider {
    @NotNull
    private final AccessTokenManager accessTokenManager;

    @Inject
    public FacebookAccessTokenProviderImpl(@NotNull AccessTokenManager accessTokenManager2) {
        Intrinsics.checkNotNullParameter(accessTokenManager2, "accessTokenManager");
        this.accessTokenManager = accessTokenManager2;
    }

    @Nullable
    public AccessToken getAccessTokenOrNull() {
        return this.accessTokenManager.getCurrentAccessToken();
    }

    public boolean isCurrentAccessTokenActive() {
        AccessToken currentAccessToken = this.accessTokenManager.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            return false;
        }
        return true;
    }
}
