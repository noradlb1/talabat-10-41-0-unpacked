package com.talabat.helpers;

import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$setupAuthenticationTokenIntegrator$tokenRepository$1 extends Lambda implements Function0<TokenRepository> {
    final /* synthetic */ TalabatApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$setupAuthenticationTokenIntegrator$tokenRepository$1(TalabatApplication talabatApplication) {
        super(0);
        this.this$0 = talabatApplication;
    }

    @NotNull
    public final TokenRepository invoke() {
        return ((TokenCoreLibApi) this.this$0.getFeature(TokenCoreLibApi.class)).getTokenRepository();
    }
}
