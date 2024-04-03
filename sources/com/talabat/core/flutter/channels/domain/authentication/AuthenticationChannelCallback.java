package com.talabat.core.flutter.channels.domain.authentication;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH&J\u001e\u0010\t\u001a\u00020\u00032\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH&¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/authentication/AuthenticationChannelCallback;", "", "clearLegacyToken", "", "clearToken", "getClientSecret", "", "getToken", "", "setToken", "map", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AuthenticationChannelCallback {
    void clearLegacyToken();

    void clearToken();

    @NotNull
    String getClientSecret();

    @NotNull
    Map<String, Object> getToken();

    void setToken(@NotNull Map<String, ? extends Object> map);
}
