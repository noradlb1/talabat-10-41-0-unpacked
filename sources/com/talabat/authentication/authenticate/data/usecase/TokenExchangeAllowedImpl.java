package com.talabat.authentication.authenticate.data.usecase;

import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import com.talabat.authentication.authenticate.domain.usecase.TokenExchangeAllowed;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/authentication/authenticate/data/usecase/TokenExchangeAllowedImpl;", "Lcom/talabat/authentication/authenticate/domain/usecase/TokenExchangeAllowed;", "tokenExchangeRetriesRepository", "Lcom/talabat/authentication/authenticate/domain/repository/TokenExchangeRetriesRepository;", "(Lcom/talabat/authentication/authenticate/domain/repository/TokenExchangeRetriesRepository;)V", "invoke", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenExchangeAllowedImpl implements TokenExchangeAllowed {
    @NotNull
    private final TokenExchangeRetriesRepository tokenExchangeRetriesRepository;

    @Inject
    public TokenExchangeAllowedImpl(@NotNull TokenExchangeRetriesRepository tokenExchangeRetriesRepository2) {
        Intrinsics.checkNotNullParameter(tokenExchangeRetriesRepository2, "tokenExchangeRetriesRepository");
        this.tokenExchangeRetriesRepository = tokenExchangeRetriesRepository2;
    }

    public boolean invoke() {
        return this.tokenExchangeRetriesRepository.getCurrentSessionRetries() < 10;
    }
}
