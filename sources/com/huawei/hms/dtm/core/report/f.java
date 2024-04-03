package com.huawei.hms.dtm.core.report;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.dtm.core.C0437t;
import com.huawei.hms.dtm.core.C0442u;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadPoolExecutor f48562a = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(8), new C0442u("DTM-Report"), new C0437t());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f48563b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f48564c = true;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Handler f48565d = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f48566e = new a(this, (c) null);

    /* renamed from: f  reason: collision with root package name */
    private final i f48567f = new i(this);

    /* renamed from: g  reason: collision with root package name */
    private NetworkReceiver f48568g;

    public class a implements Runnable {
        private a() {
        }

        public /* synthetic */ a(f fVar, c cVar) {
            this();
        }

        public void run() {
            f.this.b();
        }
    }

    public void a() {
        f48562a.execute(new e(this));
    }

    public void a(Context context) {
        NetworkReceiver networkReceiver;
        if (context != null && (networkReceiver = this.f48568g) != null) {
            context.unregisterReceiver(networkReceiver);
            this.f48568g = null;
        }
    }

    public void a(boolean z11) {
        f48562a.execute(new d(this, z11));
    }

    public void b() {
        f48562a.execute(this.f48567f);
    }

    public void b(Context context) {
        if (context != null && this.f48568g == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            NetworkReceiver networkReceiver = new NetworkReceiver(this);
            this.f48568g = networkReceiver;
            context.registerReceiver(networkReceiver, intentFilter);
        }
    }

    public void b(boolean z11) {
        f48562a.execute(new c(this, z11));
    }
}
