package com.instabug.library.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.instabug.apm.APMPlugin;
import com.instabug.crash.CrashPlugin;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.OnSdkInvokedCallback;
import com.instabug.library.Platform;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.e0;
import com.instabug.library.internal.orchestrator.Action;
import com.instabug.library.internal.orchestrator.ActionsOrchestrator;
import com.instabug.library.internal.servicelocator.application.b;
import com.instabug.library.internal.servicelocator.c;
import com.instabug.library.internal.storage.ProcessedBytes;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import com.instabug.library.k0;
import com.instabug.library.model.Report;
import com.instabug.library.model.common.Session;
import com.instabug.library.r0;
import com.instabug.library.sessionV3.configurations.IBGSessionCrashesConfigurations;
import com.instabug.library.sessionV3.manager.i;
import com.instabug.library.sessionV3.sync.SessionBatchingFilter;
import com.instabug.library.sessionV3.sync.e;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.settings.d;
import com.instabug.library.settings.f;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.o;
import com.instabug.library.visualusersteps.y;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public class InstabugCore {

    public class a implements Action {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f34181a;

        public a(Runnable runnable) {
            this.f34181a = runnable;
        }

        public void run() throws Exception {
            this.f34181a.run();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean canPrintLog(int i11) {
        int logLevel = SettingsManager.getInstance().getLogLevel();
        return logLevel != 0 && i11 <= logLevel;
    }

    public static void cleanVisualUserSteps() {
        y.d().a();
    }

    public static boolean decrypt(@NonNull String str) {
        try {
            return FileUtils.decryptFile(str);
        } catch (Exception | UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Can't Decrypt attachment", e11);
            return false;
        }
    }

    public static ProcessedBytes decryptOnTheFly(String str) {
        try {
            if (FileUtils.isEncryptedFile(str)) {
                return FileUtils.decryptOnTheFly(str);
            }
            File file = new File(str);
            byte[] bArr = new byte[((int) file.length())];
            FileUtils.read(file, bArr);
            return new ProcessedBytes(bArr, true);
        } catch (Exception | UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Can't Decrypt attachment", e11);
            return new ProcessedBytes(new byte[0], false);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void doOnBackground(@NonNull Runnable runnable) {
        if (runnable != null) {
            ActionsOrchestrator.obtainOrchestrator().addWorkerThreadAction(new a(runnable)).orchestrate();
        }
    }

    public static boolean encrypt(@NonNull String str) {
        try {
            return FileUtils.encryptFile(str);
        } catch (Exception | UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Can't Encrypt attachment", e11);
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void forceV3SessionsEvaluation(SessionBatchingFilter sessionBatchingFilter) {
        e.f51831a.a(sessionBatchingFilter);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static c getApplicationScopeServiceLocator() {
        return b.a();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static String getCurrentView() {
        int currentPlatform = SettingsManager.getInstance().getCurrentPlatform();
        if (currentPlatform == 4 || currentPlatform == 8 || currentPlatform == 7) {
            return com.instabug.library.tracking.b.c().a();
        }
        return com.instabug.library.tracking.b.c().b();
    }

    public static Feature.State getEncryptionState() {
        return SettingsManager.getInstance().getFeatureState(Feature.ENCRYPTION, false);
    }

    public static int getEncryptorVersion() {
        f s11 = f.s();
        if (s11 != null) {
            return s11.g();
        }
        return 1;
    }

    public static String getEnteredEmail() {
        return com.instabug.library.user.f.f();
    }

    public static String getEnteredUsername() {
        return com.instabug.library.user.f.g();
    }

    @WorkerThread
    @Nullable
    public static List<String> getExperiments(float f11) {
        com.instabug.library.experiments.a c11 = com.instabug.library.experiments.di.a.c();
        if (c11 != null) {
            return c11.a(f11);
        }
        return null;
    }

    @Nullable
    public static LinkedHashMap<Uri, String> getExtraAttachmentFiles() {
        return SettingsManager.getInstance().getExtraAttachmentFiles();
    }

    public static Feature.State getFeatureState(Feature feature) {
        return e0.c().b((Object) feature);
    }

    public static long getFirstRunAt() {
        return SettingsManager.getInstance().getFirstRunAt().getTime();
    }

    public static long getFirstSeen() {
        return SettingsManager.getInstance().getFirstSeen();
    }

    public static String getIdentifiedUserEmail() {
        return com.instabug.library.user.f.h();
    }

    public static String getIdentifiedUsername() {
        return com.instabug.library.user.f.i();
    }

    public static long getLastSeenTimestamp() {
        return SettingsManager.getInstance().getLastSeenTimestamp();
    }

    @Nullable
    public static Object getLastSeenView() {
        return InstabugInternalTrackingDelegate.getInstance().getLastSeenView();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static String getLatestV3SessionId() {
        return i.f51800a.i();
    }

    public static Locale getLocale(@Nullable Context context) {
        return SettingsManager.getInstance().getInstabugLocale(context);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Report.OnReportCreatedListener getOnReportCreatedListener() {
        return SettingsManager.getInstance().getOnReportCreatedListener();
    }

    @Nullable
    public static OnSdkInvokedCallback getOnSdkInvokedCallback() {
        return SettingsManager.getInstance().getOnSdkInvokedCallback();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Platform
    public static int getPlatform() {
        return SettingsManager.getInstance().getCurrentPlatform();
    }

    public static int getPrimaryColor() {
        return SettingsManager.getInstance().getPrimaryColor();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static String getPushNotificationToken() {
        return SettingsManager.getPushNotificationToken();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Session getRunningSession() {
        Session a11 = com.instabug.library.sessionV3.di.c.r().a();
        if (a11 != null) {
            return a11;
        }
        return r0.e().c();
    }

    public static String getSDKVersion() {
        return "11.7.0";
    }

    public static int getSessionCount() {
        return SettingsManager.getInstance().getSessionsCount();
    }

    public static int getStartedActivitiesCount() {
        return md.e.a().getCount();
    }

    public static String getTagsAsString() {
        return SettingsManager.getInstance().getTagsAsString();
    }

    @Nullable
    public static Activity getTargetActivity() {
        return InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
    }

    public static InstabugColorTheme getTheme() {
        return SettingsManager.getInstance().getTheme();
    }

    public static String getUserData() {
        return SettingsManager.getInstance().getUserData();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static IBGSessionCrashesConfigurations getV3SessionCrashesConfigurations() {
        return com.instabug.library.sessionV3.di.c.m();
    }

    public static Plugin getXPlugin(Class cls) {
        return com.instabug.library.core.plugin.c.a(cls);
    }

    public static void handlePbiFooter(@Nullable View view) {
        o.a(view);
    }

    public static void handlePbiFooterThemeColor(@Nullable View view, @ColorRes int i11, @ColorRes int i12) {
        o.a(view, Integer.valueOf(i11), Integer.valueOf(i12));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isAPMEnabled() {
        Class<APMPlugin> cls = APMPlugin.class;
        try {
            Object obj = APMPlugin.lock;
            Plugin a11 = com.instabug.library.core.plugin.c.a((Class) cls);
            if (a11 != null) {
                return a11.isFeatureEnabled();
            }
            return false;
        } catch (ClassNotFoundException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean isAppOnForeground() {
        return SettingsManager.getInstance().isAppOnForeground();
    }

    public static boolean isAutoScreenRecordingEnabled() {
        return SettingsManager.getInstance().isAutoScreenRecordingEnabled();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isCrashReportingEnabled() {
        try {
            Plugin a11 = com.instabug.library.core.plugin.c.a(CrashPlugin.class);
            if (a11 != null) {
                return a11.isFeatureEnabled();
            }
            return false;
        } catch (ClassNotFoundException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isDatabaseTransactionDisabled(@NonNull Context context) {
        return e0.c().c(context);
    }

    public static boolean isDbEncryptionEnabled() {
        return e0.c().a() == Feature.State.ENABLED;
    }

    public static boolean isExperimentalFeatureAvailable(Feature feature) {
        return e0.c().c(feature);
    }

    public static boolean isFeatureAvailable(Feature feature) {
        return e0.c().c((Object) feature);
    }

    public static boolean isFeatureEnabled(Feature feature) {
        return e0.c().b((Object) feature) == Feature.State.ENABLED;
    }

    public static boolean isFeaturesFetchedBefore() {
        return e0.c().f();
    }

    public static boolean isFirstRunAfterEncryptorUpdate() {
        return SettingsManager.getInstance().isFirstRunAfterEncryptorUpdate();
    }

    public static boolean isForegroundBusy() {
        if (SettingsManager.getInstance().isPromptOptionsScreenShown() || SettingsManager.getInstance().isRequestPermissionScreenShown() || SettingsManager.getInstance().isOnboardingShowing() || com.instabug.library.core.plugin.c.h()) {
            return true;
        }
        return false;
    }

    public static void isInitialScreenShotAllowed() {
        SettingsManager.isInitialScreenShotAllowed();
    }

    public static boolean isLastSDKStateEnabled(@NonNull Context context) {
        return new d(context).c();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isPushNotificationTokenSent() {
        return SettingsManager.isPushNotificationTokenSent();
    }

    public static boolean isReproStepsScreenshotEnabled() {
        return SettingsManager.getInstance().isReproStepsScreenshotEnabled();
    }

    public static boolean isUserLoggedOut() {
        return SettingsManager.getInstance().isUserLoggedOut();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean isUsersPageEnabled() {
        return SettingsManager.getInstance().isUsersPageEnabled();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isV3SessionEnabled() {
        return com.instabug.library.sessionV3.di.c.l().i();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void notifyV3SessionDataReadiness(SessionBatchingFilter sessionBatchingFilter) {
        com.instabug.library.sessionV3.di.c.u().a(sessionBatchingFilter);
    }

    public static void reportError(Throwable th2, String str) {
        IBGDiagnostics.reportNonFatal(th2, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static HashMap<String, String> retrieveAllSDKAttributes() {
        return UserAttributeCacheManager.retrieveAllSDKAttributes();
    }

    public static void saveEncryptorVersion(int i11) {
        f s11 = f.s();
        if (s11 != null) {
            s11.c(i11);
        }
    }

    public static void setAutoScreenRecordingEnabled(boolean z11) {
        SettingsManager.getInstance().setAutoScreenRecordingEnabled(z11);
    }

    public static void setBugReportingState(Feature.State state) {
        e0.c().a(Feature.BUG_REPORTING, state);
    }

    public static void setChatsState(Feature.State state) {
        e0.c().a(Feature.CHATS, state);
    }

    public static void setEnteredEmail(String str) {
        com.instabug.library.user.f.d(str);
    }

    public static void setEnteredUsername(String str) {
        com.instabug.library.user.f.e(str);
    }

    public static void setFeatureState(Feature feature, Feature.State state) {
        e0.c().a(feature, state);
    }

    public static void setFirstRunAfterEncryptorUpdate(boolean z11) {
        SettingsManager.getInstance().setFirstRunAfterEncryptorUpdate(z11);
    }

    public static void setIdentifiedUserEmail(String str) {
        com.instabug.library.user.f.f(str);
    }

    public static void setInitialScreenShotAllowed(boolean z11) {
        SettingsManager.setInitialScreenShotAllowed(z11);
    }

    public static void setLastContactedAt(long j11) {
        SettingsManager.getInstance().setLastContactedAt(j11);
    }

    public static void setLastSeenTimestamp(long j11) {
        SettingsManager.getInstance().setLastSeenTimestamp(j11);
    }

    public static void setMessagingState(Feature.State state) {
        e0.c().a(Feature.IN_APP_MESSAGING, state);
    }

    public static void setPbiFooterThemeColor(@Nullable View view, @ColorInt int i11) {
        o.a(view, i11);
    }

    public static <T extends Plugin> void setPluginState(Class<T> cls, int i11) {
        Plugin xPlugin = getXPlugin(cls);
        if (xPlugin != null) {
            xPlugin.setState(i11);
        }
    }

    public static void setPushNotificationState(Feature.State state) {
        e0.c().a(Feature.PUSH_NOTIFICATION, state);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setPushNotificationToken(String str) {
        SettingsManager.setPushNotificationToken(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setPushNotificationTokenSent(boolean z11) {
        SettingsManager.setPushNotificationTokenSent(z11);
    }

    public static void setRepliesState(Feature.State state) {
        e0.c().a(Feature.REPLIES, state);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void setTemporaryDisabled() {
        InstabugSDKLogger.d("IBG-Core", "setTemporaryDisabled disable the SDK internally");
        e0.c().h();
        Method b11 = k0.b(Instabug.class, "disableInternal");
        if (b11 != null) {
            try {
                b11.invoke((Object) null, new Object[0]);
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
    }
}
