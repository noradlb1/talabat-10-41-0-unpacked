package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.OpenEndRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Lkotlin/ranges/ComparableOpenEndRange;", "T", "", "Lkotlin/ranges/OpenEndRange;", "start", "endExclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getEndExclusive", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getStart", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
class ComparableOpenEndRange<T extends Comparable<? super T>> implements OpenEndRange<T> {
    @NotNull
    private final T endExclusive;
    @NotNull
    private final T start;

    public ComparableOpenEndRange(@NotNull T t11, @NotNull T t12) {
        Intrinsics.checkNotNullParameter(t11, "start");
        Intrinsics.checkNotNullParameter(t12, "endExclusive");
        this.start = t11;
        this.endExclusive = t12;
    }

    public boolean contains(@NotNull T t11) {
        return OpenEndRange.DefaultImpls.contains(this, t11);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ComparableOpenEndRange) {
            if (!isEmpty() || !((ComparableOpenEndRange) obj).isEmpty()) {
                ComparableOpenEndRange comparableOpenEndRange = (ComparableOpenEndRange) obj;
                if (!Intrinsics.areEqual((Object) getStart(), (Object) comparableOpenEndRange.getStart()) || !Intrinsics.areEqual((Object) getEndExclusive(), (Object) comparableOpenEndRange.getEndExclusive())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    public T getEndExclusive() {
        return this.endExclusive;
    }

    @NotNull
    public T getStart() {
        return this.start;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndExclusive().hashCode();
    }

    public boolean isEmpty() {
        return OpenEndRange.DefaultImpls.isEmpty(this);
    }

    @NotNull
    public String toString() {
        return getStart() + "..<" + getEndExclusive();
    }
}
