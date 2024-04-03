package com.talabat.authentication;

import com.talabat.authentication.token.domain.model.LegacyToken;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R5\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/authentication/AuthenticationIntegrator;", "", "()V", "onLegacyTokenReceived", "Lkotlin/Function1;", "Lcom/talabat/authentication/token/domain/model/LegacyToken;", "Lkotlin/ParameterName;", "name", "legacy", "", "getOnLegacyTokenReceived", "()Lkotlin/jvm/functions/Function1;", "setOnLegacyTokenReceived", "(Lkotlin/jvm/functions/Function1;)V", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthenticationIntegrator {
    @NotNull
    public static final AuthenticationIntegrator INSTANCE = new AuthenticationIntegrator();
    @NotNull
    private static Function1<? super LegacyToken, Unit> onLegacyTokenReceived = AuthenticationIntegrator$onLegacyTokenReceived$1.INSTANCE;

    private AuthenticationIntegrator() {
    }

    @NotNull
    public final Function1<LegacyToken, Unit> getOnLegacyTokenReceived() {
        return onLegacyTokenReceived;
    }

    public final void setOnLegacyTokenReceived(@NotNull Function1<? super LegacyToken, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        onLegacyTokenReceived = function1;
    }
}
