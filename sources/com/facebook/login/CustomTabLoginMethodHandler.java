package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.internal.CustomTab;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0014J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0018H\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/facebook/login/CustomTabLoginMethodHandler;", "Lcom/facebook/login/WebLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "chromePackage", "", "getChromePackage", "()Ljava/lang/String;", "currentPackage", "developerDefinedRedirectURI", "getDeveloperDefinedRedirectURI", "expectedChallenge", "nameForLogging", "getNameForLogging", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "validRedirectURI", "describeContents", "", "getRedirectUrl", "getSSODevice", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCustomTabComplete", "", "url", "request", "Lcom/facebook/login/LoginClient$Request;", "putChallengeParam", "param", "Lorg/json/JSONObject;", "tryAuthorize", "validateChallengeParam", "values", "Landroid/os/Bundle;", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int CHALLENGE_LENGTH = 20;
    @NotNull
    @JvmField
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new CustomTabLoginMethodHandler$Companion$CREATOR$1();
    private static final int CUSTOM_TAB_REQUEST_CODE = 1;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String OAUTH_DIALOG = "oauth";
    @JvmField
    public static boolean calledThroughLoggedOutAppSwitch;
    @Nullable
    private String currentPackage;
    @Nullable
    private String expectedChallenge;
    @NotNull
    private final String nameForLogging;
    @NotNull
    private final AccessTokenSource tokenSource;
    @NotNull
    private String validRedirectURI;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/login/CustomTabLoginMethodHandler$Companion;", "", "()V", "API_EC_DIALOG_CANCEL", "", "CHALLENGE_LENGTH", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/CustomTabLoginMethodHandler;", "CUSTOM_TAB_REQUEST_CODE", "OAUTH_DIALOG", "", "calledThroughLoggedOutAppSwitch", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(@NotNull LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        this.nameForLogging = "custom_tab";
        this.tokenSource = AccessTokenSource.CHROME_CUSTOM_TAB;
        this.expectedChallenge = Utility.generateRandomString(20);
        calledThroughLoggedOutAppSwitch = false;
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectURI());
    }

    private final String getChromePackage() {
        String str = this.currentPackage;
        if (str != null) {
            return str;
        }
        String chromePackage = CustomTabUtils.getChromePackage();
        this.currentPackage = chromePackage;
        return chromePackage;
    }

    private final String getDeveloperDefinedRedirectURI() {
        return super.getRedirectUrl();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onCustomTabComplete(java.lang.String r7, com.facebook.login.LoginClient.Request r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x00d1
            java.lang.String r0 = "fbconnect://cct."
            r1 = 0
            r2 = 2
            r3 = 0
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r7, r0, r1, r2, r3)
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = super.getRedirectUrl()
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r7, r0, r1, r2, r3)
            if (r0 == 0) goto L_0x00d1
        L_0x0017:
            android.net.Uri r7 = android.net.Uri.parse(r7)
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE
            java.lang.String r0 = r7.getQuery()
            android.os.Bundle r0 = com.facebook.internal.Utility.parseUrlQueryString(r0)
            java.lang.String r7 = r7.getFragment()
            android.os.Bundle r7 = com.facebook.internal.Utility.parseUrlQueryString(r7)
            r0.putAll(r7)
            boolean r7 = r6.validateChallengeParam(r0)
            if (r7 != 0) goto L_0x0041
            com.facebook.FacebookException r7 = new com.facebook.FacebookException
            java.lang.String r0 = "Invalid state parameter"
            r7.<init>((java.lang.String) r0)
            super.onComplete(r8, r3, r7)
            return
        L_0x0041:
            java.lang.String r7 = "error"
            java.lang.String r7 = r0.getString(r7)
            if (r7 != 0) goto L_0x004f
            java.lang.String r7 = "error_type"
            java.lang.String r7 = r0.getString(r7)
        L_0x004f:
            java.lang.String r1 = "error_msg"
            java.lang.String r1 = r0.getString(r1)
            if (r1 != 0) goto L_0x005d
            java.lang.String r1 = "error_message"
            java.lang.String r1 = r0.getString(r1)
        L_0x005d:
            if (r1 != 0) goto L_0x0065
            java.lang.String r1 = "error_description"
            java.lang.String r1 = r0.getString(r1)
        L_0x0065:
            java.lang.String r2 = "error_code"
            java.lang.String r2 = r0.getString(r2)
            r4 = -1
            if (r2 != 0) goto L_0x006f
            goto L_0x0074
        L_0x006f:
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0074 }
            goto L_0x0075
        L_0x0074:
            r2 = r4
        L_0x0075:
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r7)
            if (r5 == 0) goto L_0x009c
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r1)
            if (r5 == 0) goto L_0x009c
            if (r2 != r4) goto L_0x009c
            java.lang.String r7 = "access_token"
            boolean r7 = r0.containsKey(r7)
            if (r7 == 0) goto L_0x008f
            super.onComplete(r8, r0, r3)
            return
        L_0x008f:
            java.util.concurrent.Executor r7 = com.facebook.FacebookSdk.getExecutor()
            b7.a r1 = new b7.a
            r1.<init>(r6, r8, r0)
            r7.execute(r1)
            goto L_0x00d1
        L_0x009c:
            if (r7 == 0) goto L_0x00b7
            java.lang.String r0 = "access_denied"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x00ae
            java.lang.String r0 = "OAuthAccessDeniedException"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x00b7
        L_0x00ae:
            com.facebook.FacebookOperationCanceledException r7 = new com.facebook.FacebookOperationCanceledException
            r7.<init>()
            super.onComplete(r8, r3, r7)
            goto L_0x00d1
        L_0x00b7:
            r0 = 4201(0x1069, float:5.887E-42)
            if (r2 != r0) goto L_0x00c4
            com.facebook.FacebookOperationCanceledException r7 = new com.facebook.FacebookOperationCanceledException
            r7.<init>()
            super.onComplete(r8, r3, r7)
            goto L_0x00d1
        L_0x00c4:
            com.facebook.FacebookRequestError r0 = new com.facebook.FacebookRequestError
            r0.<init>(r2, r7, r1)
            com.facebook.FacebookServiceException r7 = new com.facebook.FacebookServiceException
            r7.<init>(r0, r1)
            super.onComplete(r8, r3, r7)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.CustomTabLoginMethodHandler.onCustomTabComplete(java.lang.String, com.facebook.login.LoginClient$Request):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCustomTabComplete$lambda-0  reason: not valid java name */
    public static final void m8986onCustomTabComplete$lambda0(CustomTabLoginMethodHandler customTabLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(customTabLoginMethodHandler, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(bundle, "$values");
        try {
            customTabLoginMethodHandler.onComplete(request, customTabLoginMethodHandler.processCodeExchange(request, bundle), (FacebookException) null);
        } catch (FacebookException e11) {
            customTabLoginMethodHandler.onComplete(request, (Bundle) null, e11);
        }
    }

    private final boolean validateChallengeParam(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return Intrinsics.areEqual((Object) new JSONObject(string).getString(LoginLogger.EVENT_PARAM_CHALLENGE), (Object) this.expectedChallenge);
        } catch (JSONException unused) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    @NotNull
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    @NotNull
    public String getRedirectUrl() {
        return this.validRedirectURI;
    }

    @Nullable
    public String getSSODevice() {
        return "chrome_custom_tab";
    }

    @NotNull
    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    public boolean onActivityResult(int i11, int i12, @Nullable Intent intent) {
        if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
            return super.onActivityResult(i11, i12, intent);
        }
        if (i11 != 1) {
            return super.onActivityResult(i11, i12, intent);
        }
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (pendingRequest == null) {
            return false;
        }
        String str = null;
        if (i12 == -1) {
            if (intent != null) {
                str = intent.getStringExtra(CustomTabMainActivity.EXTRA_URL);
            }
            onCustomTabComplete(str, pendingRequest);
            return true;
        }
        super.onComplete(pendingRequest, (Bundle) null, new FacebookOperationCanceledException());
        return false;
    }

    public void putChallengeParam(@NotNull JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, RemoteMessageConst.MessageBody.PARAM);
        jSONObject.put(LoginLogger.EVENT_PARAM_CHALLENGE, (Object) this.expectedChallenge);
    }

    public int tryAuthorize(@NotNull LoginClient.Request request) {
        boolean z11;
        Intrinsics.checkNotNullParameter(request, "request");
        LoginClient loginClient = getLoginClient();
        if (getRedirectUrl().length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return 0;
        }
        Bundle addExtraParameters = addExtraParameters(getParameters(request), request);
        if (calledThroughLoggedOutAppSwitch) {
            addExtraParameters.putString(ServerProtocol.DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH, "1");
        }
        if (FacebookSdk.hasCustomTabsPrefetching) {
            if (request.isInstagramLogin()) {
                CustomTabPrefetchHelper.Companion.mayLaunchUrl(InstagramCustomTab.Companion.getURIForAction(OAUTH_DIALOG, addExtraParameters));
            } else {
                CustomTabPrefetchHelper.Companion.mayLaunchUrl(CustomTab.Companion.getURIForAction(OAUTH_DIALOG, addExtraParameters));
            }
        }
        FragmentActivity activity = loginClient.getActivity();
        if (activity == null) {
            return 0;
        }
        Intent intent = new Intent(activity, CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, OAUTH_DIALOG);
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, addExtraParameters);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
        intent.putExtra(CustomTabMainActivity.EXTRA_TARGET_APP, request.getLoginTargetApp().toString());
        Fragment fragment = loginClient.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, 1);
        }
        return 1;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        super.writeToParcel(parcel, i11);
        parcel.writeString(this.expectedChallenge);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(@NotNull Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
        this.nameForLogging = "custom_tab";
        this.tokenSource = AccessTokenSource.CHROME_CUSTOM_TAB;
        this.expectedChallenge = parcel.readString();
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectURI());
    }
}
