package com.instabug.chat.synchronization;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.chat.cache.k;
import com.instabug.chat.cache.m;
import com.instabug.chat.f;
import com.instabug.chat.model.o;
import com.instabug.chat.network.service.g;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.eventpublisher.Unsubscribable;
import com.instabug.library.core.eventbus.instabugeventbus.EventBusSubscriber;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
public class SynchronizationManager {
    private static volatile SynchronizationManager INSTANCE = null;
    private static final String MISSING_MESSAGES = "missing_messages";
    private static final long STOP_PULLING = -1;
    private static final String TTL = "ttl";
    @Nullable
    private Unsubscribable chatTimeSubscriber;
    private final EventBusSubscriber<Long> chattingTimeUpdateAction = new bc.a(this);
    /* access modifiers changed from: private */
    @Nullable
    public Handler handler;
    private boolean isSyncing = false;
    /* access modifiers changed from: private */
    public boolean shouldSync = false;
    /* access modifiers changed from: private */
    public Consumer<Long> syncAction = new a();
    /* access modifiers changed from: private */
    @Nullable
    public d syncRunnable;

    public class a implements Consumer<Long> {
        public a() {
        }

        private boolean a() {
            return (!SynchronizationManager.this.shouldSync || SynchronizationManager.this.handler == null || SynchronizationManager.this.syncRunnable == null) ? false : true;
        }

        /* renamed from: a */
        public void accept(Long l11) {
            if (a() && SynchronizationManager.this.handler != null && SynchronizationManager.this.syncRunnable != null) {
                InstabugSDKLogger.v("IBG-BR", "Waiting " + l11 + " seconds until the next chats sync");
                SynchronizationManager.this.handler.postDelayed(SynchronizationManager.this.syncRunnable, l11.longValue() * 1000);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f46166b;

        public b(Context context) {
            this.f46166b = context;
        }

        public void run() {
            Handler unused = SynchronizationManager.this.handler = new Handler();
            SynchronizationManager synchronizationManager = SynchronizationManager.this;
            d unused2 = synchronizationManager.syncRunnable = new d(this.f46166b);
            SynchronizationManager.this.subscribeToChatTimeUpdatedEvents();
        }
    }

    public class c implements Request.Callbacks {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46168a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Consumer f46169b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f46170c;

        public c(Context context, Consumer consumer, List list) {
            this.f46168a = context;
            this.f46169b = consumer;
            this.f46170c = list;
        }

        /* renamed from: a */
        public void onSucceeded(@Nullable RequestResponse requestResponse) {
            if (requestResponse != null) {
                SynchronizationManager.this.handleSuccessResponse(requestResponse, this.f46168a, this.f46169b);
            }
            SynchronizationManager.this.clearReadMessages(this.f46170c);
        }

        /* renamed from: a */
        public void onFailed(Throwable th2) {
            SynchronizationManager.this.handleFailureResponse(this.f46169b);
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public WeakReference f46172b;

        public d(Context context) {
            this.f46172b = new WeakReference(context);
        }

        public void run() {
            if (f.c()) {
                PoolProvider.postIOTaskWithCheck(new c(this));
            }
        }
    }

    private SynchronizationManager(Context context) {
        PoolProvider.postMainThreadTask(new b(context));
    }

    /* access modifiers changed from: private */
    public void clearReadMessages(List<o> list) {
        m.b().a((List) list);
    }

    public static synchronized SynchronizationManager getInstance() {
        SynchronizationManager synchronizationManager;
        synchronized (SynchronizationManager.class) {
            if (INSTANCE == null && Instabug.getApplicationContext() != null) {
                init(Instabug.getApplicationContext());
            }
            synchronizationManager = INSTANCE;
        }
        return synchronizationManager;
    }

    /* access modifiers changed from: private */
    public void handleFailureResponse(Consumer<Long> consumer) {
        InstabugSDKLogger.e("IBG-BR", "Something went wrong while sync messages");
        this.isSyncing = false;
        try {
            consumer.accept(Long.valueOf(com.instabug.chat.settings.a.g()));
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-BR", "Exception was occurred while sync messages," + e11.getMessage());
        }
    }

    private void handleReceivedMessages(Context context, JSONArray jSONArray, boolean z11) {
        JSONObject[] jSONObjectArr = new JSONObject[0];
        if (jSONArray.length() != 0) {
            InstabugSDKLogger.v("IBG-BR", jSONArray.length() + "new messages received");
            jSONObjectArr = new JSONObject[jSONArray.length()];
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                jSONObjectArr[i11] = jSONArray.getJSONObject(i11);
            }
        }
        a.b().a(context, z11, jSONObjectArr);
    }

    /* access modifiers changed from: private */
    public void handleSuccessResponse(RequestResponse requestResponse, Context context, Consumer<Long> consumer) {
        InstabugSDKLogger.d("IBG-BR", "Chats synced successfully");
        boolean z11 = false;
        this.isSyncing = false;
        try {
            Object responseBody = requestResponse.getResponseBody();
            if (responseBody instanceof String) {
                JSONArray parseReceivedMessages = parseReceivedMessages((String) responseBody);
                if (requestResponse.getResponseCode() == 203) {
                    z11 = true;
                }
                handleReceivedMessages(context, parseReceivedMessages, z11);
                handleTTL(parseTTL((String) responseBody), consumer);
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-BR", "Exception was occurred," + e11.getMessage() + " while handling chats sync response", e11);
            try {
                consumer.accept(Long.valueOf(com.instabug.chat.settings.a.g()));
            } catch (Exception e12) {
                InstabugSDKLogger.e("IBG-BR", "Exception was occurred," + e12.getMessage());
            }
        }
    }

    private void handleTTL(long j11, Consumer<Long> consumer) {
        InstabugSDKLogger.v("IBG-BR", "Next TTL: " + j11);
        if (j11 != -1) {
            com.instabug.chat.settings.a.b(j11);
            try {
                consumer.accept(Long.valueOf(j11));
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-BR", "Exception was occurred while handling TTL," + e11.getMessage());
            }
        }
    }

    public static void init(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SynchronizationManager(context);
        }
    }

    private boolean isFeaturesFetchedBefore() {
        return InstabugCore.isFeaturesFetchedBefore();
    }

    private boolean isSyncing() {
        return this.isSyncing;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Long l11) {
        sync();
    }

    @VisibleForTesting
    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public static void m() {
        INSTANCE = null;
    }

    private JSONArray parseReceivedMessages(String str) {
        return new JSONObject(str).getJSONArray(MISSING_MESSAGES);
    }

    private long parseTTL(String str) {
        return new JSONObject(str).getLong("ttl");
    }

    /* access modifiers changed from: private */
    public void subscribeToChatTimeUpdatedEvents() {
        this.chatTimeSubscriber = com.instabug.chat.eventbus.a.a().subscribe(this.chattingTimeUpdateAction);
    }

    /* access modifiers changed from: private */
    public void syncMessages(Context context, Consumer<Long> consumer) {
        if (f.c()) {
            try {
                this.isSyncing = true;
                g.a().a(k.c(), k.g(), m.b().c(), new c(context, consumer, m.b().a()));
            } catch (JSONException unused) {
                handleFailureResponse(consumer);
            }
        } else {
            InstabugSDKLogger.e("IBG-BR", "Can't sync chats because device is offline");
            try {
                consumer.accept(Long.valueOf(com.instabug.chat.settings.a.g()));
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-BR", "Syncing chats got error: " + e11.getMessage());
            }
        }
    }

    private void unSubscribeToChatTimeUpdatedEvents() {
        Unsubscribable unsubscribable = this.chatTimeSubscriber;
        if (unsubscribable != null) {
            unsubscribable.unsubscribe();
        }
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public void release() {
        stop();
        unSubscribeToChatTimeUpdatedEvents();
        this.handler = null;
        this.syncRunnable = null;
        m();
    }

    public void stop() {
        d dVar;
        this.shouldSync = false;
        Handler handler2 = this.handler;
        if (handler2 != null && (dVar = this.syncRunnable) != null) {
            handler2.removeCallbacks(dVar);
        }
    }

    public void sync() {
        Handler handler2 = this.handler;
        if (handler2 != null && this.syncRunnable != null) {
            if (f.c() && !isSyncing()) {
                stop();
                this.shouldSync = true;
                handler2.post(this.syncRunnable);
            }
            this.handler = handler2;
        }
    }
}
