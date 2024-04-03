package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.Logger;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class ne implements de {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ce f48530a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Executor f48531b = Executors.newSingleThreadExecutor(new C0442u("DTM-Connect"));
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public WebSocket f48532c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public OkHttpClient f48533d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f48534e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Object f48535f = new Object();

    public class a extends WebSocketListener {
        private a() {
        }

        public /* synthetic */ a(ne neVar, ee eeVar) {
            this();
        }

        public void onClosed(WebSocket webSocket, int i11, String str) {
            Logger.info("DTM-AutoTrace", "disconnect success.");
            ne.this.f48531b.execute(new ke(this));
        }

        public void onClosing(WebSocket webSocket, int i11, String str) {
            Logger.info("DTM-AutoTrace", "onClosing#wss onClosing. code=" + i11 + " reason=" + str);
            ne.this.f48531b.execute(new me(this));
        }

        public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
            Logger.info("DTM-AutoTrace", "connect fail." + th2.getMessage());
            ne.this.f48531b.execute(new le(this));
        }

        public void onMessage(WebSocket webSocket, String str) {
            ne.this.f48531b.execute(new je(this, str));
        }

        public void onOpen(WebSocket webSocket, Response response) {
            Logger.info("DTM-AutoTrace", "connect success.");
            ne.this.f48531b.execute(new ie(this, webSocket));
        }
    }

    public ne(ce ceVar) {
        this.f48530a = ceVar;
    }

    public void a() {
        this.f48531b.execute(new ee(this));
    }

    public void a(String str) {
        this.f48531b.execute(new fe(this, str));
    }

    public void disconnect() {
        this.f48531b.execute(new he(this));
    }

    public boolean isConnected() {
        return (this.f48533d == null || this.f48532c == null) ? false : true;
    }

    public void send(String str) {
        synchronized (this.f48535f) {
            this.f48534e = str;
        }
        this.f48531b.execute(new ge(this, str));
    }
}
