package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamCompletableSource;
import org.reactivestreams.Subscriber;

public final class FlowableFromCompletable<T> extends Flowable<T> implements HasUpstreamCompletableSource {

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f19823c;

    public static final class FromCompletableObserver<T> extends AbstractEmptyQueueFuseable<T> implements CompletableObserver {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19824b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f19825c;

        public FromCompletableObserver(Subscriber<? super T> subscriber) {
            this.f19824b = subscriber;
        }

        public void cancel() {
            this.f19825c.dispose();
            this.f19825c = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.f19825c = DisposableHelper.DISPOSED;
            this.f19824b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19825c = DisposableHelper.DISPOSED;
            this.f19824b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19825c, disposable)) {
                this.f19825c = disposable;
                this.f19824b.onSubscribe(this);
            }
        }
    }

    public FlowableFromCompletable(CompletableSource completableSource) {
        this.f19823c = completableSource;
    }

    public CompletableSource source() {
        return this.f19823c;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19823c.subscribe(new FromCompletableObserver(subscriber));
    }
}
