package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.common.R;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.huawei.hms.push.AttributionReporter;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.tekartik.sqflite.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u0000 q2\u00020\u0001:\u0005pqrstB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u0013J \u0010I\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u0013H\u0002J\u0010\u0010J\u001a\u00020F2\b\u0010K\u001a\u0004\u0018\u00010@J\u0006\u0010L\u001a\u00020FJ\u0006\u0010M\u001a\u00020\u0013J\u000e\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u001cJ\u000e\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u00020F2\u0006\u0010Q\u001a\u00020RJ\b\u0010T\u001a\u00020FH\u0002J\b\u0010U\u001a\u00020\u0019H\u0016J\b\u0010V\u001a\u0004\u0018\u00010'J\u001d\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\u0006\u0010K\u001a\u00020@H\u0016¢\u0006\u0002\u0010WJ2\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020R2\u0018\u00103\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010[H\u0002JF\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020\u001c2\b\u0010\\\u001a\u0004\u0018\u00010\u001c2\b\u0010]\u001a\u0004\u0018\u00010\u001c2\u0018\u00103\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010[H\u0002J\u0006\u0010^\u001a\u00020FJ\u0006\u0010_\u001a\u00020FJ\u0010\u0010`\u001a\u00020F2\u0006\u0010Q\u001a\u00020RH\u0002J \u0010a\u001a\u00020\u00132\u0006\u0010b\u001a\u00020\u00192\u0006\u0010c\u001a\u00020\u00192\b\u0010d\u001a\u0004\u0018\u00010eJ\u0010\u0010f\u001a\u00020F2\u0006\u0010g\u001a\u00020\u0019H\u0004J\u0010\u0010h\u001a\u00020F2\b\u0010K\u001a\u0004\u0018\u00010@J\u0006\u0010i\u001a\u00020\u0013J\u0006\u0010j\u001a\u00020FJ\u000e\u0010k\u001a\u00020F2\u0006\u0010l\u001a\u00020RJ\u0018\u0010m\u001a\u00020F2\u0006\u0010n\u001a\u00020\u00062\u0006\u0010o\u001a\u00020\u0019H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0003@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u0004R$\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010-\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b.\u0010\u0015R\u0014\u0010/\u001a\u0002008BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R(\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u0010\u00106\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006u"}, d2 = {"Lcom/facebook/login/LoginClient;", "Landroid/os/Parcelable;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "backgroundProcessingListener", "Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "getBackgroundProcessingListener", "()Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "setBackgroundProcessingListener", "(Lcom/facebook/login/LoginClient$BackgroundProcessingListener;)V", "checkedInternetPermission", "", "getCheckedInternetPermission", "()Z", "setCheckedInternetPermission", "(Z)V", "currentHandler", "", "extraData", "", "", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "value", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "handlersToTry", "", "Lcom/facebook/login/LoginMethodHandler;", "getHandlersToTry", "()[Lcom/facebook/login/LoginMethodHandler;", "setHandlersToTry", "([Lcom/facebook/login/LoginMethodHandler;)V", "[Lcom/facebook/login/LoginMethodHandler;", "inProgress", "getInProgress", "logger", "Lcom/facebook/login/LoginLogger;", "getLogger", "()Lcom/facebook/login/LoginLogger;", "loggingExtras", "getLoggingExtras", "setLoggingExtras", "loginLogger", "numActivitiesReturned", "numTotalIntentsFired", "onCompletedListener", "Lcom/facebook/login/LoginClient$OnCompletedListener;", "getOnCompletedListener", "()Lcom/facebook/login/LoginClient$OnCompletedListener;", "setOnCompletedListener", "(Lcom/facebook/login/LoginClient$OnCompletedListener;)V", "pendingRequest", "Lcom/facebook/login/LoginClient$Request;", "getPendingRequest", "()Lcom/facebook/login/LoginClient$Request;", "setPendingRequest", "(Lcom/facebook/login/LoginClient$Request;)V", "addExtraData", "", "key", "accumulate", "addLoggingExtra", "authorize", "request", "cancelCurrentHandler", "checkInternetPermission", "checkPermission", "permission", "complete", "outcome", "Lcom/facebook/login/LoginClient$Result;", "completeAndValidate", "completeWithFailure", "describeContents", "getCurrentHandler", "(Lcom/facebook/login/LoginClient$Request;)[Lcom/facebook/login/LoginMethodHandler;", "logAuthorizationMethodComplete", "method", "result", "", "errorMessage", "errorCode", "notifyBackgroundProcessingStart", "notifyBackgroundProcessingStop", "notifyOnCompleteListener", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "setCurrentHandlerIndex", "index", "startOrContinueAuth", "tryCurrentHandler", "tryNextHandler", "validateSameFbidAndFinish", "pendingResult", "writeToParcel", "dest", "flags", "BackgroundProcessingListener", "Companion", "OnCompletedListener", "Request", "Result", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LoginClient implements Parcelable {
    @NotNull
    @JvmField
    public static final Parcelable.Creator<LoginClient> CREATOR = new LoginClient$Companion$CREATOR$1();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private BackgroundProcessingListener backgroundProcessingListener;
    private boolean checkedInternetPermission;
    private int currentHandler = -1;
    @Nullable
    private Map<String, String> extraData;
    @Nullable
    private Fragment fragment;
    @Nullable
    private LoginMethodHandler[] handlersToTry;
    @Nullable
    private Map<String, String> loggingExtras;
    @Nullable
    private LoginLogger loginLogger;
    private int numActivitiesReturned;
    private int numTotalIntentsFired;
    @Nullable
    private OnCompletedListener onCompletedListener;
    @Nullable
    private Request pendingRequest;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "", "onBackgroundProcessingStarted", "", "onBackgroundProcessingStopped", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    @Instrumented
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginClient$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/LoginClient;", "getE2E", "", "getLoginRequestCode", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String getE2E() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("init", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
            Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation, "e2e.toString()");
            return jSONObjectInstrumentation;
        }

        @JvmStatic
        public final int getLoginRequestCode() {
            return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/LoginClient$OnCompletedListener;", "", "onCompleted", "", "result", "Lcom/facebook/login/LoginClient$Result;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OnCompletedListener {
        void onCompleted(@NotNull Result result);
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB7\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bBA\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fB\u000f\b\u0012\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0017H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/login/LoginClient$Result;", "Landroid/os/Parcelable;", "request", "Lcom/facebook/login/LoginClient$Request;", "code", "Lcom/facebook/login/LoginClient$Result$Code;", "token", "Lcom/facebook/AccessToken;", "errorMessage", "", "errorCode", "(Lcom/facebook/login/LoginClient$Request;Lcom/facebook/login/LoginClient$Result$Code;Lcom/facebook/AccessToken;Ljava/lang/String;Ljava/lang/String;)V", "accessToken", "authenticationToken", "Lcom/facebook/AuthenticationToken;", "(Lcom/facebook/login/LoginClient$Request;Lcom/facebook/login/LoginClient$Result$Code;Lcom/facebook/AccessToken;Lcom/facebook/AuthenticationToken;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "extraData", "", "loggingExtras", "describeContents", "", "writeToParcel", "", "dest", "flags", "Code", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Result implements Parcelable {
        @NotNull
        @JvmField
        public static final Parcelable.Creator<Result> CREATOR = new LoginClient$Result$Companion$CREATOR$1();
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Nullable
        @JvmField
        public final AuthenticationToken authenticationToken;
        @NotNull
        @JvmField
        public final Code code;
        @Nullable
        @JvmField
        public final String errorCode;
        @Nullable
        @JvmField
        public final String errorMessage;
        @Nullable
        @JvmField
        public Map<String, String> extraData;
        @Nullable
        @JvmField
        public Map<String, String> loggingExtras;
        @Nullable
        @JvmField
        public final Request request;
        @Nullable
        @JvmField
        public final AccessToken token;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginClient$Result$Code;", "", "loggingValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLoggingValue", "()Ljava/lang/String;", "SUCCESS", "CANCEL", "ERROR", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public enum Code {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");
            
            @NotNull
            private final String loggingValue;

            private Code(String str) {
                this.loggingValue = str;
            }

            @NotNull
            public final String getLoggingValue() {
                return this.loggingValue;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J&\u0010\u000b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J2\u0010\u0010\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\rH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/login/LoginClient$Result$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/LoginClient$Result;", "createCancelResult", "request", "Lcom/facebook/login/LoginClient$Request;", "message", "", "createCompositeTokenResult", "accessToken", "Lcom/facebook/AccessToken;", "authenticationToken", "Lcom/facebook/AuthenticationToken;", "createErrorResult", "errorType", "errorDescription", "errorCode", "createTokenResult", "token", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ Result createErrorResult$default(Companion companion, Request request, String str, String str2, String str3, int i11, Object obj) {
                if ((i11 & 8) != 0) {
                    str3 = null;
                }
                return companion.createErrorResult(request, str, str2, str3);
            }

            @JvmStatic
            @NotNull
            public final Result createCancelResult(@Nullable Request request, @Nullable String str) {
                return new Result(request, Code.CANCEL, (AccessToken) null, str, (String) null);
            }

            @JvmStatic
            @NotNull
            public final Result createCompositeTokenResult(@Nullable Request request, @Nullable AccessToken accessToken, @Nullable AuthenticationToken authenticationToken) {
                return new Result(request, Code.SUCCESS, accessToken, authenticationToken, (String) null, (String) null);
            }

            @JvmStatic
            @NotNull
            @JvmOverloads
            public final Result createErrorResult(@Nullable Request request, @Nullable String str, @Nullable String str2) {
                return createErrorResult$default(this, request, str, str2, (String) null, 8, (Object) null);
            }

            @JvmStatic
            @NotNull
            @JvmOverloads
            public final Result createErrorResult(@Nullable Request request, @Nullable String str, @Nullable String str2, @Nullable String str3) {
                ArrayList arrayList = new ArrayList();
                if (str != null) {
                    arrayList.add(str);
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
                return new Result(request, Code.ERROR, (AccessToken) null, TextUtils.join(": ", arrayList), str3);
            }

            @JvmStatic
            @NotNull
            public final Result createTokenResult(@Nullable Request request, @NotNull AccessToken accessToken) {
                Intrinsics.checkNotNullParameter(accessToken, LegacyTokenLocalDataSourceImpl.KEY);
                return new Result(request, Code.SUCCESS, accessToken, (String) null, (String) null);
            }
        }

        public /* synthetic */ Result(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Result(@Nullable Request request2, @NotNull Code code2, @Nullable AccessToken accessToken, @Nullable String str, @Nullable String str2) {
            this(request2, code2, accessToken, (AuthenticationToken) null, str, str2);
            Intrinsics.checkNotNullParameter(code2, Constant.PARAM_ERROR_CODE);
        }

        @JvmStatic
        @NotNull
        public static final Result createCancelResult(@Nullable Request request2, @Nullable String str) {
            return Companion.createCancelResult(request2, str);
        }

        @JvmStatic
        @NotNull
        public static final Result createCompositeTokenResult(@Nullable Request request2, @Nullable AccessToken accessToken, @Nullable AuthenticationToken authenticationToken2) {
            return Companion.createCompositeTokenResult(request2, accessToken, authenticationToken2);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public static final Result createErrorResult(@Nullable Request request2, @Nullable String str, @Nullable String str2) {
            return Companion.createErrorResult(request2, str, str2);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public static final Result createErrorResult(@Nullable Request request2, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            return Companion.createErrorResult(request2, str, str2, str3);
        }

        @JvmStatic
        @NotNull
        public static final Result createTokenResult(@Nullable Request request2, @NotNull AccessToken accessToken) {
            return Companion.createTokenResult(request2, accessToken);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.code.name());
            parcel.writeParcelable(this.token, i11);
            parcel.writeParcelable(this.authenticationToken, i11);
            parcel.writeString(this.errorMessage);
            parcel.writeString(this.errorCode);
            parcel.writeParcelable(this.request, i11);
            Utility utility = Utility.INSTANCE;
            Utility.writeNonnullStringMapToParcel(parcel, this.loggingExtras);
            Utility.writeNonnullStringMapToParcel(parcel, this.extraData);
        }

        public Result(@Nullable Request request2, @NotNull Code code2, @Nullable AccessToken accessToken, @Nullable AuthenticationToken authenticationToken2, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(code2, Constant.PARAM_ERROR_CODE);
            this.request = request2;
            this.token = accessToken;
            this.authenticationToken = authenticationToken2;
            this.errorMessage = str;
            this.code = code2;
            this.errorCode = str2;
        }

        private Result(Parcel parcel) {
            String readString = parcel.readString();
            this.code = Code.valueOf(readString == null ? "error" : readString);
            this.token = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.authenticationToken = (AuthenticationToken) parcel.readParcelable(AuthenticationToken.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.errorCode = parcel.readString();
            this.request = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readNonnullStringMapFromParcel(parcel);
            this.extraData = Utility.readNonnullStringMapFromParcel(parcel);
        }
    }

    public LoginClient(@NotNull Fragment fragment2) {
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        setFragment(fragment2);
    }

    private final void addLoggingExtra(String str, String str2, boolean z11) {
        Map<String, String> map = this.loggingExtras;
        if (map == null) {
            map = new HashMap<>();
        }
        if (this.loggingExtras == null) {
            this.loggingExtras = map;
        }
        if (map.containsKey(str) && z11) {
            str2 = map.get(str) + AbstractJsonLexerKt.COMMA + str2;
        }
        map.put(str, str2);
    }

    private final void completeWithFailure() {
        complete(Result.Companion.createErrorResult$default(Result.Companion, this.pendingRequest, "Login attempt failed.", (String) null, (String) null, 8, (Object) null));
    }

    @JvmStatic
    @NotNull
    public static final String getE2E() {
        return Companion.getE2E();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2) == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.facebook.login.LoginLogger getLogger() {
        /*
            r3 = this;
            com.facebook.login.LoginLogger r0 = r3.loginLogger
            if (r0 == 0) goto L_0x0018
            java.lang.String r1 = r0.getApplicationId()
            com.facebook.login.LoginClient$Request r2 = r3.pendingRequest
            if (r2 != 0) goto L_0x000e
            r2 = 0
            goto L_0x0012
        L_0x000e:
            java.lang.String r2 = r2.getApplicationId()
        L_0x0012:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x0036
        L_0x0018:
            com.facebook.login.LoginLogger r0 = new com.facebook.login.LoginLogger
            androidx.fragment.app.FragmentActivity r1 = r3.getActivity()
            if (r1 != 0) goto L_0x0024
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()
        L_0x0024:
            com.facebook.login.LoginClient$Request r2 = r3.pendingRequest
            if (r2 != 0) goto L_0x002d
            java.lang.String r2 = com.facebook.FacebookSdk.getApplicationId()
            goto L_0x0031
        L_0x002d:
            java.lang.String r2 = r2.getApplicationId()
        L_0x0031:
            r0.<init>(r1, r2)
            r3.loginLogger = r0
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.getLogger():com.facebook.login.LoginLogger");
    }

    @JvmStatic
    public static final int getLoginRequestCode() {
        return Companion.getLoginRequestCode();
    }

    private final void logAuthorizationMethodComplete(String str, Result result, Map<String, String> map) {
        logAuthorizationMethodComplete(str, result.code.getLoggingValue(), result.errorMessage, result.errorCode, map);
    }

    private final void notifyOnCompleteListener(Result result) {
        OnCompletedListener onCompletedListener2 = this.onCompletedListener;
        if (onCompletedListener2 != null) {
            onCompletedListener2.onCompleted(result);
        }
    }

    public final void addExtraData(@NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        Map<String, String> map = this.extraData;
        if (map == null) {
            map = new HashMap<>();
        }
        if (this.extraData == null) {
            this.extraData = map;
        }
        if (map.containsKey(str) && z11) {
            str2 = map.get(str) + AbstractJsonLexerKt.COMMA + str2;
        }
        map.put(str, str2);
    }

    public final void authorize(@Nullable Request request) {
        if (request != null) {
            if (this.pendingRequest != null) {
                throw new FacebookException("Attempted to authorize while a request is pending.");
            } else if (!AccessToken.Companion.isCurrentAccessTokenActive() || checkInternetPermission()) {
                this.pendingRequest = request;
                this.handlersToTry = getHandlersToTry(request);
                tryNextHandler();
            }
        }
    }

    public final void cancelCurrentHandler() {
        LoginMethodHandler currentHandler2 = getCurrentHandler();
        if (currentHandler2 != null) {
            currentHandler2.cancel();
        }
    }

    public final boolean checkInternetPermission() {
        String str;
        if (this.checkedInternetPermission) {
            return true;
        }
        if (checkPermission("android.permission.INTERNET") != 0) {
            FragmentActivity activity = getActivity();
            String str2 = null;
            if (activity == null) {
                str = null;
            } else {
                str = activity.getString(R.string.com_facebook_internet_permission_error_title);
            }
            if (activity != null) {
                str2 = activity.getString(R.string.com_facebook_internet_permission_error_message);
            }
            complete(Result.Companion.createErrorResult$default(Result.Companion, this.pendingRequest, str, str2, (String) null, 8, (Object) null));
            return false;
        }
        this.checkedInternetPermission = true;
        return true;
    }

    public final int checkPermission(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AttributionReporter.SYSTEM_PERMISSION);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return -1;
        }
        return activity.checkCallingOrSelfPermission(str);
    }

    public final void complete(@NotNull Result result) {
        Intrinsics.checkNotNullParameter(result, "outcome");
        LoginMethodHandler currentHandler2 = getCurrentHandler();
        if (currentHandler2 != null) {
            logAuthorizationMethodComplete(currentHandler2.getNameForLogging(), result, currentHandler2.getMethodLoggingExtras());
        }
        Map<String, String> map = this.loggingExtras;
        if (map != null) {
            result.loggingExtras = map;
        }
        Map<String, String> map2 = this.extraData;
        if (map2 != null) {
            result.extraData = map2;
        }
        this.handlersToTry = null;
        this.currentHandler = -1;
        this.pendingRequest = null;
        this.loggingExtras = null;
        this.numActivitiesReturned = 0;
        this.numTotalIntentsFired = 0;
        notifyOnCompleteListener(result);
    }

    public final void completeAndValidate(@NotNull Result result) {
        Intrinsics.checkNotNullParameter(result, "outcome");
        if (result.token == null || !AccessToken.Companion.isCurrentAccessTokenActive()) {
            complete(result);
        } else {
            validateSameFbidAndFinish(result);
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final FragmentActivity getActivity() {
        Fragment fragment2 = this.fragment;
        if (fragment2 == null) {
            return null;
        }
        return fragment2.getActivity();
    }

    @Nullable
    public final BackgroundProcessingListener getBackgroundProcessingListener() {
        return this.backgroundProcessingListener;
    }

    public final boolean getCheckedInternetPermission() {
        return this.checkedInternetPermission;
    }

    @Nullable
    public final LoginMethodHandler getCurrentHandler() {
        LoginMethodHandler[] loginMethodHandlerArr;
        int i11 = this.currentHandler;
        if (i11 < 0 || (loginMethodHandlerArr = this.handlersToTry) == null) {
            return null;
        }
        return loginMethodHandlerArr[i11];
    }

    @Nullable
    public final Map<String, String> getExtraData() {
        return this.extraData;
    }

    @Nullable
    public final Fragment getFragment() {
        return this.fragment;
    }

    @Nullable
    public final LoginMethodHandler[] getHandlersToTry() {
        return this.handlersToTry;
    }

    public final boolean getInProgress() {
        return this.pendingRequest != null && this.currentHandler >= 0;
    }

    @Nullable
    public final Map<String, String> getLoggingExtras() {
        return this.loggingExtras;
    }

    @Nullable
    public final OnCompletedListener getOnCompletedListener() {
        return this.onCompletedListener;
    }

    @Nullable
    public final Request getPendingRequest() {
        return this.pendingRequest;
    }

    public final void notifyBackgroundProcessingStart() {
        BackgroundProcessingListener backgroundProcessingListener2 = this.backgroundProcessingListener;
        if (backgroundProcessingListener2 != null) {
            backgroundProcessingListener2.onBackgroundProcessingStarted();
        }
    }

    public final void notifyBackgroundProcessingStop() {
        BackgroundProcessingListener backgroundProcessingListener2 = this.backgroundProcessingListener;
        if (backgroundProcessingListener2 != null) {
            backgroundProcessingListener2.onBackgroundProcessingStopped();
        }
    }

    public final boolean onActivityResult(int i11, int i12, @Nullable Intent intent) {
        this.numActivitiesReturned++;
        if (this.pendingRequest != null) {
            if (intent == null || !intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
                LoginMethodHandler currentHandler2 = getCurrentHandler();
                if (currentHandler2 != null && (!currentHandler2.shouldKeepTrackOfMultipleIntents() || intent != null || this.numActivitiesReturned >= this.numTotalIntentsFired)) {
                    return currentHandler2.onActivityResult(i11, i12, intent);
                }
            } else {
                tryNextHandler();
                return false;
            }
        }
        return false;
    }

    public final void setBackgroundProcessingListener(@Nullable BackgroundProcessingListener backgroundProcessingListener2) {
        this.backgroundProcessingListener = backgroundProcessingListener2;
    }

    public final void setCheckedInternetPermission(boolean z11) {
        this.checkedInternetPermission = z11;
    }

    public final void setCurrentHandlerIndex(int i11) {
        this.currentHandler = i11;
    }

    public final void setExtraData(@Nullable Map<String, String> map) {
        this.extraData = map;
    }

    public final void setFragment(@Nullable Fragment fragment2) {
        if (this.fragment == null) {
            this.fragment = fragment2;
            return;
        }
        throw new FacebookException("Can't set fragment once it is already set.");
    }

    public final void setHandlersToTry(@Nullable LoginMethodHandler[] loginMethodHandlerArr) {
        this.handlersToTry = loginMethodHandlerArr;
    }

    public final void setLoggingExtras(@Nullable Map<String, String> map) {
        this.loggingExtras = map;
    }

    public final void setOnCompletedListener(@Nullable OnCompletedListener onCompletedListener2) {
        this.onCompletedListener = onCompletedListener2;
    }

    public final void setPendingRequest(@Nullable Request request) {
        this.pendingRequest = request;
    }

    public final void startOrContinueAuth(@Nullable Request request) {
        if (!getInProgress()) {
            authorize(request);
        }
    }

    public final boolean tryCurrentHandler() {
        String str;
        String str2;
        LoginMethodHandler currentHandler2 = getCurrentHandler();
        if (currentHandler2 == null) {
            return false;
        }
        if (!currentHandler2.needsInternetPermission() || checkInternetPermission()) {
            Request request = this.pendingRequest;
            if (request == null) {
                return false;
            }
            int tryAuthorize = currentHandler2.tryAuthorize(request);
            this.numActivitiesReturned = 0;
            if (tryAuthorize > 0) {
                LoginLogger logger = getLogger();
                String authId = request.getAuthId();
                String nameForLogging = currentHandler2.getNameForLogging();
                if (request.isFamilyLogin()) {
                    str2 = LoginLogger.EVENT_NAME_FOA_LOGIN_METHOD_START;
                } else {
                    str2 = LoginLogger.EVENT_NAME_LOGIN_METHOD_START;
                }
                logger.logAuthorizationMethodStart(authId, nameForLogging, str2);
                this.numTotalIntentsFired = tryAuthorize;
            } else {
                LoginLogger logger2 = getLogger();
                String authId2 = request.getAuthId();
                String nameForLogging2 = currentHandler2.getNameForLogging();
                if (request.isFamilyLogin()) {
                    str = LoginLogger.EVENT_NAME_FOA_LOGIN_METHOD_NOT_TRIED;
                } else {
                    str = LoginLogger.EVENT_NAME_LOGIN_METHOD_NOT_TRIED;
                }
                logger2.logAuthorizationMethodNotTried(authId2, nameForLogging2, str);
                addLoggingExtra(LoginLogger.EVENT_EXTRAS_NOT_TRIED, currentHandler2.getNameForLogging(), true);
            }
            if (tryAuthorize > 0) {
                return true;
            }
            return false;
        }
        addLoggingExtra(LoginLogger.EVENT_EXTRAS_MISSING_INTERNET_PERMISSION, "1", false);
        return false;
    }

    public final void tryNextHandler() {
        LoginMethodHandler currentHandler2 = getCurrentHandler();
        if (currentHandler2 != null) {
            logAuthorizationMethodComplete(currentHandler2.getNameForLogging(), LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, (String) null, (String) null, currentHandler2.getMethodLoggingExtras());
        }
        LoginMethodHandler[] loginMethodHandlerArr = this.handlersToTry;
        while (loginMethodHandlerArr != null) {
            int i11 = this.currentHandler;
            if (i11 >= loginMethodHandlerArr.length - 1) {
                break;
            }
            this.currentHandler = i11 + 1;
            if (tryCurrentHandler()) {
                return;
            }
        }
        if (this.pendingRequest != null) {
            completeWithFailure();
        }
    }

    public final void validateSameFbidAndFinish(@NotNull Result result) {
        Result result2;
        Intrinsics.checkNotNullParameter(result, "pendingResult");
        if (result.token != null) {
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            AccessToken accessToken = result.token;
            if (currentAccessToken != null) {
                try {
                    if (Intrinsics.areEqual((Object) currentAccessToken.getUserId(), (Object) accessToken.getUserId())) {
                        result2 = Result.Companion.createCompositeTokenResult(this.pendingRequest, result.token, result.authenticationToken);
                        complete(result2);
                        return;
                    }
                } catch (Exception e11) {
                    complete(Result.Companion.createErrorResult$default(Result.Companion, this.pendingRequest, "Caught exception", e11.getMessage(), (String) null, 8, (Object) null));
                    return;
                }
            }
            result2 = Result.Companion.createErrorResult$default(Result.Companion, this.pendingRequest, "User logged in as different Facebook user.", (String) null, (String) null, 8, (Object) null);
            complete(result2);
            return;
        }
        throw new FacebookException("Can't validate without a token");
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelableArray((Parcelable[]) this.handlersToTry, i11);
        parcel.writeInt(this.currentHandler);
        parcel.writeParcelable(this.pendingRequest, i11);
        Utility utility = Utility.INSTANCE;
        Utility.writeNonnullStringMapToParcel(parcel, this.loggingExtras);
        Utility.writeNonnullStringMapToParcel(parcel, this.extraData);
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u0001KB{\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013B\u000f\b\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\b\u0010C\u001a\u00020DH\u0016J\u0006\u0010E\u001a\u00020+J\u000e\u0010F\u001a\u00020G2\u0006\u0010B\u001a\u00020+J\u0006\u0010B\u001a\u00020+J\u0018\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u00020DH\u0016R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001bR\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b/\u0010,R\u001a\u00100\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0018\"\u0004\b9\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0018R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010,\"\u0004\bA\u0010.R\u000e\u0010B\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/facebook/login/LoginClient$Request;", "Landroid/os/Parcelable;", "loginBehavior", "Lcom/facebook/login/LoginBehavior;", "permissions", "", "", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "authType", "applicationId", "authId", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "nonce", "codeVerifier", "codeChallenge", "codeChallengeMethod", "Lcom/facebook/login/CodeChallengeMethod;", "(Lcom/facebook/login/LoginBehavior;Ljava/util/Set;Lcom/facebook/login/DefaultAudience;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/login/LoginTargetApp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/login/CodeChallengeMethod;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getApplicationId", "()Ljava/lang/String;", "getAuthId", "setAuthId", "(Ljava/lang/String;)V", "getAuthType", "setAuthType", "getCodeChallenge", "getCodeChallengeMethod", "()Lcom/facebook/login/CodeChallengeMethod;", "getCodeVerifier", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "deviceAuthTargetUserId", "getDeviceAuthTargetUserId", "setDeviceAuthTargetUserId", "deviceRedirectUriString", "getDeviceRedirectUriString", "setDeviceRedirectUriString", "isFamilyLogin", "", "()Z", "setFamilyLogin", "(Z)V", "isInstagramLogin", "isRerequest", "setRerequest", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "loginTargetApp", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "messengerPageId", "getMessengerPageId", "setMessengerPageId", "getNonce", "getPermissions", "()Ljava/util/Set;", "setPermissions", "(Ljava/util/Set;)V", "resetMessengerState", "getResetMessengerState", "setResetMessengerState", "shouldSkipAccountDeduplication", "describeContents", "", "hasPublishPermission", "setShouldSkipAccountDeduplication", "", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Request implements Parcelable {
        @NotNull
        @JvmField
        public static final Parcelable.Creator<Request> CREATOR = new LoginClient$Request$Companion$CREATOR$1();
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        private final String applicationId;
        @NotNull
        private String authId;
        @NotNull
        private String authType;
        @Nullable
        private final String codeChallenge;
        @Nullable
        private final CodeChallengeMethod codeChallengeMethod;
        @Nullable
        private final String codeVerifier;
        @NotNull
        private final DefaultAudience defaultAudience;
        @Nullable
        private String deviceAuthTargetUserId;
        @Nullable
        private String deviceRedirectUriString;
        private boolean isFamilyLogin;
        private boolean isRerequest;
        @NotNull
        private final LoginBehavior loginBehavior;
        @NotNull
        private final LoginTargetApp loginTargetApp;
        @Nullable
        private String messengerPageId;
        @NotNull
        private final String nonce;
        @NotNull
        private Set<String> permissions;
        private boolean resetMessengerState;
        private boolean shouldSkipAccountDeduplication;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/LoginClient$Request$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/LoginClient$Request;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Request(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Request(@org.jetbrains.annotations.NotNull com.facebook.login.LoginBehavior r16, @org.jetbrains.annotations.Nullable java.util.Set<java.lang.String> r17, @org.jetbrains.annotations.NotNull com.facebook.login.DefaultAudience r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21) {
            /*
                r15 = this;
                java.lang.String r0 = "loginBehavior"
                r2 = r16
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "defaultAudience"
                r4 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "authType"
                r5 = r19
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "applicationId"
                r6 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "authId"
                r7 = r21
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 1984(0x7c0, float:2.78E-42)
                r14 = 0
                r1 = r15
                r3 = r17
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.Request.<init>(com.facebook.login.LoginBehavior, java.util.Set, com.facebook.login.DefaultAudience, java.lang.String, java.lang.String, java.lang.String):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Request(@org.jetbrains.annotations.NotNull com.facebook.login.LoginBehavior r16, @org.jetbrains.annotations.Nullable java.util.Set<java.lang.String> r17, @org.jetbrains.annotations.NotNull com.facebook.login.DefaultAudience r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.Nullable com.facebook.login.LoginTargetApp r22) {
            /*
                r15 = this;
                java.lang.String r0 = "loginBehavior"
                r2 = r16
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "defaultAudience"
                r4 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "authType"
                r5 = r19
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "applicationId"
                r6 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "authId"
                r7 = r21
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 1920(0x780, float:2.69E-42)
                r14 = 0
                r1 = r15
                r3 = r17
                r8 = r22
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.Request.<init>(com.facebook.login.LoginBehavior, java.util.Set, com.facebook.login.DefaultAudience, java.lang.String, java.lang.String, java.lang.String, com.facebook.login.LoginTargetApp):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Request(@org.jetbrains.annotations.NotNull com.facebook.login.LoginBehavior r16, @org.jetbrains.annotations.Nullable java.util.Set<java.lang.String> r17, @org.jetbrains.annotations.NotNull com.facebook.login.DefaultAudience r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.Nullable com.facebook.login.LoginTargetApp r22, @org.jetbrains.annotations.Nullable java.lang.String r23) {
            /*
                r15 = this;
                java.lang.String r0 = "loginBehavior"
                r2 = r16
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "defaultAudience"
                r4 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "authType"
                r5 = r19
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "applicationId"
                r6 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "authId"
                r7 = r21
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 1792(0x700, float:2.511E-42)
                r14 = 0
                r1 = r15
                r3 = r17
                r8 = r22
                r9 = r23
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.Request.<init>(com.facebook.login.LoginBehavior, java.util.Set, com.facebook.login.DefaultAudience, java.lang.String, java.lang.String, java.lang.String, com.facebook.login.LoginTargetApp, java.lang.String):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Request(@org.jetbrains.annotations.NotNull com.facebook.login.LoginBehavior r16, @org.jetbrains.annotations.Nullable java.util.Set<java.lang.String> r17, @org.jetbrains.annotations.NotNull com.facebook.login.DefaultAudience r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.Nullable com.facebook.login.LoginTargetApp r22, @org.jetbrains.annotations.Nullable java.lang.String r23, @org.jetbrains.annotations.Nullable java.lang.String r24) {
            /*
                r15 = this;
                java.lang.String r0 = "loginBehavior"
                r2 = r16
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "defaultAudience"
                r4 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "authType"
                r5 = r19
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "applicationId"
                r6 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "authId"
                r7 = r21
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                r11 = 0
                r12 = 0
                r13 = 1536(0x600, float:2.152E-42)
                r14 = 0
                r1 = r15
                r3 = r17
                r8 = r22
                r9 = r23
                r10 = r24
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.Request.<init>(com.facebook.login.LoginBehavior, java.util.Set, com.facebook.login.DefaultAudience, java.lang.String, java.lang.String, java.lang.String, com.facebook.login.LoginTargetApp, java.lang.String, java.lang.String):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Request(@org.jetbrains.annotations.NotNull com.facebook.login.LoginBehavior r16, @org.jetbrains.annotations.Nullable java.util.Set<java.lang.String> r17, @org.jetbrains.annotations.NotNull com.facebook.login.DefaultAudience r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.Nullable com.facebook.login.LoginTargetApp r22, @org.jetbrains.annotations.Nullable java.lang.String r23, @org.jetbrains.annotations.Nullable java.lang.String r24, @org.jetbrains.annotations.Nullable java.lang.String r25) {
            /*
                r15 = this;
                java.lang.String r0 = "loginBehavior"
                r2 = r16
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "defaultAudience"
                r4 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "authType"
                r5 = r19
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "applicationId"
                r6 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "authId"
                r7 = r21
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                r12 = 0
                r13 = 1024(0x400, float:1.435E-42)
                r14 = 0
                r1 = r15
                r3 = r17
                r8 = r22
                r9 = r23
                r10 = r24
                r11 = r25
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.Request.<init>(com.facebook.login.LoginBehavior, java.util.Set, com.facebook.login.DefaultAudience, java.lang.String, java.lang.String, java.lang.String, com.facebook.login.LoginTargetApp, java.lang.String, java.lang.String, java.lang.String):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Request(com.facebook.login.LoginBehavior r15, java.util.Set r16, com.facebook.login.DefaultAudience r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, com.facebook.login.LoginTargetApp r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, com.facebook.login.CodeChallengeMethod r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
            /*
                r14 = this;
                r0 = r26
                r1 = r0 & 64
                if (r1 == 0) goto L_0x000a
                com.facebook.login.LoginTargetApp r1 = com.facebook.login.LoginTargetApp.FACEBOOK
                r9 = r1
                goto L_0x000c
            L_0x000a:
                r9 = r21
            L_0x000c:
                r1 = r0 & 128(0x80, float:1.794E-43)
                r2 = 0
                if (r1 == 0) goto L_0x0013
                r10 = r2
                goto L_0x0015
            L_0x0013:
                r10 = r22
            L_0x0015:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x001b
                r11 = r2
                goto L_0x001d
            L_0x001b:
                r11 = r23
            L_0x001d:
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L_0x0023
                r12 = r2
                goto L_0x0025
            L_0x0023:
                r12 = r24
            L_0x0025:
                r0 = r0 & 1024(0x400, float:1.435E-42)
                if (r0 == 0) goto L_0x002b
                r13 = r2
                goto L_0x002d
            L_0x002b:
                r13 = r25
            L_0x002d:
                r2 = r14
                r3 = r15
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r8 = r20
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.Request.<init>(com.facebook.login.LoginBehavior, java.util.Set, com.facebook.login.DefaultAudience, java.lang.String, java.lang.String, java.lang.String, com.facebook.login.LoginTargetApp, java.lang.String, java.lang.String, java.lang.String, com.facebook.login.CodeChallengeMethod, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getApplicationId() {
            return this.applicationId;
        }

        @NotNull
        public final String getAuthId() {
            return this.authId;
        }

        @NotNull
        public final String getAuthType() {
            return this.authType;
        }

        @Nullable
        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        @Nullable
        public final CodeChallengeMethod getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }

        @Nullable
        public final String getCodeVerifier() {
            return this.codeVerifier;
        }

        @NotNull
        public final DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        @Nullable
        public final String getDeviceAuthTargetUserId() {
            return this.deviceAuthTargetUserId;
        }

        @Nullable
        public final String getDeviceRedirectUriString() {
            return this.deviceRedirectUriString;
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
        public final String getNonce() {
            return this.nonce;
        }

        @NotNull
        public final Set<String> getPermissions() {
            return this.permissions;
        }

        public final boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public final boolean hasPublishPermission() {
            for (String isPublishPermission : this.permissions) {
                if (LoginManager.Companion.isPublishPermission(isPublishPermission)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isFamilyLogin() {
            return this.isFamilyLogin;
        }

        public final boolean isInstagramLogin() {
            return this.loginTargetApp == LoginTargetApp.INSTAGRAM;
        }

        public final boolean isRerequest() {
            return this.isRerequest;
        }

        public final void setAuthId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authId = str;
        }

        public final void setAuthType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authType = str;
        }

        public final void setDeviceAuthTargetUserId(@Nullable String str) {
            this.deviceAuthTargetUserId = str;
        }

        public final void setDeviceRedirectUriString(@Nullable String str) {
            this.deviceRedirectUriString = str;
        }

        public final void setFamilyLogin(boolean z11) {
            this.isFamilyLogin = z11;
        }

        public final void setMessengerPageId(@Nullable String str) {
            this.messengerPageId = str;
        }

        public final void setPermissions(@NotNull Set<String> set) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            this.permissions = set;
        }

        public final void setRerequest(boolean z11) {
            this.isRerequest = z11;
        }

        public final void setResetMessengerState(boolean z11) {
            this.resetMessengerState = z11;
        }

        public final void setShouldSkipAccountDeduplication(boolean z11) {
            this.shouldSkipAccountDeduplication = z11;
        }

        public final boolean shouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            String str;
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.loginBehavior.name());
            parcel.writeStringList(new ArrayList(this.permissions));
            parcel.writeString(this.defaultAudience.name());
            parcel.writeString(this.applicationId);
            parcel.writeString(this.authId);
            parcel.writeByte(this.isRerequest ? (byte) 1 : 0);
            parcel.writeString(this.deviceRedirectUriString);
            parcel.writeString(this.authType);
            parcel.writeString(this.deviceAuthTargetUserId);
            parcel.writeString(this.messengerPageId);
            parcel.writeByte(this.resetMessengerState ? (byte) 1 : 0);
            parcel.writeString(this.loginTargetApp.name());
            parcel.writeByte(this.isFamilyLogin ? (byte) 1 : 0);
            parcel.writeByte(this.shouldSkipAccountDeduplication ? (byte) 1 : 0);
            parcel.writeString(this.nonce);
            parcel.writeString(this.codeVerifier);
            parcel.writeString(this.codeChallenge);
            CodeChallengeMethod codeChallengeMethod2 = this.codeChallengeMethod;
            if (codeChallengeMethod2 == null) {
                str = null;
            } else {
                str = codeChallengeMethod2.name();
            }
            parcel.writeString(str);
        }

        @JvmOverloads
        public Request(@NotNull LoginBehavior loginBehavior2, @Nullable Set<String> set, @NotNull DefaultAudience defaultAudience2, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable LoginTargetApp loginTargetApp2, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable CodeChallengeMethod codeChallengeMethod2) {
            Intrinsics.checkNotNullParameter(loginBehavior2, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience2, "defaultAudience");
            Intrinsics.checkNotNullParameter(str, "authType");
            Intrinsics.checkNotNullParameter(str2, "applicationId");
            Intrinsics.checkNotNullParameter(str3, "authId");
            this.loginBehavior = loginBehavior2;
            this.permissions = set == null ? new HashSet<>() : set;
            this.defaultAudience = defaultAudience2;
            this.authType = str;
            this.applicationId = str2;
            this.authId = str3;
            this.loginTargetApp = loginTargetApp2 == null ? LoginTargetApp.FACEBOOK : loginTargetApp2;
            if (str4 != null) {
                if (!(str4.length() == 0)) {
                    this.nonce = str4;
                    this.codeVerifier = str5;
                    this.codeChallenge = str6;
                    this.codeChallengeMethod = codeChallengeMethod2;
                }
            }
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            this.nonce = uuid;
            this.codeVerifier = str5;
            this.codeChallenge = str6;
            this.codeChallengeMethod = codeChallengeMethod2;
        }

        private Request(Parcel parcel) {
            DefaultAudience defaultAudience2;
            LoginTargetApp loginTargetApp2;
            CodeChallengeMethod codeChallengeMethod2;
            Validate validate = Validate.INSTANCE;
            this.loginBehavior = LoginBehavior.valueOf(Validate.notNullOrEmpty(parcel.readString(), "loginBehavior"));
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            String readString = parcel.readString();
            if (readString != null) {
                defaultAudience2 = DefaultAudience.valueOf(readString);
            } else {
                defaultAudience2 = DefaultAudience.NONE;
            }
            this.defaultAudience = defaultAudience2;
            this.applicationId = Validate.notNullOrEmpty(parcel.readString(), "applicationId");
            this.authId = Validate.notNullOrEmpty(parcel.readString(), "authId");
            boolean z11 = true;
            this.isRerequest = parcel.readByte() != 0;
            this.deviceRedirectUriString = parcel.readString();
            this.authType = Validate.notNullOrEmpty(parcel.readString(), "authType");
            this.deviceAuthTargetUserId = parcel.readString();
            this.messengerPageId = parcel.readString();
            this.resetMessengerState = parcel.readByte() != 0;
            String readString2 = parcel.readString();
            if (readString2 != null) {
                loginTargetApp2 = LoginTargetApp.valueOf(readString2);
            } else {
                loginTargetApp2 = LoginTargetApp.FACEBOOK;
            }
            this.loginTargetApp = loginTargetApp2;
            this.isFamilyLogin = parcel.readByte() != 0;
            this.shouldSkipAccountDeduplication = parcel.readByte() == 0 ? false : z11;
            this.nonce = Validate.notNullOrEmpty(parcel.readString(), "nonce");
            this.codeVerifier = parcel.readString();
            this.codeChallenge = parcel.readString();
            String readString3 = parcel.readString();
            if (readString3 == null) {
                codeChallengeMethod2 = null;
            } else {
                codeChallengeMethod2 = CodeChallengeMethod.valueOf(readString3);
            }
            this.codeChallengeMethod = codeChallengeMethod2;
        }
    }

    @Nullable
    public LoginMethodHandler[] getHandlersToTry(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ArrayList arrayList = new ArrayList();
        LoginBehavior loginBehavior = request.getLoginBehavior();
        if (!request.isInstagramLogin()) {
            if (loginBehavior.allowsGetTokenAuth()) {
                arrayList.add(new GetTokenLoginMethodHandler(this));
            }
            if (!FacebookSdk.bypassAppSwitch && loginBehavior.allowsKatanaAuth()) {
                arrayList.add(new KatanaProxyLoginMethodHandler(this));
            }
        } else if (!FacebookSdk.bypassAppSwitch && loginBehavior.allowsInstagramAppAuth()) {
            arrayList.add(new InstagramAppLoginMethodHandler(this));
        }
        if (loginBehavior.allowsCustomTabAuth()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (loginBehavior.allowsWebViewAuth()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (!request.isInstagramLogin() && loginBehavior.allowsDeviceAuth()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        Object[] array = arrayList.toArray(new LoginMethodHandler[0]);
        if (array != null) {
            return (LoginMethodHandler[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, Map<String, String> map) {
        Request request = this.pendingRequest;
        String str5 = LoginLogger.EVENT_NAME_LOGIN_METHOD_COMPLETE;
        if (request == null) {
            getLogger().logUnexpectedError(str5, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
            return;
        }
        LoginLogger logger = getLogger();
        String authId = request.getAuthId();
        if (request.isFamilyLogin()) {
            str5 = LoginLogger.EVENT_NAME_FOA_LOGIN_METHOD_COMPLETE;
        }
        logger.logAuthorizationMethodComplete(authId, str, str2, str3, str4, map, str5);
    }

    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Object, com.facebook.login.LoginMethodHandler] */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LoginClient(@org.jetbrains.annotations.NotNull android.os.Parcel r9) {
        /*
            r8 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r8.<init>()
            r0 = -1
            r8.currentHandler = r0
            java.lang.Class<com.facebook.login.LoginMethodHandler> r0 = com.facebook.login.LoginMethodHandler.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable[] r0 = r9.readParcelableArray(r0)
            r1 = 0
            if (r0 != 0) goto L_0x001a
            android.os.Parcelable[] r0 = new android.os.Parcelable[r1]
        L_0x001a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r3 = r0.length
            r4 = r1
        L_0x0021:
            r5 = 0
            if (r4 >= r3) goto L_0x003b
            r6 = r0[r4]
            boolean r7 = r6 instanceof com.facebook.login.LoginMethodHandler
            if (r7 == 0) goto L_0x002d
            r5 = r6
            com.facebook.login.LoginMethodHandler r5 = (com.facebook.login.LoginMethodHandler) r5
        L_0x002d:
            if (r5 != 0) goto L_0x0030
            goto L_0x0033
        L_0x0030:
            r5.setLoginClient(r8)
        L_0x0033:
            if (r5 == 0) goto L_0x0038
            r2.add(r5)
        L_0x0038:
            int r4 = r4 + 1
            goto L_0x0021
        L_0x003b:
            com.facebook.login.LoginMethodHandler[] r0 = new com.facebook.login.LoginMethodHandler[r1]
            java.lang.Object[] r0 = r2.toArray(r0)
            if (r0 == 0) goto L_0x0077
            com.facebook.login.LoginMethodHandler[] r0 = (com.facebook.login.LoginMethodHandler[]) r0
            r8.handlersToTry = r0
            int r0 = r9.readInt()
            r8.currentHandler = r0
            java.lang.Class<com.facebook.login.LoginClient$Request> r0 = com.facebook.login.LoginClient.Request.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r9.readParcelable(r0)
            com.facebook.login.LoginClient$Request r0 = (com.facebook.login.LoginClient.Request) r0
            r8.pendingRequest = r0
            java.util.Map r0 = com.facebook.internal.Utility.readNonnullStringMapFromParcel(r9)
            if (r0 != 0) goto L_0x0063
            r0 = r5
            goto L_0x0067
        L_0x0063:
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r0)
        L_0x0067:
            r8.loggingExtras = r0
            java.util.Map r9 = com.facebook.internal.Utility.readNonnullStringMapFromParcel(r9)
            if (r9 != 0) goto L_0x0070
            goto L_0x0074
        L_0x0070:
            java.util.Map r5 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r9)
        L_0x0074:
            r8.extraData = r5
            return
        L_0x0077:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.<init>(android.os.Parcel):void");
    }
}
