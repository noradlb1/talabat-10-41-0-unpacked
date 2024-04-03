package com.facebook.login.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import c7.c;
import c7.d;
import c7.e;
import c7.f;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.LoginTargetApp;
import com.facebook.login.R;
import com.facebook.login.widget.ToolTipPopup;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ©\u00012\u00020\u0001:\b©\u0001ª\u0001«\u0001¬\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB9\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010J\b\u0010|\u001a\u00020}H\u0003J\u0006\u0010~\u001a\u00020}J*\u0010\u001a\u00020}2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0015J\u0007\u0010\u0001\u001a\u00020}J\u0012\u0010\u0001\u001a\u00020}2\u0007\u0010\u0001\u001a\u00020\u000eH\u0003J\u0012\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0005J\u0012\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u000eH\u0003J\t\u0010\u0001\u001a\u00020}H\u0015J\t\u0010\u0001\u001a\u00020}H\u0015J\u0013\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u0001H\u0015J6\u0010\u0001\u001a\u00020}2\u0007\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0015J\u001b\u0010\u0001\u001a\u00020}2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0015J\u001c\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\tH\u0015J+\u0010\u0001\u001a\u00020}2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0005J \u0010\u0001\u001a\u00020}2\u0006\u0010\u001e\u001a\u00020\u001d2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001J\t\u0010\u0001\u001a\u00020}H\u0005J\t\u0010\u0001\u001a\u00020}H\u0005J\t\u0010\u0001\u001a\u00020}H\u0005J\t\u0010 \u0001\u001a\u00020}H\u0005J%\u0010Z\u001a\u00020}2\u0017\u0010W\u001a\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0¡\u0001\"\u0004\u0018\u00010\u000e¢\u0006\u0003\u0010¢\u0001J(\u0010£\u0001\u001a\u00020}2\u0017\u0010W\u001a\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0¡\u0001\"\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0003\u0010¢\u0001J\u0017\u0010£\u0001\u001a\u00020}2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u000e0VH\u0007J(\u0010¤\u0001\u001a\u00020}2\u0017\u0010W\u001a\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0¡\u0001\"\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0003\u0010¢\u0001J\u0017\u0010¤\u0001\u001a\u00020}2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u000e0VH\u0007J\u0015\u0010¥\u0001\u001a\u00020}2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0003J\u000f\u0010¨\u0001\u001a\u00020}2\u0006\u0010\u001e\u001a\u00020\u001dR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R$\u0010(\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020'8F@FX\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\t8UX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\t8TX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010/R\u0011\u00102\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0019R$\u00105\u001a\u0002042\u0006\u0010\u0016\u001a\u0002048F@FX\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\t8EX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010/R \u0010<\u001a\b\u0012\u0004\u0012\u00020>0=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020C8F@FX\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR(\u0010I\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0019\"\u0004\bK\u0010\u001bR(\u0010L\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR(\u0010O\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e8F@FX\u000e¢\u0006\f\u001a\u0004\bP\u0010\u0019\"\u0004\bQ\u0010\u001bR\u0018\u0010R\u001a\u00060SR\u00020\u00008TX\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR0\u0010W\u001a\b\u0012\u0004\u0012\u00020\u000e0V2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0V8F@FX\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020]X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R$\u0010`\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\"8F@FX\u000e¢\u0006\f\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0011\u0010e\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bf\u0010bR\u000e\u0010g\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010h\u001a\u00020iX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001a\u0010n\u001a\u00020oX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0010\u0010t\u001a\u0004\u0018\u00010uX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010v\u001a\u00020wX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{¨\u0006­\u0001"}, d2 = {"Lcom/facebook/login/widget/LoginButton;", "Lcom/facebook/FacebookButtonBase;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "analyticsButtonCreatedEventName", "", "analyticsButtonTappedEventName", "(Landroid/content/Context;Landroid/util/AttributeSet;IILjava/lang/String;Ljava/lang/String;)V", "accessTokenTracker", "Lcom/facebook/AccessTokenTracker;", "androidXLoginCaller", "Landroidx/activity/result/ActivityResultLauncher;", "", "value", "authType", "getAuthType", "()Ljava/lang/String;", "setAuthType", "(Ljava/lang/String;)V", "<set-?>", "Lcom/facebook/CallbackManager;", "callbackManager", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "confirmLogout", "", "customButtonRadius", "", "Ljava/lang/Float;", "customButtonTransparency", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "setDefaultAudience", "(Lcom/facebook/login/DefaultAudience;)V", "defaultRequestCode", "getDefaultRequestCode", "()I", "defaultStyleResource", "getDefaultStyleResource", "loggerID", "getLoggerID", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "setLoginBehavior", "(Lcom/facebook/login/LoginBehavior;)V", "loginButtonContinueLabel", "getLoginButtonContinueLabel", "loginManagerLazy", "Lkotlin/Lazy;", "Lcom/facebook/login/LoginManager;", "getLoginManagerLazy", "()Lkotlin/Lazy;", "setLoginManagerLazy", "(Lkotlin/Lazy;)V", "Lcom/facebook/login/LoginTargetApp;", "loginTargetApp", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "setLoginTargetApp", "(Lcom/facebook/login/LoginTargetApp;)V", "loginText", "getLoginText", "setLoginText", "logoutText", "getLogoutText", "setLogoutText", "messengerPageId", "getMessengerPageId", "setMessengerPageId", "newLoginClickListener", "Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "getNewLoginClickListener", "()Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "", "permissions", "getPermissions", "()Ljava/util/List;", "setPermissions", "(Ljava/util/List;)V", "properties", "Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "getProperties", "()Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "resetMessengerState", "getResetMessengerState", "()Z", "setResetMessengerState", "(Z)V", "shouldSkipAccountDeduplication", "getShouldSkipAccountDeduplication", "toolTipChecked", "toolTipDisplayTime", "", "getToolTipDisplayTime", "()J", "setToolTipDisplayTime", "(J)V", "toolTipMode", "Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "getToolTipMode", "()Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "setToolTipMode", "(Lcom/facebook/login/widget/LoginButton$ToolTipMode;)V", "toolTipPopup", "Lcom/facebook/login/widget/ToolTipPopup;", "toolTipStyle", "Lcom/facebook/login/widget/ToolTipPopup$Style;", "getToolTipStyle", "()Lcom/facebook/login/widget/ToolTipPopup$Style;", "setToolTipStyle", "(Lcom/facebook/login/widget/ToolTipPopup$Style;)V", "checkToolTipSettings", "", "clearPermissions", "configureButton", "dismissToolTip", "displayToolTip", "toolTipString", "getLoginButtonWidth", "widthMeasureSpec", "measureButtonWidth", "text", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "heightMeasureSpec", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "parseLoginButtonAttributes", "registerCallback", "callback", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "setButtonIcon", "setButtonRadius", "setButtonText", "setButtonTransparency", "", "([Ljava/lang/String;)V", "setPublishPermissions", "setReadPermissions", "showToolTipPerSettings", "settings", "Lcom/facebook/internal/FetchedAppSettings;", "unregisterCallback", "Companion", "LoginButtonProperties", "LoginClickListener", "ToolTipMode", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class LoginButton extends FacebookButtonBase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_BUTTON_TRANSPARENCY = 255;
    private static final int MIN_BUTTON_TRANSPARENCY = 0;
    private static final String TAG = LoginButton.class.getName();
    @Nullable
    private AccessTokenTracker accessTokenTracker;
    /* access modifiers changed from: private */
    @Nullable
    public ActivityResultLauncher<Collection<String>> androidXLoginCaller;
    @Nullable
    private CallbackManager callbackManager;
    /* access modifiers changed from: private */
    public boolean confirmLogout;
    @Nullable
    private Float customButtonRadius;
    private int customButtonTransparency;
    @NotNull
    private final String loggerID;
    @NotNull
    private Lazy<? extends LoginManager> loginManagerLazy;
    @Nullable
    private String loginText;
    @Nullable
    private String logoutText;
    @NotNull
    private final LoginButtonProperties properties;
    private boolean toolTipChecked;
    private long toolTipDisplayTime;
    @NotNull
    private ToolTipMode toolTipMode;
    @Nullable
    private ToolTipPopup toolTipPopup;
    @NotNull
    private ToolTipPopup.Style toolTipStyle;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/login/widget/LoginButton$Companion;", "", "()V", "MAX_BUTTON_TRANSPARENCY", "", "MIN_BUTTON_TRANSPARENCY", "TAG", "", "kotlin.jvm.PlatformType", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010.\u001a\u00020/R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u00020%2\u0006\u0010*\u001a\u00020%@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)¨\u00060"}, d2 = {"Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "", "()V", "authType", "", "getAuthType", "()Ljava/lang/String;", "setAuthType", "(Ljava/lang/String;)V", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "setDefaultAudience", "(Lcom/facebook/login/DefaultAudience;)V", "loginBehavior", "Lcom/facebook/login/LoginBehavior;", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "setLoginBehavior", "(Lcom/facebook/login/LoginBehavior;)V", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "setLoginTargetApp", "(Lcom/facebook/login/LoginTargetApp;)V", "messengerPageId", "getMessengerPageId", "setMessengerPageId", "permissions", "", "getPermissions", "()Ljava/util/List;", "setPermissions", "(Ljava/util/List;)V", "resetMessengerState", "", "getResetMessengerState", "()Z", "setResetMessengerState", "(Z)V", "<set-?>", "shouldSkipAccountDeduplication", "getShouldSkipAccountDeduplication", "setShouldSkipAccountDeduplication", "clearPermissions", "", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class LoginButtonProperties {
        @NotNull
        private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
        @NotNull
        private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
        @NotNull
        private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        @NotNull
        private LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;
        @Nullable
        private String messengerPageId;
        @NotNull
        private List<String> permissions = CollectionsKt__CollectionsKt.emptyList();
        private boolean resetMessengerState;
        private boolean shouldSkipAccountDeduplication;

        public final void clearPermissions() {
            this.permissions = CollectionsKt__CollectionsKt.emptyList();
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
        public final LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        @NotNull
        public final LoginTargetApp getLoginTargetApp() {
            return this.loginTargetApp;
        }

        @Nullable
        public final String getMessengerPageId() {
            return this.messengerPageId;
        }

        @NotNull
        public final List<String> getPermissions() {
            return this.permissions;
        }

        public final boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public final boolean getShouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        public final void setAuthType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authType = str;
        }

        public final void setDefaultAudience(@NotNull DefaultAudience defaultAudience2) {
            Intrinsics.checkNotNullParameter(defaultAudience2, "<set-?>");
            this.defaultAudience = defaultAudience2;
        }

        public final void setLoginBehavior(@NotNull LoginBehavior loginBehavior2) {
            Intrinsics.checkNotNullParameter(loginBehavior2, "<set-?>");
            this.loginBehavior = loginBehavior2;
        }

        public final void setLoginTargetApp(@NotNull LoginTargetApp loginTargetApp2) {
            Intrinsics.checkNotNullParameter(loginTargetApp2, "<set-?>");
            this.loginTargetApp = loginTargetApp2;
        }

        public final void setMessengerPageId(@Nullable String str) {
            this.messengerPageId = str;
        }

        public final void setPermissions(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.permissions = list;
        }

        public final void setResetMessengerState(boolean z11) {
            this.resetMessengerState = z11;
        }

        public final void setShouldSkipAccountDeduplication(boolean z11) {
            this.shouldSkipAccountDeduplication = z11;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0004J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0004R\u0014\u0010\u0003\u001a\u00020\u00048DX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078DX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "Landroid/view/View$OnClickListener;", "(Lcom/facebook/login/widget/LoginButton;)V", "isFamilyLogin", "", "()Z", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "getLoginManager", "Lcom/facebook/login/LoginManager;", "onClick", "", "v", "Landroid/view/View;", "performLogin", "performLogout", "context", "Landroid/content/Context;", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @AutoHandleExceptions
    public class LoginClickListener implements View.OnClickListener {
        final /* synthetic */ LoginButton this$0;

        public LoginClickListener(LoginButton loginButton) {
            Intrinsics.checkNotNullParameter(loginButton, "this$0");
            this.this$0 = loginButton;
        }

        /* access modifiers changed from: private */
        /* renamed from: performLogout$lambda-2  reason: not valid java name */
        public static final void m9007performLogout$lambda2(LoginManager loginManager, DialogInterface dialogInterface, int i11) {
            Intrinsics.checkNotNullParameter(loginManager, "$loginManager");
            loginManager.logOut();
        }

        @NotNull
        public LoginManager getLoginManager() {
            LoginManager instance = LoginManager.Companion.getInstance();
            instance.setDefaultAudience(this.this$0.getDefaultAudience());
            instance.setLoginBehavior(this.this$0.getLoginBehavior());
            instance.setLoginTargetApp(getLoginTargetApp());
            instance.setAuthType(this.this$0.getAuthType());
            instance.setFamilyLogin(isFamilyLogin());
            instance.setShouldSkipAccountDeduplication(this.this$0.getShouldSkipAccountDeduplication());
            instance.setMessengerPageId(this.this$0.getMessengerPageId());
            instance.setResetMessengerState(this.this$0.getResetMessengerState());
            return instance;
        }

        @NotNull
        public final LoginTargetApp getLoginTargetApp() {
            return LoginTargetApp.FACEBOOK;
        }

        public final boolean isFamilyLogin() {
            return false;
        }

        public void onClick(@NotNull View view) {
            int i11;
            Intrinsics.checkNotNullParameter(view, "v");
            this.this$0.callExternalOnClickListener(view);
            AccessToken.Companion companion = AccessToken.Companion;
            AccessToken currentAccessToken = companion.getCurrentAccessToken();
            boolean isCurrentAccessTokenActive = companion.isCurrentAccessTokenActive();
            if (isCurrentAccessTokenActive) {
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                performLogout(context);
            } else {
                performLogin();
            }
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(this.this$0.getContext());
            Bundle bundle = new Bundle();
            if (currentAccessToken != null) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            bundle.putInt("logging_in", i11);
            bundle.putInt("access_token_expired", isCurrentAccessTokenActive ? 1 : 0);
            internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE, bundle);
        }

        public final void performLogin() {
            LoginManager loginManager = getLoginManager();
            ActivityResultLauncher access$getAndroidXLoginCaller$p = this.this$0.androidXLoginCaller;
            if (access$getAndroidXLoginCaller$p != null) {
                LoginManager.FacebookLoginActivityResultContract facebookLoginActivityResultContract = (LoginManager.FacebookLoginActivityResultContract) access$getAndroidXLoginCaller$p.getContract();
                CallbackManager callbackManager = this.this$0.getCallbackManager();
                if (callbackManager == null) {
                    callbackManager = new CallbackManagerImpl();
                }
                facebookLoginActivityResultContract.setCallbackManager(callbackManager);
                access$getAndroidXLoginCaller$p.launch(this.this$0.getProperties().getPermissions());
            } else if (this.this$0.getFragment() != null) {
                Fragment fragment = this.this$0.getFragment();
                if (fragment != null) {
                    LoginButton loginButton = this.this$0;
                    loginManager.logIn(fragment, (Collection<String>) loginButton.getProperties().getPermissions(), loginButton.getLoggerID());
                }
            } else if (this.this$0.getNativeFragment() != null) {
                android.app.Fragment nativeFragment = this.this$0.getNativeFragment();
                if (nativeFragment != null) {
                    LoginButton loginButton2 = this.this$0;
                    loginManager.logIn(nativeFragment, (Collection<String>) loginButton2.getProperties().getPermissions(), loginButton2.getLoggerID());
                }
            } else {
                loginManager.logIn(this.this$0.getActivity(), (Collection<String>) this.this$0.getProperties().getPermissions(), this.this$0.getLoggerID());
            }
        }

        public final void performLogout(@NotNull Context context) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(context, "context");
            LoginManager loginManager = getLoginManager();
            if (this.this$0.confirmLogout) {
                String string = this.this$0.getResources().getString(R.string.com_facebook_loginview_log_out_action);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.com_facebook_loginview_log_out_action)");
                String string2 = this.this$0.getResources().getString(R.string.com_facebook_loginview_cancel_action);
                Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.com_facebook_loginview_cancel_action)");
                Profile currentProfile = Profile.Companion.getCurrentProfile();
                if (currentProfile == null) {
                    str = null;
                } else {
                    str = currentProfile.getName();
                }
                if (str != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string3 = this.this$0.getResources().getString(R.string.com_facebook_loginview_logged_in_as);
                    Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.com_facebook_loginview_logged_in_as)");
                    str2 = String.format(string3, Arrays.copyOf(new Object[]{currentProfile.getName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
                } else {
                    str2 = this.this$0.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
                    Intrinsics.checkNotNullExpressionValue(str2, "{\n          resources.getString(R.string.com_facebook_loginview_logged_in_using_facebook)\n        }");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage(str2).setCancelable(true).setPositiveButton(string, new f(loginManager)).setNegativeButton(string2, (DialogInterface.OnClickListener) null);
                builder.create().show();
                return;
            }
            loginManager.logOut();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "", "stringValue", "", "intValue", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getIntValue", "()I", "toString", "AUTOMATIC", "DISPLAY_ALWAYS", "NEVER_DISPLAY", "Companion", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ToolTipMode {
        AUTOMATIC(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);
        
        @NotNull
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        @NotNull
        public static final ToolTipMode DEFAULT = null;
        private final int intValue;
        @NotNull
        private final String stringValue;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/facebook/login/widget/LoginButton$ToolTipMode$Companion;", "", "()V", "DEFAULT", "Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "getDEFAULT", "()Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "fromInt", "enumValue", "", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final ToolTipMode fromInt(int i11) {
                for (ToolTipMode toolTipMode : ToolTipMode.values()) {
                    if (toolTipMode.getIntValue() == i11) {
                        return toolTipMode;
                    }
                }
                return null;
            }

            @NotNull
            public final ToolTipMode getDEFAULT() {
                return ToolTipMode.DEFAULT;
            }
        }

        /* access modifiers changed from: public */
        static {
            ToolTipMode toolTipMode;
            Companion = new Companion((DefaultConstructorMarker) null);
            DEFAULT = toolTipMode;
        }

        private ToolTipMode(String str, int i11) {
            this.stringValue = str;
            this.intValue = i11;
        }

        public final int getIntValue() {
            return this.intValue;
        }

        @NotNull
        public String toString() {
            return this.stringValue;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolTipMode.values().length];
            iArr[ToolTipMode.AUTOMATIC.ordinal()] = 1;
            iArr[ToolTipMode.DISPLAY_ALWAYS.ordinal()] = 2;
            iArr[ToolTipMode.NEVER_DISPLAY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12, @NotNull String str, @NotNull String str2) {
        super(context, attributeSet, i11, i12, str, str2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "analyticsButtonCreatedEventName");
        Intrinsics.checkNotNullParameter(str2, "analyticsButtonTappedEventName");
        this.properties = new LoginButtonProperties();
        this.toolTipStyle = ToolTipPopup.Style.BLUE;
        this.toolTipMode = ToolTipMode.Companion.getDEFAULT();
        this.toolTipDisplayTime = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
        this.loginManagerLazy = LazyKt__LazyJVMKt.lazy(LoginButton$loginManagerLazy$1.INSTANCE);
        this.customButtonTransparency = 255;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.loggerID = uuid;
    }

    @AutoHandleExceptions
    private final void checkToolTipSettings() {
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.toolTipMode.ordinal()];
        if (i11 == 1) {
            Utility utility = Utility.INSTANCE;
            FacebookSdk.getExecutor().execute(new e(Utility.getMetadataApplicationId(getContext()), this));
        } else if (i11 == 2) {
            String string = getResources().getString(R.string.com_facebook_tooltip_default);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.com_facebook_tooltip_default)");
            displayToolTip(string);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkToolTipSettings$lambda-3  reason: not valid java name */
    public static final void m9004checkToolTipSettings$lambda3(String str, LoginButton loginButton) {
        Intrinsics.checkNotNullParameter(str, "$appId");
        Intrinsics.checkNotNullParameter(loginButton, "this$0");
        loginButton.getActivity().runOnUiThread(new c(loginButton, FetchedAppSettingsManager.queryAppSettings(str, false)));
    }

    /* access modifiers changed from: private */
    /* renamed from: checkToolTipSettings$lambda-3$lambda-2  reason: not valid java name */
    public static final void m9005checkToolTipSettings$lambda3$lambda2(LoginButton loginButton, FetchedAppSettings fetchedAppSettings) {
        Intrinsics.checkNotNullParameter(loginButton, "this$0");
        loginButton.showToolTipPerSettings(fetchedAppSettings);
    }

    @AutoHandleExceptions
    private final void displayToolTip(String str) {
        ToolTipPopup toolTipPopup2 = new ToolTipPopup(str, this);
        toolTipPopup2.setStyle(this.toolTipStyle);
        toolTipPopup2.setNuxDisplayTime(this.toolTipDisplayTime);
        toolTipPopup2.show();
        this.toolTipPopup = toolTipPopup2;
    }

    @AutoHandleExceptions
    private final int measureButtonWidth(String str) {
        return getCompoundPaddingLeft() + getCompoundDrawablePadding() + measureTextWidth(str) + getCompoundPaddingRight();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-0  reason: not valid java name */
    public static final void m9006onAttachedToWindow$lambda0(CallbackManager.ActivityResultParameters activityResultParameters) {
    }

    @AutoHandleExceptions
    private final void showToolTipPerSettings(FetchedAppSettings fetchedAppSettings) {
        if (fetchedAppSettings != null && fetchedAppSettings.getNuxEnabled() && getVisibility() == 0) {
            displayToolTip(fetchedAppSettings.getNuxContent());
        }
    }

    public final void clearPermissions() {
        this.properties.clearPermissions();
    }

    @AutoHandleExceptions
    public void configureButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.configureButton(context, attributeSet, i11, i12);
        setInternalOnClickListener(getNewLoginClickListener());
        parseLoginButtonAttributes(context, attributeSet, i11, i12);
        if (isInEditMode()) {
            setBackgroundColor(getResources().getColor(com.facebook.common.R.color.com_facebook_blue));
            setLoginText("Continue with Facebook");
        } else {
            this.accessTokenTracker = new LoginButton$configureButton$1(this);
        }
        setButtonText();
        setButtonRadius();
        setButtonTransparency();
        setButtonIcon();
    }

    public final void dismissToolTip() {
        ToolTipPopup toolTipPopup2 = this.toolTipPopup;
        if (toolTipPopup2 != null) {
            toolTipPopup2.dismiss();
        }
        this.toolTipPopup = null;
    }

    @NotNull
    public final String getAuthType() {
        return this.properties.getAuthType();
    }

    @Nullable
    public final CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    @NotNull
    public final DefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    @AutoHandleExceptions
    public int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    }

    public int getDefaultStyleResource() {
        return R.style.com_facebook_loginview_default_style;
    }

    @NotNull
    public final String getLoggerID() {
        return this.loggerID;
    }

    @NotNull
    public final LoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    @StringRes
    public final int getLoginButtonContinueLabel() {
        return R.string.com_facebook_loginview_log_in_button_continue;
    }

    @AutoHandleExceptions
    public final int getLoginButtonWidth(int i11) {
        Resources resources = getResources();
        String str = this.loginText;
        if (str == null) {
            str = resources.getString(R.string.com_facebook_loginview_log_in_button_continue);
            int measureButtonWidth = measureButtonWidth(str);
            if (View.resolveSize(measureButtonWidth, i11) < measureButtonWidth) {
                str = resources.getString(R.string.com_facebook_loginview_log_in_button);
            }
        }
        return measureButtonWidth(str);
    }

    @NotNull
    public final Lazy<LoginManager> getLoginManagerLazy() {
        return this.loginManagerLazy;
    }

    @NotNull
    public final LoginTargetApp getLoginTargetApp() {
        return this.properties.getLoginTargetApp();
    }

    @Nullable
    public final String getLoginText() {
        return this.loginText;
    }

    @Nullable
    public final String getLogoutText() {
        return this.logoutText;
    }

    @Nullable
    public final String getMessengerPageId() {
        return this.properties.getMessengerPageId();
    }

    @NotNull
    public LoginClickListener getNewLoginClickListener() {
        return new LoginClickListener(this);
    }

    @NotNull
    public final List<String> getPermissions() {
        return this.properties.getPermissions();
    }

    @NotNull
    public final LoginButtonProperties getProperties() {
        return this.properties;
    }

    public final boolean getResetMessengerState() {
        return this.properties.getResetMessengerState();
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.properties.getShouldSkipAccountDeduplication();
    }

    public final long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    @NotNull
    public final ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    @NotNull
    public final ToolTipPopup.Style getToolTipStyle() {
        return this.toolTipStyle;
    }

    @AutoHandleExceptions
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getContext() instanceof ActivityResultRegistryOwner) {
            Context context = getContext();
            if (context != null) {
                this.androidXLoginCaller = ((ActivityResultRegistryOwner) context).getActivityResultRegistry().register("facebook-login", ((LoginManager) this.loginManagerLazy.getValue()).createLogInActivityResultContract(this.callbackManager, this.loggerID), new d());
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
            }
        }
        AccessTokenTracker accessTokenTracker2 = this.accessTokenTracker;
        if (accessTokenTracker2 != null && accessTokenTracker2.isTracking()) {
            accessTokenTracker2.startTracking();
            setButtonText();
        }
    }

    @AutoHandleExceptions
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityResultLauncher<Collection<String>> activityResultLauncher = this.androidXLoginCaller;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
        AccessTokenTracker accessTokenTracker2 = this.accessTokenTracker;
        if (accessTokenTracker2 != null) {
            accessTokenTracker2.stopTracking();
        }
        dismissToolTip();
    }

    @AutoHandleExceptions
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (!this.toolTipChecked && !isInEditMode()) {
            this.toolTipChecked = true;
            checkToolTipSettings();
        }
    }

    @AutoHandleExceptions
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        setButtonText();
    }

    @AutoHandleExceptions
    public void onMeasure(int i11, int i12) {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        int compoundPaddingTop = getCompoundPaddingTop() + ((int) Math.ceil((double) (Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom)))) + getCompoundPaddingBottom();
        Resources resources = getResources();
        int loginButtonWidth = getLoginButtonWidth(i11);
        String str = this.logoutText;
        if (str == null) {
            str = resources.getString(R.string.com_facebook_loginview_log_out_button);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.com_facebook_loginview_log_out_button)");
        }
        setMeasuredDimension(View.resolveSize(Math.max(loginButtonWidth, measureButtonWidth(str)), i11), compoundPaddingTop);
    }

    @AutoHandleExceptions
    public void onVisibilityChanged(@NotNull View view, int i11) {
        Intrinsics.checkNotNullParameter(view, "changedView");
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            dismissToolTip();
        }
    }

    @AutoHandleExceptions
    public final void parseLoginButtonAttributes(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        Intrinsics.checkNotNullParameter(context, "context");
        ToolTipMode.Companion companion = ToolTipMode.Companion;
        this.toolTipMode = companion.getDEFAULT();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_login_view, i11, i12);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context\n            .theme\n            .obtainStyledAttributes(\n                attrs, R.styleable.com_facebook_login_view, defStyleAttr, defStyleRes)");
        try {
            this.confirmLogout = obtainStyledAttributes.getBoolean(R.styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
            setLoginText(obtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_login_text));
            setLogoutText(obtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_logout_text));
            ToolTipMode fromInt = companion.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_login_view_com_facebook_tooltip_mode, companion.getDEFAULT().getIntValue()));
            if (fromInt == null) {
                fromInt = companion.getDEFAULT();
            }
            this.toolTipMode = fromInt;
            int i13 = R.styleable.com_facebook_login_view_com_facebook_login_button_radius;
            if (obtainStyledAttributes.hasValue(i13)) {
                this.customButtonRadius = Float.valueOf(obtainStyledAttributes.getDimension(i13, 0.0f));
            }
            int integer = obtainStyledAttributes.getInteger(R.styleable.com_facebook_login_view_com_facebook_login_button_transparency, 255);
            this.customButtonTransparency = integer;
            int max = Math.max(0, integer);
            this.customButtonTransparency = max;
            this.customButtonTransparency = Math.min(255, max);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void registerCallback(@NotNull CallbackManager callbackManager2, @NotNull FacebookCallback<LoginResult> facebookCallback) {
        Intrinsics.checkNotNullParameter(callbackManager2, "callbackManager");
        Intrinsics.checkNotNullParameter(facebookCallback, "callback");
        ((LoginManager) this.loginManagerLazy.getValue()).registerCallback(callbackManager2, facebookCallback);
        CallbackManager callbackManager3 = this.callbackManager;
        if (callbackManager3 == null) {
            this.callbackManager = callbackManager2;
        } else if (callbackManager3 != callbackManager2) {
            Log.w(TAG, "You're registering a callback on the one Facebook login button with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    public final void setAuthType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.properties.setAuthType(str);
    }

    @AutoHandleExceptions
    public final void setButtonIcon() {
        setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), com.facebook.common.R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r2 = (android.graphics.drawable.StateListDrawable) r1;
     */
    @android.annotation.TargetApi(29)
    @com.facebook.internal.instrument.crashshield.AutoHandleExceptions
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setButtonRadius() {
        /*
            r7 = this;
            java.lang.Float r0 = r7.customButtonRadius
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            float r0 = r0.floatValue()
            android.graphics.drawable.Drawable r1 = r7.getBackground()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r2 < r3) goto L_0x003a
            boolean r2 = r1 instanceof android.graphics.drawable.StateListDrawable
            if (r2 == 0) goto L_0x003a
            r2 = r1
            android.graphics.drawable.StateListDrawable r2 = (android.graphics.drawable.StateListDrawable) r2
            int r3 = r2.getStateCount()
            if (r3 <= 0) goto L_0x003a
            r4 = 0
        L_0x0021:
            int r5 = r4 + 1
            android.graphics.drawable.Drawable r4 = r2.getStateDrawable(r4)
            boolean r6 = r4 instanceof android.graphics.drawable.GradientDrawable
            if (r6 == 0) goto L_0x002e
            android.graphics.drawable.GradientDrawable r4 = (android.graphics.drawable.GradientDrawable) r4
            goto L_0x002f
        L_0x002e:
            r4 = 0
        L_0x002f:
            if (r4 != 0) goto L_0x0032
            goto L_0x0035
        L_0x0032:
            r4.setCornerRadius(r0)
        L_0x0035:
            if (r5 < r3) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r4 = r5
            goto L_0x0021
        L_0x003a:
            boolean r2 = r1 instanceof android.graphics.drawable.GradientDrawable
            if (r2 == 0) goto L_0x0043
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            r1.setCornerRadius(r0)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.widget.LoginButton.setButtonRadius():void");
    }

    @AutoHandleExceptions
    public final void setButtonText() {
        Resources resources = getResources();
        if (isInEditMode() || !AccessToken.Companion.isCurrentAccessTokenActive()) {
            String str = this.loginText;
            if (str != null) {
                setText(str);
                return;
            }
            String string = resources.getString(getLoginButtonContinueLabel());
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(loginButtonContinueLabel)");
            int width = getWidth();
            if (width != 0 && measureButtonWidth(string) > width) {
                string = resources.getString(R.string.com_facebook_loginview_log_in_button);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.com_facebook_loginview_log_in_button)");
            }
            setText(string);
            return;
        }
        String str2 = this.logoutText;
        if (str2 == null) {
            str2 = resources.getString(R.string.com_facebook_loginview_log_out_button);
        }
        setText(str2);
    }

    @AutoHandleExceptions
    public final void setButtonTransparency() {
        getBackground().setAlpha(this.customButtonTransparency);
    }

    public final void setDefaultAudience(@NotNull DefaultAudience defaultAudience) {
        Intrinsics.checkNotNullParameter(defaultAudience, "value");
        this.properties.setDefaultAudience(defaultAudience);
    }

    public final void setLoginBehavior(@NotNull LoginBehavior loginBehavior) {
        Intrinsics.checkNotNullParameter(loginBehavior, "value");
        this.properties.setLoginBehavior(loginBehavior);
    }

    public final void setLoginManagerLazy(@NotNull Lazy<? extends LoginManager> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.loginManagerLazy = lazy;
    }

    public final void setLoginTargetApp(@NotNull LoginTargetApp loginTargetApp) {
        Intrinsics.checkNotNullParameter(loginTargetApp, "value");
        this.properties.setLoginTargetApp(loginTargetApp);
    }

    public final void setLoginText(@Nullable String str) {
        this.loginText = str;
        setButtonText();
    }

    public final void setLogoutText(@Nullable String str) {
        this.logoutText = str;
        setButtonText();
    }

    public final void setMessengerPageId(@Nullable String str) {
        this.properties.setMessengerPageId(str);
    }

    public final void setPermissions(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        this.properties.setPermissions(CollectionsKt__CollectionsKt.listOfNotNull((T[]) Arrays.copyOf(strArr, strArr.length)));
    }

    @Deprecated(message = "Use setPermissions instead", replaceWith = @ReplaceWith(expression = "setPermissions", imports = {}))
    public final void setPublishPermissions(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "permissions");
        this.properties.setPermissions(list);
    }

    @Deprecated(message = "Use setPermissions instead", replaceWith = @ReplaceWith(expression = "setPermissions", imports = {}))
    public final void setReadPermissions(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "permissions");
        this.properties.setPermissions(list);
    }

    public final void setResetMessengerState(boolean z11) {
        this.properties.setResetMessengerState(z11);
    }

    public final void setToolTipDisplayTime(long j11) {
        this.toolTipDisplayTime = j11;
    }

    public final void setToolTipMode(@NotNull ToolTipMode toolTipMode2) {
        Intrinsics.checkNotNullParameter(toolTipMode2, "<set-?>");
        this.toolTipMode = toolTipMode2;
    }

    public final void setToolTipStyle(@NotNull ToolTipPopup.Style style) {
        Intrinsics.checkNotNullParameter(style, "<set-?>");
        this.toolTipStyle = style;
    }

    public final void unregisterCallback(@NotNull CallbackManager callbackManager2) {
        Intrinsics.checkNotNullParameter(callbackManager2, "callbackManager");
        ((LoginManager) this.loginManagerLazy.getValue()).unregisterCallback(callbackManager2);
    }

    public final void setPermissions(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.properties.setPermissions(list);
    }

    @Deprecated(message = "Use setPermissions instead", replaceWith = @ReplaceWith(expression = "setPermissions", imports = {}))
    public final void setPublishPermissions(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        this.properties.setPermissions(CollectionsKt__CollectionsKt.listOfNotNull((T[]) Arrays.copyOf(strArr, strArr.length)));
    }

    @Deprecated(message = "Use setPermissions instead", replaceWith = @ReplaceWith(expression = "setPermissions", imports = {}))
    public final void setReadPermissions(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        this.properties.setPermissions(CollectionsKt__CollectionsKt.listOfNotNull((T[]) Arrays.copyOf(strArr, strArr.length)));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoginButton(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoginButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoginButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
