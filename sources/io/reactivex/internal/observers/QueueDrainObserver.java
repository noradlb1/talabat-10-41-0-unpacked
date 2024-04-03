package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {

    /* renamed from: c  reason: collision with root package name */
    public final Observer<? super V> f14575c;

    /* renamed from: d  reason: collision with root package name */
    public final SimplePlainQueue<U> f14576d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f14577e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f14578f;

    /* renamed from: g  reason: collision with root package name */
    public Throwable f14579g;

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.f14575c = observer;
        this.f14576d = simplePlainQueue;
    }

    public final void a(U u11, boolean z11, Disposable disposable) {
        Observer<? super V> observer = this.f14575c;
        SimplePlainQueue<U> simplePlainQueue = this.f14576d;
        if (this.f14580b.get() != 0 || !this.f14580b.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u11);
            if (!enter()) {
                return;
            }
        } else {
            accept(observer, u11);
            if (leave(-1) == 0) {
                return;
            }
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, z11, disposable, this);
    }

    public void accept(Observer<? super V> observer, U u11) {
    }

    public final void b(U u11, boolean z11, Disposable disposable) {
        Observer<? super V> observer = this.f14575c;
        SimplePlainQueue<U> simplePlainQueue = this.f14576d;
        if (this.f14580b.get() != 0 || !this.f14580b.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u11);
            if (!enter()) {
                return;
            }
        } else if (simplePlainQueue.isEmpty()) {
            accept(observer, u11);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u11);
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, z11, disposable, this);
    }

    public final boolean cancelled() {
        return this.f14577e;
    }

    public final boolean done() {
        return this.f14578f;
    }

    public final boolean enter() {
        return this.f14580b.getAndIncrement() == 0;
    }

    public final Throwable error() {
        return this.f14579g;
    }

    public final boolean fastEnter() {
        return this.f14580b.get() == 0 && this.f14580b.compareAndSet(0, 1);
    }

    public final int leave(int i11) {
        return this.f14580b.addAndGet(i11);
    }
}
