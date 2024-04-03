package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.VisibleForTesting;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.common.R;
import com.facebook.login.LoginTargetApp;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import v6.s;
import v6.t;
import v6.u;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\f\b\u0016\u0018\u0000 N2\u00020\u0001:\u0006MNOPQRB\u0017\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB=\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020-H\u0016J(\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\bH\u0002J\b\u00106\u001a\u00020-H\u0016J\u0012\u00107\u001a\u00020-2\b\u00108\u001a\u0004\u0018\u00010\fH\u0014J\b\u00109\u001a\u00020-H\u0016J\u0018\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020-H\u0014J\b\u0010?\u001a\u00020-H\u0014J\u0010\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020+H\u0016J\u0012\u0010B\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010\u0005H\u0017J\u0006\u0010D\u001a\u00020-J\u0012\u0010E\u001a\u00020-2\b\u0010F\u001a\u0004\u0018\u00010GH\u0004J\u0012\u0010H\u001a\u00020-2\b\u0010I\u001a\u0004\u0018\u00010\fH\u0004J\u0010\u0010J\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\u0005H\u0004J\u0010\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020\bH\u0003R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0018\u00010%R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\"\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0019\u001a\u0004\u0018\u00010&@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/facebook/internal/WebDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "theme", "", "(Landroid/content/Context;Ljava/lang/String;I)V", "action", "parameters", "Landroid/os/Bundle;", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "listener", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;ILcom/facebook/login/LoginTargetApp;Lcom/facebook/internal/WebDialog$OnCompleteListener;)V", "contentFrameLayout", "Landroid/widget/FrameLayout;", "crossImageView", "Landroid/widget/ImageView;", "expectedRedirectUrl", "isDetached", "", "<set-?>", "isListenerCalled", "()Z", "isPageFinished", "onCompleteListener", "getOnCompleteListener", "()Lcom/facebook/internal/WebDialog$OnCompleteListener;", "setOnCompleteListener", "(Lcom/facebook/internal/WebDialog$OnCompleteListener;)V", "spinner", "Landroid/app/ProgressDialog;", "uploadTask", "Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "Landroid/webkit/WebView;", "webView", "getWebView", "()Landroid/webkit/WebView;", "windowParams", "Landroid/view/WindowManager$LayoutParams;", "cancel", "", "createCrossImage", "dismiss", "getScaledSize", "screenSize", "density", "", "noPaddingSize", "maxPaddingSize", "onAttachedToWindow", "onCreate", "savedInstanceState", "onDetachedFromWindow", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onStart", "onStop", "onWindowAttributesChanged", "params", "parseResponseUri", "urlString", "resize", "sendErrorToListener", "error", "", "sendSuccessToListener", "values", "setExpectedRedirectUrl", "setUpWebView", "margin", "Builder", "Companion", "DialogWebViewClient", "InitCallback", "OnCompleteListener", "UploadStagingResourcesTask", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class WebDialog extends Dialog {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int BACKGROUND_GRAY = -872415232;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int DEFAULT_THEME = R.style.com_facebook_activity_theme;
    public static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
    @NotNull
    private static final String DISPLAY_TOUCH = "touch";
    @NotNull
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
    private static final int MAX_PADDING_SCREEN_WIDTH = 800;
    private static final double MIN_SCALE_FACTOR = 0.5d;
    private static final int NO_PADDING_SCREEN_HEIGHT = 800;
    private static final int NO_PADDING_SCREEN_WIDTH = 480;
    @NotNull
    private static final String PLATFORM_DIALOG_PATH_REGEX = "^/(v\\d+\\.\\d+/)??dialog/.*";
    /* access modifiers changed from: private */
    @Nullable
    public static InitCallback initCallback;
    /* access modifiers changed from: private */
    public static volatile int webDialogTheme;
    /* access modifiers changed from: private */
    @Nullable
    public FrameLayout contentFrameLayout;
    /* access modifiers changed from: private */
    @Nullable
    public ImageView crossImageView;
    /* access modifiers changed from: private */
    @NotNull
    public String expectedRedirectUrl;
    /* access modifiers changed from: private */
    public boolean isDetached;
    private boolean isListenerCalled;
    /* access modifiers changed from: private */
    public boolean isPageFinished;
    @Nullable
    private OnCompleteListener onCompleteListener;
    /* access modifiers changed from: private */
    @Nullable
    public ProgressDialog spinner;
    @Nullable
    private UploadStagingResourcesTask uploadTask;
    /* access modifiers changed from: private */
    @Nullable
    public String url;
    @Nullable
    private WebView webView;
    @Nullable
    private WindowManager.LayoutParams windowParams;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0018"}, d2 = {"Lcom/facebook/internal/WebDialog$DialogWebViewClient;", "Landroid/webkit/WebViewClient;", "(Lcom/facebook/internal/WebDialog;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "errorCode", "", "description", "failingUrl", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class DialogWebViewClient extends WebViewClient {
        final /* synthetic */ WebDialog this$0;

        public DialogWebViewClient(WebDialog webDialog) {
            Intrinsics.checkNotNullParameter(webDialog, "this$0");
            this.this$0 = webDialog;
        }

        public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
            ProgressDialog access$getSpinner$p;
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "url");
            super.onPageFinished(webView, str);
            if (!this.this$0.isDetached && (access$getSpinner$p = this.this$0.spinner) != null) {
                access$getSpinner$p.dismiss();
            }
            FrameLayout access$getContentFrameLayout$p = this.this$0.contentFrameLayout;
            if (access$getContentFrameLayout$p != null) {
                access$getContentFrameLayout$p.setBackgroundColor(0);
            }
            WebView webView2 = this.this$0.getWebView();
            if (webView2 != null) {
                webView2.setVisibility(0);
            }
            ImageView access$getCrossImageView$p = this.this$0.crossImageView;
            if (access$getCrossImageView$p != null) {
                access$getCrossImageView$p.setVisibility(0);
            }
            this.this$0.isPageFinished = true;
        }

        public void onPageStarted(@NotNull WebView webView, @NotNull String str, @Nullable Bitmap bitmap) {
            ProgressDialog access$getSpinner$p;
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "url");
            Utility utility = Utility.INSTANCE;
            Utility.logd(WebDialog.LOG_TAG, Intrinsics.stringPlus("Webview loading URL: ", str));
            super.onPageStarted(webView, str, bitmap);
            if (!this.this$0.isDetached && (access$getSpinner$p = this.this$0.spinner) != null) {
                access$getSpinner$p.show();
            }
        }

        public void onReceivedError(@NotNull WebView webView, int i11, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "description");
            Intrinsics.checkNotNullParameter(str2, "failingUrl");
            super.onReceivedError(webView, i11, str, str2);
            this.this$0.sendErrorToListener(new FacebookDialogException(str, i11, str2));
        }

        public void onReceivedSslError(@NotNull WebView webView, @NotNull SslErrorHandler sslErrorHandler, @NotNull SslError sslError) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(sslErrorHandler, "handler");
            Intrinsics.checkNotNullParameter(sslError, "error");
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            this.this$0.sendErrorToListener(new FacebookDialogException((String) null, -11, (String) null));
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00ab  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.NotNull android.webkit.WebView r6, @org.jetbrains.annotations.NotNull java.lang.String r7) {
            /*
                r5 = this;
                java.lang.String r0 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r6 = "url"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
                com.facebook.internal.Utility r6 = com.facebook.internal.Utility.INSTANCE
                java.lang.String r6 = "Redirect URL: "
                java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r7)
                java.lang.String r0 = "FacebookSDK.WebDialog"
                com.facebook.internal.Utility.logd((java.lang.String) r0, (java.lang.String) r6)
                android.net.Uri r6 = android.net.Uri.parse(r7)
                java.lang.String r0 = r6.getPath()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0031
                java.lang.String r0 = "^/(v\\d+\\.\\d+/)??dialog/.*"
                java.lang.String r6 = r6.getPath()
                boolean r6 = java.util.regex.Pattern.matches(r0, r6)
                if (r6 == 0) goto L_0x0031
                r6 = r1
                goto L_0x0032
            L_0x0031:
                r6 = r2
            L_0x0032:
                com.facebook.internal.WebDialog r0 = r5.this$0
                java.lang.String r0 = r0.expectedRedirectUrl
                r3 = 2
                r4 = 0
                boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r7, r0, r2, r3, r4)
                if (r0 == 0) goto L_0x00c5
                com.facebook.internal.WebDialog r6 = r5.this$0
                android.os.Bundle r6 = r6.parseResponseUri(r7)
                java.lang.String r7 = "error"
                java.lang.String r7 = r6.getString(r7)
                if (r7 != 0) goto L_0x0054
                java.lang.String r7 = "error_type"
                java.lang.String r7 = r6.getString(r7)
            L_0x0054:
                java.lang.String r0 = "error_msg"
                java.lang.String r0 = r6.getString(r0)
                if (r0 != 0) goto L_0x0062
                java.lang.String r0 = "error_message"
                java.lang.String r0 = r6.getString(r0)
            L_0x0062:
                if (r0 != 0) goto L_0x006a
                java.lang.String r0 = "error_description"
                java.lang.String r0 = r6.getString(r0)
            L_0x006a:
                java.lang.String r2 = "error_code"
                java.lang.String r2 = r6.getString(r2)
                r3 = -1
                if (r2 == 0) goto L_0x007e
                boolean r4 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r2)
                if (r4 != 0) goto L_0x007e
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x007e }
                goto L_0x007f
            L_0x007e:
                r2 = r3
            L_0x007f:
                boolean r4 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r7)
                if (r4 == 0) goto L_0x0093
                boolean r4 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r0)
                if (r4 == 0) goto L_0x0093
                if (r2 != r3) goto L_0x0093
                com.facebook.internal.WebDialog r7 = r5.this$0
                r7.sendSuccessToListener(r6)
                goto L_0x00c4
            L_0x0093:
                if (r7 == 0) goto L_0x00ab
                java.lang.String r6 = "access_denied"
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r6)
                if (r6 != 0) goto L_0x00a5
                java.lang.String r6 = "OAuthAccessDeniedException"
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r6)
                if (r6 == 0) goto L_0x00ab
            L_0x00a5:
                com.facebook.internal.WebDialog r6 = r5.this$0
                r6.cancel()
                goto L_0x00c4
            L_0x00ab:
                r6 = 4201(0x1069, float:5.887E-42)
                if (r2 != r6) goto L_0x00b5
                com.facebook.internal.WebDialog r6 = r5.this$0
                r6.cancel()
                goto L_0x00c4
            L_0x00b5:
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>(r2, r7, r0)
                com.facebook.internal.WebDialog r7 = r5.this$0
                com.facebook.FacebookServiceException r2 = new com.facebook.FacebookServiceException
                r2.<init>(r6, r0)
                r7.sendErrorToListener(r2)
            L_0x00c4:
                return r1
            L_0x00c5:
                java.lang.String r0 = "fbconnect://cancel"
                boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r7, r0, r2, r3, r4)
                if (r0 == 0) goto L_0x00d3
                com.facebook.internal.WebDialog r6 = r5.this$0
                r6.cancel()
                return r1
            L_0x00d3:
                if (r6 != 0) goto L_0x00f5
                java.lang.String r6 = "touch"
                boolean r6 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r7, (java.lang.CharSequence) r6, (boolean) r2, (int) r3, (java.lang.Object) r4)
                if (r6 == 0) goto L_0x00de
                goto L_0x00f5
            L_0x00de:
                com.facebook.internal.WebDialog r6 = r5.this$0     // Catch:{ ActivityNotFoundException -> 0x00f3 }
                android.content.Context r6 = r6.getContext()     // Catch:{ ActivityNotFoundException -> 0x00f3 }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x00f3 }
                java.lang.String r3 = "android.intent.action.VIEW"
                android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ ActivityNotFoundException -> 0x00f3 }
                r0.<init>(r3, r7)     // Catch:{ ActivityNotFoundException -> 0x00f3 }
                r6.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x00f3 }
                goto L_0x00f4
            L_0x00f3:
                r1 = r2
            L_0x00f4:
                return r1
            L_0x00f5:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WebDialog.DialogWebViewClient.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/WebDialog$InitCallback;", "", "onInit", "", "webView", "Landroid/webkit/WebView;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface InitCallback {
        void onInit(@Nullable WebView webView);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/facebook/internal/WebDialog$OnCompleteListener;", "", "onComplete", "", "values", "Landroid/os/Bundle;", "error", "Lcom/facebook/FacebookException;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OnCompleteListener {
        void onComplete(@Nullable Bundle bundle, @Nullable FacebookException facebookException);
    }

    @Instrumented
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ+\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0003\"\u00020\u0002H\u0014¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0010\u0012\f\u0012\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b0\u0003X\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "", "action", "parameters", "Landroid/os/Bundle;", "(Lcom/facebook/internal/WebDialog;Ljava/lang/String;Landroid/os/Bundle;)V", "exceptions", "Ljava/lang/Exception;", "Lkotlin/Exception;", "[Ljava/lang/Exception;", "doInBackground", "p0", "([Ljava/lang/Void;)[Ljava/lang/String;", "onPostExecute", "", "results", "([Ljava/lang/String;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class UploadStagingResourcesTask extends AsyncTask implements TraceFieldInterface {
        public Trace _nr_trace;
        @NotNull
        private final String action;
        @NotNull
        private Exception[] exceptions = new Exception[0];
        @NotNull
        private final Bundle parameters;
        final /* synthetic */ WebDialog this$0;

        public UploadStagingResourcesTask(@NotNull WebDialog webDialog, @NotNull String str, Bundle bundle) {
            Intrinsics.checkNotNullParameter(webDialog, "this$0");
            Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
            Intrinsics.checkNotNullParameter(bundle, "parameters");
            this.this$0 = webDialog;
            this.action = str;
            this.parameters = bundle;
        }

        /* access modifiers changed from: private */
        /* renamed from: doInBackground$lambda-0  reason: not valid java name */
        public static final void m8967doInBackground$lambda0(String[] strArr, int i11, UploadStagingResourcesTask uploadStagingResourcesTask, CountDownLatch countDownLatch, GraphResponse graphResponse) {
            Intrinsics.checkNotNullParameter(strArr, "$results");
            Intrinsics.checkNotNullParameter(uploadStagingResourcesTask, "this$0");
            Intrinsics.checkNotNullParameter(countDownLatch, "$latch");
            Intrinsics.checkNotNullParameter(graphResponse, "response");
            try {
                FacebookRequestError error = graphResponse.getError();
                String str = "Error staging photo.";
                if (error != null) {
                    String errorMessage = error.getErrorMessage();
                    if (errorMessage != null) {
                        str = errorMessage;
                    }
                    throw new FacebookGraphResponseException(graphResponse, str);
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject != null) {
                    String optString = jSONObject.optString("uri");
                    if (optString != null) {
                        strArr[i11] = optString;
                        countDownLatch.countDown();
                        return;
                    }
                    throw new FacebookException(str);
                }
                throw new FacebookException(str);
            } catch (Exception e11) {
                uploadStagingResourcesTask.exceptions[i11] = e11;
            }
        }

        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "WebDialog$UploadStagingResourcesTask#doInBackground", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "WebDialog$UploadStagingResourcesTask#doInBackground", (ArrayList<String>) null);
            }
            String[] doInBackground = doInBackground((Void[]) objArr);
            TraceMachine.exitMethod();
            return doInBackground;
        }

        public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "WebDialog$UploadStagingResourcesTask#onPostExecute", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "WebDialog$UploadStagingResourcesTask#onPostExecute", (ArrayList<String>) null);
            }
            onPostExecute((String[]) obj);
            TraceMachine.exitMethod();
        }

        @Nullable
        public String[] doInBackground(@NotNull Void... voidArr) {
            Intrinsics.checkNotNullParameter(voidArr, "p0");
            String[] stringArray = this.parameters.getStringArray(ShareConstants.WEB_DIALOG_PARAM_MEDIA);
            if (stringArray == null) {
                return null;
            }
            String[] strArr = new String[stringArray.length];
            this.exceptions = new Exception[stringArray.length];
            CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            try {
                int length = stringArray.length - 1;
                if (length >= 0) {
                    int i11 = 0;
                    while (true) {
                        int i12 = i11 + 1;
                        if (isCancelled()) {
                            Iterator it = concurrentLinkedQueue.iterator();
                            while (it.hasNext()) {
                                ((GraphRequestAsyncTask) it.next()).cancel(true);
                            }
                            return null;
                        }
                        Uri parse = Uri.parse(stringArray[i11]);
                        if (Utility.isWebUri(parse)) {
                            strArr[i11] = parse.toString();
                            countDownLatch.countDown();
                        } else {
                            c cVar = new c(strArr, i11, this, countDownLatch);
                            ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(parse, "uri");
                            concurrentLinkedQueue.add(ShareInternalUtility.newUploadStagingResourceWithImageRequest(currentAccessToken, parse, (GraphRequest.Callback) cVar).executeAsync());
                        }
                        if (i12 > length) {
                            break;
                        }
                        i11 = i12;
                    }
                }
                countDownLatch.await();
                return strArr;
            } catch (Exception unused) {
                Iterator it2 = concurrentLinkedQueue.iterator();
                while (it2.hasNext()) {
                    ((GraphRequestAsyncTask) it2.next()).cancel(true);
                }
                return null;
            }
        }

        public void onPostExecute(@Nullable String[] strArr) {
            ProgressDialog access$getSpinner$p = this.this$0.spinner;
            if (access$getSpinner$p != null) {
                access$getSpinner$p.dismiss();
            }
            Exception[] excArr = this.exceptions;
            int length = excArr.length;
            int i11 = 0;
            while (i11 < length) {
                Exception exc = excArr[i11];
                i11++;
                if (exc != null) {
                    this.this$0.sendErrorToListener(exc);
                    return;
                }
            }
            if (strArr == null) {
                this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            List asList = ArraysKt___ArraysJvmKt.asList((T[]) strArr);
            if (asList.contains((Object) null)) {
                this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            Utility utility = Utility.INSTANCE;
            Utility.putJSONValueInBundle(this.parameters, ShareConstants.WEB_DIALOG_PARAM_MEDIA, new JSONArray((Collection<?>) asList));
            String dialogAuthority = ServerProtocol.getDialogAuthority();
            this.this$0.url = Utility.buildUri(dialogAuthority, FacebookSdk.getGraphApiVersion() + "/dialog/" + this.action, this.parameters).toString();
            ImageView access$getCrossImageView$p = this.this$0.crossImageView;
            if (access$getCrossImageView$p != null) {
                this.this$0.setUpWebView((access$getCrossImageView$p.getDrawable().getIntrinsicWidth() / 2) + 1);
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.values().length];
            iArr[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WebDialog(@NotNull Context context, @NotNull String str) {
        this(context, str, Companion.getWebDialogTheme());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
    }

    public /* synthetic */ WebDialog(Context context, String str, Bundle bundle, int i11, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, bundle, i11, loginTargetApp, onCompleteListener2);
    }

    private final void createCrossImage() {
        ImageView imageView = new ImageView(getContext());
        this.crossImageView = imageView;
        imageView.setOnClickListener(new t(this));
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.com_facebook_close);
        ImageView imageView2 = this.crossImageView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
        ImageView imageView3 = this.crossImageView;
        if (imageView3 != null) {
            imageView3.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createCrossImage$lambda-5  reason: not valid java name */
    public static final void m8964createCrossImage$lambda5(WebDialog webDialog, View view) {
        Intrinsics.checkNotNullParameter(webDialog, "this$0");
        webDialog.cancel();
    }

    private final int getScaledSize(int i11, float f11, int i12, int i13) {
        int i14 = (int) (((float) i11) / f11);
        return (int) (((double) i11) * (i14 <= i12 ? 1.0d : i14 >= i13 ? 0.5d : ((((double) (i13 - i14)) / ((double) (i13 - i12))) * MIN_SCALE_FACTOR) + MIN_SCALE_FACTOR));
    }

    @JvmStatic
    public static final int getWebDialogTheme() {
        return Companion.getWebDialogTheme();
    }

    @JvmStatic
    public static final void initDefaultTheme(@Nullable Context context) {
        Companion.initDefaultTheme(context);
    }

    @JvmStatic
    @NotNull
    public static final WebDialog newInstance(@NotNull Context context, @Nullable String str, @Nullable Bundle bundle, int i11, @Nullable OnCompleteListener onCompleteListener2) {
        return Companion.newInstance(context, str, bundle, i11, onCompleteListener2);
    }

    @JvmStatic
    @NotNull
    public static final WebDialog newInstance(@NotNull Context context, @Nullable String str, @Nullable Bundle bundle, int i11, @NotNull LoginTargetApp loginTargetApp, @Nullable OnCompleteListener onCompleteListener2) {
        return Companion.newInstance(context, str, bundle, i11, loginTargetApp, onCompleteListener2);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4  reason: not valid java name */
    public static final void m8965onCreate$lambda4(WebDialog webDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(webDialog, "this$0");
        webDialog.cancel();
    }

    @JvmStatic
    public static final void setInitCallback(@Nullable InitCallback initCallback2) {
        Companion.setInitCallback(initCallback2);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public final void setUpWebView(int i11) {
        WebSettings webSettings;
        WebSettings webSettings2;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.webView = new WebDialog$setUpWebView$1(getContext());
        InitCallback initCallback2 = initCallback;
        if (initCallback2 != null) {
            initCallback2.onInit(getWebView());
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setVerticalScrollBarEnabled(false);
        }
        WebView webView3 = this.webView;
        if (webView3 != null) {
            webView3.setHorizontalScrollBarEnabled(false);
        }
        WebView webView4 = this.webView;
        if (webView4 != null) {
            webView4.setWebViewClient(new DialogWebViewClient(this));
        }
        WebView webView5 = this.webView;
        WebSettings webSettings3 = null;
        if (webView5 == null) {
            webSettings = null;
        } else {
            webSettings = webView5.getSettings();
        }
        if (webSettings != null) {
            webSettings.setJavaScriptEnabled(true);
        }
        WebView webView6 = this.webView;
        if (webView6 != null) {
            String str = this.url;
            if (str != null) {
                webView6.loadUrl(str);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        WebView webView7 = this.webView;
        if (webView7 != null) {
            webView7.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        WebView webView8 = this.webView;
        if (webView8 != null) {
            webView8.setVisibility(4);
        }
        WebView webView9 = this.webView;
        if (webView9 == null) {
            webSettings2 = null;
        } else {
            webSettings2 = webView9.getSettings();
        }
        if (webSettings2 != null) {
            webSettings2.setSavePassword(false);
        }
        WebView webView10 = this.webView;
        if (webView10 != null) {
            webSettings3 = webView10.getSettings();
        }
        if (webSettings3 != null) {
            webSettings3.setSaveFormData(false);
        }
        WebView webView11 = this.webView;
        if (webView11 != null) {
            webView11.setFocusable(true);
        }
        WebView webView12 = this.webView;
        if (webView12 != null) {
            webView12.setFocusableInTouchMode(true);
        }
        WebView webView13 = this.webView;
        if (webView13 != null) {
            webView13.setOnTouchListener(new u());
        }
        linearLayout.setPadding(i11, i11, i11, i11);
        linearLayout.addView(this.webView);
        linearLayout.setBackgroundColor(BACKGROUND_GRAY);
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout != null) {
            frameLayout.addView(linearLayout);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpWebView$lambda-7  reason: not valid java name */
    public static final boolean m8966setUpWebView$lambda7(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    @JvmStatic
    public static final void setWebDialogTheme(int i11) {
        Companion.setWebDialogTheme(i11);
    }

    public void cancel() {
        if (this.onCompleteListener != null && !this.isListenerCalled) {
            sendErrorToListener(new FacebookOperationCanceledException());
        }
    }

    public void dismiss() {
        ProgressDialog progressDialog;
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.stopLoading();
        }
        if (!this.isDetached && (progressDialog = this.spinner) != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        super.dismiss();
    }

    @Nullable
    public final OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    @Nullable
    public final WebView getWebView() {
        return this.webView;
    }

    public final boolean isListenerCalled() {
        return this.isListenerCalled;
    }

    public final boolean isPageFinished() {
        return this.isPageFinished;
    }

    public void onAttachedToWindow() {
        WindowManager.LayoutParams layoutParams;
        IBinder iBinder;
        Window window;
        IBinder iBinder2;
        WindowManager.LayoutParams attributes;
        this.isDetached = false;
        Utility utility = Utility.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (Utility.mustFixWindowParamsForAutofill(context) && (layoutParams = this.windowParams) != null) {
            IBinder iBinder3 = null;
            if (layoutParams == null) {
                iBinder = null;
            } else {
                iBinder = layoutParams.token;
            }
            if (iBinder == null) {
                if (layoutParams != null) {
                    Activity ownerActivity = getOwnerActivity();
                    if (ownerActivity == null) {
                        window = null;
                    } else {
                        window = ownerActivity.getWindow();
                    }
                    if (window == null || (attributes = window.getAttributes()) == null) {
                        iBinder2 = null;
                    } else {
                        iBinder2 = attributes.token;
                    }
                    layoutParams.token = iBinder2;
                }
                WindowManager.LayoutParams layoutParams2 = this.windowParams;
                if (layoutParams2 != null) {
                    iBinder3 = layoutParams2.token;
                }
                Utility.logd(LOG_TAG, Intrinsics.stringPlus("Set token on onAttachedToWindow(): ", iBinder3));
            }
        }
        super.onAttachedToWindow();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.spinner = progressDialog;
        progressDialog.requestWindowFeature(1);
        ProgressDialog progressDialog2 = this.spinner;
        if (progressDialog2 != null) {
            progressDialog2.setMessage(getContext().getString(R.string.com_facebook_loading));
        }
        ProgressDialog progressDialog3 = this.spinner;
        if (progressDialog3 != null) {
            progressDialog3.setCanceledOnTouchOutside(false);
        }
        ProgressDialog progressDialog4 = this.spinner;
        if (progressDialog4 != null) {
            progressDialog4.setOnCancelListener(new s(this));
        }
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        resize();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
        createCrossImage();
        if (this.url != null) {
            ImageView imageView = this.crossImageView;
            if (imageView != null) {
                setUpWebView((imageView.getDrawable().getIntrinsicWidth() / 2) + 1);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout != null) {
            frameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        }
        FrameLayout frameLayout2 = this.contentFrameLayout;
        if (frameLayout2 != null) {
            setContentView(frameLayout2);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onDetachedFromWindow() {
        this.isDetached = true;
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int i11, @NotNull KeyEvent keyEvent) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (i11 == 4) {
            WebView webView2 = this.webView;
            if (webView2 != null) {
                if (webView2 == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(webView2.canGoBack());
                }
                if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
                    WebView webView3 = this.webView;
                    if (webView3 == null) {
                        return true;
                    }
                    webView3.goBack();
                    return true;
                }
            }
            cancel();
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public void onStart() {
        AsyncTask.Status status;
        super.onStart();
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            if (uploadStagingResourcesTask == null) {
                status = null;
            } else {
                status = uploadStagingResourcesTask.getStatus();
            }
            if (status == AsyncTask.Status.PENDING) {
                UploadStagingResourcesTask uploadStagingResourcesTask2 = this.uploadTask;
                if (uploadStagingResourcesTask2 != null) {
                    AsyncTaskInstrumentation.execute(uploadStagingResourcesTask2, new Void[0]);
                }
                ProgressDialog progressDialog = this.spinner;
                if (progressDialog != null) {
                    progressDialog.show();
                    return;
                }
                return;
            }
        }
        resize();
    }

    public void onStop() {
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            uploadStagingResourcesTask.cancel(true);
            ProgressDialog progressDialog = this.spinner;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
        super.onStop();
    }

    public void onWindowAttributesChanged(@NotNull WindowManager.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, NativeProtocol.WEB_DIALOG_PARAMS);
        if (layoutParams.token == null) {
            this.windowParams = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    @NotNull
    @VisibleForTesting(otherwise = 4)
    public Bundle parseResponseUri(@Nullable String str) {
        Uri parse = Uri.parse(str);
        Utility utility = Utility.INSTANCE;
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
        parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
        return parseUrlQueryString;
    }

    public final void resize() {
        int i11;
        Object systemService = getContext().getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i12 = displayMetrics.widthPixels;
            int i13 = displayMetrics.heightPixels;
            if (i12 < i13) {
                i11 = i12;
            } else {
                i11 = i13;
            }
            if (i12 < i13) {
                i12 = i13;
            }
            int min = Math.min(getScaledSize(i11, displayMetrics.density, NO_PADDING_SCREEN_WIDTH, 800), displayMetrics.widthPixels);
            int min2 = Math.min(getScaledSize(i12, displayMetrics.density, 800, 1280), displayMetrics.heightPixels);
            Window window = getWindow();
            if (window != null) {
                window.setLayout(min, min2);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final void sendErrorToListener(@Nullable Throwable th2) {
        FacebookException facebookException;
        if (this.onCompleteListener != null && !this.isListenerCalled) {
            this.isListenerCalled = true;
            if (th2 instanceof FacebookException) {
                facebookException = (FacebookException) th2;
            } else {
                facebookException = new FacebookException(th2);
            }
            OnCompleteListener onCompleteListener2 = this.onCompleteListener;
            if (onCompleteListener2 != null) {
                onCompleteListener2.onComplete((Bundle) null, facebookException);
            }
            dismiss();
        }
    }

    public final void sendSuccessToListener(@Nullable Bundle bundle) {
        OnCompleteListener onCompleteListener2 = this.onCompleteListener;
        if (onCompleteListener2 != null && !this.isListenerCalled) {
            this.isListenerCalled = true;
            if (onCompleteListener2 != null) {
                onCompleteListener2.onComplete(bundle, (FacebookException) null);
            }
            dismiss();
        }
    }

    public final void setExpectedRedirectUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "expectedRedirectUrl");
        this.expectedRedirectUrl = str;
    }

    public final void setOnCompleteListener(@Nullable OnCompleteListener onCompleteListener2) {
        this.onCompleteListener = onCompleteListener2;
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0007J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0005J6\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J>\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0012\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/facebook/internal/WebDialog$Companion;", "", "()V", "API_EC_DIALOG_CANCEL", "", "BACKGROUND_GRAY", "DEFAULT_THEME", "DISABLE_SSL_CHECK_FOR_TESTING", "", "DISPLAY_TOUCH", "", "LOG_TAG", "MAX_PADDING_SCREEN_HEIGHT", "MAX_PADDING_SCREEN_WIDTH", "MIN_SCALE_FACTOR", "", "NO_PADDING_SCREEN_HEIGHT", "NO_PADDING_SCREEN_WIDTH", "PLATFORM_DIALOG_PATH_REGEX", "initCallback", "Lcom/facebook/internal/WebDialog$InitCallback;", "webDialogTheme", "getWebDialogTheme", "initDefaultTheme", "", "context", "Landroid/content/Context;", "newInstance", "Lcom/facebook/internal/WebDialog;", "action", "parameters", "Landroid/os/Bundle;", "theme", "listener", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "setInitCallback", "callback", "setWebDialogTheme", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int getWebDialogTheme() {
            Validate.sdkInitialized();
            return WebDialog.webDialogTheme;
        }

        @JvmStatic
        public final void initDefaultTheme(@Nullable Context context) {
            Bundle bundle;
            if (context != null) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo == null) {
                        bundle = null;
                    } else {
                        bundle = applicationInfo.metaData;
                    }
                    if (bundle != null && WebDialog.webDialogTheme == 0) {
                        setWebDialogTheme(applicationInfo.metaData.getInt(FacebookSdk.WEB_DIALOG_THEME));
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }

        @JvmStatic
        @NotNull
        public final WebDialog newInstance(@NotNull Context context, @Nullable String str, @Nullable Bundle bundle, int i11, @Nullable OnCompleteListener onCompleteListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            WebDialog.initDefaultTheme(context);
            return new WebDialog(context, str, bundle, i11, LoginTargetApp.FACEBOOK, onCompleteListener, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final void setInitCallback(@Nullable InitCallback initCallback) {
            WebDialog.initCallback = initCallback;
        }

        @JvmStatic
        public final void setWebDialogTheme(int i11) {
            if (i11 == 0) {
                i11 = WebDialog.DEFAULT_THEME;
            }
            WebDialog.webDialogTheme = i11;
        }

        @JvmStatic
        @NotNull
        public final WebDialog newInstance(@NotNull Context context, @Nullable String str, @Nullable Bundle bundle, int i11, @NotNull LoginTargetApp loginTargetApp, @Nullable OnCompleteListener onCompleteListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(loginTargetApp, "targetApp");
            WebDialog.initDefaultTheme(context);
            return new WebDialog(context, str, bundle, i11, loginTargetApp, onCompleteListener, (DefaultConstructorMarker) null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private WebDialog(Context context, String str, int i11) {
        super(context, i11 == 0 ? Companion.getWebDialogTheme() : i11);
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        this.url = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private WebDialog(Context context, String str, Bundle bundle, int i11, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener2) {
        super(context, i11 == 0 ? Companion.getWebDialogTheme() : i11);
        Uri uri;
        String str2 = ServerProtocol.DIALOG_REDIRECT_URI;
        this.expectedRedirectUrl = str2;
        bundle = bundle == null ? new Bundle() : bundle;
        str2 = Utility.isChromeOS(context) ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : str2;
        this.expectedRedirectUrl = str2;
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, str2);
        bundle.putString("display", "touch");
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.ROOT, "android-%s", Arrays.copyOf(new Object[]{FacebookSdk.getSdkVersion()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        bundle.putString(ServerProtocol.DIALOG_PARAM_SDK_VERSION, format);
        this.onCompleteListener = onCompleteListener2;
        if (!Intrinsics.areEqual((Object) str, (Object) "share") || !bundle.containsKey(ShareConstants.WEB_DIALOG_PARAM_MEDIA)) {
            if (WhenMappings.$EnumSwitchMapping$0[loginTargetApp.ordinal()] == 1) {
                uri = Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), ServerProtocol.INSTAGRAM_OAUTH_PATH, bundle);
            } else {
                String dialogAuthority = ServerProtocol.getDialogAuthority();
                uri = Utility.buildUri(dialogAuthority, FacebookSdk.getGraphApiVersion() + "/dialog/" + str, bundle);
            }
            this.url = uri.toString();
            return;
        }
        this.uploadTask = new UploadStagingResourcesTask(this, str, bundle);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/facebook/internal/WebDialog$Builder;", "", "context", "Landroid/content/Context;", "action", "", "parameters", "Landroid/os/Bundle;", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "applicationId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "accessToken", "Lcom/facebook/AccessToken;", "<set-?>", "getApplicationId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "listener", "getListener", "()Lcom/facebook/internal/WebDialog$OnCompleteListener;", "getParameters", "()Landroid/os/Bundle;", "", "theme", "getTheme", "()I", "build", "Lcom/facebook/internal/WebDialog;", "finishInit", "", "setOnCompleteListener", "setTheme", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class Builder {
        @Nullable
        private AccessToken accessToken;
        @Nullable
        private String action;
        @Nullable
        private String applicationId;
        @Nullable
        private Context context;
        @Nullable
        private OnCompleteListener listener;
        @Nullable
        private Bundle parameters;
        private int theme;

        public Builder(@NotNull Context context2, @NotNull String str, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
            AccessToken.Companion companion = AccessToken.Companion;
            this.accessToken = companion.getCurrentAccessToken();
            if (!companion.isCurrentAccessTokenActive()) {
                String metadataApplicationId = Utility.getMetadataApplicationId(context2);
                if (metadataApplicationId != null) {
                    this.applicationId = metadataApplicationId;
                } else {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            finishInit(context2, str, bundle);
        }

        private final void finishInit(Context context2, String str, Bundle bundle) {
            this.context = context2;
            this.action = str;
            if (bundle != null) {
                this.parameters = bundle;
            } else {
                this.parameters = new Bundle();
            }
        }

        @Nullable
        public WebDialog build() {
            String str;
            AccessToken accessToken2 = this.accessToken;
            if (accessToken2 != null) {
                Bundle bundle = this.parameters;
                String str2 = null;
                if (bundle != null) {
                    if (accessToken2 == null) {
                        str = null;
                    } else {
                        str = accessToken2.getApplicationId();
                    }
                    bundle.putString("app_id", str);
                }
                Bundle bundle2 = this.parameters;
                if (bundle2 != null) {
                    AccessToken accessToken3 = this.accessToken;
                    if (accessToken3 != null) {
                        str2 = accessToken3.getToken();
                    }
                    bundle2.putString("access_token", str2);
                }
            } else {
                Bundle bundle3 = this.parameters;
                if (bundle3 != null) {
                    bundle3.putString("app_id", this.applicationId);
                }
            }
            Companion companion = WebDialog.Companion;
            Context context2 = this.context;
            if (context2 != null) {
                return companion.newInstance(context2, this.action, this.parameters, this.theme, this.listener);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        @Nullable
        public final String getApplicationId() {
            return this.applicationId;
        }

        @Nullable
        public final Context getContext() {
            return this.context;
        }

        @Nullable
        public final OnCompleteListener getListener() {
            return this.listener;
        }

        @Nullable
        public final Bundle getParameters() {
            return this.parameters;
        }

        public final int getTheme() {
            return this.theme;
        }

        @NotNull
        public final Builder setOnCompleteListener(@Nullable OnCompleteListener onCompleteListener) {
            this.listener = onCompleteListener;
            return this;
        }

        @NotNull
        public final Builder setTheme(int i11) {
            this.theme = i11;
            return this;
        }

        public Builder(@NotNull Context context2, @Nullable String str, @NotNull String str2, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(str2, NativeProtocol.WEB_DIALOG_ACTION);
            this.applicationId = Validate.notNullOrEmpty(str == null ? Utility.getMetadataApplicationId(context2) : str, "applicationId");
            finishInit(context2, str2, bundle);
        }
    }
}
