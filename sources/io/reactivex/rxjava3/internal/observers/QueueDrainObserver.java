package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ObservableQueueDrain;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;

public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {

    /* renamed from: c  reason: collision with root package name */
    public final Observer<? super V> f19056c;

    /* renamed from: d  reason: collision with root package name */
    public final SimplePlainQueue<U> f19057d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f19058e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f19059f;

    /* renamed from: g  reason: collision with root package name */
    public Throwable f19060g;

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.f19056c = observer;
        this.f19057d = simplePlainQueue;
    }

    public final void a(U u11, boolean z11, Disposable disposable) {
        Observer<? super V> observer = this.f19056c;
        SimplePlainQueue<U> simplePlainQueue = this.f19057d;
        if (this.f19061b.get() != 0 || !this.f19061b.compareAndSet(0, 1)) {
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
        Observer<? super V> observer = this.f19056c;
        SimplePlainQueue<U> simplePlainQueue = this.f19057d;
        if (this.f19061b.get() != 0 || !this.f19061b.compareAndSet(0, 1)) {
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
        return this.f19058e;
    }

    public final boolean done() {
        return this.f19059f;
    }

    public final boolean enter() {
        return this.f19061b.getAndIncrement() == 0;
    }

    public final Throwable error() {
        return this.f19060g;
    }

    public final int leave(int i11) {
        return this.f19061b.addAndGet(i11);
    }
}
