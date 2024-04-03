package com.talabat.helpers;

import com.talabat.authentication.token.domain.model.LegacyToken;
import datamodels.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/authentication/token/domain/model/LegacyToken;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$setupAuthenticationTokenIntegrator$3 extends Lambda implements Function1<LegacyToken, Unit> {
    public static final TalabatApplication$setupAuthenticationTokenIntegrator$3 INSTANCE = new TalabatApplication$setupAuthenticationTokenIntegrator$3();

    public TalabatApplication$setupAuthenticationTokenIntegrator$3() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LegacyToken) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LegacyToken legacyToken) {
        Intrinsics.checkNotNullParameter(legacyToken, "it");
        Token token = new Token();
        token.access_token = legacyToken.getAccessToken();
        token.token_type = legacyToken.getTokenType();
        token.expires_in = String.valueOf(legacyToken.getExpiresIn());
        token.refresh_token = "";
        GlobalDataModel.token = token;
    }
}
