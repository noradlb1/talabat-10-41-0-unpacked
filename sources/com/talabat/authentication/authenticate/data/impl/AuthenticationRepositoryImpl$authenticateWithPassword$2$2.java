package com.talabat.authentication.authenticate.data.impl;

import com.talabat.authentication.authenticate.domain.model.PasswordAuthentication;
import com.talabat.authentication.token.data.model.TokenData;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication;", "kotlin.jvm.PlatformType", "it", "Lcom/talabat/authentication/token/data/model/TokenData;", "apply"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AuthenticationRepositoryImpl$authenticateWithPassword$2$2<T, R> implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRepositoryImpl f55404b;

    public AuthenticationRepositoryImpl$authenticateWithPassword$2$2(AuthenticationRepositoryImpl authenticationRepositoryImpl) {
        this.f55404b = authenticationRepositoryImpl;
    }

    public final PasswordAuthentication apply(@NotNull TokenData tokenData) {
        Intrinsics.checkNotNullParameter(tokenData, "it");
        if (tokenData instanceof TokenData.Error) {
            return this.f55404b.toPasswordAuthenticationError((TokenData.Error) tokenData);
        }
        if (tokenData instanceof TokenData.Valid) {
            return PasswordAuthentication.Success.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
