package com.talabat.authentication.token.data.remote.impl;

import com.talabat.authentication.aaa.TokenResponse;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.authentication.token.domain.model.Token;
import com.talabat.authentication.usecase.CalculateTokenTimeDifferenceUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/authentication/token/data/remote/impl/TokenResponseMapperImpl;", "Lcom/talabat/authentication/token/data/remote/TokenResponseMapper;", "calculateTokenTimeDifferenceUseCase", "Lcom/talabat/authentication/usecase/CalculateTokenTimeDifferenceUseCase;", "(Lcom/talabat/authentication/usecase/CalculateTokenTimeDifferenceUseCase;)V", "map", "Lcom/talabat/authentication/token/domain/model/Token;", "tokenResponse", "Lcom/talabat/authentication/aaa/TokenResponse;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenResponseMapperImpl implements TokenResponseMapper {
    @NotNull
    private final CalculateTokenTimeDifferenceUseCase calculateTokenTimeDifferenceUseCase;

    @Inject
    public TokenResponseMapperImpl(@NotNull CalculateTokenTimeDifferenceUseCase calculateTokenTimeDifferenceUseCase2) {
        Intrinsics.checkNotNullParameter(calculateTokenTimeDifferenceUseCase2, "calculateTokenTimeDifferenceUseCase");
        this.calculateTokenTimeDifferenceUseCase = calculateTokenTimeDifferenceUseCase2;
    }

    @NotNull
    public Token map(@NotNull TokenResponse tokenResponse) {
        Intrinsics.checkNotNullParameter(tokenResponse, "tokenResponse");
        return new Token(tokenResponse.getRefreshToken(), tokenResponse.getAccessToken(), tokenResponse.getExpiresIn(), tokenResponse.getTokenType(), tokenResponse.getScope(), this.calculateTokenTimeDifferenceUseCase.invoke(tokenResponse.getAccessToken()));
    }
}
