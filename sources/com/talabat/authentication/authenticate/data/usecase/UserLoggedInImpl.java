package com.talabat.authentication.authenticate.data.usecase;

import com.talabat.authentication.authenticate.domain.usecase.UserLoggedIn;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.gdm.owin.domain.GdmOwinTokenRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/authentication/authenticate/data/usecase/UserLoggedInImpl;", "Lcom/talabat/authentication/authenticate/domain/usecase/UserLoggedIn;", "gdmOwinTokenRepository", "Lcom/talabat/gdm/owin/domain/GdmOwinTokenRepository;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "(Lcom/talabat/gdm/owin/domain/GdmOwinTokenRepository;Lcom/talabat/authentication/token/domain/repository/TokenRepository;)V", "invoke", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserLoggedInImpl implements UserLoggedIn {
    @NotNull
    private final GdmOwinTokenRepository gdmOwinTokenRepository;
    @NotNull
    private final TokenRepository tokenRepository;

    @Inject
    public UserLoggedInImpl(@NotNull GdmOwinTokenRepository gdmOwinTokenRepository2, @NotNull TokenRepository tokenRepository2) {
        Intrinsics.checkNotNullParameter(gdmOwinTokenRepository2, "gdmOwinTokenRepository");
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        this.gdmOwinTokenRepository = gdmOwinTokenRepository2;
        this.tokenRepository = tokenRepository2;
    }

    public boolean invoke() {
        if (this.gdmOwinTokenRepository.isGdmOwinTokenAvailable() || this.tokenRepository.getTokenOrNull() != null) {
            return true;
        }
        return false;
    }
}
