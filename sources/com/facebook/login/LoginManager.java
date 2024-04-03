package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b7.l;
import b7.m;
import b7.n;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 y2\u00020\u0001:\u0006wxyz{|B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u001e\u001a\u00060\u001fR\u00020\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0014J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020$H\u0014JH\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u00010$2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\r2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020$H\u0014JL\u0010>\u001a\u00020/2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020B2\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010D2\b\u00105\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010$H\u0002J\u0016\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u0006\u0010+\u001a\u00020,J\u001e\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u001e\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J \u0010G\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0002J$\u0010G\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J.\u0010G\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u001e\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u0016\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u0006\u0010+\u001a\u00020,J\u001e\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u0016\u0010P\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010+\u001a\u00020,J\u001e\u0010Q\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J\u001c\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010Q\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J\u001e\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0007J\u001e\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0002J\u001e\u0010R\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J\u001c\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010R\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J\u001e\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0007J\u001e\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0002J\b\u0010S\u001a\u00020/H\u0016J\u001c\u0010T\u001a\u00020/2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010U\u001a\u0004\u0018\u00010$H\u0002J\u0016\u0010V\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u0006\u0010+\u001a\u00020,J\u0018\u0010V\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u0006\u0010+\u001a\u00020,H\u0002J,\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010<2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109H\u0017J\u000e\u0010[\u001a\u00020/2\u0006\u0010H\u001a\u00020IJ\u000e\u0010[\u001a\u00020/2\u0006\u0010J\u001a\u00020NJ\u0010\u0010[\u001a\u00020/2\u0006\u0010J\u001a\u00020OH\u0002J \u0010\\\u001a\u00020/2\b\u0010 \u001a\u0004\u0018\u00010!2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109J\u0016\u0010]\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u0006\u0010(\u001a\u00020)J\u0016\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\u0006\u0010(\u001a\u00020)J\u001e\u0010]\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u001e\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u0018\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010(\u001a\u00020)H\u0007J\u0018\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010^\u001a\u00020\r2\u0006\u0010_\u001a\u00020<H\u0002J\u0016\u0010`\u001a\u00020/2\u0006\u0010?\u001a\u00020@2\u0006\u0010a\u001a\u00020bJ\u001e\u0010`\u001a\u00020/2\u0006\u0010?\u001a\u00020@2\u0006\u0010c\u001a\u00020d2\u0006\u0010a\u001a\u00020bJ \u0010e\u001a\u00020/2\u0006\u0010?\u001a\u00020@2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dH\u0002J\u000e\u0010f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010g\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010h\u001a\u00020/2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010i\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010j\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010k\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u0014J\u0010\u0010m\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u000e\u0010n\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010o\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\rJ\u0018\u0010p\u001a\u00020/2\u0006\u0010q\u001a\u00020r2\u0006\u0010=\u001a\u00020$H\u0002J\u0018\u0010s\u001a\u00020\r2\u0006\u0010q\u001a\u00020r2\u0006\u0010=\u001a\u00020$H\u0002J\u0010\u0010t\u001a\u00020/2\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010u\u001a\u00020/2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0002J\u0018\u0010v\u001a\u00020/2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000e¨\u0006}"}, d2 = {"Lcom/facebook/login/LoginManager;", "", "()V", "<set-?>", "", "authType", "getAuthType", "()Ljava/lang/String;", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "isExpressLoginAllowed", "", "()Z", "isFamilyLogin", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "Lcom/facebook/login/LoginTargetApp;", "loginTargetApp", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "messengerPageId", "resetMessengerState", "sharedPreferences", "Landroid/content/SharedPreferences;", "shouldSkipAccountDeduplication", "getShouldSkipAccountDeduplication", "createLogInActivityResultContract", "Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "callbackManager", "Lcom/facebook/CallbackManager;", "loggerID", "createLoginRequest", "Lcom/facebook/login/LoginClient$Request;", "permissions", "", "createLoginRequestFromResponse", "response", "Lcom/facebook/GraphResponse;", "createLoginRequestWithConfig", "loginConfig", "Lcom/facebook/login/LoginConfiguration;", "createReauthorizeRequest", "finishLogin", "", "newToken", "Lcom/facebook/AccessToken;", "newIdToken", "Lcom/facebook/AuthenticationToken;", "origRequest", "exception", "Lcom/facebook/FacebookException;", "isCanceled", "callback", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "getFacebookActivityIntent", "Landroid/content/Intent;", "request", "logCompleteLogin", "context", "Landroid/content/Context;", "result", "Lcom/facebook/login/LoginClient$Result$Code;", "resultExtras", "", "Ljava/lang/Exception;", "wasLoginActivityTried", "logIn", "activity", "Landroid/app/Activity;", "fragment", "Landroid/app/Fragment;", "activityResultRegistryOwner", "Landroidx/activity/result/ActivityResultRegistryOwner;", "Landroidx/fragment/app/Fragment;", "Lcom/facebook/internal/FragmentWrapper;", "logInWithConfiguration", "logInWithPublishPermissions", "logInWithReadPermissions", "logOut", "logStartLogin", "loginRequest", "loginWithConfiguration", "onActivityResult", "resultCode", "", "data", "reauthorizeDataAccess", "registerCallback", "resolveError", "resolveIntent", "intent", "retrieveLoginStatus", "responseCallback", "Lcom/facebook/LoginStatusCallback;", "toastDurationMs", "", "retrieveLoginStatusImpl", "setAuthType", "setDefaultAudience", "setExpressLoginStatus", "setFamilyLogin", "setLoginBehavior", "setLoginTargetApp", "targetApp", "setMessengerPageId", "setResetMessengerState", "setShouldSkipAccountDeduplication", "startLogin", "startActivityDelegate", "Lcom/facebook/login/StartActivityDelegate;", "tryFacebookActivity", "unregisterCallback", "validatePublishPermissions", "validateReadPermissions", "ActivityStartActivityDelegate", "AndroidxActivityResultRegistryOwnerStartActivityDelegate", "Companion", "FacebookLoginActivityResultContract", "FragmentStartActivityDelegate", "LoginLoggerHolder", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class LoginManager {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
    @NotNull
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    /* access modifiers changed from: private */
    @NotNull
    public static final Set<String> OTHER_PUBLISH_PERMISSIONS;
    @NotNull
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
    @NotNull
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    @NotNull
    private static final String TAG;
    /* access modifiers changed from: private */
    public static volatile LoginManager instance;
    @NotNull
    private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
    @NotNull
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    private boolean isFamilyLogin;
    @NotNull
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    @NotNull
    private LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;
    @Nullable
    private String messengerPageId;
    private boolean resetMessengerState;
    @NotNull
    private final SharedPreferences sharedPreferences;
    private boolean shouldSkipAccountDeduplication;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/facebook/login/LoginManager$ActivityStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityContext", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ActivityStartActivityDelegate implements StartActivityDelegate {
        @NotNull
        private final Activity activityContext;

        public ActivityStartActivityDelegate(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activityContext = activity;
        }

        @NotNull
        public Activity getActivityContext() {
            return this.activityContext;
        }

        public void startActivityForResult(@NotNull Intent intent, int i11) {
            Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            getActivityContext().startActivityForResult(intent, i11);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/login/LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "activityResultRegistryOwner", "Landroidx/activity/result/ActivityResultRegistryOwner;", "callbackManager", "Lcom/facebook/CallbackManager;", "(Landroidx/activity/result/ActivityResultRegistryOwner;Lcom/facebook/CallbackManager;)V", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AndroidxActivityResultRegistryOwnerStartActivityDelegate implements StartActivityDelegate {
        @NotNull
        private final ActivityResultRegistryOwner activityResultRegistryOwner;
        @NotNull
        private final CallbackManager callbackManager;

        public AndroidxActivityResultRegistryOwnerStartActivityDelegate(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner2, @NotNull CallbackManager callbackManager2) {
            Intrinsics.checkNotNullParameter(activityResultRegistryOwner2, "activityResultRegistryOwner");
            Intrinsics.checkNotNullParameter(callbackManager2, "callbackManager");
            this.activityResultRegistryOwner = activityResultRegistryOwner2;
            this.callbackManager = callbackManager2;
        }

        /* access modifiers changed from: private */
        /* renamed from: startActivityForResult$lambda-0  reason: not valid java name */
        public static final void m9001startActivityForResult$lambda0(AndroidxActivityResultRegistryOwnerStartActivityDelegate androidxActivityResultRegistryOwnerStartActivityDelegate, LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, Pair pair) {
            Intrinsics.checkNotNullParameter(androidxActivityResultRegistryOwnerStartActivityDelegate, "this$0");
            Intrinsics.checkNotNullParameter(loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, "$launcherHolder");
            CallbackManager callbackManager2 = androidxActivityResultRegistryOwnerStartActivityDelegate.callbackManager;
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            Object obj = pair.first;
            Intrinsics.checkNotNullExpressionValue(obj, "result.first");
            callbackManager2.onActivityResult(requestCode, ((Number) obj).intValue(), (Intent) pair.second);
            ActivityResultLauncher<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.unregister();
            }
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher((ActivityResultLauncher<Intent>) null);
        }

        @Nullable
        public Activity getActivityContext() {
            ActivityResultRegistryOwner activityResultRegistryOwner2 = this.activityResultRegistryOwner;
            if (activityResultRegistryOwner2 instanceof Activity) {
                return (Activity) activityResultRegistryOwner2;
            }
            return null;
        }

        public void startActivityForResult(@NotNull Intent intent, int i11) {
            Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder = new LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder();
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher(this.activityResultRegistryOwner.getActivityResultRegistry().register("facebook-login", new LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1(), new b(this, loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder)));
            ActivityResultLauncher<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.launch(intent);
            }
        }
    }

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J \u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0017J2\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006)"}, d2 = {"Lcom/facebook/login/LoginManager$Companion;", "", "()V", "EXPRESS_LOGIN_ALLOWED", "", "MANAGE_PERMISSION_PREFIX", "OTHER_PUBLISH_PERMISSIONS", "", "PREFERENCE_LOGIN_MANAGER", "PUBLISH_PERMISSION_PREFIX", "TAG", "instance", "Lcom/facebook/login/LoginManager;", "otherPublishPermissions", "getOtherPublishPermissions", "()Ljava/util/Set;", "computeLoginResult", "Lcom/facebook/login/LoginResult;", "request", "Lcom/facebook/login/LoginClient$Request;", "newToken", "Lcom/facebook/AccessToken;", "newIdToken", "Lcom/facebook/AuthenticationToken;", "getExtraDataFromIntent", "", "intent", "Landroid/content/Intent;", "getInstance", "handleLoginStatusError", "", "errorType", "errorDescription", "loggerRef", "logger", "Lcom/facebook/login/LoginLogger;", "responseCallback", "Lcom/facebook/LoginStatusCallback;", "isPublishPermission", "", "permission", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Set<String> getOtherPublishPermissions() {
            return SetsKt__SetsKt.setOf("ads_management", "create_event", "rsvp_event");
        }

        /* access modifiers changed from: private */
        public final void handleLoginStatusError(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
            FacebookException facebookException = new FacebookException(str + ": " + str2);
            loginLogger.logLoginStatusError(str3, facebookException);
            loginStatusCallback.onError(facebookException);
        }

        @JvmStatic
        @NotNull
        @VisibleForTesting(otherwise = 2)
        public final LoginResult computeLoginResult(@NotNull LoginClient.Request request, @NotNull AccessToken accessToken, @Nullable AuthenticationToken authenticationToken) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(accessToken, "newToken");
            Set<String> permissions = request.getPermissions();
            Set mutableSet = CollectionsKt___CollectionsKt.toMutableSet(CollectionsKt___CollectionsKt.filterNotNull(accessToken.getPermissions()));
            if (request.isRerequest()) {
                mutableSet.retainAll(permissions);
            }
            Set mutableSet2 = CollectionsKt___CollectionsKt.toMutableSet(CollectionsKt___CollectionsKt.filterNotNull(permissions));
            mutableSet2.removeAll(mutableSet);
            return new LoginResult(accessToken, authenticationToken, mutableSet, mutableSet2);
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @JvmStatic
        public final Map<String, String> getExtraDataFromIntent(@Nullable Intent intent) {
            if (intent == null) {
                return null;
            }
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result == null) {
                return null;
            }
            return result.extraData;
        }

        @JvmStatic
        @NotNull
        public LoginManager getInstance() {
            if (LoginManager.instance == null) {
                synchronized (this) {
                    LoginManager.instance = new LoginManager();
                    Unit unit = Unit.INSTANCE;
                }
            }
            LoginManager access$getInstance$cp = LoginManager.instance;
            if (access$getInstance$cp != null) {
                return access$getInstance$cp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            throw null;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean isPublishPermission(@Nullable String str) {
            if (str == null) {
                return false;
            }
            if (StringsKt__StringsJVMKt.startsWith$default(str, LoginManager.PUBLISH_PERMISSION_PREFIX, false, 2, (Object) null) || StringsKt__StringsJVMKt.startsWith$default(str, LoginManager.MANAGE_PERMISSION_PREFIX, false, 2, (Object) null) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(str)) {
                return true;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u001d\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "callbackManager", "Lcom/facebook/CallbackManager;", "loggerID", "(Lcom/facebook/login/LoginManager;Lcom/facebook/CallbackManager;Ljava/lang/String;)V", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "setCallbackManager", "(Lcom/facebook/CallbackManager;)V", "getLoggerID", "()Ljava/lang/String;", "setLoggerID", "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "permissions", "parseResult", "resultCode", "", "intent", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class FacebookLoginActivityResultContract extends ActivityResultContract<Collection<? extends String>, CallbackManager.ActivityResultParameters> {
        @Nullable
        private CallbackManager callbackManager;
        @Nullable
        private String loggerID;

        public FacebookLoginActivityResultContract(@Nullable LoginManager loginManager, @Nullable CallbackManager callbackManager2, String str) {
            Intrinsics.checkNotNullParameter(loginManager, "this$0");
            LoginManager.this = loginManager;
            this.callbackManager = callbackManager2;
            this.loggerID = str;
        }

        @Nullable
        public final CallbackManager getCallbackManager() {
            return this.callbackManager;
        }

        @Nullable
        public final String getLoggerID() {
            return this.loggerID;
        }

        public final void setCallbackManager(@Nullable CallbackManager callbackManager2) {
            this.callbackManager = callbackManager2;
        }

        public final void setLoggerID(@Nullable String str) {
            this.loggerID = str;
        }

        @NotNull
        public Intent createIntent(@NotNull Context context, @NotNull Collection<String> collection) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(collection, "permissions");
            LoginClient.Request createLoginRequestWithConfig = LoginManager.this.createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
            String str = this.loggerID;
            if (str != null) {
                createLoginRequestWithConfig.setAuthId(str);
            }
            LoginManager.this.logStartLogin(context, createLoginRequestWithConfig);
            Intent facebookActivityIntent = LoginManager.this.getFacebookActivityIntent(createLoginRequestWithConfig);
            if (LoginManager.this.resolveIntent(facebookActivityIntent)) {
                return facebookActivityIntent;
            }
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            LoginManager.this.logCompleteLogin(context, LoginClient.Result.Code.ERROR, (Map<String, String>) null, facebookException, false, createLoginRequestWithConfig);
            throw facebookException;
        }

        @NotNull
        public CallbackManager.ActivityResultParameters parseResult(int i11, @Nullable Intent intent) {
            LoginManager.onActivityResult$default(LoginManager.this, i11, intent, (FacebookCallback) null, 4, (Object) null);
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            CallbackManager callbackManager2 = this.callbackManager;
            if (callbackManager2 != null) {
                callbackManager2.onActivityResult(requestCode, i11, intent);
            }
            return new CallbackManager.ActivityResultParameters(requestCode, i11, intent);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FacebookLoginActivityResultContract(CallbackManager callbackManager2, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(LoginManager.this, (i11 & 1) != 0 ? null : callbackManager2, (i11 & 2) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/login/LoginManager$FragmentStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "fragment", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;)V", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class FragmentStartActivityDelegate implements StartActivityDelegate {
        @Nullable
        private final Activity activityContext;
        @NotNull
        private final FragmentWrapper fragment;

        public FragmentStartActivityDelegate(@NotNull FragmentWrapper fragmentWrapper) {
            Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
            this.activityContext = fragmentWrapper.getActivity();
        }

        @Nullable
        public Activity getActivityContext() {
            return this.activityContext;
        }

        public void startActivityForResult(@NotNull Intent intent, int i11) {
            Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            this.fragment.startActivityForResult(intent, i11);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/login/LoginManager$LoginLoggerHolder;", "", "()V", "logger", "Lcom/facebook/login/LoginLogger;", "getLogger", "context", "Landroid/content/Context;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LoginLoggerHolder {
        @NotNull
        public static final LoginLoggerHolder INSTANCE = new LoginLoggerHolder();
        @Nullable
        private static LoginLogger logger;

        private LoginLoggerHolder() {
        }

        @Nullable
        public final synchronized LoginLogger getLogger(@Nullable Context context) {
            if (context == null) {
                context = FacebookSdk.getApplicationContext();
            }
            if (context == null) {
                return null;
            }
            if (logger == null) {
                logger = new LoginLogger(context, FacebookSdk.getApplicationId());
            }
            return logger;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        OTHER_PUBLISH_PERMISSIONS = companion.getOtherPublishPermissions();
        String cls = LoginManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(cls, "LoginManager::class.java.toString()");
        TAG = cls;
    }

    public LoginManager() {
        Validate.sdkInitialized();
        SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences2;
        if (FacebookSdk.hasCustomTabsPrefetching && CustomTabUtils.getChromePackage() != null) {
            CustomTabsClient.bindCustomTabsService(FacebookSdk.getApplicationContext(), "com.android.chrome", new CustomTabPrefetchHelper());
            CustomTabsClient.connectAndInitialize(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationContext().getPackageName());
        }
    }

    @JvmStatic
    @NotNull
    @VisibleForTesting(otherwise = 2)
    public static final LoginResult computeLoginResult(@NotNull LoginClient.Request request, @NotNull AccessToken accessToken, @Nullable AuthenticationToken authenticationToken) {
        return Companion.computeLoginResult(request, accessToken, authenticationToken);
    }

    public static /* synthetic */ FacebookLoginActivityResultContract createLogInActivityResultContract$default(LoginManager loginManager, CallbackManager callbackManager, String str, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                callbackManager = null;
            }
            if ((i11 & 2) != 0) {
                str = null;
            }
            return loginManager.createLogInActivityResultContract(callbackManager, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogInActivityResultContract");
    }

    private final LoginClient.Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        Set<String> permissions;
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        List list = null;
        if (!(accessToken == null || (permissions = accessToken.getPermissions()) == null)) {
            list = CollectionsKt___CollectionsKt.filterNotNull(permissions);
        }
        return createLoginRequest(list);
    }

    private final void finishLogin(AccessToken accessToken, AuthenticationToken authenticationToken, LoginClient.Request request, FacebookException facebookException, boolean z11, FacebookCallback<LoginResult> facebookCallback) {
        LoginResult loginResult;
        if (accessToken != null) {
            AccessToken.Companion.setCurrentAccessToken(accessToken);
            Profile.Companion.fetchProfileForCurrentAccessToken();
        }
        if (authenticationToken != null) {
            AuthenticationToken.Companion.setCurrentAuthenticationToken(authenticationToken);
        }
        if (facebookCallback != null) {
            if (accessToken == null || request == null) {
                loginResult = null;
            } else {
                loginResult = Companion.computeLoginResult(request, accessToken, authenticationToken);
            }
            if (z11 || (loginResult != null && loginResult.getRecentlyGrantedPermissions().isEmpty())) {
                facebookCallback.onCancel();
            } else if (facebookException != null) {
                facebookCallback.onError(facebookException);
            } else if (accessToken != null && loginResult != null) {
                setExpressLoginStatus(true);
                facebookCallback.onSuccess(loginResult);
            }
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @JvmStatic
    public static final Map<String, String> getExtraDataFromIntent(@Nullable Intent intent) {
        return Companion.getExtraDataFromIntent(intent);
    }

    @JvmStatic
    @NotNull
    public static LoginManager getInstance() {
        return Companion.getInstance();
    }

    private final boolean isExpressLoginAllowed() {
        return this.sharedPreferences.getBoolean(EXPRESS_LOGIN_ALLOWED, true);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isPublishPermission(@Nullable String str) {
        return Companion.isPublishPermission(str);
    }

    /* access modifiers changed from: private */
    public final void logCompleteLogin(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z11, LoginClient.Request request) {
        String str;
        String str2;
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger != null) {
            if (request == null) {
                LoginLogger.logUnexpectedError$default(logger, LoginLogger.EVENT_NAME_LOGIN_COMPLETE, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", (String) null, 4, (Object) null);
                return;
            }
            HashMap hashMap = new HashMap();
            if (z11) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put(LoginLogger.EVENT_EXTRAS_TRY_LOGIN_ACTIVITY, str);
            String authId = request.getAuthId();
            if (request.isFamilyLogin()) {
                str2 = LoginLogger.EVENT_NAME_FOA_LOGIN_COMPLETE;
            } else {
                str2 = LoginLogger.EVENT_NAME_LOGIN_COMPLETE;
            }
            logger.logCompleteLogin(authId, hashMap, code, map, exc, str2);
        }
    }

    /* access modifiers changed from: private */
    public final void logStartLogin(Context context, LoginClient.Request request) {
        String str;
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger != null && request != null) {
            if (request.isFamilyLogin()) {
                str = LoginLogger.EVENT_NAME_FOA_LOGIN_START;
            } else {
                str = LoginLogger.EVENT_NAME_LOGIN_START;
            }
            logger.logStartLogin(request, str);
        }
    }

    private final void loginWithConfiguration(FragmentWrapper fragmentWrapper, LoginConfiguration loginConfiguration) {
        logIn(fragmentWrapper, loginConfiguration);
    }

    public static /* synthetic */ boolean onActivityResult$default(LoginManager loginManager, int i11, Intent intent, FacebookCallback facebookCallback, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 4) != 0) {
                facebookCallback = null;
            }
            return loginManager.onActivityResult(i11, intent, facebookCallback);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivityResult");
    }

    /* access modifiers changed from: private */
    /* renamed from: registerCallback$lambda-0  reason: not valid java name */
    public static final boolean m8998registerCallback$lambda0(LoginManager loginManager, FacebookCallback facebookCallback, int i11, Intent intent) {
        Intrinsics.checkNotNullParameter(loginManager, "this$0");
        return loginManager.onActivityResult(i11, intent, facebookCallback);
    }

    /* access modifiers changed from: private */
    public final boolean resolveIntent(Intent intent) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private final void retrieveLoginStatusImpl(Context context, LoginStatusCallback loginStatusCallback, long j11) {
        Context context2;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        if (context == null) {
            context2 = FacebookSdk.getApplicationContext();
        } else {
            context2 = context;
        }
        LoginLogger loginLogger = new LoginLogger(context2, applicationId);
        if (!isExpressLoginAllowed()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
            return;
        }
        LoginStatusClient newInstance$facebook_common_release = LoginStatusClient.Companion.newInstance$facebook_common_release(context, applicationId, uuid, FacebookSdk.getGraphApiVersion(), j11, (String) null);
        newInstance$facebook_common_release.setCompletedListener(new m(uuid, loginLogger, loginStatusCallback, applicationId));
        loginLogger.logLoginStatusStart(uuid);
        if (!newInstance$facebook_common_release.start()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: retrieveLoginStatusImpl$lambda-2  reason: not valid java name */
    public static final void m8999retrieveLoginStatusImpl$lambda2(String str, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback, String str2, Bundle bundle) {
        boolean z11;
        String str3;
        boolean z12;
        boolean z13;
        String str4 = str;
        LoginLogger loginLogger2 = loginLogger;
        LoginStatusCallback loginStatusCallback2 = loginStatusCallback;
        Bundle bundle2 = bundle;
        Intrinsics.checkNotNullParameter(str4, "$loggerRef");
        Intrinsics.checkNotNullParameter(loginLogger2, "$logger");
        Intrinsics.checkNotNullParameter(loginStatusCallback2, "$responseCallback");
        Intrinsics.checkNotNullParameter(str2, "$applicationId");
        if (bundle2 != null) {
            String string = bundle2.getString(NativeProtocol.STATUS_ERROR_TYPE);
            String string2 = bundle2.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
            if (string != null) {
                Companion.handleLoginStatusError(string, string2, str, loginLogger, loginStatusCallback);
                return;
            }
            String string3 = bundle2.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
            ArrayList<String> stringArrayList = bundle2.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string4 = bundle2.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
            String string5 = bundle2.getString("graph_domain");
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle2, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            boolean z14 = false;
            if (string4 == null || string4.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                str3 = LoginMethodHandler.Companion.getUserIDFromSignedRequest(string4);
            } else {
                str3 = null;
            }
            String str5 = str3;
            if (string3 == null || string3.length() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                if (stringArrayList == null || stringArrayList.isEmpty()) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z13) {
                    if (str5 == null || str5.length() == 0) {
                        z14 = true;
                    }
                    if (!z14) {
                        AccessToken accessToken = new AccessToken(string3, str2, str5, stringArrayList, (Collection<String>) null, (Collection<String>) null, (AccessTokenSource) null, bundleLongAsDate, (Date) null, bundleLongAsDate2, string5);
                        AccessToken.Companion.setCurrentAccessToken(accessToken);
                        Profile.Companion.fetchProfileForCurrentAccessToken();
                        loginLogger2.logLoginStatusSuccess(str4);
                        loginStatusCallback2.onCompleted(accessToken);
                        return;
                    }
                }
            }
            loginLogger2.logLoginStatusFailure(str4);
            loginStatusCallback.onFailure();
            return;
        }
        loginLogger2.logLoginStatusFailure(str4);
        loginStatusCallback.onFailure();
    }

    private final void setExpressLoginStatus(boolean z11) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(EXPRESS_LOGIN_ALLOWED, z11);
        edit.apply();
    }

    private final void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request) throws FacebookException {
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.Companion.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new n(this));
        if (!tryFacebookActivity(startActivityDelegate, request)) {
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            logCompleteLogin(startActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, (Map<String, String>) null, facebookException, false, request);
            throw facebookException;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startLogin$lambda-1  reason: not valid java name */
    public static final boolean m9000startLogin$lambda1(LoginManager loginManager, int i11, Intent intent) {
        Intrinsics.checkNotNullParameter(loginManager, "this$0");
        return onActivityResult$default(loginManager, i11, intent, (FacebookCallback) null, 4, (Object) null);
    }

    private final boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.Companion.getLoginRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private final void validatePublishPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String next : collection) {
                if (!Companion.isPublishPermission(next)) {
                    throw new FacebookException("Cannot pass a read permission (" + next + ") to a request for publish authorization");
                }
            }
        }
    }

    private final void validateReadPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String next : collection) {
                if (Companion.isPublishPermission(next)) {
                    throw new FacebookException("Cannot pass a publish or manage permission (" + next + ") to a request for read authorization");
                }
            }
        }
    }

    @NotNull
    @JvmOverloads
    public final FacebookLoginActivityResultContract createLogInActivityResultContract() {
        return createLogInActivityResultContract$default(this, (CallbackManager) null, (String) null, 3, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final FacebookLoginActivityResultContract createLogInActivityResultContract(@Nullable CallbackManager callbackManager) {
        return createLogInActivityResultContract$default(this, callbackManager, (String) null, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final FacebookLoginActivityResultContract createLogInActivityResultContract(@Nullable CallbackManager callbackManager, @Nullable String str) {
        return new FacebookLoginActivityResultContract(this, callbackManager, str);
    }

    @NotNull
    public LoginClient.Request createLoginRequest(@Nullable Collection<String> collection) {
        Set set;
        LoginBehavior loginBehavior2 = this.loginBehavior;
        if (collection == null) {
            set = null;
        } else {
            set = CollectionsKt___CollectionsKt.toSet(collection);
        }
        DefaultAudience defaultAudience2 = this.defaultAudience;
        String str = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior2, set, defaultAudience2, str, applicationId, uuid, this.loginTargetApp, (String) null, (String) null, (String) null, (CodeChallengeMethod) null, 1920, (DefaultConstructorMarker) null);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    @NotNull
    public LoginClient.Request createLoginRequestWithConfig(@NotNull LoginConfiguration loginConfiguration) {
        String str;
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        CodeChallengeMethod codeChallengeMethod = CodeChallengeMethod.S256;
        try {
            PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
            str = PKCEUtil.generateCodeChallenge(loginConfiguration.getCodeVerifier(), codeChallengeMethod);
        } catch (FacebookException unused) {
            codeChallengeMethod = CodeChallengeMethod.PLAIN;
            str = loginConfiguration.getCodeVerifier();
        }
        LoginBehavior loginBehavior2 = this.loginBehavior;
        Set set = CollectionsKt___CollectionsKt.toSet(loginConfiguration.getPermissions());
        DefaultAudience defaultAudience2 = this.defaultAudience;
        String str2 = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        LoginTargetApp loginTargetApp2 = this.loginTargetApp;
        String nonce = loginConfiguration.getNonce();
        String codeVerifier = loginConfiguration.getCodeVerifier();
        LoginClient.Request request = new LoginClient.Request(loginBehavior2, set, defaultAudience2, str2, applicationId, uuid, loginTargetApp2, nonce, codeVerifier, str, codeChallengeMethod);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    @NotNull
    public LoginClient.Request createReauthorizeRequest() {
        LoginBehavior loginBehavior2 = LoginBehavior.DIALOG_ONLY;
        HashSet hashSet = new HashSet();
        DefaultAudience defaultAudience2 = this.defaultAudience;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior2, hashSet, defaultAudience2, "reauthorize", applicationId, uuid, this.loginTargetApp, (String) null, (String) null, (String) null, (CodeChallengeMethod) null, 1920, (DefaultConstructorMarker) null);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    @NotNull
    public final String getAuthType() {
        return this.authType;
    }

    @NotNull
    public final DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    @NotNull
    public Intent getFacebookActivityIntent(@NotNull LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra(LoginFragment.REQUEST_KEY, bundle);
        return intent;
    }

    @NotNull
    public final LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    @NotNull
    public final LoginTargetApp getLoginTargetApp() {
        return this.loginTargetApp;
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.shouldSkipAccountDeduplication;
    }

    public final boolean isFamilyLogin() {
        return this.isFamilyLogin;
    }

    public final void logIn(@NotNull Fragment fragment, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithConfiguration(@NotNull Fragment fragment, @NotNull LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        loginWithConfiguration(new FragmentWrapper(fragment), loginConfiguration);
    }

    @Deprecated(message = "")
    public final void logInWithPublishPermissions(@NotNull Fragment fragment, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    @Deprecated(message = "")
    public final void logInWithReadPermissions(@NotNull Fragment fragment, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
    }

    public void logOut() {
        AccessToken.Companion.setCurrentAccessToken((AccessToken) null);
        AuthenticationToken.Companion.setCurrentAuthenticationToken((AuthenticationToken) null);
        Profile.Companion.setCurrentProfile((Profile) null);
        setExpressLoginStatus(false);
    }

    @VisibleForTesting(otherwise = 3)
    @JvmOverloads
    public final boolean onActivityResult(int i11, @Nullable Intent intent) {
        return onActivityResult$default(this, i11, intent, (FacebookCallback) null, 4, (Object) null);
    }

    @VisibleForTesting(otherwise = 3)
    @JvmOverloads
    public boolean onActivityResult(int i11, @Nullable Intent intent, @Nullable FacebookCallback<LoginResult> facebookCallback) {
        boolean z11;
        Map<String, String> map;
        LoginClient.Result.Code code;
        LoginClient.Request request;
        AuthenticationToken authenticationToken;
        AccessToken accessToken;
        AuthenticationToken authenticationToken2;
        int i12 = i11;
        Intent intent2 = intent;
        LoginClient.Result.Code code2 = LoginClient.Result.Code.ERROR;
        FacebookException facebookException = null;
        boolean z12 = false;
        if (intent2 != null) {
            intent2.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent2.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result != null) {
                request = result.request;
                LoginClient.Result.Code code3 = result.code;
                if (i12 != -1) {
                    if (i12 == 0) {
                        z12 = true;
                    }
                    accessToken = null;
                    authenticationToken2 = null;
                } else if (code3 == LoginClient.Result.Code.SUCCESS) {
                    accessToken = result.token;
                    authenticationToken2 = result.authenticationToken;
                } else {
                    authenticationToken2 = null;
                    facebookException = new FacebookAuthorizationException(result.errorMessage);
                    accessToken = null;
                }
                map = result.loggingExtras;
                z11 = z12;
                authenticationToken = authenticationToken2;
                code = code3;
                if (facebookException == null && accessToken == null && !z11) {
                    facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
                }
                FacebookException facebookException2 = facebookException;
                LoginClient.Request request2 = request;
                logCompleteLogin((Context) null, code, map, facebookException2, true, request2);
                finishLogin(accessToken, authenticationToken, request2, facebookException2, z11, facebookCallback);
                return true;
            }
        } else if (i12 == 0) {
            code = LoginClient.Result.Code.CANCEL;
            z11 = true;
            accessToken = null;
            authenticationToken = null;
            request = null;
            map = null;
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
            FacebookException facebookException22 = facebookException;
            LoginClient.Request request22 = request;
            logCompleteLogin((Context) null, code, map, facebookException22, true, request22);
            finishLogin(accessToken, authenticationToken, request22, facebookException22, z11, facebookCallback);
            return true;
        }
        code = code2;
        accessToken = null;
        authenticationToken = null;
        request = null;
        map = null;
        z11 = false;
        facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        FacebookException facebookException222 = facebookException;
        LoginClient.Request request222 = request;
        logCompleteLogin((Context) null, code, map, facebookException222, true, request222);
        finishLogin(accessToken, authenticationToken, request222, facebookException222, z11, facebookCallback);
        return true;
    }

    public final void reauthorizeDataAccess(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
    }

    public final void registerCallback(@Nullable CallbackManager callbackManager, @Nullable FacebookCallback<LoginResult> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new l(this, facebookCallback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public final void resolveError(@NotNull Activity activity, @NotNull GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(graphResponse));
    }

    public final void retrieveLoginStatus(@NotNull Context context, @NotNull LoginStatusCallback loginStatusCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(loginStatusCallback, "responseCallback");
        retrieveLoginStatus(context, 5000, loginStatusCallback);
    }

    @NotNull
    public final LoginManager setAuthType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "authType");
        this.authType = str;
        return this;
    }

    @NotNull
    public final LoginManager setDefaultAudience(@NotNull DefaultAudience defaultAudience2) {
        Intrinsics.checkNotNullParameter(defaultAudience2, "defaultAudience");
        this.defaultAudience = defaultAudience2;
        return this;
    }

    @NotNull
    public final LoginManager setFamilyLogin(boolean z11) {
        this.isFamilyLogin = z11;
        return this;
    }

    @NotNull
    public final LoginManager setLoginBehavior(@NotNull LoginBehavior loginBehavior2) {
        Intrinsics.checkNotNullParameter(loginBehavior2, "loginBehavior");
        this.loginBehavior = loginBehavior2;
        return this;
    }

    @NotNull
    public final LoginManager setLoginTargetApp(@NotNull LoginTargetApp loginTargetApp2) {
        Intrinsics.checkNotNullParameter(loginTargetApp2, "targetApp");
        this.loginTargetApp = loginTargetApp2;
        return this;
    }

    @NotNull
    public final LoginManager setMessengerPageId(@Nullable String str) {
        this.messengerPageId = str;
        return this;
    }

    @NotNull
    public final LoginManager setResetMessengerState(boolean z11) {
        this.resetMessengerState = z11;
        return this;
    }

    @NotNull
    public final LoginManager setShouldSkipAccountDeduplication(boolean z11) {
        this.shouldSkipAccountDeduplication = z11;
        return this;
    }

    public final void unregisterCallback(@Nullable CallbackManager callbackManager) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public final void logIn(@NotNull Fragment fragment, @Nullable Collection<String> collection, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logInWithPublishPermissions(@NotNull Fragment fragment, @NotNull CallbackManager callbackManager, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithPublishPermissions((ActivityResultRegistryOwner) activity, callbackManager, collection);
            return;
        }
        throw new FacebookException(Intrinsics.stringPlus("Cannot obtain activity context on the fragment ", fragment));
    }

    public final void logInWithReadPermissions(@NotNull Fragment fragment, @NotNull CallbackManager callbackManager, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithReadPermissions((ActivityResultRegistryOwner) activity, callbackManager, collection);
            return;
        }
        throw new FacebookException(Intrinsics.stringPlus("Cannot obtain activity context on the fragment ", fragment));
    }

    public final void loginWithConfiguration(@NotNull Activity activity, @NotNull LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        logIn(activity, loginConfiguration);
    }

    @Deprecated(message = "")
    public final void resolveError(@NotNull Fragment fragment, @NotNull GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        resolveError(new FragmentWrapper(fragment), graphResponse);
    }

    public final void retrieveLoginStatus(@NotNull Context context, long j11, @NotNull LoginStatusCallback loginStatusCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(loginStatusCallback, "responseCallback");
        retrieveLoginStatusImpl(context, loginStatusCallback, j11);
    }

    public final void logIn(@NotNull android.app.Fragment fragment, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void reauthorizeDataAccess(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        reauthorizeDataAccess(new FragmentWrapper(fragment));
    }

    public final void resolveError(@NotNull Fragment fragment, @NotNull CallbackManager callbackManager, @NotNull GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            resolveError((ActivityResultRegistryOwner) activity, callbackManager, graphResponse);
            return;
        }
        throw new FacebookException(Intrinsics.stringPlus("Cannot obtain activity context on the fragment ", fragment));
    }

    private final void reauthorizeDataAccess(FragmentWrapper fragmentWrapper) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createReauthorizeRequest());
    }

    public final void logIn(@NotNull android.app.Fragment fragment, @Nullable Collection<String> collection, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logIn(@NotNull FragmentWrapper fragmentWrapper, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
        logIn(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithPublishPermissions(@NotNull android.app.Fragment fragment, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithReadPermissions(@NotNull android.app.Fragment fragment, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
    }

    private final void logInWithPublishPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validatePublishPermissions(collection);
        loginWithConfiguration(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    private final void logInWithReadPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validateReadPermissions(collection);
        logIn(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void resolveError(@NotNull android.app.Fragment fragment, @NotNull GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        resolveError(new FragmentWrapper(fragment), graphResponse);
    }

    private final void resolveError(FragmentWrapper fragmentWrapper, GraphResponse graphResponse) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestFromResponse(graphResponse));
    }

    public final void logIn(@NotNull FragmentWrapper fragmentWrapper, @Nullable Collection<String> collection, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestWithConfig);
    }

    public final void resolveError(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestFromResponse(graphResponse));
    }

    public final void logInWithPublishPermissions(@NotNull Activity activity, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        validatePublishPermissions(collection);
        loginWithConfiguration(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithReadPermissions(@NotNull Activity activity, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        validateReadPermissions(collection);
        logIn(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logIn(@NotNull Activity activity, @Nullable Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        logIn(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithPublishPermissions(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        validatePublishPermissions(collection);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithReadPermissions(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        validateReadPermissions(collection);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logIn(@NotNull FragmentWrapper fragmentWrapper, @NotNull LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(@NotNull Activity activity, @NotNull LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        if (activity instanceof ActivityResultRegistryOwner) {
            Log.w(TAG, "You're calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().");
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(@NotNull Activity activity, @Nullable Collection<String> collection, @Nullable String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig);
    }

    private final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, LoginConfiguration loginConfiguration) {
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> collection, @Nullable String str) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestWithConfig);
    }

    public final void logIn(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }
}
