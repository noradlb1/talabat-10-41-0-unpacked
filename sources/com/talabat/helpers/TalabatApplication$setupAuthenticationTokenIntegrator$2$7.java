package com.talabat.helpers;

import com.talabat.authentication.token.domain.model.Token;
import com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$setupAuthenticationTokenIntegrator$2$7 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ TalabatNetworkModuleJWTTokenIntegrator $this_with;
    final /* synthetic */ Function0<Token> $tokenResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$setupAuthenticationTokenIntegrator$2$7(TalabatNetworkModuleJWTTokenIntegrator talabatNetworkModuleJWTTokenIntegrator, Function0<Token> function0) {
        super(0);
        this.$this_with = talabatNetworkModuleJWTTokenIntegrator;
        this.$tokenResult = function0;
    }

    @NotNull
    public final Boolean invoke() {
        Object obj;
        Function0<Token> function0 = this.$tokenResult;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(function0.invoke());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        return Boolean.valueOf(obj != null);
    }
}
