package com.instabug.bug;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.instabug.bug.invocation.Option;
import com.instabug.chat.ChatsDelegate;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.OnSdkDismissCallback;
import com.instabug.library.OnUsageExceededReady;
import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.extendedbugreport.ExtendedBugReport;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.invocation.OnInvokeCallback;
import com.instabug.library.invocation.util.InstabugFloatingButtonEdge;
import com.instabug.library.invocation.util.InstabugVideoRecordingButtonPosition;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BugReporting {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface ReportType {
        public static final int BUG = 0;
        public static final int FEEDBACK = 1;
        public static final int QUESTION = 2;
    }

    public class a implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45595a;

        public a(boolean z11) {
            this.f45595a = z11;
        }

        public void run() {
            if (com.instabug.bug.settings.b.f().n()) {
                InstabugSDKLogger.d("IBG-BR", "setAutoScreenRecordingEnabled: " + this.f45595a);
                h.a(this.f45595a);
            }
        }
    }

    public class b implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int[] f45596a;

        public b(int[] iArr) {
            this.f45596a = iArr;
        }

        public void run() {
            PoolProvider.postIOTaskWithCheck(new c(this));
        }
    }

    public class c implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45597a;

        public c(int i11) {
            this.f45597a = i11;
        }

        public void run() {
            h.a(this.f45597a);
        }
    }

    public class d implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45598a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int[] f45599b;

        public d(int i11, int[] iArr) {
            this.f45598a = i11;
            this.f45599b = iArr;
        }

        public void run() {
            h.b(this.f45598a, this.f45599b);
        }
    }

    public class e implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f45600a;

        public e(Feature.State state) {
            this.f45600a = state;
        }

        public void run() {
            PoolProvider.postIOTaskWithCheck(new d(this));
        }
    }

    public class f implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f45601a;

        public f(Feature.State state) {
            this.f45601a = state;
        }

        public void run() {
            InstabugSDKLogger.d("IBG-BR", "setViewHierarchyState: " + this.f45601a);
            InstabugCore.setFeatureState(Feature.VIEW_HIERARCHY_V2, this.f45601a);
        }
    }

    public class g implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45602a;

        public g(String str) {
            this.f45602a = str;
        }

        public void run() {
            InstabugSDKLogger.d("IBG-BR", "setDisclaimerText: " + this.f45602a);
            h.b(this.f45602a);
        }
    }

    public class h implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45603a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f45604b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f45605c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f45606d;

        public h(boolean z11, boolean z12, boolean z13, boolean z14) {
            this.f45603a = z11;
            this.f45604b = z12;
            this.f45605c = z13;
            this.f45606d = z14;
        }

        public void run() {
            InstabugCore.setInitialScreenShotAllowed(this.f45603a);
            h.a(this.f45603a, this.f45604b, this.f45605c, this.f45606d);
        }
    }

    public class i implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45607a;

        public i(boolean z11) {
            this.f45607a = z11;
        }

        public void run() {
            InstabugSDKLogger.d("IBG-BR", "setScreenshotByMediaProjectionEnabled: " + this.f45607a);
            SettingsManager.getInstance().setScreenshotByMediaProjectionEnabled(this.f45607a);
        }
    }

    class j implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45608a;

        public void run() {
            InstabugSDKLogger.d("IBG-BR", "setScreenshotRequired: " + this.f45608a);
            com.instabug.bug.settings.b.f().f(this.f45608a);
        }
    }

    public class k implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InstabugInvocationEvent[] f45609a;

        public k(InstabugInvocationEvent[] instabugInvocationEventArr) {
            this.f45609a = instabugInvocationEventArr;
        }

        public void run() {
            if (com.instabug.bug.settings.b.f().n()) {
                if (Instabug.isBuilding()) {
                    SDKCoreEventSubscriber.subscribe(new a(this));
                } else {
                    InvocationManager.getInstance().setInstabugInvocationEvent(this.f45609a);
                }
            }
        }
    }

    public static /* synthetic */ class l {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45610a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.instabug.library.extendedbugreport.ExtendedBugReport$State[] r0 = com.instabug.library.extendedbugreport.ExtendedBugReport.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f45610a = r0
                com.instabug.library.extendedbugreport.ExtendedBugReport$State r1 = com.instabug.library.extendedbugreport.ExtendedBugReport.State.ENABLED_WITH_REQUIRED_FIELDS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f45610a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.instabug.library.extendedbugreport.ExtendedBugReport$State r1 = com.instabug.library.extendedbugreport.ExtendedBugReport.State.ENABLED_WITH_OPTIONAL_FIELDS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.BugReporting.l.<clinit>():void");
        }
    }

    public class m implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int[] f45611a;

        public m(int[] iArr) {
            this.f45611a = iArr;
        }

        public void run() {
            h.a(this.f45611a);
        }
    }

    public class n implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnInvokeCallback f45612a;

        public n(OnInvokeCallback onInvokeCallback) {
            this.f45612a = onInvokeCallback;
        }

        public void run() {
            InstabugSDKLogger.d("IBG-BR", "Setting invoke callback");
            SettingsManager.getInstance().setOnInvokeCallback(this.f45612a);
        }
    }

    public class o implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnSdkDismissCallback f45613a;

        public o(OnSdkDismissCallback onSdkDismissCallback) {
            this.f45613a = onSdkDismissCallback;
        }

        public void run() {
            InstabugSDKLogger.d("IBG-BR", "Setting OnSdkDismissCallback");
            ChatsDelegate.setOnSdkDismissCallback(this.f45613a);
            com.instabug.bug.settings.b.f().a(this.f45613a);
            SettingsManager.getInstance().setOnSdkDismissCallback(this.f45613a);
        }
    }

    public class p implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45614a;

        public p(int i11) {
            this.f45614a = i11;
        }

        public void run() {
            InstabugSDKLogger.d("IBG-BR", "Setting ShakingThreshold to: " + this.f45614a);
            if (Instabug.isBuilding()) {
                SDKCoreEventSubscriber.subscribe(new e(this));
            } else {
                InvocationManager.getInstance().getCurrentInvocationSettings().setShakingThreshold(this.f45614a);
            }
        }
    }

    public class q implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InstabugFloatingButtonEdge f45615a;

        public q(InstabugFloatingButtonEdge instabugFloatingButtonEdge) {
            this.f45615a = instabugFloatingButtonEdge;
        }

        public void run() {
            if (com.instabug.bug.settings.b.f().n()) {
                InstabugSDKLogger.d("IBG-BR", "Setting FloatingButtonEdge to: " + this.f45615a);
                if (Instabug.isBuilding()) {
                    SDKCoreEventSubscriber.subscribe(new f(this));
                } else {
                    InvocationManager.getInstance().getCurrentInvocationSettings().setFloatingButtonEdge(this.f45615a);
                }
            }
        }
    }

    public class r implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45616a;

        public r(int i11) {
            this.f45616a = i11;
        }

        public void run() {
            if (com.instabug.bug.settings.b.f().n()) {
                InstabugSDKLogger.d("IBG-BR", "Seetting FloatingButtonOffset: " + this.f45616a);
                if (Instabug.isBuilding()) {
                    SDKCoreEventSubscriber.subscribe(new g(this));
                } else {
                    InvocationManager.getInstance().getCurrentInvocationSettings().setFloatingButtonOffsetFromTop(this.f45616a);
                }
            }
        }
    }

    public class s implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InstabugVideoRecordingButtonPosition f45617a;

        public s(InstabugVideoRecordingButtonPosition instabugVideoRecordingButtonPosition) {
            this.f45617a = instabugVideoRecordingButtonPosition;
        }

        public void run() {
            if (com.instabug.bug.settings.b.f().n()) {
                InstabugSDKLogger.d("IBG-BR", "setVideoRecordingFloatingButtonPosition: " + this.f45617a);
                InvocationManager.getInstance().getCurrentInvocationSettings().setVideoRecordingButtonPosition(this.f45617a);
            }
        }
    }

    public class t implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ExtendedBugReport.State f45618a;

        public t(ExtendedBugReport.State state) {
            this.f45618a = state;
        }

        public void run() {
            if (this.f45618a == null) {
                InstabugSDKLogger.w("IBG-BR", "state object passed to BugReporting.setExtendedBugReportState() is null");
            } else if (com.instabug.bug.settings.b.f().n()) {
                InstabugSDKLogger.d("IBG-BR", "setExtendedBugReportState: " + this.f45618a);
                int i11 = l.f45610a[this.f45618a.ordinal()];
                com.instabug.bug.settings.b.f().a(i11 != 1 ? i11 != 2 ? com.instabug.bug.extendedbugreport.a.DISABLED : com.instabug.bug.extendedbugreport.a.ENABLED_WITH_OPTIONAL_FIELDS : com.instabug.bug.extendedbugreport.a.ENABLED_WITH_REQUIRED_FIELDS);
            }
        }
    }

    public static void getUsageExceeded(@NonNull OnUsageExceededReady onUsageExceededReady) {
        try {
            APIChecker.checkAndRunOrThrow("BugReporting.getUsageExceeded", new xb.b(onUsageExceededReady));
        } catch (Exception unused) {
            if (onUsageExceededReady != null) {
                onUsageExceededReady.onReady(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getUsageExceeded$1(OnUsageExceededReady onUsageExceededReady, boolean z11) {
        if (onUsageExceededReady != null) {
            onUsageExceededReady.onReady(z11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setCommentMinimumCharacterCount$0(int i11, int[] iArr) {
        if (i11 < 2) {
            InstabugSDKLogger.e("IBG-BR", "Description minimum limit can’t be less than 2");
            return;
        }
        if (iArr.length <= 0) {
            iArr = new int[]{0, 1, 2};
        }
        h.a(i11, iArr);
    }

    public static void setAttachmentTypesEnabled(boolean z11, boolean z12, boolean z13, boolean z14) {
        APIChecker.checkAndRunInExecutor("BugReporting.setAttachmentTypesEnabled", new h(z11, z12, z13, z14));
    }

    @RequiresApi(21)
    public static void setAutoScreenRecordingEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("BugReporting.setAutoScreenRecordingEnabled", new a(z11));
    }

    public static void setCommentMinimumCharacterCount(int i11, @ReportType int... iArr) {
        APIChecker.checkAndRunInExecutor("BugReporting.setCommentMinimumCharacterCount", new xb.c(i11, iArr));
    }

    public static void setDisclaimerText(String str) {
        APIChecker.checkAndRun("BugReporting.setDisclaimerText", new g(str));
    }

    public static void setExtendedBugReportState(@NonNull ExtendedBugReport.State state) {
        APIChecker.checkAndRunInExecutor("BugReporting.setExtendedBugReportState", new t(state));
    }

    public static void setFloatingButtonEdge(@NonNull InstabugFloatingButtonEdge instabugFloatingButtonEdge) {
        APIChecker.checkAndRunInExecutor("BugReporting.setFloatingButtonEdge", new q(instabugFloatingButtonEdge));
    }

    public static void setFloatingButtonOffset(@IntRange(from = 0) int i11) {
        APIChecker.checkAndRunInExecutor("BugReporting.setFloatingButtonOffset", new r(i11));
    }

    public static void setInvocationEvents(InstabugInvocationEvent... instabugInvocationEventArr) {
        APIChecker.checkAndRunInExecutor("BugReporting.setInvocationEvents", new k(instabugInvocationEventArr));
    }

    public static void setOnDismissCallback(OnSdkDismissCallback onSdkDismissCallback) {
        APIChecker.checkAndRunInExecutorThenPostOnMain("BugReporting.setOnDismissCallback", new o(onSdkDismissCallback));
    }

    public static void setOnInvokeCallback(OnInvokeCallback onInvokeCallback) {
        APIChecker.checkAndRunInExecutorThenPostOnMain("BugReporting.setOnInvokeCallback", new n(onInvokeCallback));
    }

    public static void setOptions(@NonNull @Option int... iArr) {
        APIChecker.checkAndRunInExecutor("BugReporting.NonNull", new m(iArr));
    }

    public static void setReportTypes(@ReportType int... iArr) {
        APIChecker.checkAndRunInExecutor("BugReporting.setReportTypes", new b(iArr));
    }

    @RequiresApi(21)
    public static void setScreenshotByMediaProjectionEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("BugReporting.setScreenshotByMediaProjectionEnabled", new i(z11));
    }

    public static void setShakingThreshold(int i11) {
        APIChecker.checkAndRunInExecutor("BugReporting.setShakingThreshold", new p(i11));
    }

    public static void setState(@NonNull Feature.State state) {
        APIChecker.checkAndRunInExecutor("BugReporting.setState", new e(state));
    }

    public static void setVideoRecordingFloatingButtonPosition(@NonNull InstabugVideoRecordingButtonPosition instabugVideoRecordingButtonPosition) {
        APIChecker.checkAndRunInExecutor("BugReporting.setVideoRecordingFloatingButtonPosition", new s(instabugVideoRecordingButtonPosition));
    }

    public static void setViewHierarchyState(@NonNull Feature.State state) {
        APIChecker.checkAndRunInExecutor("BugReporting.setViewHierarchyState", new f(state));
    }

    public static void show(@ReportType int i11) {
        APIChecker.checkAndRunInExecutor("BugReporting.show", new c(i11));
    }

    public static void show(@ReportType int i11, @Option int... iArr) {
        APIChecker.checkAndRunInExecutor("BugReporting.show", new d(i11, iArr));
    }
}
