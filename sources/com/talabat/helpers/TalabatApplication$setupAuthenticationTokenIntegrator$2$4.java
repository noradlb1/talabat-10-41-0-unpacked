package com.talabat.helpers;

import com.talabat.authentication.token.domain.model.Token;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$setupAuthenticationTokenIntegrator$2$4 extends Lambda implements Function0<String> {
    final /* synthetic */ Function0<Token> $tokenResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$setupAuthenticationTokenIntegrator$2$4(Function0<Token> function0) {
        super(0);
        this.$tokenResult = function0;
    }

    @NotNull
    public final String invoke() {
        return this.$tokenResult.invoke().getAccessToken();
    }
}
