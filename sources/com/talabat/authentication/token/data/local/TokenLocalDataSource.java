package com.talabat.authentication.token.data.local;

import com.talabat.authentication.token.domain.model.Token;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/talabat/authentication/token/data/local/TokenLocalDataSource;", "", "clearToken", "", "getDeviceToken", "", "getToken", "Lcom/talabat/authentication/token/domain/model/Token;", "setToken", "token", "deviceToken", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TokenLocalDataSource {
    void clearToken();

    @Nullable
    String getDeviceToken();

    @Nullable
    Token getToken();

    void setToken(@NotNull Token token, @NotNull String str);
}
