package com.iab.omid.library.deliveryhero3.walking.async;

import com.iab.omid.library.deliveryhero3.walking.async.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<Runnable> f45035a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f45036b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<b> f45037c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private b f45038d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f45035a = linkedBlockingQueue;
        this.f45036b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void a() {
        b poll = this.f45037c.poll();
        this.f45038d = poll;
        if (poll != null) {
            poll.a(this.f45036b);
        }
    }

    public void a(b bVar) {
        this.f45038d = null;
        a();
    }

    public void b(b bVar) {
        bVar.a((b.a) this);
        this.f45037c.add(bVar);
        if (this.f45038d == null) {
            a();
        }
    }
}
