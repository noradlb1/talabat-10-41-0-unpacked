package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q6.a;
import q6.b;
import q6.c;
import q6.d;
import q6.e;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\rH\u0007J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\b\u0010#\u001a\u00020$H\u0007J\b\u0010%\u001a\u00020$H\u0007J\u0012\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0007J\u001a\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/facebook/appevents/internal/ActivityLifecycleTracker;", "", "()V", "INCORRECT_IMPL_WARNING", "", "INTERRUPTION_THRESHOLD_MILLISECONDS", "", "TAG", "activityReferences", "", "appId", "currActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "currentActivityAppearTime", "currentFuture", "Ljava/util/concurrent/ScheduledFuture;", "currentFutureLock", "currentSession", "Lcom/facebook/appevents/internal/SessionInfo;", "foregroundActivityCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "sessionTimeoutInSeconds", "getSessionTimeoutInSeconds", "()I", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "tracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancelCurrentTask", "", "getCurrentActivity", "getCurrentSessionGuid", "Ljava/util/UUID;", "isInBackground", "", "isTracking", "onActivityCreated", "activity", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "startTracking", "application", "Landroid/app/Application;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ActivityLifecycleTracker {
    @NotNull
    private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
    @NotNull
    public static final ActivityLifecycleTracker INSTANCE = new ActivityLifecycleTracker();
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000;
    /* access modifiers changed from: private */
    @NotNull
    public static final String TAG;
    /* access modifiers changed from: private */
    public static int activityReferences;
    @Nullable
    private static String appId;
    @Nullable
    private static WeakReference<Activity> currActivity;
    private static long currentActivityAppearTime;
    @Nullable
    private static volatile ScheduledFuture<?> currentFuture;
    @NotNull
    private static final Object currentFutureLock = new Object();
    @Nullable
    private static volatile SessionInfo currentSession;
    @NotNull
    private static final AtomicInteger foregroundActivityCount = new AtomicInteger(0);
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    @NotNull

    /* renamed from: tracking  reason: collision with root package name */
    private static final AtomicBoolean f33582tracking = new AtomicBoolean(false);

    static {
        String canonicalName = ActivityLifecycleTracker.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.internal.ActivityLifecycleTracker";
        }
        TAG = canonicalName;
    }

    private ActivityLifecycleTracker() {
    }

    private final void cancelCurrentTask() {
        synchronized (currentFutureLock) {
            if (currentFuture != null) {
                ScheduledFuture<?> scheduledFuture = currentFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
            }
            currentFuture = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    @Nullable
    public static final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = currActivity;
        if (weakReference == null || weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @JvmStatic
    @Nullable
    public static final UUID getCurrentSessionGuid() {
        SessionInfo sessionInfo;
        if (currentSession == null || (sessionInfo = currentSession) == null) {
            return null;
        }
        return sessionInfo.getSessionId();
    }

    private final int getSessionTimeoutInSeconds() {
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null) {
            return Constants.getDefaultAppEventsSessionTimeoutInSeconds();
        }
        return appSettingsWithoutQuery.getSessionTimeoutInSeconds();
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isInBackground() {
        return activityReferences == 0;
    }

    @JvmStatic
    public static final boolean isTracking() {
        return f33582tracking.get();
    }

    @JvmStatic
    public static final void onActivityCreated(@Nullable Activity activity) {
        singleThreadExecutor.execute(new e());
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-1  reason: not valid java name */
    public static final void m8916onActivityCreated$lambda1() {
        if (currentSession == null) {
            currentSession = SessionInfo.Companion.getStoredSessionInfo();
        }
    }

    /* access modifiers changed from: private */
    public final void onActivityDestroyed(Activity activity) {
        CodelessManager.onActivityDestroyed(activity);
    }

    /* access modifiers changed from: private */
    public final void onActivityPaused(Activity activity) {
        AtomicInteger atomicInteger = foregroundActivityCount;
        if (atomicInteger.decrementAndGet() < 0) {
            atomicInteger.set(0);
            Log.w(TAG, INCORRECT_IMPL_WARNING);
        }
        cancelCurrentTask();
        long currentTimeMillis = System.currentTimeMillis();
        String activityName = Utility.getActivityName(activity);
        CodelessManager.onActivityPaused(activity);
        singleThreadExecutor.execute(new b(currentTimeMillis, activityName));
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityPaused$lambda-6  reason: not valid java name */
    public static final void m8917onActivityPaused$lambda6(long j11, String str) {
        Intrinsics.checkNotNullParameter(str, "$activityName");
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j11), (Long) null, (UUID) null, 4, (DefaultConstructorMarker) null);
        }
        SessionInfo sessionInfo = currentSession;
        if (sessionInfo != null) {
            sessionInfo.setSessionLastEventTime(Long.valueOf(j11));
        }
        if (foregroundActivityCount.get() <= 0) {
            a aVar = new a(j11, str);
            synchronized (currentFutureLock) {
                currentFuture = singleThreadExecutor.schedule(aVar, (long) INSTANCE.getSessionTimeoutInSeconds(), TimeUnit.SECONDS);
                Unit unit = Unit.INSTANCE;
            }
        }
        long j12 = currentActivityAppearTime;
        long j13 = 0;
        if (j12 > 0) {
            j13 = (j11 - j12) / ((long) 1000);
        }
        AutomaticAnalyticsLogger.logActivityTimeSpentEvent(str, j13);
        SessionInfo sessionInfo2 = currentSession;
        if (sessionInfo2 != null) {
            sessionInfo2.writeSessionToDisk();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityPaused$lambda-6$lambda-4  reason: not valid java name */
    public static final void m8918onActivityPaused$lambda6$lambda4(long j11, String str) {
        Intrinsics.checkNotNullParameter(str, "$activityName");
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j11), (Long) null, (UUID) null, 4, (DefaultConstructorMarker) null);
        }
        if (foregroundActivityCount.get() <= 0) {
            SessionLogger sessionLogger = SessionLogger.INSTANCE;
            SessionLogger.logDeactivateApp(str, currentSession, appId);
            SessionInfo.Companion.clearSavedSessionFromDisk();
            currentSession = null;
        }
        synchronized (currentFutureLock) {
            currentFuture = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        currActivity = new WeakReference<>(activity);
        foregroundActivityCount.incrementAndGet();
        INSTANCE.cancelCurrentTask();
        long currentTimeMillis = System.currentTimeMillis();
        currentActivityAppearTime = currentTimeMillis;
        String activityName = Utility.getActivityName(activity);
        CodelessManager.onActivityResumed(activity);
        MetadataIndexer.onActivityResumed(activity);
        SuggestedEventsManager.trackActivity(activity);
        InAppPurchaseManager.startTracking();
        singleThreadExecutor.execute(new c(currentTimeMillis, activityName, activity.getApplicationContext()));
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityResumed$lambda-2  reason: not valid java name */
    public static final void m8919onActivityResumed$lambda2(long j11, String str, Context context) {
        Long l11;
        SessionInfo sessionInfo;
        Intrinsics.checkNotNullParameter(str, "$activityName");
        SessionInfo sessionInfo2 = currentSession;
        if (sessionInfo2 == null) {
            l11 = null;
        } else {
            l11 = sessionInfo2.getSessionLastEventTime();
        }
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j11), (Long) null, (UUID) null, 4, (DefaultConstructorMarker) null);
            SessionLogger sessionLogger = SessionLogger.INSTANCE;
            String str2 = appId;
            Intrinsics.checkNotNullExpressionValue(context, "appContext");
            SessionLogger.logActivateApp(str, (SourceApplicationInfo) null, str2, context);
        } else if (l11 != null) {
            long longValue = j11 - l11.longValue();
            if (longValue > ((long) (INSTANCE.getSessionTimeoutInSeconds() * 1000))) {
                SessionLogger sessionLogger2 = SessionLogger.INSTANCE;
                SessionLogger.logDeactivateApp(str, currentSession, appId);
                String str3 = appId;
                Intrinsics.checkNotNullExpressionValue(context, "appContext");
                SessionLogger.logActivateApp(str, (SourceApplicationInfo) null, str3, context);
                currentSession = new SessionInfo(Long.valueOf(j11), (Long) null, (UUID) null, 4, (DefaultConstructorMarker) null);
            } else if (longValue > 1000 && (sessionInfo = currentSession) != null) {
                sessionInfo.incrementInterruptionCount();
            }
        }
        SessionInfo sessionInfo3 = currentSession;
        if (sessionInfo3 != null) {
            sessionInfo3.setSessionLastEventTime(Long.valueOf(j11));
        }
        SessionInfo sessionInfo4 = currentSession;
        if (sessionInfo4 != null) {
            sessionInfo4.writeSessionToDisk();
        }
    }

    @JvmStatic
    public static final void startTracking(@NotNull Application application, @Nullable String str) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        if (f33582tracking.compareAndSet(false, true)) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.CodelessEvents, new d());
            appId = str;
            application.registerActivityLifecycleCallbacks(new ActivityLifecycleTracker$startTracking$2());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startTracking$lambda-0  reason: not valid java name */
    public static final void m8920startTracking$lambda0(boolean z11) {
        if (z11) {
            CodelessManager.enable();
        } else {
            CodelessManager.disable();
        }
    }
}
