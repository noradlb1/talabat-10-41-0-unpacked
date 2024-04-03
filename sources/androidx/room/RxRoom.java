package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.InvalidationTracker;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class RxRoom {
    public static final Object NOTHING = new Object();

    public static Flowable<Object> createFlowable(final RoomDatabase roomDatabase, final String... strArr) {
        return Flowable.create(new FlowableOnSubscribe<Object>() {
            public void subscribe(final FlowableEmitter<Object> flowableEmitter) throws Exception {
                final AnonymousClass1 r02 = new InvalidationTracker.Observer(strArr) {
                    public void onInvalidated(@NonNull Set<String> set) {
                        if (!flowableEmitter.isCancelled()) {
                            flowableEmitter.onNext(RxRoom.NOTHING);
                        }
                    }
                };
                if (!flowableEmitter.isCancelled()) {
                    roomDatabase.getInvalidationTracker().addObserver(r02);
                    flowableEmitter.setDisposable(Disposables.fromAction(new Action() {
                        public void run() throws Exception {
                            roomDatabase.getInvalidationTracker().removeObserver(r02);
                        }
                    }));
                }
                if (!flowableEmitter.isCancelled()) {
                    flowableEmitter.onNext(RxRoom.NOTHING);
                }
            }
        }, BackpressureStrategy.LATEST);
    }

    public static Observable<Object> createObservable(final RoomDatabase roomDatabase, final String... strArr) {
        return Observable.create(new ObservableOnSubscribe<Object>() {
            public void subscribe(final ObservableEmitter<Object> observableEmitter) throws Exception {
                final AnonymousClass1 r02 = new InvalidationTracker.Observer(strArr) {
                    public void onInvalidated(@NonNull Set<String> set) {
                        observableEmitter.onNext(RxRoom.NOTHING);
                    }
                };
                roomDatabase.getInvalidationTracker().addObserver(r02);
                observableEmitter.setDisposable(Disposables.fromAction(new Action() {
                    public void run() throws Exception {
                        roomDatabase.getInvalidationTracker().removeObserver(r02);
                    }
                }));
                observableEmitter.onNext(RxRoom.NOTHING);
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> Single<T> createSingle(final Callable<T> callable) {
        return Single.create(new SingleOnSubscribe<T>() {
            public void subscribe(SingleEmitter<T> singleEmitter) throws Exception {
                try {
                    singleEmitter.onSuccess(callable.call());
                } catch (EmptyResultSetException e11) {
                    singleEmitter.tryOnError(e11);
                }
            }
        });
    }

    private static Executor getExecutor(RoomDatabase roomDatabase, boolean z11) {
        if (z11) {
            return roomDatabase.getTransactionExecutor();
        }
        return roomDatabase.getQueryExecutor();
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> Flowable<T> createFlowable(RoomDatabase roomDatabase, String[] strArr, Callable<T> callable) {
        return createFlowable(roomDatabase, false, strArr, callable);
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> Observable<T> createObservable(RoomDatabase roomDatabase, String[] strArr, Callable<T> callable) {
        return createObservable(roomDatabase, false, strArr, callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> Flowable<T> createFlowable(RoomDatabase roomDatabase, boolean z11, String[] strArr, Callable<T> callable) {
        Scheduler from = Schedulers.from(getExecutor(roomDatabase, z11));
        final Maybe<T> fromCallable = Maybe.fromCallable(callable);
        return createFlowable(roomDatabase, strArr).subscribeOn(from).unsubscribeOn(from).observeOn(from).flatMapMaybe(new Function<Object, MaybeSource<T>>() {
            public MaybeSource<T> apply(Object obj) throws Exception {
                return Maybe.this;
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> Observable<T> createObservable(RoomDatabase roomDatabase, boolean z11, String[] strArr, Callable<T> callable) {
        Scheduler from = Schedulers.from(getExecutor(roomDatabase, z11));
        final Maybe<T> fromCallable = Maybe.fromCallable(callable);
        return createObservable(roomDatabase, strArr).subscribeOn(from).unsubscribeOn(from).observeOn(from).flatMapMaybe(new Function<Object, MaybeSource<T>>() {
            public MaybeSource<T> apply(Object obj) throws Exception {
                return Maybe.this;
            }
        });
    }
}
