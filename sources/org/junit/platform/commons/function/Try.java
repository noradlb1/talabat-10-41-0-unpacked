package org.junit.platform.commons.function;

import com.facebook.internal.NativeProtocol;
import com.newrelic.agent.android.agentdata.HexAttribute;
import i30.a;
import i30.b;
import j$.util.Optional;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;

@API(since = "1.4", status = API.Status.MAINTAINED)
public abstract class Try<V> {

    public static class Failure<V> extends Try<V> {
        private final Exception cause;

        public Failure(Exception exc) {
            super();
            this.cause = exc;
        }

        private <U> Try<U> uncheckedCast() {
            return this;
        }

        public <U> Try<U> andThen(Function<V, Try<U>> function) {
            return uncheckedCast();
        }

        public <U> Try<U> andThenTry(Transformer<V, U> transformer) {
            return uncheckedCast();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.cause, ((Failure) obj).cause);
        }

        public V get() throws Exception {
            throw this.cause;
        }

        public <E extends Exception> V getOrThrow(Function<? super Exception, E> function) throws Exception {
            Object unused = Try.checkNotNull(function, "exceptionTransformer");
            throw ((Exception) function.apply(this.cause));
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.cause});
        }

        public Try<V> ifFailure(Consumer<Exception> consumer) {
            Object unused = Try.checkNotNull(consumer, "causeConsumer");
            consumer.accept(this.cause);
            return this;
        }

        public Try<V> ifSuccess(Consumer<V> consumer) {
            return this;
        }

        public Try<V> orElse(Supplier<Try<V>> supplier) {
            Object unused = Try.checkNotNull(supplier, "supplier");
            Objects.requireNonNull(supplier);
            return Try.of(new b(supplier));
        }

        public Try<V> orElseTry(Callable<V> callable) {
            Object unused = Try.checkNotNull(callable, NativeProtocol.WEB_DIALOG_ACTION);
            return Try.call(callable);
        }

        public Optional<V> toOptional() {
            return Optional.empty();
        }
    }

    public static class Success<V> extends Try<V> {
        private final V value;

        public Success(V v11) {
            super();
            this.value = v11;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Try lambda$andThen$1(Function function) throws Exception {
            return (Try) function.apply(this.value);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$andThenTry$0(Transformer transformer) throws Exception {
            return transformer.apply(this.value);
        }

        public <U> Try<U> andThen(Function<V, Try<U>> function) {
            Object unused = Try.checkNotNull(function, "function");
            return Try.of(new a(this, function));
        }

        public <U> Try<U> andThenTry(Transformer<V, U> transformer) {
            Object unused = Try.checkNotNull(transformer, "transformer");
            return Try.call(new b(this, transformer));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.value, ((Success) obj).value);
        }

        public V get() {
            return this.value;
        }

        public <E extends Exception> V getOrThrow(Function<? super Exception, E> function) {
            return this.value;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.value});
        }

        public Try<V> ifFailure(Consumer<Exception> consumer) {
            return this;
        }

        public Try<V> ifSuccess(Consumer<V> consumer) {
            Object unused = Try.checkNotNull(consumer, "valueConsumer");
            consumer.accept(this.value);
            return this;
        }

        public Try<V> orElse(Supplier<Try<V>> supplier) {
            return this;
        }

        public Try<V> orElseTry(Callable<V> callable) {
            return this;
        }

        public Optional<V> toOptional() {
            return Optional.ofNullable(this.value);
        }
    }

    @FunctionalInterface
    public interface Transformer<S, T> {
        T apply(S s11) throws Exception;
    }

    public static <V> Try<V> call(Callable<V> callable) {
        checkNotNull(callable, NativeProtocol.WEB_DIALOG_ACTION);
        return of(new a(callable));
    }

    /* access modifiers changed from: private */
    public static <T> T checkNotNull(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new JUnitException(str + " must not be null");
    }

    public static <V> Try<V> failure(Exception exc) {
        return new Failure((Exception) checkNotNull(exc, HexAttribute.HEX_ATTR_CAUSE));
    }

    /* access modifiers changed from: private */
    public static <V> Try<V> of(Callable<Try<V>> callable) {
        try {
            return callable.call();
        } catch (Exception e11) {
            return failure(e11);
        }
    }

    public static <V> Try<V> success(V v11) {
        return new Success(v11);
    }

    public abstract <U> Try<U> andThen(Function<V, Try<U>> function);

    public abstract <U> Try<U> andThenTry(Transformer<V, U> transformer);

    public abstract V get() throws Exception;

    public abstract <E extends Exception> V getOrThrow(Function<? super Exception, E> function) throws Exception;

    public abstract Try<V> ifFailure(Consumer<Exception> consumer);

    public abstract Try<V> ifSuccess(Consumer<V> consumer);

    public abstract Try<V> orElse(Supplier<Try<V>> supplier);

    public abstract Try<V> orElseTry(Callable<V> callable);

    public abstract Optional<V> toOptional();

    private Try() {
    }
}
