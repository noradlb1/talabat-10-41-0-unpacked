package com.talabat.authentication.token.domain.repository;

import com.talabat.authentication.token.domain.DeviceTokenNotFoundException;
import com.talabat.authentication.token.domain.LegacyTokenNotFoundException;
import com.talabat.authentication.token.domain.TokenNotFoundException;
import com.talabat.authentication.token.domain.model.LegacyToken;
import com.talabat.authentication.token.domain.model.Token;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u000fH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000bH&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H&J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H&R\u0014\u0010\u0002\u001a\u00020\u00038fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078fX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8fX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "", "deviceToken", "", "getDeviceToken", "()Ljava/lang/String;", "legacyToken", "Lcom/talabat/authentication/token/domain/model/LegacyToken;", "getLegacyToken", "()Lcom/talabat/authentication/token/domain/model/LegacyToken;", "token", "Lcom/talabat/authentication/token/domain/model/Token;", "getToken", "()Lcom/talabat/authentication/token/domain/model/Token;", "clearLegacyToken", "", "clearToken", "clearTokens", "getTokenOrNull", "loginClient", "Lio/reactivex/Single;", "saveToken", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TokenRepository {
    void clearLegacyToken();

    void clearToken();

    void clearTokens();

    @NotNull
    String getDeviceToken() throws DeviceTokenNotFoundException;

    @NotNull
    LegacyToken getLegacyToken() throws LegacyTokenNotFoundException;

    @NotNull
    Token getToken() throws TokenNotFoundException;

    @Nullable
    Token getTokenOrNull();

    @NotNull
    Single<Token> loginClient();

    void saveToken(@NotNull Token token, @NotNull String str);
}
