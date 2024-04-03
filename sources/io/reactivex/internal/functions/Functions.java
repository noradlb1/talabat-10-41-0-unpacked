package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
    public static final Function<Object, Object> f14500a = new Identity();

    /* renamed from: b  reason: collision with root package name */
    public static final Consumer<Object> f14501b = new EmptyConsumer();

    /* renamed from: c  reason: collision with root package name */
    public static final Predicate<Object> f14502c = new TruePredicate();

    /* renamed from: d  reason: collision with root package name */
    public static final Predicate<Object> f14503d = new FalsePredicate();

    /* renamed from: e  reason: collision with root package name */
    public static final Callable<Object> f14504e = new NullCallable();

    /* renamed from: f  reason: collision with root package name */
    public static final Comparator<Object> f14505f = new NaturalObjectComparator();

    public static final class ActionConsumer<T> implements Consumer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Action f14506b;

        public ActionConsumer(Action action) {
            this.f14506b = action;
        }

        public void accept(T t11) throws Exception {
            this.f14506b.run();
        }
    }

    public static final class Array2Func<T1, T2, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final BiFunction<? super T1, ? super T2, ? extends R> f14507b;

        public Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.f14507b = biFunction;
        }

        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f14507b.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    public static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function3<T1, T2, T3, R> f14508b;

        public Array3Func(Function3<T1, T2, T3, R> function3) {
            this.f14508b = function3;
        }

        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return this.f14508b.apply(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    public static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function4<T1, T2, T3, T4, R> f14509b;

        public Array4Func(Function4<T1, T2, T3, T4, R> function4) {
            this.f14509b = function4;
        }

        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return this.f14509b.apply(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    public static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {

        /* renamed from: f  reason: collision with root package name */
        private final Function5<T1, T2, T3, T4, T5, R> f14510f;

        public Array5Func(Function5<T1, T2, T3, T4, T5, R> function5) {
            this.f14510f = function5;
        }

        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 5) {
                return this.f14510f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    public static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function6<T1, T2, T3, T4, T5, T6, R> f14511b;

        public Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
            this.f14511b = function6;
        }

        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 6) {
                return this.f14511b.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    public static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function7<T1, T2, T3, T4, T5, T6, T7, R> f14512b;

        public Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
            this.f14512b = function7;
        }

        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 7) {
                return this.f14512b.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    public static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f14513b;

        public Array8Func(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
            this.f14513b = function8;
        }

        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 8) {
                return this.f14513b.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    public static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {

        /* renamed from: b  reason: collision with root package name */
        public final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f14514b;

        public Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
            this.f14514b = function9;
        }

        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 9) {
                return this.f14514b.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    public static final class ArrayListCapacityCallable<T> implements Callable<List<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final int f14515b;

        public ArrayListCapacityCallable(int i11) {
            this.f14515b = i11;
        }

        public List<T> call() throws Exception {
            return new ArrayList(this.f14515b);
        }
    }

    public static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {

        /* renamed from: b  reason: collision with root package name */
        public final BooleanSupplier f14516b;

        public BooleanSupplierPredicateReverse(BooleanSupplier booleanSupplier) {
            this.f14516b = booleanSupplier;
        }

        public boolean test(T t11) throws Exception {
            return !this.f14516b.getAsBoolean();
        }
    }

    public static class BoundedConsumer implements Consumer<Subscription> {

        /* renamed from: b  reason: collision with root package name */
        public final int f14517b;

        public BoundedConsumer(int i11) {
            this.f14517b = i11;
        }

        public void accept(Subscription subscription) throws Exception {
            subscription.request((long) this.f14517b);
        }
    }

    public static final class CastToClass<T, U> implements Function<T, U> {

        /* renamed from: b  reason: collision with root package name */
        public final Class<U> f14518b;

        public CastToClass(Class<U> cls) {
            this.f14518b = cls;
        }

        public U apply(T t11) throws Exception {
            return this.f14518b.cast(t11);
        }
    }

    public static final class ClassFilter<T, U> implements Predicate<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Class<U> f14519b;

        public ClassFilter(Class<U> cls) {
            this.f14519b = cls;
        }

        public boolean test(T t11) throws Exception {
            return this.f14519b.isInstance(t11);
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
        public final T f14520b;

        public EqualsPredicate(T t11) {
            this.f14520b = t11;
        }

        public boolean test(T t11) throws Exception {
            return ObjectHelper.equals(t11, this.f14520b);
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
        public final Future<?> f14521b;

        public FutureAction(Future<?> future) {
            this.f14521b = future;
        }

        public void run() throws Exception {
            this.f14521b.get();
        }
    }

    public enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        public Set<Object> call() throws Exception {
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

    public static final class JustValue<T, U> implements Callable<U>, Function<T, U> {

        /* renamed from: b  reason: collision with root package name */
        public final U f14522b;

        public JustValue(U u11) {
            this.f14522b = u11;
        }

        public U apply(T t11) throws Exception {
            return this.f14522b;
        }

        public U call() throws Exception {
            return this.f14522b;
        }
    }

    public static final class ListSorter<T> implements Function<List<T>, List<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Comparator<? super T> f14523b;

        public ListSorter(Comparator<? super T> comparator) {
            this.f14523b = comparator;
        }

        public List<T> apply(List<T> list) {
            Collections.sort(list, this.f14523b);
            return list;
        }
    }

    public static final class MaxRequestSubscription implements Consumer<Subscription> {
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class NaturalObjectComparator implements Comparator<Object> {
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class NotificationOnComplete<T> implements Action {

        /* renamed from: b  reason: collision with root package name */
        public final Consumer<? super Notification<T>> f14524b;

        public NotificationOnComplete(Consumer<? super Notification<T>> consumer) {
            this.f14524b = consumer;
        }

        public void run() throws Exception {
            this.f14524b.accept(Notification.createOnComplete());
        }
    }

    public static final class NotificationOnError<T> implements Consumer<Throwable> {

        /* renamed from: b  reason: collision with root package name */
        public final Consumer<? super Notification<T>> f14525b;

        public NotificationOnError(Consumer<? super Notification<T>> consumer) {
            this.f14525b = consumer;
        }

        public void accept(Throwable th2) throws Exception {
            this.f14525b.accept(Notification.createOnError(th2));
        }
    }

    public static final class NotificationOnNext<T> implements Consumer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Consumer<? super Notification<T>> f14526b;

        public NotificationOnNext(Consumer<? super Notification<T>> consumer) {
            this.f14526b = consumer;
        }

        public void accept(T t11) throws Exception {
            this.f14526b.accept(Notification.createOnNext(t11));
        }
    }

    public static final class NullCallable implements Callable<Object> {
        public Object call() {
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
        public final TimeUnit f14527b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f14528c;

        public TimestampFunction(TimeUnit timeUnit, Scheduler scheduler) {
            this.f14527b = timeUnit;
            this.f14528c = scheduler;
        }

        public Timed<T> apply(T t11) throws Exception {
            return new Timed<>(t11, this.f14528c.now(this.f14527b), this.f14527b);
        }
    }

    public static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {
        private final Function<? super T, ? extends K> keySelector;

        public ToMapKeySelector(Function<? super T, ? extends K> function) {
            this.keySelector = function;
        }

        public void accept(Map<K, T> map, T t11) throws Exception {
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

        public void accept(Map<K, V> map, T t11) throws Exception {
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

        public void accept(Map<K, Collection<V>> map, T t11) throws Exception {
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

    public static <T> Predicate<T> alwaysFalse() {
        return f14503d;
    }

    public static <T> Predicate<T> alwaysTrue() {
        return f14502c;
    }

    public static <T> Consumer<T> boundedConsumer(int i11) {
        return new BoundedConsumer(i11);
    }

    public static <T, U> Function<T, U> castFunction(Class<U> cls) {
        return new CastToClass(cls);
    }

    public static <T> Callable<List<T>> createArrayList(int i11) {
        return new ArrayListCapacityCallable(i11);
    }

    public static <T> Callable<Set<T>> createHashSet() {
        return HashSetCallable.INSTANCE;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return f14501b;
    }

    public static <T> Predicate<T> equalsWith(T t11) {
        return new EqualsPredicate(t11);
    }

    public static Action futureAction(Future<?> future) {
        return new FutureAction(future);
    }

    public static <T> Function<T, T> identity() {
        return f14500a;
    }

    public static <T, U> Predicate<T> isInstanceOf(Class<U> cls) {
        return new ClassFilter(cls);
    }

    public static <T> Callable<T> justCallable(T t11) {
        return new JustValue(t11);
    }

    public static <T, U> Function<T, U> justFunction(U u11) {
        return new JustValue(u11);
    }

    public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }

    public static <T> Comparator<T> naturalComparator() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Comparator<T> naturalOrder() {
        return f14505f;
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

    public static <T> Callable<T> nullSupplier() {
        return f14504e;
    }

    public static <T> Predicate<T> predicateReverseFor(BooleanSupplier booleanSupplier) {
        return new BooleanSupplierPredicateReverse(booleanSupplier);
    }

    public static <T> Function<T, Timed<T>> timestampWith(TimeUnit timeUnit, Scheduler scheduler) {
        return new TimestampFunction(timeUnit, scheduler);
    }

    public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "f is null");
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

    public static <T1, T2, T3, R> Function<Object[], R> toFunction(Function3<T1, T2, T3, R> function3) {
        ObjectHelper.requireNonNull(function3, "f is null");
        return new Array3Func(function3);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(Function4<T1, T2, T3, T4, R> function4) {
        ObjectHelper.requireNonNull(function4, "f is null");
        return new Array4Func(function4);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(Function5<T1, T2, T3, T4, T5, R> function5) {
        ObjectHelper.requireNonNull(function5, "f is null");
        return new Array5Func(function5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        ObjectHelper.requireNonNull(function6, "f is null");
        return new Array6Func(function6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        ObjectHelper.requireNonNull(function7, "f is null");
        return new Array7Func(function7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        ObjectHelper.requireNonNull(function8, "f is null");
        return new Array8Func(function8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        ObjectHelper.requireNonNull(function9, "f is null");
        return new Array9Func(function9);
    }
}
