package com.deliveryhero.perseus.core.session;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/deliveryhero/perseus/core/session/AppSessionManager;", "", "getAndIncrementSessionOffset", "", "getUserSessionId", "", "refreshSessionTimeStamp", "", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface AppSessionManager {
    long getAndIncrementSessionOffset();

    @NotNull
    String getUserSessionId();

    void refreshSessionTimeStamp();
}
