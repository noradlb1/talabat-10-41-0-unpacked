package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.annotation.apihint.Internal;
import rx.Observable;
import rx.Scheduler;

@Internal
class RxBase {

    /* renamed from: a  reason: collision with root package name */
    public final Scheduler f27903a;

    public RxBase() {
        this.f27903a = null;
    }

    public <R> Observable<R> a(Callable<R> callable) {
        return b(RxUtils.a(callable));
    }

    public <R> Observable<R> b(Observable<R> observable) {
        Scheduler scheduler = this.f27903a;
        if (scheduler != null) {
            return observable.subscribeOn(scheduler);
        }
        return observable;
    }

    @Experimental
    public Scheduler getScheduler() {
        return this.f27903a;
    }

    @Experimental
    public RxBase(Scheduler scheduler) {
        this.f27903a = scheduler;
    }
}
