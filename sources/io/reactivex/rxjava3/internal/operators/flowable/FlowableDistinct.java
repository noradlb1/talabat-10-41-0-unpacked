package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableDistinct<T, K> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, K> f19630d;

    /* renamed from: e  reason: collision with root package name */
    public final Supplier<? extends Collection<? super K>> f19631e;

    public static final class DistinctSubscriber<T, K> extends BasicFuseableSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Collection<? super K> f19632g;

        /* renamed from: h  reason: collision with root package name */
        public final Function<? super T, K> f19633h;

        public DistinctSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, Collection<? super K> collection) {
            super(subscriber);
            this.f19633h = function;
            this.f19632g = collection;
        }

        public void clear() {
            this.f19632g.clear();
            super.clear();
        }

        public void onComplete() {
            if (!this.f23111e) {
                this.f23111e = true;
                this.f19632g.clear();
                this.f23108b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f23111e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f23111e = true;
            this.f19632g.clear();
            this.f23108b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f23111e) {
                if (this.f23112f == 0) {
                    try {
                        K apply = this.f19633h.apply(t11);
                        Objects.requireNonNull(apply, "The keySelector returned a null key");
                        if (this.f19632g.add(apply)) {
                            this.f23108b.onNext(t11);
                        } else {
                            this.f23109c.request(1);
                        }
                    } catch (Throwable th2) {
                        c(th2);
                    }
                } else {
                    this.f23108b.onNext(null);
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll;
            while (true) {
                poll = this.f23110d.poll();
                if (poll == null) {
                    break;
                }
                Collection<? super K> collection = this.f19632g;
                K apply = this.f19633h.apply(poll);
                Objects.requireNonNull(apply, "The keySelector returned a null key");
                if (collection.add(apply)) {
                    break;
                } else if (this.f23112f == 2) {
                    this.f23109c.request(1);
                }
            }
            return poll;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public FlowableDistinct(Flowable<T> flowable, Function<? super T, K> function, Supplier<? extends Collection<? super K>> supplier) {
        super(flowable);
        this.f19630d = function;
        this.f19631e = supplier;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            this.f19260c.subscribe(new DistinctSubscriber(subscriber, this.f19630d, (Collection) ExceptionHelper.nullCheck(this.f19631e.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
