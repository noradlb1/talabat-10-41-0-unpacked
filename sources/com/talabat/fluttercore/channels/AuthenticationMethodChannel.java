package com.talabat.fluttercore.channels;

import androidx.core.app.NotificationCompat;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.token.data.flutter.TokenFlutterMapper;
import com.talabat.authentication.token.domain.DeviceTokenNotFoundException;
import com.talabat.authentication.token.domain.TokenNotFoundException;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/fluttercore/channels/AuthenticationMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "tokenFlutterMapper", "Lcom/talabat/authentication/token/data/flutter/TokenFlutterMapper;", "authenticationChannelCallback", "Lcom/talabat/fluttercore/channels/AuthenticationChannelCallback;", "(Lcom/talabat/authentication/aaa/secrets/SecretProvider;Lcom/talabat/authentication/token/domain/repository/TokenRepository;Lcom/talabat/authentication/token/data/flutter/TokenFlutterMapper;Lcom/talabat/fluttercore/channels/AuthenticationChannelCallback;)V", "clearJwtToken", "", "clearOwinToken", "getClientSecret", "", "getToken", "logout", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setToken", "arguments", "Companion", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthenticationMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    private static final String CLEAR_JWT_TOKEN = "clearJwtToken";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_CLIENT_SECRET = "getClientSecret";
    @NotNull
    private static final String GET_TOKEN = "getToken";
    @NotNull
    private static final String LOGOUT = "logout";
    @NotNull
    private static final String SET_TOKEN = "setToken";
    @Nullable
    private final AuthenticationChannelCallback authenticationChannelCallback;
    @NotNull
    private final SecretProvider secretProvider;
    @NotNull
    private final TokenFlutterMapper tokenFlutterMapper;
    @NotNull
    private final TokenRepository tokenRepository;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/fluttercore/channels/AuthenticationMethodChannel$Companion;", "", "()V", "CLEAR_JWT_TOKEN", "", "GET_CLIENT_SECRET", "GET_TOKEN", "LOGOUT", "SET_TOKEN", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public AuthenticationMethodChannel(@NotNull SecretProvider secretProvider2, @NotNull TokenRepository tokenRepository2, @NotNull TokenFlutterMapper tokenFlutterMapper2, @Nullable AuthenticationChannelCallback authenticationChannelCallback2) {
        Intrinsics.checkNotNullParameter(secretProvider2, "secretProvider");
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        Intrinsics.checkNotNullParameter(tokenFlutterMapper2, "tokenFlutterMapper");
        this.secretProvider = secretProvider2;
        this.tokenRepository = tokenRepository2;
        this.tokenFlutterMapper = tokenFlutterMapper2;
        this.authenticationChannelCallback = authenticationChannelCallback2;
    }

    private final void clearJwtToken() {
        AuthenticationChannelCallback authenticationChannelCallback2 = this.authenticationChannelCallback;
        if (authenticationChannelCallback2 != null) {
            authenticationChannelCallback2.onLogout();
        }
        this.tokenRepository.clearToken();
    }

    private final void clearOwinToken() {
        this.tokenRepository.clearLegacyToken();
    }

    private final Object getClientSecret() {
        return this.secretProvider.getClientSecret();
    }

    private final Object getToken() {
        Map<String, Object> map;
        String str;
        try {
            map = this.tokenFlutterMapper.toMap(this.tokenRepository.getToken());
        } catch (TokenNotFoundException unused) {
            map = MapsKt__MapsKt.emptyMap();
        }
        try {
            str = this.tokenRepository.getDeviceToken();
        } catch (DeviceTokenNotFoundException unused2) {
            str = "";
        }
        return MapsKt__MapsKt.plus(map, TuplesKt.to("deviceToken", str));
    }

    private final void logout() {
        clearOwinToken();
        clearJwtToken();
    }

    private final void setToken(Object obj) {
        Map map = (Map) obj;
        this.tokenRepository.saveToken(this.tokenFlutterMapper.fromMap(map), String.valueOf(map.get("deviceToken")));
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1097329270:
                    if (str.equals(LOGOUT)) {
                        logout();
                        return;
                    }
                    return;
                case 179600593:
                    if (str.equals(GET_CLIENT_SECRET)) {
                        result.success(getClientSecret());
                        return;
                    }
                    return;
                case 956796639:
                    if (str.equals(CLEAR_JWT_TOKEN)) {
                        clearJwtToken();
                        return;
                    }
                    return;
                case 1405254327:
                    if (str.equals(SET_TOKEN)) {
                        Object obj = methodCall.arguments;
                        Intrinsics.checkNotNullExpressionValue(obj, "call.arguments");
                        setToken(obj);
                        return;
                    }
                    return;
                case 1966366787:
                    if (str.equals(GET_TOKEN)) {
                        result.success(getToken());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthenticationMethodChannel(SecretProvider secretProvider2, TokenRepository tokenRepository2, TokenFlutterMapper tokenFlutterMapper2, AuthenticationChannelCallback authenticationChannelCallback2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(secretProvider2, tokenRepository2, tokenFlutterMapper2, (i11 & 8) != 0 ? null : authenticationChannelCallback2);
    }
}
