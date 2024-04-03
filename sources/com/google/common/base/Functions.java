package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Functions {

    public static class ConstantFunction<E> implements Function<Object, E>, Serializable {
        private static final long serialVersionUID = 0;
        @ParametricNullness
        private final E value;

        public ConstantFunction(@ParametricNullness E e11) {
            this.value = e11;
        }

        @ParametricNullness
        public E apply(@CheckForNull Object obj) {
            return this.value;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ConstantFunction) {
                return Objects.equal(this.value, ((ConstantFunction) obj).value);
            }
            return false;
        }

        public int hashCode() {
            E e11 = this.value;
            if (e11 == null) {
                return 0;
            }
            return e11.hashCode();
        }

        public String toString() {
            return "Functions.constant(" + this.value + ")";
        }
    }

    public static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        @ParametricNullness
        final V defaultValue;
        final Map<K, ? extends V> map;

        public ForMapWithDefault(Map<K, ? extends V> map2, @ParametricNullness V v11) {
            this.map = (Map) Preconditions.checkNotNull(map2);
            this.defaultValue = v11;
        }

        @ParametricNullness
        public V apply(@ParametricNullness K k11) {
            Object obj = this.map.get(k11);
            if (obj != null || this.map.containsKey(k11)) {
                return NullnessCasts.uncheckedCastNullableTToT(obj);
            }
            return this.defaultValue;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ForMapWithDefault)) {
                return false;
            }
            ForMapWithDefault forMapWithDefault = (ForMapWithDefault) obj;
            if (!this.map.equals(forMapWithDefault.map) || !Objects.equal(this.defaultValue, forMapWithDefault.defaultValue)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.map, this.defaultValue);
        }

        public String toString() {
            return "Functions.forMap(" + this.map + ", defaultValue=" + this.defaultValue + ")";
        }
    }

    public static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: f  reason: collision with root package name */
        private final Function<A, ? extends B> f44608f;

        /* renamed from: g  reason: collision with root package name */
        private final Function<B, C> f44609g;

        public FunctionComposition(Function<B, C> function, Function<A, ? extends B> function2) {
            this.f44609g = (Function) Preconditions.checkNotNull(function);
            this.f44608f = (Function) Preconditions.checkNotNull(function2);
        }

        @ParametricNullness
        public C apply(@ParametricNullness A a11) {
            return this.f44609g.apply(this.f44608f.apply(a11));
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof FunctionComposition)) {
                return false;
            }
            FunctionComposition functionComposition = (FunctionComposition) obj;
            if (!this.f44608f.equals(functionComposition.f44608f) || !this.f44609g.equals(functionComposition.f44609g)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f44608f.hashCode() ^ this.f44609g.hashCode();
        }

        public String toString() {
            return this.f44609g + "(" + this.f44608f + ")";
        }
    }

    public static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final Map<K, V> map;

        public FunctionForMapNoDefault(Map<K, V> map2) {
            this.map = (Map) Preconditions.checkNotNull(map2);
        }

        @ParametricNullness
        public V apply(@ParametricNullness K k11) {
            boolean z11;
            V v11 = this.map.get(k11);
            if (v11 != null || this.map.containsKey(k11)) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "Key '%s' not present in map", (Object) k11);
            return NullnessCasts.uncheckedCastNullableTToT(v11);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof FunctionForMapNoDefault) {
                return this.map.equals(((FunctionForMapNoDefault) obj).map);
            }
            return false;
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            return "Functions.forMap(" + this.map + ")";
        }
    }

    public enum IdentityFunction implements Function<Object, Object> {
        INSTANCE;

        @CheckForNull
        public Object apply(@CheckForNull Object obj) {
            return obj;
        }

        public String toString() {
            return "Functions.identity()";
        }
    }

    public static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final Predicate<T> predicate;

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof PredicateFunction) {
                return this.predicate.equals(((PredicateFunction) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            return "Functions.forPredicate(" + this.predicate + ")";
        }

        private PredicateFunction(Predicate<T> predicate2) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate2);
        }

        public Boolean apply(@ParametricNullness T t11) {
            return Boolean.valueOf(this.predicate.apply(t11));
        }
    }

    public static class SupplierFunction<F, T> implements Function<F, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<T> supplier;

        @ParametricNullness
        public T apply(@ParametricNullness F f11) {
            return this.supplier.get();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SupplierFunction) {
                return this.supplier.equals(((SupplierFunction) obj).supplier);
            }
            return false;
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public String toString() {
            return "Functions.forSupplier(" + this.supplier + ")";
        }

        private SupplierFunction(Supplier<T> supplier2) {
            this.supplier = (Supplier) Preconditions.checkNotNull(supplier2);
        }
    }

    public enum ToStringFunction implements Function<Object, String> {
        INSTANCE;

        public String toString() {
            return "Functions.toStringFunction()";
        }

        public String apply(Object obj) {
            Preconditions.checkNotNull(obj);
            return obj.toString();
        }
    }

    private Functions() {
    }

    public static <A, B, C> Function<A, C> compose(Function<B, C> function, Function<A, ? extends B> function2) {
        return new FunctionComposition(function, function2);
    }

    public static <E> Function<Object, E> constant(@ParametricNullness E e11) {
        return new ConstantFunction(e11);
    }

    public static <K, V> Function<K, V> forMap(Map<K, V> map) {
        return new FunctionForMapNoDefault(map);
    }

    public static <T> Function<T, Boolean> forPredicate(Predicate<T> predicate) {
        return new PredicateFunction(predicate);
    }

    public static <F, T> Function<F, T> forSupplier(Supplier<T> supplier) {
        return new SupplierFunction(supplier);
    }

    public static <E> Function<E, E> identity() {
        return IdentityFunction.INSTANCE;
    }

    public static Function<Object, String> toStringFunction() {
        return ToStringFunction.INSTANCE;
    }

    public static <K, V> Function<K, V> forMap(Map<K, ? extends V> map, @ParametricNullness V v11) {
        return new ForMapWithDefault(map, v11);
    }
}
