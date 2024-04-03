package com.deliveryhero.perseus.data.local;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\bH&¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStore;", "", "getClientId", "", "getSessionId", "getSessionOffset", "", "putClientId", "", "clientId", "putSessionId", "sessionId", "putSessionOffset", "sessionOffset", "refreshSessionTimeStamp", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PerseusUserLocalDataStore {
    @Nullable
    String getClientId();

    @Nullable
    String getSessionId();

    long getSessionOffset();

    void putClientId(@NotNull String str);

    void putSessionId(@NotNull String str);

    void putSessionOffset(long j11);

    void refreshSessionTimeStamp();
}
