package io.reactivex.internal.operators.parallel;

import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelFromArray<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Publisher<T>[] f18093a;

    public ParallelFromArray(Publisher<T>[] publisherArr) {
        this.f18093a = publisherArr;
    }

    public int parallelism() {
        return this.f18093a.length;
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.f18093a[i11].subscribe(subscriberArr[i11]);
            }
        }
    }
}
