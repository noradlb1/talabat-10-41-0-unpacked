package androidx.work;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;

public abstract class RxWorker extends ListenableWorker {

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f37989b = new SynchronousExecutor();
    @Nullable
    private SingleFutureAdapter<ListenableWorker.Result> mSingleFutureObserverAdapter;

    public static class SingleFutureAdapter<T> implements SingleObserver<T>, Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final SettableFuture<T> f37990b;
        @Nullable
        private Disposable mDisposable;

        public SingleFutureAdapter() {
            SettableFuture<T> create = SettableFuture.create();
            this.f37990b = create;
            create.addListener(this, RxWorker.f37989b);
        }

        public void a() {
            Disposable disposable = this.mDisposable;
            if (disposable != null) {
                disposable.dispose();
            }
        }

        public void onError(Throwable th2) {
            this.f37990b.setException(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.mDisposable = disposable;
        }

        public void onSuccess(T t11) {
            this.f37990b.set(t11);
        }

        public void run() {
            if (this.f37990b.isCancelled()) {
                a();
            }
        }
    }

    public RxWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    public Scheduler a() {
        return Schedulers.from(getBackgroundExecutor());
    }

    @MainThread
    @NonNull
    public abstract Single<ListenableWorker.Result> createWork();

    public void onStopped() {
        super.onStopped();
        SingleFutureAdapter<ListenableWorker.Result> singleFutureAdapter = this.mSingleFutureObserverAdapter;
        if (singleFutureAdapter != null) {
            singleFutureAdapter.a();
            this.mSingleFutureObserverAdapter = null;
        }
    }

    @NonNull
    public final Completable setCompletableProgress(@NonNull Data data) {
        return Completable.fromFuture(setProgressAsync(data));
    }

    @NonNull
    @Deprecated
    public final Single<Void> setProgress(@NonNull Data data) {
        return Single.fromFuture(setProgressAsync(data));
    }

    @NonNull
    public ListenableFuture<ListenableWorker.Result> startWork() {
        this.mSingleFutureObserverAdapter = new SingleFutureAdapter<>();
        createWork().subscribeOn(a()).observeOn(Schedulers.from(getTaskExecutor().getBackgroundExecutor())).subscribe(this.mSingleFutureObserverAdapter);
        return this.mSingleFutureObserverAdapter.f37990b;
    }
}
