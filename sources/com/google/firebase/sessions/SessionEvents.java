package com.google.firebase.sessions;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.google.firebase.FirebaseApp;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/sessions/SessionEvents;", "", "()V", "SESSION_EVENT_ENCODER", "Lcom/google/firebase/encoders/DataEncoder;", "getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions", "()Lcom/google/firebase/encoders/DataEncoder;", "getApplicationInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "startSession", "Lcom/google/firebase/sessions/SessionEvent;", "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "sessionsSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionEvents {
    @NotNull
    public static final SessionEvents INSTANCE = new SessionEvents();
    @NotNull
    private static final DataEncoder SESSION_EVENT_ENCODER;

    static {
        DataEncoder build = new JsonDataEncoderBuilder().configureWith(AutoSessionEventEncoder.CONFIG).ignoreNullValues(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "JsonDataEncoderBuilder()…lues(true)\n      .build()");
        SESSION_EVENT_ENCODER = build;
    }

    private SessionEvents() {
    }

    @NotNull
    public final ApplicationInfo getApplicationInfo(@NotNull FirebaseApp firebaseApp) {
        String str;
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Context applicationContext = firebaseApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "firebaseApp.applicationContext");
        String packageName = applicationContext.getPackageName();
        PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(packageName, 0);
        if (Build.VERSION.SDK_INT >= 28) {
            str = String.valueOf(packageInfo.getLongVersionCode());
        } else {
            str = String.valueOf(packageInfo.versionCode);
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        Intrinsics.checkNotNullExpressionValue(applicationId, "firebaseApp.options.applicationId");
        String str2 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str2, "MODEL");
        String str3 = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str3, "RELEASE");
        LogEnvironment logEnvironment = LogEnvironment.LOG_ENVIRONMENT_PROD;
        Intrinsics.checkNotNullExpressionValue(packageName, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        String str4 = packageInfo.versionName;
        Intrinsics.checkNotNullExpressionValue(str4, "packageInfo.versionName");
        String str5 = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str5, "MANUFACTURER");
        return new ApplicationInfo(applicationId, str2, BuildConfig.VERSION_NAME, str3, logEnvironment, new AndroidApplicationInfo(packageName, str4, str, str5));
    }

    @NotNull
    public final DataEncoder getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions() {
        return SESSION_EVENT_ENCODER;
    }

    @NotNull
    public final SessionEvent startSession(@NotNull FirebaseApp firebaseApp, @NotNull SessionDetails sessionDetails, @NotNull SessionsSettings sessionsSettings) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(sessionDetails, "sessionDetails");
        Intrinsics.checkNotNullParameter(sessionsSettings, "sessionsSettings");
        return new SessionEvent(EventType.SESSION_START, new SessionInfo(sessionDetails.getSessionId(), sessionDetails.getFirstSessionId(), sessionDetails.getSessionIndex(), sessionDetails.getSessionStartTimestampUs(), new DataCollectionStatus((DataCollectionState) null, (DataCollectionState) null, sessionsSettings.getSamplingRate(), 3, (DefaultConstructorMarker) null), (String) null, 32, (DefaultConstructorMarker) null), getApplicationInfo(firebaseApp));
    }
}
