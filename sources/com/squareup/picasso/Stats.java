package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class Stats {
    private static final int BITMAP_DECODE_FINISHED = 2;
    private static final int BITMAP_TRANSFORMED_FINISHED = 3;
    private static final int CACHE_HIT = 0;
    private static final int CACHE_MISS = 1;
    private static final int DOWNLOAD_FINISHED = 4;
    private static final String STATS_THREAD_NAME = "Picasso-Stats";

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f53461a;

    /* renamed from: b  reason: collision with root package name */
    public final Cache f53462b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f53463c;

    /* renamed from: d  reason: collision with root package name */
    public long f53464d;

    /* renamed from: e  reason: collision with root package name */
    public long f53465e;

    /* renamed from: f  reason: collision with root package name */
    public long f53466f;

    /* renamed from: g  reason: collision with root package name */
    public long f53467g;

    /* renamed from: h  reason: collision with root package name */
    public long f53468h;

    /* renamed from: i  reason: collision with root package name */
    public long f53469i;

    /* renamed from: j  reason: collision with root package name */
    public long f53470j;

    /* renamed from: k  reason: collision with root package name */
    public long f53471k;

    /* renamed from: l  reason: collision with root package name */
    public int f53472l;

    /* renamed from: m  reason: collision with root package name */
    public int f53473m;

    /* renamed from: n  reason: collision with root package name */
    public int f53474n;

    public static class StatsHandler extends Handler {
        private final Stats stats;

        public StatsHandler(Looper looper, Stats stats2) {
            super(looper);
            this.stats = stats2;
        }

        public void handleMessage(final Message message) {
            int i11 = message.what;
            if (i11 == 0) {
                this.stats.i();
            } else if (i11 == 1) {
                this.stats.j();
            } else if (i11 == 2) {
                this.stats.g((long) message.arg1);
            } else if (i11 == 3) {
                this.stats.h((long) message.arg1);
            } else if (i11 != 4) {
                Picasso.f53431l.post(new Runnable() {
                    public void run() {
                        throw new AssertionError("Unhandled stats message." + message.what);
                    }
                });
            } else {
                this.stats.k((Long) message.obj);
            }
        }
    }

    public Stats(Cache cache) {
        this.f53462b = cache;
        HandlerThread handlerThread = new HandlerThread(STATS_THREAD_NAME, 10);
        this.f53461a = handlerThread;
        handlerThread.start();
        Utils.i(handlerThread.getLooper());
        this.f53463c = new StatsHandler(handlerThread.getLooper(), this);
    }

    private static long getAverage(int i11, long j11) {
        return j11 / ((long) i11);
    }

    private void processBitmap(Bitmap bitmap, int i11) {
        int j11 = Utils.j(bitmap);
        Handler handler = this.f53463c;
        handler.sendMessage(handler.obtainMessage(i11, j11, 0));
    }

    public StatsSnapshot a() {
        return new StatsSnapshot(this.f53462b.maxSize(), this.f53462b.size(), this.f53464d, this.f53465e, this.f53466f, this.f53467g, this.f53468h, this.f53469i, this.f53470j, this.f53471k, this.f53472l, this.f53473m, this.f53474n, System.currentTimeMillis());
    }

    public void b(Bitmap bitmap) {
        processBitmap(bitmap, 2);
    }

    public void c(Bitmap bitmap) {
        processBitmap(bitmap, 3);
    }

    public void d() {
        this.f53463c.sendEmptyMessage(0);
    }

    public void e() {
        this.f53463c.sendEmptyMessage(1);
    }

    public void f(long j11) {
        Handler handler = this.f53463c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j11)));
    }

    public void g(long j11) {
        int i11 = this.f53473m + 1;
        this.f53473m = i11;
        long j12 = this.f53467g + j11;
        this.f53467g = j12;
        this.f53470j = getAverage(i11, j12);
    }

    public void h(long j11) {
        this.f53474n++;
        long j12 = this.f53468h + j11;
        this.f53468h = j12;
        this.f53471k = getAverage(this.f53473m, j12);
    }

    public void i() {
        this.f53464d++;
    }

    public void j() {
        this.f53465e++;
    }

    public void k(Long l11) {
        this.f53472l++;
        long longValue = this.f53466f + l11.longValue();
        this.f53466f = longValue;
        this.f53469i = getAverage(this.f53472l, longValue);
    }

    public void l() {
        this.f53461a.quit();
    }
}
