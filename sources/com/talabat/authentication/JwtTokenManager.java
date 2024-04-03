package com.talabat.authentication;

import com.talabat.authentication.natives.JwtTokenFlowException;
import com.talabat.authentication.natives.JwtTokenFlowTerminalException;
import com.talabat.authentication.token.domain.model.Token;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/authentication/JwtTokenManager;", "", "getValidToken", "", "path", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "Lcom/talabat/authentication/token/domain/model/Token;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface JwtTokenManager {
    @Nullable
    Object getValidToken(@NotNull String str, @NotNull Continuation<? super String> continuation) throws JwtTokenFlowException, JwtTokenFlowTerminalException;

    @Nullable
    Object refreshToken(@NotNull String str, @NotNull Continuation<? super Token> continuation) throws JwtTokenFlowException, JwtTokenFlowTerminalException;
}
