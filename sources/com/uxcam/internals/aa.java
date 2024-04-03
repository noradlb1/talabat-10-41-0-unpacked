package com.uxcam.internals;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import java.util.Objects;
import org.json.JSONArray;

public class aa extends Thread {

    /* renamed from: k  reason: collision with root package name */
    public static final ac f12947k = new C0000aa();

    /* renamed from: l  reason: collision with root package name */
    public static Pair<JSONArray, String> f12948l;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f12949a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final int f12950b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12951c;

    /* renamed from: d  reason: collision with root package name */
    public ac f12952d = f12947k;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f12953e = 0;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f12954f = false;

    /* renamed from: g  reason: collision with root package name */
    public long f12955g = 0;

    /* renamed from: h  reason: collision with root package name */
    public long f12956h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f12957i = new ab();

    /* renamed from: j  reason: collision with root package name */
    public boolean f12958j = true;

    /* renamed from: com.uxcam.internals.aa$aa  reason: collision with other inner class name */
    public class C0000aa implements ac {
        public void a(Pair<JSONArray, String> pair, long j11) {
        }
    }

    public class ab implements Runnable {
        public ab() {
        }

        public void run() {
            aa.this.f12953e = 0;
            boolean unused = aa.this.f12954f = false;
            aa.this.f12956h = System.currentTimeMillis() - aa.this.f12955g;
        }
    }

    public interface ac {
        void a(Pair<JSONArray, String> pair, long j11);
    }

    public aa(int i11, int i12) {
        this.f12950b = i11;
        this.f12951c = i12;
    }

    public void run() {
        boolean z11;
        setName("|ANR-Ticker|");
        long j11 = (long) this.f12950b;
        while (!isInterrupted() && this.f12958j) {
            if (this.f12953e == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f12953e += j11;
            if (z11) {
                this.f12955g = System.currentTimeMillis();
                this.f12949a.post(this.f12957i);
            }
            try {
                Thread.sleep(j11);
                if (this.f12953e != 0 && !this.f12954f) {
                    this.f12954f = true;
                    Pair<JSONArray, String> a11 = hx.a("main", true);
                    f12948l = a11;
                    Objects.toString(a11);
                }
                if (((long) this.f12951c) < this.f12956h) {
                    if (Debug.isDebuggerConnected() || Debug.waitingForDebugger()) {
                        this.f12954f = true;
                    } else {
                        this.f12952d.a(f12948l, this.f12956h);
                        j11 = (long) this.f12950b;
                        this.f12954f = true;
                        this.f12956h = 0;
                    }
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}
