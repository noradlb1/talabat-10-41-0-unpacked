package com.talabat.helpers;

import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$setupAuthenticationTokenIntegrator$2$5 extends Lambda implements Function0<String> {
    final /* synthetic */ TalabatNetworkModuleJWTTokenIntegrator $this_with;
    final /* synthetic */ Function0<TokenRepository> $tokenRepository;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$setupAuthenticationTokenIntegrator$2$5(TalabatNetworkModuleJWTTokenIntegrator talabatNetworkModuleJWTTokenIntegrator, Function0<? extends TokenRepository> function0) {
        super(0);
        this.$this_with = talabatNetworkModuleJWTTokenIntegrator;
        this.$tokenRepository = function0;
    }

    @NotNull
    public final String invoke() {
        Object obj;
        Function0<TokenRepository> function0 = this.$tokenRepository;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(function0.invoke().getDeviceToken());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            obj = "";
        }
        return (String) obj;
    }
}
