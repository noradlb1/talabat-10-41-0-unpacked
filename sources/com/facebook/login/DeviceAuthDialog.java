package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.compose.DialogNavigator;
import b7.b;
import b7.c;
import b7.d;
import b7.e;
import b7.f;
import b7.g;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.huawei.hms.push.AttributionReporter;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.tekartik.sqflite.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0016\u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016J4\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\b\u0010'\u001a\u00020\u001dH\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000fH\u0015J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u000fH\u0014J\b\u0010,\u001a\u00020\u000fH\u0014J\b\u0010-\u001a\u00020\u001fH\u0014J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J&\u00102\u001a\u0004\u0018\u00010\u00162\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00107\u001a\u00020\u001fH\u0016J\u0010\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=H\u0014J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u000201H\u0016J'\u0010@\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020B2\b\u0010&\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020\u001fH\u0002J<\u0010E\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\b\u0010G\u001a\u00020\u001fH\u0002J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010I\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "completed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "confirmationCode", "Landroid/widget/TextView;", "currentGraphRequestPoll", "Lcom/facebook/GraphRequestAsyncTask;", "currentRequestState", "Lcom/facebook/login/DeviceAuthDialog$RequestState;", "deviceAuthMethodHandler", "Lcom/facebook/login/DeviceAuthMethodHandler;", "instructions", "isBeingDestroyed", "", "isRetry", "pollRequest", "Lcom/facebook/GraphRequest;", "getPollRequest", "()Lcom/facebook/GraphRequest;", "progressBar", "Landroid/view/View;", "request", "Lcom/facebook/login/LoginClient$Request;", "scheduledPoll", "Ljava/util/concurrent/ScheduledFuture;", "additionalDeviceInfo", "", "", "completeLogin", "", "userId", "permissions", "Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "accessToken", "expirationTime", "Ljava/util/Date;", "dataAccessExpirationTime", "getApplicationAccessToken", "getLayoutResId", "", "isSmartLogin", "initializeContentView", "onBackButtonPressed", "onCancel", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onError", "ex", "Lcom/facebook/FacebookException;", "onSaveInstanceState", "outState", "onSuccess", "expiresIn", "", "(Ljava/lang/String;JLjava/lang/Long;)V", "poll", "presentConfirmation", "name", "schedulePoll", "setCurrentRequestState", "startLogin", "Companion", "PermissionsLists", "RequestState", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DeviceAuthDialog extends DialogFragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String DEVICE_LOGIN_ENDPOINT = "device/login";
    /* access modifiers changed from: private */
    @NotNull
    public static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
    /* access modifiers changed from: private */
    public static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
    private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
    private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
    @NotNull
    private static final String REQUEST_STATE_KEY = "request_state";
    public Trace _nr_trace;
    @NotNull
    private final AtomicBoolean completed = new AtomicBoolean();
    private TextView confirmationCode;
    @Nullable
    private volatile GraphRequestAsyncTask currentGraphRequestPoll;
    @Nullable
    private volatile RequestState currentRequestState;
    @Nullable
    private DeviceAuthMethodHandler deviceAuthMethodHandler;
    private TextView instructions;
    private boolean isBeingDestroyed;
    private boolean isRetry;
    private View progressBar;
    @Nullable
    private LoginClient.Request request;
    @Nullable
    private volatile ScheduledFuture<?> scheduledPoll;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0000XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0000XD¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u00020\f8\u0000XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$Companion;", "", "()V", "DEVICE_LOGIN_ENDPOINT", "", "getDEVICE_LOGIN_ENDPOINT$facebook_common_release$annotations", "getDEVICE_LOGIN_ENDPOINT$facebook_common_release", "()Ljava/lang/String;", "DEVICE_LOGIN_STATUS_ENDPOINT", "getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release$annotations", "getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release", "LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED", "", "LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING", "getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release$annotations", "getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release", "()I", "LOGIN_ERROR_SUBCODE_CODE_EXPIRED", "LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING", "REQUEST_STATE_KEY", "handlePermissionResponse", "Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "result", "Lorg/json/JSONObject;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getDEVICE_LOGIN_ENDPOINT$facebook_common_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release$annotations() {
        }

        /* access modifiers changed from: private */
        public final PermissionsLists handlePermissionResponse(JSONObject jSONObject) throws JSONException {
            boolean z11;
            String optString;
            JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int length = jSONArray.length();
            if (length > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                    String optString2 = optJSONObject.optString(AttributionReporter.SYSTEM_PERMISSION);
                    Intrinsics.checkNotNullExpressionValue(optString2, AttributionReporter.SYSTEM_PERMISSION);
                    if (optString2.length() == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11 && !Intrinsics.areEqual((Object) optString2, (Object) "installed") && (optString = optJSONObject.optString("status")) != null) {
                        int hashCode = optString.hashCode();
                        if (hashCode != -1309235419) {
                            if (hashCode != 280295099) {
                                if (hashCode == 568196142 && optString.equals("declined")) {
                                    arrayList2.add(optString2);
                                }
                            } else if (optString.equals("granted")) {
                                arrayList.add(optString2);
                            }
                        } else if (optString.equals("expired")) {
                            arrayList3.add(optString2);
                        }
                    }
                    if (i12 >= length) {
                        break;
                    }
                    i11 = i12;
                }
            }
            return new PermissionsLists(arrayList, arrayList2, arrayList3);
        }

        @NotNull
        public final String getDEVICE_LOGIN_ENDPOINT$facebook_common_release() {
            return DeviceAuthDialog.DEVICE_LOGIN_ENDPOINT;
        }

        @NotNull
        public final String getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release() {
            return DeviceAuthDialog.DEVICE_LOGIN_STATUS_ENDPOINT;
        }

        public final int getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release() {
            return DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "", "grantedPermissions", "", "", "declinedPermissions", "expiredPermissions", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDeclinedPermissions", "()Ljava/util/List;", "setDeclinedPermissions", "(Ljava/util/List;)V", "getExpiredPermissions", "setExpiredPermissions", "getGrantedPermissions", "setGrantedPermissions", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PermissionsLists {
        @NotNull
        private List<String> declinedPermissions;
        @NotNull
        private List<String> expiredPermissions;
        @NotNull
        private List<String> grantedPermissions;

        public PermissionsLists(@NotNull List<String> list, @NotNull List<String> list2, @NotNull List<String> list3) {
            Intrinsics.checkNotNullParameter(list, "grantedPermissions");
            Intrinsics.checkNotNullParameter(list2, "declinedPermissions");
            Intrinsics.checkNotNullParameter(list3, "expiredPermissions");
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
            this.expiredPermissions = list3;
        }

        @NotNull
        public final List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        @NotNull
        public final List<String> getExpiredPermissions() {
            return this.expiredPermissions;
        }

        @NotNull
        public final List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public final void setDeclinedPermissions(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.declinedPermissions = list;
        }

        public final void setExpiredPermissions(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.expiredPermissions = list;
        }

        public final void setGrantedPermissions(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.grantedPermissions = list;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\b\u0010¢\u0006\u0002\u0010\u0002B\u000f\b\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0018H\u0016R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$RequestState;", "Landroid/os/Parcelable;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "", "authorizationUri", "getAuthorizationUri", "()Ljava/lang/String;", "interval", "", "getInterval", "()J", "setInterval", "(J)V", "lastPoll", "requestCode", "getRequestCode", "setRequestCode", "(Ljava/lang/String;)V", "userCode", "describeContents", "", "getUserCode", "setLastPoll", "", "setUserCode", "withinLastRefreshWindow", "", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class RequestState implements Parcelable {
        @NotNull
        @JvmField
        public static final Parcelable.Creator<RequestState> CREATOR = new DeviceAuthDialog$RequestState$Companion$CREATOR$1();
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Nullable
        private String authorizationUri;
        private long interval;
        private long lastPoll;
        @Nullable
        private String requestCode;
        @Nullable
        private String userCode;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$RequestState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/DeviceAuthDialog$RequestState;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public RequestState() {
        }

        public RequestState(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
        }

        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getAuthorizationUri() {
            return this.authorizationUri;
        }

        public final long getInterval() {
            return this.interval;
        }

        @Nullable
        public final String getRequestCode() {
            return this.requestCode;
        }

        @Nullable
        public final String getUserCode() {
            return this.userCode;
        }

        public final void setInterval(long j11) {
            this.interval = j11;
        }

        public final void setLastPoll(long j11) {
            this.lastPoll = j11;
        }

        public final void setRequestCode(@Nullable String str) {
            this.requestCode = str;
        }

        public final void setUserCode(@Nullable String str) {
            this.userCode = str;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            this.authorizationUri = format;
        }

        public final boolean withinLastRefreshWindow() {
            if (this.lastPoll != 0 && (new Date().getTime() - this.lastPoll) - (this.interval * 1000) < 0) {
                return true;
            }
            return false;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.authorizationUri);
            parcel.writeString(this.userCode);
            parcel.writeString(this.requestCode);
            parcel.writeLong(this.interval);
            parcel.writeLong(this.lastPoll);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _get_pollRequest_$lambda-5  reason: not valid java name */
    public static final void m8987_get_pollRequest_$lambda5(DeviceAuthDialog deviceAuthDialog, GraphResponse graphResponse) {
        FacebookException facebookException;
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        if (!deviceAuthDialog.completed.get()) {
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                int subErrorCode = error.getSubErrorCode();
                boolean z11 = true;
                if (!(subErrorCode == LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING || subErrorCode == LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING)) {
                    z11 = false;
                }
                if (z11) {
                    deviceAuthDialog.schedulePoll();
                } else if (subErrorCode == LOGIN_ERROR_SUBCODE_CODE_EXPIRED) {
                    RequestState requestState = deviceAuthDialog.currentRequestState;
                    if (requestState != null) {
                        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                        DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
                    }
                    LoginClient.Request request2 = deviceAuthDialog.request;
                    if (request2 != null) {
                        deviceAuthDialog.startLogin(request2);
                    } else {
                        deviceAuthDialog.onCancel();
                    }
                } else if (subErrorCode == LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED) {
                    deviceAuthDialog.onCancel();
                } else {
                    FacebookRequestError error2 = graphResponse.getError();
                    if (error2 == null) {
                        facebookException = null;
                    } else {
                        facebookException = error2.getException();
                    }
                    if (facebookException == null) {
                        facebookException = new FacebookException();
                    }
                    deviceAuthDialog.onError(facebookException);
                }
            } else {
                try {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    String string = jSONObject.getString("access_token");
                    Intrinsics.checkNotNullExpressionValue(string, "resultObject.getString(\"access_token\")");
                    deviceAuthDialog.onSuccess(string, jSONObject.getLong(AccessToken.EXPIRES_IN_KEY), Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
                } catch (JSONException e11) {
                    deviceAuthDialog.onError(new FacebookException((Throwable) e11));
                }
            }
        }
    }

    private final void completeLogin(String str, PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
        if (deviceAuthMethodHandler2 != null) {
            deviceAuthMethodHandler2.onSuccess(str2, FacebookSdk.getApplicationId(), str, permissionsLists.getGrantedPermissions(), permissionsLists.getDeclinedPermissions(), permissionsLists.getExpiredPermissions(), AccessTokenSource.DEVICE_AUTH, date, (Date) null, date2);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final GraphRequest getPollRequest() {
        String str;
        Bundle bundle = new Bundle();
        RequestState requestState = this.currentRequestState;
        if (requestState == null) {
            str = null;
        } else {
            str = requestState.getRequestCode();
        }
        bundle.putString(Constant.PARAM_ERROR_CODE, str);
        bundle.putString("access_token", getApplicationAccessToken());
        return GraphRequest.Companion.newPostRequestWithBundle((AccessToken) null, DEVICE_LOGIN_STATUS_ENDPOINT, bundle, new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeContentView$lambda-2  reason: not valid java name */
    public static final void m8988initializeContentView$lambda2(DeviceAuthDialog deviceAuthDialog, View view) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        deviceAuthDialog.onCancel();
    }

    private final void onSuccess(String str, long j11, Long l11) {
        Date date;
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        Date date2 = null;
        if (j11 != 0) {
            date = new Date(new Date().getTime() + (j11 * 1000));
        } else {
            date = null;
        }
        if ((l11 == null || l11.longValue() != 0) && l11 != null) {
            date2 = new Date(l11.longValue() * 1000);
        }
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(new AccessToken(str, FacebookSdk.getApplicationId(), "0", (Collection) null, (Collection) null, (Collection) null, (AccessTokenSource) null, date, (Date) null, date2, (String) null, 1024, (DefaultConstructorMarker) null), "me", new b(this, str, date, date2));
        newGraphPathRequest.setHttpMethod(HttpMethod.GET);
        newGraphPathRequest.setParameters(bundle);
        newGraphPathRequest.executeAsync();
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-10  reason: not valid java name */
    public static final void m8989onSuccess$lambda10(DeviceAuthDialog deviceAuthDialog, String str, Date date, Date date2, GraphResponse graphResponse) {
        EnumSet<SmartLoginOption> smartLoginOptions;
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        Intrinsics.checkNotNullParameter(str, "$accessToken");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        if (!deviceAuthDialog.completed.get()) {
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                FacebookException exception = error.getException();
                if (exception == null) {
                    exception = new FacebookException();
                }
                deviceAuthDialog.onError(exception);
                return;
            }
            try {
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                String string = jSONObject.getString("id");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"id\")");
                PermissionsLists access$handlePermissionResponse = Companion.handlePermissionResponse(jSONObject);
                String string2 = jSONObject.getString("name");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"name\")");
                RequestState requestState = deviceAuthDialog.currentRequestState;
                if (requestState != null) {
                    DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                    DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
                }
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                Boolean bool = null;
                if (!(appSettingsWithoutQuery == null || (smartLoginOptions = appSettingsWithoutQuery.getSmartLoginOptions()) == null)) {
                    bool = Boolean.valueOf(smartLoginOptions.contains(SmartLoginOption.RequireConfirm));
                }
                if (!Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE) || deviceAuthDialog.isRetry) {
                    deviceAuthDialog.completeLogin(string, access$handlePermissionResponse, str, date, date2);
                    return;
                }
                deviceAuthDialog.isRetry = true;
                deviceAuthDialog.presentConfirmation(string, access$handlePermissionResponse, str, string2, date, date2);
            } catch (JSONException e11) {
                deviceAuthDialog.onError(new FacebookException((Throwable) e11));
            }
        }
    }

    private final void poll() {
        RequestState requestState = this.currentRequestState;
        if (requestState != null) {
            requestState.setLastPoll(new Date().getTime());
        }
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
    }

    private final void presentConfirmation(String str, PermissionsLists permissionsLists, String str2, String str3, Date date, Date date2) {
        String string = getResources().getString(R.string.com_facebook_smart_login_confirmation_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.com_facebook_smart_login_confirmation_title)");
        String string2 = getResources().getString(R.string.com_facebook_smart_login_confirmation_continue_as);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.com_facebook_smart_login_confirmation_continue_as)");
        String string3 = getResources().getString(R.string.com_facebook_smart_login_confirmation_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.com_facebook_smart_login_confirmation_cancel)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(string2, Arrays.copyOf(new Object[]{str3}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new a(this, str, permissionsLists, str2, date, date2)).setPositiveButton(string3, new c(this));
        builder.create().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: presentConfirmation$lambda-6  reason: not valid java name */
    public static final void m8990presentConfirmation$lambda6(DeviceAuthDialog deviceAuthDialog, String str, PermissionsLists permissionsLists, String str2, Date date, Date date2, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        Intrinsics.checkNotNullParameter(str, "$userId");
        Intrinsics.checkNotNullParameter(permissionsLists, "$permissions");
        Intrinsics.checkNotNullParameter(str2, "$accessToken");
        deviceAuthDialog.completeLogin(str, permissionsLists, str2, date, date2);
    }

    /* access modifiers changed from: private */
    /* renamed from: presentConfirmation$lambda-8  reason: not valid java name */
    public static final void m8991presentConfirmation$lambda8(DeviceAuthDialog deviceAuthDialog, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        View initializeContentView = deviceAuthDialog.initializeContentView(false);
        Dialog dialog = deviceAuthDialog.getDialog();
        if (dialog != null) {
            dialog.setContentView(initializeContentView);
        }
        LoginClient.Request request2 = deviceAuthDialog.request;
        if (request2 != null) {
            deviceAuthDialog.startLogin(request2);
        }
    }

    private final void schedulePoll() {
        Long l11;
        RequestState requestState = this.currentRequestState;
        if (requestState == null) {
            l11 = null;
        } else {
            l11 = Long.valueOf(requestState.getInterval());
        }
        if (l11 != null) {
            this.scheduledPoll = DeviceAuthMethodHandler.Companion.getBackgroundExecutor().schedule(new d(this), l11.longValue(), TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: schedulePoll$lambda-3  reason: not valid java name */
    public static final void m8992schedulePoll$lambda3(DeviceAuthDialog deviceAuthDialog) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        deviceAuthDialog.poll();
    }

    private final void setCurrentRequestState(RequestState requestState) {
        this.currentRequestState = requestState;
        TextView textView = this.confirmationCode;
        if (textView != null) {
            textView.setText(requestState.getUserCode());
            DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), DeviceRequestsHelper.generateQRCode(requestState.getAuthorizationUri()));
            TextView textView2 = this.instructions;
            if (textView2 != null) {
                textView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, bitmapDrawable, (Drawable) null, (Drawable) null);
                TextView textView3 = this.confirmationCode;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                    View view = this.progressBar;
                    if (view != null) {
                        view.setVisibility(8);
                        if (!this.isRetry && DeviceRequestsHelper.startAdvertisementService(requestState.getUserCode())) {
                            new InternalAppEventsLogger(getContext()).logEventImplicitly(AnalyticsEvents.EVENT_SMART_LOGIN_SERVICE);
                        }
                        if (requestState.withinLastRefreshWindow()) {
                            schedulePoll();
                        } else {
                            poll();
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("confirmationCode");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("instructions");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationCode");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startLogin$lambda-1  reason: not valid java name */
    public static final void m8993startLogin$lambda1(DeviceAuthDialog deviceAuthDialog, GraphResponse graphResponse) {
        FacebookException facebookException;
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        if (!deviceAuthDialog.isBeingDestroyed) {
            if (graphResponse.getError() != null) {
                FacebookRequestError error = graphResponse.getError();
                if (error == null) {
                    facebookException = null;
                } else {
                    facebookException = error.getException();
                }
                if (facebookException == null) {
                    facebookException = new FacebookException();
                }
                deviceAuthDialog.onError(facebookException);
                return;
            }
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            RequestState requestState = new RequestState();
            try {
                requestState.setUserCode(jSONObject.getString("user_code"));
                requestState.setRequestCode(jSONObject.getString(Constant.PARAM_ERROR_CODE));
                requestState.setInterval(jSONObject.getLong(SessionsConfigParameter.SYNC_INTERVAL));
                deviceAuthDialog.setCurrentRequestState(requestState);
            } catch (JSONException e11) {
                deviceAuthDialog.onError(new FacebookException((Throwable) e11));
            }
        }
    }

    @Nullable
    public Map<String, String> additionalDeviceInfo() {
        return null;
    }

    @NotNull
    public String getApplicationAccessToken() {
        return Validate.hasAppID() + '|' + Validate.hasClientToken();
    }

    @LayoutRes
    public int getLayoutResId(boolean z11) {
        if (z11) {
            return R.layout.com_facebook_smart_device_dialog_fragment;
        }
        return R.layout.com_facebook_device_auth_dialog_fragment;
    }

    @NotNull
    public View initializeContentView(boolean z11) {
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "requireActivity().layoutInflater");
        View inflate = layoutInflater.inflate(getLayoutResId(z11), (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(getLayoutResId(isSmartLogin), null)");
        View findViewById = inflate.findViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.progress_bar)");
        this.progressBar = findViewById;
        View findViewById2 = inflate.findViewById(R.id.confirmation_code);
        if (findViewById2 != null) {
            this.confirmationCode = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.cancel_button);
            if (findViewById3 != null) {
                ((Button) findViewById3).setOnClickListener(new g(this));
                View findViewById4 = inflate.findViewById(R.id.com_facebook_device_auth_instructions);
                if (findViewById4 != null) {
                    TextView textView = (TextView) findViewById4;
                    this.instructions = textView;
                    textView.setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
                    return inflate;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public boolean onBackButtonPressed() {
        return true;
    }

    public void onCancel() {
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler2 != null) {
                deviceAuthMethodHandler2.onCancel();
            }
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        boolean z11;
        DeviceAuthDialog$onCreateDialog$dialog$1 deviceAuthDialog$onCreateDialog$dialog$1 = new DeviceAuthDialog$onCreateDialog$dialog$1(this, requireActivity(), R.style.com_facebook_auth_dialog);
        if (!DeviceRequestsHelper.isAvailable() || this.isRetry) {
            z11 = false;
        } else {
            z11 = true;
        }
        deviceAuthDialog$onCreateDialog$dialog$1.setContentView(initializeContentView(z11));
        return deviceAuthDialog$onCreateDialog$dialog$1;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        RequestState requestState;
        LoginClient loginClient;
        LoginMethodHandler loginMethodHandler = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "DeviceAuthDialog#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "DeviceAuthDialog#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        LoginFragment loginFragment = (LoginFragment) ((FacebookActivity) requireActivity()).getCurrentFragment();
        if (!(loginFragment == null || (loginClient = loginFragment.getLoginClient()) == null)) {
            loginMethodHandler = loginClient.getCurrentHandler();
        }
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) loginMethodHandler;
        if (!(bundle == null || (requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY)) == null)) {
            setCurrentRequestState(requestState);
        }
        TraceMachine.exitMethod();
        return onCreateView;
    }

    public void onDestroyView() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroyView();
        GraphRequestAsyncTask graphRequestAsyncTask = this.currentGraphRequestPoll;
        if (graphRequestAsyncTask != null) {
            graphRequestAsyncTask.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture = this.scheduledPoll;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, DialogNavigator.NAME);
        super.onDismiss(dialogInterface);
        if (!this.isBeingDestroyed) {
            onCancel();
        }
    }

    public void onError(@NotNull FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookException, "ex");
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler2 != null) {
                deviceAuthMethodHandler2.onError(facebookException);
            }
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void startLogin(@NotNull LoginClient.Request request2) {
        Map map;
        Intrinsics.checkNotNullParameter(request2, "request");
        this.request = request2;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request2.getPermissions()));
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ServerProtocol.DIALOG_PARAM_REDIRECT_URI, request2.getDeviceRedirectUriString());
        Utility.putNonEmptyString(bundle, DeviceRequestsHelper.DEVICE_TARGET_USER_ID, request2.getDeviceAuthTargetUserId());
        bundle.putString("access_token", getApplicationAccessToken());
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        Map<String, String> additionalDeviceInfo = additionalDeviceInfo();
        if (additionalDeviceInfo == null) {
            map = null;
        } else {
            map = MapsKt__MapsKt.toMutableMap(additionalDeviceInfo);
        }
        bundle.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo(map));
        GraphRequest.Companion.newPostRequestWithBundle((AccessToken) null, DEVICE_LOGIN_ENDPOINT, bundle, new f(this)).executeAsync();
    }
}
