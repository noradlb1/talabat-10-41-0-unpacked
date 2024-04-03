package com.deliveryhero.customerchat.commons;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/deliveryhero/customerchat/commons/ChatCryptoException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "throwable", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatCryptoException extends RuntimeException {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatCryptoException(String str, Throwable th2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "Unable to encrypt or decrypt data" : str, th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatCryptoException(@NotNull String str, @NotNull Throwable th2) {
        super(str, th2);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(th2, "throwable");
    }
}
