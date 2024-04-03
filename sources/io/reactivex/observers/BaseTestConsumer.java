package io.reactivex.observers;

import io.reactivex.Notification;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f18642b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public final List<T> f18643c = new VolatileSizeArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final List<Throwable> f18644d = new VolatileSizeArrayList();

    /* renamed from: e  reason: collision with root package name */
    public long f18645e;

    /* renamed from: f  reason: collision with root package name */
    public Thread f18646f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18647g;

    /* renamed from: h  reason: collision with root package name */
    public int f18648h;

    /* renamed from: i  reason: collision with root package name */
    public int f18649i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f18650j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f18651k;

    public enum TestWaitStrategy implements Runnable {
        SPIN {
            public void run() {
            }
        },
        YIELD {
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS {
            public void run() {
                TestWaitStrategy.a(1);
            }
        },
        SLEEP_10MS {
            public void run() {
                TestWaitStrategy.a(10);
            }
        },
        SLEEP_100MS {
            public void run() {
                TestWaitStrategy.a(100);
            }
        },
        SLEEP_1000MS {
            public void run() {
                TestWaitStrategy.a(1000);
            }
        };

        public static void a(int i11) {
            try {
                Thread.sleep((long) i11);
            } catch (InterruptedException e11) {
                throw new RuntimeException(e11);
            }
        }

        public abstract void run();
    }

    public static String valueAndClass(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ")";
    }

    public final AssertionError a(String str) {
        StringBuilder sb2 = new StringBuilder(str.length() + 64);
        sb2.append(str);
        sb2.append(" (");
        sb2.append("latch = ");
        sb2.append(this.f18642b.getCount());
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append("values = ");
        sb2.append(this.f18643c.size());
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append("errors = ");
        sb2.append(this.f18644d.size());
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append("completions = ");
        sb2.append(this.f18645e);
        if (this.f18651k) {
            sb2.append(", timeout!");
        }
        if (isDisposed()) {
            sb2.append(", disposed!");
        }
        CharSequence charSequence = this.f18650j;
        if (charSequence != null) {
            sb2.append(", tag = ");
            sb2.append(charSequence);
        }
        sb2.append(')');
        AssertionError assertionError = new AssertionError(sb2.toString());
        if (!this.f18644d.isEmpty()) {
            if (this.f18644d.size() == 1) {
                assertionError.initCause(this.f18644d.get(0));
            } else {
                assertionError.initCause(new CompositeException((Iterable<? extends Throwable>) this.f18644d));
            }
        }
        return assertionError;
    }

    public final U assertComplete() {
        long j11 = this.f18645e;
        if (j11 == 0) {
            throw a("Not completed");
        } else if (j11 <= 1) {
            return this;
        } else {
            throw a("Multiple completions: " + j11);
        }
    }

    public final U assertEmpty() {
        return assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U assertError(Throwable th2) {
        return assertError((Predicate<Throwable>) Functions.equalsWith(th2));
    }

    public final U assertErrorMessage(String str) {
        int size = this.f18644d.size();
        if (size == 0) {
            throw a("No errors");
        } else if (size == 1) {
            String message = this.f18644d.get(0).getMessage();
            if (ObjectHelper.equals(str, message)) {
                return this;
            }
            throw a("Error message differs; exptected: " + str + " but was: " + message);
        } else {
            throw a("Multiple errors");
        }
    }

    public final U assertFailure(Class<? extends Throwable> cls, T... tArr) {
        return assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    public final U assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        return assertSubscribed().assertValues(tArr).assertError(cls).assertErrorMessage(str).assertNotComplete();
    }

    public final U assertNever(T t11) {
        int size = this.f18643c.size();
        int i11 = 0;
        while (i11 < size) {
            if (!ObjectHelper.equals(this.f18643c.get(i11), t11)) {
                i11++;
            } else {
                throw a("Value at position " + i11 + " is equal to " + valueAndClass(t11) + "; Expected them to be different");
            }
        }
        return this;
    }

    public final U assertNoErrors() {
        if (this.f18644d.size() == 0) {
            return this;
        }
        throw a("Error(s) present: " + this.f18644d);
    }

    public final U assertNoTimeout() {
        if (!this.f18651k) {
            return this;
        }
        throw a("Timeout?!");
    }

    public final U assertNoValues() {
        return assertValueCount(0);
    }

    public final U assertNotComplete() {
        long j11 = this.f18645e;
        int i11 = (j11 > 1 ? 1 : (j11 == 1 ? 0 : -1));
        if (i11 == 0) {
            throw a("Completed!");
        } else if (i11 <= 0) {
            return this;
        } else {
            throw a("Multiple completions: " + j11);
        }
    }

    public abstract U assertNotSubscribed();

    public final U assertNotTerminated() {
        if (this.f18642b.getCount() != 0) {
            return this;
        }
        throw a("Subscriber terminated!");
    }

    public final U assertResult(T... tArr) {
        return assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    public abstract U assertSubscribed();

    public final U assertTerminated() {
        if (this.f18642b.getCount() == 0) {
            long j11 = this.f18645e;
            if (j11 <= 1) {
                int size = this.f18644d.size();
                if (size > 1) {
                    throw a("Terminated with multiple errors: " + size);
                } else if (j11 == 0 || size == 0) {
                    return this;
                } else {
                    throw a("Terminated with multiple completions and errors: " + j11);
                }
            } else {
                throw a("Terminated with multiple completions: " + j11);
            }
        } else {
            throw a("Subscriber still running!");
        }
    }

    public final U assertTimeout() {
        if (this.f18651k) {
            return this;
        }
        throw a("No timeout?!");
    }

    public final U assertValue(T t11) {
        if (this.f18643c.size() == 1) {
            T t12 = this.f18643c.get(0);
            if (ObjectHelper.equals(t11, t12)) {
                return this;
            }
            throw a("expected: " + valueAndClass(t11) + " but was: " + valueAndClass(t12));
        }
        throw a("expected: " + valueAndClass(t11) + " but was: " + this.f18643c);
    }

    public final U assertValueAt(int i11, T t11) {
        int size = this.f18643c.size();
        if (size == 0) {
            throw a("No values");
        } else if (i11 < size) {
            T t12 = this.f18643c.get(i11);
            if (ObjectHelper.equals(t11, t12)) {
                return this;
            }
            throw a("expected: " + valueAndClass(t11) + " but was: " + valueAndClass(t12));
        } else {
            throw a("Invalid index: " + i11);
        }
    }

    public final U assertValueCount(int i11) {
        int size = this.f18643c.size();
        if (size == i11) {
            return this;
        }
        throw a("Value counts differ; expected: " + i11 + " but was: " + size);
    }

    public final U assertValueSequence(Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> it = this.f18643c.iterator();
        Iterator<? extends T> it2 = iterable.iterator();
        int i11 = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (hasNext2 && hasNext) {
                Object next = it2.next();
                T next2 = it.next();
                if (ObjectHelper.equals(next, next2)) {
                    i11++;
                } else {
                    throw a("Values at position " + i11 + " differ; expected: " + valueAndClass(next) + " but was: " + valueAndClass(next2));
                }
            }
        }
        if (hasNext2) {
            throw a("More values received than expected (" + i11 + ")");
        } else if (!hasNext) {
            return this;
        } else {
            throw a("Fewer values received than expected (" + i11 + ")");
        }
    }

    public final U assertValueSequenceOnly(Iterable<? extends T> iterable) {
        return assertSubscribed().assertValueSequence(iterable).assertNoErrors().assertNotComplete();
    }

    public final U assertValueSet(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            assertNoValues();
            return this;
        }
        for (T next : this.f18643c) {
            if (!collection.contains(next)) {
                throw a("Value not in the expected collection: " + valueAndClass(next));
            }
        }
        return this;
    }

    public final U assertValueSetOnly(Collection<? extends T> collection) {
        return assertSubscribed().assertValueSet(collection).assertNoErrors().assertNotComplete();
    }

    public final U assertValues(T... tArr) {
        int size = this.f18643c.size();
        if (size == tArr.length) {
            int i11 = 0;
            while (i11 < size) {
                T t11 = this.f18643c.get(i11);
                T t12 = tArr[i11];
                if (ObjectHelper.equals(t12, t11)) {
                    i11++;
                } else {
                    throw a("Values at position " + i11 + " differ; expected: " + valueAndClass(t12) + " but was: " + valueAndClass(t11));
                }
            }
            return this;
        }
        throw a("Value count differs; expected: " + tArr.length + " " + Arrays.toString(tArr) + " but was: " + size + " " + this.f18643c);
    }

    public final U assertValuesOnly(T... tArr) {
        return assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    public final U await() throws InterruptedException {
        if (this.f18642b.getCount() == 0) {
            return this;
        }
        this.f18642b.await();
        return this;
    }

    public final U awaitCount(int i11) {
        return awaitCount(i11, TestWaitStrategy.SLEEP_10MS, 5000);
    }

    public final U awaitDone(long j11, TimeUnit timeUnit) {
        try {
            if (!this.f18642b.await(j11, timeUnit)) {
                this.f18651k = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e11) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e11);
        }
    }

    public final boolean awaitTerminalEvent() {
        try {
            await();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U clearTimeout() {
        this.f18651k = false;
        return this;
    }

    public final long completions() {
        return this.f18645e;
    }

    public final int errorCount() {
        return this.f18644d.size();
    }

    public final List<Throwable> errors() {
        return this.f18644d;
    }

    public final List<List<Object>> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(values());
        arrayList.add(errors());
        ArrayList arrayList2 = new ArrayList();
        for (long j11 = 0; j11 < this.f18645e; j11++) {
            arrayList2.add(Notification.createOnComplete());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final boolean isTerminated() {
        return this.f18642b.getCount() == 0;
    }

    public final boolean isTimeout() {
        return this.f18651k;
    }

    public final Thread lastThread() {
        return this.f18646f;
    }

    public final int valueCount() {
        return this.f18643c.size();
    }

    public final List<T> values() {
        return this.f18643c;
    }

    public final U withTag(CharSequence charSequence) {
        this.f18650j = charSequence;
        return this;
    }

    public final U assertError(Class<? extends Throwable> cls) {
        return assertError((Predicate<Throwable>) Functions.isInstanceOf(cls));
    }

    public final U awaitCount(int i11, Runnable runnable) {
        return awaitCount(i11, runnable, 5000);
    }

    public final U assertError(Predicate<Throwable> predicate) {
        boolean z11;
        int size = this.f18644d.size();
        if (size != 0) {
            Iterator<Throwable> it = this.f18644d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z11 = false;
                    break;
                }
                try {
                    if (predicate.test(it.next())) {
                        z11 = true;
                        break;
                    }
                } catch (Exception e11) {
                    throw ExceptionHelper.wrapOrThrow(e11);
                }
            }
            if (!z11) {
                throw a("Error not present");
            } else if (size == 1) {
                return this;
            } else {
                throw a("Error present but other errors as well");
            }
        } else {
            throw a("No errors");
        }
    }

    public final boolean await(long j11, TimeUnit timeUnit) throws InterruptedException {
        boolean z11 = this.f18642b.getCount() == 0 || this.f18642b.await(j11, timeUnit);
        this.f18651k = !z11;
        return z11;
    }

    public final U awaitCount(int i11, Runnable runnable, long j11) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (j11 <= 0 || System.currentTimeMillis() - currentTimeMillis < j11) {
                if (this.f18642b.getCount() == 0 || this.f18643c.size() >= i11) {
                    break;
                }
                runnable.run();
            } else {
                this.f18651k = true;
                break;
            }
        }
        return this;
    }

    public final boolean awaitTerminalEvent(long j11, TimeUnit timeUnit) {
        try {
            return await(j11, timeUnit);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U assertFailure(Predicate<Throwable> predicate, T... tArr) {
        return assertSubscribed().assertValues(tArr).assertError(predicate).assertNotComplete();
    }

    public final U assertNever(Predicate<? super T> predicate) {
        int size = this.f18643c.size();
        int i11 = 0;
        while (i11 < size) {
            try {
                if (!predicate.test(this.f18643c.get(i11))) {
                    i11++;
                } else {
                    throw a("Value at position " + i11 + " matches predicate " + predicate.toString() + ", which was not expected.");
                }
            } catch (Exception e11) {
                throw ExceptionHelper.wrapOrThrow(e11);
            }
        }
        return this;
    }

    public final U assertValue(Predicate<T> predicate) {
        assertValueAt(0, predicate);
        if (this.f18643c.size() <= 1) {
            return this;
        }
        throw a("Value present but other values as well");
    }

    public final U assertValueAt(int i11, Predicate<T> predicate) {
        if (this.f18643c.size() == 0) {
            throw a("No values");
        } else if (i11 < this.f18643c.size()) {
            try {
                if (predicate.test(this.f18643c.get(i11))) {
                    return this;
                }
                throw a("Value not present");
            } catch (Exception e11) {
                throw ExceptionHelper.wrapOrThrow(e11);
            }
        } else {
            throw a("Invalid index: " + i11);
        }
    }
}
