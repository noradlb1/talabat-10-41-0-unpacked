package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Comparator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class Range<T> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Comparator<T> comparator;
    private transient int hashCode;
    private final T maximum;
    private final T minimum;
    private transient String toString;

    public enum ComparableComparator implements Comparator {
        INSTANCE;

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    private Range(T t11, T t12, Comparator<T> comparator2) {
        if (t11 == null || t12 == null) {
            throw new IllegalArgumentException("Elements in a range must not be null: element1=" + t11 + ", element2=" + t12);
        }
        if (comparator2 == null) {
            this.comparator = ComparableComparator.INSTANCE;
        } else {
            this.comparator = comparator2;
        }
        if (this.comparator.compare(t11, t12) < 1) {
            this.minimum = t11;
            this.maximum = t12;
            return;
        }
        this.minimum = t12;
        this.maximum = t11;
    }

    public static <T extends Comparable<T>> Range<T> between(T t11, T t12) {
        return between(t11, t12, (Comparator) null);
    }

    public static <T extends Comparable<T>> Range<T> is(T t11) {
        return between(t11, t11, (Comparator) null);
    }

    public boolean contains(T t11) {
        return t11 != null && this.comparator.compare(t11, this.minimum) > -1 && this.comparator.compare(t11, this.maximum) < 1;
    }

    public boolean containsRange(Range<T> range) {
        return range != null && contains(range.minimum) && contains(range.maximum);
    }

    public int elementCompareTo(T t11) {
        if (t11 == null) {
            throw new NullPointerException("Element is null");
        } else if (isAfter(t11)) {
            return -1;
        } else {
            if (isBefore(t11)) {
                return 1;
            }
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Range.class) {
            return false;
        }
        Range range = (Range) obj;
        if (!this.minimum.equals(range.minimum) || !this.maximum.equals(range.maximum)) {
            return false;
        }
        return true;
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public T getMaximum() {
        return this.maximum;
    }

    public T getMinimum() {
        return this.minimum;
    }

    public int hashCode() {
        int i11 = this.hashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode2 = this.maximum.hashCode() + ((((629 + Range.class.hashCode()) * 37) + this.minimum.hashCode()) * 37);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public Range<T> intersectionWith(Range<T> range) {
        T t11;
        T t12;
        if (!isOverlappedBy(range)) {
            throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", new Object[]{range}));
        } else if (equals(range)) {
            return this;
        } else {
            if (getComparator().compare(this.minimum, range.minimum) < 0) {
                t11 = range.minimum;
            } else {
                t11 = this.minimum;
            }
            if (getComparator().compare(this.maximum, range.maximum) < 0) {
                t12 = this.maximum;
            } else {
                t12 = range.maximum;
            }
            return between(t11, t12, getComparator());
        }
    }

    public boolean isAfter(T t11) {
        return t11 != null && this.comparator.compare(t11, this.minimum) < 0;
    }

    public boolean isAfterRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isAfter(range.maximum);
    }

    public boolean isBefore(T t11) {
        return t11 != null && this.comparator.compare(t11, this.maximum) > 0;
    }

    public boolean isBeforeRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isBefore(range.minimum);
    }

    public boolean isEndedBy(T t11) {
        return t11 != null && this.comparator.compare(t11, this.maximum) == 0;
    }

    public boolean isNaturalOrdering() {
        return this.comparator == ComparableComparator.INSTANCE;
    }

    public boolean isOverlappedBy(Range<T> range) {
        if (range == null) {
            return false;
        }
        return range.contains(this.minimum) || range.contains(this.maximum) || contains(range.minimum);
    }

    public boolean isStartedBy(T t11) {
        return t11 != null && this.comparator.compare(t11, this.minimum) == 0;
    }

    public String toString() {
        String str = this.toString;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append('[');
        sb2.append(this.minimum);
        sb2.append("..");
        sb2.append(this.maximum);
        sb2.append(AbstractJsonLexerKt.END_LIST);
        String sb3 = sb2.toString();
        this.toString = sb3;
        return sb3;
    }

    public static <T> Range<T> between(T t11, T t12, Comparator<T> comparator2) {
        return new Range<>(t11, t12, comparator2);
    }

    public static <T> Range<T> is(T t11, Comparator<T> comparator2) {
        return between(t11, t11, comparator2);
    }

    public String toString(String str) {
        return String.format(str, new Object[]{this.minimum, this.maximum, this.comparator});
    }
}
