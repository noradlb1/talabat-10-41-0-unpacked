package com.instabug.library.internal.video;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugState;
import com.instabug.library.R;
import com.instabug.library.core.eventbus.AutoScreenRecordingEventBus;
import com.instabug.library.core.eventbus.InstabugStateEventBus;
import com.instabug.library.core.eventbus.ScreenRecordingEventBus;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.internal.video.customencoding.q;
import com.instabug.library.internal.video.h;
import com.instabug.library.model.session.SessionState;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.n;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ScreenRecordingService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private Disposable f51128a;

    /* renamed from: b  reason: collision with root package name */
    private Disposable f51129b;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public h f51130c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f51131d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final h.a f51132e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final q.a f51133f = new b();
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Disposable f51134g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Disposable f51135h;

    public enum Action {
        STOP_DELETE,
        STOP_KEEP,
        STOP_TRIM_KEEP
    }

    public class a implements h.a {
        public a() {
        }

        public void a() {
        }

        public void b() {
            ScreenRecordingService.this.stopForeground(true);
            ScreenRecordingService.this.stopSelf();
        }

        public void c() {
            if (ScreenRecordingService.this.f51131d) {
                InternalScreenRecordHelper.getInstance().c();
            }
        }

        public void onStart() {
        }
    }

    public class b implements q.a {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                InternalScreenRecordHelper.getInstance().release();
                Toast.makeText(ScreenRecordingService.this, R.string.instabug_str_recording_video_error, 0).show();
            }
        }

        public b() {
        }

        public void a(long j11) {
        }

        public void a(Throwable th2) {
            InstabugSDKLogger.e("ScreenRecordingService", "Error while starting screen recorder", th2);
            if (ScreenRecordingService.this.f51130c != null) {
                ScreenRecordingService.this.f51130c.g();
            }
            if (ScreenRecordingService.this.f51131d) {
                InternalScreenRecordHelper.getInstance().d();
                PoolProvider.postMainThreadTask(new a());
            }
            ScreenRecordingService.this.f51132e.b();
            ScreenRecordingService.this.stopForeground(true);
            ScreenRecordingService.this.stopSelf();
        }

        public void onStart() {
        }
    }

    public class c implements Consumer {
        public c() {
        }

        /* renamed from: a */
        public void accept(SessionState sessionState) {
            if (Instabug.getApplicationContext() != null && sessionState == SessionState.FINISH && i.a(ScreenRecordingService.this.getApplicationContext(), ScreenRecordingService.class)) {
                ScreenRecordingService.this.a();
            }
        }
    }

    public class d implements Consumer {
        public d(ScreenRecordingService screenRecordingService) {
        }

        /* renamed from: a */
        public void accept(InstabugState instabugState) {
            Action action;
            if (instabugState == InstabugState.DISABLED) {
                action = Action.STOP_DELETE;
            } else if (instabugState == InstabugState.INVOKED) {
                action = Action.STOP_TRIM_KEEP;
            } else {
                action = null;
            }
            if (action != null) {
                AutoScreenRecordingEventBus.getInstance().post(action);
            }
        }
    }

    public class e implements Consumer {
        public e() {
        }

        /* renamed from: a */
        public void accept(ScreenRecordingEvent screenRecordingEvent) {
            if (screenRecordingEvent.getStatus() == 3) {
                ScreenRecordingService.this.a();
            } else if (SettingsManager.getInstance().isScreenCurrentlyRecorded() || screenRecordingEvent.getStatus() == 1) {
                SettingsManager.getInstance().setScreenCurrentlyRecorded(false);
                if (ScreenRecordingService.this.f51130c != null) {
                    ScreenRecordingService.this.f51130c.d(new c(this, screenRecordingEvent));
                }
            }
        }
    }

    public class f implements Consumer {
        public f() {
        }

        /* renamed from: a */
        public void accept(Action action) {
            PoolProvider.postComputationTask(new e(this, action));
        }
    }

    public class g implements q.a {
        public g() {
        }

        public void a(long j11) {
        }

        public void a(Throwable th2) {
            if (ScreenRecordingService.this.f51130c != null) {
                ScreenRecordingService.this.f51130c.g();
            }
            ScreenRecordingService.this.stopForeground(true);
            ScreenRecordingService.this.stopSelf();
        }

        public void onStart() {
        }
    }

    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51143a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.instabug.library.internal.video.ScreenRecordingService$Action[] r0 = com.instabug.library.internal.video.ScreenRecordingService.Action.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51143a = r0
                com.instabug.library.internal.video.ScreenRecordingService$Action r1 = com.instabug.library.internal.video.ScreenRecordingService.Action.STOP_DELETE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f51143a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.instabug.library.internal.video.ScreenRecordingService$Action r1 = com.instabug.library.internal.video.ScreenRecordingService.Action.STOP_KEEP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f51143a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.instabug.library.internal.video.ScreenRecordingService$Action r1 = com.instabug.library.internal.video.ScreenRecordingService.Action.STOP_TRIM_KEEP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.video.ScreenRecordingService.h.<clinit>():void");
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static Intent a(Context context, int i11, @Nullable Intent intent, boolean z11) {
        Intent intent2 = new Intent(context, ScreenRecordingService.class);
        intent2.putExtra("result-code", i11);
        intent2.putExtra("is.manual.screen.recording", z11);
        intent2.putExtra("data", intent);
        return intent2;
    }

    private void f() {
        Disposable disposable = this.f51128a;
        if (disposable == null || disposable.isDisposed()) {
            this.f51128a = SessionStateEventBus.getInstance().subscribe(new c());
        }
    }

    private void g() {
        Disposable disposable = this.f51129b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f51129b.dispose();
        }
    }

    private void h() {
        if (!this.f51128a.isDisposed()) {
            this.f51128a.dispose();
        }
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate() {
        super.onCreate();
        f();
        e();
        if (Build.VERSION.SDK_INT >= 29) {
            n.a((Service) this, R.string.ibg_screen_recording_notification_title, 8743);
        }
    }

    public void onDestroy() {
        if (SettingsManager.getInstance().isScreenCurrentlyRecorded()) {
            SettingsManager.getInstance().setScreenCurrentlyRecorded(false);
        }
        super.onDestroy();
        Disposable disposable = this.f51134g;
        if (disposable != null && !disposable.isDisposed()) {
            this.f51134g.dispose();
        }
        Disposable disposable2 = this.f51135h;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.f51135h.dispose();
        }
        h();
        g();
        n.a(this, 8743);
    }

    @SuppressLint({"STRICT_MODE_VIOLATION"})
    public int onStartCommand(Intent intent, int i11, int i12) {
        if (intent == null) {
            stopForeground(true);
            stopSelf();
        } else {
            int intExtra = intent.getIntExtra("result-code", 0);
            Intent intent2 = (Intent) intent.getParcelableExtra("data");
            if (intExtra == 0 || intent2 == null) {
                InstabugSDKLogger.w("ScreenRecordingService", "Can't start service. Result code: " + intExtra + ", Data: " + intent2);
                Toast.makeText(this, R.string.feature_requests_error_state_title, 0).show();
                ScreenRecordingEventBus.getInstance().post(new ScreenRecordingEvent(4, (Uri) null));
                stopForeground(true);
                stopSelf();
            }
            this.f51131d = intent.getBooleanExtra("is.manual.screen.recording", true);
            c();
            if (SettingsManager.getInstance().isScreenCurrentlyRecorded()) {
                stopForeground(true);
                stopSelf();
            } else if (intent2 != null) {
                this.f51130c = new h(Instabug.getApplicationContext(), this.f51132e, this.f51133f, intExtra, intent2);
                SettingsManager.getInstance().setScreenCurrentlyRecorded(true);
            }
        }
        return super.onStartCommand(intent, i11, i12);
    }

    public void onTrimMemory(int i11) {
        super.onTrimMemory(i11);
        if (i11 == 20 && this.f51131d) {
            a();
        }
    }

    private void b() {
        Disposable disposable = this.f51135h;
        if (disposable == null || disposable.isDisposed()) {
            this.f51135h = AutoScreenRecordingEventBus.getInstance().subscribe(new f());
        }
    }

    private void c() {
        if (this.f51131d) {
            d();
        } else {
            b();
        }
    }

    private void d() {
        Disposable disposable = this.f51134g;
        if (disposable == null || disposable.isDisposed()) {
            this.f51134g = ScreenRecordingEventBus.getInstance().subscribe(new e());
        }
    }

    private void e() {
        this.f51129b = InstabugStateEventBus.getInstance().subscribe(new d(this));
    }

    /* access modifiers changed from: private */
    public void a() {
        if (SettingsManager.getInstance().isScreenCurrentlyRecorded()) {
            SettingsManager.getInstance().setScreenCurrentlyRecorded(false);
            InternalScreenRecordHelper.getInstance().cancel();
            h hVar = this.f51130c;
            if (hVar != null) {
                hVar.d(new g());
            }
        }
    }
}
