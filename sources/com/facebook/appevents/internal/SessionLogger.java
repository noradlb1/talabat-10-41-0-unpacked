package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.work.PeriodicWorkRequest;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.internal.security.CertificateUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.commons.lang3.time.DateUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\u0016\u001a\u00020\u0011H\u0002J$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/internal/SessionLogger;", "", "()V", "INACTIVE_SECONDS_QUANTA", "", "PACKAGE_CHECKSUM", "", "TAG", "kotlin.jvm.PlatformType", "computePackageChecksum", "context", "Landroid/content/Context;", "getQuantaIndex", "", "timeBetweenSessions", "", "logActivateApp", "", "activityName", "sourceApplicationInfo", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "appId", "logClockSkewEvent", "logDeactivateApp", "sessionInfo", "Lcom/facebook/appevents/internal/SessionInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class SessionLogger {
    @NotNull
    private static final long[] INACTIVE_SECONDS_QUANTA = {300000, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, 1800000, DateUtils.MILLIS_PER_HOUR, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    @NotNull
    public static final SessionLogger INSTANCE = new SessionLogger();
    @NotNull
    private static final String PACKAGE_CHECKSUM = "PCKGCHKSUM";
    private static final String TAG = SessionLogger.class.getCanonicalName();

    private SessionLogger() {
    }

    private final String computePackageChecksum(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String stringPlus = Intrinsics.stringPlus("PCKGCHKSUM;", packageManager.getPackageInfo(context.getPackageName(), 0).versionName);
            SharedPreferences sharedPreferences = context.getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0);
            String string = sharedPreferences.getString(stringPlus, (String) null);
            if (string != null && string.length() == 32) {
                return string;
            }
            String computeChecksumWithPackageManager = HashUtils.computeChecksumWithPackageManager(context, (Long) null);
            if (computeChecksumWithPackageManager == null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "pm.getApplicationInfo(context.packageName, 0)");
                computeChecksumWithPackageManager = HashUtils.computeChecksum(applicationInfo.sourceDir);
            }
            sharedPreferences.edit().putString(stringPlus, computeChecksumWithPackageManager).apply();
            return computeChecksumWithPackageManager;
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final int getQuantaIndex(long j11) {
        int i11 = 0;
        while (true) {
            long[] jArr = INACTIVE_SECONDS_QUANTA;
            if (i11 >= jArr.length || jArr[i11] >= j11) {
                return i11;
            }
            i11++;
        }
        return i11;
    }

    @JvmStatic
    public static final void logActivateApp(@NotNull String str, @Nullable SourceApplicationInfo sourceApplicationInfo, @Nullable String str2, @NotNull Context context) {
        String sourceApplicationInfo2;
        Intrinsics.checkNotNullParameter(str, "activityName");
        Intrinsics.checkNotNullParameter(context, "context");
        String str3 = "Unclassified";
        if (!(sourceApplicationInfo == null || (sourceApplicationInfo2 = sourceApplicationInfo.toString()) == null)) {
            str3 = sourceApplicationInfo2;
        }
        Bundle bundle = new Bundle();
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, str3);
        bundle.putString(AppEventsConstants.EVENT_PARAM_PACKAGE_FP, INSTANCE.computePackageChecksum(context));
        bundle.putString(AppEventsConstants.EVENT_PARAM_APP_CERT_HASH, CertificateUtil.getCertificateHash(context));
        InternalAppEventsLogger.Companion companion = InternalAppEventsLogger.Companion;
        InternalAppEventsLogger createInstance = companion.createInstance(str, str2, (AccessToken) null);
        createInstance.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, bundle);
        if (companion.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            createInstance.flush();
        }
    }

    private final void logClockSkewEvent() {
        Logger.Companion companion = Logger.Companion;
        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
        String str = TAG;
        Intrinsics.checkNotNull(str);
        companion.log(loggingBehavior, str, "Clock skew detected");
    }

    @JvmStatic
    public static final void logDeactivateApp(@NotNull String str, @Nullable SessionInfo sessionInfo, @Nullable String str2) {
        long j11;
        String sourceApplicationInfo;
        long j12;
        Intrinsics.checkNotNullParameter(str, "activityName");
        if (sessionInfo != null) {
            Long diskRestoreTime = sessionInfo.getDiskRestoreTime();
            long j13 = 0;
            if (diskRestoreTime == null) {
                Long sessionLastEventTime = sessionInfo.getSessionLastEventTime();
                if (sessionLastEventTime == null) {
                    j12 = 0;
                } else {
                    j12 = sessionLastEventTime.longValue();
                }
                j11 = 0 - j12;
            } else {
                j11 = diskRestoreTime.longValue();
            }
            if (j11 < 0) {
                INSTANCE.logClockSkewEvent();
                j11 = 0;
            }
            long sessionLength = sessionInfo.getSessionLength();
            if (sessionLength < 0) {
                INSTANCE.logClockSkewEvent();
                sessionLength = 0;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, sessionInfo.getInterruptionCount());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ROOT, "session_quanta_%d", Arrays.copyOf(new Object[]{Integer.valueOf(getQuantaIndex(j11))}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, format);
            SourceApplicationInfo sourceApplicationInfo2 = sessionInfo.getSourceApplicationInfo();
            String str3 = "Unclassified";
            if (!(sourceApplicationInfo2 == null || (sourceApplicationInfo = sourceApplicationInfo2.toString()) == null)) {
                str3 = sourceApplicationInfo;
            }
            bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, str3);
            Long sessionLastEventTime2 = sessionInfo.getSessionLastEventTime();
            if (sessionLastEventTime2 != null) {
                j13 = sessionLastEventTime2.longValue();
            }
            bundle.putLong(Constants.LOG_TIME_APP_EVENT_KEY, j13 / ((long) 1000));
            InternalAppEventsLogger.Companion.createInstance(str, str2, (AccessToken) null).logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, ((double) sessionLength) / ((double) 1000), bundle);
        }
    }
}
