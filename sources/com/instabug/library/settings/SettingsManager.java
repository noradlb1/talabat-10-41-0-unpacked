package com.instabug.library.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.OnSdkDismissCallback;
import com.instabug.library.OnSdkInvokedCallback;
import com.instabug.library.Platform;
import com.instabug.library.e0;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.video.customencoding.VideoEncoderConfig;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.invocation.OnInvokeCallback;
import com.instabug.library.model.Report;
import com.instabug.library.model.b;
import com.instabug.library.model.session.config.SessionsConfig;
import com.instabug.library.model.session.config.SessionsConfigMapper;
import com.instabug.library.ui.onboarding.WelcomeMessage;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class SettingsManager {
    private static final String ASR_DURATION_ERROR_MSG_BELOW_MIN = "Auto screen recording duration should be in a range from 30 to 180 seconds. Falling back to %d seconds";
    public static final String INSTABUG_SHARED_PREF_NAME = "instabug";
    public static final int MAX_ASR_DURATION_IN_SECONDS = 180;
    public static final String MIGRATION_STATE_SHARED_PREF = "instabug_migration_state";
    public static final int MIN_ASR_DURATION_IN_SECONDS = 30;
    private static final boolean SHOULD_LOG_EXTRA_REQUEST_DATA = false;
    public static final boolean VERBOSE = false;
    private static SettingsManager settingsManager;

    private int convertSecondToMilliseconds(int i11) {
        return (int) TimeUnit.MILLISECONDS.convert((long) i11, TimeUnit.SECONDS);
    }

    private String getASRError(int i11) {
        if (i11 < 30) {
            return String.format(Locale.ENGLISH, ASR_DURATION_ERROR_MSG_BELOW_MIN, new Object[]{30});
        }
        return String.format(Locale.ENGLISH, ASR_DURATION_ERROR_MSG_BELOW_MIN, new Object[]{180});
    }

    public static long getFatalHangsSensitivity() {
        if (f.s() != null) {
            return f.s().k();
        }
        return ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    }

    public static synchronized SettingsManager getInstance() {
        SettingsManager settingsManager2;
        synchronized (SettingsManager.class) {
            if (settingsManager == null) {
                settingsManager = new SettingsManager();
            }
            settingsManager2 = settingsManager;
        }
        return settingsManager2;
    }

    public static String getPushNotificationToken() {
        if (f.s() != null) {
            return f.s().o();
        }
        return "";
    }

    @Nullable
    public static VideoEncoderConfig getVideoEncoderConfig() {
        return e.j().y();
    }

    public static boolean isInitialScreenShotAllowed() {
        return e.j().E();
    }

    public static boolean isPushNotificationTokenSent() {
        if (f.s() != null) {
            return f.s().F();
        }
        return false;
    }

    public static void setFatalHangsSensitivity(long j11) {
        if (f.s() != null) {
            f.s().e(j11);
        }
    }

    public static void setInitialScreenShotAllowed(boolean z11) {
        e.j().f(z11);
    }

    public static void setPushNotificationToken(String str) {
        if (f.s() != null) {
            f.s().b0(str);
        }
    }

    public static void setPushNotificationTokenSent(boolean z11) {
        if (f.s() != null) {
            f.s().a0(z11);
        }
    }

    public static void setVideoEncoderConfig(@NonNull VideoEncoderConfig videoEncoderConfig) {
        e.j().a(videoEncoderConfig);
    }

    public static boolean shouldLogExtraRequestData() {
        return false;
    }

    public void addExtraAttachmentFile(Uri uri, String str) {
        e.j().a(uri, str);
    }

    public void addPrivateViews(@NonNull View... viewArr) {
        e.j().a(viewArr);
    }

    public void addTags(String... strArr) {
        e.j().a(strArr);
    }

    public boolean autoScreenRecordingEnabled() {
        return e.j().a();
    }

    public int autoScreenRecordingMaxDuration() {
        return e.j().b();
    }

    public void clearExtraAttachmentFiles() {
        e.j().c();
        AttachmentsUtility.clearInternalAttachments(Instabug.getApplicationContext());
    }

    public long geLastForegroundTime() {
        if (f.s() != null) {
            return f.s().v();
        }
        return -1;
    }

    @Nullable
    public Locale getAppLocale() {
        return e.j().d();
    }

    @Nullable
    public String getAppToken() {
        return e.j().i();
    }

    public Feature.State getAutoScreenRecordingAudioCapturingState() {
        return e.j().e();
    }

    @Platform
    public int getCurrentPlatform() {
        return e.j().q();
    }

    @Nullable
    public InstabugCustomTextPlaceHolder getCustomPlaceHolders() {
        return e.j().f();
    }

    public int getCustomTracesCount() {
        if (f.s() != null) {
            return f.s().c();
        }
        return 15;
    }

    @Nullable
    public Bitmap getDarkCustomBrandingLogo() {
        return e.j().g();
    }

    public long getDiagnosticsLastSyncTime() {
        if (f.s() != null) {
            return f.s().e();
        }
        return System.currentTimeMillis();
    }

    public int getDiagnosticsSyncInterval() {
        if (f.s() != null) {
            return f.s().f();
        }
        return 1440;
    }

    @NonNull
    public String getEnteredEmail() {
        if (f.s() != null) {
            return f.s().h();
        }
        return "";
    }

    public String getEnteredUsername() {
        if (f.s() != null) {
            return f.s().i();
        }
        return "";
    }

    public int getExperimentsStoreLimit() {
        f s11 = f.s();
        if (s11 != null) {
            return s11.j();
        }
        return 200;
    }

    @Nullable
    public LinkedHashMap<Uri, String> getExtraAttachmentFiles() {
        return e.j().h();
    }

    public Feature.State getFeatureState(Feature feature, boolean z11) {
        return f.s() != null ? f.s().a(feature.name(), z11) ? Feature.State.ENABLED : Feature.State.DISABLED : z11 ? Feature.State.ENABLED : Feature.State.DISABLED;
    }

    @Nullable
    public b getFeaturesCache() throws JSONException {
        if (f.s() != null) {
            return f.s().l();
        }
        return null;
    }

    public String getFeaturesHash() {
        if (f.s() != null) {
            return f.s().m();
        }
        return "";
    }

    public long getFeaturesTTL() {
        if (f.s() != null) {
            return f.s().n();
        }
        return 0;
    }

    public Date getFirstRunAt() {
        if (f.s() != null) {
            return new Date(f.s().c0());
        }
        return new Date(0);
    }

    public long getFirstSeen() {
        if (f.s() == null) {
            return -1;
        }
        return f.s().p();
    }

    @NonNull
    public String getIdentifiedUserEmail() {
        if (f.s() != null) {
            return f.s().q();
        }
        return "";
    }

    public String getIdentifiedUsername() {
        if (f.s() != null) {
            return f.s().r();
        }
        return "";
    }

    @NonNull
    public Locale getInstabugLocale(@Nullable Context context) {
        return e.j().a(context);
    }

    @Nullable
    public String getLastAppVersion() {
        if (f.s() == null) {
            return null;
        }
        return f.s().t();
    }

    @Deprecated
    public long getLastContactedAt() {
        if (f.s() != null) {
            return f.s().u();
        }
        return 0;
    }

    public int getLastKnownVersionCode() {
        if (f.s() != null) {
            return f.s().w();
        }
        return -1;
    }

    public int getLastMigrationVersion() {
        if (f.s() != null) {
            return f.s().x();
        }
        return 0;
    }

    public String getLastSDKVersion() {
        if (f.s() != null) {
            return f.s().z();
        }
        return "11.7.0";
    }

    public long getLastSeenTimestamp() {
        if (f.s() != null) {
            return f.s().A();
        }
        return System.currentTimeMillis();
    }

    @Nullable
    public Bitmap getLightCustomBrandingLogo() {
        return e.j().k();
    }

    public int getLogLevel() {
        return e.j().l();
    }

    @Nullable
    public String getLoggingFeatureSettings() {
        if (f.s() != null) {
            return f.s().B();
        }
        return null;
    }

    @Nullable
    public String getMD5Uuid() {
        if (f.s() != null) {
            return f.s().C();
        }
        return null;
    }

    @Nullable
    public String getNonFatalsFeatureSettings() {
        if (f.s() != null) {
            return f.s().D();
        }
        return null;
    }

    public int getOSVersion() {
        if (f.s() == null) {
            return -1;
        }
        return f.s().E();
    }

    @Nullable
    public OnInvokeCallback getOnInvokeCallback() {
        return e.j().m();
    }

    @Nullable
    public Report.OnReportCreatedListener getOnReportCreatedListener() {
        return e.j().U();
    }

    @Nullable
    public OnSdkDismissCallback getOnSdkDismissCallback() {
        return e.j().o();
    }

    @Nullable
    public OnSdkInvokedCallback getOnSdkInvokedCallback() {
        return e.j().p();
    }

    public com.instabug.library.percentagefeatures.b getPercentageFeature(String str) {
        com.instabug.library.percentagefeatures.b bVar = new com.instabug.library.percentagefeatures.b();
        if (f.s() == null || str == null) {
            return bVar;
        }
        return f.s().b(str);
    }

    public int getPrimaryColor() {
        return e.j().r();
    }

    @NonNull
    public Collection<View> getPrivateViews() {
        return e.j().s();
    }

    public int getRequestedOrientation() {
        return e.j().t();
    }

    @Nullable
    public String getSavedAppToken() {
        if (f.s() == null) {
            return null;
        }
        return f.s().a();
    }

    public long getSessionStartedAt() {
        return e.j().u();
    }

    public int getSessionStitchingTimeoutInSeconds(int i11) {
        if (f.s() == null) {
            return i11;
        }
        return f.s().a(i11);
    }

    public int getSessionsCount() {
        if (f.s() != null) {
            return f.s().G();
        }
        return 0;
    }

    public SessionsConfig getSessionsSyncConfigurations() {
        if (f.s() != null) {
            return SessionsConfigMapper.map(f.s().H());
        }
        return SessionsConfigMapper.map("{}");
    }

    public int getStatusBarColor() {
        return e.j().v();
    }

    @Nullable
    public ArrayList<String> getTags() {
        return e.j().w();
    }

    public String getTagsAsString() {
        StringBuilder sb2 = new StringBuilder();
        ArrayList w11 = e.j().w();
        if (w11 != null && w11.size() > 0) {
            int size = w11.size();
            for (int i11 = 0; i11 < size; i11++) {
                sb2.append((String) w11.get(i11));
                if (i11 != size - 1) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
            }
        }
        return sb2.toString();
    }

    public InstabugColorTheme getTheme() {
        return e.j().x();
    }

    public String getUserData() {
        if (e0.c().b((Object) Feature.USER_DATA) != Feature.State.ENABLED || f.s() == null) {
            return "";
        }
        return f.s().I();
    }

    @Nullable
    public String getUuid() {
        if (f.s() != null) {
            return f.s().J();
        }
        return null;
    }

    public WelcomeMessage.State getWelcomeMessageState() {
        return WelcomeMessage.State.valueOf(e.j().z().toString());
    }

    public void incrementSessionsCount() {
        if (f.s() != null) {
            f.s().K();
        }
    }

    public boolean isAppOnForeground() {
        if (f.s() != null) {
            return f.s().L();
        }
        return true;
    }

    public boolean isAutoScreenRecordingDenied() {
        return e.j().A();
    }

    public boolean isAutoScreenRecordingEnabled() {
        return e.j().B();
    }

    public boolean isCrashedSession() {
        if (e.j() != null) {
            return e.j().C();
        }
        return false;
    }

    public boolean isCustomBrandingEnabled() {
        return (getLightCustomBrandingLogo() == null || getDarkCustomBrandingLogo() == null) ? false : true;
    }

    public boolean isDeviceRegistered() {
        if (f.s() != null) {
            return f.s().M();
        }
        return false;
    }

    public boolean isFirstDismiss() {
        if (f.s() != null) {
            return f.s().N();
        }
        return true;
    }

    public boolean isFirstRun() {
        if (f.s() != null) {
            return f.s().O();
        }
        return true;
    }

    public boolean isFirstRunAfterEncryptorUpdate() {
        if (f.s() != null) {
            return f.s().P();
        }
        return true;
    }

    public boolean isFirstSession() {
        if (f.s() != null) {
            return f.s().Q();
        }
        return true;
    }

    public boolean isInBackground() {
        return e.j().D();
    }

    public boolean isOSVersionSet() {
        return getOSVersion() != -1;
    }

    public boolean isOnboardingShowing() {
        return e.j().G();
    }

    public boolean isProcessingForeground() {
        return e.j().H();
    }

    public boolean isPromptOptionsScreenShown() {
        return e.j().n();
    }

    public boolean isReproStepsScreenshotEnabled() {
        return e.j().I();
    }

    public boolean isRequestPermissionScreenShown() {
        return e.j().J();
    }

    public boolean isSDKVersionSet() {
        if (f.s() != null) {
            return f.s().S();
        }
        return false;
    }

    public boolean isScreenCurrentlyRecorded() {
        return e.j().L();
    }

    public boolean isScreenshotByMediaProjectionEnabled() {
        return e.j().M();
    }

    public boolean isSessionEnabled() {
        if (f.s() != null) {
            return f.s().T();
        }
        return true;
    }

    public boolean isUserLoggedOut() {
        if (f.s() != null) {
            return f.s().U();
        }
        return true;
    }

    public boolean isUsersPageEnabled() {
        if (f.s() != null) {
            return f.s().V();
        }
        return false;
    }

    public void release() {
        e.N();
    }

    public void removePrivateViews(@NonNull View... viewArr) {
        e.j().b(viewArr);
    }

    public void resetRequestedOrientation() {
        e.j().O();
    }

    public void resetSessionCount() {
        if (f.s() != null) {
            f.s().W();
        }
    }

    public void resetTags() {
        e.j().P();
    }

    public void saveCustomTracesCount(int i11) {
        if (f.s() != null) {
            f.s().b(i11);
        }
    }

    public void savePercentageFeature(@Nullable String str, @Nullable com.instabug.library.percentagefeatures.b bVar) {
        if (f.s() != null) {
            f.s().a(str, bVar);
        }
    }

    public void setAppLocale(Locale locale) {
        e.j().a(locale);
    }

    public void setAppToken(String str) {
        e.j().a(str);
    }

    public void setAutoScreenRecordingAudioCapturingState(Feature.State state) {
        e.j().a(state);
    }

    public void setAutoScreenRecordingDenied(boolean z11) {
        e.j().a(z11);
    }

    public void setAutoScreenRecordingEnabled(boolean z11) {
        e.j().b(z11);
    }

    public void setCrashedSession(boolean z11) {
        if (e.j() != null) {
            e.j().c(z11);
        }
    }

    public void setCurrentPlatform(@Platform int i11) {
        e.j().a(i11);
    }

    public void setCurrentSDKVersion(String str) {
        if (f.s() != null) {
            f.s().d(str);
        }
    }

    public void setCustomPlaceHolders(InstabugCustomTextPlaceHolder instabugCustomTextPlaceHolder) {
        e.j().a(instabugCustomTextPlaceHolder);
    }

    public void setDarkCustomBrandingLogo(Bitmap bitmap) {
        e.j().a(bitmap);
    }

    public void setDiagnosticsLastSyncTime(long j11) {
        if (f.s() != null) {
            f.s().d(j11);
        }
    }

    public void setDiagnosticsSyncInterval(int i11) {
        if (f.s() != null) {
            f.s().d(i11);
        }
    }

    public void setEnteredEmail(String str) {
        if (f.s() != null) {
            f.s().e(str);
        }
    }

    public void setEnteredUsername(String str) {
        if (f.s() != null) {
            f.s().f(str);
        }
    }

    public void setExperimentsStoreLimit(int i11) {
        f s11 = f.s();
        if (s11 != null) {
            s11.e(i11);
        }
    }

    public void setFeatureEnabled(String str, boolean z11) {
        if (f.s() != null) {
            InstabugSDKLogger.d("IBG-Core", "Saving feature: " + str + " enabled state to " + z11);
            f.s().b(str, z11);
        }
    }

    public void setFeaturesCache(b bVar) throws JSONException {
        if (f.s() != null) {
            f.s().R(bVar);
        }
    }

    public void setFeaturesHash(@Nullable String str) {
        if (f.s() != null) {
            f.s().g(str);
        }
    }

    public void setFeaturesTTL(long j11) {
        if (f.s() != null) {
            f.s().f(j11);
        }
    }

    public void setFirstRunAfterEncryptorUpdate(boolean z11) {
        if (f.s() != null) {
            f.s().a(z11);
        }
    }

    public void setFirstRunAt(long j11) {
        if (f.s() != null) {
            f.s().Z(j11);
        }
    }

    public void setFirstSeen(long j11) {
        if (f.s() != null) {
            f.s().h(j11);
        }
    }

    public void setIdentifiedUserEmail(String str) {
        if (f.s() != null) {
            f.s().h(str);
        }
    }

    public void setIdentifiedUsername(@Nullable String str) {
        if (f.s() != null) {
            f.s().i(str);
        }
    }

    public void setIgnoreFlagSecure(boolean z11) {
        e.j().d(z11);
    }

    public void setInBackground(boolean z11) {
        e.j().e(z11);
    }

    public void setInstabugLocale(Locale locale) {
        e.j().b(locale);
    }

    public void setIsAppOnForeground(boolean z11) {
        if (f.s() != null) {
            f.s().b(z11);
        }
    }

    public void setIsDeviceRegistered(boolean z11) {
        if (f.s() != null) {
            f.s().c(z11);
        }
    }

    public void setIsFirstDismiss(boolean z11) {
        if (f.s() != null) {
            f.s().d(z11);
        }
    }

    public void setIsFirstRun(boolean z11) {
        if (f.s() != null) {
            f.s().e(z11);
        }
    }

    public void setIsFirstSession(boolean z11) {
        if (f.s() != null) {
            f.s().f(z11);
        }
    }

    public void setIsSessionEnabled(boolean z11) {
        if (f.s() != null) {
            f.s().g(z11);
        }
    }

    public void setLastAppVersion(@Nullable String str) {
        if (f.s() != null) {
            f.s().j(str);
        }
    }

    @Deprecated
    public void setLastContactedAt(long j11) {
        if (f.s() != null) {
            f.s().i(j11);
        }
    }

    public void setLastForegroundTime(long j11) {
        if (f.s() != null) {
            f.s().j(j11);
        }
    }

    public void setLastMigrationVersion(int i11) {
        if (f.s() != null) {
            f.s().f(i11);
        }
    }

    public void setLastSeenTimestamp(long j11) {
        if (f.s() != null) {
            f.s().k(j11);
        }
    }

    public void setLightCustomBrandingLogo(Bitmap bitmap) {
        e.j().b(bitmap);
    }

    public void setLogLevel(int i11) {
        e.j().b(i11);
    }

    public void setLoggingFeatureSettings(@Nullable String str) {
        if (f.s() != null) {
            f.s().k(str);
        }
    }

    public void setMD5Uuid(@Nullable String str) {
        if (f.s() != null) {
            f.s().l(str);
        }
    }

    public void setNonFatalsFeatureSettings(String str) {
        if (f.s() != null) {
            f.s().m(str);
        }
    }

    public void setOSVersion(int i11) {
        if (f.s() != null) {
            f.s().g(i11);
        }
    }

    public void setOnInvokeCallback(OnInvokeCallback onInvokeCallback) {
        e.j().a(onInvokeCallback);
    }

    public void setOnReportCreatedListener(Report.OnReportCreatedListener onReportCreatedListener) {
        e.j().K(onReportCreatedListener);
    }

    public void setOnSdkDismissCallback(OnSdkDismissCallback onSdkDismissCallback) {
        e.j().a(onSdkDismissCallback);
    }

    public void setOnSdkInvokedCallback(OnSdkInvokedCallback onSdkInvokedCallback) {
        e.j().a(onSdkInvokedCallback);
    }

    public void setOnboardingShowing(boolean z11) {
        e.j().h(z11);
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void setPrimaryColor(@ColorInt int i11) {
        e.j().c(i11);
        InvocationManager.getInstance().notifyPrimaryColorChanged();
    }

    public void setProcessingForeground(boolean z11) {
        e.j().i(z11);
    }

    public void setPromptOptionsScreenShown(boolean z11) {
        e.j().R(z11);
    }

    public void setReproStepsScreenshotEnabled(boolean z11) {
        e.j().S(z11);
    }

    public void setRequestPermissionScreenShown(boolean z11) {
        e.j().T(z11);
    }

    public void setRequestedOrientation(int i11) {
        e.j().d(i11);
    }

    public void setSavedAppToken(String str) {
        if (f.s() != null) {
            f.s().c(str);
        }
    }

    public void setScreenCurrentlyRecorded(boolean z11) {
        e.j().m(z11);
    }

    public void setScreenshotByMediaProjectionEnabled(boolean z11) {
        e.j().n(z11);
    }

    public void setSessionStartedAt(long j11) {
        e.j().a(j11);
    }

    public void setSessionStitchingTimeout(int i11) {
        if (f.s() != null) {
            f.s().i(i11);
        }
    }

    public void setSessionsSyncConfigurations(String str) {
        if (f.s() != null) {
            f.s().o(str);
        }
    }

    public void setShouldAutoShowOnboarding(boolean z11) {
        if (f.s() != null) {
            f.s().i(z11);
        }
    }

    public void setShouldMakeUUIDMigrationRequest(boolean z11) {
        if (f.s() != null) {
            f.s().j(z11);
        }
    }

    public void setStatusBarColor(int i11) {
        e.j().e(i11);
    }

    public void setTheme(InstabugColorTheme instabugColorTheme) {
        e.j().a(instabugColorTheme);
    }

    public void setUserData(String str) {
        if (f.s() != null) {
            f.s().p(str);
        }
    }

    public void setUserLoggedOut(boolean z11) {
        if (f.s() != null) {
            f.s().k(z11);
        }
    }

    public void setUsersPageEnabled(boolean z11) {
        if (f.s() != null) {
            f.s().l(z11);
        }
    }

    public void setUuid(@Nullable String str) {
        if (f.s() != null) {
            f.s().q(str);
        }
    }

    public void setVersionCode(int i11) {
        if (f.s() != null) {
            f.s().j(i11);
        }
    }

    public void setWelcomeMessageState(WelcomeMessage.State state) {
        e.j().a(state);
    }

    public boolean shouldAutoShowOnboarding() {
        if (f.s() != null) {
            return f.s().X();
        }
        return true;
    }

    public boolean shouldIgnoreFlagSecure() {
        return e.j().Q();
    }

    public boolean shouldMakeUUIDMigrationRequest() {
        if (f.s() != null) {
            return f.s().Y();
        }
        return false;
    }

    public void updateUserSessionCount(int i11) {
        if (f.s() != null) {
            f.s().h(i11);
        }
    }

    public void addExtraAttachmentFile(byte[] bArr, String str) {
        Uri uriFromBytes;
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            InstabugSDKLogger.e("IBG-Core", "Can't execute addExtraAttachmentFile(). Null context");
        } else if (AttachmentsUtility.isValidSize((double) bArr.length, 5.0d) && (uriFromBytes = AttachmentsUtility.getUriFromBytes(applicationContext, bArr, str)) != null) {
            e.j().a(uriFromBytes, str);
        }
    }

    public boolean getFeatureState(String str, boolean z11) {
        return f.s() != null ? f.s().a(str, z11) : z11;
    }

    public static SessionsConfig getSessionsSyncConfigurations(@NonNull Context context) {
        return SessionsConfigMapper.map(f.a(context));
    }
}
