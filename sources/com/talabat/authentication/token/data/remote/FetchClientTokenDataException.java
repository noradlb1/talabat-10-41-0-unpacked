package com.talabat.authentication.token.data.remote;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/authentication/token/data/remote/FetchClientTokenDataException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "throwable", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FetchClientTokenDataException extends Exception {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FetchClientTokenDataException(String str, Throwable th2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchClientTokenDataException(@NotNull String str, @Nullable Throwable th2) {
        super(str, th2);
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
