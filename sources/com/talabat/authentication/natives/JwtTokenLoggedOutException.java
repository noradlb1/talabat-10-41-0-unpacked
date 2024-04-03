package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/authentication/natives/JwtTokenLoggedOutException;", "Lcom/talabat/authentication/natives/JwtTokenFlowTerminalException;", "msg", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JwtTokenLoggedOutException extends JwtTokenFlowTerminalException {
    public JwtTokenLoggedOutException() {
        this((String) null, (Throwable) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JwtTokenLoggedOutException(String str, Throwable th2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : th2);
    }

    public JwtTokenLoggedOutException(@Nullable String str, @Nullable Throwable th2) {
        super(str, th2);
    }
}
