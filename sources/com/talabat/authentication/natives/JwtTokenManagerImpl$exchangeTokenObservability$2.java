package com.talabat.authentication.natives;

import com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/authentication/usecase/MigrationExchangeObservabilityUseCase;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class JwtTokenManagerImpl$exchangeTokenObservability$2 extends Lambda implements Function0<MigrationExchangeObservabilityUseCase> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ JwtTokenManagerImpl f55475g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JwtTokenManagerImpl$exchangeTokenObservability$2(JwtTokenManagerImpl jwtTokenManagerImpl) {
        super(0);
        this.f55475g = jwtTokenManagerImpl;
    }

    @NotNull
    public final MigrationExchangeObservabilityUseCase invoke() {
        return new MigrationExchangeObservabilityUseCase(this.f55475g.observabilityManager);
    }
}
