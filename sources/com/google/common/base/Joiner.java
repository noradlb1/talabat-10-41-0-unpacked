package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public class Joiner {
    /* access modifiers changed from: private */
    public final String separator;

    public static final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a11, Map<?, ?> map) throws IOException {
            return appendTo(a11, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public String join(Map<?, ?> map) {
            return join((Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public MapJoiner useForNull(String str) {
            return new MapJoiner(this.joiner.useForNull(str), this.keyValueSeparator);
        }

        private MapJoiner(Joiner joiner2, String str) {
            this.joiner = joiner2;
            this.keyValueSeparator = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public StringBuilder appendTo(StringBuilder sb2, Map<?, ?> map) {
            return appendTo(sb2, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public String join(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return join(iterable.iterator());
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a11, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return appendTo(a11, iterable.iterator());
        }

        public String join(Iterator<? extends Map.Entry<?, ?>> it) {
            return appendTo(new StringBuilder(), it).toString();
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a11, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            Preconditions.checkNotNull(a11);
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                a11.append(this.joiner.toString(entry.getKey()));
                a11.append(this.keyValueSeparator);
                a11.append(this.joiner.toString(entry.getValue()));
                while (it.hasNext()) {
                    a11.append(this.joiner.separator);
                    Map.Entry entry2 = (Map.Entry) it.next();
                    a11.append(this.joiner.toString(entry2.getKey()));
                    a11.append(this.keyValueSeparator);
                    a11.append(this.joiner.toString(entry2.getValue()));
                }
            }
            return a11;
        }

        @CanIgnoreReturnValue
        public StringBuilder appendTo(StringBuilder sb2, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return appendTo(sb2, iterable.iterator());
        }

        @CanIgnoreReturnValue
        public StringBuilder appendTo(StringBuilder sb2, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                appendTo(sb2, it);
                return sb2;
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    private static Iterable<Object> iterable(@CheckForNull final Object obj, @CheckForNull final Object obj2, final Object[] objArr) {
        Preconditions.checkNotNull(objArr);
        return new AbstractList<Object>() {
            @CheckForNull
            public Object get(int i11) {
                if (i11 == 0) {
                    return obj;
                }
                if (i11 != 1) {
                    return objArr[i11 - 2];
                }
                return obj2;
            }

            public int size() {
                return objArr.length + 2;
            }
        };
    }

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a11, Iterable<? extends Object> iterable) throws IOException {
        return appendTo(a11, iterable.iterator());
    }

    public final String join(Iterable<? extends Object> iterable) {
        return join(iterable.iterator());
    }

    public Joiner skipNulls() {
        return new Joiner(this) {
            public <A extends Appendable> A appendTo(A a11, Iterator<? extends Object> it) throws IOException {
                Preconditions.checkNotNull(a11, "appendable");
                Preconditions.checkNotNull(it, "parts");
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (next != null) {
                            a11.append(Joiner.this.toString(next));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                while (it.hasNext()) {
                    Object next2 = it.next();
                    if (next2 != null) {
                        a11.append(Joiner.this.separator);
                        a11.append(Joiner.this.toString(next2));
                    }
                }
                return a11;
            }

            public Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified skipNulls");
            }

            public MapJoiner withKeyValueSeparator(String str) {
                throw new UnsupportedOperationException("can't use .skipNulls() with maps");
            }
        };
    }

    public CharSequence toString(@CheckForNull Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public Joiner useForNull(final String str) {
        Preconditions.checkNotNull(str);
        return new Joiner(this) {
            public Joiner skipNulls() {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            public CharSequence toString(@CheckForNull Object obj) {
                return obj == null ? str : Joiner.this.toString(obj);
            }

            public Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    public MapJoiner withKeyValueSeparator(char c11) {
        return withKeyValueSeparator(String.valueOf(c11));
    }

    private Joiner(String str) {
        this.separator = (String) Preconditions.checkNotNull(str);
    }

    public static Joiner on(char c11) {
        return new Joiner(String.valueOf(c11));
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a11, Iterator<? extends Object> it) throws IOException {
        Preconditions.checkNotNull(a11);
        if (it.hasNext()) {
            a11.append(toString(it.next()));
            while (it.hasNext()) {
                a11.append(this.separator);
                a11.append(toString(it.next()));
            }
        }
        return a11;
    }

    public final String join(Iterator<? extends Object> it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    public MapJoiner withKeyValueSeparator(String str) {
        return new MapJoiner(str);
    }

    public final String join(Object[] objArr) {
        return join((Iterable<? extends Object>) Arrays.asList(objArr));
    }

    private Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    public final String join(@CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return join((Iterable<? extends Object>) iterable(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a11, Object[] objArr) throws IOException {
        return appendTo(a11, (Iterable<? extends Object>) Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a11, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) throws IOException {
        return appendTo(a11, (Iterable<? extends Object>) iterable(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb2, Iterable<? extends Object> iterable) {
        return appendTo(sb2, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb2, Iterator<? extends Object> it) {
        try {
            appendTo(sb2, it);
            return sb2;
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb2, Object[] objArr) {
        return appendTo(sb2, (Iterable<? extends Object>) Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb2, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return appendTo(sb2, (Iterable<? extends Object>) iterable(obj, obj2, objArr));
    }
}
