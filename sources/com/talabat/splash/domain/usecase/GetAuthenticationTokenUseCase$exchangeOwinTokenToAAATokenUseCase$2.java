package com.talabat.splash.domain.usecase;

import com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase;
import com.talabat.authentication.token.domain.repository.ClearOwinUseCase;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/authentication/authenticate/domain/repository/ExchangeOwinTokenToAAATokenUseCase;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetAuthenticationTokenUseCase$exchangeOwinTokenToAAATokenUseCase$2 extends Lambda implements Function0<ExchangeOwinTokenToAAATokenUseCase> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GetAuthenticationTokenUseCase f61488g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetAuthenticationTokenUseCase$exchangeOwinTokenToAAATokenUseCase$2(GetAuthenticationTokenUseCase getAuthenticationTokenUseCase) {
        super(0);
        this.f61488g = getAuthenticationTokenUseCase;
    }

    @NotNull
    public final ExchangeOwinTokenToAAATokenUseCase invoke() {
        return new ExchangeOwinTokenToAAATokenUseCase((ClearOwinUseCase) null, this.f61488g.dispatchersFactory, this.f61488g.featureFlag, this.f61488g.authenticationRepository, this.f61488g.migrationExchangeObservabilityUseCase, UserFeatureFlagsKeys.FF_USER_AUTHENTICATION_EXCHANGE_OWIN_TO_JWT, this.f61488g.tokenRepository, new GetAuthenticationTokenUseCase$exchangeOwinTokenToAAATokenUseCase$2$isGdmAvailable$1(), 1, (DefaultConstructorMarker) null);
    }
}
