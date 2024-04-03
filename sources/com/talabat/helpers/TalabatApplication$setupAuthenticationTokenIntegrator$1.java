package com.talabat.helpers;

import com.talabat.authentication.token.domain.repository.TokenRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$setupAuthenticationTokenIntegrator$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Function0<TokenRepository> $tokenRepository;
    final /* synthetic */ TalabatApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$setupAuthenticationTokenIntegrator$1(TalabatApplication talabatApplication, Function0<? extends TokenRepository> function0) {
        super(0);
        this.this$0 = talabatApplication;
        this.$tokenRepository = function0;
    }

    @Nullable
    public final Boolean invoke() {
        Object obj;
        Function0<TokenRepository> function0 = this.$tokenRepository;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(Boolean.valueOf(function0.invoke().getTokenOrNull() != null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        return (Boolean) obj;
    }
}
