package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Suppliers {

    @VisibleForTesting
    public static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;
        final long durationNanos;
        volatile transient long expirationNanos;
        @CheckForNull
        volatile transient T value;

        public ExpiringMemoizingSupplier(Supplier<T> supplier, long j11, TimeUnit timeUnit) {
            boolean z11;
            this.delegate = (Supplier) Preconditions.checkNotNull(supplier);
            this.durationNanos = timeUnit.toNanos(j11);
            if (j11 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "duration (%s %s) must be > 0", j11, (Object) timeUnit);
        }

        @ParametricNullness
        public T get() {
            long j11 = this.expirationNanos;
            long nanoTime = System.nanoTime();
            if (j11 == 0 || nanoTime - j11 >= 0) {
                synchronized (this) {
                    if (j11 == this.expirationNanos) {
                        T t11 = this.delegate.get();
                        this.value = t11;
                        long j12 = nanoTime + this.durationNanos;
                        if (j12 == 0) {
                            j12 = 1;
                        }
                        this.expirationNanos = j12;
                        return t11;
                    }
                }
            }
            return NullnessCasts.uncheckedCastNullableTToT(this.value);
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.durationNanos + ", NANOS)";
        }
    }

    @VisibleForTesting
    public static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;
        volatile transient boolean initialized;
        @CheckForNull
        transient T value;

        public MemoizingSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @ParametricNullness
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t11 = this.delegate.get();
                        this.value = t11;
                        this.initialized = true;
                        return t11;
                    }
                }
            }
            return NullnessCasts.uncheckedCastNullableTToT(this.value);
        }

        public String toString() {
            Object obj;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (this.initialized) {
                obj = "<supplier that returned " + this.value + ">";
            } else {
                obj = this.delegate;
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    @VisibleForTesting
    public static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {
        private static final Supplier<Void> SUCCESSFULLY_COMPUTED = new a();
        private volatile Supplier<T> delegate;
        @CheckForNull
        private T value;

        public NonSerializableMemoizingSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) Preconditions.checkNotNull(supplier);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Void lambda$static$0() {
            throw new IllegalStateException();
        }

        @ParametricNullness
        public T get() {
            Supplier<T> supplier = this.delegate;
            Supplier<Void> supplier2 = SUCCESSFULLY_COMPUTED;
            if (supplier != supplier2) {
                synchronized (this) {
                    if (this.delegate != supplier2) {
                        T t11 = this.delegate.get();
                        this.value = t11;
                        this.delegate = supplier2;
                        return t11;
                    }
                }
            }
            return NullnessCasts.uncheckedCastNullableTToT(this.value);
        }

        public String toString() {
            Object obj = this.delegate;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (obj == SUCCESSFULLY_COMPUTED) {
                obj = "<supplier that returned " + this.value + ">";
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<? super F, T> function;
        final Supplier<F> supplier;

        public SupplierComposition(Function<? super F, T> function2, Supplier<F> supplier2) {
            this.function = (Function) Preconditions.checkNotNull(function2);
            this.supplier = (Supplier) Preconditions.checkNotNull(supplier2);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof SupplierComposition)) {
                return false;
            }
            SupplierComposition supplierComposition = (SupplierComposition) obj;
            if (!this.function.equals(supplierComposition.function) || !this.supplier.equals(supplierComposition.supplier)) {
                return false;
            }
            return true;
        }

        @ParametricNullness
        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public int hashCode() {
            return Objects.hashCode(this.function, this.supplier);
        }

        public String toString() {
            return "Suppliers.compose(" + this.function + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.supplier + ")";
        }
    }

    public interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    public enum SupplierFunctionImpl implements SupplierFunction<Object> {
        INSTANCE;

        public String toString() {
            return "Suppliers.supplierFunction()";
        }

        @CheckForNull
        public Object apply(Supplier<Object> supplier) {
            return supplier.get();
        }
    }

    public static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        @ParametricNullness
        final T instance;

        public SupplierOfInstance(@ParametricNullness T t11) {
            this.instance = t11;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return Objects.equal(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @ParametricNullness
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return Objects.hashCode(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    public static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;

        public ThreadSafeSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @ParametricNullness
        public T get() {
            T t11;
            synchronized (this.delegate) {
                t11 = this.delegate.get();
            }
            return t11;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
        }
    }

    private Suppliers() {
    }

    public static <F, T> Supplier<T> compose(Function<? super F, T> function, Supplier<F> supplier) {
        return new SupplierComposition(function, supplier);
    }

    public static <T> Supplier<T> memoize(Supplier<T> supplier) {
        if ((supplier instanceof NonSerializableMemoizingSupplier) || (supplier instanceof MemoizingSupplier)) {
            return supplier;
        }
        if (supplier instanceof Serializable) {
            return new MemoizingSupplier(supplier);
        }
        return new NonSerializableMemoizingSupplier(supplier);
    }

    public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> supplier, long j11, TimeUnit timeUnit) {
        return new ExpiringMemoizingSupplier(supplier, j11, timeUnit);
    }

    public static <T> Supplier<T> ofInstance(@ParametricNullness T t11) {
        return new SupplierOfInstance(t11);
    }

    public static <T> Function<Supplier<T>, T> supplierFunction() {
        return SupplierFunctionImpl.INSTANCE;
    }

    public static <T> Supplier<T> synchronizedSupplier(Supplier<T> supplier) {
        return new ThreadSafeSupplier(supplier);
    }
}
