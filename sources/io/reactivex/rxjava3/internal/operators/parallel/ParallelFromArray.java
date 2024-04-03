package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelFromArray<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Publisher<T>[] f22627a;

    public ParallelFromArray(Publisher<T>[] publisherArr) {
        this.f22627a = publisherArr;
    }

    public int parallelism() {
        return this.f22627a.length;
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.f22627a[i11].subscribe(onSubscribe[i11]);
            }
        }
    }
}
