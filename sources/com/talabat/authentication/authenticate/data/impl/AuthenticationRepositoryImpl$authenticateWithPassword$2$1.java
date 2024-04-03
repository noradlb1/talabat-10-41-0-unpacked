package com.talabat.authentication.authenticate.data.impl;

import com.talabat.authentication.token.data.model.TokenData;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/authentication/token/data/model/TokenData;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AuthenticationRepositoryImpl$authenticateWithPassword$2$1<T> implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRepositoryImpl f55403b;

    public AuthenticationRepositoryImpl$authenticateWithPassword$2$1(AuthenticationRepositoryImpl authenticationRepositoryImpl) {
        this.f55403b = authenticationRepositoryImpl;
    }

    public final void accept(TokenData tokenData) {
        if (tokenData instanceof TokenData.Valid) {
            TokenData.Valid valid = (TokenData.Valid) tokenData;
            this.f55403b.tokenRepository.saveToken(valid.getToken(), valid.getDeviceToken());
        }
    }
}
