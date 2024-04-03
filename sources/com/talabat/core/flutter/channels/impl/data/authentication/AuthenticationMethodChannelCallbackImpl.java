package com.talabat.core.flutter.channels.impl.data.authentication;

import android.content.Context;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.token.data.flutter.TokenFlutterMapper;
import com.talabat.authentication.token.domain.DeviceTokenNotFoundException;
import com.talabat.authentication.token.domain.TokenNotFoundException;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelCallback;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.home.HomeScreen;
import com.talabat.fluttercore.channels.LogoutEventCallback;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u001e\u0010\u0018\u001a\u00020\u00102\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/authentication/AuthenticationMethodChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/authentication/AuthenticationChannelCallback;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "tokenFlutterMapper", "Lcom/talabat/authentication/token/data/flutter/TokenFlutterMapper;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "context", "Landroid/content/Context;", "(Lcom/talabat/authentication/aaa/secrets/SecretProvider;Lcom/talabat/authentication/token/domain/repository/TokenRepository;Lcom/talabat/authentication/token/data/flutter/TokenFlutterMapper;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/navigation/domain/Navigator;Landroid/content/Context;)V", "clearLegacyToken", "", "clearToken", "getClientSecret", "", "getToken", "", "", "launchHomeScreen", "setToken", "map", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthenticationMethodChannelCallbackImpl implements AuthenticationChannelCallback {
    @NotNull
    private final Context context;
    @NotNull
    private final ITalabatFeatureFlag featureFlags;
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final SecretProvider secretProvider;
    @NotNull
    private final TokenFlutterMapper tokenFlutterMapper;
    @NotNull
    private final TokenRepository tokenRepository;

    @Inject
    public AuthenticationMethodChannelCallbackImpl(@NotNull SecretProvider secretProvider2, @NotNull TokenRepository tokenRepository2, @NotNull TokenFlutterMapper tokenFlutterMapper2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Navigator navigator2, @NotNull @ApplicationContext Context context2) {
        Intrinsics.checkNotNullParameter(secretProvider2, "secretProvider");
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        Intrinsics.checkNotNullParameter(tokenFlutterMapper2, "tokenFlutterMapper");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlags");
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.secretProvider = secretProvider2;
        this.tokenRepository = tokenRepository2;
        this.tokenFlutterMapper = tokenFlutterMapper2;
        this.featureFlags = iTalabatFeatureFlag;
        this.navigator = navigator2;
        this.context = context2;
    }

    private final void launchHomeScreen() {
        this.navigator.navigateTo(this.context, new HomeScreen(new HomeScreen.HomeScreenData((HomeScreen.NavigationTab) null, false, 3, (DefaultConstructorMarker) null)), AuthenticationMethodChannelCallbackImpl$launchHomeScreen$1.INSTANCE);
    }

    public void clearLegacyToken() {
        this.tokenRepository.clearLegacyToken();
    }

    public void clearToken() {
        LogoutEventCallback logoutEventCallback;
        if (this.featureFlags.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_STOP_USING_OWIN_TOKEN, false)) {
            Context context2 = this.context;
            if (context2 instanceof LogoutEventCallback) {
                logoutEventCallback = (LogoutEventCallback) context2;
            } else {
                logoutEventCallback = null;
            }
            if (logoutEventCallback != null) {
                logoutEventCallback.onLogout();
            }
            launchHomeScreen();
        }
        this.tokenRepository.clearToken();
    }

    @NotNull
    public String getClientSecret() {
        return this.secretProvider.getClientSecret();
    }

    @NotNull
    public Map<String, Object> getToken() {
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

    public void setToken(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        this.tokenRepository.saveToken(this.tokenFlutterMapper.fromMap(map), String.valueOf(map.get("deviceToken")));
    }
}
