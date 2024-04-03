package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/authentication/natives/JwtTokenFlowTerminalException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "msg", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMsg", "()Ljava/lang/String;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class JwtTokenFlowTerminalException extends RuntimeException {
    @Nullable
    private final String msg;

    public JwtTokenFlowTerminalException() {
        this((String) null, (Throwable) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JwtTokenFlowTerminalException(String str, Throwable th2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : th2);
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public JwtTokenFlowTerminalException(@Nullable String str, @Nullable Throwable th2) {
        super(str, th2);
        this.msg = str;
    }
}
