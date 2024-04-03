package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.squareup.picasso.NetworkRequestHandler;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

class Dispatcher {
    private static final int AIRPLANE_MODE_OFF = 0;
    private static final int AIRPLANE_MODE_ON = 1;
    private static final int BATCH_DELAY = 200;
    private static final String DISPATCHER_THREAD_NAME = "Dispatcher";
    private static final int RETRY_DELAY = 500;

    /* renamed from: a  reason: collision with root package name */
    public final DispatcherThread f53398a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f53399b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f53400c;

    /* renamed from: d  reason: collision with root package name */
    public final Downloader f53401d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, BitmapHunter> f53402e = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    public final Map<Object, Action> f53403f = new WeakHashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Map<Object, Action> f53404g = new WeakHashMap();

    /* renamed from: h  reason: collision with root package name */
    public final Set<Object> f53405h = new LinkedHashSet();

    /* renamed from: i  reason: collision with root package name */
    public final Handler f53406i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f53407j;

    /* renamed from: k  reason: collision with root package name */
    public final Cache f53408k;

    /* renamed from: l  reason: collision with root package name */
    public final Stats f53409l;

    /* renamed from: m  reason: collision with root package name */
    public final List<BitmapHunter> f53410m;

    /* renamed from: n  reason: collision with root package name */
    public final NetworkBroadcastReceiver f53411n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f53412o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f53413p;

    public static class DispatcherHandler extends Handler {
        private final Dispatcher dispatcher;

        public DispatcherHandler(Looper looper, Dispatcher dispatcher2) {
            super(looper);
            this.dispatcher = dispatcher2;
        }

        public void handleMessage(final Message message) {
            boolean z11 = false;
            switch (message.what) {
                case 1:
                    this.dispatcher.s((Action) message.obj);
                    return;
                case 2:
                    this.dispatcher.l((Action) message.obj);
                    return;
                case 4:
                    this.dispatcher.m((BitmapHunter) message.obj);
                    return;
                case 5:
                    this.dispatcher.r((BitmapHunter) message.obj);
                    return;
                case 6:
                    this.dispatcher.n((BitmapHunter) message.obj, false);
                    return;
                case 7:
                    this.dispatcher.k();
                    return;
                case 9:
                    this.dispatcher.o((NetworkInfo) message.obj);
                    return;
                case 10:
                    Dispatcher dispatcher2 = this.dispatcher;
                    if (message.arg1 == 1) {
                        z11 = true;
                    }
                    dispatcher2.j(z11);
                    return;
                case 11:
                    this.dispatcher.p(message.obj);
                    return;
                case 12:
                    this.dispatcher.q(message.obj);
                    return;
                default:
                    Picasso.f53431l.post(new Runnable() {
                        public void run() {
                            throw new AssertionError("Unknown handler message received: " + message.what);
                        }
                    });
                    return;
            }
        }
    }

    public static class DispatcherThread extends HandlerThread {
        public DispatcherThread() {
            super("Picasso-Dispatcher", 10);
        }
    }

    public static class NetworkBroadcastReceiver extends BroadcastReceiver {
        private final Dispatcher dispatcher;

        public NetworkBroadcastReceiver(Dispatcher dispatcher2) {
            this.dispatcher = dispatcher2;
        }

        public void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.dispatcher.f53412o) {
                intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            }
            this.dispatcher.f53399b.registerReceiver(this, intentFilter);
        }

        public void b() {
            this.dispatcher.f53399b.unregisterReceiver(this);
        }

        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        this.dispatcher.a(intent.getBooleanExtra("state", false));
                    }
                } else if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(action)) {
                    this.dispatcher.e(((ConnectivityManager) Utils.o(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    public Dispatcher(Context context, ExecutorService executorService, Handler handler, Downloader downloader, Cache cache, Stats stats) {
        DispatcherThread dispatcherThread = new DispatcherThread();
        this.f53398a = dispatcherThread;
        dispatcherThread.start();
        Utils.i(dispatcherThread.getLooper());
        this.f53399b = context;
        this.f53400c = executorService;
        this.f53406i = new DispatcherHandler(dispatcherThread.getLooper(), this);
        this.f53401d = downloader;
        this.f53407j = handler;
        this.f53408k = cache;
        this.f53409l = stats;
        this.f53410m = new ArrayList(4);
        this.f53413p = Utils.q(context);
        this.f53412o = Utils.p(context, "android.permission.ACCESS_NETWORK_STATE");
        NetworkBroadcastReceiver networkBroadcastReceiver = new NetworkBroadcastReceiver(this);
        this.f53411n = networkBroadcastReceiver;
        networkBroadcastReceiver.a();
    }

    private void batch(BitmapHunter bitmapHunter) {
        if (!bitmapHunter.t()) {
            Bitmap bitmap = bitmapHunter.f53383n;
            if (bitmap != null) {
                bitmap.prepareToDraw();
            }
            this.f53410m.add(bitmapHunter);
            if (!this.f53406i.hasMessages(7)) {
                this.f53406i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    private void flushFailedActions() {
        if (!this.f53403f.isEmpty()) {
            Iterator<Action> it = this.f53403f.values().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                it.remove();
                if (next.e().f53442j) {
                    Utils.t(DISPATCHER_THREAD_NAME, "replaying", next.g().c());
                }
                t(next, false);
            }
        }
    }

    private void logBatch(List<BitmapHunter> list) {
        if (list != null && !list.isEmpty() && list.get(0).p().f53442j) {
            StringBuilder sb2 = new StringBuilder();
            for (BitmapHunter next : list) {
                if (sb2.length() > 0) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(Utils.k(next));
            }
            Utils.t(DISPATCHER_THREAD_NAME, "delivered", sb2.toString());
        }
    }

    private void markForReplay(BitmapHunter bitmapHunter) {
        Action g11 = bitmapHunter.g();
        if (g11 != null) {
            markForReplay(g11);
        }
        List<Action> h11 = bitmapHunter.h();
        if (h11 != null) {
            int size = h11.size();
            for (int i11 = 0; i11 < size; i11++) {
                markForReplay(h11.get(i11));
            }
        }
    }

    public void a(boolean z11) {
        Handler handler = this.f53406i;
        handler.sendMessage(handler.obtainMessage(10, z11 ? 1 : 0, 0));
    }

    public void b(Action action) {
        Handler handler = this.f53406i;
        handler.sendMessage(handler.obtainMessage(2, action));
    }

    public void c(BitmapHunter bitmapHunter) {
        Handler handler = this.f53406i;
        handler.sendMessage(handler.obtainMessage(4, bitmapHunter));
    }

    public void d(BitmapHunter bitmapHunter) {
        Handler handler = this.f53406i;
        handler.sendMessage(handler.obtainMessage(6, bitmapHunter));
    }

    public void e(NetworkInfo networkInfo) {
        Handler handler = this.f53406i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    public void f(Object obj) {
        Handler handler = this.f53406i;
        handler.sendMessage(handler.obtainMessage(11, obj));
    }

    public void g(Object obj) {
        Handler handler = this.f53406i;
        handler.sendMessage(handler.obtainMessage(12, obj));
    }

    public void h(BitmapHunter bitmapHunter) {
        Handler handler = this.f53406i;
        handler.sendMessageDelayed(handler.obtainMessage(5, bitmapHunter), 500);
    }

    public void i(Action action) {
        Handler handler = this.f53406i;
        handler.sendMessage(handler.obtainMessage(1, action));
    }

    public void j(boolean z11) {
        this.f53413p = z11;
    }

    public void k() {
        ArrayList arrayList = new ArrayList(this.f53410m);
        this.f53410m.clear();
        Handler handler = this.f53407j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        logBatch(arrayList);
    }

    public void l(Action action) {
        String b11 = action.b();
        BitmapHunter bitmapHunter = this.f53402e.get(b11);
        if (bitmapHunter != null) {
            bitmapHunter.e(action);
            if (bitmapHunter.c()) {
                this.f53402e.remove(b11);
                if (action.e().f53442j) {
                    Utils.t(DISPATCHER_THREAD_NAME, "canceled", action.g().c());
                }
            }
        }
        if (this.f53405h.contains(action.h())) {
            this.f53404g.remove(action.i());
            if (action.e().f53442j) {
                Utils.u(DISPATCHER_THREAD_NAME, "canceled", action.g().c(), "because paused request got canceled");
            }
        }
        Action remove = this.f53403f.remove(action.i());
        if (remove != null && remove.e().f53442j) {
            Utils.u(DISPATCHER_THREAD_NAME, "canceled", remove.g().c(), "from replaying");
        }
    }

    public void m(BitmapHunter bitmapHunter) {
        if (MemoryPolicy.b(bitmapHunter.o())) {
            this.f53408k.set(bitmapHunter.m(), bitmapHunter.r());
        }
        this.f53402e.remove(bitmapHunter.m());
        batch(bitmapHunter);
        if (bitmapHunter.p().f53442j) {
            Utils.u(DISPATCHER_THREAD_NAME, "batched", Utils.k(bitmapHunter), "for completion");
        }
    }

    public void n(BitmapHunter bitmapHunter, boolean z11) {
        String str;
        if (bitmapHunter.p().f53442j) {
            String k11 = Utils.k(bitmapHunter);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("for error");
            if (z11) {
                str = " (will replay)";
            } else {
                str = "";
            }
            sb2.append(str);
            Utils.u(DISPATCHER_THREAD_NAME, "batched", k11, sb2.toString());
        }
        this.f53402e.remove(bitmapHunter.m());
        batch(bitmapHunter);
    }

    public void o(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f53400c;
        if (executorService instanceof PicassoExecutorService) {
            ((PicassoExecutorService) executorService).a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            flushFailedActions();
        }
    }

    public void p(Object obj) {
        boolean z11;
        if (this.f53405h.add(obj)) {
            Iterator<BitmapHunter> it = this.f53402e.values().iterator();
            while (it.hasNext()) {
                BitmapHunter next = it.next();
                boolean z12 = next.p().f53442j;
                Action g11 = next.g();
                List<Action> h11 = next.h();
                if (h11 == null || h11.isEmpty()) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (g11 != null || z11) {
                    if (g11 != null && g11.h().equals(obj)) {
                        next.e(g11);
                        this.f53404g.put(g11.i(), g11);
                        if (z12) {
                            Utils.u(DISPATCHER_THREAD_NAME, "paused", g11.f53359b.c(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z11) {
                        for (int size = h11.size() - 1; size >= 0; size--) {
                            Action action = h11.get(size);
                            if (action.h().equals(obj)) {
                                next.e(action);
                                this.f53404g.put(action.i(), action);
                                if (z12) {
                                    Utils.u(DISPATCHER_THREAD_NAME, "paused", action.f53359b.c(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.c()) {
                        it.remove();
                        if (z12) {
                            Utils.u(DISPATCHER_THREAD_NAME, "canceled", Utils.k(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    public void q(Object obj) {
        if (this.f53405h.remove(obj)) {
            Iterator<Action> it = this.f53404g.values().iterator();
            ArrayList arrayList = null;
            while (it.hasNext()) {
                Action next = it.next();
                if (next.h().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.f53407j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public void r(BitmapHunter bitmapHunter) {
        NetworkInfo networkInfo;
        if (!bitmapHunter.t()) {
            boolean z11 = false;
            if (this.f53400c.isShutdown()) {
                n(bitmapHunter, false);
                return;
            }
            if (this.f53412o) {
                networkInfo = ((ConnectivityManager) Utils.o(this.f53399b, "connectivity")).getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (bitmapHunter.u(this.f53413p, networkInfo)) {
                if (bitmapHunter.p().f53442j) {
                    Utils.t(DISPATCHER_THREAD_NAME, "retrying", Utils.k(bitmapHunter));
                }
                if (bitmapHunter.j() instanceof NetworkRequestHandler.ContentLengthException) {
                    bitmapHunter.f53379j |= NetworkPolicy.NO_CACHE.f53427b;
                }
                bitmapHunter.f53384o = this.f53400c.submit(bitmapHunter);
                return;
            }
            if (this.f53412o && bitmapHunter.v()) {
                z11 = true;
            }
            n(bitmapHunter, z11);
            if (z11) {
                markForReplay(bitmapHunter);
            }
        }
    }

    public void s(Action action) {
        t(action, true);
    }

    public void t(Action action, boolean z11) {
        if (this.f53405h.contains(action.h())) {
            this.f53404g.put(action.i(), action);
            if (action.e().f53442j) {
                String c11 = action.f53359b.c();
                Utils.u(DISPATCHER_THREAD_NAME, "paused", c11, "because tag '" + action.h() + "' is paused");
                return;
            }
            return;
        }
        BitmapHunter bitmapHunter = this.f53402e.get(action.b());
        if (bitmapHunter != null) {
            bitmapHunter.b(action);
        } else if (!this.f53400c.isShutdown()) {
            BitmapHunter f11 = BitmapHunter.f(action.e(), this, this.f53408k, this.f53409l, action);
            f11.f53384o = this.f53400c.submit(f11);
            this.f53402e.put(action.b(), f11);
            if (z11) {
                this.f53403f.remove(action.i());
            }
            if (action.e().f53442j) {
                Utils.t(DISPATCHER_THREAD_NAME, "enqueued", action.f53359b.c());
            }
        } else if (action.e().f53442j) {
            Utils.u(DISPATCHER_THREAD_NAME, "ignored", action.f53359b.c(), "because shut down");
        }
    }

    public void u() {
        ExecutorService executorService = this.f53400c;
        if (executorService instanceof PicassoExecutorService) {
            executorService.shutdown();
        }
        this.f53401d.shutdown();
        this.f53398a.quit();
        Picasso.f53431l.post(new Runnable() {
            public void run() {
                Dispatcher.this.f53411n.b();
            }
        });
    }

    private void markForReplay(Action action) {
        Object i11 = action.i();
        if (i11 != null) {
            action.f53368k = true;
            this.f53403f.put(i11, action);
        }
    }
}
