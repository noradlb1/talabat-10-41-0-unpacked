package com.talabat.authentication.authenticate.data.impl;

import com.talabat.authentication.authenticate.domain.model.PasswordAuthentication;
import com.talabat.authentication.authenticate.domain.repository.PasswordAuthenticationException;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication;", "kotlin.jvm.PlatformType", "it", "", "apply"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AuthenticationRepositoryImpl$authenticateWithPassword$2$4<T, R> implements Function {
    public static final AuthenticationRepositoryImpl$authenticateWithPassword$2$4<T, R> INSTANCE = new AuthenticationRepositoryImpl$authenticateWithPassword$2$4<>();

    public final SingleSource<? extends PasswordAuthentication> apply(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return Single.error((Throwable) new PasswordAuthenticationException());
    }
}
