package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.functions.Function4;
import io.reactivex.rxjava3.functions.Function5;
import io.reactivex.rxjava3.functions.Function6;
import io.reactivex.rxjava3.functions.Function7;
import io.reactivex.rxjava3.functions.Function8;
import io.reactivex.rxjava3.functions.Function9;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

public final class Functions {
    public static final Action EMPTY_ACTION = new EmptyAction();
    public static final LongConsumer EMPTY_LONG_CONSUMER = new EmptyLongConsumer();
    public static final Runnable EMPTY_RUNNABLE = new EmptyRunnable();
    public static final Consumer<Throwable> ERROR_CONSUMER = new ErrorConsumer();
    public static final Consumer<Throwable> ON_ERROR_MISSING = new OnErrorMissingConsumer();
    public static final Consumer<Subscription> REQUEST_MAX = new MaxRequestSubscription();

    /* renamed from: a  reason: collision with root package name */
    public static final Function<Object, Object> f18788a = new Identity();

    /* renamed from: b  reason: collision with root package name */
    public static final Consumer<Object> f18789b = new EmptyConsumer();

    /* renamed from: c  reason: collision with root package name */
    public static final Predicate<Object> f18790c = new TruePredicate();

    /* renamed from: d  reason: collision with root package name */
    public static final Predicate<Object> f18791d = new FalsePredicate();

    /* renamed from: e  reason: collision with root package name */
    public static final Supplier<Object> f18792e = new NullProvider();

    public static final class ActionConsumer<T> implements Consumer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Action f18793b;

        public ActionConsumer(Action action) {
            this.f18793b = action;
        }

        public void accept(T t11) throws Throwable {
            this.f18793b.run();
        }
    }

    public static final class Array2Func<T1, T2, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final BiFunction<? super T1, ? super T2, ? extends R> f18794b;

        public Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.f18794b = biFunction;
        }

        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 2) {
                return this.f18794b.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    public static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function3<T1, T2, T3, R> f18795b;

        public Array3Func(Function3<T1, T2, T3, R> function3) {
            this.f18795b = function3;
        }

        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 3) {
                return this.f18795b.apply(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    public static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function4<T1, T2, T3, T4, R> f18796b;

        public Array4Func(Function4<T1, T2, T3, T4, R> function4) {
            this.f18796b = function4;
        }

        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 4) {
                return this.f18796b.apply(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    public static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {

        /* renamed from: f  reason: collision with root package name */
        private final Function5<T1, T2, T3, T4, T5, R> f18797f;

        public Array5Func(Function5<T1, T2, T3, T4, T5, R> function5) {
            this.f18797f = function5;
        }

        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 5) {
                return this.f18797f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    public static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function6<T1, T2, T3, T4, T5, T6, R> f18798b;

        public Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
            this.f18798b = function6;
        }

        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 6) {
                return this.f18798b.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    public static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function7<T1, T2, T3, T4, T5, T6, T7, R> f18799b;

        public Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
            this.f18799b = function7;
        }

        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 7) {
                return this.f18799b.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    public static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f18800b;

        public Array8Func(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
            this.f18800b = function8;
        }

        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 8) {
                return this.f18800b.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    public static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f18801b;

        public Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
            this.f18801b = function9;
        }

        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 9) {
                return this.f18801b.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    public static final class ArrayListCapacityCallable<T> implements Supplier<List<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final int f18802b;

        public ArrayListCapacityCallable(int i11) {
            this.f18802b = i11;
        }

        public List<T> get() {
            return new ArrayList(this.f18802b);
        }
    }

    public static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {

        /* renamed from: b  reason: collision with root package name */
        public final BooleanSupplier f18803b;

        public BooleanSupplierPredicateReverse(BooleanSupplier booleanSupplier) {
            this.f18803b = booleanSupplier;
        }

        public boolean test(T t11) throws Throwable {
            return !this.f18803b.getAsBoolean();
        }
    }

    public static class BoundedConsumer implements Consumer<Subscription> {

        /* renamed from: b  reason: collision with root package name */
        public final int f18804b;

        public BoundedConsumer(int i11) {
            this.f18804b = i11;
        }

        public void accept(Subscription subscription) {
            subscription.request((long) this.f18804b);
        }
    }

    public static final class CastToClass<T, U> implements Function<T, U> {

        /* renamed from: b  reason: collision with root package name */
        public final Class<U> f18805b;

        public CastToClass(Class<U> cls) {
            this.f18805b = cls;
        }

        public U apply(T t11) {
            return this.f18805b.cast(t11);
        }
    }

    public static final class ClassFilter<T, U> implements Predicate<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Class<U> f18806b;

        public ClassFilter(Class<U> cls) {
            this.f18806b = cls;
        }

        public boolean test(T t11) {
            return this.f18806b.isInstance(t11);
        }
    }

    public static final class EmptyAction implements Action {
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    public static final class EmptyConsumer implements Consumer<Object> {
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    public static final class EmptyLongConsumer implements LongConsumer {
        public void accept(long j11) {
        }
    }

    public static final class EmptyRunnable implements Runnable {
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    public static final class EqualsPredicate<T> implements Predicate<T> {

        /* renamed from: b  reason: collision with root package name */
        public final T f18807b;

        public EqualsPredicate(T t11) {
            this.f18807b = t11;
        }

        public boolean test(T t11) {
            return Objects.equals(t11, this.f18807b);
        }
    }

    public static final class ErrorConsumer implements Consumer<Throwable> {
        public void accept(Throwable th2) {
            RxJavaPlugins.onError(th2);
        }
    }

    public static final class FalsePredicate implements Predicate<Object> {
        public boolean test(Object obj) {
            return false;
        }
    }

    public static final class FutureAction implements Action {

        /* renamed from: b  reason: collision with root package name */
        public final Future<?> f18808b;

        public FutureAction(Future<?> future) {
            this.f18808b = future;
        }

        public void run() throws Exception {
            this.f18808b.get();
        }
    }

    public enum HashSetSupplier implements Supplier<Set<Object>> {
        INSTANCE;

        public Set<Object> get() {
            return new HashSet();
        }
    }

    public static final class Identity implements Function<Object, Object> {
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    public static final class JustValue<T, U> implements Callable<U>, Supplier<U>, Function<T, U> {

        /* renamed from: b  reason: collision with root package name */
        public final U f18809b;

        public JustValue(U u11) {
            this.f18809b = u11;
        }

        public U apply(T t11) {
            return this.f18809b;
        }

        public U call() {
            return this.f18809b;
        }

        public U get() {
            return this.f18809b;
        }
    }

    public static final class ListSorter<T> implements Function<List<T>, List<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Comparator<? super T> f18810b;

        public ListSorter(Comparator<? super T> comparator) {
            this.f18810b = comparator;
        }

        public List<T> apply(List<T> list) {
            Collections.sort(list, this.f18810b);
            return list;
        }
    }

    public static final class MaxRequestSubscription implements Consumer<Subscription> {
        public void accept(Subscription subscription) {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class NotificationOnComplete<T> implements Action {

        /* renamed from: b  reason: collision with root package name */
        public final Consumer<? super Notification<T>> f18811b;

        public NotificationOnComplete(Consumer<? super Notification<T>> consumer) {
            this.f18811b = consumer;
        }

        public void run() throws Throwable {
            this.f18811b.accept(Notification.createOnComplete());
        }
    }

    public static final class NotificationOnError<T> implements Consumer<Throwable> {

        /* renamed from: b  reason: collision with root package name */
        public final Consumer<? super Notification<T>> f18812b;

        public NotificationOnError(Consumer<? super Notification<T>> consumer) {
            this.f18812b = consumer;
        }

        public void accept(Throwable th2) throws Throwable {
            this.f18812b.accept(Notification.createOnError(th2));
        }
    }

    public static final class NotificationOnNext<T> implements Consumer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Consumer<? super Notification<T>> f18813b;

        public NotificationOnNext(Consumer<? super Notification<T>> consumer) {
            this.f18813b = consumer;
        }

        public void accept(T t11) throws Throwable {
            this.f18813b.accept(Notification.createOnNext(t11));
        }
    }

    public static final class NullProvider implements Supplier<Object> {
        public Object get() {
            return null;
        }
    }

    public static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        public void accept(Throwable th2) {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(th2));
        }
    }

    public static final class TimestampFunction<T> implements Function<T, Timed<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final TimeUnit f18814b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f18815c;

        public TimestampFunction(TimeUnit timeUnit, Scheduler scheduler) {
            this.f18814b = timeUnit;
            this.f18815c = scheduler;
        }

        public Timed<T> apply(T t11) {
            return new Timed<>(t11, this.f18815c.now(this.f18814b), this.f18814b);
        }
    }

    public static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {
        private final Function<? super T, ? extends K> keySelector;

        public ToMapKeySelector(Function<? super T, ? extends K> function) {
            this.keySelector = function;
        }

        public void accept(Map<K, T> map, T t11) throws Throwable {
            map.put(this.keySelector.apply(t11), t11);
        }
    }

    public static final class ToMapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, V>, T> {
        private final Function<? super T, ? extends K> keySelector;
        private final Function<? super T, ? extends V> valueSelector;

        public ToMapKeyValueSelector(Function<? super T, ? extends V> function, Function<? super T, ? extends K> function2) {
            this.valueSelector = function;
            this.keySelector = function2;
        }

        public void accept(Map<K, V> map, T t11) throws Throwable {
            map.put(this.keySelector.apply(t11), this.valueSelector.apply(t11));
        }
    }

    public static final class ToMultimapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {
        private final Function<? super K, ? extends Collection<? super V>> collectionFactory;
        private final Function<? super T, ? extends K> keySelector;
        private final Function<? super T, ? extends V> valueSelector;

        public ToMultimapKeyValueSelector(Function<? super K, ? extends Collection<? super V>> function, Function<? super T, ? extends V> function2, Function<? super T, ? extends K> function3) {
            this.collectionFactory = function;
            this.valueSelector = function2;
            this.keySelector = function3;
        }

        public void accept(Map<K, Collection<V>> map, T t11) throws Throwable {
            Object apply = this.keySelector.apply(t11);
            Collection collection = map.get(apply);
            if (collection == null) {
                collection = (Collection) this.collectionFactory.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.valueSelector.apply(t11));
        }
    }

    public static final class TruePredicate implements Predicate<Object> {
        public boolean test(Object obj) {
            return true;
        }
    }

    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Consumer<T> actionConsumer(Action action) {
        return new ActionConsumer(action);
    }

    @NonNull
    public static <T> Predicate<T> alwaysFalse() {
        return f18791d;
    }

    @NonNull
    public static <T> Predicate<T> alwaysTrue() {
        return f18790c;
    }

    public static <T> Consumer<T> boundedConsumer(int i11) {
        return new BoundedConsumer(i11);
    }

    @NonNull
    public static <T, U> Function<T, U> castFunction(@NonNull Class<U> cls) {
        return new CastToClass(cls);
    }

    public static <T> Supplier<List<T>> createArrayList(int i11) {
        return new ArrayListCapacityCallable(i11);
    }

    public static <T> Supplier<Set<T>> createHashSet() {
        return HashSetSupplier.INSTANCE;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return f18789b;
    }

    public static <T> Predicate<T> equalsWith(T t11) {
        return new EqualsPredicate(t11);
    }

    @NonNull
    public static Action futureAction(@NonNull Future<?> future) {
        return new FutureAction(future);
    }

    @NonNull
    public static <T> Function<T, T> identity() {
        return f18788a;
    }

    public static <T, U> Predicate<T> isInstanceOf(Class<U> cls) {
        return new ClassFilter(cls);
    }

    @NonNull
    public static <T> Callable<T> justCallable(@NonNull T t11) {
        return new JustValue(t11);
    }

    @NonNull
    public static <T, U> Function<T, U> justFunction(@NonNull U u11) {
        return new JustValue(u11);
    }

    @NonNull
    public static <T> Supplier<T> justSupplier(@NonNull T t11) {
        return new JustValue(t11);
    }

    public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }

    public static <T> Comparator<T> naturalComparator() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Action notificationOnComplete(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnComplete(consumer);
    }

    public static <T> Consumer<Throwable> notificationOnError(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnError(consumer);
    }

    public static <T> Consumer<T> notificationOnNext(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnNext(consumer);
    }

    @NonNull
    public static <T> Supplier<T> nullSupplier() {
        return f18792e;
    }

    public static <T> Predicate<T> predicateReverseFor(BooleanSupplier booleanSupplier) {
        return new BooleanSupplierPredicateReverse(booleanSupplier);
    }

    public static <T> Function<T, Timed<T>> timestampWith(TimeUnit timeUnit, Scheduler scheduler) {
        return new TimestampFunction(timeUnit, scheduler);
    }

    @NonNull
    public static <T1, T2, R> Function<Object[], R> toFunction(@NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        return new Array2Func(biFunction);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> toMapKeySelector(Function<? super T, ? extends K> function) {
        return new ToMapKeySelector(function);
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> toMapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new ToMapKeyValueSelector(function2, function);
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new ToMultimapKeyValueSelector(function3, function2, function);
    }

    @NonNull
    public static <T1, T2, T3, R> Function<Object[], R> toFunction(@NonNull Function3<T1, T2, T3, R> function3) {
        return new Array3Func(function3);
    }

    @NonNull
    public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(@NonNull Function4<T1, T2, T3, T4, R> function4) {
        return new Array4Func(function4);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(@NonNull Function5<T1, T2, T3, T4, T5, R> function5) {
        return new Array5Func(function5);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(@NonNull Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        return new Array6Func(function6);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(@NonNull Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        return new Array7Func(function7);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(@NonNull Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        return new Array8Func(function8);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(@NonNull Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        return new Array9Func(function9);
    }
}
