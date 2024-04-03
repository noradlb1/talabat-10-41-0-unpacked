package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.qualityvalidation.Excuse;
import com.facebook.internal.qualityvalidation.ExcusesForDesignViolations;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 @2\u00020\u0001:\u0003?@AB!\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rB\u000f\b\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010B\u0001\b\u0002\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\b\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020\u000bH\u0016J\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\tH\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b8F¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010+R\"\u0010\u0004\u001a\u0004\u0018\u00010\u001c2\b\u00101\u001a\u0004\u0018\u00010\u001c@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)¨\u0006B"}, d2 = {"Lcom/facebook/FacebookRequestError;", "Landroid/os/Parcelable;", "connection", "Ljava/net/HttpURLConnection;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/net/HttpURLConnection;Ljava/lang/Exception;)V", "errorCode", "", "errorType", "", "errorMessage", "(ILjava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "requestStatusCode", "subErrorCode", "errorMessageField", "errorUserTitle", "errorUserMessage", "requestResultBody", "Lorg/json/JSONObject;", "requestResult", "batchRequestResult", "", "exceptionField", "Lcom/facebook/FacebookException;", "errorIsTransient", "", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Object;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;Z)V", "getBatchRequestResult", "()Ljava/lang/Object;", "category", "Lcom/facebook/FacebookRequestError$Category;", "getCategory", "()Lcom/facebook/FacebookRequestError$Category;", "getConnection", "()Ljava/net/HttpURLConnection;", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "errorRecoveryMessage", "getErrorRecoveryMessage", "getErrorType", "getErrorUserMessage", "getErrorUserTitle", "<set-?>", "getException", "()Lcom/facebook/FacebookException;", "getRequestResult", "()Lorg/json/JSONObject;", "getRequestResultBody", "getRequestStatusCode", "getSubErrorCode", "describeContents", "toString", "writeToParcel", "", "out", "flags", "Category", "Companion", "Range", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ExcusesForDesignViolations({@Excuse(reason = "Legacy migration", type = "KOTLIN_JVM_FIELD")})
public final class FacebookRequestError implements Parcelable {
    @NotNull
    private static final String BODY_KEY = "body";
    @NotNull
    private static final String CODE_KEY = "code";
    @NotNull
    @JvmField
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new FacebookRequestError$Companion$CREATOR$1();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String ERROR_CODE_FIELD_KEY = "code";
    @NotNull
    private static final String ERROR_CODE_KEY = "error_code";
    @NotNull
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    @NotNull
    private static final String ERROR_KEY = "error";
    @NotNull
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    @NotNull
    private static final String ERROR_MSG_KEY = "error_msg";
    @NotNull
    private static final String ERROR_REASON_KEY = "error_reason";
    @NotNull
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    @NotNull
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    @NotNull
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    @NotNull
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    /* access modifiers changed from: private */
    @NotNull
    public static final Range HTTP_RANGE_SUCCESS = new Range(200, 299);
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    @Nullable
    private final Object batchRequestResult;
    @NotNull
    private final Category category;
    @Nullable
    private final HttpURLConnection connection;
    private final int errorCode;
    @Nullable
    private final String errorMessage;
    @Nullable
    private final String errorRecoveryMessage;
    @Nullable
    private final String errorType;
    @Nullable
    private final String errorUserMessage;
    @Nullable
    private final String errorUserTitle;
    @Nullable
    private FacebookException exception;
    @Nullable
    private final JSONObject requestResult;
    @Nullable
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/FacebookRequestError$Category;", "", "(Ljava/lang/String;I)V", "LOGIN_RECOVERABLE", "OTHER", "TRANSIENT", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010#\u001a\u0004\u0018\u00010$H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019XT¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/facebook/FacebookRequestError$Companion;", "", "()V", "BODY_KEY", "", "CODE_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/FacebookRequestError;", "ERROR_CODE_FIELD_KEY", "ERROR_CODE_KEY", "ERROR_IS_TRANSIENT_KEY", "ERROR_KEY", "ERROR_MESSAGE_FIELD_KEY", "ERROR_MSG_KEY", "ERROR_REASON_KEY", "ERROR_SUB_CODE_KEY", "ERROR_TYPE_FIELD_KEY", "ERROR_USER_MSG_KEY", "ERROR_USER_TITLE_KEY", "HTTP_RANGE_SUCCESS", "Lcom/facebook/FacebookRequestError$Range;", "getHTTP_RANGE_SUCCESS$facebook_core_release", "()Lcom/facebook/FacebookRequestError$Range;", "INVALID_ERROR_CODE", "", "INVALID_HTTP_STATUS_CODE", "errorClassification", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "checkResponseAndCreateError", "singleResult", "Lorg/json/JSONObject;", "batchResult", "connection", "Ljava/net/HttpURLConnection;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:50:0x00cf A[Catch:{ JSONException -> 0x012d }] */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.FacebookRequestError checkResponseAndCreateError(@org.jetbrains.annotations.NotNull org.json.JSONObject r20, @org.jetbrains.annotations.Nullable java.lang.Object r21, @org.jetbrains.annotations.Nullable java.net.HttpURLConnection r22) {
            /*
                r19 = this;
                r9 = r20
                java.lang.String r0 = "error_code"
                java.lang.String r1 = "error"
                java.lang.String r2 = "FACEBOOK_NON_JSON_RESULT"
                java.lang.String r3 = "body"
                java.lang.String r4 = "code"
                java.lang.String r5 = "singleResult"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r5)
                r15 = 0
                boolean r5 = r9.has(r4)     // Catch:{ JSONException -> 0x012d }
                if (r5 == 0) goto L_0x012d
                int r5 = r9.getInt(r4)     // Catch:{ JSONException -> 0x012d }
                java.lang.Object r6 = com.facebook.internal.Utility.getStringPropertyAsJSON(r9, r3, r2)     // Catch:{ JSONException -> 0x012d }
                if (r6 == 0) goto L_0x00f0
                boolean r7 = r6 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x012d }
                if (r7 == 0) goto L_0x00f0
                r7 = r6
                org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ JSONException -> 0x012d }
                boolean r7 = r7.has(r1)     // Catch:{ JSONException -> 0x012d }
                r8 = 1
                java.lang.String r10 = "error_subcode"
                r11 = 0
                r12 = -1
                if (r7 == 0) goto L_0x0083
                r0 = r6
                org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x012d }
                java.lang.Object r0 = com.facebook.internal.Utility.getStringPropertyAsJSON(r0, r1, r15)     // Catch:{ JSONException -> 0x012d }
                org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x012d }
                if (r0 != 0) goto L_0x0041
                r1 = r15
                goto L_0x0047
            L_0x0041:
                java.lang.String r1 = "type"
                java.lang.String r1 = r0.optString(r1, r15)     // Catch:{ JSONException -> 0x012d }
            L_0x0047:
                if (r0 != 0) goto L_0x004b
                r7 = r15
                goto L_0x0051
            L_0x004b:
                java.lang.String r7 = "message"
                java.lang.String r7 = r0.optString(r7, r15)     // Catch:{ JSONException -> 0x012d }
            L_0x0051:
                if (r0 != 0) goto L_0x0055
                r4 = r12
                goto L_0x0059
            L_0x0055:
                int r4 = r0.optInt(r4, r12)     // Catch:{ JSONException -> 0x012d }
            L_0x0059:
                if (r0 != 0) goto L_0x005c
                goto L_0x0060
            L_0x005c:
                int r12 = r0.optInt(r10, r12)     // Catch:{ JSONException -> 0x012d }
            L_0x0060:
                if (r0 != 0) goto L_0x0064
                r10 = r15
                goto L_0x006a
            L_0x0064:
                java.lang.String r10 = "error_user_msg"
                java.lang.String r10 = r0.optString(r10, r15)     // Catch:{ JSONException -> 0x012d }
            L_0x006a:
                if (r0 != 0) goto L_0x006e
                r13 = r15
                goto L_0x0074
            L_0x006e:
                java.lang.String r13 = "error_user_title"
                java.lang.String r13 = r0.optString(r13, r15)     // Catch:{ JSONException -> 0x012d }
            L_0x0074:
                if (r0 != 0) goto L_0x0077
                goto L_0x007d
            L_0x0077:
                java.lang.String r14 = "is_transient"
                boolean r11 = r0.optBoolean(r14, r11)     // Catch:{ JSONException -> 0x012d }
            L_0x007d:
                r14 = r11
                r11 = r8
                r8 = r7
                r7 = r12
                r12 = r4
                goto L_0x00cc
            L_0x0083:
                r1 = r6
                org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x012d }
                boolean r1 = r1.has(r0)     // Catch:{ JSONException -> 0x012d }
                java.lang.String r4 = "error_msg"
                java.lang.String r7 = "error_reason"
                if (r1 != 0) goto L_0x00aa
                r1 = r6
                org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x012d }
                boolean r1 = r1.has(r4)     // Catch:{ JSONException -> 0x012d }
                if (r1 != 0) goto L_0x00aa
                r1 = r6
                org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x012d }
                boolean r1 = r1.has(r7)     // Catch:{ JSONException -> 0x012d }
                if (r1 == 0) goto L_0x00a3
                goto L_0x00aa
            L_0x00a3:
                r14 = r11
                r7 = r12
                r4 = r15
                r8 = r4
                r10 = r8
                r13 = r10
                goto L_0x00cd
            L_0x00aa:
                r1 = r6
                org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x012d }
                java.lang.String r1 = r1.optString(r7, r15)     // Catch:{ JSONException -> 0x012d }
                r7 = r6
                org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ JSONException -> 0x012d }
                java.lang.String r4 = r7.optString(r4, r15)     // Catch:{ JSONException -> 0x012d }
                r7 = r6
                org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ JSONException -> 0x012d }
                int r0 = r7.optInt(r0, r12)     // Catch:{ JSONException -> 0x012d }
                r7 = r6
                org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ JSONException -> 0x012d }
                int r7 = r7.optInt(r10, r12)     // Catch:{ JSONException -> 0x012d }
                r12 = r0
                r14 = r11
                r10 = r15
                r13 = r10
                r11 = r8
                r8 = r4
            L_0x00cc:
                r4 = r1
            L_0x00cd:
                if (r11 == 0) goto L_0x00f0
                com.facebook.FacebookRequestError r16 = new com.facebook.FacebookRequestError     // Catch:{ JSONException -> 0x012d }
                r11 = r6
                org.json.JSONObject r11 = (org.json.JSONObject) r11     // Catch:{ JSONException -> 0x012d }
                r17 = 0
                r18 = 0
                r0 = r16
                r1 = r5
                r2 = r12
                r3 = r7
                r5 = r8
                r6 = r13
                r7 = r10
                r8 = r11
                r9 = r20
                r10 = r21
                r11 = r22
                r12 = r17
                r13 = r14
                r14 = r18
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x012d }
                return r16
            L_0x00f0:
                com.facebook.FacebookRequestError$Range r0 = r19.getHTTP_RANGE_SUCCESS$facebook_core_release()     // Catch:{ JSONException -> 0x012d }
                boolean r0 = r0.contains(r5)     // Catch:{ JSONException -> 0x012d }
                if (r0 != 0) goto L_0x012d
                com.facebook.FacebookRequestError r16 = new com.facebook.FacebookRequestError     // Catch:{ JSONException -> 0x012d }
                r4 = -1
                r6 = -1
                r7 = 0
                r8 = 0
                r10 = 0
                r11 = 0
                boolean r0 = r9.has(r3)     // Catch:{ JSONException -> 0x012d }
                if (r0 == 0) goto L_0x0110
                java.lang.Object r0 = com.facebook.internal.Utility.getStringPropertyAsJSON(r9, r3, r2)     // Catch:{ JSONException -> 0x012d }
                org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x012d }
                r12 = r0
                goto L_0x0111
            L_0x0110:
                r12 = r15
            L_0x0111:
                r13 = 0
                r14 = 0
                r17 = 0
                r0 = r16
                r1 = r5
                r2 = r4
                r3 = r6
                r4 = r7
                r5 = r8
                r6 = r10
                r7 = r11
                r8 = r12
                r9 = r20
                r10 = r21
                r11 = r22
                r12 = r13
                r13 = r14
                r14 = r17
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x012d }
                return r16
            L_0x012d:
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.Companion.checkResponseAndCreateError(org.json.JSONObject, java.lang.Object, java.net.HttpURLConnection):com.facebook.FacebookRequestError");
        }

        @JvmStatic
        @NotNull
        public final synchronized FacebookRequestErrorClassification getErrorClassification() {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                return FacebookRequestErrorClassification.Companion.getDefaultErrorClassification();
            }
            return appSettingsWithoutQuery.getErrorClassification();
        }

        @NotNull
        public final Range getHTTP_RANGE_SUCCESS$facebook_core_release() {
            return FacebookRequestError.HTTP_RANGE_SUCCESS;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/FacebookRequestError$Range;", "", "start", "", "end", "(II)V", "contains", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Range {
        private final int end;
        private final int start;

        public Range(int i11, int i12) {
            this.start = i11;
            this.end = i12;
        }

        public final boolean contains(int i11) {
            return i11 <= this.end && this.start <= i11;
        }
    }

    private FacebookRequestError(int i11, int i12, int i13, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z11) {
        boolean z12;
        Category category2;
        this.requestStatusCode = i11;
        this.errorCode = i12;
        this.subErrorCode = i13;
        this.errorType = str;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorMessage = str2;
        if (facebookException != null) {
            this.exception = facebookException;
            z12 = true;
        } else {
            this.exception = new FacebookServiceException(this, getErrorMessage());
            z12 = false;
        }
        if (z12) {
            category2 = Category.OTHER;
        } else {
            category2 = Companion.getErrorClassification().classify(i12, i13, z11);
        }
        this.category = category2;
        this.errorRecoveryMessage = Companion.getErrorClassification().getRecoveryMessage(category2);
    }

    public /* synthetic */ FacebookRequestError(int i11, int i12, int i13, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, i13, str, str2, str3, str4, jSONObject, jSONObject2, obj, httpURLConnection, facebookException, z11);
    }

    public /* synthetic */ FacebookRequestError(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @JvmStatic
    @Nullable
    public static final FacebookRequestError checkResponseAndCreateError(@NotNull JSONObject jSONObject, @Nullable Object obj, @Nullable HttpURLConnection httpURLConnection) {
        return Companion.checkResponseAndCreateError(jSONObject, obj, httpURLConnection);
    }

    @JvmStatic
    @NotNull
    public static final synchronized FacebookRequestErrorClassification getErrorClassification() {
        FacebookRequestErrorClassification errorClassification;
        synchronized (FacebookRequestError.class) {
            errorClassification = Companion.getErrorClassification();
        }
        return errorClassification;
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    @NotNull
    public final Category getCategory() {
        return this.category;
    }

    @Nullable
    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMessage() {
        String str = this.errorMessage;
        if (str != null) {
            return str;
        }
        FacebookException facebookException = this.exception;
        if (facebookException == null) {
            return null;
        }
        return facebookException.getLocalizedMessage();
    }

    @Nullable
    public final String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    @Nullable
    public final String getErrorType() {
        return this.errorType;
    }

    @Nullable
    public final String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    @Nullable
    public final String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    @Nullable
    public final FacebookException getException() {
        return this.exception;
    }

    @Nullable
    public final JSONObject getRequestResult() {
        return this.requestResult;
    }

    @Nullable
    public final JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public final int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public final int getSubErrorCode() {
        return this.subErrorCode;
    }

    @NotNull
    public String toString() {
        String str = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder(\"{HttpStatus: \")\n        .append(requestStatusCode)\n        .append(\", errorCode: \")\n        .append(errorCode)\n        .append(\", subErrorCode: \")\n        .append(subErrorCode)\n        .append(\", errorType: \")\n        .append(errorType)\n        .append(\", errorMessage: \")\n        .append(errorMessage)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.requestStatusCode);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.subErrorCode);
        parcel.writeString(this.errorType);
        parcel.writeString(getErrorMessage());
        parcel.writeString(this.errorUserTitle);
        parcel.writeString(this.errorUserMessage);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.VisibleForTesting(otherwise = 4)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FacebookRequestError(@org.jetbrains.annotations.Nullable java.net.HttpURLConnection r15, @org.jetbrains.annotations.Nullable java.lang.Exception r16) {
        /*
            r14 = this;
            r0 = r16
            r1 = -1
            r2 = -1
            r3 = -1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r11 = r0 instanceof com.facebook.FacebookException
            if (r11 == 0) goto L_0x0014
            com.facebook.FacebookException r0 = (com.facebook.FacebookException) r0
            r12 = r0
            goto L_0x001a
        L_0x0014:
            com.facebook.FacebookException r11 = new com.facebook.FacebookException
            r11.<init>((java.lang.Throwable) r0)
            r12 = r11
        L_0x001a:
            r13 = 0
            r0 = r14
            r11 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.<init>(java.net.HttpURLConnection, java.lang.Exception):void");
    }

    public FacebookRequestError(int i11, @Nullable String str, @Nullable String str2) {
        this(-1, i11, -1, str, str2, (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Object) null, (HttpURLConnection) null, (FacebookException) null, false);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (JSONObject) null, (JSONObject) null, (Object) null, (HttpURLConnection) null, (FacebookException) null, false);
    }
}
