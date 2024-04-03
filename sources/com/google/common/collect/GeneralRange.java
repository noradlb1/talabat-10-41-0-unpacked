package com.google.common.collect;

import com.facebook.internal.security.CertificateUtil;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    @CheckForNull
    private final T lowerEndpoint;
    @CheckForNull
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;
    @CheckForNull
    private final T upperEndpoint;

    private GeneralRange(Comparator<? super T> comparator2, boolean z11, @CheckForNull T t11, BoundType boundType, boolean z12, @CheckForNull T t12, BoundType boundType2) {
        boolean z13;
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        this.hasLowerBound = z11;
        this.hasUpperBound = z12;
        this.lowerEndpoint = t11;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t12;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z11) {
            comparator2.compare(NullnessCasts.uncheckedCastNullableTToT(t11), NullnessCasts.uncheckedCastNullableTToT(t11));
        }
        if (z12) {
            comparator2.compare(NullnessCasts.uncheckedCastNullableTToT(t12), NullnessCasts.uncheckedCastNullableTToT(t12));
        }
        if (z11 && z12) {
            int compare = comparator2.compare(NullnessCasts.uncheckedCastNullableTToT(t11), NullnessCasts.uncheckedCastNullableTToT(t12));
            boolean z14 = true;
            if (compare <= 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            Preconditions.checkArgument(z13, "lowerEndpoint (%s) > upperEndpoint (%s)", (Object) t11, (Object) t12);
            if (compare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                if (boundType == boundType3 && boundType2 == boundType3) {
                    z14 = false;
                }
                Preconditions.checkArgument(z14);
            }
        }
    }

    public static <T> GeneralRange<T> all(Comparator<? super T> comparator2) {
        BoundType boundType = BoundType.OPEN;
        return new GeneralRange(comparator2, false, (Object) null, boundType, false, (Object) null, boundType);
    }

    public static <T> GeneralRange<T> downTo(Comparator<? super T> comparator2, @ParametricNullness T t11, BoundType boundType) {
        return new GeneralRange(comparator2, true, t11, boundType, false, (T) null, BoundType.OPEN);
    }

    public static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        T t11;
        BoundType boundType;
        BoundType boundType2;
        T t12 = null;
        if (range.hasLowerBound()) {
            t11 = range.lowerEndpoint();
        } else {
            t11 = null;
        }
        if (range.hasLowerBound()) {
            boundType = range.lowerBoundType();
        } else {
            boundType = BoundType.OPEN;
        }
        BoundType boundType3 = boundType;
        if (range.hasUpperBound()) {
            t12 = range.upperEndpoint();
        }
        T t13 = t12;
        if (range.hasUpperBound()) {
            boundType2 = range.upperBoundType();
        } else {
            boundType2 = BoundType.OPEN;
        }
        return new GeneralRange(Ordering.natural(), range.hasLowerBound(), t11, boundType3, range.hasUpperBound(), t13, boundType2);
    }

    public static <T> GeneralRange<T> range(Comparator<? super T> comparator2, @ParametricNullness T t11, BoundType boundType, @ParametricNullness T t12, BoundType boundType2) {
        return new GeneralRange(comparator2, true, t11, boundType, true, t12, boundType2);
    }

    public static <T> GeneralRange<T> upTo(Comparator<? super T> comparator2, @ParametricNullness T t11, BoundType boundType) {
        return new GeneralRange(comparator2, false, (Object) null, BoundType.OPEN, true, t11, boundType);
    }

    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    public boolean contains(@ParametricNullness T t11) {
        return !tooLow(t11) && !tooHigh(t11);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange generalRange = (GeneralRange) obj;
        if (!this.comparator.equals(generalRange.comparator) || this.hasLowerBound != generalRange.hasLowerBound || this.hasUpperBound != generalRange.hasUpperBound || !getLowerBoundType().equals(generalRange.getLowerBoundType()) || !getUpperBoundType().equals(generalRange.getUpperBoundType()) || !Objects.equal(getLowerEndpoint(), generalRange.getLowerEndpoint()) || !Objects.equal(getUpperEndpoint(), generalRange.getUpperEndpoint())) {
            return false;
        }
        return true;
    }

    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    @CheckForNull
    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    @CheckForNull
    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return Objects.hashCode(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    public GeneralRange<T> intersect(GeneralRange<T> generalRange) {
        BoundType boundType;
        BoundType boundType2;
        T t11;
        int compare;
        BoundType boundType3;
        int compare2;
        int compare3;
        Preconditions.checkNotNull(generalRange);
        Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        boolean z11 = this.hasLowerBound;
        T lowerEndpoint2 = getLowerEndpoint();
        BoundType lowerBoundType2 = getLowerBoundType();
        if (!hasLowerBound()) {
            z11 = generalRange.hasLowerBound;
            lowerEndpoint2 = generalRange.getLowerEndpoint();
            lowerBoundType2 = generalRange.getLowerBoundType();
        } else if (generalRange.hasLowerBound() && ((compare3 = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint())) < 0 || (compare3 == 0 && generalRange.getLowerBoundType() == BoundType.OPEN))) {
            lowerEndpoint2 = generalRange.getLowerEndpoint();
            lowerBoundType2 = generalRange.getLowerBoundType();
        }
        boolean z12 = z11;
        boolean z13 = this.hasUpperBound;
        T upperEndpoint2 = getUpperEndpoint();
        BoundType upperBoundType2 = getUpperBoundType();
        if (!hasUpperBound()) {
            z13 = generalRange.hasUpperBound;
            upperEndpoint2 = generalRange.getUpperEndpoint();
            upperBoundType2 = generalRange.getUpperBoundType();
        } else if (generalRange.hasUpperBound() && ((compare2 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint())) > 0 || (compare2 == 0 && generalRange.getUpperBoundType() == BoundType.OPEN))) {
            upperEndpoint2 = generalRange.getUpperEndpoint();
            upperBoundType2 = generalRange.getUpperBoundType();
        }
        boolean z14 = z13;
        T t12 = upperEndpoint2;
        if (!z12 || !z14 || ((compare = this.comparator.compare(lowerEndpoint2, t12)) <= 0 && !(compare == 0 && lowerBoundType2 == (boundType3 = BoundType.OPEN) && upperBoundType2 == boundType3))) {
            t11 = lowerEndpoint2;
            boundType2 = lowerBoundType2;
            boundType = upperBoundType2;
        } else {
            boundType2 = BoundType.OPEN;
            boundType = BoundType.CLOSED;
            t11 = t12;
        }
        return new GeneralRange(this.comparator, z12, t11, boundType2, z14, t12, boundType);
    }

    public boolean isEmpty() {
        if ((!hasUpperBound() || !tooLow(NullnessCasts.uncheckedCastNullableTToT(getUpperEndpoint()))) && (!hasLowerBound() || !tooHigh(NullnessCasts.uncheckedCastNullableTToT(getLowerEndpoint())))) {
            return false;
        }
        return true;
    }

    public GeneralRange<T> reverse() {
        GeneralRange<T> generalRange = this.reverse;
        if (generalRange != null) {
            return generalRange;
        }
        GeneralRange generalRange2 = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        generalRange2.reverse = this;
        this.reverse = generalRange2;
        return generalRange2;
    }

    public String toString() {
        char c11;
        T t11;
        T t12;
        char c12;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.comparator);
        sb2.append(CertificateUtil.DELIMITER);
        BoundType boundType = this.lowerBoundType;
        BoundType boundType2 = BoundType.CLOSED;
        if (boundType == boundType2) {
            c11 = '[';
        } else {
            c11 = '(';
        }
        sb2.append(c11);
        if (this.hasLowerBound) {
            t11 = this.lowerEndpoint;
        } else {
            t11 = "-∞";
        }
        sb2.append(t11);
        sb2.append(AbstractJsonLexerKt.COMMA);
        if (this.hasUpperBound) {
            t12 = this.upperEndpoint;
        } else {
            t12 = "∞";
        }
        sb2.append(t12);
        if (this.upperBoundType == boundType2) {
            c12 = AbstractJsonLexerKt.END_LIST;
        } else {
            c12 = ')';
        }
        sb2.append(c12);
        return sb2.toString();
    }

    public boolean tooHigh(@ParametricNullness T t11) {
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (!hasUpperBound()) {
            return false;
        }
        int compare = this.comparator.compare(t11, NullnessCasts.uncheckedCastNullableTToT(getUpperEndpoint()));
        if (compare > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (compare == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUpperBoundType() == BoundType.OPEN) {
            z13 = true;
        }
        return (z12 & z13) | z11;
    }

    public boolean tooLow(@ParametricNullness T t11) {
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (!hasLowerBound()) {
            return false;
        }
        int compare = this.comparator.compare(t11, NullnessCasts.uncheckedCastNullableTToT(getLowerEndpoint()));
        if (compare < 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (compare == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getLowerBoundType() == BoundType.OPEN) {
            z13 = true;
        }
        return (z12 & z13) | z11;
    }
}
