package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.VolatileSizeArrayList;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> {

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f23203b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public final List<T> f23204c = new VolatileSizeArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final List<Throwable> f23205d = new VolatileSizeArrayList();

    /* renamed from: e  reason: collision with root package name */
    public long f23206e;

    /* renamed from: f  reason: collision with root package name */
    public Thread f23207f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23208g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f23209h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23210i;

    @NonNull
    public static String valueAndClass(@Nullable Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ")";
    }

    @NonNull
    public abstract U a();

    @NonNull
    public final U assertComplete() {
        long j11 = this.f23206e;
        if (j11 == 0) {
            throw b("Not completed");
        } else if (j11 <= 1) {
            return this;
        } else {
            throw b("Multiple completions: " + j11);
        }
    }

    @NonNull
    public final U assertEmpty() {
        return a().assertNoValues().assertNoErrors().assertNotComplete();
    }

    @NonNull
    public final U assertError(@NonNull Throwable th2) {
        return assertError(Functions.equalsWith(th2), true);
    }

    @NonNull
    @SafeVarargs
    public final U assertFailure(@NonNull Class<? extends Throwable> cls, @NonNull T... tArr) {
        return a().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    @NonNull
    public final U assertNoErrors() {
        if (this.f23205d.size() == 0) {
            return this;
        }
        throw b("Error(s) present: " + this.f23205d);
    }

    @NonNull
    public final U assertNoValues() {
        return assertValueCount(0);
    }

    @NonNull
    public final U assertNotComplete() {
        long j11 = this.f23206e;
        int i11 = (j11 > 1 ? 1 : (j11 == 1 ? 0 : -1));
        if (i11 == 0) {
            throw b("Completed!");
        } else if (i11 <= 0) {
            return this;
        } else {
            throw b("Multiple completions: " + j11);
        }
    }

    @NonNull
    @SafeVarargs
    public final U assertResult(@NonNull T... tArr) {
        return a().assertValues(tArr).assertNoErrors().assertComplete();
    }

    @NonNull
    public final U assertValue(@NonNull T t11) {
        if (this.f23204c.size() == 1) {
            T t12 = this.f23204c.get(0);
            if (Objects.equals(t11, t12)) {
                return this;
            }
            throw b("\nexpected: " + valueAndClass(t11) + "\ngot: " + valueAndClass(t12));
        }
        throw b("\nexpected: " + valueAndClass(t11) + "\ngot: " + this.f23204c);
    }

    @NonNull
    public final U assertValueAt(int i11, @NonNull T t11) {
        int size = this.f23204c.size();
        if (size == 0) {
            throw b("No values");
        } else if (i11 < 0 || i11 >= size) {
            throw b("Index " + i11 + " is out of range [0, " + size + ")");
        } else {
            T t12 = this.f23204c.get(i11);
            if (Objects.equals(t11, t12)) {
                return this;
            }
            throw b("\nexpected: " + valueAndClass(t11) + "\ngot: " + valueAndClass(t12) + "; Value at position " + i11 + " differ");
        }
    }

    @NonNull
    public final U assertValueCount(int i11) {
        int size = this.f23204c.size();
        if (size == i11) {
            return this;
        }
        throw b("\nexpected: " + i11 + "\ngot: " + size + "; Value counts differ");
    }

    @NonNull
    public final U assertValueSequence(@NonNull Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> it = this.f23204c.iterator();
        Iterator<? extends T> it2 = iterable.iterator();
        int i11 = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (hasNext2 && hasNext) {
                Object next = it2.next();
                T next2 = it.next();
                if (Objects.equals(next, next2)) {
                    i11++;
                } else {
                    throw b("\nexpected: " + valueAndClass(next) + "\ngot: " + valueAndClass(next2) + "; Value at position " + i11 + " differ");
                }
            }
        }
        if (hasNext2) {
            throw b("More values received than expected (" + i11 + ")");
        } else if (!hasNext) {
            return this;
        } else {
            throw b("Fewer values received than expected (" + i11 + ")");
        }
    }

    @NonNull
    @SafeVarargs
    public final U assertValues(@NonNull T... tArr) {
        int size = this.f23204c.size();
        if (size == tArr.length) {
            int i11 = 0;
            while (i11 < size) {
                T t11 = this.f23204c.get(i11);
                T t12 = tArr[i11];
                if (Objects.equals(t12, t11)) {
                    i11++;
                } else {
                    throw b("\nexpected: " + valueAndClass(t12) + "\ngot: " + valueAndClass(t11) + "; Value at position " + i11 + " differ");
                }
            }
            return this;
        }
        throw b("\nexpected: " + tArr.length + " " + Arrays.toString(tArr) + "\ngot: " + size + " " + this.f23204c + "; Value count differs");
    }

    @NonNull
    @SafeVarargs
    public final U assertValuesOnly(@NonNull T... tArr) {
        return a().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    @NonNull
    public final U await() throws InterruptedException {
        if (this.f23203b.getCount() == 0) {
            return this;
        }
        this.f23203b.await();
        return this;
    }

    @NonNull
    public final U awaitCount(int i11) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - currentTimeMillis < 5000) {
                if (this.f23203b.getCount() == 0 || this.f23204c.size() >= i11) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e11) {
                    throw new RuntimeException(e11);
                }
            } else {
                this.f23210i = true;
                break;
            }
        }
        return this;
    }

    @NonNull
    public final U awaitDone(long j11, @NonNull TimeUnit timeUnit) {
        try {
            if (!this.f23203b.await(j11, timeUnit)) {
                this.f23210i = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e11) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e11);
        }
    }

    @NonNull
    public final AssertionError b(@NonNull String str) {
        StringBuilder sb2 = new StringBuilder(str.length() + 64);
        sb2.append(str);
        sb2.append(" (");
        sb2.append("latch = ");
        sb2.append(this.f23203b.getCount());
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append("values = ");
        sb2.append(this.f23204c.size());
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append("errors = ");
        sb2.append(this.f23205d.size());
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append("completions = ");
        sb2.append(this.f23206e);
        if (this.f23210i) {
            sb2.append(", timeout!");
        }
        if (isDisposed()) {
            sb2.append(", disposed!");
        }
        CharSequence charSequence = this.f23209h;
        if (charSequence != null) {
            sb2.append(", tag = ");
            sb2.append(charSequence);
        }
        sb2.append(')');
        AssertionError assertionError = new AssertionError(sb2.toString());
        if (!this.f23205d.isEmpty()) {
            if (this.f23205d.size() == 1) {
                assertionError.initCause(this.f23205d.get(0));
            } else {
                assertionError.initCause(new CompositeException((Iterable<? extends Throwable>) this.f23205d));
            }
        }
        return assertionError;
    }

    public abstract void dispose();

    public abstract boolean isDisposed();

    @NonNull
    public final List<T> values() {
        return this.f23204c;
    }

    @NonNull
    public final U withTag(@Nullable CharSequence charSequence) {
        this.f23209h = charSequence;
        return this;
    }

    @NonNull
    public final U assertError(@NonNull Class<? extends Throwable> cls) {
        return assertError(Functions.isInstanceOf(cls), true);
    }

    @NonNull
    public final U assertError(@NonNull Predicate<Throwable> predicate) {
        return assertError(predicate, false);
    }

    public final boolean await(long j11, @NonNull TimeUnit timeUnit) throws InterruptedException {
        boolean z11 = this.f23203b.getCount() == 0 || this.f23203b.await(j11, timeUnit);
        this.f23210i = !z11;
        return z11;
    }

    @NonNull
    private U assertError(@NonNull Predicate<Throwable> predicate, boolean z11) {
        boolean z12;
        int size = this.f23205d.size();
        if (size != 0) {
            Iterator<Throwable> it = this.f23205d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z12 = false;
                    break;
                }
                try {
                    if (predicate.test(it.next())) {
                        z12 = true;
                        break;
                    }
                } catch (Throwable th2) {
                    throw ExceptionHelper.wrapOrThrow(th2);
                }
            }
            if (z12) {
                if (size == 1) {
                    return this;
                }
                if (z11) {
                    throw b("Error present but other errors as well");
                }
                throw b("One error passed the predicate but other errors are present as well");
            } else if (z11) {
                throw b("Error not present");
            } else {
                throw b("No error(s) passed the predicate");
            }
        } else {
            throw b("No errors");
        }
    }

    @NonNull
    public final U assertValue(@NonNull Predicate<T> predicate) {
        assertValueAt(0, predicate);
        if (this.f23204c.size() <= 1) {
            return this;
        }
        throw b("The first value passed the predicate but this consumer received more than one value");
    }

    @NonNull
    public final U assertValueAt(int i11, @NonNull Predicate<T> predicate) {
        int size = this.f23204c.size();
        if (size == 0) {
            throw b("No values");
        } else if (i11 < 0 || i11 >= size) {
            throw b("Index " + i11 + " is out of range [0, " + size + ")");
        } else {
            T t11 = this.f23204c.get(i11);
            try {
                if (predicate.test(t11)) {
                    return this;
                }
                throw b("Value " + valueAndClass(t11) + " at position " + i11 + " did not pass the predicate");
            } catch (Throwable th2) {
                throw ExceptionHelper.wrapOrThrow(th2);
            }
        }
    }
}
