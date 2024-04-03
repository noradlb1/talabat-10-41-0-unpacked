package androidx.core.util;

import android.util.Range;
import kotlin.Metadata;
import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001R\u001c\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00018\u00008\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00018\u00008\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"androidx/core/util/RangeKt$toClosedRange$1", "Lkotlin/ranges/ClosedRange;", "endInclusive", "kotlin.jvm.PlatformType", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RangeKt$toClosedRange$1 implements ClosedRange<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Range<T> f11448b;

    public RangeKt$toClosedRange$1(Range<T> range) {
        this.f11448b = range;
    }

    public boolean contains(@NotNull T t11) {
        return ClosedRange.DefaultImpls.contains(this, t11);
    }

    public T getEndInclusive() {
        return this.f11448b.getUpper();
    }

    public T getStart() {
        return this.f11448b.getLower();
    }

    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }
}
