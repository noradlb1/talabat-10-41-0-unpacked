package com.deliveryhero.customerchat.commons;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/customerchat/commons/UserChangedDuringChatOpenException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "message", "", "(Ljava/lang/String;)V", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserChangedDuringChatOpenException extends IllegalStateException {
    public UserChangedDuringChatOpenException() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserChangedDuringChatOpenException(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "Cannot register the user when the chat is open" : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserChangedDuringChatOpenException(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
