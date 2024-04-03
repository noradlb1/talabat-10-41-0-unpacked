package com.talabat.authentication.natives.fake;

import com.talabat.authentication.JwtTokenManager;
import com.talabat.authentication.aaa.TokenResponse;
import com.talabat.authentication.token.domain.model.Token;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/authentication/natives/fake/FakeJwtTokenManager;", "Lcom/talabat/authentication/JwtTokenManager;", "()V", "validToken", "Lcom/talabat/authentication/token/domain/model/Token;", "validTokenResponse", "Lcom/talabat/authentication/aaa/TokenResponse;", "getValidToken", "", "path", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeJwtTokenManager implements JwtTokenManager {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DEFAULT_DEVICE_ID = "default_device_id";
    @NotNull
    private final Token validToken;
    @NotNull
    private final TokenResponse validTokenResponse;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/authentication/natives/fake/FakeJwtTokenManager$Companion;", "", "()V", "DEFAULT_DEVICE_ID", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public FakeJwtTokenManager() {
        TokenResponse tokenResponse = new TokenResponse("access token", "refresh token", 2005421400, "jwt", "scope");
        this.validTokenResponse = tokenResponse;
        this.validToken = new Token(tokenResponse.getRefreshToken(), tokenResponse.getAccessToken(), tokenResponse.getExpiresIn(), tokenResponse.getTokenType(), tokenResponse.getScope(), 0);
    }

    @Nullable
    public Object getValidToken(@NotNull String str, @NotNull Continuation<? super String> continuation) {
        return this.validToken.getAccessToken();
    }

    @Nullable
    public Object refreshToken(@NotNull String str, @NotNull Continuation<? super Token> continuation) {
        return this.validToken;
    }
}
