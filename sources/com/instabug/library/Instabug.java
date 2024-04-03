package com.instabug.library;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Feature;
import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.diagnostics.customtraces.IBGPendingTraceHandler;
import com.instabug.library.internal.video.customencoding.VideoEncoderConfig;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.invocation.util.InstabugFloatingButtonEdge;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.model.Report;
import com.instabug.library.screenshot.ScreenshotProvider;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.ui.onboarding.WelcomeMessage;
import com.instabug.library.user.UserEventParam;
import com.instabug.library.util.InstabugDeprecationLogger;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.visualusersteps.State;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

public class Instabug {
    /* access modifiers changed from: private */
    @Nullable
    public static volatile Instabug INSTANCE;
    /* access modifiers changed from: private */
    public static Context appContext;
    /* access modifiers changed from: private */
    public c0 delegate;

    public static class Builder {
        private static volatile boolean isBuildCalled = false;
        private Feature.State anrDefaultState;
        /* access modifiers changed from: private */
        @Nullable
        public Application application;
        /* access modifiers changed from: private */
        public Context applicationContext;
        /* access modifiers changed from: private */
        public String applicationToken;
        private boolean bugPromptOptionEnable;
        private boolean chatPromptOptionEnable;
        private boolean commentFieldRequired;
        private Feature.State consoleLogState;
        private List<Integer> deprecatedMethodsToBeLogedAfterBuild;
        private boolean emailFieldRequired;
        private boolean emailFieldVisibility;
        private boolean feedbackPromptOptionEnable;
        /* access modifiers changed from: private */
        public int floatingButtonOffsetFromTop;
        private Feature.State inAppMessagingState;
        /* access modifiers changed from: private */
        public InstabugFloatingButtonEdge instabugFloatingButtonEdge;
        /* access modifiers changed from: private */
        public InstabugInvocationEvent[] instabugInvocationEvents;
        private Feature.State instabugLogState;
        private int instabugStatusBarColor;
        private boolean introMessageEnabled;
        private boolean isSurveysAutoShowing;
        private Feature.State pushNotificationState;
        private State reproStepsState;
        private int shakingThreshold;
        private boolean shouldPlaySounds;
        private boolean successDialogEnabled;
        private Feature.State surveysState;
        private Feature.State trackingUserStepsState;
        private Feature.State userDataState;
        private Feature.State userEventsState;
        private Feature.State viewHierarchyState;

        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Feature.State f50497b;

            public a(Feature.State state) {
                this.f50497b = state;
            }

            public void run() {
                boolean z11;
                InstabugState instabugState;
                IBGPendingTraceHandler.setBuilderBGStartTime(System.currentTimeMillis());
                if (Builder.this.application != null) {
                    if (Builder.this.applicationToken == null || Builder.this.applicationToken.trim().isEmpty()) {
                        InstabugSDKLogger.w("IBG-Core", "Invalid application token. Abort building the SDK");
                        return;
                    }
                    com.instabug.library.core.b.a();
                    InstabugSDKLogger.d("IBG-Core", "Building Instabug From BG thread, thread name: " + Thread.currentThread().getName());
                    c0 a11 = c0.a(Builder.this.application);
                    Instabug unused = Instabug.INSTANCE = new Instabug(a11, (k) null);
                    InstabugSDKLogger.initLogger(Builder.this.applicationContext);
                    Feature.State state = this.f50497b;
                    Feature.State state2 = Feature.State.ENABLED;
                    if (state == state2) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    e0 c11 = e0.c();
                    Feature feature = Feature.INSTABUG;
                    if (!z11) {
                        state2 = Feature.State.DISABLED;
                    }
                    c11.a(feature, state2);
                    a11.W(InstabugState.BUILDING);
                    Builder.this.logDeprecatedApis();
                    String appToken = SettingsManager.getInstance().getAppToken();
                    if (!(Builder.this.applicationToken == null || appToken == null || Builder.this.applicationToken.equals(appToken))) {
                        com.instabug.library.user.f.s();
                    }
                    SettingsManager.getInstance().setAppToken(Builder.this.applicationToken);
                    com.instabug.library.core.plugin.c.a(Builder.this.applicationContext);
                    new com.instabug.library.settings.d(Builder.this.applicationContext).a(z11);
                    r0.a(SettingsManager.getInstance());
                    try {
                        a11.a(Builder.this.applicationContext);
                        if (z11) {
                            instabugState = InstabugState.ENABLED;
                        } else {
                            instabugState = InstabugState.DISABLED;
                        }
                        a11.W(instabugState);
                        a11.t();
                        InvocationManager.getInstance().getCurrentInvocationSettings().setFloatingButtonEdge(Builder.this.instabugFloatingButtonEdge);
                        InvocationManager.getInstance().notifyPrimaryColorChanged();
                        InvocationManager.getInstance().setInstabugInvocationEvent(Builder.this.instabugInvocationEvents);
                        if (Builder.this.floatingButtonOffsetFromTop != -1) {
                            InvocationManager.getInstance().getCurrentInvocationSettings().setFloatingButtonOffsetFromTop(Builder.this.floatingButtonOffsetFromTop);
                        }
                        SDKCoreEventPublisher.post(new SDKCoreEvent("sdk_state", "built"));
                        Builder.this.updateFeaturesStates();
                        Builder.this.logFeaturesStates(Boolean.valueOf(z11));
                        InstabugSDKLogger.d("IBG-Core", "SDK Built");
                    } catch (Exception e11) {
                        InstabugSDKLogger.e("IBG-Core", "Error while building the sdk: ", e11);
                    }
                    IBGPendingTraceHandler.setBuilderBGEndTime(System.currentTimeMillis());
                }
            }
        }

        public Builder(@NonNull Application application2, @NonNull String str) {
            this(application2, str, InstabugInvocationEvent.SHAKE);
        }

        /* access modifiers changed from: private */
        public void logDeprecatedApis() {
            for (Integer intValue : this.deprecatedMethodsToBeLogedAfterBuild) {
                InstabugDeprecationLogger.getInstance().log(intValue.intValue());
            }
        }

        /* access modifiers changed from: private */
        public void logFeaturesStates(Boolean bool) {
            InstabugSDKLogger.v("IBG-Core", "User data feature state is set to " + this.userDataState);
            InstabugSDKLogger.v("IBG-Core", "Console log feature state is set to " + this.consoleLogState);
            InstabugSDKLogger.v("IBG-Core", "Instabug logs feature state is set to " + this.instabugLogState);
            InstabugSDKLogger.v("IBG-Core", "In-App messaging feature state is set to" + this.inAppMessagingState);
            InstabugSDKLogger.v("IBG-Core", "Push notification feature state is set to " + this.pushNotificationState);
            InstabugSDKLogger.v("IBG-Core", "Tracking user steps feature state is set to " + this.trackingUserStepsState);
            InstabugSDKLogger.v("IBG-Core", "Repro steps feature state is set to " + this.reproStepsState);
            InstabugSDKLogger.v("IBG-Core", "View hierarchy feature state is set to " + this.viewHierarchyState);
            InstabugSDKLogger.v("IBG-Core", "Surveys feature state is set to " + this.surveysState);
            InstabugSDKLogger.v("IBG-Core", "User events feature state is set to " + this.userEventsState);
            InstabugSDKLogger.v("IBG-Core", "Instabug overall state is set to " + bool);
        }

        private void startVitalComponents() {
            if (this.application != null) {
                md.e.a().b();
                InstabugInternalTrackingDelegate.init(this.application);
            }
        }

        /* access modifiers changed from: private */
        public void updateFeaturesStates() {
            InstabugCore.setFeatureState(Feature.USER_DATA, this.userDataState);
            InstabugCore.setFeatureState(Feature.CONSOLE_LOGS, this.consoleLogState);
            InstabugCore.setFeatureState(Feature.INSTABUG_LOGS, this.instabugLogState);
            InstabugCore.setFeatureState(Feature.IN_APP_MESSAGING, this.inAppMessagingState);
            InstabugCore.setFeatureState(Feature.PUSH_NOTIFICATION, this.pushNotificationState);
            InstabugCore.setFeatureState(Feature.TRACK_USER_STEPS, this.trackingUserStepsState);
            com.instabug.library.visualusersteps.z.a(this.reproStepsState);
            InstabugCore.setFeatureState(Feature.VIEW_HIERARCHY_V2, this.viewHierarchyState);
            InstabugCore.setFeatureState(Feature.SURVEYS, this.surveysState);
            InstabugCore.setFeatureState(Feature.USER_EVENTS, this.userEventsState);
        }

        @Nullable
        public void build() {
            IBGPendingTraceHandler.setBuilderFGStartTime(System.currentTimeMillis());
            Context unused = Instabug.appContext = this.applicationContext;
            InstabugSDKLogger.d("IBG-Core", "building sdk with default state ");
            if (isBuildCalled) {
                InstabugSDKLogger.v("IBG-Core", "isBuildCalled true returning..");
                return;
            }
            isBuildCalled = true;
            j(Feature.State.ENABLED);
            IBGPendingTraceHandler.setBuilderFGEndTime(System.currentTimeMillis());
        }

        public Builder ignoreFlagSecure(boolean z11) {
            SettingsManager.getInstance().setIgnoreFlagSecure(z11);
            return this;
        }

        @VisibleForTesting
        public void j(Feature.State state) {
            PoolProvider.getApiExecutor().execute(new a(state));
        }

        public Builder setConsoleLogState(@NonNull Feature.State state) {
            this.consoleLogState = state;
            return this;
        }

        @Deprecated
        public Builder setDebugEnabled(boolean z11) {
            return this;
        }

        public Builder setInAppMessagingState(@NonNull Feature.State state) {
            this.inAppMessagingState = state;
            return this;
        }

        public Builder setInstabugLogState(@NonNull Feature.State state) {
            this.instabugLogState = state;
            return this;
        }

        public Builder setInvocationEvents(@NonNull InstabugInvocationEvent... instabugInvocationEventArr) {
            this.instabugInvocationEvents = instabugInvocationEventArr;
            return this;
        }

        public Builder setReproStepsState(State state) {
            this.reproStepsState = state;
            return this;
        }

        public Builder setSdkDebugLogsLevel(int i11) {
            SettingsManager.getInstance().setLogLevel(i11);
            return this;
        }

        public Builder setTrackingUserStepsState(@NonNull Feature.State state) {
            this.trackingUserStepsState = state;
            return this;
        }

        public Builder setUserDataState(@NonNull Feature.State state) {
            this.userDataState = state;
            return this;
        }

        public Builder setUserEventsState(@NonNull Feature.State state) {
            this.userEventsState = state;
            return this;
        }

        public Builder setViewHierarchyState(@NonNull Feature.State state) {
            this.viewHierarchyState = state;
            return this;
        }

        public Builder(@NonNull Application application2, @NonNull String str, @NonNull InstabugInvocationEvent... instabugInvocationEventArr) {
            this(application2.getApplicationContext(), str, instabugInvocationEventArr);
            this.application = application2;
        }

        public Builder(@NonNull Context context, @NonNull String str, @NonNull InstabugInvocationEvent... instabugInvocationEventArr) {
            this.instabugStatusBarColor = -3815737;
            this.instabugInvocationEvents = new InstabugInvocationEvent[]{InstabugInvocationEvent.SHAKE};
            Feature.State state = e0.f50555e;
            this.userDataState = state;
            this.consoleLogState = state;
            this.instabugLogState = state;
            this.inAppMessagingState = state;
            this.pushNotificationState = state;
            this.trackingUserStepsState = state;
            this.reproStepsState = State.ENABLED;
            this.viewHierarchyState = Feature.State.DISABLED;
            this.surveysState = state;
            this.userEventsState = state;
            this.anrDefaultState = state;
            this.emailFieldRequired = true;
            this.emailFieldVisibility = true;
            this.commentFieldRequired = false;
            this.introMessageEnabled = true;
            this.shouldPlaySounds = false;
            this.successDialogEnabled = true;
            this.instabugFloatingButtonEdge = InstabugFloatingButtonEdge.RIGHT;
            this.shakingThreshold = 650;
            this.floatingButtonOffsetFromTop = -1;
            this.isSurveysAutoShowing = true;
            this.chatPromptOptionEnable = true;
            this.bugPromptOptionEnable = true;
            this.feedbackPromptOptionEnable = true;
            this.deprecatedMethodsToBeLogedAfterBuild = new ArrayList();
            this.applicationContext = context;
            this.instabugInvocationEvents = instabugInvocationEventArr;
            this.applicationToken = str;
        }

        @Nullable
        public void build(Feature.State state) {
            String str;
            IBGPendingTraceHandler.setBuilderFGStartTime(System.currentTimeMillis());
            Context unused = Instabug.appContext = this.applicationContext;
            if (state != Feature.State.DISABLED || ((str = this.applicationToken) != null && !str.isEmpty())) {
                InstabugSDKLogger.d("IBG-Core", "building sdk with state " + state);
                if (isBuildCalled) {
                    InstabugSDKLogger.v("IBG-Core", "isBuildCalled true returning..");
                    return;
                }
                isBuildCalled = true;
                j(state);
                IBGPendingTraceHandler.setBuilderFGEndTime(System.currentTimeMillis());
                return;
            }
            startVitalComponents();
        }
    }

    public class a implements Runnable {
        public void run() {
            APIChecker.checkBuilt("Instabug.enable", new b(this));
        }
    }

    public class a0 implements VoidRunnable {
        public void run() {
            InvocationManager.getInstance().show();
        }
    }

    public class b implements VoidRunnable {
        public void run() {
            if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.F();
            }
            InstabugSDKLogger.d("IBG-Core", "disable");
        }
    }

    public class b0 implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View[] f50499a;

        public b0(View[] viewArr) {
            this.f50499a = viewArr;
        }

        public void run() {
            if (Instabug.getInstance() != null && Instabug.getInstance().delegate != null) {
                Instabug.getInstance().delegate.a(this.f50499a);
            }
        }
    }

    public class c implements VoidRunnable {
        public void run() {
            if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.w0();
            }
            InstabugSDKLogger.d("IBG-Core", "pauseSdk");
        }
    }

    public class c0 implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View[] f50500a;

        public c0(View[] viewArr) {
            this.f50500a = viewArr;
        }

        public void run() {
            if (Instabug.getInstance() != null && Instabug.getInstance().delegate != null) {
                Instabug.getInstance().delegate.b(this.f50500a);
            }
        }
    }

    public class d implements VoidRunnable {
        public void run() {
            if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.D0();
            }
            InstabugSDKLogger.d("IBG-Core", "resumeSdk");
        }
    }

    public class d0 implements VoidRunnable {
        public void run() {
            if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.F();
                InstabugSDKLogger.d("IBG-Core", "disableInternal");
            }
        }
    }

    public class e implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Locale f50501a;

        public e(Locale locale) {
            this.f50501a = locale;
        }

        public void run() {
            if (this.f50501a == null) {
                InstabugSDKLogger.w("IBG-Core", "locale object passed to Instabug.setLocale is null");
            } else if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.a0(this.f50501a);
            }
        }
    }

    public class e0 implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f50502a;

        public e0(List list) {
            this.f50502a = list;
        }

        public void run() throws Exception {
            Instabug k11 = Instabug.getInstance();
            if (k11 != null) {
                k11.delegate.a(this.f50502a);
            }
        }
    }

    public class f implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f50503a;

        public f(Context context) {
            this.f50503a = context;
        }

        @Nullable
        /* renamed from: a */
        public Locale run() {
            return SettingsManager.getInstance().getInstabugLocale(this.f50503a);
        }
    }

    public class f0 implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f50504a;

        public f0(List list) {
            this.f50504a = list;
        }

        public void run() throws Exception {
            Instabug k11 = Instabug.getInstance();
            if (k11 != null) {
                k11.delegate.b(this.f50504a);
            }
        }
    }

    public class g implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f50505a;

        public g(String[] strArr) {
            this.f50505a = strArr;
        }

        public void run() {
            SettingsManager.getInstance().addTags(StringUtility.trimStrings(this.f50505a));
        }
    }

    public class g0 implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f50506a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50507b;

        public g0(Uri uri, String str) {
            this.f50506a = uri;
            this.f50507b = str;
        }

        public void run() {
            if (this.f50506a == null) {
                InstabugSDKLogger.w("IBG-Core", "fileUri object passed to Instabug.addFileAttachment() is null");
            } else if (this.f50507b == null) {
                InstabugSDKLogger.w("IBG-Core", "fileNameWithExtension passed to Instabug.addFileAttachment() is null");
            } else {
                SettingsManager.getInstance().addExtraAttachmentFile(this.f50506a, this.f50507b);
                InstabugSDKLogger.d("IBG-Core", "addFileAttachment file uri: " + this.f50506a);
            }
        }
    }

    public class h implements ReturnableRunnable {
        @Nullable
        /* renamed from: a */
        public ArrayList run() {
            return SettingsManager.getInstance().getTags();
        }
    }

    public class h0 implements VoidRunnable {
        public void run() throws Exception {
            Instabug k11 = Instabug.getInstance();
            if (k11 != null) {
                k11.delegate.c();
            }
        }
    }

    public class i implements VoidRunnable {
        public void run() {
            SettingsManager.getInstance().resetTags();
        }
    }

    public static /* synthetic */ class i0 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50508a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.instabug.library.InstabugColorTheme[] r0 = com.instabug.library.InstabugColorTheme.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50508a = r0
                com.instabug.library.InstabugColorTheme r1 = com.instabug.library.InstabugColorTheme.InstabugColorThemeDark     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50508a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.instabug.library.InstabugColorTheme r1 = com.instabug.library.InstabugColorTheme.InstabugColorThemeLight     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.Instabug.i0.<clinit>():void");
        }
    }

    public class j implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InstabugCustomTextPlaceHolder f50509a;

        public j(InstabugCustomTextPlaceHolder instabugCustomTextPlaceHolder) {
            this.f50509a = instabugCustomTextPlaceHolder;
        }

        public void run() {
            if (this.f50509a == null) {
                InstabugSDKLogger.w("IBG-Core", "instabugCustomTextPlaceHolder object passed to Instabug.setCustomTextPlaceHolders() is null");
            } else {
                SettingsManager.getInstance().setCustomPlaceHolders(this.f50509a);
            }
        }
    }

    public class j0 implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f50510a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50511b;

        public j0(byte[] bArr, String str) {
            this.f50510a = bArr;
            this.f50511b = str;
        }

        public void run() {
            if (this.f50510a == null) {
                InstabugSDKLogger.w("IBG-Core", "data object passed to Instabug.addFileAttachment() is null");
            } else if (this.f50511b == null) {
                InstabugSDKLogger.w("IBG-Core", "fileNameWithExtension  passed to Instabug.addFileAttachment() is null");
            } else {
                SettingsManager.getInstance().addExtraAttachmentFile(this.f50510a, this.f50511b);
                InstabugSDKLogger.d("IBG-Core", "addFileAttachment bytes");
            }
        }
    }

    public class k implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f50512a;

        public k(int i11) {
            this.f50512a = i11;
        }

        public void run() {
            SettingsManager.getInstance().setPrimaryColor(this.f50512a);
        }
    }

    public class k0 implements VoidRunnable {
        public void run() {
            SettingsManager.getInstance().clearExtraAttachmentFiles();
            InstabugSDKLogger.d("IBG-Core", "clearFileAttachment");
        }
    }

    public class l implements ReturnableRunnable {
        /* renamed from: a */
        public HashMap run() {
            if (Instabug.getInstance() != null) {
                return Instabug.getInstance().delegate.i();
            }
            return new HashMap();
        }
    }

    public class l0 implements ReturnableRunnable {
        /* renamed from: a */
        public String run() {
            return SettingsManager.getInstance().getUserData();
        }
    }

    public class m implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50513a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50514b;

        public m(String str, String str2) {
            this.f50513a = str;
            this.f50514b = str2;
        }

        public void run() {
            if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.a(this.f50513a, this.f50514b);
            }
            InstabugSDKLogger.d("IBG-Core", "setUserAttribute");
        }
    }

    public class m0 implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50515a;

        public m0(String str) {
            this.f50515a = str;
        }

        public void run() {
            if (e0.c().b((Object) Feature.USER_DATA) == Feature.State.ENABLED) {
                SettingsManager.getInstance().setUserData(StringUtility.trimString(this.f50515a, 1000));
            }
        }
    }

    public class n implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50516a;

        public n(String str) {
            this.f50516a = str;
        }

        @Nullable
        /* renamed from: a */
        public String run() {
            if (Instabug.getInstance() != null) {
                return Instabug.getInstance().delegate.a(this.f50516a);
            }
            return null;
        }
    }

    public class n0 implements ReturnableRunnable {
        /* renamed from: a */
        public String run() {
            return com.instabug.library.user.f.h();
        }
    }

    public class o implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50517a;

        public o(String str) {
            this.f50517a = str;
        }

        public void run() {
            if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.b(this.f50517a);
            }
            InstabugSDKLogger.d("IBG-Core", "removeUserAttribute");
        }
    }

    public class o0 implements VoidRunnable {
        public void run() {
            com.instabug.library.user.f.s();
            InstabugSDKLogger.d("IBG-Core", "logoutUser");
        }
    }

    public class p implements VoidRunnable {
        public void run() {
            if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.d();
            }
            InstabugSDKLogger.d("IBG-Core", "clearAllUserAttributes");
        }
    }

    public class q implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WelcomeMessage.State f50518a;

        public q(WelcomeMessage.State state) {
            this.f50518a = state;
        }

        public void run() {
            if (this.f50518a == null) {
                InstabugSDKLogger.w("IBG-Core", "welcomeMessageState object passed to Instabug.setWelcomeMessageState() is null");
            } else {
                PoolProvider.postIOTaskWithCheck(new c(this));
            }
        }
    }

    public class r implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WelcomeMessage.State f50519a;

        public r(WelcomeMessage.State state) {
            this.f50519a = state;
        }

        public void run() {
            if (this.f50519a == null) {
                InstabugSDKLogger.w("IBG-Core", "welcomeMessageState object passed to Instabug.showWelcomeMessage() is null");
                return;
            }
            if (!InstabugCore.isForegroundBusy() && Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.c(this.f50519a);
            }
            InstabugSDKLogger.i("IBG-Core", "showWelcomeMessage: " + this.f50519a.name());
        }
    }

    public class s implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f50520a;

        public s(Feature.State state) {
            this.f50520a = state;
        }

        public void run() {
            if (this.f50520a == null) {
                InstabugSDKLogger.w("IBG-Core", "state object passed to Instabug.setSessionProfilerState() is null");
                return;
            }
            if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.V(this.f50520a);
            }
            InstabugSDKLogger.d("IBG-Core", "setSessionProfilerState: " + this.f50520a.name());
        }
    }

    public class t implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f50521a;

        public t(Feature.State state) {
            this.f50521a = state;
        }

        public void run() {
            if (this.f50521a == null) {
                InstabugSDKLogger.w("IBG-Core", "state object passed to Instabug.setTrackingUserStepsState() is null");
                return;
            }
            e0.c().a(Feature.TRACK_USER_STEPS, this.f50521a);
            InstabugSDKLogger.d("IBG-Core", "setTrackingUserStepsState: " + this.f50521a.name());
        }
    }

    public class u implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ State f50522a;

        public u(State state) {
            this.f50522a = state;
        }

        public void run() {
            com.instabug.library.visualusersteps.z.a(this.f50522a);
        }
    }

    public class v implements ReturnableRunnable {
        /* renamed from: a */
        public InstabugColorTheme run() {
            return SettingsManager.getInstance().getTheme();
        }
    }

    public class w implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InstabugColorTheme f50523a;

        public w(InstabugColorTheme instabugColorTheme) {
            this.f50523a = instabugColorTheme;
        }

        public void run() {
            SettingsManager.getInstance().setTheme(this.f50523a);
            int i11 = i0.f50508a[this.f50523a.ordinal()];
            if (i11 == 1) {
                SettingsManager.getInstance().setPrimaryColor(-9580554);
                SettingsManager.getInstance().setStatusBarColor(-16119286);
            } else if (i11 == 2) {
                SettingsManager.getInstance().setPrimaryColor(-15893761);
                SettingsManager.getInstance().setStatusBarColor(-3815737);
            }
        }
    }

    public class x implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50524a;

        public x(String str) {
            this.f50524a = str;
        }

        public void run() {
            InstabugUserEventLogger.getInstance().logUserEvent(this.f50524a, new UserEventParam[0]);
            InstabugSDKLogger.d("IBG-Core", "logUserEvent: " + this.f50524a);
        }
    }

    public class y implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Report.OnReportCreatedListener f50525a;

        public y(Report.OnReportCreatedListener onReportCreatedListener) {
            this.f50525a = onReportCreatedListener;
        }

        public void run() {
            SettingsManager.getInstance().setOnReportCreatedListener(this.f50525a);
        }
    }

    class z implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f50526a;

        public void run() {
            if (this.f50526a != null) {
                SettingsManager.getInstance().setAutoScreenRecordingAudioCapturingState(this.f50526a);
                InstabugSDKLogger.d("IBG-Core", "setAutoScreenRecordingAudioCapturingEnabled: " + this.f50526a.name());
            }
            InstabugSDKLogger.w("IBG-Core", "isASRAudioEnabled object passed to Instabug.setAutoScreenRecordingAudioCapturingEnabled() is null");
        }
    }

    public /* synthetic */ Instabug(c0 c0Var, k kVar) {
        this(c0Var);
    }

    public static void addExperiments(@NonNull List<String> list) {
        APIChecker.checkAndRunInExecutor("Instabug.addExperiments", new e0(list));
    }

    public static void addFileAttachment(@NonNull Uri uri, @NonNull String str) {
        APIChecker.checkAndRunInExecutor("Instabug.addFileAttachment", new g0(uri, str));
    }

    public static void addPrivateViews(@NonNull View... viewArr) {
        APIChecker.checkAndRunInExecutor("Instabug.addPrivateViews", new b0(viewArr));
    }

    public static void addTags(@NonNull String... strArr) {
        APIChecker.checkAndRunInExecutor("Instabug.addTags", new g(strArr));
    }

    public static void clearAllExperiments() {
        APIChecker.checkAndRunInExecutor("Instabug.clearAllExperiments", new h0());
    }

    public static void clearAllUserAttributes() {
        APIChecker.checkAndRunInExecutor("Instabug.clearAllUserAttributes", new p());
    }

    public static void clearFileAttachment() {
        APIChecker.checkAndRunInExecutor("Instabug.clearFileAttachment", new k0());
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static synchronized void disable() {
        synchronized (Instabug.class) {
            APIChecker.checkAndRunInExecutor("Instabug.disable", new b());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static void disableInternal() {
        APIChecker.checkAndRunInExecutor("Instabug.disableInternal", new d0());
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static synchronized void enable() {
        synchronized (Instabug.class) {
            if (!com.instabug.library.internal.utils.memory.a.a()) {
                PoolProvider.getApiExecutor().execute(new a());
            }
        }
    }

    @Nullable
    public static HashMap<String, String> getAllUserAttributes() {
        return (HashMap) APIChecker.checkAndGet("Instabug.getAllUserAttributes", new l(), null);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    @Nullable
    public static String getAppToken() {
        return SettingsManager.getInstance().getAppToken();
    }

    @Nullable
    public static Context getApplicationContext() {
        Context context = appContext;
        if (context != null) {
            return context;
        }
        com.instabug.library.internal.contentprovider.a b11 = com.instabug.library.internal.contentprovider.a.b();
        if (b11 != null) {
            return b11.a();
        }
        return null;
    }

    public static Date getFirstRunAt() {
        return SettingsManager.getInstance().getFirstRunAt();
    }

    /* access modifiers changed from: private */
    @Nullable
    public static Instabug getInstance() {
        com.instabug.library.internal.contentprovider.a b11 = com.instabug.library.internal.contentprovider.a.b();
        if (INSTANCE == null && b11 != null) {
            INSTANCE = new Instabug(c0.a(b11.a()));
        }
        return INSTANCE;
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static Locale getLocale(@Nullable Context context) {
        return (Locale) APIChecker.checkAndGet("Instabug.getLocale", new f(context), Locale.getDefault());
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public static int getPrimaryColor() {
        return ((Integer) APIChecker.checkAndGet("Instabug.getPrimaryColor", new qc.b(), 0)).intValue();
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    @Nullable
    public static ArrayList<String> getTags() {
        return (ArrayList) APIChecker.checkAndGet("Instabug.getTags", new h(), null);
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    @Nullable
    public static InstabugColorTheme getTheme() {
        return (InstabugColorTheme) APIChecker.checkAndGet("Instabug.getTheme", new v(), InstabugColorTheme.InstabugColorThemeLight);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    @Nullable
    public static String getUserAttribute(@NonNull String str) {
        return (String) APIChecker.checkAndGet("Instabug.getUserAttribute", new n(str), null);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static String getUserData() {
        return (String) APIChecker.checkAndGet("Instabug.getUserData", new l0(), "");
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static String getUserEmail() {
        return (String) APIChecker.checkAndGet("Instabug.getUserEmail", new n0(), "");
    }

    public static void getUserUUID(@NonNull OnUserUUIDReadyCallback onUserUUIDReadyCallback) {
        try {
            APIChecker.checkAndRunOrThrow("Instabug.getUserUUID", new qc.d(onUserUUIDReadyCallback));
        } catch (Exception unused) {
            PoolProvider.postMainThreadTaskWithoutCheck(new qc.e(onUserUUIDReadyCallback));
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static void identifyUser(@Nullable String str, @NonNull String str2) {
        APIChecker.checkAndRunInExecutor("Instabug.identifyUser", new qc.i(str, str2));
    }

    public static boolean isAppOnForeground() {
        return SettingsManager.getInstance().isAppOnForeground();
    }

    public static boolean isBuilding() {
        return InstabugStateProvider.getInstance().getState() == InstabugState.BUILDING;
    }

    public static boolean isBuilt() {
        if (INSTANCE == null || InstabugStateProvider.getInstance().getState() == InstabugState.NOT_BUILT || InstabugStateProvider.getInstance().getState() == InstabugState.BUILDING) {
            return false;
        }
        return true;
    }

    public static boolean isEnabled() {
        if (!isBuilt()) {
            return false;
        }
        e0 c11 = e0.c();
        Feature feature = Feature.INSTABUG;
        if (!c11.c((Object) feature) || e0.c().b((Object) feature) != Feature.State.ENABLED) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$identifyUser$6(String str, String str2) throws Exception {
        String str3;
        String str4;
        if (getApplicationContext() != null) {
            com.instabug.library.user.f.a(getApplicationContext(), str, str2);
            if (str == null || str.isEmpty()) {
                str3 = "empty_username";
            } else {
                str3 = "non-empty-username";
            }
            if (str2 == null || str2.isEmpty()) {
                str4 = "empty-email";
            } else {
                str4 = "non-empty-email";
            }
            InstabugSDKLogger.i("IBG-Core", "identifyUser username: " + str3 + " email: " + str4);
            return;
        }
        InstabugSDKLogger.e("IBG-Core", "identifyUser failed to execute due to null app context");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setCustomBrandingImage$8(Bitmap bitmap, Bitmap bitmap2) throws Exception {
        SettingsManager.getInstance().setLightCustomBrandingLogo(bitmap);
        SettingsManager.getInstance().setDarkCustomBrandingLogo(bitmap2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setScreenshotProvider$9(Callable callable) throws Exception {
        if (SettingsManager.getInstance().getCurrentPlatform() == 2) {
            InstabugSDKLogger.e("IBG-Core", "IllegalState in Instabug.setScreenshotProvider", new IllegalStateException("setScreenshotProvider should not be called from the native Android SDK"));
        } else {
            ScreenshotProvider.a(callable);
        }
    }

    public static void logUserEvent(@NonNull String str) {
        APIChecker.checkAndRunInExecutor("Instabug.logUserEvent", new x(str));
    }

    public static void logoutUser() {
        APIChecker.checkAndRunInExecutor("Instabug.logoutUser", new o0());
    }

    public static void onReportSubmitHandler(Report.OnReportCreatedListener onReportCreatedListener) {
        APIChecker.checkAndRunInExecutor("Instabug.onReportSubmitHandler", new y(onReportCreatedListener));
    }

    public static void pauseSdk() {
        APIChecker.checkAndRunInExecutor("Instabug.pauseSdk", new c());
    }

    public static void removeExperiments(@NonNull List<String> list) {
        APIChecker.checkAndRunInExecutor("Instabug.removeExperiments", new f0(list));
    }

    public static void removePrivateViews(@NonNull View... viewArr) {
        APIChecker.checkAndRunInExecutor("Instabug.removePrivateViews", new c0(viewArr));
    }

    public static void removeUserAttribute(@NonNull String str) {
        APIChecker.checkAndRunInExecutor("Instabug.removeUserAttribute", new o(str));
    }

    private static void reportScreenChange(@Nullable Bitmap bitmap, @NonNull String str) {
        if (isBuilt() && getInstance() != null && getInstance().delegate != null) {
            getInstance().delegate.a(bitmap, str);
        }
    }

    public static void resetTags() {
        APIChecker.checkAndRunInExecutor("Instabug.resetTags", new i());
    }

    public static void resumeSdk() {
        APIChecker.checkAndRunInExecutor("Instabug.resumeSdk", new d());
    }

    public static void setColorTheme(@NonNull InstabugColorTheme instabugColorTheme) {
        APIChecker.checkAndRunInExecutor("Instabug.setColorTheme", new w(instabugColorTheme));
    }

    private static void setCurrentPlatform(@Platform int i11) {
        SettingsManager.getInstance().setCurrentPlatform(i11);
    }

    public static void setCustomBrandingImage(@DrawableRes int i11, @DrawableRes int i12) {
        APIChecker.checkAndRunInExecutor("Instabug.setCustomBrandingImage", new qc.j(i11, i12));
    }

    public static void setCustomTextPlaceHolders(@NonNull InstabugCustomTextPlaceHolder instabugCustomTextPlaceHolder) {
        APIChecker.checkAndRunInExecutor("Instabug.setCustomTextPlaceHolders", new j(instabugCustomTextPlaceHolder));
    }

    @Deprecated
    public static void setDebugEnabled(boolean z11) {
    }

    public static void setLocale(@NonNull Locale locale) {
        APIChecker.checkAndRunInExecutor("Instabug.setLocale", new e(locale));
    }

    public static void setPrimaryColor(@ColorInt int i11) {
        APIChecker.checkAndRunInExecutor("Instabug.setPrimaryColor", new k(i11));
    }

    public static void setReproStepsState(State state) {
        APIChecker.checkAndRunInExecutor("Instabug.setReproStepsState", new u(state));
    }

    public static void setScreenshotProvider(@NonNull Callable<Bitmap> callable) {
        APIChecker.checkAndRunInExecutor("Instabug.setScreenshotProvider", new qc.c(callable));
    }

    public static void setSdkDebugLogsLevel(int i11) {
        APIChecker.checkAndRunInExecutor("setSdkDebugLogsLevel", new qc.g(i11));
    }

    public static void setSessionProfilerState(@NonNull Feature.State state) {
        APIChecker.checkAndRunInExecutor("Instabug.setSessionProfilerState", new s(state));
    }

    public static void setTrackingUserStepsState(@NonNull Feature.State state) {
        APIChecker.checkAndRunInExecutor("Instabug.setTrackingUserStepsState", new t(state));
    }

    public static void setUserAttribute(@NonNull String str, @NonNull String str2) {
        APIChecker.checkAndRunInExecutor("Instabug.setUserAttribute", new m(str, str2));
    }

    public static void setUserData(@NonNull String str) {
        APIChecker.checkAndRunInExecutor("Instabug.setUserData", new m0(str));
    }

    @RequiresApi(18)
    public static void setVideoEncoderConfig(@NonNull VideoEncoderConfig videoEncoderConfig) {
        SettingsManager.setVideoEncoderConfig(videoEncoderConfig);
    }

    public static void setWelcomeMessageState(@NonNull WelcomeMessage.State state) {
        APIChecker.checkAndRunInExecutor("Instabug.setWelcomeMessageState", new q(state));
    }

    public static void show() {
        APIChecker.checkAndRunInExecutor("Instabug.show", new a0());
    }

    public static void showWelcomeMessage(@NonNull WelcomeMessage.State state) {
        APIChecker.checkAndRunInExecutor("Instabug.showWelcomeMessage", new r(state));
    }

    private Instabug(@NonNull c0 c0Var) {
        this.delegate = c0Var;
    }

    public static void addFileAttachment(@NonNull byte[] bArr, @NonNull String str) {
        APIChecker.checkAndRunInExecutor("Instabug.addFileAttachment", new j0(bArr, str));
    }

    /* access modifiers changed from: private */
    public static void setCustomBrandingImage(Bitmap bitmap, Bitmap bitmap2) {
        APIChecker.checkAndRunInExecutor("Instabug.setCustomBrandingImage", new qc.h(bitmap, bitmap2));
    }
}
