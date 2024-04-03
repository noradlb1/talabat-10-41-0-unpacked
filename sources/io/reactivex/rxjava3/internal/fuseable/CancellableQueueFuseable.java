package io.reactivex.rxjava3.internal.fuseable;

public final class CancellableQueueFuseable<T> extends AbstractEmptyQueueFuseable<T> {

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f18817b;

    public void cancel() {
        this.f18817b = true;
    }

    public void dispose() {
        this.f18817b = true;
    }

    public boolean isDisposed() {
        return this.f18817b;
    }
}
