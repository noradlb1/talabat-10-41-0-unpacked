package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;
    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient Converter<B, A> reverse;

    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        public ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @CheckForNull
        public A correctedDoBackward(@CheckForNull C c11) {
            return this.first.correctedDoBackward(this.second.correctedDoBackward(c11));
        }

        @CheckForNull
        public C correctedDoForward(@CheckForNull A a11) {
            return this.second.correctedDoForward(this.first.correctedDoForward(a11));
        }

        public A doBackward(C c11) {
            throw new AssertionError();
        }

        public C doForward(A a11) {
            throw new AssertionError();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            if (!this.first.equals(converterComposition.first) || !this.second.equals(converterComposition.second)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    public static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        public A doBackward(B b11) {
            return this.backwardFunction.apply(b11);
        }

        public B doForward(A a11) {
            return this.forwardFunction.apply(a11);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            if (!this.forwardFunction.equals(functionBasedConverter.forwardFunction) || !this.backwardFunction.equals(functionBasedConverter.backwardFunction)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.backwardFunction + ")";
        }

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(function);
            this.backwardFunction = (Function) Preconditions.checkNotNull(function2);
        }
    }

    public static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter<?> INSTANCE = new IdentityConverter<>();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        public T doBackward(T t11) {
            return t11;
        }

        public T doForward(T t11) {
            return t11;
        }

        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    public static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        public ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        @CheckForNull
        public B correctedDoBackward(@CheckForNull A a11) {
            return this.original.correctedDoForward(a11);
        }

        @CheckForNull
        public A correctedDoForward(@CheckForNull B b11) {
            return this.original.correctedDoBackward(b11);
        }

        public B doBackward(A a11) {
            throw new AssertionError();
        }

        public A doForward(B b11) {
            throw new AssertionError();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    public Converter() {
        this(true);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    @CheckForNull
    private A unsafeDoBackward(@CheckForNull B b11) {
        return doBackward(NullnessCasts.uncheckedCastNullableTToT(b11));
    }

    @CheckForNull
    private B unsafeDoForward(@CheckForNull A a11) {
        return doForward(NullnessCasts.uncheckedCastNullableTToT(a11));
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @InlineMe(replacement = "this.convert(a)")
    @Deprecated
    public final B apply(A a11) {
        return convert(a11);
    }

    @CheckForNull
    public final B convert(@CheckForNull A a11) {
        return correctedDoForward(a11);
    }

    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>() {
            public Iterator<B> iterator() {
                return new Object() {
                    private final Iterator<? extends A> fromIterator;

                    {
                        this.fromIterator = iterable.iterator();
                    }

                    public /* synthetic */ void forEachRemaining(Consumer consumer) {
                        Iterator.CC.$default$forEachRemaining(this, consumer);
                    }

                    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                    }

                    public boolean hasNext() {
                        return this.fromIterator.hasNext();
                    }

                    public B next() {
                        return Converter.this.convert(this.fromIterator.next());
                    }

                    public void remove() {
                        this.fromIterator.remove();
                    }
                };
            }
        };
    }

    @CheckForNull
    public A correctedDoBackward(@CheckForNull B b11) {
        if (!this.handleNullAutomatically) {
            return unsafeDoBackward(b11);
        }
        if (b11 == null) {
            return null;
        }
        return Preconditions.checkNotNull(doBackward(b11));
    }

    @CheckForNull
    public B correctedDoForward(@CheckForNull A a11) {
        if (!this.handleNullAutomatically) {
            return unsafeDoForward(a11);
        }
        if (a11 == null) {
            return null;
        }
        return Preconditions.checkNotNull(doForward(a11));
    }

    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(converter));
    }

    @ForOverride
    public abstract A doBackward(B b11);

    @ForOverride
    public abstract B doForward(A a11);

    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @CheckReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.reverse = reverseConverter;
        return reverseConverter;
    }

    public Converter(boolean z11) {
        this.handleNullAutomatically = z11;
    }
}
