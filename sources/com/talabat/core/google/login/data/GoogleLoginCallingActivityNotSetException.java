package com.talabat.core.google.login.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/google/login/data/GoogleLoginCallingActivityNotSetException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "com_talabat_core_social-login_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GoogleLoginCallingActivityNotSetException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoogleLoginCallingActivityNotSetException(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
