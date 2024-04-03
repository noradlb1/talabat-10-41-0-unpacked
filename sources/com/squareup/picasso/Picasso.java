package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.squareup.picasso.Action;
import com.squareup.picasso.RemoteViewsAction;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import tracking.gtm.TalabatGTM;

public class Picasso {

    /* renamed from: l  reason: collision with root package name */
    public static final Handler f53431l = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 != 3) {
                int i12 = 0;
                if (i11 == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    while (i12 < size) {
                        BitmapHunter bitmapHunter = (BitmapHunter) list.get(i12);
                        bitmapHunter.f53372c.b(bitmapHunter);
                        i12++;
                    }
                } else if (i11 == 13) {
                    List list2 = (List) message.obj;
                    int size2 = list2.size();
                    while (i12 < size2) {
                        Action action = (Action) list2.get(i12);
                        action.f53358a.g(action);
                        i12++;
                    }
                } else {
                    throw new AssertionError("Unknown handler message received: " + message.what);
                }
            } else {
                Action action2 = (Action) message.obj;
                if (action2.e().f53442j) {
                    Utils.u("Main", "canceled", action2.f53359b.c(), "target got garbage collected");
                }
                action2.f53358a.a(action2.i());
            }
        }
    };
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: m  reason: collision with root package name */
    public static volatile Picasso f53432m = null;

    /* renamed from: a  reason: collision with root package name */
    public final Context f53433a;

    /* renamed from: b  reason: collision with root package name */
    public final Dispatcher f53434b;

    /* renamed from: c  reason: collision with root package name */
    public final Cache f53435c;
    private final CleanupThread cleanupThread;

    /* renamed from: d  reason: collision with root package name */
    public final Stats f53436d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<Object, Action> f53437e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<ImageView, DeferredRequestCreator> f53438f;

    /* renamed from: g  reason: collision with root package name */
    public final ReferenceQueue<Object> f53439g;

    /* renamed from: h  reason: collision with root package name */
    public final Bitmap.Config f53440h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53441i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f53442j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f53443k;
    private final Listener listener;
    private final List<RequestHandler> requestHandlers;
    private final RequestTransformer requestTransformer;

    public static class Builder {
        private Cache cache;
        private final Context context;
        private Bitmap.Config defaultBitmapConfig;
        private Downloader downloader;
        private boolean indicatorsEnabled;
        private Listener listener;
        private boolean loggingEnabled;
        private List<RequestHandler> requestHandlers;

        /* renamed from: service  reason: collision with root package name */
        private ExecutorService f53444service;
        private RequestTransformer transformer;

        public Builder(@NonNull Context context2) {
            if (context2 != null) {
                this.context = context2.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public Builder addRequestHandler(@NonNull RequestHandler requestHandler) {
            if (requestHandler != null) {
                if (this.requestHandlers == null) {
                    this.requestHandlers = new ArrayList();
                }
                if (!this.requestHandlers.contains(requestHandler)) {
                    this.requestHandlers.add(requestHandler);
                    return this;
                }
                throw new IllegalStateException("RequestHandler already registered.");
            }
            throw new IllegalArgumentException("RequestHandler must not be null.");
        }

        public Picasso build() {
            Context context2 = this.context;
            if (this.downloader == null) {
                this.downloader = new OkHttp3Downloader(context2);
            }
            if (this.cache == null) {
                this.cache = new LruCache(context2);
            }
            if (this.f53444service == null) {
                this.f53444service = new PicassoExecutorService();
            }
            if (this.transformer == null) {
                this.transformer = RequestTransformer.IDENTITY;
            }
            Stats stats = new Stats(this.cache);
            Context context3 = context2;
            return new Picasso(context3, new Dispatcher(context3, this.f53444service, Picasso.f53431l, this.downloader, this.cache, stats), this.cache, this.listener, this.transformer, this.requestHandlers, stats, this.defaultBitmapConfig, this.indicatorsEnabled, this.loggingEnabled);
        }

        public Builder defaultBitmapConfig(@NonNull Bitmap.Config config) {
            if (config != null) {
                this.defaultBitmapConfig = config;
                return this;
            }
            throw new IllegalArgumentException("Bitmap config must not be null.");
        }

        public Builder downloader(@NonNull Downloader downloader2) {
            if (downloader2 == null) {
                throw new IllegalArgumentException("Downloader must not be null.");
            } else if (this.downloader == null) {
                this.downloader = downloader2;
                return this;
            } else {
                throw new IllegalStateException("Downloader already set.");
            }
        }

        public Builder executor(@NonNull ExecutorService executorService) {
            if (executorService == null) {
                throw new IllegalArgumentException("Executor service must not be null.");
            } else if (this.f53444service == null) {
                this.f53444service = executorService;
                return this;
            } else {
                throw new IllegalStateException("Executor service already set.");
            }
        }

        public Builder indicatorsEnabled(boolean z11) {
            this.indicatorsEnabled = z11;
            return this;
        }

        public Builder listener(@NonNull Listener listener2) {
            if (listener2 == null) {
                throw new IllegalArgumentException("Listener must not be null.");
            } else if (this.listener == null) {
                this.listener = listener2;
                return this;
            } else {
                throw new IllegalStateException("Listener already set.");
            }
        }

        public Builder loggingEnabled(boolean z11) {
            this.loggingEnabled = z11;
            return this;
        }

        public Builder memoryCache(@NonNull Cache cache2) {
            if (cache2 == null) {
                throw new IllegalArgumentException("Memory cache must not be null.");
            } else if (this.cache == null) {
                this.cache = cache2;
                return this;
            } else {
                throw new IllegalStateException("Memory cache already set.");
            }
        }

        public Builder requestTransformer(@NonNull RequestTransformer requestTransformer) {
            if (requestTransformer == null) {
                throw new IllegalArgumentException("Transformer must not be null.");
            } else if (this.transformer == null) {
                this.transformer = requestTransformer;
                return this;
            } else {
                throw new IllegalStateException("Transformer already set.");
            }
        }
    }

    public static class CleanupThread extends Thread {
        private final Handler handler;
        private final ReferenceQueue<Object> referenceQueue;

        public CleanupThread(ReferenceQueue<Object> referenceQueue2, Handler handler2) {
            this.referenceQueue = referenceQueue2;
            this.handler = handler2;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void a() {
            interrupt();
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    Action.RequestWeakReference requestWeakReference = (Action.RequestWeakReference) this.referenceQueue.remove(1000);
                    Message obtainMessage = this.handler.obtainMessage();
                    if (requestWeakReference != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = requestWeakReference.f53370a;
                        this.handler.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e11) {
                    this.handler.post(new Runnable() {
                        public void run() {
                            throw new RuntimeException(e11);
                        }
                    });
                    return;
                }
            }
        }
    }

    public interface Listener {
        void onImageLoadFailed(Picasso picasso, Uri uri, Exception exc);
    }

    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f53447b;

        private LoadedFrom(int i11) {
            this.f53447b = i11;
        }
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    public interface RequestTransformer {
        public static final RequestTransformer IDENTITY = new RequestTransformer() {
            public Request transformRequest(Request request) {
                return request;
            }
        };

        Request transformRequest(Request request);
    }

    public Picasso(Context context, Dispatcher dispatcher, Cache cache, Listener listener2, RequestTransformer requestTransformer2, List<RequestHandler> list, Stats stats, Bitmap.Config config, boolean z11, boolean z12) {
        int i11;
        this.f53433a = context;
        this.f53434b = dispatcher;
        this.f53435c = cache;
        this.listener = listener2;
        this.requestTransformer = requestTransformer2;
        this.f53440h = config;
        if (list != null) {
            i11 = list.size();
        } else {
            i11 = 0;
        }
        ArrayList arrayList = new ArrayList(i11 + 7);
        arrayList.add(new ResourceRequestHandler(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new ContactsPhotoRequestHandler(context));
        arrayList.add(new MediaStoreRequestHandler(context));
        arrayList.add(new ContentStreamRequestHandler(context));
        arrayList.add(new AssetRequestHandler(context));
        arrayList.add(new FileRequestHandler(context));
        arrayList.add(new NetworkRequestHandler(dispatcher.f53401d, stats));
        this.requestHandlers = Collections.unmodifiableList(arrayList);
        this.f53436d = stats;
        this.f53437e = new WeakHashMap();
        this.f53438f = new WeakHashMap();
        this.f53441i = z11;
        this.f53442j = z12;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.f53439g = referenceQueue;
        CleanupThread cleanupThread2 = new CleanupThread(referenceQueue, f53431l);
        this.cleanupThread = cleanupThread2;
        cleanupThread2.start();
    }

    private void deliverAction(Bitmap bitmap, LoadedFrom loadedFrom, Action action, Exception exc) {
        if (!action.j()) {
            if (!action.k()) {
                this.f53437e.remove(action.i());
            }
            if (bitmap == null) {
                action.error(exc);
                if (this.f53442j) {
                    Utils.u("Main", "errored", action.f53359b.c(), exc.getMessage());
                }
            } else if (loadedFrom != null) {
                action.complete(bitmap, loadedFrom);
                if (this.f53442j) {
                    String c11 = action.f53359b.c();
                    Utils.u("Main", TalabatGTM.COMPLETED, c11, "from " + loadedFrom);
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    public static Picasso get() {
        if (f53432m == null) {
            synchronized (Picasso.class) {
                if (f53432m == null) {
                    Context context = PicassoProvider.f53452b;
                    if (context != null) {
                        f53432m = new Builder(context).build();
                    } else {
                        throw new IllegalStateException("context == null");
                    }
                }
            }
        }
        return f53432m;
    }

    public static void setSingletonInstance(@NonNull Picasso picasso) {
        if (picasso != null) {
            synchronized (Picasso.class) {
                if (f53432m == null) {
                    f53432m = picasso;
                } else {
                    throw new IllegalStateException("Singleton instance already exists.");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Picasso must not be null.");
    }

    public void a(Object obj) {
        DeferredRequestCreator remove;
        Utils.c();
        Action remove2 = this.f53437e.remove(obj);
        if (remove2 != null) {
            remove2.a();
            this.f53434b.b(remove2);
        }
        if ((obj instanceof ImageView) && (remove = this.f53438f.remove((ImageView) obj)) != null) {
            remove.a();
        }
    }

    public boolean areIndicatorsEnabled() {
        return this.f53441i;
    }

    public void b(BitmapHunter bitmapHunter) {
        boolean z11;
        Action g11 = bitmapHunter.g();
        List<Action> h11 = bitmapHunter.h();
        boolean z12 = true;
        if (h11 == null || h11.isEmpty()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (g11 == null && !z11) {
            z12 = false;
        }
        if (z12) {
            Uri uri = bitmapHunter.i().uri;
            Exception j11 = bitmapHunter.j();
            Bitmap r11 = bitmapHunter.r();
            LoadedFrom n11 = bitmapHunter.n();
            if (g11 != null) {
                deliverAction(r11, n11, g11, j11);
            }
            if (z11) {
                int size = h11.size();
                for (int i11 = 0; i11 < size; i11++) {
                    deliverAction(r11, n11, h11.get(i11), j11);
                }
            }
            Listener listener2 = this.listener;
            if (listener2 != null && j11 != null) {
                listener2.onImageLoadFailed(this, uri, j11);
            }
        }
    }

    public void c(ImageView imageView, DeferredRequestCreator deferredRequestCreator) {
        if (this.f53438f.containsKey(imageView)) {
            a(imageView);
        }
        this.f53438f.put(imageView, deferredRequestCreator);
    }

    public void cancelRequest(@NonNull ImageView imageView) {
        if (imageView != null) {
            a(imageView);
            return;
        }
        throw new IllegalArgumentException("view cannot be null.");
    }

    public void cancelTag(@NonNull Object obj) {
        Utils.c();
        if (obj != null) {
            ArrayList arrayList = new ArrayList(this.f53437e.values());
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                Action action = (Action) arrayList.get(i11);
                if (obj.equals(action.h())) {
                    a(action.i());
                }
            }
            ArrayList arrayList2 = new ArrayList(this.f53438f.values());
            int size2 = arrayList2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                DeferredRequestCreator deferredRequestCreator = (DeferredRequestCreator) arrayList2.get(i12);
                if (obj.equals(deferredRequestCreator.b())) {
                    deferredRequestCreator.a();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Cannot cancel requests with null tag.");
    }

    public void d(Action action) {
        Object i11 = action.i();
        if (!(i11 == null || this.f53437e.get(i11) == action)) {
            a(i11);
            this.f53437e.put(i11, action);
        }
        h(action);
    }

    public List<RequestHandler> e() {
        return this.requestHandlers;
    }

    public Bitmap f(String str) {
        Bitmap bitmap = this.f53435c.get(str);
        if (bitmap != null) {
            this.f53436d.d();
        } else {
            this.f53436d.e();
        }
        return bitmap;
    }

    public void g(Action action) {
        Bitmap bitmap;
        if (MemoryPolicy.a(action.f53362e)) {
            bitmap = f(action.b());
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            LoadedFrom loadedFrom = LoadedFrom.MEMORY;
            deliverAction(bitmap, loadedFrom, action, (Exception) null);
            if (this.f53442j) {
                Utils.u("Main", TalabatGTM.COMPLETED, action.f53359b.c(), "from " + loadedFrom);
                return;
            }
            return;
        }
        d(action);
        if (this.f53442j) {
            Utils.t("Main", "resumed", action.f53359b.c());
        }
    }

    public StatsSnapshot getSnapshot() {
        return this.f53436d.a();
    }

    public void h(Action action) {
        this.f53434b.i(action);
    }

    public Request i(Request request) {
        Request transformRequest = this.requestTransformer.transformRequest(request);
        if (transformRequest != null) {
            return transformRequest;
        }
        throw new IllegalStateException("Request transformer " + this.requestTransformer.getClass().getCanonicalName() + " returned null for " + request);
    }

    public void invalidate(@Nullable Uri uri) {
        if (uri != null) {
            this.f53435c.clearKeyUri(uri.toString());
        }
    }

    public boolean isLoggingEnabled() {
        return this.f53442j;
    }

    public RequestCreator load(@Nullable Uri uri) {
        return new RequestCreator(this, uri, 0);
    }

    public void pauseTag(@NonNull Object obj) {
        if (obj != null) {
            this.f53434b.f(obj);
            return;
        }
        throw new IllegalArgumentException("tag == null");
    }

    public void resumeTag(@NonNull Object obj) {
        if (obj != null) {
            this.f53434b.g(obj);
            return;
        }
        throw new IllegalArgumentException("tag == null");
    }

    public void setIndicatorsEnabled(boolean z11) {
        this.f53441i = z11;
    }

    public void setLoggingEnabled(boolean z11) {
        this.f53442j = z11;
    }

    public void shutdown() {
        if (this == f53432m) {
            throw new UnsupportedOperationException("Default singleton instance cannot be shutdown.");
        } else if (!this.f53443k) {
            this.f53435c.clear();
            this.cleanupThread.a();
            this.f53436d.l();
            this.f53434b.u();
            for (DeferredRequestCreator a11 : this.f53438f.values()) {
                a11.a();
            }
            this.f53438f.clear();
            this.f53443k = true;
        }
    }

    public void invalidate(@Nullable String str) {
        if (str != null) {
            invalidate(Uri.parse(str));
        }
    }

    public RequestCreator load(@Nullable String str) {
        if (str == null) {
            return new RequestCreator(this, (Uri) null, 0);
        }
        if (str.trim().length() != 0) {
            return load(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public void cancelRequest(@NonNull Target target) {
        if (target != null) {
            a(target);
            return;
        }
        throw new IllegalArgumentException("target cannot be null.");
    }

    public void invalidate(@NonNull File file) {
        if (file != null) {
            invalidate(Uri.fromFile(file));
            return;
        }
        throw new IllegalArgumentException("file == null");
    }

    public void cancelRequest(@NonNull RemoteViews remoteViews, @IdRes int i11) {
        if (remoteViews != null) {
            a(new RemoteViewsAction.RemoteViewsTarget(remoteViews, i11));
            return;
        }
        throw new IllegalArgumentException("remoteViews cannot be null.");
    }

    public RequestCreator load(@NonNull File file) {
        if (file == null) {
            return new RequestCreator(this, (Uri) null, 0);
        }
        return load(Uri.fromFile(file));
    }

    public RequestCreator load(@DrawableRes int i11) {
        if (i11 != 0) {
            return new RequestCreator(this, (Uri) null, i11);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }
}
